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
public class OrderCustomGoods implements Serializable {
    /** 订单客户定制商品表ID */
    private Long id;

    /** 商品数量 */
    private Integer goodsNum;

    /** 商品名称 */
    private String goodsName;

    /** 商品SKU_ID */
    private Long goodsSkuId;

    /** 订单客户定制需求表ID */
    private Long orderCustomDemandId;

    /** 商品单价 */
    private BigDecimal goodsPrice;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    /** 属性IDs */
    private String attributeIds;

    /** 属性名称s */
    private String attributeNames;

    /** 属性值IDs */
    private String attributeValueIds;

    /** 属性值名称s */
    private String attributeValueNames;

    /** 首图图片路径 */
    private String firstImagePath;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Long getOrderCustomDemandId() {
        return orderCustomDemandId;
    }

    public void setOrderCustomDemandId(Long orderCustomDemandId) {
        this.orderCustomDemandId = orderCustomDemandId;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
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

    public String getAttributeIds() {
        return attributeIds;
    }

    public void setAttributeIds(String attributeIds) {
        this.attributeIds = attributeIds;
    }

    public String getAttributeNames() {
        return attributeNames;
    }

    public void setAttributeNames(String attributeNames) {
        this.attributeNames = attributeNames;
    }

    public String getAttributeValueIds() {
        return attributeValueIds;
    }

    public void setAttributeValueIds(String attributeValueIds) {
        this.attributeValueIds = attributeValueIds;
    }

    public String getAttributeValueNames() {
        return attributeValueNames;
    }

    public void setAttributeValueNames(String attributeValueNames) {
        this.attributeValueNames = attributeValueNames;
    }

    public String getFirstImagePath() {
        return firstImagePath;
    }

    public void setFirstImagePath(String firstImagePath) {
        this.firstImagePath = firstImagePath;
    }
}