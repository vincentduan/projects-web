package com.efubao.core.bigc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.service.CategoryService;


/**
 */
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private CategoryService categoryService;

    /**
     * 网站首页入口
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
    	Category categoryTmp = new Category();
		categoryTmp.setIsDel(false);
		categoryTmp.setStatus(1);
		List<Category> categorys = categoryService.queryByCondition(categoryTmp);
    	request.setAttribute("categorys", categorys);
        return "index";
    }

}
