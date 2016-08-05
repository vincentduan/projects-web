package com.unisk.wechat.api.support.request;

import java.text.MessageFormat;

import com.unisk.wechat.api.msg.json.send.CommonMessage;
import com.unisk.wechat.api.support.CommonRequest;
import com.unisk.wechat.api.support.SystemConfig;
import com.unisk.wechat.api.util.AccessTokenUtil;
import com.unisk.wechat.api.util.JsonUtil;

/**
 * 
 * @Description:主动发送消息请求处理器
 * @author shijingbang
 * @Date 2015年11月26日
 */
public class MessageSendRequest extends CommonRequest {

	/**
	 * 主动发送消息
	 * 
	 * @param msg
	 *            要发送的消息内容对象
	 * @return
	 */
	public static String sendMessage(CommonMessage msg) {
		String url = SystemConfig.getValue("wechat.sendMessage.url");
		String accessToken = AccessTokenUtil.getAccessToken();
		url = MessageFormat.format(url, accessToken);
		return sendPostRequest(url, JsonUtil.toJsonByJackson(msg));
	}

}
