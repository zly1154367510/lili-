package com.zly.service.impl;

import com.zly.mapper.TbOrderMapper;
import com.zly.mapper.TbShappingCarMapper;
import com.zly.mapper.TbUserMapper;
import com.zly.pojo.GetInsertId;
import com.zly.pojo.TbOrder;
import com.zly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * Created by zly11 on 2018/5/17.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TbOrderMapper tbOrderMapper;

    @Autowired
    private TbShappingCarMapper tbShappingCarMapper;

    @Autowired
    private TbUserMapper tbUserMapper;

    @Transactional
    @Override
    public int addOrder(String payment, Date created, String username, String address, String name, List<Long> shappingCarId) {
        Long uId = tbUserMapper.selectUserByUsername(username).get(0).getId();
        GetInsertId getInsertId = new GetInsertId();
        int i = tbOrderMapper.insertAll(payment,created,uId,address,name,getInsertId);
        for (Long id : shappingCarId) {
            tbShappingCarMapper.updSCarById(getInsertId.getId(), id);
        }
        return i;
    }

    @Override
    public List<TbOrder> findAllByUid(String username) {
        Long uId = tbUserMapper.selectUserByUsername(username).get(0).getId();
        return tbOrderMapper.selectByUId(uId);
    }
}
