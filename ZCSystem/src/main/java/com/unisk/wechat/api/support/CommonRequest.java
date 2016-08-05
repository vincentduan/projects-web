package com.unisk.wechat.api.support;

import java.io.File;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.unisk.wechat.api.util.HttpClient;

/**
 * 
 * @Description:主动发送消息 基类
 * @author shijingbang
 * @Date 2015年11月25日
 */
public class CommonRequest {
	private static final Logger logger = LoggerFactory.getLogger(CommonRequest.class);

	public static String sendPostRequest(String url, String json) {
		Assert.notNull(url, "请求的url不能为空!");
		if (logger.isDebugEnabled()) {
			logger.debug("请求URL：{},请求参数:{}", url, json);
		}
		// 发起请求，得到响应
		String result = HttpClient.post4Json(url, json);

		if (logger.isDebugEnabled()) {
			logger.debug("返回响应：{}", result);
		}
		return result;
	}

	public static String sendPostUpload(String paramName, String url, String fileName, File file) {
		Assert.notNull(url, "请求的url不能为空!");
		if (logger.isDebugEnabled()) {
			logger.debug("上传文件:{},请求URL：{}", fileName, url);
		}
		// 发起请求，得到响应
		String result = HttpClient.upload(paramName, url, fileName, file);

		if (logger.isDebugEnabled()) {
			logger.debug("返回响应：{}", result);
		}
		return result;
	}

	public static String sendGetRequest(String url) {
		Assert.notNull(url, "请求的url不能为空!");
		if (logger.isDebugEnabled()) {
			logger.debug("请求URL：{}", url);
		}
		// 发起请求，得到响应
		String result = HttpClient.sendGetRequest(url);

		if (logger.isDebugEnabled()) {
			logger.debug("返回响应：{}", result);
		}
		return result;
	}

	public static String getRequestUrl(String key, Object[] params) {
		String url = SystemConfig.getValue(key);
		Assert.notNull(url, "未找到" + key + "对应配置的请求URL");
		url = MessageFormat.format(url, params);
		return url;
	}

}
