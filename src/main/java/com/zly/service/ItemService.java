package com.zly.service;

import com.zly.pojo.TbItem;

import java.util.List;

/**
 * Created by zly11 on 2018/5/8.
 */
public interface ItemService {

    /**
     *
     * 根据产品类别来查询商品
     */

    List<TbItem> findItemByCid(Long cid,int pageNum);
    List<TbItem> findItemDetalisByCid(Long id);
    List<TbItem> findItemSimilar(Long id);
    List<TbItem> findItemByKeyword(String title);
}
