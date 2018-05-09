package com.zly.service;

import com.zly.pojo.TbItemParamGroup;

import java.util.List;

/**
 * Created by zly11 on 2018/5/9.
 */
public interface ItemParamGroupService {

    List<TbItemParamGroup> findItemParamGroupByItemCatId(Long id);
}
