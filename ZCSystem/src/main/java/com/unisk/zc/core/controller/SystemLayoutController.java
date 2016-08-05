package com.unisk.zc.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unisk.zc.core.config.Global;
import com.unisk.zc.core.utils.CookieUtils;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.UniskUser;

@Controller
@RequestMapping(value={"/"})
public class SystemLayoutController {
	
	private static final Logger logger = LoggerFactory.getLogger(SystemLoginController.class);
	
	@RequestMapping(value={"index"})
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap map){
//		UniskUser user = UserUtils.getUser();
//		CookieUtils.setCookie(response, "theme", Global.getThemeDefault());
//		if (user == null || user.getId() == null) {
//			return "sys/layout/sysLogin";
//		}
		return "sys/layout/sysIndex";
	}
	
	@RequestMapping(value={"menu"})
	public String menu(HttpServletRequest request, HttpServletResponse response, ModelMap map){
		return "sys/layout/menuTree";
	}
	
	@RequestMapping(value={"map"})
	public String defaultMap(HttpServletRequest request, HttpServletResponse response, ModelMap map){
		return "sys/layout/indexMap";
	}
}
