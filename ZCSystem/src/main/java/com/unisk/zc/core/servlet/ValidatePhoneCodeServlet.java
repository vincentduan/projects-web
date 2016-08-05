package com.unisk.zc.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class ValidatePhoneCodeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4543277119782980941L;
	
	public static final String VALIDATE_PHONE_CODE = "validatePhoneCode";

	public void destroy() {
		super.destroy();
	}

	public static boolean validate(HttpServletRequest request,String validateCode) {
		String code = (String) request.getSession().getAttribute(VALIDATE_PHONE_CODE);
		return validateCode.toUpperCase().equals(code);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String validateCode = request.getParameter("phonecode");
		if (StringUtils.isNotBlank(validateCode)) {
			response.getOutputStream().print( validate(request, validateCode) ? "true" : "false" );
		} else {
			doPost(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(1111);
	}
}
