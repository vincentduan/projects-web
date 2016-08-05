package com.unisk.wechat.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unisk.wechat.api.official.sdk.AesException;
import com.unisk.wechat.api.official.sdk.WXBizMsgCrypt;
import com.unisk.wechat.api.support.WechatHelper;
import com.unisk.wechat.api.support.WechatSession;
import com.unisk.wechat.api.util.SpringUtils;

public class WechatVoteHttpServlet extends HttpServlet {
	private static final long serialVersionUID = -1751250881642089906L;
	private static final Logger logger = LoggerFactory.getLogger(WechatNoticeHttpServlet.class);
	private static final String WX_BIZ_MSG_CRYPT = "voteMsgCrypt";

	/**
	 * 处理微信服务器验证
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signature = request.getParameter("msg_signature"); // 微信加密签名
		String timestamp = request.getParameter("timestamp"); // 时间戳
		String nonce = request.getParameter("nonce"); // 随机数
		String echostr = request.getParameter("echostr"); // 随机字符串

		if (logger.isDebugEnabled()) {
			logger.debug("请求URL参数：" + request.getQueryString());
		}

		String sEchoStr = ""; // 需要返回的明文
		try {
			// 直接使用腾讯官网提供的代码验证
			WXBizMsgCrypt wxcpt = WechatHelper.getWXBizMsgCrypt(WX_BIZ_MSG_CRYPT);
			sEchoStr = wxcpt.VerifyURL(signature, timestamp, nonce, echostr);
			if (logger.isDebugEnabled()) {
				logger.debug("微信验证成功,sEchoStr = {}", sEchoStr);
			}
		} catch (AesException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("微信验证失败,失败原因:{}", e.getMessage());
			}
			e.printStackTrace();
		}
		Writer out = response.getWriter();
		out.write(sEchoStr);

		out.flush();
		out.close();
	}

	/**
	 * 处理微信服务器发过来的各种消息，包括：文本、图片、地理位置、音乐等等
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 防止中文乱码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String encryptMsg = "";
		PrintWriter pw = response.getWriter();

		if (logger.isDebugEnabled()) {
			logger.debug("开始处理微信平台POST请求........,开始时间:{}", System.currentTimeMillis());
		}
		String signature = request.getParameter("msg_signature"); // 微信加密签名
		String timestamp = request.getParameter("timestamp"); // 时间戳
		String nonce = request.getParameter("nonce"); // 随机数

		try {
			// 读取post请求正文参数内容
			String requestParam = IOUtils.toString(request.getInputStream(), "UTF-8");

			if (logger.isDebugEnabled()) {
				logger.debug("请求数据为：signature={},timestamp={},nonce={},postData={}", new Object[] { signature, timestamp, nonce, requestParam });
			}
			// 解密密文参数
			String decryptMsg = WechatHelper.getWXBizMsgCrypt(WX_BIZ_MSG_CRYPT).DecryptMsg(signature, timestamp, nonce, requestParam);

			if (logger.isDebugEnabled()) {
				logger.debug("解析微信postData数据成功,解密后的数据为：{}", decryptMsg);
			}
			// 根据请求内容处理具体业务逻辑
			WechatSession session = SpringUtils.getBean(WechatSession.class);
			String responseMessage = session.processRequest(decryptMsg);

			if (logger.isDebugEnabled()) {
				logger.debug("响应明文消息为:{}", responseMessage);
			}

			// 加密明文之后返给微信平台
			encryptMsg = WechatHelper.getWXBizMsgCrypt(WX_BIZ_MSG_CRYPT).EncryptMsg(responseMessage, "", nonce);

			if (logger.isDebugEnabled()) {
				logger.debug("响应明文消息加密成功,加密后的消息为:{}", encryptMsg);
			}

		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("处理微信post请求失败,失败原因：{}", e.getMessage());
			}
		} finally {
			pw.print(encryptMsg);
			pw.close();
		}

	}
}
