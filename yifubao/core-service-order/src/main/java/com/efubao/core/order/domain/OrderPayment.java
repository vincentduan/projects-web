package com.efubao.core.order.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-12
 *
 */
public class OrderPayment implements Serializable {
    /** 支付流水号 */
    private String orderPaymentNo;

    /** 订单名称 */
    private String orderNo;

    /** 第三方支付账单 */
    private Long thridPaymentNum;

    /** 支付类型1:订金2:尾款 */
    private Integer payType;

    /** 支付状态1:支付完成2:支付失败3:待支付;4-已退款 */
    private String payStatus;

    /** 支付金额 */
    private BigDecimal payMoney;

    /** 支付通路:1-易极付 */
    private Integer payWay;

    /** 支付时间 */
    private Timestamp payFinishTime;

    /** 退款时间 */
    private Timestamp refundFinishTime;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    /**  */
    private String remarks;

    private static final long serialVersionUID = 1L;

    public String getOrderPaymentNo() {
        return orderPaymentNo;
    }

    public void setOrderPaymentNo(String orderPaymentNo) {
        this.orderPaymentNo = orderPaymentNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getThridPaymentNum() {
        return thridPaymentNum;
    }

    public void setThridPaymentNum(Long thridPaymentNum) {
        this.thridPaymentNum = thridPaymentNum;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Timestamp getPayFinishTime() {
        return payFinishTime;
    }

    public void setPayFinishTime(Timestamp payFinishTime) {
        this.payFinishTime = payFinishTime;
    }

    public Timestamp getRefundFinishTime() {
        return refundFinishTime;
    }

    public void setRefundFinishTime(Timestamp refundFinishTime) {
        this.refundFinishTime = refundFinishTime;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}