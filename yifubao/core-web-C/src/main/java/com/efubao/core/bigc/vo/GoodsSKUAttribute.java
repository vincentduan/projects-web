package com.efubao.core.bigc.vo;

import java.io.Serializable;
import java.util.List;

import com.efubao.core.admin.domain.PropertyValue;

public class GoodsSKUAttribute implements Serializable {

	/**
	 * 商品SKU属性
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
    
	private String name;
    
	private List<GoodsSKUAttributeValue> attrValues;

    
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

	public List<GoodsSKUAttributeValue> getAttrValues() {
		return attrValues;
	}

	public void setAttrValues(List<GoodsSKUAttributeValue> attrValues) {
		this.attrValues = attrValues;
	}

}
