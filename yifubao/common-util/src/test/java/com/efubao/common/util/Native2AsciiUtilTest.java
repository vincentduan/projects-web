/** 
  * Native2AsciiUtilTest.java
  * 
  * Copyright (c) 2013 by efubao.com
  */
package com.efubao.common.util;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.util.Assert;

import com.efubao.common.util.Native2AsciiUtil;

/**
 */
public class Native2AsciiUtilTest {
	/**
	 * native string
	 * <p>{username:"张三", sex:"man", age:10, phone:"13800138000"}</p>
	 */
	private String nativeString = "{username:\"张三\", sex:\"man\", age:10, phone:\"13800138000\"}";
	/** 
	 * ASCII string
	 * <p>{username:"\u5f20\u4e09", sex:"man", age:10, phone:"13800138000"}</p>
	 */
	private String asciiString = "{username:\"\\u5f20\\u4e09\", sex:\"man\", age:10, phone:\"13800138000\"}";

	/**
	 * Test method for {@link com.efubao.common.util.Native2AsciiUtil#native2Ascii(java.lang.String)}.
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void testNative2Ascii() throws UnsupportedEncodingException {
		Assert.isTrue(Native2AsciiUtil.native2Ascii(nativeString).equals(asciiString));
	}

	/**
	 * Test method for {@link com.efubao.common.util.Native2AsciiUtil#ascii2Native(java.lang.String)}.
	 */
	@Test
	public void testAscii2Native() {
		Assert.isTrue(Native2AsciiUtil.ascii2Native(asciiString).equals(nativeString));
	}

}
