package com.unisk.wechat.web.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unisk.wechat.api.msg.Msg;
import com.unisk.wechat.api.msg.json.send.SendNewsMessage;
import com.unisk.wechat.api.msg.json.send.SendNewsMessage.NewsArticle;
import com.unisk.wechat.api.support.SystemConfig;
import com.unisk.wechat.api.support.WechatHelper;
import com.unisk.wechat.api.support.request.MessageSendRequest;
import com.unisk.wechat.api.util.JsonUtil;
import com.unisk.wechat.api.util.RandomStrUtil;
import com.unisk.wechat.api.util.WechatJsApiTicketUtil;
import com.unisk.wechat.api.util.WechatJsGroupTicketUtil;
import com.unisk.wechat.api.util.WechatSignatureUtil;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.FreeMarkerUtil;
import com.unisk.zc.entitys.NoticeMessage;
import com.unisk.zc.entitys.NoticeMessageReceiver;
import com.unisk.zc.entitys.ZtreeNode;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.NoticeMessageReceiverService;
import com.unisk.zc.service.NoticeMessageService;
import com.unisk.zc.service.UniskUserService;
import com.unisk.zc.service.ZtreeNodeService;
import com.unisk.zc.utils.DateUtils;

/**
 * 沃众筹企业号公告栏模块控制器
 * 
 * @Description:
 * @author shijingbang
 * @Date 2016年1月9日
 */
@Controller
@RequestMapping("/wechat/notice")
public class WechatNoticeController {
	private static final Logger logger = LoggerFactory.getLogger(WechatNoticeController.class);
	@Autowired
	NoticeMessageService noticeMesssageService;
	@Autowired
	NoticeMessageReceiverService noticeMessageReceiverService;
	@Autowired
	UniskUserService uniskUserService;
	@Autowired
	ZtreeNodeService treeNodeService;

