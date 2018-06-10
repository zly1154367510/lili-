package com.zly.service;

import com.zly.pojo.TbUser;

import java.util.List;

/**
 * Created by zly11 on 2018/5/13.
 */
public interface UserService {

    Integer checkParam(String param,Integer type);

    Integer register(TbUser tbUser);

    String login(TbUser tbUser);

    boolean isLogin(String username,String token);

    int updIsStatuByUsername(String username);
}
