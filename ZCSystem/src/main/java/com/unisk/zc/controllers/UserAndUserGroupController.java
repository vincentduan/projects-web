package com.unisk.zc.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.unisk.wechat.api.support.request.TagManageRequest;
import com.unisk.zc.entitys.UserAndUserGroup;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.UserAndUserGroupService;

/**
 * 
 * @Description:用户组-用户控制器
 * @author 刘见明
 * @copyright 联通时科(北京)信息技术有限公司
 * @time:2016年1月5日 下午2:35:18
 */
@Controller
@RequestMapping(value = { "/ucenter/userandgroup" })
public class UserAndUserGroupController {

	private static final Logger logger = LoggerFactory.getLogger(Logger.class);

	public static final String path = "sys/modules/usergroup/";

	@Autowired
	private UserAndUserGroupService userAndUserGroupService;

	@RequestMapping(value = "/add")
	public String add(UserAndUserGroup userGroup, String uids, String unames,HttpServletRequest request, HttpServletResponse response, ModelMap map) 
			throws UniskException {
		userAndUserGroupService.modifyUserAndUserGroup(userGroup,uids,unames);
		
		return "redirect:/ucenter/usergroup/groupUsersView.do?id=" + userGroup.getUsergroupid();
	}

	@RequestMapping(value = { "delete" })
	public String delete(HttpServletRequest request,HttpServletResponse response, UserAndUserGroup userAndUserGroup, ModelMap map)
			throws UniskException {
		userAndUserGroupService.delete( userAndUserGroup );
		return "redirect:/ucenter/usergroup/groupUsersView.do?id=" + userAndUserGroup.getUsergroupid();
	}
}
