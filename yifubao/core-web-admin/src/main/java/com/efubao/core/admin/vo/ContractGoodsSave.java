package com.efubao.core.admin.vo;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.Goods;
import com.efubao.core.admin.domain.GoodsSKU;

public class ContractGoodsSave {
	
	public Goods goods;
	
	public GoodsSKU goodsSku;
	
	public Category category;
	

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public GoodsSKU getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(GoodsSKU goodsSku) {
		this.goodsSku = goodsSku;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
