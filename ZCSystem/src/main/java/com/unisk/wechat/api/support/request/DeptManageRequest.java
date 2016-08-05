package com.unisk.wechat.api.support.request;

import com.unisk.wechat.api.support.CommonRequest;
import com.unisk.wechat.api.support.WechatHelper;

/**
 * 微信通讯录管理 之部门管理
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年12月3日
 */
public class DeptManageRequest extends CommonRequest {
	/**
	 * 微信通讯录管理 --部门创建
	 * 
	 * @param json
	 * @return
	 */
	public static String deptCreateRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.deptCreate.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 微信通讯录管理 --部门更新
	 * 
	 * @param json
	 * @return
	 */
	public static String deptUpdateRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.deptUpdate.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 微信通讯录管理 --部门删除
	 * 
	 * @param id
	 * @return
	 */
	public static String deptDeleteRequest(String id) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), id };
		String url = getRequestUrl("wechat.deptDelete.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 微信通讯录管理 --获取部门列表
	 * 
	 * @param id
	 * @return
	 */
	public static String deptListRequest(String id) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), id };
		String url = getRequestUrl("wechat.deptQuery.url", params);
		return sendGetRequest(url);
	}

}
