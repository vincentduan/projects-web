/**
 * Copyright &copy; 2012-2013 EMVC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.unisk.zc.core.shiro;

/**
 * 用户和密码（包含验证码）令牌类
 * @author xuhao
 * @version 2015-12-08
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	private String captcha;
	
	private String phoneCode;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, char[] password,
			boolean rememberMe, String host, String captcha, String phoneCode) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
		this.phoneCode = phoneCode;
	}

}