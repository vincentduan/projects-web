package com.efubao.core.sp.utils;

public enum InvoiceTypeEnum {
	普通发票("普通发票", "1"), 增值税发票("增值税发票", "2");
	// 成员变量
	private String name;
	private String index;

	// 构造方法
	private InvoiceTypeEnum(String name, String index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(String index) {
		for (InvoiceTypeEnum c : InvoiceTypeEnum.values()) {
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
