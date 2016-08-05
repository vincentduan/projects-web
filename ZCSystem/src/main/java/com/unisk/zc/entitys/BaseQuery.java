package com.unisk.zc.entitys;

import java.util.HashMap;
import java.util.Map;

import com.unisk.zc.core.support.Page;

public abstract class BaseQuery<T> {

	public Page<T> page;

	private Map<Object, Object> queryMap;

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public Map<Object, Object> getQueryMap() {
		if (queryMap == null) {
			queryMap = new HashMap<Object, Object>();
		}
		return queryMap;
	}

	public void setQueryMap(Map<Object, Object> queryMap) {
		this.queryMap = queryMap;
	}

}
