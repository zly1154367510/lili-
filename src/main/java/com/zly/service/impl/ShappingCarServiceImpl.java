package com.zly.service.impl;

import com.zly.mapper.TbShappingCarMapper;
import com.zly.mapper.TbUserMapper;
import com.zly.pojo.TbShappingCar;
import com.zly.service.ShappingCarService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/5/16.
 */
@Service
public class ShappingCarServiceImpl implements ShappingCarService{

    @Autowired
    private TbShappingCarMapper tbShappingCarMapper;

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public int addShappingCar(String username, Long iId,int num) {
        Long uId = tbUserMapper.selectUserByUsername(username).get(0).getId();
        List<TbShappingCar> tbShappingCars = tbShappingCarMapper.selectByuIdiId(uId,iId);
        if (tbShappingCars!=null&&tbShappingCars.size()!=0){
            int endNum = tbShappingCars.get(0).getNum()+num;
            return tbShappingCarMapper.updateNumById(endNum,tbShappingCars.get(0).getId());
        }
        return tbShappingCarMapper.insertByuIdiId(uId,iId,num,new Date());
    }

    @Override
    public List<TbShappingCar> selectShappingCarByUId(String username) {
        Long uId = tbUserMapper.selectUserByUsername(username).get(0).getId();
        return tbShappingCarMapper.selectByUId(uId);
    }

    @Override
    public int changShappingCarNum(Long id, int num) {
        return tbShappingCarMapper.updateNumById(num,id);
    }
}
