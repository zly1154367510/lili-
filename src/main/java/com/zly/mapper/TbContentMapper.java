package com.zly.mapper;

import com.zly.pojo.TbContent;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbContentMapper extends MyMapper<TbContent> {

    @Select("select title,url,pic from tb_content where category_id=#{cId}")
    List<TbContent> selectContentByCategoryId(Long cId);


}