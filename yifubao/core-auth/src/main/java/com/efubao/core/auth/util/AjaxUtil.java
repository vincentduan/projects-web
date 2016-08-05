/**
 * AjaxUtil.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.core.auth.util;

import org.springframework.web.context.request.WebRequest;

/**
 * Spring MVC AJAX util
 * 
 */
public final class AjaxUtil {
	/**
	 * is AJAX
	 * @param webRequest http request
	 * @return true, only the requet header has X-Requested-With attribute;
	 * 		false, others
	 */
	public static boolean isAjaxRequest(WebRequest webRequest) {
		String requestedWith = webRequest.getHeader("X-Requested-With");
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}

	/**
	 * is AJAX upload request
	 * @param webRequest 
	 * @return
	 */
	public static boolean isAjaxUploadRequest(WebRequest webRequest) {
		return webRequest.getParameter("ajaxUpload") != null;
	}

	/**
	 * 
	 */
	private AjaxUtil() {
	}
}
