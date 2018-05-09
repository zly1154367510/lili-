package com.zly.pojo;

import javax.persistence.*;

@Table(name = "tb_item_param_group")
public class TbItemParamGroup {
    @Id
    private Integer id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "item_cat_id")
    private Long itemCatId;

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
     * @return group_name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return item_cat_id
     */
    public Long getItemCatId() {
        return itemCatId;
    }

    /**
     * @param itemCatId
     */
    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }
}