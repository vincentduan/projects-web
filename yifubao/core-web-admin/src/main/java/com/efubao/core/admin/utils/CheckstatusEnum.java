package com.efubao.core.admin.utils;

public enum CheckstatusEnum {
	WAITING("待审核", "1"), SUCCESS("审核通过", "2"), FAIL("审核不通过", "");
	// 成员变量
	private String name;
	private String index;

	// 构造方法
	private CheckstatusEnum(String name, String index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(String index) {
		for (CheckstatusEnum c : CheckstatusEnum.values()) {
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
