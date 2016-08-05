package com.unisk.zc.core.servlet;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.unisk.zc.core.config.Global;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.utils.SmsSend;

public class SendPhoneCodeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7644019630153450188L;
	
	public static final String VALIDATE_PHONE_CODE = "validatePhoneCode";

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		if (StringUtils.isNotBlank(username) && !SmsSend.isMobileNO(username)) {
			response.getOutputStream().print("false");
		} else {
			doPost(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneCode = SmsSend.randomCode(6);
		String content = MessageFormat.format( Global.getConfig("mobileContent"), phoneCode );
		String username = request.getParameter("username");
		try {
			SmsSend.send(username, content);
			request.getSession().setMaxInactiveInterval( Integer.valueOf( Global.getConfig("MaxInactiveInterval") ) * 60 );
			request.getSession().setAttribute(VALIDATE_PHONE_CODE, phoneCode);
			response.getOutputStream().print("true");
		} catch (UniskException e) {
			e.printStackTrace();
		}
  }
}
