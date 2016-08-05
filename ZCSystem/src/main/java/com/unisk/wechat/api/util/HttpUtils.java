package com.unisk.wechat.api.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Description:对请求参数进行编码、解码工具类
 * @author shijingbang
 * @Date 2015年11月18日
 */
public class HttpUtils {

	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	private static String DEFAULT_CHARSET = "UTF-8";

	public static String encode(String param) {
		return encode(param, DEFAULT_CHARSET);
	}

	public static String encode(String param, String charset) {
		if (param == null) {
			return null;
		}
		try {
			return URLEncoder.encode(param, charset);
		} catch (UnsupportedEncodingException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("URLEncoder编码发生错误，错误原因{}", e.getMessage());
			}
		}
		return null;
	}

	public static String decode(String param, String charset) {
		if (param == null) {
			return null;
		}
		try {
			return URLDecoder.decode(param, charset);
		} catch (UnsupportedEncodingException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("URLDecoder解码发生错误，错误原因{}", e.getMessage());
			}
		}
		return null;
	}

	public static String decode(String param) {
		return decode(param, DEFAULT_CHARSET);
	}

	public static void main(String[] args) {
		System.out.println(decode("shijingbang"));
	}
}
