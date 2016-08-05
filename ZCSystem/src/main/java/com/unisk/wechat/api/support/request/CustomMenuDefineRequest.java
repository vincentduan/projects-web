package com.unisk.wechat.api.support.request;

import java.text.MessageFormat;

import org.springframework.util.Assert;

import com.unisk.wechat.api.msg.json.send.CommonMessage;
import com.unisk.wechat.api.support.CommonRequest;
import com.unisk.wechat.api.support.SystemConfig;
import com.unisk.wechat.api.support.WechatHelper;

/**
 * 
 * @Description: 自定义菜单 请求处理器
 * @author shijingbang
 * @Date 2015年11月26日
 */
public class CustomMenuDefineRequest extends CommonRequest {
	/**
	 * 创建自定义菜单
	 * 
	 * @param msg
	 * @return
	 */
	public static String menuCreateRequest(String json, String agentId) {
		String url = getRequestUrl("wechat.menuCreate.url", agentId);
		return sendPostRequest(url, json);
	}

	/**
	 * 删除自定义菜单
	 * 
	 * @param msg
	 * @return
	 */
	public static String menuDeleteRequest(CommonMessage msg) {
		String url = getRequestUrl("wechat.meneDelete.url", msg.getAgentId());
		return sendGetRequest(url);
	}

	/**
	 * 获取自定义菜单列表
	 * 
	 * @param msg
	 * @return
	 */
	public static String menuQueryRequest(CommonMessage msg) {
		String url = getRequestUrl("wechat.menuQuery.url", msg.getAgentId());
		return sendGetRequest(url);
	}

	public static String getRequestUrl(String key, String agentId) {
		String url = SystemConfig.getValue(key);
		Assert.notNull(url, "未找到" + key + "对应配置的请求URL");
		String accessToken = WechatHelper.getAccessToken();
		url = MessageFormat.format(url, accessToken, agentId);
		return url;
	}
}
