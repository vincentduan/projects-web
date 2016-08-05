package com.unisk.wechat.api.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unisk.wechat.api.official.sdk.WXBizMsgCrypt;
import com.unisk.wechat.api.util.AccessTokenUtil;
import com.unisk.wechat.api.util.RandomStrUtil;
import com.unisk.wechat.api.util.SpringUtils;

public class WechatHelper {
	private static final Logger logger = LoggerFactory.getLogger(WechatHelper.class);

	public static final String NOTICE_AGENT_ID = "wzc.notice.wechat.agentId";

	public static final String VOTE_AGENT_ID = "wzc.vote.wechat.agentId";

	/**
	 * 获取沃众筹应用凭证
	 * 
	 * @return
	 */
	public static WXBizMsgCrypt getWXBizMsgCrypt(String beanName) {
		return (WXBizMsgCrypt) SpringUtils.getBean(beanName);
	}

	public static String getCorpID() {
		return SystemConfig.getValue("wo.wechat.CorpID");
	}

	public static String getEncodingAESKey(String encodingAESKey) {
		return SystemConfig.getValue(encodingAESKey);
	}

	public static String getToken(String token) {
		return SystemConfig.getValue(token);
	}

	public static String getSecret() {
		return SystemConfig.getValue("wo.wechat.wozhongchou.secret");
	}

	public static String getContextUrl() {
		return SystemConfig.getValue("unisk.project.rootUrl");
	}

	public static String getAccessToken() {
		return AccessTokenUtil.getAccessToken();
	}

	public static String getWoAgentId(String agentIdKey) {
		return SystemConfig.getValue(agentIdKey);
	}

	/**
	 * 生成长度15的随机数
	 * 
	 * @return
	 */
	public static String getNonce() {
		String nonce = RandomStrUtil.randomStr(15);
		if (logger.isDebugEnabled()) {
			logger.debug("the generate random nonce string is {}", nonce);
		}
		return nonce;
	}

	public static long getTimestamp() {
		return System.currentTimeMillis();
	}
}
