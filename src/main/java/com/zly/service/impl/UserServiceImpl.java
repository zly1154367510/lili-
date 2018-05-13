package com.zly.service.impl;

import com.zly.mapper.TbUserMapper;
import com.zly.pojo.TbUser;
import com.zly.service.TokenService;
import com.zly.service.UserService;
import com.zly.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/5/13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TokenService tokenService;

    @Override
    public Integer checkParam(String param, Integer type) {
        Integer flag = 4;
        List<TbUser> flagList;
        switch (type){
            case 1:
                if (tbUserMapper.selectUserByUsername(param).size()!=0){
                    flag = 1;
                }
                break;
            case 2:
                if (tbUserMapper.selectUserByPhone(param).size()!=0){
                    flag = 2;
                }
                break;
            case 3:
                if (tbUserMapper.selectUserByEmail(param).size()!=0){
                    flag = 3;
                }
                break;

        }
        return flag;
    }

    @Override
    public Integer register(TbUser tbUser) {

        tbUser.setCreated(new Date());
        String password = tbUser.getPassword();
        tbUser.setPassword(MD5Util.getMD5(password));
        return tbUserMapper.register(tbUser.getUsername(),tbUser.getPassword(),tbUser.getPhone(),tbUser.getEmail(),tbUser.getCreated());
    }

    @Override
    public String login(TbUser tbUser) {
        String password = tbUser.getPassword();
        tbUser.setPassword(MD5Util.getMD5(password));
        List<TbUser> list = tbUserMapper.selectUserByUsernamePassword(tbUser.getUsername(), tbUser.getPassword());
        if (list.size()!=0){
            return tokenService.createToken(tbUser.getUsername());
        }
        return null;
    }
}
