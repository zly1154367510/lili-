package com.zly.service.impl;

import com.zly.mapper.TbItemParamGroupMapper;
import com.zly.pojo.TbItemParamGroup;
import com.zly.service.ItemParamGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/9.
 */
@Service
public class ItemParamGroupServiceImpl implements ItemParamGroupService {

    @Autowired
    private TbItemParamGroupMapper tbItemParamGroupMapper;

    @Override
    public List<TbItemParamGroup> findItemParamGroupByItemCatId(Long id) {
        return tbItemParamGroupMapper.findItemParamGroup(id);
    }
}
