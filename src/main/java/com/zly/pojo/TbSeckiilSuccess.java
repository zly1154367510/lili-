package com.zly.pojo;

import javax.persistence.*;

@Table(name = "tb_seckiil_success")
public class TbSeckiilSuccess {
    @Id
    private Integer id;

    /**
     * 秒杀成功者的用户名
     */
    private String username;

    /**
     * 秒杀成功对应向
     */
    @Column(name = "si_id")
    private Long siId;

    /**
     * 对应订单表
     */
    @Column(name = "o_id")
    private Long oId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取秒杀成功者的用户名
     *
     * @return username - 秒杀成功者的用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置秒杀成功者的用户名
     *
     * @param username 秒杀成功者的用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取秒杀成功对应向
     *
     * @return si_id - 秒杀成功对应向
     */
    public Long getSiId() {
        return siId;
    }

    /**
     * 设置秒杀成功对应向
     *
     * @param siId 秒杀成功对应向
     */
    public void setSiId(Long siId) {
        this.siId = siId;
    }

    /**
     * 获取对应订单表
     *
     * @return o_id - 对应订单表
     */
    public Long getoId() {
        return oId;
    }

    /**
     * 设置对应订单表
     *
     * @param oId 对应订单表
     */
    public void setoId(Long oId) {
        this.oId = oId;
    }
}