package com.efubao.common.util;

/**
 * 获取短信验证码util
 *
 */ 
public class ConfirmCodeUtil {
	
	private ConfirmCodeUtil(){}
	
	/**
	 * 获取短息验证码
	 * @return
	 */
	public static String getConfirmCode(){
		
	    java.util.Random r = new java.util.Random();
		int x = 0;
		while (true) {
			x = r.nextInt(999999);
			if (x > 99999) {
				break;
			}
		}
		return String.valueOf(x);
	}
}
