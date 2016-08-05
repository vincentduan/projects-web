package com.efubao.core.common.cache;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.cache.interceptor.SimpleKeyGenerator;

import com.efubao.common.util.Page;

/**
 * cache key Generator
 * 
 * 
 */
public class MyKeyGenerator extends SimpleKeyGenerator {

	private static final String STR = "_";
	private static final String blank = "null";

	@Override
	public Object generate(Object target, Method method, Object... params) {
		// Object keyGenerator = super.generate(target, method, params);

		StringBuffer buffer = new StringBuffer();
		// Class entityClass = GenericsHelper.getSuperGenericsClass(target
		// .getClass());
		// buffer.append(entityClass.getName());
		buffer.append(target.getClass().getSimpleName());
		buffer.append(STR);
		buffer.append(method.getName());
		buffer.append(STR);
		if (params != null) {
			for (Object obj : params) {
				if (obj != null) {
					if (obj instanceof AtomicInteger
							|| obj instanceof AtomicLong
							|| obj instanceof BigDecimal
							|| obj instanceof BigInteger || obj instanceof Byte
							|| obj instanceof Double || obj instanceof Float
							|| obj instanceof Integer || obj instanceof Long
							|| obj instanceof Short || obj instanceof Boolean
							|| obj instanceof String) {

						buffer.append(obj);

					} else if (obj instanceof List || obj instanceof Set
							|| obj instanceof Map) {
						if (obj instanceof List) {
							Collections.sort((List) obj);
						}
						buffer.append(obj.hashCode());

					} else if (obj instanceof Long[]) {
						Arrays.sort((Long[]) obj);
						buffer.append(Arrays.toString((Long[]) obj));

					} else if (obj instanceof Page) {
						buffer.append(((Page) obj).getPageNo());
						buffer.append(STR);
						buffer.append(((Page) obj).getPageSize());
						buffer.append(STR);
						buffer.append(((Page) obj).getOrderBy());
					} else {

						buffer.append(obj.hashCode());

					}
				} else {
					buffer.append(blank);
				}
				buffer.append(STR);
			}
		}
		// System.out.println("key-buffer:" + buffer.toString());
		// int keyGenerator = buffer.toString().hashCode();
		String keyGenerator = buffer.toString();
		return keyGenerator;
	}

}