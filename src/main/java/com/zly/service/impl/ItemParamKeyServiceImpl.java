package com.zly.service.impl;

import com.zly.mapper.TbItemParamKeyMapper;
import com.zly.pojo.TbItemParamKey;
import com.zly.service.ItemParamKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/9.
 */
@Service
public class ItemParamKeyServiceImpl implements ItemParamKeyService {

    @Autowired
    private TbItemParamKeyMapper itemParamKeyMapper;

    @Override
    public List<TbItemParamKey> findItemParamKeyByGroupId(Long id) {
        return itemParamKeyMapper.findItemParamKeyByGroupId(id);
    }
}
