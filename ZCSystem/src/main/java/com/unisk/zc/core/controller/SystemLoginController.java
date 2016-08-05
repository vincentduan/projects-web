package com.unisk.zc.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.unisk.zc.core.config.Global;
import com.unisk.zc.core.utils.CookieUtils;
import com.unisk.zc.core.utils.LoginCookieUtils;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.utils.springs.UniskPropertyPlaceHolder;

@Controller
@RequestMapping(value={"/"})
public class SystemLoginController {

	private static final Logger logger = LoggerFactory.getLogger(SystemLoginController.class);
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		UniskUser user = UserUtils.getUser();
		CookieUtils.setCookie(response, "theme", Global.getThemeDefault());
		if (user != null && user.getId() != null) {
			return "redirect:" + Global.getAdminPath();
		}
		return "/sys/layout/sysLogin";
	}

	@RequestMapping(value = { "login" }, method = { RequestMethod.POST })
	public String login(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 判断登录是否失败
		String exceptionClassName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if (logger.isDebugEnabled()) {
			logger.debug("登录认证失败，失败异常:{}", exceptionClassName);
		}
		if (StringUtils.isNotBlank(exceptionClassName)) {
			request.setAttribute("errorMsg", UniskPropertyPlaceHolder.getProperty(exceptionClassName, "登录异常,请联系管理员！"));
			model.addAttribute("username", username);
			model.addAttribute("isValtidaeCodeLogin", Boolean.valueOf(LoginCookieUtils.isValidateCodeLogin(username, true, false)));
			return "/sys/layout/sysLogin";
		}
		// 认证成功，跳转首页
		return "redirect:" + Global.getAdminPath();
	}

}
