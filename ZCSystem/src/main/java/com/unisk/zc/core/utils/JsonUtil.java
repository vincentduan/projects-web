package com.unisk.zc.core.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @Description: 实体bean与json字符串相互转化工具类
 * @author shijingbang
 * @Date 2015年11月18日
 */
public class JsonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	private static class GsonProvider {
		private static Gson gson;
		private static final String DATA_PATTERN = "yyyy-MM-dd HH:mm:ss";
		static {
			GsonBuilder builder = new GsonBuilder();
			builder.serializeNulls();// 序列化属性值为null的
			builder.setDateFormat(DATA_PATTERN);// 格式化日期格式
			builder.disableHtmlEscaping();// 不转义html特殊字符
			gson = builder.create();
		}

		private static Gson getGson() {
			return gson;
		}
	}

	public static Gson getDefaultGson() {
		return GsonProvider.getGson();
	}

	public static String toJson(Object obj) {
		String json = getDefaultGson().toJson(obj);
		if (logger.isDebugEnabled()) {
			logger.debug(json);
		}
		return json;
	}

	public static <T> Map<String, T> jsonToMap(String json, Class<T> clazz) {
		if (logger.isDebugEnabled()) {
			logger.debug("请求参数：JSON=" + json);
		}
		Map<String, T> map = getDefaultGson().fromJson(json, new TypeToken<Map<String, T>>() {
		}.getType());

		if (map == null)
			return new HashMap<String, T>();
		return map;
	}

	/**
	 * 将json串转成一个列表集合
	 * 
	 * @param 示例
	 *            [{"a":"","b":""},{"a":"","b":""},{"a":"","b":""}]
	 */
	public static List<Map<String, String>> converterJsonToArray(String json) {
		if (logger.isDebugEnabled()) {
			logger.debug("请求参数：JSON=" + json);
		}
		List<Map<String, String>> list = getDefaultGson().fromJson(json, new TypeToken<List<Map<String, String>>>() {
		}.getType());
		return list;
	}

}
