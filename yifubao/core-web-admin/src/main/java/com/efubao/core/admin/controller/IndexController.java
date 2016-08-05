package com.efubao.core.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.efubao.core.admin.controller.common.AbstractController;

/**
 */
@Controller
@RequestMapping("/")
public class IndexController {


    /**
     * 网站首页入口
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return "index";
    }

}
