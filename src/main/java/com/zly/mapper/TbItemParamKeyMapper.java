package com.zly.mapper;

import com.zly.pojo.TbItemParamKey;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemParamKeyMapper extends MyMapper<TbItemParamKey> {

    @Select("select id,param_name as paramName,group_id as groupId from tb_item_param_key where id=#{param_id}")
    public TbItemParamKey findItemParamKey(Long param_id);

    @Select("select id,param_name as paramName,group_id as groupId from tb_item_param_key where group_id=#{groupId}")
    public List<TbItemParamKey> findItemParamKeyByGroupId(Long groupId);
}