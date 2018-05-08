package com.zly.mapper;

import com.zly.pojo.TbItem;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemMapper extends MyMapper<TbItem> {

    /**
     *
     * 根据类别查询产品
     */
    @Select("select id,title,sell_point as sellPoint,cid,status,created,updated,price,image from tb_item where cid=#{cid}")
    public List<TbItem> findItemByCid(Long cid);

}