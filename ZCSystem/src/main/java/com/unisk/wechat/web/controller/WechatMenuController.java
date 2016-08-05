package com.unisk.wechat.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unisk.wechat.api.support.WechatHelper;
import com.unisk.wechat.api.support.request.CustomMenuDefineRequest;
import com.unisk.wechat.api.util.JsonUtil;

@Controller
@RequestMapping("/wechat/menu")
public class WechatMenuController {

	// http://localhost:8888/uniskzhongchou/wechat/menu/create.do
	@RequestMapping("/notice/create")
	@ResponseBody
	public String noticeMenuCreate(@RequestParam(value = "agentId", required = true) String agentId) {
		Map<String, Object> menus = new HashMap<String, Object>();

		List<Map<String, Object>> buttons = new ArrayList<Map<String, Object>>();

		Map<String, Object> noticeHistory = new HashMap<String, Object>();
		noticeHistory.put("name", "最新公告");
		noticeHistory.put("type", "click");
		noticeHistory.put("key", "WECHAT_CLICK_VIEW_NOTICES");
		buttons.add(noticeHistory);

		Map<String, Object> zixun = new HashMap<String, Object>();
		zixun.put("name", "发布公告");
		zixun.put("type", "view");
		zixun.put("url", WechatHelper.getContextUrl() + "/wechat/notice/toPublish.do");
		buttons.add(zixun);

		Map<String, Object> session = new HashMap<String, Object>();
		session.put("name", "发起会话");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> mutilSession = new HashMap<String, Object>();
		mutilSession.put("name", "群聊");
		mutilSession.put("type", "view");
		mutilSession.put("url", WechatHelper.getContextUrl() + "/wechat/chat/groupChat.do");
		list.add(mutilSession);

		Map<String, Object> singleSession = new HashMap<String, Object>();
		singleSession.put("name", "私聊");
		singleSession.put("type", "view");
		singleSession.put("url", WechatHelper.getContextUrl() + "/wechat/chat/singleChat.do");
		list.add(singleSession);
		session.put("sub_button", list);

		buttons.add(session);
		menus.put("button", buttons);
		String menu = JsonUtil.toJson(menus);
		String result = CustomMenuDefineRequest.menuCreateRequest(menu, agentId);
		return result;
	}

	@RequestMapping("/vote/create")
	@ResponseBody
	public String voteMenuCreate(@RequestParam(value = "agentId", required = true) String agentId) {
		Map<String, Object> menus = new HashMap<String, Object>();

		List<Map<String, Object>> buttons = new ArrayList<Map<String, Object>>();
		Map<String, Object> vote = new HashMap<String, Object>();// 资讯
		vote.put("name", "投票");
		vote.put("type", "click");
		vote.put("key", "WECHAT_CLICK_VOTE_LIST");
		buttons.add(vote);

		Map<String, Object> statist = new HashMap<String, Object>();
		statist.put("name", "统计结果");
		statist.put("type", "click");
		statist.put("key", "WECHAT_CLICK_VOTE_STATIST");
		buttons.add(statist);

		menus.put("button", buttons);
		String menu = JsonUtil.toJson(menus);
		String result = CustomMenuDefineRequest.menuCreateRequest(menu, agentId);
		return result;
	}
}
