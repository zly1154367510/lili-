package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.mapper.TbContentMapper;
import com.zly.pojo.TbContent;
import com.zly.service.ConfigService;
import com.zly.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/12.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Autowired
    private ConfigService configService;

    @Override
    public List<TbContent> getBigContent(Long cid) {
        PageHelper.startPage(1,Integer.parseInt(configService.getConfigByCid(cid).getConfigValue()));
        return tbContentMapper.selectContentByCategoryId(cid);
    }
}
