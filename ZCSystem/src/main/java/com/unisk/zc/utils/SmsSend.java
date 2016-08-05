package com.unisk.zc.utils;

import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.Sets;
import com.unisk.zc.core.config.Global;
import com.unisk.zc.exceptions.UniskException;

public class SmsSend {

	public static boolean send(String mobile, String contentTemplate) throws UniskException {
		if( StringUtils.isEmpty(mobile) ) return false;
		if( StringUtils.isEmpty(contentTemplate) ) return false;
		String url = "http://123.125.99.106:8082/mt";
		String client_id = "01";
		String spno = "10655487" + new Random(System.currentTimeMillis()).nextInt(9999);
		String params = "client_id=" + client_id + "&spno=" + spno 
				+ "&mobile_number=" + mobile 
				+ "&content=" + URLEncodedUtils.parse(contentTemplate, Charsets.UTF_8);
		try {
			HttpConnector.requestPost(url, params, false);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(Constant.SEND_SMS_ERROR_CODE, Constant.SEND_SMS_ERROR_DESC, "短信发送失败");
		}
	}
	
	public static boolean isMobileNO(String mobiles){  
		Pattern p = Pattern.compile(Global.getConfig("mobilePattern"));  
		Matcher m = p.matcher(mobiles);  
		return m.matches();  
	}  
	
	/**
	 * 随机生成{len}长度的不重复的数字串
	 * @param len
	 * @return
	 */
	public static String randomCode( int len ){
		if( len < 4 || len > 10 ) return null;
		char[] num = {'0','1','2','3','4','5','6','7','8','9'}; 
		StringBuffer str = new StringBuffer();
		Set set = Sets.newHashSet();
		for (int i = 0; i < len; i++) {
			int r =  RandomUtils.nextInt(10);
			if( set.contains(r) ) i--;
			else {
				str.append(num[r]);
				set.add(r);
			}
		}
		return str.toString();
	}

}
