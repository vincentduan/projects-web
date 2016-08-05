package com.unisk.zc.utils.springs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unisk.zc.utils.JacksonUtil;

/**
 * jackson ObjectMapper 包装器，用于解决原来spring的json处理器无法打印json串的问题
 *
 * @author lishuangying
 *
 */
public class ObjectMapperWrapper extends ObjectMapper {

    private static Log logger = LogFactory.getLog(ObjectMapperWrapper.class);

    public Object readValue(InputStream src, JavaType valueType) throws IOException, JsonParseException,
            JsonMappingException {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(src));
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("【JSON】" + sb.toString() + "【valueType】" + valueType);
        return super.readValue(sb.toString(), valueType);
    }

    public void writeValue(JsonGenerator jgen, Object value) throws IOException, JsonGenerationException,
            JsonMappingException {
        logger.info(JacksonUtil.obj2str(value));
        super.writeValue(jgen, value);
    }

}
