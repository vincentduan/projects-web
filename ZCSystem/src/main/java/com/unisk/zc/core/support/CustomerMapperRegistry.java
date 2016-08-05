package com.unisk.zc.core.support;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.apache.ibatis.session.SqlSession;

public class CustomerMapperRegistry {
	private final CustomerConfiguration config;
	private final Set<Class<?>> knownMappers = new HashSet<Class<?>>();

	public CustomerMapperRegistry(CustomerConfiguration config) {
		this.config = config;
	}

	public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
		if (!knownMappers.contains(type))
			throw new BindingException("Type " + type + " is not known to the MapperRegistry.");
		try {
			return CustomerMapperProxy.newMapperProxy(type, sqlSession);
		} catch (Exception e) {
			throw new BindingException("Error getting mapper instance. Cause: " + e, e);
		}
	}

	public boolean hasMapper(Class<?> type) {
		return knownMappers.contains(type);
	}

	public void addMapper(Class<?> type) {
		if (type.isInterface()) {
			if (knownMappers.contains(type)) {
				throw new BindingException("Type " + type + " is already known to the MapperRegistry.");
			}
			boolean loadCompleted = false;
			try {
				knownMappers.add(type);
				// It's important that the type is added before the parser is run
				// otherwise the binding may automatically be attempted by the
				// mapper parser. If the type is already known, it won't try.
				MapperAnnotationBuilder parser = new MapperAnnotationBuilder(config, type);
				parser.parse();
				loadCompleted = true;
			} finally {
				if (!loadCompleted) {
					knownMappers.remove(type);
				}
			}
		}
	}
}
