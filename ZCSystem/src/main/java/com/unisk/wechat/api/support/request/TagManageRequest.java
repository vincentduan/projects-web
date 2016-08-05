package com.unisk.wechat.api.support.request;

import com.unisk.wechat.api.support.CommonRequest;
import com.unisk.wechat.api.support.WechatHelper;

/**
 * 微信通讯录管理 之tag标签管理
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年12月3日
 */
public class TagManageRequest extends CommonRequest {
	/**
	 * 通讯录管理-标签管理--创建标签
	 * 
	 * @param json
	 * @return
	 */
	public static String tagCreateRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.tagCreate.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 通讯录管理-标签管理--更新标签
	 * 
	 * @param json
	 * @return
	 */
	public static String tagUpdateRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.tagUpdate.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 通讯录管理-标签管理--删除标签
	 * 
	 * @param tagId
	 * @return
	 */
	public static String tagDeleteRequest(String tagId) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), tagId };
		String url = getRequestUrl("wechat.tagDelete.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 通讯录管理-标签管理--获取标签成员
	 * 
	 * @param tagId
	 * @return
	 */
	public static String tagListRequest(String tagId) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), tagId };
		String url = getRequestUrl("wechat.tagQuery.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 通讯录管理-标签管理--增加标签成员
	 * 
	 * @param id
	 * @return
	 */
	public static String tagAddUserRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.tagAddUser.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 通讯录管理-标签管理--删除标签成员
	 * 
	 * @param id
	 * @return
	 */
	public static String tagDeleteUserRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.tagDeleteUser.url", params);
		return sendPostRequest(url, json);
	}
}
