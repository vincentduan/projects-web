package com.efubao.core.pb.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.pb.domain.Dictionary;
import com.efubao.core.pb.domain.DictionaryExample;
import com.efubao.core.pb.domain.DictionaryExample.Criteria;
import com.efubao.core.pb.mapper.DictionaryMapper;
import com.efubao.core.pb.service.DictionaryService;

/**
 * Created by xingliang on 2016-03-14.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Override
	public Dictionary findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Dictionary t) {
		// TODO Auto-generated method stub
		if (t == null)
			return 0;
		return dictionaryMapper.insertSelective(t);
	}

	@Override
	public int update(Dictionary t) {
		// TODO Auto-generated method stub
		if (null == t)
			return 0;
		return dictionaryMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (null == id)
			return 0;
		return dictionaryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<Dictionary> page, Dictionary t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Dictionary> queryByKey(String key) {
		if (null == key)
			return null;

		DictionaryExample example = new DictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andDicKeyEqualTo(key);
		return dictionaryMapper.selectByExample(example);
	}

	@Override
	public Dictionary findByKeyAndName(String key, String name) {
		if (null == key || null == name)
			return null;

		DictionaryExample example = new DictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andDicKeyEqualTo(key);
		criteria.andNameEqualTo(name);
		List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(dictionaries))
			return null;
		else
			return dictionaries.get(0);
	}
}
