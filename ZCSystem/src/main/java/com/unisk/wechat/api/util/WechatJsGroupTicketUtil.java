package com.unisk.wechat.api.util;

import java.text.MessageFormat;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unisk.wechat.api.support.SystemConfig;

/**
 * 获取微信JS_SDK管理组临时票据ticket工具类
 * 
 * @Description:
 * @author shijingbang
 * @Date 2016年1月9日
 */
public class WechatJsGroupTicketUtil {

	private static final Logger logger = LoggerFactory.getLogger(WechatJsGroupTicketUtil.class);

	private static Long lastTime = null;
	private static String jsGroupTicket = null;
	private static String groupId = null;
	private static Integer expireIn = 7200;

	/**
	 * 获取jsGroup_ticket
	 * 
	 * @return
	 */
	public static String getJsGroupTicket() {
		// 判断jsgroup_ticket是否可用(有无失效)
		if (!isJsGroupTicketUseable()) {
			String originalJsGroupTicketUrl = SystemConfig.getValue("wechat.getJsGroupTicket.url");
			String accessToken = AccessTokenUtil.getAccessToken();
			String jsGroupTicketUrl = MessageFormat.format(originalJsGroupTicketUrl, accessToken);
			String json = HttpClient.sendGetRequest(jsGroupTicketUrl);
			Map<String, Object> map = JsonUtil.jsonToMap(json, Object.class);

			lastTime = System.currentTimeMillis();
			jsGroupTicket = (String) map.get("ticket");
			groupId = (String) map.get("group_id");
			expireIn = ((Double) (map.get("expires_in"))).intValue();

			if (logger.isDebugEnabled()) {
				logger.debug("获取jsgroup_ticket的最新时间lastTime：{}", lastTime);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("jsgroup_ticket为：{},groupId为：{}", jsGroupTicket, groupId);
		}
		return jsGroupTicket;
	}

	public static String getGroupId() {
		if (StringUtils.isBlank(groupId)) {
			getJsGroupTicket();
		}
		return groupId;
	}

	public static boolean isJsGroupTicketUseable() {
		long currentTime = System.currentTimeMillis();
		if (lastTime == null || ((currentTime - lastTime) / 1000 >= expireIn)) {
			return false;
		}
		return true;
	}

}
