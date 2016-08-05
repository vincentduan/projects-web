/**
 * MyTokenBasedRememberMeServices.java
 * Copyright (c) 2013 by lashou.com
 */
package com.efubao.core.auth.rememberme;

import com.efubao.core.auth.util.AuthUtil;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class LashouTokenBasedRememberMeServices extends TokenBasedRememberMeServices {
	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices#rememberMeRequested(javax.servlet.http.HttpServletRequest, java.lang.String)
	 */
	@Override
	protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
		Boolean rememberme = (Boolean) request.getAttribute(AuthUtil.PARAMETER_REMEMBERME);
		return rememberme == null? false: rememberme;
	}
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		super.logout(request, response, authentication);
		// 清除全部cookie
		for (Cookie cookie : request.getCookies()) {
			cookie.setValue(null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}

}
