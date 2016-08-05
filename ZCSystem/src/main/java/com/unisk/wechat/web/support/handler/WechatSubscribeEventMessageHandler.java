package com.unisk.wechat.web.support.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.unisk.wechat.api.msg.Msg;
import com.unisk.wechat.api.msg.xml.receive.ReceiveEventMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyNewsMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyNewsMsg.InnerNewsMsg;
import com.unisk.wechat.api.support.MessageHandler;
import com.unisk.wechat.api.support.WechatHelper;
import com.unisk.wechat.api.util.XmlUtil;

/**
 * 
 * @Description: 用户关注 事件推送处理器
 * @author shijingbang
 * @Date 2015年12月2日
 */
public class WechatSubscribeEventMessageHandler extends MessageHandler {

	public WechatSubscribeEventMessageHandler(String msgType, String event) {
		super(msgType, event);
	}

	@Override
	public String processRequest(Map<String, Object> map) {
		ReceiveEventMsg msg = super.convertMapToBean(map, ReceiveEventMsg.class);
		ReplyNewsMsg reply = new ReplyNewsMsg();
		reply.setToUserName(msg.getFromUserName());
		reply.setFromUserName(msg.getToUserName());
		reply.setArticleCount(1);
		reply.setCreateTime(System.currentTimeMillis() + "");
		reply.setMsgType(Msg.MSG_TYPE_IMAGE_TEXT);// 图文消息
		List<InnerNewsMsg> news = new ArrayList<ReplyNewsMsg.InnerNewsMsg>();
		// 以下内容从数据库查，此处先做演示用
		InnerNewsMsg news1 = new ReplyNewsMsg.InnerNewsMsg();
		news1.setDescription("沃众筹用户操作帮助指南！");
		news1.setTitle("沃众筹用户操作帮助指南");
		news1.setUrl(WechatHelper.getContextUrl() + "/wechat/help.do");
		news1.setPicUrl(WechatHelper.getContextUrl() + "/statics/images/14072985.png");
		news.add(news1);

		reply.setNews(news);

		return XmlUtil.toXml(reply);
	}
}
