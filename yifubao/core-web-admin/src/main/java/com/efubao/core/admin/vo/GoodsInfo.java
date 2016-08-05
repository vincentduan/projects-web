package com.efubao.core.admin.vo;

import java.io.Serializable;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.Goods;

public class GoodsInfo extends Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Goods goods;

    public Category category;
    
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "GoodsInfo [goods=" + goods + ", category=" + category + ", getGoods()=" + getGoods()
				+ ", getCategory()=" + getCategory() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getNum()=" + getNum() + ", getSummary()=" + getSummary() + ", getCategoryId()=" + getCategoryId()
				+ ", getFirstImagePath()=" + getFirstImagePath() + ", getSort()=" + getSort() + ", getStatus()="
				+ getStatus() + ", getMinPrice()=" + getMinPrice() + ", getMaxPrice()=" + getMaxPrice()
				+ ", getOnlineTime()=" + getOnlineTime() + ", getOfflineTime()=" + getOfflineTime()
				+ ", getCreateTime()=" + getCreateTime() + ", getUpdateTime()=" + getUpdateTime() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}
