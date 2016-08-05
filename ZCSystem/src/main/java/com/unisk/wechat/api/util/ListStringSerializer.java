package com.unisk.wechat.api.util;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * @Description:用于将List集合序列化为微信平台要求的UserID1|UserID2|UserID3 格式字符串
 * @author shijingbang
 * @Date 2015年11月24日
 */
public class ListStringSerializer extends JsonSerializer<List<String>> {

	private static final String DELIMITEED = "|";

	private static final Logger logger = LoggerFactory.getLogger(ListStringSerializer.class);

	@Override
	public void serialize(List<String> value, JsonGenerator gen, SerializerProvider serializers) throws IOException,
			JsonProcessingException {
		String text = StringUtils.collectionToDelimitedString(value, DELIMITEED);
		if (logger.isDebugEnabled()) {
			logger.debug(text);
		}

		gen.writeString(text);
	}

}
