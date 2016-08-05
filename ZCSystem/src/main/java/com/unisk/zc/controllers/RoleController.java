package com.unisk.zc.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.JsonUtil;
import com.unisk.zc.entitys.Roles;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.RolesService;

/**
 * 角色管理控制器
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年12月25日
 */
@Controller
@RequestMapping(value = { "/ucenter/role" })
public class RoleController {

	private static final Logger logger = LoggerFactory.getLogger(Logger.class);

	public static final String SUFFIX = "sys/modules/roles/";

	@Autowired
	RolesService rolesService;

	/**
	 * 跳转角色管理首页
	 * 
	 * @return
	 */
	@RequestMapping("/mainView")
	public String mainView() {
		return SUFFIX + "role-main";
	}

	/**
	 * 跳转角色管理新增、编辑、查看页面
	 * 
	 * @return
	 * @throws UniskException
	 * @throws NumberFormatException
	 */
	@RequestMapping("/editView")
	public String editView(@RequestParam(value = "id", required = false) String roleId, HttpServletRequest request,
			HttpServletResponse response, ModelMap map) throws NumberFormatException, UniskException {
		Roles roles = rolesService.findById(Integer.valueOf(roleId));
		map.put("roles", roles);
		return SUFFIX + "role-form";
	}

	@RequestMapping("/addView")
	public String addView(Roles roles, HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		return SUFFIX + "role-form";
	}

	/**
	 * 查询展示角色列表
	 * 
	 * @param roles
	 * @param request
	 * @return
	 * @throws UniskException
	 */
	@RequestMapping("/listView")
	public String listView(Roles roles, HttpServletRequest request, HttpServletResponse response, ModelMap map) throws UniskException {
		Page<Map<String,Object>> page = rolesService.selectMapPage(roles);
		map.put("page", page);
		return SUFFIX + "role-list";
	}

	@RequestMapping("/delete")
	public String delete(Roles roles, HttpServletRequest request, HttpServletResponse response, ModelMap map) throws UniskException {
		rolesService.delete(roles.getId());
		return SUFFIX + "role-main";
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Roles roles, HttpServletRequest request, HttpServletResponse response, ModelMap map) throws UniskException {
		rolesService.insert(roles);
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "0");
		result.put("msg", "操作成功！");
		return JsonUtil.toJson(result);
	}

	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Roles roles) throws UniskException {
		rolesService.update(roles);
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "0");
		result.put("msg", "操作成功！");
		return JsonUtil.toJson(result);
	}

}
