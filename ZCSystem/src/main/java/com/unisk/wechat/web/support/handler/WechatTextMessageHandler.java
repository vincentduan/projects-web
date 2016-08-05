package com.unisk.wechat.web.support.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unisk.wechat.api.msg.json.send.SendTextMessage;
import com.unisk.wechat.api.msg.json.send.SendTextMessage.TextContent;
import com.unisk.wechat.api.msg.xml.receive.ReceiveTextMsg;
import com.unisk.wechat.api.support.MessageHandler;
import com.unisk.wechat.api.support.request.MessageSendRequest;

public class WechatTextMessageHandler extends MessageHandler {
	private static final Logger logger = LoggerFactory.getLogger(WechatTextMessageHandler.class);

	public WechatTextMessageHandler(String msgType) {
		super(msgType);
	}

	@Override
	public String processRequest(Map<String, Object> map) {
		ReceiveTextMsg msg = super.convertMapToBean(map, ReceiveTextMsg.class);
		SendTextMessage sendMsg = new SendTextMessage();
		List<String> toUser = new ArrayList<String>();
		toUser.add("@all");
		sendMsg.setToUser(toUser);
		sendMsg.setAgentId(msg.getAgentId());
		sendMsg.setMsgType(msg.getMsgType());
		sendMsg.setSafe(false);
		sendMsg.setText(new TextContent(msg.getContent()));
		MessageSendRequest.sendMessage(sendMsg);
		return "";
	}
}
