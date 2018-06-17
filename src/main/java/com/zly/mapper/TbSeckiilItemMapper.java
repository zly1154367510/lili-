package com.zly.mapper;

import com.zly.pojo.TbSeckiilItem;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.*;

public interface TbSeckiilItemMapper extends MyMapper<TbSeckiilItem> {

    @Select("select id,s_id as sId,i_id as iId,new_price as newPrice,num from tb_seckiil_item where s_id=#{sId}")
    @Results({
            @Result(
                    column = "iId",
                    property = "tbItem",
                    one = @One(select = "com.zly.mapper.TbItemMapper.findItemById")
            )
    })
    TbSeckiilItem selectById(int sId);

    //秒杀活动备货量减一
    @Update("update tb_seckiil_item set num=num-1 where id=#{id}")
    int updateNumById(int id);

    @Select("select id,s_id as sId,i_id as iId,new_price as newPrice,num from tb_seckiil_item where id = #{id}")
    TbSeckiilItem selectByIds(int id);

}