package com.unisk.zc.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unisk.wechat.api.support.request.DeptManageRequest;
import com.unisk.wechat.api.support.request.TagManageRequest;
import com.unisk.wechat.api.support.request.UserManageRequest;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.Department;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.entitys.UserGroup;
import com.unisk.zc.entitys.commons.CommonResBean;
import com.unisk.zc.entitys.commons.ResBean;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.DepartmentService;
import com.unisk.zc.service.UniskUserService;
import com.unisk.zc.service.UserGroupService;
import com.unisk.zc.utils.Constant;

@Controller
@RequestMapping(value={"/ucenter/sync"})
public class WechatSyscController {
	
	private static final String FLAG_USER = "user";
	private static final String FLAG_DEPT = "dept";
	private static final String FLAG_GROUP = "group";

	@Autowired
	private UniskUserService userService;
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private UserGroupService groupService;
	
	@ResponseBody
	@RequestMapping(value={"/syncWechat"})
	public ResBean syncWechat(String flag, Integer id,  HttpServletRequest request,HttpServletResponse response) throws UniskException{
		CommonResBean resBean = new CommonResBean();
		
		String retJsonStr = null;
		if( StringUtils.equalsIgnoreCase(flag, FLAG_USER)){
			UniskUser user = userService.findById(id);
			if( user == null) {
				resBean.setStatus("1");
				resBean.setReset(Constant.FAILURE_CODE);
				resBean.setDesc(Constant.FAILURE_DESC);
				return resBean;
			}
			if( user.getWechatstatus() == 0 ){
				JSONObject json = new JSONObject();
				json.put("userid", String.valueOf(user.getUsername()));
				json.put("name", user.getRealname());
				JSONArray deptArray = new JSONArray();
				deptArray.put(String.valueOf(user.getDeptid()));
				json.put("department", deptArray.toString());
				json.put("position", user.getTitle());
				json.put("mobile", user.getPhone());
				json.put("gender", user.getSex() == 0 ? "2" : "1");
				json.put("email", user.getEmail());
				retJsonStr = UserManageRequest.userCreateRequest(json.toString());
				//添加成功,状态1
				updateUniskUser(user,retJsonStr,1);
			}
			if( user.getWechatstatus() == 2 ){
				JSONObject json = new JSONObject();
				json.put("userid", String.valueOf(user.getUsername()));
				json.put("name", user.getRealname());
				JSONArray deptArray = new JSONArray();
				deptArray.put(String.valueOf(user.getDeptid()));
				json.put("department", deptArray.toString());
				json.put("position", user.getTitle());
				json.put("mobile", user.getPhone());
				json.put("gender", user.getSex() == 0 ? "2" : "1");
				json.put("email", user.getEmail());
				retJsonStr = UserManageRequest.userUpdateRequest(json.toString());
				//更新成功,状态3
				updateUniskUser(user,retJsonStr,3);
			}
		}
		
		if( StringUtils.equalsIgnoreCase(flag, FLAG_DEPT)){
			Department dept = deptService.findById(id);
			if( dept == null) {
				resBean.setStatus("1");
				resBean.setReset(Constant.FAILURE_CODE);
				resBean.setDesc(Constant.FAILURE_DESC);
				return resBean;
			}
			if( dept.getWechatstatus() == 0 ){
				JSONObject json = new JSONObject();
				json.put("name", dept.getDeptname());
				json.put("parentid", dept.getParentid());
				json.put("order", dept.getSortcode());
				json.put("id", dept.getId());
				retJsonStr = DeptManageRequest.deptCreateRequest(json.toString());
				//添加成功,状态1
				updateDept(dept,retJsonStr,1);
			}
			if( dept.getWechatstatus() == 2 ){
				JSONObject json = new JSONObject();
				json.put("name", dept.getDeptname());
				json.put("parentid", dept.getParentid());
				json.put("order", dept.getSortcode());
				json.put("id", dept.getId());
				retJsonStr = DeptManageRequest.deptUpdateRequest(json.toString());
				//更新成功,状态3
				updateDept(dept,retJsonStr,3);
			}
		}
		
		if( StringUtils.equalsIgnoreCase(flag, FLAG_GROUP)){
			UserGroup group = groupService.findById(id);
			if( group == null) {
				resBean.setStatus("1");
				resBean.setReset(Constant.FAILURE_CODE);
				resBean.setDesc(Constant.FAILURE_DESC);
				return resBean;
			}
			if( group.getWechatstatus() == 0 ){
				JSONObject json = new JSONObject();
				json.put("tagname", group.getGroupname());
				json.put("tagid", group.getId());
				retJsonStr = TagManageRequest.tagCreateRequest(json.toString());
				//添加成功,状态1
				updateGroup(group,retJsonStr,1);
			}
			if( group.getWechatstatus() == 2 ){
				JSONObject json = new JSONObject();
				json.put("tagname", group.getGroupname());
				json.put("tagid", group.getId());
				retJsonStr = TagManageRequest.tagUpdateRequest(json.toString());
				//更新成功,状态3
				updateGroup(group,retJsonStr,3);
			}
		}
		
		return resBean;
	}
	
	private ResBean updateGroup(UserGroup group, String retJsonStr, int status) throws UniskException {
		JSONObject retJson = JSONObject.fromString(retJsonStr);
		CommonResBean resBean = new CommonResBean();
		UniskUser loginUser = UserUtils.getUser();
		if( retJson.getInt("errcode") == 0 ){
			group.setWechatstatus(status);
			group.setModifytime(new Date());
			if( loginUser != null && loginUser.getId()!=null ) group.setModifyuserid(loginUser.getId());
			groupService.updateNoSync(group);
		}else{
			resBean.setStatus("1");
			resBean.setReset(Constant.FAILURE_CODE);
			resBean.setDesc(retJson.getString("errmsg"));
		}
		return resBean;
		
	}

	private ResBean updateDept(Department dept, String retJsonStr, int status) throws UniskException {
		JSONObject retJson = JSONObject.fromString(retJsonStr);
		CommonResBean resBean = new CommonResBean();
		UniskUser loginUser = UserUtils.getUser();
		if( retJson.getInt("errcode") == 0 ){
			dept.setWechatstatus(status);
			dept.setModifytime(new Date());
			if( loginUser != null && loginUser.getId()!=null ) dept.setModifyuserid(loginUser.getId());
			deptService.updateNoSync(dept);
		}else{
			resBean.setStatus("1");
			resBean.setReset(Constant.FAILURE_CODE);
			resBean.setDesc(retJson.getString("errmsg"));
		}
		return resBean;
	}

	private ResBean updateUniskUser(UniskUser user, String retJsonStr,Integer status) throws UniskException{
		JSONObject retJson = JSONObject.fromString(retJsonStr);
		CommonResBean resBean = new CommonResBean();
		UniskUser loginUser = UserUtils.getUser();
		if( retJson.getInt("errcode") == 0 ){
			user.setWechatstatus(status);
			user.setModifytime(new Date());
			if( loginUser != null && loginUser.getId()!=null ) user.setModifyuserid(loginUser.getId());
			userService.updateNoSync(user);
		}else{
			resBean.setStatus("1");
			resBean.setReset(Constant.FAILURE_CODE);
			resBean.setDesc(retJson.getString("errmsg"));
		}
		return resBean;
	}
	
}
