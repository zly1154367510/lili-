package com.zly.pojo;

import javax.persistence.*;

@Table(name = "tb_config")
public class TbConfig {
    @Id
    private Integer id;

    @Column(name = "config_name")
    private String configName;

    @Column(name = "config_value")
    private String configValue;

    @Column(name = "content_id")
    private Integer contentId;

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
     * @return config_name
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * @param configName
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * @return config_value
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * @param configValue
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    /**
     * @return content_id
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * @param contentId
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }
}