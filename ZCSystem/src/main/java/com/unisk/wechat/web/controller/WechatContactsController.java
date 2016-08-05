package com.unisk.wechat.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unisk.wechat.api.support.request.DeptManageRequest;
import com.unisk.wechat.api.support.request.TagManageRequest;
import com.unisk.wechat.api.support.request.UserManageRequest;
import com.unisk.wechat.api.util.JsonUtil;

@Controller
@RequestMapping("/wechat")
public class WechatContactsController {
	/**
	 * http://localhost:8888/uniskzhongchou/wechat/dept/create.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dept/create", produces = { "application/json;charset=UTF-8" })
	public String deptCreate() {
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("name", "沃众筹测试小组一");// 部门名称
		dept.put("parentid", "1");// 父亲部门id。根部门id为1
		dept.put("order", "1");// 在父部门中的次序值。order值小的排序靠前。
		dept.put("id", 2);// 部门id，整型。指定时必须大于1，不指定时则自动生成
		String result = DeptManageRequest.deptCreateRequest(JsonUtil.toJson(dept));
		return result;
	}

	/**
	 * http://localhost:8888/uniskzhongchou/wechat/dept/update.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dept/update", produces = { "application/json;charset=UTF-8" })
	public String deptUpdate() {
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("name", "沃众筹测试小组(测试部门修改接口)");// 部门名称
		dept.put("parentid", "1");// 父亲部门id。根部门id为1
		dept.put("order", "1");// 在父部门中的次序值。order值小的排序靠前。
		dept.put("id", 2);// 部门id，整型。指定时必须大于1，不指定时则自动生成
		String result = DeptManageRequest.deptUpdateRequest(JsonUtil.toJson(dept));
		return result;
	}

	/**
	 * http://localhost:8888/uniskzhongchou/wechat/dept/delete.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dept/delete", produces = { "application/json;charset=UTF-8" })
	public String deptDelete() {
		String result = DeptManageRequest.deptDeleteRequest("2");
		return result;
	}

	/**
	 * http://localhost:8888/uniskzhongchou/wechat/dept/list.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dept/list", produces = { "application/json;charset=UTF-8" })
	public String deptList() {
		String result = DeptManageRequest.deptListRequest("0");
		return result;
	}

	/**
	 * http://localhost:8888/uniskzhongchou/wechat/user/create.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/create", produces = { "application/json;charset=UTF-8" })
	public String userCreate() {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("userid", "zhangsan"); // 成员UserID。对应管理端的帐号，企业内必须唯一。长度为1~64个字节
		user.put("name", "张三"); // 成员名称。长度为1~64个字节
		List<Integer> deptList = new ArrayList<Integer>();
		deptList.add(2);
		user.put("department", deptList); // 成员所属部门id列表。注意，每个部门的直属成员上限为1000个
		user.put("position", "码农");
		user.put("mobile", "18609102332");// 手机号码。企业内必须唯一，mobile/weixinid/email三者不能同时为空
		user.put("gender", "1"); // 性别。1表示男性，2表示女性
		user.put("email", "zhangsan@gzdev.com"); // 邮箱。长度为0~64个字节。企业内必须唯一
		user.put("weixinid", "zhangsan4dev"); // 微信号。企业内必须唯一。（注意：是微信号，不是微信的名字）
		// user.put("avatar_mediaid", ""); // 成员头像的mediaid，通过多媒体接口上传图片获得的mediaid
		// user.put("extattr", ""); // 扩展属性。扩展属性需要在WEB管理端创建后才生效，否则忽略未知属性的赋值
		String result = UserManageRequest.userCreateRequest(JsonUtil.toJson(user));
		return result;
	}

	/**
	 * http://localhost:8888/uniskzhongchou/wechat/user/update.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/update", produces = { "application/json;charset=UTF-8" })
	public String userUpdate() {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("userid", "zhangsan"); // 成员UserID。对应管理端的帐号，企业内必须唯一。长度为1~64个字节
		user.put("name", "李四"); // 成员名称。长度为1~64个字节
		List<Integer> deptList = new ArrayList<Integer>();
		deptList.add(2);
		user.put("department", deptList); // 成员所属部门id列表。注意，每个部门的直属成员上限为1000个
		user.put("position", "Java开发工程师");
		user.put("mobile", "18609102332");// 手机号码。企业内必须唯一，mobile/weixinid/email三者不能同时为空
		user.put("gender", "1"); // 性别。1表示男性，2表示女性
		user.put("email", "zhangsan@gzdev.com"); // 邮箱。长度为0~64个字节。企业内必须唯一
		user.put("weixinid", "zhangsan4dev"); // 微信号。企业内必须唯一。（注意：是微信号，不是微信的名字）
		// user.put("avatar_mediaid", ""); // 成员头像的mediaid，通过多媒体接口上传图片获得的mediaid
		// user.put("extattr", ""); // 扩展属性。扩展属性需要在WEB管理端创建后才生效，否则忽略未知属性的赋值
		String result = UserManageRequest.userUpdateRequest(JsonUtil.toJson(user));
		return result;
	}

	/**
	 * http://localhost:8888/uniskzhongchou/wechat/user/list.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/list", produces = { "application/json;charset=UTF-8" })
	public String userList(@RequestParam(value = "userId", required = true) String userId) {
		String result = UserManageRequest.userListRequest(userId);
		return result;
	}

	/**
	 * 获取部门成员 http://localhost:8888/uniskzhongchou/wechat/user/listByDept.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/listByDept", produces = { "application/json;charset=UTF-8" })
	public String userListByDept(@RequestParam(value = "deptId", required = true) String deptId, @RequestParam(value = "fetchChild", required = false, defaultValue = "1") String fetchChild,
			@RequestParam(value = "status", required = false, defaultValue = "1") String status) {
		String result = UserManageRequest.userListByDeptRequest(deptId, fetchChild, status);
		return result;
	}

	/**
	 * 获取部门成员 http://localhost:8888/uniskzhongchou/wechat/user/listDetailByDept.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/listDetailByDept", produces = { "application/json;charset=UTF-8" })
	public String userListDetailByDept(@RequestParam(value = "deptId", required = true) String deptId,
			@RequestParam(value = "fetchChild", required = false, defaultValue = "1") String fetchChild, @RequestParam(value = "status", required = false, defaultValue = "1") String status) {
		String result = UserManageRequest.userListDetailByDeptRequest(deptId, fetchChild, status);
		return result;
	}

	/**
	 * http://localhost:8888/uniskzhongchou/wechat/tag/create.do
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/tag/create", produces = { "application/json;charset=UTF-8" })
	public String tagCreate() {
		Map<String, Object> tag = new HashMap<String, Object>();
		tag.put("tagname", "测试标签创建接口");
		tag.put("tagid", "1");
		String result = TagManageRequest.tagCreateRequest(JsonUtil.toJson(tag));
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/tag/update", produces = { "application/json;charset=UTF-8" })
	public String tagUpdate() {
		Map<String, Object> tag = new HashMap<String, Object>();
		tag.put("tagname", "测试标签创建接口(修改)");
		tag.put("tagid", "1");
		String result = TagManageRequest.tagUpdateRequest(JsonUtil.toJson(tag));
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/tag/delete", produces = { "application/json;charset=UTF-8" })
	public String tagDelete(@RequestParam(value = "tagId", required = true) String tagId) {
		String result = TagManageRequest.tagDeleteRequest(tagId);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/tag/addUser", produces = { "application/json;charset=UTF-8" })
	public String tagAddUser() {
		Map<String, Object> tag = new HashMap<String, Object>();
		tag.put("tagid", "1");
		List<String> userList = new ArrayList<String>();
		userList.add("zhangsan");
		tag.put("userlist", userList);
		List<String> partylist = new ArrayList<String>();
		partylist.add("2");
		tag.put("partylist", partylist);
		String result = TagManageRequest.tagAddUserRequest(JsonUtil.toJson(tag));
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/tag/getUser", produces = { "application/json;charset=UTF-8" })
	public String tagGetUser(@RequestParam(value = "tagId", required = true) String tagId) {
		String result = TagManageRequest.tagListRequest(tagId);
		return result;
	}

}
