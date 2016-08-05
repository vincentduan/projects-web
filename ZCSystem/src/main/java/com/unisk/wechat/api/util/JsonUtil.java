package com.unisk.wechat.api.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	/**
	 * 使用jackson框架序列化对象为json串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJsonByJackson(Object obj) {
		String json = "";
		try {
			json = ObjectMapperProvider.getObjectMapper().writeValueAsString(obj);
			if (logger.isDebugEnabled()) {
				logger.debug("序列化对象为json：{}", json);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	private static class ObjectMapperProvider {
		private static ObjectMapper objectMapper;

		static {
			objectMapper = new ObjectMapper();
		}

		public static ObjectMapper getObjectMapper() {
			return objectMapper;
		}

	}

	public static void main(String[] args) {
		Map<String, Object> menus = new HashMap<String, Object>();

		List<Map<String, Object>> buttons = new ArrayList<Map<String, Object>>();
		Map<String, Object> zixun = new HashMap<String, Object>();// 资讯
		zixun.put("name", "沃众筹资讯");
		zixun.put("type", "click");
		zixun.put("key", "WECHAT_CLICK_WO_ZIXUN_001");
		buttons.add(zixun);

		Map<String, Object> wodedongtai = new HashMap<String, Object>();
		wodedongtai.put("name", "我的动态");
		List<Map<String, Object>> wodedongtaiSubButtons = new ArrayList<Map<String, Object>>();
		Map<String, Object> wodedongtaiSubMap1 = new HashMap<String, Object>();
		wodedongtaiSubMap1.put("name", "我参与的项目");
		wodedongtaiSubMap1.put("type", "view");
		wodedongtaiSubMap1.put("url", "http://zhongchou.unisk.cn/");
		wodedongtaiSubButtons.add(wodedongtaiSubMap1);
		wodedongtai.put("sub_button", wodedongtaiSubButtons);
		buttons.add(wodedongtai);

		Map<String, Object> gerenzhongxin = new HashMap<String, Object>();
		gerenzhongxin.put("name", "个人中心");
		List<Map<String, Object>> gerenzhongxinSubButtons = new ArrayList<Map<String, Object>>();
		Map<String, Object> gerenzhongxinSubMap1 = new HashMap<String, Object>();
		gerenzhongxinSubMap1.put("name", "用户信息");
		gerenzhongxinSubMap1.put("type", "view");
		gerenzhongxinSubMap1.put("url", "http://zhongchou.unisk.cn/");

		Map<String, Object> gerenzhongxinSubMap2 = new HashMap<String, Object>();
		gerenzhongxinSubMap2.put("name", "消息中心");
		gerenzhongxinSubMap2.put("type", "view");
		gerenzhongxinSubMap2.put("url", "http://zhongchou.unisk.cn/");

		Map<String, Object> gerenzhongxinSubMap3 = new HashMap<String, Object>();
		gerenzhongxinSubMap3.put("name", "帮助指南");
		gerenzhongxinSubMap3.put("type", "view");
		gerenzhongxinSubMap3.put("url", "http://www.baidu.com");

		Map<String, Object> gerenzhongxinSubMap4 = new HashMap<String, Object>();
		gerenzhongxinSubMap4.put("name", "意见反馈");
		gerenzhongxinSubMap4.put("type", "view");
		gerenzhongxinSubMap4.put("url", "http://www.baidu.com");

		Map<String, Object> gerenzhongxinSubMap5 = new HashMap<String, Object>();
		gerenzhongxinSubMap5.put("name", "扫码推事件(测试)");
		gerenzhongxinSubMap5.put("type", "scancode_push");
		gerenzhongxinSubMap5.put("key", "rselfmenu_0_1");
		gerenzhongxinSubMap5.put("sub_button", new ArrayList<Map<String, Object>>());

		gerenzhongxinSubButtons.add(gerenzhongxinSubMap1);
		gerenzhongxinSubButtons.add(gerenzhongxinSubMap2);
		gerenzhongxinSubButtons.add(gerenzhongxinSubMap3);
		gerenzhongxinSubButtons.add(gerenzhongxinSubMap4);
		gerenzhongxinSubButtons.add(gerenzhongxinSubMap5);

		gerenzhongxin.put("sub_button", gerenzhongxinSubButtons);
		buttons.add(gerenzhongxin);

		menus.put("button", buttons);

		System.out.println(toJson(menus));
	}

}
