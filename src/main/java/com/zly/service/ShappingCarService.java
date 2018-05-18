package com.zly.service;

import com.zly.pojo.TbShappingCar;

import java.util.List;

/**
 * Created by zly11 on 2018/5/16.
 */
public interface ShappingCarService {

    int addShappingCar(String username,Long iId,int num);

    List<TbShappingCar> selectShappingCarByUId(String username);

    int changShappingCarNum(Long id,int num);
}
