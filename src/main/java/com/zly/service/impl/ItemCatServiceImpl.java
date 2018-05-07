package com.zly.service.impl;

import com.zly.mapper.TbItemCatMapper;
import com.zly.pojo.TbItemCat;
import com.zly.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/7.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> getParenItemCat() {
        return tbItemCatMapper.getParentItemCat();
    }
}
