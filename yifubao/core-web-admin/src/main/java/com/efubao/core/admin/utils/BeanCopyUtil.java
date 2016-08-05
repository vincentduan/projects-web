package com.efubao.core.admin.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cglib.beans.BeanCopier;

/**
 * 针对spring BeanCopier创建时性能较低，新创建的对象缓存下来
 * 
 *
 */
public class BeanCopyUtil {

	private static Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();

	private BeanCopyUtil( ) {
	}

	public static void copyProperties(Object source, Object target) {
		String beanKey = generateKey(source.getClass(), target.getClass());
		BeanCopier copier = null;
		if (!beanCopierMap.containsKey(beanKey))
		{
			synchronized (BeanCopyUtil.class)
			{
				if (!beanCopierMap.containsKey(beanKey))
				{
					copier = BeanCopier.create(source.getClass(), target.getClass(), false);
					beanCopierMap.put(beanKey, copier);
				}
				else
				{
					copier = beanCopierMap.get(beanKey);
				}
			}
		}
		else
		{
			copier = beanCopierMap.get(beanKey);
		}
		copier.copy(source, target, null);
	}

	public static void flush( ) {
		beanCopierMap.clear();
	}

	private static String generateKey(Class<?> class1, Class<?> class2) {
		return class1.getName() +"."+ class2.getName();
	}

}
