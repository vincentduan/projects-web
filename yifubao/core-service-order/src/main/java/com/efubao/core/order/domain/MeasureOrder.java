package com.efubao.core.order.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-12
 *
 */
public class MeasureOrder implements Serializable {
    /**  */
    private String measureOrderNo;

    /** 量体师Id */
    private Long measureMasterId;

    /** 订单号 */
    private String orderNo;

    /** 量体订单来源:1-efubao */
    private Integer source;

    /** 状态1:待量体2:量体中3:量体完成 */
    private Integer status;

    /** 备注 */
    private String remarks;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    /** 量体数据 */
    private Integer measureNum;

    private static final long serialVersionUID = 1L;

    public String getMeasureOrderNo() {
        return measureOrderNo;
    }

    public void setMeasureOrderNo(String measureOrderNo) {
        this.measureOrderNo = measureOrderNo;
    }

    public Long getMeasureMasterId() {
        return measureMasterId;
    }

    public void setMeasureMasterId(Long measureMasterId) {
        this.measureMasterId = measureMasterId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getMeasureNum() {
        return measureNum;
    }

    public void setMeasureNum(Integer measureNum) {
        this.measureNum = measureNum;
    }
}