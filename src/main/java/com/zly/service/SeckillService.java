package com.zly.service;

import com.zly.exception.RepeatKillException;
import com.zly.exception.SeckillCloseException;
import com.zly.exception.SeckillException;
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

    /**
     * 秒杀提交
     * seckillItemId => seckill 实体
     * seckill startTime 和 endTime 对比当前系统时间，不符合秒杀活动时间区间则秒杀失败
     * seckillItemId => seckillItem 实体
     * 对比秒杀活动备货量，如果备货没了,则秒杀失败
     * username => user实体
     * 获取 userId
     * seckillItemId username =>tb_seckill_success 查看是否重复
     * 如果重复则则抛出异常
     *
     * 上面都通过
     * tb_seckill_item <=> seckillItemId  num=num-1
     * price,new Date(),userId ,address,name => tb_order 表
     * username,seckillItemId,orderId(新插入键) => tb_seckill_success 表
     *
     * @param seckillItemId
     * @param username
     * @param name
     * @param address
     * @param price
     * @return
     */
    int SubmitOrder(int seckillItemId,String username,String name,String address,String price)
    throws SeckillException,SeckillCloseException,RepeatKillException;

}
