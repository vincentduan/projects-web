package com.efubao.core.order.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-10
 *
 */
public class MeasureInfoProperty implements Serializable {
    /**  */
    private Long id;

    /** 量体信息ID */
    private Long measureInfoId;

    /** 量体属性 */
    private String measureProperty;

    /** 量体属性值 */
    private String measurePropertyValue;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMeasureInfoId() {
        return measureInfoId;
    }

    public void setMeasureInfoId(Long measureInfoId) {
        this.measureInfoId = measureInfoId;
    }

    public String getMeasureProperty() {
        return measureProperty;
    }

    public void setMeasureProperty(String measureProperty) {
        this.measureProperty = measureProperty;
    }

    public String getMeasurePropertyValue() {
        return measurePropertyValue;
    }

    public void setMeasurePropertyValue(String measurePropertyValue) {
        this.measurePropertyValue = measurePropertyValue;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}