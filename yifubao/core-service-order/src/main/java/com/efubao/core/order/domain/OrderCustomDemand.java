package com.efubao.core.order.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-10
 *
 */
public class OrderCustomDemand implements Serializable {
    /** 订单客户定制需求表ID */
    private Long id;

    /** 订单号 */
    private String orderNo;

    /** 品类ID */
    private Long categoryId;

    /** 品类名称 */
    private String categoryName;

    /** 定制数量 */
    private Integer customNum;

    /** 定制预算 */
    private BigDecimal customBudget;

    /** 定制周期 */
    private Integer customCycle;

    /** 定制属性 */
    private String categoryProperty;

    /** 意向服务商ID */
    private Long spId;

    /** 定制方式1:量体定制 */
    private Integer customType;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCustomNum() {
        return customNum;
    }

    public void setCustomNum(Integer customNum) {
        this.customNum = customNum;
    }

    public BigDecimal getCustomBudget() {
        return customBudget;
    }

    public void setCustomBudget(BigDecimal customBudget) {
        this.customBudget = customBudget;
    }

    public Integer getCustomCycle() {
        return customCycle;
    }

    public void setCustomCycle(Integer customCycle) {
        this.customCycle = customCycle;
    }

    public String getCategoryProperty() {
        return categoryProperty;
    }

    public void setCategoryProperty(String categoryProperty) {
        this.categoryProperty = categoryProperty;
    }

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public Integer getCustomType() {
        return customType;
    }

    public void setCustomType(Integer customType) {
        this.customType = customType;
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