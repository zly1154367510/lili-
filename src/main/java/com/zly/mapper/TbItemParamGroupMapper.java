package com.zly.mapper;

import com.zly.pojo.TbItemParamGroup;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemParamGroupMapper extends MyMapper<TbItemParamGroup> {

    @Select("select id,group_name as groupName,item_cat_id as itemCatId from tb_item_param_group where item_cat_id = #{id}")
    List<TbItemParamGroup> findItemParamGroup(Long id);
}