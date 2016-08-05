package com.unisk.wechat.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unisk.wechat.api.support.request.Auth20ManagerRequest;

@Controller
@RequestMapping("/wechat")
public class WechatAuthenticationController {
	
	private static final Logger logger = LoggerFactory.getLogger(WechatAuthenticationController.class);
	
	/**
	 * 用于微信企业号二次验证
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/auth/info", method=RequestMethod.GET)
	public String getAuthInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		if( logger.isDebugEnabled() ){
			logger.debug( "oauth2.0 code = {}" , code );
			logger.debug( "oauth2.0 state = {}" , state );
		}
		String result = Auth20ManagerRequest.getOAuthUserinfoRequest(code);
		
		if( logger.isDebugEnabled() ){
			logger.debug( "oauth2.0 result = {}" , result );
		}
		return "wechat/auth";
	}
	
	@RequestMapping(value = "/auth/authUrl", method=RequestMethod.GET)
	public void getAuthUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String curUrl = request.getParameter("curUrl");
		boolean fromParam = true;
		if( StringUtils.isEmpty(curUrl) ){
			curUrl = request.getHeader("Referer");
			fromParam = false;
		}
		
		if( logger.isDebugEnabled() ){
			logger.debug( "oauth2.0[authUrl] curUrl = {}" , curUrl );
			logger.debug( "oauth2.0[authUrl] fromParam = {}" , fromParam );
		}

		Assert.notNull(curUrl, "未找到当前请求的URL");
		curUrl = Auth20ManagerRequest.getCodeRequestUrl(curUrl);
		logger.debug( "oauth2.0[authUrl] 附加微信认证信息的URL = {}" , curUrl );
		if( logger.isDebugEnabled() ){
		}
		
		response.sendRedirect(curUrl);
	}
	
	
}
