package com.unisk.wechat.web.support.handler;

import java.util.Map;

import com.unisk.wechat.api.support.MessageHandler;

public class WechatLocationEventMessageHandler extends MessageHandler {

	public WechatLocationEventMessageHandler(String msgType, String event) {
		super(msgType, event);
	}

	@Override
	public String processRequest(Map<String, Object> map) {
		// 暂时不处理业务逻辑
		return "";
	}

}
