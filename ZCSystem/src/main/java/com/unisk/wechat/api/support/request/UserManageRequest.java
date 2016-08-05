package com.unisk.wechat.api.support.request;

import com.unisk.wechat.api.support.CommonRequest;
import com.unisk.wechat.api.support.WechatHelper;

/**
 * 微信通讯录管理 之 微信成员管理
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年12月3日
 */
public class UserManageRequest extends CommonRequest {
	/**
	 * 通讯录管理-成员管理--创建成员
	 * 
	 * @param json
	 * @return
	 */
	public static String userCreateRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.userCreate.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 通讯录管理-成员管理--更新成员
	 * 
	 * @param json
	 * @return
	 */
	public static String userUpdateRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.userUpdate.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 通讯录管理-成员管理--删除成员
	 * 
	 * @param id
	 * @return
	 */
	public static String userDeleteRequest(String id) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), id };
		String url = getRequestUrl("wechat.userDelete.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 通讯录管理-成员管理--批量删除成员
	 * 
	 * @param id
	 * @return
	 */
	public static String userBatchDeleteRequest() {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.userBatchDelete.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 通讯录管理-成员管理--获取成员
	 * 
	 * @param id
	 * @return
	 */
	public static String userListRequest(String id) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), id };
		String url = getRequestUrl("wechat.userQuery.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 通讯录管理-成员管理--获取部门成员
	 * 
	 * @param deptId
	 * @param fetchChild
	 * @param status
	 * @return
	 */
	public static String userListByDeptRequest(String deptId, String fetchChild, String status) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), deptId, fetchChild, status };
		String url = getRequestUrl("wechat.userQueryByDept.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 通讯录管理-成员管理--获取部门成员(详情)
	 * 
	 * @param deptId
	 *            获取的部门id
	 * @param fetchChild
	 *            1/0：是否递归获取子部门下面的成员
	 * @param status
	 *            0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加，未填写则默认为4
	 * @return
	 */
	public static String userListDetailByDeptRequest(String deptId, String fetchChild, String status) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), deptId, fetchChild, status };
		String url = getRequestUrl("wechat.userQueryDetailByDept.url", params);
		return sendGetRequest(url);
	}

}
