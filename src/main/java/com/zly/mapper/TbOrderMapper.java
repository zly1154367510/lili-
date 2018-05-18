package com.zly.mapper;

import com.zly.pojo.GetInsertId;
import com.zly.pojo.TbOrder;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface TbOrderMapper extends MyMapper<TbOrder> {
    @Options(useGeneratedKeys = true, keyProperty = "getInsertId.id")
    @Insert("insert into tb_order (id,payment,create_time,u_id,address,name) values(null,#{payment},#{created},#{uId},#{address},#{name})")
    int insertAll(@Param("payment")String payment, @Param("created")Date created, @Param("uId")Long uId, @Param("address")String address, @Param("name")String name, @Param("getInsertId")GetInsertId getInsertId);

    @Select("select id,payment,create_time as created,u_id as uId,address,name from tb_order use index(u_id)  where u_id=#{uId}")
    @Results({
            @Result(
                    property = "shappingCars",
                    column = "id",
                    many = @Many(select = "com.zly.mapper.TbShappingCarMapper.selectByOId")
            )
    })
    List<TbOrder> selectByUId(Long uId);
}