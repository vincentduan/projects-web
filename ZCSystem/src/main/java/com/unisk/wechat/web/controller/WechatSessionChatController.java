package com.unisk.wechat.web.controller;

import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unisk.wechat.api.support.WechatHelper;
import com.unisk.wechat.api.util.RandomStrUtil;
import com.unisk.wechat.api.util.WechatJsApiTicketUtil;
import com.unisk.wechat.api.util.WechatJsGroupTicketUtil;
import com.unisk.wechat.api.util.WechatSignatureUtil;

@Controller
@RequestMapping("/wechat/chat")
public class WechatSessionChatController {
	@RequestMapping("/groupChat")
	public String groupChat(HttpServletRequest request) {
		String nonceStr = RandomStrUtil.randomStr(16);
		String timestamp = System.currentTimeMillis() / 1000 + "";
		String jsApiTicket = WechatJsApiTicketUtil.getJsApiTicket();
		String url = WechatHelper.getContextUrl() + "/wechat/chat/groupChat.do";
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("jsapi_ticket", jsApiTicket);
		map.put("timestamp", timestamp);
		map.put("noncestr", nonceStr);
		map.put("url", url);
		String signature = WechatSignatureUtil.generateSignature(map);
		map.put("signature", signature);
		map.put("jsapi_ticket", jsApiTicket);
		map.put("timestamp", timestamp);
		map.put("noncestr", nonceStr);
		map.put("url", url);

		TreeMap<String, String> contactMap = new TreeMap<String, String>();
		String jsGroupTicket = WechatJsGroupTicketUtil.getJsGroupTicket();
		String groupId = WechatJsGroupTicketUtil.getGroupId();
		contactMap.put("timestamp", timestamp);
		contactMap.put("group_ticket", jsGroupTicket);
		contactMap.put("noncestr", nonceStr);
		contactMap.put("url", url);
		String contactSignature = WechatSignatureUtil.generateSignature(contactMap);
		contactMap.put("signature", contactSignature);
		contactMap.put("groupId", groupId);

		request.setAttribute("data", map);
		request.setAttribute("contactData", contactMap);
		return "/wechat/chat/chat-group";
	}

	@RequestMapping("/singleChat")
	public String singleChat(HttpServletRequest request) {
		String nonceStr = RandomStrUtil.randomStr(16);
		String timestamp = System.currentTimeMillis() / 1000 + "";
		String jsApiTicket = WechatJsApiTicketUtil.getJsApiTicket();
		String url = WechatHelper.getContextUrl() + "/wechat/chat/singleChat.do";
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("jsapi_ticket", jsApiTicket);
		map.put("timestamp", timestamp);
		map.put("noncestr", nonceStr);
		map.put("url", url);
		String signature = WechatSignatureUtil.generateSignature(map);
		map.put("signature", signature);
		map.put("jsapi_ticket", jsApiTicket);
		map.put("timestamp", timestamp);
		map.put("noncestr", nonceStr);
		map.put("url", url);

		TreeMap<String, String> contactMap = new TreeMap<String, String>();
		String jsGroupTicket = WechatJsGroupTicketUtil.getJsGroupTicket();
		String groupId = WechatJsGroupTicketUtil.getGroupId();
		contactMap.put("timestamp", timestamp);
		contactMap.put("group_ticket", jsGroupTicket);
		contactMap.put("noncestr", nonceStr);
		contactMap.put("url", url);
		String contactSignature = WechatSignatureUtil.generateSignature(contactMap);
		contactMap.put("signature", contactSignature);
		contactMap.put("groupId", groupId);

		request.setAttribute("data", map);
		request.setAttribute("contactData", contactMap);
		return "/wechat/chat/chat-single";
	}
}
