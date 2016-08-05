package com.unisk.zc.core.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射工具类
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年12月22日
 */
public class ReflectHelper {

	private static final Logger logger = LoggerFactory.getLogger(ReflectHelper.class);

	/**
	 * 给对象的属性设置新值
	 * 
	 * @param target
	 *            要被设置值得目标对象
	 * @param fieldName
	 *            属性字段名称
	 * @param value
	 *            属性新值
	 * @author shijingbang
	 */
	public static void setValueByFieldName(Object target, String fieldName, Object value) {
		try {
			Field field = getFieldByFieldName(target, fieldName);
			if (!field.isAccessible()) {
				field.setAccessible(true);
				field.set(target, value);
				field.setAccessible(false);
			} else {
				field.set(target, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据属性名称获取对应的属性对象
	 * 
	 * @param target
	 *            目标对象
	 * @param fieldName
	 *            属性名称
	 * @return 属性对象
	 * @author shijingbang
	 */
	public static Object getValueByFieldName(Object target, String fieldName) {
		Object fieldValue = null;
		Class<?> clazz = target.getClass();
		// 先从本类找属性，找不到就从父类中找(包含私有属性)
		for (; clazz != Object.class; clazz = target.getClass().getSuperclass()) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				// 如果属性是私有的
				if (!field.isAccessible()) {
					field.setAccessible(true);
					fieldValue = field.get(target);
					field.setAccessible(false);

				} else {
					fieldValue = field.get(target);

				}
				return fieldValue;
			} catch (Exception e) {
				// do nothing
				if (logger.isDebugEnabled()) {
					logger.debug("类中{}没有属性{}，尝试从父类中找", clazz.getName(), fieldName);
				}
			}
		}
		return fieldValue;
	}

	/**
	 * 获取obj对象fieldName的Field
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static Field getFieldByFieldName(Object obj, String fieldName) {
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
			}
		}
		return null;
	}

	/**
	 * 获取目标对象的泛型实参列表的第一个class类
	 * 
	 * @param obj
	 * @return
	 */
	public static Class<?> getGenericClass(Object obj) {
		return getGenericClass(obj, 0);
	}

	/**
	 * 获取目标对象指定位置的泛型类
	 * 
	 * @param obj
	 * @param position
	 * @return
	 */
	public static Class<?> getGenericClass(Object obj, int position) {
		if (obj != null) {
			Type type = obj.getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType genType = (ParameterizedType) type;
				Type[] getGenericTypes = genType.getActualTypeArguments();
				return (Class<?>) getGenericTypes[position];
			}
		}

		return null;
	}
}
