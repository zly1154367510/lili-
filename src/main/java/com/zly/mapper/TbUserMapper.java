package com.zly.mapper;

import com.zly.pojo.TbUser;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface TbUserMapper extends MyMapper<TbUser> {

    @Select("select * from tb_user where username=#{username}")
    List<TbUser> selectUserByUsername(String username);

    @Select("select * from tb_user where email=#{email}")
    List<TbUser> selectUserByEmail(String email);

    @Select("select * from tb_user where phone=#{phone}")
    List<TbUser> selectUserByPhone(String phone);

    @Select("select id,username,password,phone,email,created,is_ban as isBan ,is_statu as isStatu from tb_user where username=#{username} and password=#{password}")
    List<TbUser> selectUserByUsernamePassword(@Param("username") String username,@Param("password") String password );


    @Insert("insert into tb_user (id,username,password,phone,email,created) values (null,#{username},#{password},#{phone},#{email},#{created})")
    int register(@Param("username")String username, @Param("password") String password, @Param("phone") String phone, @Param("email") String email, @Param("created") Date cerated);

    @Update("update tb_user set is_statu = 1 where username=#{username}")
    int updIsStatuByUsername(String username);
}