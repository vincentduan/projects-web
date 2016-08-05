package com.unisk.zc.utils;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonMapper {

	private static final ObjectMapper mapper = new ObjectMapper();

	private JacksonMapper() {}

	public static ObjectMapper getInstance() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		mapper.getSerializationConfig().with(df);
		mapper.getDeserializationConfig().with(df);
		return mapper;
	}

}
