package com.efubao.core.bigc.controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private static final Logger logger = LoggerFactory
			.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryServcie;

	/**
	 * 获取分类列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/categoryList")
	public String categoryList(HttpServletRequest request,
			HttpServletResponse response) {
		Category category = new Category();
		Long parentId = Long
				.parseLong(StringUtils.isNotBlank(request.getParameter("parentId"))
						&& StringUtils.isNumeric(request.getParameter("parentId")) ? request
						.getParameter("parentId") : "0");
		category.setParentId(parentId);
		category.setIsDel(false);
		List<Category> lists = categoryServcie.queryByCondition(category);
		Long parentPId = (long) 0;
		if (parentId != 0) {
			parentPId = categoryServcie.findById(parentId).getParentId();
		}
		request.setAttribute("items", lists);
		request.setAttribute("parentPId", parentPId);
		request.setAttribute("parentId", parentId);
		return "category/categoryList";
	}

	/**
	 * 增加分类
	 *
	 * @param request
	 * @param response
	 * @param attr
	 * @return
	 */
	@RequestMapping("/addCategory")
	public String addCategory(HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes attr) {
		Category category = new Category();
		category.setName(request.getParameter("name"));
		Integer sort = Integer
				.parseInt(StringUtils.isNotBlank(request.getParameter("sort"))
						&& StringUtils.isNumeric(request.getParameter("sort")) ? request
						.getParameter("sort") : "1");
		category.setSort(sort);
		Long parentId = Long
				.parseLong(StringUtils.isNotBlank(request.getParameter("parentId"))
						&& StringUtils.isNumeric(request.getParameter("parentId")) ? request
						.getParameter("parentId") : "0");
		category.setParentId(parentId);
		String levelPath = "";
		if (parentId != 0) {
			levelPath = categoryServcie.findById(parentId).getLevelPath();
			if (!levelPath.isEmpty()) {
				levelPath += ",";
			}
			levelPath += parentId;
		}
		category.setLevelPath(levelPath);
		categoryServcie.save(category);
		attr.addAttribute("parentId", parentId);
		return "redirect:/category/categoryList";
	}

	/**
	 * 搜索
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request,
			HttpServletResponse response) {
		Category category = new Category();
		category.setName(request.getParameter("name"));
		String status = request.getParameter("status");
		if (StringUtils.isNotBlank(status) && StringUtils.isNumeric(status)) {
			category.setStatus(Integer.parseInt(status));
		}
		Long parentId = Long
				.parseLong(StringUtils.isNotBlank(request.getParameter("parentId"))
						&& StringUtils.isNumeric(request.getParameter("parentId")) ? request
						.getParameter("parentId") : "0");
		category.setParentId(parentId);
		category.setIsDel(false);
		List<Category> lists = categoryServcie.queryByCondition(category);
		Long parentPId = (long) 0;
		if (parentId != 0) {
			parentPId = categoryServcie.findById(parentId).getParentId();
		}
		request.setAttribute("parentPId", parentPId);
		request.setAttribute("parentId", parentId);
		request.setAttribute("items", lists);
		return "category/categoryList";
	}

	/**
	 * 停用/启用分类
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/changeStatus")
	public String changeStatus(@RequestParam("id") String id,
			HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes attr) {
		Category category = new Category();
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			category.setId(Long.parseLong(id));
		}else{
			//报错
		}
		String status = request.getParameter("status");
		if (StringUtils.isNotBlank(status) && StringUtils.isNumeric(status)) {
			category.setStatus(Integer.parseInt(status));
		}
		categoryServcie.update(category);
		Long parentId = Long
				.parseLong(StringUtils.isNotBlank(request.getParameter("parentId"))
						&& StringUtils.isNumeric(request.getParameter("parentId")) ? request
						.getParameter("parentId") : "0");
		attr.addAttribute("parentId", parentId);
		return "redirect:/category/categoryList";
	}

	/**
	 * 删除属性
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attr) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			Category category = new Category();
			category.setId(Long.parseLong(id));
			category.setIsDel(true);
			categoryServcie.update(category);
		}else{
			//报错
		}
		Long parentId = Long
				.parseLong(StringUtils.isNotBlank(request.getParameter("parentId"))
						&& StringUtils.isNumeric(request.getParameter("parentId")) ? request
						.getParameter("parentId") : "0");
		attr.addAttribute("parentId", parentId);
		return "redirect:/category/categoryList";
	}

}
