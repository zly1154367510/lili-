package com.zly.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_shapping_car")
public class TbShappingCar {
    @Id
    private Long id;

    @Column(name = "u_id")
    private Long uId;

    @Column(name = "i_id")
    private Long iId;

    private Integer num;

    private Date created;

    private TbItem tbItem;

    public TbItem getTbItem() {
        return tbItem;
    }

    public void setTbItem(TbItem tbItem) {
        this.tbItem = tbItem;
    }

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
     * @return u_id
     */
    public Long getuId() {
        return uId;
    }

    /**
     * @param uId
     */
    public void setuId(Long uId) {
        this.uId = uId;
    }

    /**
     * @return i_id
     */
    public Long getiId() {
        return iId;
    }

    /**
     * @param iId
     */
    public void setiId(Long iId) {
        this.iId = iId;
    }

    /**
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }
}