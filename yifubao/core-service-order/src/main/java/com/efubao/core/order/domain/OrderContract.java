package com.efubao.core.order.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-12
 *
 */
public class OrderContract implements Serializable {
    /** 订单合同ID */
    private Long id;

    /** 供应商ID */
    private Long spId;

    /** 生产天数 */
    private Integer makeDays;

    /** 定制周期 */
    private Integer customCycle;

    /** 定制金额 */
    private BigDecimal customMoney;

    /** 定制品类 */
    private String customCategory;

    /** 定制属性 */
    private String customProperty;

    /** 合同有效开始日期 */
    private Date validStartDate;

    /** 合同有效结束日期 */
    private Date validEndDate;

    /** 订单总费用 */
    private BigDecimal totalMoney;

    /** 订金 */
    private BigDecimal frontMoney;

    /** 质保金 */
    private BigDecimal qualityDeposit;

    /** 履约保证金 */
    private BigDecimal creditDeposit;

    /** 平台佣金 */
    private BigDecimal commission;

    /** 尾款 */
    private BigDecimal balancePayment;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    /** 客户是否同意合同 */
    private Boolean isCustomerAgree;

    /** 量体数据 */
    private Integer measureNum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public Integer getMakeDays() {
        return makeDays;
    }

    public void setMakeDays(Integer makeDays) {
        this.makeDays = makeDays;
    }

    public Integer getCustomCycle() {
        return customCycle;
    }

    public void setCustomCycle(Integer customCycle) {
        this.customCycle = customCycle;
    }

    public BigDecimal getCustomMoney() {
        return customMoney;
    }

    public void setCustomMoney(BigDecimal customMoney) {
        this.customMoney = customMoney;
    }

    public String getCustomCategory() {
        return customCategory;
    }

    public void setCustomCategory(String customCategory) {
        this.customCategory = customCategory;
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public void setCustomProperty(String customProperty) {
        this.customProperty = customProperty;
    }

    public Date getValidStartDate() {
        return validStartDate;
    }

    public void setValidStartDate(Date validStartDate) {
        this.validStartDate = validStartDate;
    }

    public Date getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(Date validEndDate) {
        this.validEndDate = validEndDate;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getFrontMoney() {
        return frontMoney;
    }

    public void setFrontMoney(BigDecimal frontMoney) {
        this.frontMoney = frontMoney;
    }

    public BigDecimal getQualityDeposit() {
        return qualityDeposit;
    }

    public void setQualityDeposit(BigDecimal qualityDeposit) {
        this.qualityDeposit = qualityDeposit;
    }

    public BigDecimal getCreditDeposit() {
        return creditDeposit;
    }

    public void setCreditDeposit(BigDecimal creditDeposit) {
        this.creditDeposit = creditDeposit;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
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

    public Boolean getIsCustomerAgree() {
        return isCustomerAgree;
    }

    public void setIsCustomerAgree(Boolean isCustomerAgree) {
        this.isCustomerAgree = isCustomerAgree;
    }

    public Integer getMeasureNum() {
        return measureNum;
    }

    public void setMeasureNum(Integer measureNum) {
        this.measureNum = measureNum;
    }
}