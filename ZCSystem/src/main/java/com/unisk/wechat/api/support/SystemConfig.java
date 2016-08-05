package com.unisk.wechat.api.support;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

/**
 * 
 * @Description:加载系统配置文件
 * @author shijingbang
 * @Date 2015年11月18日
 */
@Component
public class SystemConfig {
	private static final Logger logger = LoggerFactory.getLogger(SystemConfig.class);
	private static Properties props = new Properties();

	private static String RESOURCE_PATH = "classpath*:config/wechat/*.properties";

	@PostConstruct
	public void loadProperties() {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(this.getClass().getClassLoader());
		try {
			Resource[] resources = resolver.getResources(RESOURCE_PATH);
			for (Resource resource : resources) {
				props.load(resource.getInputStream());
				if (logger.isDebugEnabled()) {
					logger.debug("加载系统资源文件：{}", resource.getFilename());
				}
			}
		} catch (IOException e) {
			if (logger.isErrorEnabled()) {
				logger.error("加载系统资源文件失败,失败原因：{}", e.getMessage());
			}
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

	public static String getValue(String key, String defaultValue) {

		return props.getProperty(key, defaultValue);
	}
}
