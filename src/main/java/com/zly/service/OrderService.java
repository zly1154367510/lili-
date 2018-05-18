package com.zly.service;

import com.zly.pojo.TbOrder;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/5/17.
 */
public interface OrderService {

    int addOrder(String payment, Date created, String username, String address, String name, List<Long> shappingCarIds);

    List<TbOrder> findAllByUid(String username);

}
