package com.unisk.wechat.api.support.request;

import java.io.File;

import com.unisk.wechat.api.support.CommonRequest;
import com.unisk.wechat.api.support.WechatHelper;

/**
 * 
 * Title:微信接口 之 管理素材文件 <br>
 * Description:用于调用微信接口，上传素材、获取素材列表等 <br>
 * Date: 2016年1月20日 <br>
 * 
 * @author bang
 */
public class UploadMaterialRequest extends CommonRequest {

	public static String DEFAULT_PARAM_NAME = "media";

	/**
	 * 管理素材文件--上传临时素材文件
	 * 
	 * @param type
	 * @param fileName
	 * @param file
	 * @return
	 * @author bang
	 */
	public static String uploadTempMaterialRequest(String type, String fileName, File file) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), type };
		String url = getRequestUrl("wechat.uploadTempMaterial.url", params);
		return sendPostUpload(DEFAULT_PARAM_NAME, url, fileName, file);
	}

	/**
	 * 管理素材文件--获取临时素材文件
	 * 
	 * @param mediaId 媒体文件id
	 * @return
	 * @author bang
	 */
	public static String getTempMaterialRequest(String mediaId) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), mediaId };
		String url = getRequestUrl("wechat.getTempMaterial.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 管理素材文件--上传永久图文素材
	 * 
	 * @param json json格式内容 参考官网接口文档 (http://qydev.weixin.qq.com/wiki/index.php?title=上传永久素材)
	 * @return
	 * @author bang
	 */
	public static String uploadPermanentMpnewsMaterialRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.uploadPermanentMpnewsMaterial.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 管理素材文件--上传其他类型永久素材
	 * 
	 * @param agentId 微信应用ID
	 * @param type 上传的媒体文件类型
	 * @param fileName 文件名称
	 * @param file 要上传的文件
	 * @return
	 * @author bang
	 */
	public static String uploadPermanentOthersMaterialRequest(String agentId, String type, String fileName, File file) {
		Object[] params = new Object[] { agentId, type, WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.uploadPermanentOthersMaterial.url", params);
		return sendPostUpload(DEFAULT_PARAM_NAME, url, fileName, file);
	}

	/**
	 * 管理素材文件--获取永久素材
	 * 
	 * @param mediaId 媒体文件id
	 * @param agentId 微信应用id
	 * @return
	 * @author bang
	 */
	public static String getPermanentMaterialRequest(String mediaId, String agentId) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), mediaId, agentId };
		String url = getRequestUrl("wechat.getPermanentMaterial.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 管理素材文件--删除永久素材
	 * 
	 * @param mediaId 媒体文件id
	 * @param agentId 微信应用id
	 * @return
	 * @author bang
	 */
	public static String deletePermanentMaterialRequest(String mediaId, String agentId) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), agentId, mediaId };
		String url = getRequestUrl("wechat.deletePermanentMaterial.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 管理素材文件--修改永久素材
	 * 
	 * @param json 要修改的图文消息内容(http://qydev.weixin.qq.com/wiki/index.php?title=修改永久图文素材)
	 * @return
	 * @author bang
	 */
	public static String updatePermanentMaterialRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.updatePermanentMaterial.url", params);
		return sendPostRequest(url, json);
	}

	/**
	 * 管理素材文件--获取素材总数
	 * 
	 * @param agentId 微信应用ID
	 * @return
	 * @author bang
	 */
	public static String getCountMaterialRequest(String agentId) {
		Object[] params = new Object[] { WechatHelper.getAccessToken(), agentId };
		String url = getRequestUrl("wechat.getCountMaterial.url", params);
		return sendGetRequest(url);
	}

	/**
	 * 管理素材文件--获取素材列表
	 * 
	 * @param json 参见官网接口说明(http://qydev.weixin.qq.com/wiki/index.php?title=获取素材列表)
	 * @return
	 * @author bang
	 */
	public static String batchgetMaterialRequest(String json) {
		Object[] params = new Object[] { WechatHelper.getAccessToken() };
		String url = getRequestUrl("wechat.batchgetMaterial.url", params);
		return sendPostRequest(url, json);
	}

}
