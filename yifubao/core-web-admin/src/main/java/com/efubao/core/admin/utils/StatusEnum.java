package com.efubao.core.admin.utils;

public enum StatusEnum {
	NORMAL("正常", "1"), STOP("停用", "2"), DELETE("删除", "0");
	// 成员变量
	private String name;
	private String index;

	// 构造方法
	private StatusEnum(String name, String index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(String index) {
		for (StatusEnum c : StatusEnum.values()) {
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
