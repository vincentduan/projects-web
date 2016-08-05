package com.efubao.core.admin.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.efubao.core.common.base.BasePo;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-09
 *
 */
public class GoodsSKU extends BasePo implements Serializable {
    /**  */
    private Long id;

    /** 商品ID */
    private Long goodsId;

    /** 属性IDs */
    private String attributeIds;

    /** 属性名称s */
    private String attributeNames;

    /** 属性值IDs */
    private String attributeValueIds;

    /** 属性值名称s */
    private String attributeValueNames;

    /** 图片路径 */
    private String imagePath;

    /** 价格 */
    private BigDecimal price;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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