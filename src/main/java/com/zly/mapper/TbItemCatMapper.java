package com.zly.mapper;

import com.zly.pojo.TbItemCat;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemCatMapper extends MyMapper<TbItemCat> {

    @Select("select * from tb_item_cat where parent_id=0")
    public List<TbItemCat> getParentItemCat();

}