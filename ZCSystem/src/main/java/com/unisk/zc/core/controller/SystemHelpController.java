package com.unisk.zc.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/"})
public class SystemHelpController {

	@RequestMapping(value={"help"})
	public String help(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		return "sys/layout/help";
	}

}
