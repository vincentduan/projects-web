package com.efubao.core.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 格式验证工具类
 * 
 * 
 */
public class FormatValidUtils {

	/**
	 * 手机号验证
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean validMobile(String phone) {
		String regExp = "^[1]([3|4|5|7|8][0-9]{1})[0-9]{8}$";

		Pattern p = Pattern.compile(regExp);

		Matcher m = p.matcher(phone);

		return m.find();// boolean

	}
}
