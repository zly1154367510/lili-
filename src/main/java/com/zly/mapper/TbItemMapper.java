package com.zly.mapper;

import com.zly.pojo.TbItem;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TbItemMapper extends MyMapper<TbItem> {

    /**
     *
     * 根据类别查询产品
     */
    @Select("select id,title,sell_point as sellPoint,cid,status,created,updated,price,image from tb_item where cid=#{cid}")
    public List<TbItem> findItemByCid(Long cid);


    @Select("select id,title,sell_point as sellPoint,cid,status,created,updated,price,image from tb_item where id=#{id}")
    @Results({
            @Result(
                    property = "tbItemParamValues",
                    column = "id",
                    many = @Many(select = "com.zly.mapper.TbItemParamValueMapper.findValueById")
            )
    })
    List<TbItem> findItemDetalis(Long id);

    @Select("select id,title,sell_point as sellPoint,cid,status,created,updated,price from tb_item where id = #{id}")
    public TbItem findItemById(Long id);

    //@Select("select id,title,sell_point as sellPoint,cid,status,created,updated,price,image from tb_item where title like %'#{title}'%")
    @SelectProvider(type = itemSqlBuild.class,method = "findItemByTitle")
    public List<TbItem> findItemByTitle(String title);

    @Select("select id,title,sell_point as sellPoint,cid,status,created,updated,price,image from tb_item where price>#{price1} and price<#{price2} order by rand() limit #{num}")
    List<TbItem> findItemByPrice(@Param("price1") Long price1,@Param("price2") Long price2,@Param("num") int num);



    class itemSqlBuild{


        public String findItemByTitle(String title){
            String sql = "select id,title,sell_point as sellPoint,cid,status,created,updated,price,image from tb_item where title like '%";
            sql += title;
            sql += "%'";
            return sql;
        }
    }

}