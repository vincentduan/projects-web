package com.unisk.wechat.web.support.handler;

import java.util.Map;

import com.unisk.wechat.api.msg.Msg;
import com.unisk.wechat.api.msg.xml.receive.ReceiveImageMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyImageMsg;
import com.unisk.wechat.api.support.MessageHandler;
import com.unisk.wechat.api.support.WechatHelper;
import com.unisk.wechat.api.util.XmlUtil;

/**
 * 
 * @Description:被动响应消息之 图片消息处理器
 * @author shijingbang
 * @Date 2015年11月24日
 */
public class WechatImageMessageHandler extends MessageHandler {

	public WechatImageMessageHandler(String msgType) {
		super(msgType);
	}

	@Override
	public String processRequest(Map<String, Object> map) {
		ReceiveImageMsg msg = super.convertMapToBean(map, ReceiveImageMsg.class);

		ReplyImageMsg replyMsg = new ReplyImageMsg();

		replyMsg.setCreateTime(System.currentTimeMillis() + "");
		replyMsg.setFromUserName(msg.getToUserName());
		replyMsg.setToUserName(msg.getFromUserName());
		replyMsg.setMsgType(Msg.MSG_TYPE_IMAGE);
		replyMsg.setPicUrl(WechatHelper.getContextUrl() + "/statics/imgs/bighellologo.png");
		replyMsg.setMsgId(msg.getMsgId());
		replyMsg.setMediaId(null);// 图片媒体文件id，可以调用获取媒体文件接口拉取数据，参见官网接口文档管理素材文件一栏

		return XmlUtil.toXml(replyMsg);
	}

}
