package com.zly.pojo;

import javax.persistence.*;
import java.util.List;

@Table(name = "tb_seckiil_item")
public class TbSeckiilItem {
    @Id
    private Long id;

    /**
     * 秒杀活动id
     */
    @Column(name = "s_id")
    private Long sId;

    /**
     * 商品id
     */
    @Column(name = "i_id")
    private Long iId;

    private TbItem tbItem;

    public TbItem getTbItem() {
        return tbItem;
    }

    public void setTbItem(TbItem tbItem) {
        this.tbItem = tbItem;
    }

    /**
     * 商品新价格
     */
    @Column(name = "new_price")
    private String newPrice;

    /**
     * 秒杀数量
     */
    private Long num;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取秒杀活动id
     *
     * @return s_id - 秒杀活动id
     */
    public Long getsId() {
        return sId;
    }

    /**
     * 设置秒杀活动id
     *
     * @param sId 秒杀活动id
     */
    public void setsId(Long sId) {
        this.sId = sId;
    }

    /**
     * 获取商品id
     *
     * @return i_id - 商品id
     */
    public Long getiId() {
        return iId;
    }

    /**
     * 设置商品id
     *
     * @param iId 商品id
     */
    public void setiId(Long iId) {
        this.iId = iId;
    }

    /**
     * 获取商品新价格
     *
     * @return new_price - 商品新价格
     */
    public String getNewPrice() {
        return newPrice;
    }

    /**
     * 设置商品新价格
     *
     * @param newPrice 商品新价格
     */
    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    /**
     * 获取秒杀数量
     *
     * @return num - 秒杀数量
     */
    public Long getNum() {
        return num;
    }

    /**
     * 设置秒杀数量
     *
     * @param num 秒杀数量
     */
    public void setNum(Long num) {
        this.num = num;
    }
}