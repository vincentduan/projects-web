/** 
 * Charset.java
 * 
 * Copyright (c) 2013 by efubao.com.
 */
package com.efubao.common.util;

/**
 * Character encoding
 * http://zh.wikipedia.org/zh/%E5%AD%97%E7%AC%A6%E7%BC%96%E7%A0%81
 * 
 */
public enum Charset {
	/**
	 * ASCII（American Standard Code for Information Interchange，美国信息交换标准代码）,
	 * 是基于拉丁字母的一套电脑编码系统。
	 * 详见http://zh.wikipedia.org/zh-cn/ASCII，http://en.wikipedia.org/wiki/ASCII
	 */
	ASCII("ASCII"), 
	/** 
	 * http://zh.wikipedia.org/zh-cn/Unicode 
	 */
	UNICODE("Unicode"), 
	/**
	 * UTF-8（8-bit Unicode Transformation
	 * Format）是一种针对Unicode的可变长度字符编码（定长码），也是一种前缀码。
	 * http://zh.wikipedia.org/zh-cn/UTF-8
	 */
	UTF_8("UTF-8"), 
	/**
	 * ISO-8859-1又称Latin-1或“西欧语言”，是国际标准化组织内ISO/IEC
	 * 8859的第一个8位字符集。 * http://zh.wikipedia.org/zh-cn/ISO/IEC_8859-1
	 */
	ISO_8859_1("ISO-8859-1"), 
	/**
	 * GBK即汉字内码扩展规范，K为汉语拼音 Kuo
	 * Zhan（扩展）中“扩”字的声母。英文全称Chinese Internal Code Specification。
	 * http://zh.wikipedia.org/zh-cn/GBK
	 */
	GBK("GBK"), 
	/**
	 * GB2312是中国国家标准简体中文字符集，全称《信息交换用汉字编码字符集·基本集》
	 * http://zh.wikipedia.org/zh-cn/GB_2312
	 */
	GB2312("GB2312"), 
	/**
	 * Big5，又稱為大五碼或五大碼，是使用繁体中文（正體中文）社群中最常用的電腦漢字字符集標準，共收錄13,060個漢字
	 * http://zh.wikipedia.org/zh/big5
	 */
	BIG5("Big5");
	
	/**
	 * 构造函数
	 * @param value 字符集的标准名称 
	 */
	Charset(final String value) {
		this.value = value;
	}

	/** * 字符集的标准名称 */
	private final String value;

	/**
	 * 返回字符集的标准名称
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

}
