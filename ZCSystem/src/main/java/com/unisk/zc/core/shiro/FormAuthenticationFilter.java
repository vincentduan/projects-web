/**
 * Copyright &copy; 2012-2013 EMVC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.unisk.zc.core.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

/**
 * 表单验证（包含验证码）过滤类
 * @author xuhao
 * @version 2015-12-08
 */
@Service
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	public static final String DEFAULT_CAPTCHA_PARAM = "validateCode";
	public static final String DEFAULT_PHONECODE_PARAM = "phonecode";


	public String getCaptchaParam() {
		return DEFAULT_CAPTCHA_PARAM;
	}
	
	public String getPhoneCodeParam(){
		return DEFAULT_PHONECODE_PARAM;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}
	
	protected String getPhoneCode(ServletRequest request){
		return WebUtils.getCleanParam(request, getPhoneCodeParam());
	}

	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		if (password==null){
			password = "";
		}
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		String captcha = getCaptcha(request);
		String phonecode = getPhoneCode(request);
		return new UsernamePasswordToken(username, password.toCharArray(), rememberMe, host, captcha, phonecode);
	}

}