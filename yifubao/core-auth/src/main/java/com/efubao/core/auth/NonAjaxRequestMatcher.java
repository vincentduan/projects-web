/**
 * NonAjaxRequestMatcher.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.core.auth;

import com.efubao.core.auth.util.AjaxUtil;

import org.springframework.security.web.util.RequestMatcher;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * non AJAX request matcher
 *
 */
public class NonAjaxRequestMatcher implements RequestMatcher {
	@Override
	public boolean matches(HttpServletRequest request) {
		return !AjaxUtil.isAjaxRequest(new ServletWebRequest(request));
	}

}
