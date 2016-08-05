package com.efubao.core.pb.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.pb.domain.Dictionary;

/**
 * Created by xingliang on 2016-03-14.
 */
public interface DictionaryService extends BaseService<Dictionary> {

	public List<Dictionary> queryByKey(String key);
	
	public Dictionary findByKeyAndName(String key, String name);
}
