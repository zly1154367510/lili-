package com.zly.mapper;

import com.zly.pojo.TbItemParamValue;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemParamValueMapper extends MyMapper<TbItemParamValue> {

    @Select("select item_id as itemId,param_id as paramId,param_value as paramValue from tb_item_param_value where item_id = #{itemId}")
    @Results({
            @Result(
                    property = "tbItemParamKey",
                    column = "param_id",
                    one = @One(select = "com.zly.mapper.TbItemParamKeyMapper.findItemParamKey")
            )
    })
    List<TbItemParamValue> findValueById(Long itemId);
}