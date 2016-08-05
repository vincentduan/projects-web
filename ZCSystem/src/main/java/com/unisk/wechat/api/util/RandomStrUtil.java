package com.unisk.wechat.api.util;

import java.util.Random;

/**
 * 用于随机生成EncodingAESKey
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年11月18日
 */
public class RandomStrUtil {

	private static final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	public static String randomStr(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int j = random.nextInt(chars.length);
			sb.append(chars[j]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(randomStr(43));
		// System.out.println(WechatHelper.getNonce());

		System.out.println(randomStr(16));
	}
}
