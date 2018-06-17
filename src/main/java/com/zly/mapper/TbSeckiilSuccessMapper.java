package com.zly.mapper;

import com.zly.pojo.TbSeckiilSuccess;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbSeckiilSuccessMapper extends MyMapper<TbSeckiilSuccess> {

    @Insert("insert into tb_seckiil_success(id,username,si_id,o_id) values(null,#{username},#{si_id},#{o_id})")
    int insertO(
            @Param("username")String username,
            @Param("si_id")int SIId,
            @Param("o_id")int oId
    );

    @Select("select * from tb_seckiil_success where username=#{username} and si_id=#{SIId}")
    TbSeckiilSuccess selectByUsernameSIId(
            @Param("username")String username,
            @Param("SIId")int SIId
    );

}