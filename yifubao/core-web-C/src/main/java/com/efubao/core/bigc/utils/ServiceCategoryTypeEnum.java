package com.efubao.core.bigc.utils;

public enum ServiceCategoryTypeEnum {
	高端定制("高端定制", "1"), 量体定制("量体定制", "2"), 标准定制("标准定制", "3");
	// 成员变量
	private String name;
	private String index;

	// 构造方法
	private ServiceCategoryTypeEnum(String name, String index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(String index) {
		for (ServiceCategoryTypeEnum c : ServiceCategoryTypeEnum.values()) {
			if (index.equals(c.getIndex())) {
				return c.name;
			}
		}
		return null;
	}

	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
