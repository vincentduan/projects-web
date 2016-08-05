package com.unisk.wechat.api.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

/**
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年11月19日
 */
@Component
public class SpringUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			applicationContext = ContextLoader.getCurrentWebApplicationContext();
		}
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringUtils.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public static <T> T getBean(Class<T> clazz, String name) {
		return getApplicationContext().getBean(name, clazz);
	}

	public static Object getBean(String name, Object... args) {
		return getApplicationContext().getBean(name, args);
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	public static <T> Map<String, T> getBeansByType(Class<T> type) {
		return getApplicationContext().getBeansOfType(type);
	}

}
