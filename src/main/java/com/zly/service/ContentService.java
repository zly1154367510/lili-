package com.zly.service;

import com.zly.pojo.TbContent;

import java.util.List;

/**
 * Created by zly11 on 2018/5/12.
 */
public interface ContentService {

    List<TbContent> getBigContent(Long cid);
}
