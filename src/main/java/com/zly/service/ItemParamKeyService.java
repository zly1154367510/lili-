package com.zly.service;

import com.zly.pojo.TbItemParamKey;

import java.util.List;

/**
 * Created by zly11 on 2018/5/9.
 */
public interface ItemParamKeyService {

    List<TbItemParamKey> findItemParamKeyByGroupId(Long id);

}
