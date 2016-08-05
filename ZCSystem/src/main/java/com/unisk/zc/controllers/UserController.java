package com.unisk.zc.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.entitys.commons.CommonResBean;
import com.unisk.zc.entitys.commons.ResBean;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.UniskUserService;
import com.unisk.zc.service.UserAndUserGroupService;

@Controller
@RequestMapping(value = { "/ucenter/user" })
public class UserController {

	@Autowired
	UniskUserService userService;
	
	@Autowired
	UserAndUserGroupService ugroupService;
	
	public static final String path = "sys/modules/users/";
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = { "listView" })
	public String listView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") UniskUser user, ModelMap map)
			throws UniskException {
		Page<Map<String, Object>> page = userService.selectMapPage(user);
		// 传递参数
		map.put("page", page);
		return path + "user-list";
	}

	@RequestMapping(value = { "formView" })
	public String formView(@ModelAttribute("user") UniskUser user,HttpServletRequest request, HttpServletResponse response, ModelMap map)
			throws UniskException {
		user = userService.findById( user.getId() );
		if( user != null && user.getId() != null )map.put("user", user);
		return path + "user-form";
	}
	
	@RequestMapping(value = { "modify" })
	public String modify(@ModelAttribute("user") UniskUser user, HttpServletRequest request, HttpServletResponse response, ModelMap map)
			throws UniskException {
		if( user.getId() == null )
			userService.insert(user);
		else 
			userService.update(user);
		map.addAttribute(user);
		return "redirect:/ucenter/user/listView.do";
	}

	@RequestMapping(value = { "delete" })
	@Transactional
	public String delete(HttpServletRequest request, HttpServletResponse response, int id, ModelMap map)
			throws UniskException {
		//删除用户表
		userService.delete(id);
		//删除用户角色-用户关系表
		//删除用户组-用户关系表
		ugroupService.delete(id);
		return "redirect:/ucenter/user/listView.do";
	}
	
	@ResponseBody
	@RequestMapping(value = { "check" })
	public String check(@ModelAttribute("user") UniskUser user, HttpServletRequest request, HttpServletResponse response, ModelMap map)
			throws UniskException {
		boolean flag = userService.checkUsernameIsOnly(user);
		return String.valueOf(!flag);
	}
	
	/**
	 * 
	 * @Description:调转到查看用户页
	 * @author 刘见明
	 * @time:2015年12月31日 下午1:54:55
	 * @param request
	 * @param response
	 * @param id
	 *            参数 用户id
	 * @return
	 * @throws UniskException
	 */
	@RequestMapping(value = { "view" })
	public String view(HttpServletRequest request, HttpServletResponse response, int id, ModelMap map)
			throws UniskException {
		// 获取要更新的user对象
		UniskUser user = userService.findById(id);
		// 增加操作类型
		map.put("operation", "view");
		map.put("user", user);
		return path + "user-form";
	}
	
	@RequestMapping(value = { "forGroupUsersView" })
	public String forGroupUsersView(@ModelAttribute("user") UniskUser user, Integer groupId, HttpServletRequest request, HttpServletResponse response, ModelMap map)
			throws UniskException {
		Map<Object, Object> queryMap = new HashMap<Object, Object>();
		queryMap.put("userGroupId", groupId);
		String sql = "not in ( select USERID from tb_r_user_and_usergroup where USERGROUPID = " + groupId + ")";
		queryMap.put("notinids", sql);
		user.setQueryMap(queryMap);
		Page<Map<String, Object>> page = userService.selectMapPage(user);
		// 传递参数
		map.put("page", page);
		map.put("groupId", groupId);
		return path + "user-group-popupuser-list";
	}

	@RequestMapping(value = { "usubjectview" })
	public String listForUSubjectView(HttpServletRequest request,
			String userRolesId, HttpServletResponse response,
			@ModelAttribute("user") UniskUser user, ModelMap map)
			throws UniskException {
		Map<Object, Object> queryMap = new HashMap<Object, Object>();
		queryMap.put("userrolesid", userRolesId);
		user.setQueryMap(queryMap);
		Page<UniskUser> page = userService.selectRemoveHasChooseUser(user);
		// 传递参数
		map.put("page", page);
		map.put("operation", "usubjectview");
		map.put("name", "userRolesId");
		map.put("id", userRolesId);
		return path + "user-other-list";
	}
}
