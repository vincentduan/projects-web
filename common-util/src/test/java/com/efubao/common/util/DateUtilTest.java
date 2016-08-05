/** 
  * DateUtilTest.java
  * Copyright (c) 2013 by efubao.com.
  */
package com.efubao.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.efubao.common.util.DateUtil;

/**
 */
public class DateUtilTest {
	
	/**  */
	private final String strDate1 = "2011-02-28";
	/**  */
	private final String strDate1Format = "yyyy-MM-dd";
	/**  */
	private final int intDate1 = 20110228;
	/**  */
	private final int yearOfDate1 = 2011;
	/**  */
	private final int dayOfDate1 = 28;
	/**  */
	private final int intDate2 = 20110331;
	/** days between testDate1 and testDate2 */
	private final int daysBetweenDate1AndDate2 = 31;

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#getInterval(java.util.Date, java.util.Date)}.
	 */
	@Test
	public void testGetIntervalDateDate() {
		Assert.assertEquals(DateUtil.getInterval(DateUtil.parse(intDate1), DateUtil.parse(intDate2)), daysBetweenDate1AndDate2);
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#getInterval(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public void testGetIntervalIntegerInteger() {
		Assert.assertEquals(DateUtil.getInterval(intDate1,intDate2), daysBetweenDate1AndDate2);
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#parse(java.lang.Integer)}.
	 */
	@Test
	public void testParseInteger() {
		Calendar testDate1 = Calendar.getInstance();
		testDate1.setTime(DateUtil.parse(intDate1));
		Assert.assertEquals(testDate1.get(Calendar.DAY_OF_MONTH), dayOfDate1);
		Assert.assertEquals(testDate1.get(Calendar.MONTH), Calendar.FEBRUARY);
		Assert.assertEquals(testDate1.get(Calendar.YEAR), yearOfDate1);
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#parse(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testParseStringString() {
		Assert.assertEquals(DateUtil.parse(strDate1, strDate1Format), DateUtil.parse(intDate1));
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#format(java.util.Date, java.lang.String)}.
	 */
	@Test
	public void testFormatDateString() {
		Assert.assertEquals(DateUtil.format(DateUtil.parse(intDate1), strDate1Format), strDate1);
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#format(java.util.Date, java.text.SimpleDateFormat)}.
	 */
	@Test
	public void testFormatDateSimpleDateFormat() {
		Assert.assertEquals(DateUtil.format(DateUtil.parse(intDate1), new SimpleDateFormat(strDate1Format)), strDate1);
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#formatDate(java.util.Date)}.
	 */
	@Test
	public void testFormatDate() {
		Assert.assertEquals(DateUtil.formatDate(DateUtil.parse(intDate1)), strDate1);
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#formatTime(java.util.Date)}.
	 */
	@Test
	public void testFormatTime() {
		Assert.assertEquals(DateUtil.formatTime(DateUtil.parse(intDate1)), "00:00:00");
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#formatAll(java.util.Date)}.
	 */
	@Test
	public void testFormatAll() {
		Assert.assertEquals(DateUtil.formatAll(DateUtil.parse(intDate1)), strDate1 + " 00:00:00");
	}

	/**
	 * Test method for {@link com.efubao.common.util.DateUtil#format(int, java.lang.String)}.
	 */
	@Test
	public void testFormatIntString() {
		Assert.assertEquals(DateUtil.format(intDate1, strDate1Format), strDate1);
	}

}
