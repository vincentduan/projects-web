package com.unisk.wechat.api.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {

	public static void copyProperties(Object dest, Map<String, Object> orgi) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		if (dest != null && orgi != null && !orgi.isEmpty()) {
			Method[] methods = dest.getClass().getMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(XmlElement.class)) {
					XmlElement element = method.getAnnotation(XmlElement.class);
					String key = element.name();
					if (orgi.containsKey(key)) {
						method.invoke(dest, orgi.get(key));

					}
				}
			}
		}
	};

}
