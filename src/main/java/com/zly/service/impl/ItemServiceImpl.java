package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.mapper.TbItemMapper;
import com.zly.pojo.TbItem;
import com.zly.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/8.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public List<TbItem> findItemByCid(Long cid,int pageNum) {
        PageHelper.startPage(pageNum, 5);
        return itemMapper.findItemByCid(cid);
    }

    @Override
    public List<TbItem> findItemDetalisByCid(Long id) {
        return itemMapper.findItemDetalis(id);
    }
}
