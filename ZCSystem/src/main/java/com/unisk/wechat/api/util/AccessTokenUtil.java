package com.unisk.wechat.api.util;

import java.text.MessageFormat;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unisk.wechat.api.support.SystemConfig;
import com.unisk.wechat.api.support.WechatHelper;

/**
 * 
 * @Description:获取微信AccessToken工具类
 * @author shijingbang
 * @Date 2015年11月18日
 */
public class AccessTokenUtil {

	private static final Logger logger = LoggerFactory.getLogger(AccessTokenUtil.class);

	private static Long lastTime = null;
	private static String accessToken = null;
	private static Integer expireIn = 7200;

	/**
	 * 获取access_token
	 * 
	 * @return
	 */
	public static String getAccessToken() {
		// 判断access_token是否可用(有无失效)
		if (!isAccessTokenUseable()) {
			String originalAccessTokenUrl = SystemConfig.getValue("wechat.getAccessToken.url");
			String corpId = WechatHelper.getCorpID();
			String corpsecret = WechatHelper.getSecret();
			String accessTokenUrl = MessageFormat.format(originalAccessTokenUrl, corpId, corpsecret);
			String json = HttpClient.sendGetRequest(accessTokenUrl);
			Map<String, Object> map = JsonUtil.jsonToMap(json, Object.class);

			lastTime = System.currentTimeMillis();
			accessToken = (String) map.get("access_token");
			expireIn = ((Double) (map.get("expires_in"))).intValue();

			if (logger.isDebugEnabled()) {
				logger.debug("获取accessToken的最新时间lastTime：{}", lastTime);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("accessToken为：{}", accessToken);
		}
		return accessToken;
	}

	public static boolean isAccessTokenUseable() {
		long currentTime = System.currentTimeMillis();
		if (lastTime == null || ((currentTime - lastTime) / 1000 >= expireIn)) {
			return false;
		}
		return true;
	}
}
