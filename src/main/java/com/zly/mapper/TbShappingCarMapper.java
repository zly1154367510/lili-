package com.zly.mapper;

import com.zly.pojo.TbShappingCar;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface TbShappingCarMapper extends MyMapper<TbShappingCar> {

    @Insert("insert into tb_shapping_car(id,u_id,i_id,num,created) values (null,#{uId},#{iId},#{num},#{created})")
    int insertByuIdiId(@Param("uId")Long uId, @Param("iId")Long iId, @Param("num")int num, @Param("created")Date date);

    @Select("select id,num from tb_shapping_car where u_id=#{uId} and i_id = #{iId}")
    List<TbShappingCar> selectByuIdiId(@Param("uId")Long uId,@Param("iId")Long iId);

    @Update("update tb_shapping_car set num=#{num} where id=#{id}")
    int updateNumById(@Param("num")int num,@Param("id")Long id);

    @Select("select id,u_id as uId,i_id as iId,num,created from tb_shapping_car use index(u_id) where u_id=#{uId} and o_id=0;")
    @Results({
            @Result(
                    property = "tbItem",
                    column = "iId",
                    one = @One(select = "com.zly.mapper.TbItemMapper.findItemById")
            )
    })
    List<TbShappingCar> selectByUId(Long uId);

    @Select("select id,u_id as uId,i_id as iId,num,created from tb_shapping_car use index(u_id) where o_id=#{oId};")
    @Results({
            @Result(
                    property = "tbItem",
                    column = "iId",
                    one = @One(select = "com.zly.mapper.TbItemMapper.findItemById")
            )
    })
    List<TbShappingCar> selectByOId(Long oId);
    @Update("update tb_shapping_car set o_id=#{oId} where id=#{id}")
    int updSCarById(@Param("oId")Long oId,@Param("id")Long id);

}