package com.zly.pojo;

import javax.persistence.*;
import java.util.List;

@Table(name = "tb_item_param_value")
public class TbItemParamValue {
    @Id
    @Column(name = "item_id")
    private Long itemId;

    @Id
    @Column(name = "param_id")
    private Integer paramId;

    @Column(name = "param_value")
    private String paramValue;

    //item属性key
    private TbItemParamKey tbItemParamKey;

    public TbItemParamKey getTbItemParamKey() {
        return tbItemParamKey;
    }

    public void setTbItemParamKey(TbItemParamKey tbItemParamKey) {
        System.out.println("调用key set方法");
        this.tbItemParamKey = tbItemParamKey;
    }

    /**
     * @return item_id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return param_id
     */
    public Integer getParamId() {
        return paramId;
    }

    /**
     * @param paramId
     */
    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    /**
     * @return param_value
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * @param paramValue
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}