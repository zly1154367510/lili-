package com.zly.service.impl;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.zly.exception.RepeatKillException;
import com.zly.exception.SeckillCloseException;
import com.zly.exception.SeckillException;
import com.zly.mapper.*;
import com.zly.pojo.*;
import com.zly.service.SeckillService;
import com.zly.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/6/16.
 */
@Service
public class SeckillServiceImpl implements SeckillService{

    @Autowired
    private TbSeckiilMapper tbSeckiilMapper;

    @Autowired
    private TbSeckiilItemMapper tbSeckiilItemMapper;

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbSeckiilSuccessMapper tbSeckiilSuccessMapper;

    @Autowired
    private TbOrderMapper tbOrderMapper;

    @Override
    public List<TbSeckiil> getAllSameDaySeckill() {
        Date date = new Date();
        return tbSeckiilMapper.selectA(date);
    }

    @Override
    public TbSeckiil getSameDaySeckill() {
        return null;
    }

    @Transactional
    @Override
    public int SubmitOrder(int seckillItemId, String username, String name, String address, String price) {
        TbSeckiilItem tbSeckiilItem = tbSeckiilItemMapper.selectById(seckillItemId);
        TbUser tbUser = tbUserMapper.selectUserByUsername(username).get(0);
        TbSeckiil tbSeckiil = tbSeckiilMapper.selectById(tbSeckiilItem.getsId());
        Date date = DateUtils.FormatDate(DateUtils.FORMAT,new Date().toString());
        if (date.after(tbSeckiil.getStartTime()) && date.before(tbSeckiil.getEndTime())){
            if (tbSeckiilItemMapper.selectByIds(seckillItemId).getNum()>=0){
                if(tbSeckiilSuccessMapper.selectByUsernameSIId(username,seckillItemId)!=null){
                    GetInsertId getInsertId = new GetInsertId();
                    tbOrderMapper.insertAll(price,DateUtils.FormatDate(DateUtils.FORMAT,new Date().toString()),tbUser.getId(),address,name,getInsertId);
                    return tbSeckiilSuccessMapper.insertO(username,seckillItemId,Integer.parseInt(getInsertId.getId().toString()));
                }else{
                    throw  new RepeatKillException("用户重复秒杀");
                }
            }else{
                throw new SeckillException("秒杀商品备货量不足");
            }
        }else{
            throw new SeckillCloseException("秒杀已结束");
        }

    }
}
