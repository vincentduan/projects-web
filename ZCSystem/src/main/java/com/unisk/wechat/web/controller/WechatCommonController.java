package com.unisk.wechat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wechat")
public class WechatCommonController {

	@RequestMapping("/help")
	public String toWechatHelpPage() {
		return "/wechat/wechat-help";
	}
}
