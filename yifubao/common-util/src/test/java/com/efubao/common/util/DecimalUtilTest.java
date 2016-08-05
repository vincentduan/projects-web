/**
 * DecimalUtilTest.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.common.util;

import org.junit.Test;
import org.springframework.util.Assert;

import com.efubao.common.util.DecimalUtil;

/**
 *
 */
public class DecimalUtilTest {
	
	/**  */
	private final static Number TEST_NUMBER_1 = -0.0001;
	/**  */
	private final static Number TEST_NUMBER_2 = 12315.2211;
	/**  */
	private final static Number TEST_NUMBER_3 = 12315.2251;

	/**
	 * Test method for {@link com.efubao.common.util.DecimalUtil#format(java.lang.Number, int, boolean)}.
	 */
	@Test
	public void testFormatNumberIntBoolean() {
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_1, 2, false).equals("0.00"));
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_1, 2, true).equals("0.00"));
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_2, 2, false).equals("12,315.22"));
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_2, 2, true).equals("+12,315.22"));
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_3, 2, false).equals("12,315.23"));
	}

	/**
	 * Test method for {@link com.efubao.common.util.DecimalUtil#format(java.lang.Number, int)}.
	 */
	@Test
	public void testFormatNumberInt() {
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_3, 2).equals("12,315.23"));
	}

	/**
	 * Test method for {@link com.efubao.common.util.DecimalUtil#format(java.lang.Number, java.lang.String, boolean)}.
	 */
	@Test
	public void testFormatNumberStringBoolean() {
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_3, "##0.00", false).equals("12315.23"));
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_3, "###,##0.00", true).equals("+12,315.23"));
	}

	/**
	 * Test method for {@link com.efubao.common.util.DecimalUtil#format(java.lang.Number, java.lang.String)}.
	 */
	@Test
	public void testFormatNumberString() {
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_3, "##0.00").equals("12315.23"));
		Assert.isTrue(DecimalUtil.format(TEST_NUMBER_3, "###,##0.00").equals("12,315.23"));
	}

}
