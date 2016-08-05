package com.efubao.core.common.serializer;

import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 自定义返回JSON 数据格中orderNo BigDecimal格式化处理
 * 
 */
public class OrderNoBigDecimalSerializer extends JsonSerializer<BigDecimal> {

	public static final String style = "#######################";

	@Override
	public void serialize(BigDecimal value,
			com.fasterxml.jackson.core.JsonGenerator gen,
			com.fasterxml.jackson.databind.SerializerProvider serializers)
			throws IOException,
			com.fasterxml.jackson.core.JsonProcessingException {
		DecimalFormat df = new DecimalFormat(style);
		String s = df.format(value);
		gen.writeString(s);

	}

}
