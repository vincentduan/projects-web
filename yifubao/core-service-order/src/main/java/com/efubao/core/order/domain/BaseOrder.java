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
public class BaseOrder implements Serializable {
    /** 订单号 */
    private String orderNo;

    /** 订单状态:100-发布需求;110-管家受理;120-选择服务商;125-中标录合同;130-付订金;140-上门量体;150-生产制作;160-付尾款;170-待发货;180-待签收;190-已签收;200-交易完成;210-取消订单 */
    private Integer status;

    /** 订单类型:10-量体订单;20-商品订单 */
    private Integer type;

    /** 服务商ID */
    private Long spId;

    /** 用户ID */
    private Long customerId;

    /** 订单合同表ID */
    private Long orderContractId;

    /** 订单总金额 */
    private BigDecimal totalMoney;

    /** 质保金 */
    private BigDecimal qualityDeposit;

    /** 履约保证金 */
    private BigDecimal creditDeposit;

    /** 订金 */
    private BigDecimal frontMoney;

    /** 尾款 */
    private BigDecimal balancePayment;

    /** 备注信息 */
    private String remarks;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    /** 删除标记0-正常订单状态，1-删除订单状态 */
    private Boolean isDel;

    private static final long serialVersionUID = 1L;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getOrderContractId() {
        return orderContractId;
    }

    public void setOrderContractId(Long orderContractId) {
        this.orderContractId = orderContractId;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
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

    public BigDecimal getFrontMoney() {
        return frontMoney;
    }

    public void setFrontMoney(BigDecimal frontMoney) {
        this.frontMoney = frontMoney;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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