	@RequestMapping("/toPublish")
	public String toNoticeWechatPublishPage(HttpServletRequest request) {
		String nonceStr = RandomStrUtil.randomStr(16);// 生成16位随机数
		String timestamp = System.currentTimeMillis() / 1000 + "";// 精确到秒
		String jsApiTicket = WechatJsApiTicketUtil.getJsApiTicket();// 获取调用js-sdk接口能力的临时票据
		String url = WechatHelper.getContextUrl() + "/wechat/notice/toPublish.do";
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("jsapi_ticket", jsApiTicket);
		map.put("timestamp", timestamp);
		map.put("noncestr", nonceStr);
		map.put("url", url);
		String signature = WechatSignatureUtil.generateSignature(map);
		map.put("signature", signature);

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
		return "/wechat/notice/notice-publish-wechat";
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/generate", produces = { "application/json;charset=UTF-8" })
	public String generateNotice(@RequestBody String json, HttpServletRequest request) throws IOException, UniskException {
		if (logger.isDebugEnabled()) {
			logger.debug("请求参数为bodyContent:{}", json);
		}
		Map<String, Object> model = JsonUtil.jsonToMap(URLDecoder.decode(json.substring(0, json.length() - 1), "UTF-8"), Object.class);
		String createTime = DateUtils.getNowTime();
		model.put("createTime", createTime);
		String fileName = UUID.randomUUID().toString() + ".html";
		model.put("ctx", WechatHelper.getContextUrl());

		// 根据freemarker模板生成公告的静态页面
		FreeMarkerUtil.analysisTemplate("common-notice.ftl", fileName, model, true);
		String url = FreeMarkerUtil.generateUploadFilePath(SystemConfig.getValue("wzc.freemarker.access.path")) + fileName;

		// 群发公告消息 图文消息形式发送
		List<String> selectedTagIds = (List<String>) model.get("selectedTagIds");// 要发送的标签列表
		List<String> selectedDepartmentIds = (List<String>) model.get("selectedDepartmentIds");// 要发送的部门列表
		List<String> selectedUserIds = (List<String>) model.get("selectedUserIds");// 要送法的用户列表
		SendNewsMessage message = new SendNewsMessage();
		message.setToTag(selectedTagIds);
		message.setToUser(selectedUserIds);
		message.setToParty(selectedDepartmentIds);
		message.setAgentId(WechatHelper.getWoAgentId(WechatHelper.NOTICE_AGENT_ID));// 应用ID
		message.setMsgType(Msg.MSG_TYPE_IMAGE_TEXT);// 消息类型
		SendNewsMessage.NewsContent news = new SendNewsMessage.NewsContent();
		List<NewsArticle> articles = new ArrayList<NewsArticle>();
		NewsArticle article = new NewsArticle();
		article.setTitle((String) model.get("title"));
		article.setDescription((String) model.get("content"));
		article.setUrl(WechatHelper.getContextUrl() + url);
		article.setPicurl(WechatHelper.getContextUrl() + "/statics/images/notice.png");
		articles.add(article);
		news.setArticles(articles);
		message.setNews(news);
		String result = MessageSendRequest.sendMessage(message);// 群发图文消息
		Map<String, Object> resultMap = JsonUtil.jsonToMap(result, Object.class);
		Map<String, Object> respMsg = new HashMap<String, Object>();
		// 发布群消息成功，则公告信息入库
		if (StringUtils.equals("ok", (String) resultMap.get("errmsg"))) {
			noticeMesssageService.saveNoticeByNewsMessage(message);
			respMsg.put("code", "0");
			respMsg.put("message", "发布成功!");
		} else {
			respMsg.put("code", "1");
			respMsg.put("message", resultMap.get("errmsg"));
		}
		return JsonUtil.toJson(respMsg);
	}

	@RequestMapping(value = "/toView")
	public String noticeView(HttpServletRequest request) {
		Page<NoticeMessage> result = getListByPage(request);
		request.setAttribute("page", result);
		return "/wechat/notice/notice-view";
	}

	@RequestMapping(value = "/toList")
	public String noticeList(HttpServletRequest request) {
		Page<NoticeMessage> result = getListByPage(request);
		request.setAttribute("page", result);
		return "/wechat/notice/notice-list";
	}

	public Page<NoticeMessage> getListByPage(HttpServletRequest request) {
		String currentPage = request.getParameter("currentPage");
		String maxNum = request.getParameter("maxNum");
		String receiverusername = request.getParameter("receiverusername");
		int cp = StringUtils.isBlank(currentPage) ? 1 : Integer.parseInt(currentPage);
		int mn = StringUtils.isBlank(maxNum) ? 9 : Integer.parseInt(maxNum);
		Page page = new Page();
		page.setCurrentPage(cp);
		page.setMaxNum(mn);
		NoticeMessageReceiver receiver = new NoticeMessageReceiver();
		receiver.setPage(page);
		receiver.setReceiverusername(receiverusername);
		request.setAttribute("receiverusername", receiverusername);
		Page<NoticeMessage> result = noticeMesssageService.getNoticeMessageByWXIdPage(receiver);
		return result;
	}

	@RequestMapping(value = "/toShowUserTree")
	public String showUserTree(HttpServletRequest request) {
		List<ZtreeNode> deptMenuNodes = treeNodeService.selectAllByDept();
		List<ZtreeNode> tagMenuNodes = treeNodeService.selectAllByTag();
		Gson gson = new GsonBuilder().create();
		request.setAttribute("deptMenuNodes", gson.toJson(deptMenuNodes));
		request.setAttribute("tagMenuNodes", gson.toJson(tagMenuNodes));
		return "/wechat/notice/notice-selectUsers";
	}

	@RequestMapping("/toPublish2")
	public String toNoticeWechatPublishPage2(HttpServletRequest request) {
		return "/wechat/notice/notice-publish-wechat1";
	}

}
