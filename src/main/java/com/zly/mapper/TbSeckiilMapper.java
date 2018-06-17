package com.zly.mapper;

import com.zly.pojo.TbSeckiil;
import com.zly.pojo.TbSeckiilItem;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface TbSeckiilMapper extends MyMapper<TbSeckiil> {


//    @Select("select id,start_time as startTime,end_start as endStart,create_time as createTime from tb_seckiil where id=#{id}")
//    @Results({
//            @Result(
//                    column = "id",
//                    property = "tbSeckiilItems",
//                    many = @Many(select = "com.zly.mapper.TbSeckiilItemMapper.selectById")
//
//            )
//    })
//    TbSeckiil selectById(int id);

    @Select("select id,start_time as startTime,end_time as endTime,create_time as createTime from tb_seckiil where datediff(#{date},start_time)=0 order by abs(datediff(#{date},start_time))asc")
    @Results({
            @Result(
                    column = "id",
                    property = "tbSeckiilItems",
                    many = @Many(select = "com.zly.mapper.TbSeckiilItemMapper.selectById")

            )
    })
    List<TbSeckiil> selectA(Date date);

    @Select("select id,start_time as startTime,end_time as endTime,create_time as createTime from tb_seckiil where id = #{id}")
    TbSeckiil selectById(Long id);

}