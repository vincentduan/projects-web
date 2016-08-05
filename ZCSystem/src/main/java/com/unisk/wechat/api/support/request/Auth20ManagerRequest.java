package com.unisk.wechat.api.support.request;

import com.unisk.wechat.api.support.CommonRequest;
import com.unisk.wechat.api.support.SystemConfig;
import com.unisk.wechat.api.util.AccessTokenUtil;

/**
 * 
 * @Description:OAuth2.0获取Code 请求处理器
 * @author xuhao
 * @Date 2015年12月3日
 */
public class Auth20ManagerRequest extends CommonRequest {
	/**
	 * OAuth2.0前置请求
	 * 
	 * @param msg
	 * @return
	 */
	public static String getCodeRequestUrl( String redirectUri ) {
		String url = getRequestUrl("wechat.oauth2.0.getCode.url",
			new Object[]{ SystemConfig.getValue("wo.wechat.CorpID")
				,redirectUri
				,"code"
				,"snsapi_base"
				,SystemConfig.getValue("wo.oauth2.0.wechat.state")	
			});
		return url;
	}

	/**
	 * 根据code获取成员信息
	 * 
	 * @param msg
//	 * @return
	 */
	public static String getOAuthUserinfoRequest(String code) {
		String url = getRequestUrl( "wechat.oauth2.0.getUserinfo.url"
			,new Object[]{ 
				AccessTokenUtil.getAccessToken() 
				, code 
			});
		return sendGetRequest(url);
	}

}
