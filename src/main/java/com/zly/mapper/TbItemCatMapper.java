package com.zly.mapper;

import com.zly.pojo.TbItemCat;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemCatMapper extends MyMapper<TbItemCat> {

    @Select("select * from tb_item_cat where parent_id=0")
    public List<TbItemCat> getParentItemCat();

    @Select("select id,parent_id as parentId,name,is_parent as isParent from tb_item_cat where parent_id=0")
    List<TbItemCat> getItemCatParent();

    @Select("select id,parent_id as parentId,name,is_parent as isParent from tb_item_cat where parent_id = #{id}")
    List<TbItemCat> isLeatNode(long id);

    @Select("select name from tb_item_cat where parent_id=0")
    List<String> selectItemCatName();

}