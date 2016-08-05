package com.unisk.zc.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.entitys.UserGroup;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.UniskUserService;
import com.unisk.zc.service.UserGroupService;

@Controller
@RequestMapping(value = { "/ucenter/usergroup" })
public class UseGroupController {

	@Autowired
	private UserGroupService userGroupService;
	@Autowired
	private UniskUserService userService;

	public static final String path = "sys/modules/usergroup/";

	/**
	 * @Description:获取用户组列表 ，包括分页、模糊查询
	 * @author 刘见明
	 * @time:2015年12月25日 下午2:40:44
	 * @param request
	 * @param response
	 * @param user
	 * @param map
	 * @return
	 * @throws UniskException
	 */
	@RequestMapping(value = { "listView" })
	public String listView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("group") UserGroup group, ModelMap map) 
			throws UniskException {
		
		Page<Map<String, Object>> page = userGroupService.selectMapPage(group);
		
		// 传递参数
		map.put("page", page);
		return path + "usergroup-list";
	}

	/**
	 * 
	 * @Description:调转到增加修改用户组界面
	 * @author 刘见明
	 * @time:2015年12月30日 下午3:55:04
	 * @return 调转到指定页面中
	 * @throws UniskException
	 */
	@RequestMapping(value = { "formView" })
	public String formView(@ModelAttribute("group") UserGroup group,HttpServletRequest request, HttpServletResponse response,  ModelMap map)
			throws UniskException {
		group = userGroupService.findById(group.getId());
		if( group != null && group.getId() != null )map.put("group", group);
		return path + "usergroup-form";
	}

	/**
	 * 
	 * @Description:增加修改用户组
	 * @author 刘见明
	 * @time:2015年12月30日 下午3:56:09
	 * @param request
	 * @param response
	 * @param up
	 * @param map
	 * @return
	 * @throws UniskException
	 */
	@RequestMapping(value = { "modify" })
	public String modify( @ModelAttribute("group") UserGroup group, HttpServletRequest request, HttpServletResponse response,ModelMap map)
			throws UniskException {
		if( group.getId() == null  ){
			userGroupService.insert(group);
		}else{
			userGroupService.update(group);
		}
		return listView(request, response, new UserGroup(), new ModelMap());
	}

	/**
	 * 
	 * @Description:删除用户组
	 * @author 刘见明
	 * @time:2015年12月30日 下午5:23:11
	 * @param request
	 * @param response
	 * @param id
	 * @param map
	 * @return
	 * @throws UniskException
	 */
	@RequestMapping(value = { "delete" })
	public String delete(HttpServletRequest request, HttpServletResponse response, int id, ModelMap map)
			throws UniskException {
		userGroupService.delete(id);
		return listView(request, response, new UserGroup(), new ModelMap());
	}

	/**
	 * 
	 * @Description:用户组添加用户页面，需要得到用户组信息、用户信息
	 * @author 刘见明
	 * @time:2016年1月4日 下午2:30:28
	 * @param id
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws UniskException
	 */
	@RequestMapping(value = { "/groupUsersView" })
	public String groupUsersView(UserGroup userGroup, @ModelAttribute("user") UniskUser user, HttpServletRequest request, HttpServletResponse response,
			ModelMap map) throws UniskException {
		userGroup = userGroupService.findById(userGroup.getId());
		map.put("group", userGroup);
		
		Map queryMap = Maps.newHashMap();
		queryMap.put("usergroupid", userGroup.getId());
		user.setQueryMap(queryMap);
		Page<Map<String, Object>> page = userService.selectMapPage(user);
		map.put("page", page);
		return path + "usergroup-users";
	}
}
