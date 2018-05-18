package com.zly.pojo;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_order")
public class TbOrder {
    /**
     * 订单id
     */
    @Id
    private Long id;

    /**
     * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    private String payment;

    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 用户id
     */
    @Column(name = "u_id")
    private Long uId;

    private String address;

    private String name;

    private List<TbShappingCar> shappingCars;

    public List<TbShappingCar> getShappingCars() {
        return shappingCars;
    }

    public void setShappingCars(List<TbShappingCar> shappingCars) {
        this.shappingCars = shappingCars;
    }

    /**
     * 获取订单id
     *
     * @return id - 订单id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置订单id
     *
     * @param id 订单id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     *
     * @return payment - 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public String getPayment() {
        return payment;
    }

    /**
     * 设置实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     *
     * @param payment 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * 获取订单创建时间
     *
     * @return create_time - 订单创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取用户id
     *
     * @return u_id - 用户id
     */
    public Long getuId() {
        return uId;
    }

    /**
     * 设置用户id
     *
     * @param uId 用户id
     */
    public void setuId(Long uId) {
        this.uId = uId;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}