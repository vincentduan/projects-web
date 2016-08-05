package com.efubao.core.pb.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.core.pb.domain.City;
import com.efubao.core.pb.domain.CityExample;
import com.efubao.core.pb.mapper.CityMapper;
import com.efubao.core.pb.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	@Override
	public City findById(Long id) {
		if (id == null) {
			return null;
		}
		return cityMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<City> findByPid(Long parentId) {
		if (parentId == null) {
			return null;
		}
		CityExample example = new CityExample();
		CityExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		return cityMapper.selectByExample(example);
	}

	@Override
	public List<City> findByClevel(Integer levelType, String name) {
		if (levelType == null) {
			return null;
		}
		CityExample example = new CityExample();
		CityExample.Criteria criteria = example.createCriteria();
		criteria.andLevelTypeEqualTo(levelType);
	
		if(StringUtils.trimToNull(name) != null){
			criteria.andNameEqualTo(name);
		}
		return cityMapper.selectByExample(example);
	}

}
