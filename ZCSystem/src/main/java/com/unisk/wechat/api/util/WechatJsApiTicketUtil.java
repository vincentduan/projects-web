package com.unisk.wechat.api.util;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unisk.wechat.api.support.SystemConfig;

/**
 * 获取微信JS_SDK API临时票据jsapi_ticket工具类
 * 
 * @Description:
 * @author shijingbang
 * @Date 2016年1月9日
 */
public class WechatJsApiTicketUtil {

	private static final Logger logger = LoggerFactory.getLogger(WechatJsApiTicketUtil.class);

	private static Long lastTime = null;
	private static String jsApiTicket = null;
	private static Integer expireIn = 7200;

	/**
	 * 获取jsapi_ticket
	 * 
	 * @return
	 */
	public static String getJsApiTicket() {
		// 判断jsapi_ticket是否可用(有无失效)
		if (!isJsApiTicketUseable()) {
			String originalJsApiTicketUrl = SystemConfig.getValue("wechat.getJsApiTicket.url");
			String accessToken = AccessTokenUtil.getAccessToken();
			String jsApiTicketUrl = MessageFormat.format(originalJsApiTicketUrl, accessToken);
			String json = HttpClient.sendGetRequest(jsApiTicketUrl);
			Map<String, Object> map = JsonUtil.jsonToMap(json, Object.class);

			lastTime = System.currentTimeMillis();
			jsApiTicket = (String) map.get("ticket");
			expireIn = ((Double) (map.get("expires_in"))).intValue();

			if (logger.isDebugEnabled()) {
				logger.debug("获取jsapi_ticket的最新时间lastTime：{}", lastTime);
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("jsapi_ticket为：{}", jsApiTicket);
		}
		return jsApiTicket;
	}

	public static boolean isJsApiTicketUseable() {
		long currentTime = System.currentTimeMillis();
		if (lastTime == null || ((currentTime - lastTime) / 1000 >= expireIn)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] arrs = new String[] { "noncestr", "jsapi_ticket", "timestamp", "url" };
		System.out.println(Arrays.toString(arrs));
		Arrays.sort(arrs);
		System.out.println(Arrays.toString(arrs));

		TreeMap<String, String> map = new TreeMap<>();
		map.put("noncestr", "Wm3WZYTPz0wzccnW");
		map.put("jsapi_ticket", "sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg");
		map.put("url", "http://mp.weixin.qq.com");
		map.put("timestamp", "1414587457");

		System.out.println(map.toString());
	}
}
