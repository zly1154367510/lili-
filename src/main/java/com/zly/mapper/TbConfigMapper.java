package com.zly.mapper;

import com.zly.pojo.TbConfig;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface TbConfigMapper extends MyMapper<TbConfig> {

    @Select("select config_value as configValue from tb_config where content_id=#{cId}")
    TbConfig selectConfigByCid(Long cId);
}