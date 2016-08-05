package com.unisk.wechat.web.support.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.unisk.wechat.api.msg.Msg;
import com.unisk.wechat.api.msg.xml.receive.ReceiveEventMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyNewsMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyNewsMsg.InnerNewsMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyTextMsg;
import com.unisk.wechat.api.support.MessageHandler;
import com.unisk.wechat.api.support.WechatHelper;
import com.unisk.wechat.api.util.XmlUtil;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.NoticeMessage;
import com.unisk.zc.entitys.NoticeMessageReceiver;
import com.unisk.zc.service.NoticeMessageService;

/**
 * 
 * @Description:最新公告查看 click事件处理器
 * @author shijingbang
 * @Date 2015年11月26日
 */
public class WechatPushNoticesMessageHandler extends MessageHandler {
	@Autowired
	NoticeMessageService noticeMesssageService;

	public WechatPushNoticesMessageHandler(String msgType, String event, String eventKey) {
		super(msgType, event, eventKey);
	}

	/**
	 * 推送图文消息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String processRequest(Map<String, Object> map) {
		ReceiveEventMsg msg = super.convertMapToBean(map, ReceiveEventMsg.class);
		String fromUser = msg.getFromUserName();
		NoticeMessageReceiver receiver = new NoticeMessageReceiver();
		Page page = new Page();
		page.setCurrentPage(1);
		page.setMaxNum(9);
		receiver.setPage(page);
		receiver.setReceiverusername(fromUser);
		Page<NoticeMessage> result = noticeMesssageService.getNoticeMessageByWXIdPage(receiver);
		if (result != null && result.getData() != null && result.getData().size() > 0) {
			List<NoticeMessage> list = result.getData();
			ReplyNewsMsg reply = new ReplyNewsMsg();
			reply.setToUserName(fromUser);
			reply.setFromUserName(msg.getToUserName());
			reply.setArticleCount(list.size() + 1);
			reply.setCreateTime(System.currentTimeMillis() + "");
			reply.setMsgType(Msg.MSG_TYPE_IMAGE_TEXT);// 图文消息
			List<InnerNewsMsg> news = new ArrayList<ReplyNewsMsg.InnerNewsMsg>();

			for (NoticeMessage nm : list) {
				InnerNewsMsg newsItem = new ReplyNewsMsg.InnerNewsMsg();
				newsItem.setDescription(nm.getContent());
				newsItem.setTitle(nm.getTitle());
				newsItem.setUrl(nm.getUrl());
				newsItem.setPicUrl(nm.getPicUrl());
				news.add(newsItem);
			}
			InnerNewsMsg news4 = new ReplyNewsMsg.InnerNewsMsg();
			news4.setDescription("查看更多");
			news4.setTitle("查看更多");
			news4.setUrl(WechatHelper.getContextUrl() + "/wechat/notice/toView.do?receiverusername=" + fromUser + "&currentPage=1&maxNum=9");
			news.add(news4);

			reply.setNews(news);
			return XmlUtil.toXml(reply);
		}
		// 普通文本消息
		ReplyTextMsg textMsg = new ReplyTextMsg();
		textMsg.setContent("系统暂时还没有发给您的公告消息!");
		textMsg.setToUserName(fromUser);
		textMsg.setFromUserName(msg.getToUserName());
		textMsg.setCreateTime(System.currentTimeMillis() + "");
		textMsg.setMsgType(Msg.MSG_TYPE_TEXT);
		return XmlUtil.toXml(textMsg);
	}

}
