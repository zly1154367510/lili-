package com.zly.pojo;

import javax.persistence.*;

@Table(name = "tb_item_param_key")
public class TbItemParamKey {
    @Id
    private Integer id;

    @Column(name = "param_name")
    private String paramName;

    @Column(name = "group_id")
    private Integer groupId;

    //item属性分组

    private TbItemParamGroup tbItemParamGroup;

    private TbItemParamValue tbItemParamValue;

    public TbItemParamValue getTbItemParamValue() {
        return tbItemParamValue;
    }

    public void setTbItemParamValue(TbItemParamValue tbItemParamValue) {
        this.tbItemParamValue = tbItemParamValue;
    }

    public TbItemParamGroup getTbItemParamGroup() {
        return tbItemParamGroup;
    }

    public void setTbItemParamGroup(TbItemParamGroup tbItemParamGroup) {
        this.tbItemParamGroup = tbItemParamGroup;
    }

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
     * @return param_name
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * @param paramName
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * @return group_id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}