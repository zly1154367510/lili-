package com.zly.service.impl;

import com.zly.mapper.TbConfigMapper;
import com.zly.pojo.TbConfig;
import com.zly.service.ConfigService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zly11 on 2018/5/14.
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private TbConfigMapper tbConfigMaper;

    @Override
    public TbConfig getConfigByCid(Long cid) {
        return tbConfigMaper.selectConfigByCid(cid);
    }
}
