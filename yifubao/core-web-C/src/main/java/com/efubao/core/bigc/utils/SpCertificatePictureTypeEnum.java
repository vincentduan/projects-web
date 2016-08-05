package com.efubao.core.bigc.utils;

public enum SpCertificatePictureTypeEnum {
	营业执照("营业执照", "1"), 税务登记证("税务登记证", "2"), 组织机构代码证("组织机构代码证", "3"), 银行开户许可证("银行开户许可证", "4");
	// 成员变量
	private String name;
	private String index;

	// 构造方法
	private SpCertificatePictureTypeEnum(String name, String index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(String index) {
		for (SpCertificatePictureTypeEnum c : SpCertificatePictureTypeEnum.values()) {
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
