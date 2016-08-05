package com.unisk.wechat.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.unisk.wechat.api.msg.Msg;
import com.unisk.wechat.api.msg.json.send.SendNewsMessage;
import com.unisk.wechat.api.msg.json.send.SendNewsMessage.NewsArticle;
import com.unisk.wechat.api.support.SystemConfig;
import com.unisk.wechat.api.support.WechatHelper;
import com.unisk.wechat.api.support.request.MessageSendRequest;
import com.unisk.wechat.api.support.request.UploadMaterialRequest;
import com.unisk.wechat.api.util.FileUtils;
import com.unisk.wechat.api.util.JsonUtil;
import com.unisk.wechat.web.support.NoticeFormData;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.FreeMarkerUtil;
import com.unisk.zc.entitys.NoticeMessage;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.NoticeMessageReceiverService;
import com.unisk.zc.service.NoticeMessageService;

/**
 * 
 * Title: 公告消息发布PC管理端控制器<br>
 * Description: 用于在PC端公告消息的增删改查以及群发到微信企业号<br>
 * Date: 2016年1月14日 <br>
 * 
 * @author bang
 */
@Controller
@RequestMapping("/ucenter/notice")
public class NoticeManagerController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeManagerController.class);
	@Autowired
	NoticeMessageService noticeMesssageService;
	@Autowired
	NoticeMessageReceiverService noticeMessageReceiverService;

	/**
	 * 跳转到公告消息首页
	 * 
	 * @param request
	 * @return
	 * @author bang
	 */
	@RequestMapping(value = { "listView" })
	public String listView(HttpServletRequest request) {
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		NoticeMessage message = new NoticeMessage();
		message.getQueryMap().put("beginTime", beginTime);
		message.getQueryMap().put("endTime", endTime);
		Page<Map<String, Object>> page = noticeMesssageService.selectMapPageByRange(message);
		request.setAttribute("page", page);
		return "/wechat/notice/notice-pc-list";
	}

	@RequestMapping(value = { "formView" })
	public String formView(HttpServletRequest request) {
		return "/wechat/notice/notice-publish-pc";
	}

	/**
	 * 群发公告消息至微信端
	 * 
	 * @param id 公告消息ID
	 * @return
	 * @throws UniskException
	 * @author bang
	 */
	@RequestMapping(value = "/sync", produces = { "application/json" })
	public String syncNotice(@RequestParam(value = "id") Integer id) throws UniskException {
		NoticeMessage nm = noticeMesssageService.findById(id);
		SendNewsMessage message = new SendNewsMessage();
		message.setToTag(nm.getToTagList());
		message.setToUser(nm.getToUserList());
		message.setToParty(nm.getToPartyList());
		message.setAgentId(WechatHelper.getWoAgentId(WechatHelper.NOTICE_AGENT_ID));// 应用ID
		message.setMsgType(Msg.MSG_TYPE_IMAGE_TEXT);// 消息类型
		SendNewsMessage.NewsContent news = new SendNewsMessage.NewsContent();
		List<NewsArticle> articles = new ArrayList<NewsArticle>();
		NewsArticle article = new NewsArticle();
		article.setTitle(nm.getTitle());
		article.setDescription(nm.getContent());
		article.setUrl(nm.getUrl());
		article.setPicurl(nm.getPicUrl());
		articles.add(article);
		news.setArticles(articles);
		message.setNews(news);
		String result = MessageSendRequest.sendMessage(message);// 群发图文消息

		Map<String, Object> resultMap = JsonUtil.jsonToMap(result, Object.class);
		Map<String, Object> respMsg = new HashMap<String, Object>();
		if (StringUtils.equals("ok", (String) resultMap.get("errmsg"))) {
			respMsg.put("code", "0");
			respMsg.put("message", "发布成功!");
		} else {
			respMsg.put("code", "1");
			respMsg.put("message", resultMap.get("errmsg"));
		}
		return JsonUtil.toJson(respMsg);
	}

	/**
	 * 上传公告附件
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws UniskException
	 * @author bang
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException, UniskException {
		// 获取要上传的目录
		String uploadDirectory = FreeMarkerUtil.getUploadFilePath();
		// 保存文件到磁盘
		if (!file.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadDirectory + file.getOriginalFilename()));
		}
		String url = FreeMarkerUtil.generateUploadFilePath(SystemConfig.getValue("wzc.freemarker.access.path")) + file.getOriginalFilename();
		Map<String, String> result = new HashMap<String, String>();
		result.put("code", "0");
		result.put("message", "上传成功！");
		result.put("fileName", file.getOriginalFilename());
		result.put("filePath", uploadDirectory + file.getOriginalFilename());
		result.put("url", WechatHelper.getContextUrl() + url);
		return JsonUtil.toJson(result);
	}

	/**
	 * 发布公告
	 * 
	 * @return
	 * @author bang
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/publish", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public String publish(HttpServletRequest request, NoticeFormData formData) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("请求参数为{}", formData);
		}
		formData.setAgentId(WechatHelper.getWoAgentId(WechatHelper.NOTICE_AGENT_ID));

		if (StringUtils.equals("1", formData.getUploadType())) {// 以富文本方式发布公告
			// 生成静态页面
			String fileName = UUID.randomUUID().toString() + ".html";
			String filePath = FreeMarkerUtil.getUploadFilePath();
			File file = new File(filePath + fileName);
			FileUtils.write(file, formData.getContent(), "UTF-8");
			// 生成访问此静态页面的url
			String url = FreeMarkerUtil.generateUploadFilePath(SystemConfig.getValue("wzc.freemarker.access.path")) + fileName;
			SendNewsMessage message = new SendNewsMessage();
			message.setToTag(formData.getSelectedTagIdsList());
			message.setToUser(formData.getSelectedUserIdsList());
			message.setToParty(formData.getSelectedUserIdsList());
			message.setAgentId(formData.getAgentId());// 应用ID
			message.setMsgType(Msg.MSG_TYPE_IMAGE_TEXT);// 消息类型
			SendNewsMessage.NewsContent news = new SendNewsMessage.NewsContent();
			List<NewsArticle> articles = new ArrayList<NewsArticle>();
			NewsArticle article = new NewsArticle();
			article.setTitle(formData.getTitle());
			article.setDescription(formData.getTitle());
			article.setUrl(WechatHelper.getContextUrl() + url);
			article.setPicurl(WechatHelper.getContextUrl() + "/statics/images/notice.png");
			articles.add(article);
			news.setArticles(articles);
			message.setNews(news);
			String result = MessageSendRequest.sendMessage(message);// 群发图文消息
			if (logger.isDebugEnabled()) {
				logger.debug("微信服务器返回群发图文消息响应内容为:{}", result);
			}
			Map<String, Object> resultMap = JsonUtil.jsonToMap(result, Object.class);
			Map<String, Object> respMsg = new HashMap<String, Object>();
			// 发布群消息成功，则公告信息入库
			if (StringUtils.equals("ok", (String) resultMap.get("errmsg"))) {
				noticeMesssageService.saveNoticeByNewsMessage(message);// 代码复用，公告信息入库
				respMsg.put("code", "0");
				respMsg.put("message", "发布成功!");
			} else {
				respMsg.put("code", "1");
				respMsg.put("message", resultMap.get("errmsg"));
			}
			return JsonUtil.toJson(respMsg);
		} else if (StringUtils.equals("2", formData.getUploadType())) {// 以附件上传的形式发布公告
			// 上传素材到微信服务器
			File file = new File(formData.getFilePath());
			formData.setMsgType(FileUtils.getFileType(file));
			String result = UploadMaterialRequest.uploadPermanentOthersMaterialRequest(formData.getAgentId(), formData.getMsgType(), formData.getFileName(), file);
			if (logger.isDebugEnabled()) {
				logger.debug("上传素材类型{},微信服务器返回消息响应内容为:{}", formData.getMsgType(), result);
			}
			Map<String, Object> resultMap = JsonUtil.jsonToMap(result, Object.class);
			if (StringUtils.equals("ok", (String) resultMap.get("errmsg"))) {// 上传素材成功，则群发消息
				String mediaId = (String) resultMap.get("media_id");
				formData.setMediaId(mediaId);
				String resp = MessageSendRequest.sendMessage(formData.getCommonMessageByMsgType());// 按消息类型来群发消息
				if (logger.isDebugEnabled()) {
					logger.debug("微信服务器返回群发{}消息响应内容为:{}", formData.getMsgType(), resp);
				}
				Map<String, Object> respMap = JsonUtil.jsonToMap(resp, Object.class);
				Map<String, Object> respMsg = new HashMap<String, Object>();
				// 发布群消息成功，则公告信息入库
				if (StringUtils.equals("ok", (String) respMap.get("errmsg"))) {

					respMsg.put("code", "0");
					respMsg.put("message", "发布成功!");
				} else {
					respMsg.put("code", "1");
					respMsg.put("message", respMap.get("errmsg"));
				}
				return JsonUtil.toJson(respMsg);
			}
		}

		Map<String, String> result = new HashMap<String, String>();
		result.put("code", "0");
		result.put("message", "发布成功！");
		return JsonUtil.toJson(result);
	}

}
