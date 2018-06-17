package com.zly.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_seckiil")
public class TbSeckiil {
    @Id
    private Long id;

    /**
     * 秒杀开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 秒杀结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 创建时间
     */
    /**
     * mybatis 查询 datetime 等时间格式数据默认返回 long
     * 加入此备注转化为正常 Date
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    private List<TbSeckiilItem> tbSeckiilItems;

    public List<TbSeckiilItem> getTbSeckiilItems() {
        return tbSeckiilItems;
    }

    public void setTbSeckiilItems(List<TbSeckiilItem> tbSeckiilItems) {
        this.tbSeckiilItems = tbSeckiilItems;
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
     * 获取秒杀开始时间
     *
     * @return start_time - 秒杀开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置秒杀开始时间
     *
     * @param startTime 秒杀开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取秒杀结束时间
     *
     * @return end_time - 秒杀结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置秒杀结束时间
     *
     * @param endTime 秒杀结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}