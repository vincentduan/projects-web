package com.efubao.core.bigc.vo;

import java.io.Serializable;
import java.util.List;

import com.efubao.core.admin.domain.PropertyValue;

public class GoodsSKUAttributeValue implements Serializable {

	/**
	 * 商品SKU属性值
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;

	private Long id;

	private String imgPath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
