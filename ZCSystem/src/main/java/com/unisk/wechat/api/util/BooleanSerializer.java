package com.unisk.wechat.api.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * @Description:自定义boolean值序列化json串字符串值 true:"1" false:"0"
 * @author shijingbang
 * @Date 2015年11月25日
 */
public class BooleanSerializer extends JsonSerializer<Boolean> {

	@Override
	public void serialize(Boolean value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
		String text = value == null ? "0" : value ? "1" : "0";
		gen.writeString(text);
	}

}
