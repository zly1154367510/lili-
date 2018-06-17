package com.zly.service.impl;

import com.zly.mapper.TbSeckiilItemMapper;
import com.zly.mapper.TbSeckiilMapper;
import com.zly.pojo.TbSeckiil;
import com.zly.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<TbSeckiil> getAllSameDaySeckill() {
        Date date = new Date();
        return tbSeckiilMapper.selectA(date);
    }

    @Override
    public TbSeckiil getSameDaySeckill() {
        return null;
    }
}
