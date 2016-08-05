package com.unisk.zc.core.utils;

import java.util.Map;

import com.google.common.collect.Maps;

public class LoginCookieUtils {

	public static boolean isValidateCodeLogin(String useruame, boolean isFail, boolean clean) {
		Map<String, Integer> loginFailMap = (Map) CacheUtils.get("loginFailMap");
		if (loginFailMap == null) {
			loginFailMap = Maps.newHashMap();
			CacheUtils.put("loginFailMap", loginFailMap);
		}
		Integer loginFailNum = loginFailMap.get(useruame);
		if (loginFailNum == null) {
			loginFailNum = Integer.valueOf(0);
		}
		if (isFail) {
			loginFailNum = Integer.valueOf(loginFailNum.intValue() + 1);
			loginFailMap.put(useruame, loginFailNum);
		}
		if (clean) {
			loginFailMap.remove(useruame);
		}
		return loginFailNum.intValue() >= 3;
	}
	
}
