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
public class MeasureGoods implements Serializable {
    /** 量体商品ID */
    private Long id;

    /** 量体订单号 */
    private String measureOrderNo;

    /** 商品名称 */
    private String goodsName;

    /** 商品数量 */
    private Integer goodsNum;

    /** 商品SKU */
    private Long goodsSkuId;

    /**  */
    private Timestamp createTime;

    /**  */
    private Timestamp updateTime;

    /**  */
    private Boolean isDel;

    /** 首图图片路径 */
    private String firstImagePath;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeasureOrderNo() {
        return measureOrderNo;
    }

    public void setMeasureOrderNo(String measureOrderNo) {
        this.measureOrderNo = measureOrderNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
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

    public String getFirstImagePath() {
        return firstImagePath;
    }

    public void setFirstImagePath(String firstImagePath) {
        this.firstImagePath = firstImagePath;
    }
}