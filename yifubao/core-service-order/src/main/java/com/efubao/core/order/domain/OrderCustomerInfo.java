package com.efubao.core.order.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-16
 *
 */
public class OrderCustomerInfo implements Serializable {
    /** 订单客户信息表ID */
    private Long id;

    /** 订单号 */
    private String orderNo;

    /** 企业名称 */
    private String companyName;

    /** 定制部门 */
    private String customDepartment;

    /** 收货地址ID */
    private Long receiveAddressId;

    /** 预约姓名 */
    private String bespeakName;

    /** 预约电话 */
    private String bespeakPhone;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomDepartment() {
        return customDepartment;
    }

    public void setCustomDepartment(String customDepartment) {
        this.customDepartment = customDepartment;
    }

    public Long getReceiveAddressId() {
        return receiveAddressId;
    }

    public void setReceiveAddressId(Long receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    public String getBespeakName() {
        return bespeakName;
    }

    public void setBespeakName(String bespeakName) {
        this.bespeakName = bespeakName;
    }

    public String getBespeakPhone() {
        return bespeakPhone;
    }

    public void setBespeakPhone(String bespeakPhone) {
        this.bespeakPhone = bespeakPhone;
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