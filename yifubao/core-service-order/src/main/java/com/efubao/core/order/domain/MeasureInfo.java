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
public class MeasureInfo implements Serializable {
    /**  */
    private Long id;

    /** 被量体人姓名 */
    private String name;

    /** 性别:1-男;2-女 */
    private Integer gender;

    /** 被量体人电话 */
    private String phone;

    /** 部门 */
    private String department;

    /** 量体订单号 */
    private String measureOrderNo;

    /** 录入时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /**  */
    private Boolean isDel;

    /** 备注 */
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMeasureOrderNo() {
        return measureOrderNo;
    }

    public void setMeasureOrderNo(String measureOrderNo) {
        this.measureOrderNo = measureOrderNo;
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