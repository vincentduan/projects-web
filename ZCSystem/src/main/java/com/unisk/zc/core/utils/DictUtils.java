package com.unisk.zc.core.utils;

import java.util.List;

import com.unisk.zc.entitys.Dictionary;
import com.unisk.zc.mapper.DictionaryMapper;
import com.unisk.zc.utils.springs.SpringContextHolder;

public class DictUtils {

	private static DictionaryMapper dictDao = SpringContextHolder.getBean(DictionaryMapper.class);

	public static List<Dictionary> getBusinessType() {
		Dictionary dict = new Dictionary();
		dict.setKinds("BUSINESSTYPE");
		return dictDao.selectList(dict);
	}

	public static List<Dictionary> getProvList() {
		Dictionary dict = new Dictionary();
		dict.setKinds("COMMON-REGION");
		return dictDao.selectList(dict);
	}

	public static Dictionary getDictionaryByKindsAndUValue(String kinds, String uValue) {
		Dictionary dict = new Dictionary();
		dict.setKinds(kinds);
		dict.setUvalue(uValue);
		return dictDao.selectList(dict).get(0);
	}

	public static Dictionary getDictionaryByKindsAndUKey(String kinds, String uKey) {
		Dictionary dict = new Dictionary();
		dict.setKinds(kinds);
		dict.setUkey(uKey);
		return dictDao.selectList(dict).get(0);
	}
}
