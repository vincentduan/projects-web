package com.unisk.wechat.api.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import com.unisk.wechat.api.official.sdk.WXBizMsgCrypt;

/**
 * 
 * @Description:微信企业号应用 凭证 提供者 工厂Bean
 * @author shijingbang
 * @Date 2015年12月2日
 */
public class WXBizMsgCryptProvider implements FactoryBean<WXBizMsgCrypt> {

	private static final Logger logger = LoggerFactory.getLogger(WXBizMsgCryptProvider.class);
	private String sToken;
	private String sEncodingAESKey;
	private String sCorpID;

	public String getsToken() {
		return sToken;
	}

	public void setsToken(String sToken) {
		this.sToken = sToken;
	}

	public String getsEncodingAESKey() {
		return sEncodingAESKey;
	}

	public void setsEncodingAESKey(String sEncodingAESKey) {
		this.sEncodingAESKey = sEncodingAESKey;
	}

	public String getsCorpID() {
		return sCorpID;
	}

	public void setsCorpID(String sCorpID) {
		this.sCorpID = sCorpID;
	}

	@Override
	public WXBizMsgCrypt getObject() throws Exception {
		WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
		if (logger.isDebugEnabled()) {
			logger.debug("加载微信凭证对象成功,sToken=" + sToken + ";sEncodingAESKey=" + sEncodingAESKey + ";sCorpID=" + sCorpID);
		}
		return wxcpt;
	}

	@Override
	public Class<?> getObjectType() {
		return WXBizMsgCrypt.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
