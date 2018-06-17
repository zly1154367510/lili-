package com.zly.service;

import com.zly.pojo.TbSeckiil;

import java.util.List;

/**
 * Created by zly11 on 2018/6/16.
 */
public interface SeckillService {


    /**
     * 获取当天的秒杀活动
     * @return
     */
    List<TbSeckiil> getAllSameDaySeckill();

    /**
     *
     * 获取当天离的当前时间最近的秒杀活动
     * 只要一个
     * 用于首页展出
     * @return
     */
    TbSeckiil getSameDaySeckill();

}
