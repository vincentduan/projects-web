package com.unisk.wechat.api.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WechatSignatureUtil {

	private static final Logger logger = LoggerFactory.getLogger(WechatSignatureUtil.class);

	public static String generateSignature(TreeMap<String, String> map) {
		String str1 = mapToString(map);
		String digest = SHA1Util.encode(str1);
		if (logger.isDebugEnabled()) {
			logger.debug("SHA_1加密之后的串为：{}", digest);
		}
		return digest;

	}

	public static String mapToString(Map<String, String> map) {
		Iterator<Entry<String, String>> i = map.entrySet().iterator();
		if (!i.hasNext())
			return "";

		StringBuilder sb = new StringBuilder();
		for (;;) {
			Entry<String, String> e = i.next();
			String key = e.getKey();
			String value = e.getValue();
			sb.append(key);
			sb.append('=');
			sb.append(value);
			if (!i.hasNext()) {
				String s = sb.toString();
				if (logger.isDebugEnabled()) {
					logger.debug(s);
				}
				return s;
			}
			sb.append('&');
		}
	}

	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("noncestr", "Wm3WZYTPz0wzccnW");
		map.put("jsapi_ticket", "sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg");
		map.put("url", "http://mp.weixin.qq.com");
		map.put("timestamp", "1414587457");
		System.out.println(generateSignature(map));
	}
}
