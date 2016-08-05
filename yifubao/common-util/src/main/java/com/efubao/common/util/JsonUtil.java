/**
 * JsonUtil.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.common.util;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON utility
 *
 */
public final class JsonUtil {
	
	/**
	 * log
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
	
	/**
	 * 
	 */
	private JsonUtil() {
		
	}

	/**
	 * 
	 */
	static final ObjectMapper OBJECT_MAPPER;

	static {
		OBJECT_MAPPER = new ObjectMapper();
		OBJECT_MAPPER.getSerializationConfig().withSerializationInclusion(JsonInclude.Include.NON_NULL);
		OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static ObjectMapper getObjectMapper() {
		return OBJECT_MAPPER;
	}

	/**
	 * JSON串转换为Java泛型对象，可以是各种类型
	 * 
	 * @param <T> return type
	 * @param jsonString JSON
	 * @param tr TypeReference,例如: new TypeReference< List<FamousUser> >(){}
	 * @return List对象列表
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2GenericObject(String jsonString, TypeReference<T> tr) {
		if (!StringUtils.isBlank(jsonString)) {
			try {
				return (T) OBJECT_MAPPER.readValue(jsonString, tr);
			} catch (Exception e) {
				LOGGER.warn("json error:" + e.getMessage());
			}
		}
		return null;
	}
 
	/**
	 * Java对象转JSON字符串
	 * 
	 * @param object Java对象，可以是对象，数组，List,Map等
	 * @return JSON 字符串
	 */
	public static String toJson(Object object) {
		try {
			return OBJECT_MAPPER.writeValueAsString(object);
		} catch (Exception e) {
			LOGGER.warn("json error:" + e.getMessage());
		}
		return null;

	}
 
    /**
     * JSON字符串转Java对象
     * 
     * @param jsonString JSON
     * @param c class
     * @return
     */
	public static Object json2Object(String jsonString, Class<?> c) {
		if (!StringUtils.isBlank(jsonString)) {
			try {
				return OBJECT_MAPPER.readValue(jsonString, c);
			} catch (Exception e) {
				LOGGER.warn("json error:" + e.getMessage());
			}

		}
		return null;
	}
	
	/**
	 * 验证字符串是否为json格式
	 * 
	 * @param json
	 * @return
	 */
    public static boolean isValidJson(final String json) {
        boolean valid = false;
        try {
           final JsonParser parser = new ObjectMapper().getJsonFactory()
                 .createJsonParser(json);
           while (parser.nextToken() != null) {
           }
           valid = true;
        } catch (JsonParseException jpe) {
            return valid;
        } catch (IOException ioe) {
            return valid;
        }
        return valid;
     }
}
