package com.unisk.zc.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unisk.zc.exceptions.UniskException;

public class SerializationObject {

	public static final <T> String serialize(T t) throws UniskException {
		if (t == null) {
			return null;
		}
		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			return mapper.writeValueAsString(t);
		} catch (JsonGenerationException e) {
			throw new UniskException(e);
		} catch (JsonMappingException e) {
			throw new UniskException(e);
		} catch (IOException e) {
			throw new UniskException(e);
		}

	}

	public static final <T> T deserialize(String jsonStr, Class<T> clazz) throws UniskException {
		if (jsonStr == null) {
			return null;
		}
		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			return mapper.readValue(jsonStr, clazz);
		} catch (JsonParseException e) {
			throw new UniskException(e);
		} catch (JsonMappingException e) {
			throw new UniskException(e);
		} catch (IOException e) {
			throw new UniskException(e);
		}
	}
}
