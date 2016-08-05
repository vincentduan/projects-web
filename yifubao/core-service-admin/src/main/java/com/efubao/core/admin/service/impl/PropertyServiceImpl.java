package com.efubao.core.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Property;
import com.efubao.core.admin.domain.PropertyExample;
import com.efubao.core.admin.domain.PropertyExample.Criteria;
import com.efubao.core.admin.mapper.PropertyMapper;
import com.efubao.core.admin.service.PropertyService;
import com.efubao.core.common.util.PersentLike;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyMapper propertyMapper;

	@Override
	public Property findById(Long id) {
		if (id == null) {
			return null;
		}
		return propertyMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(Property t) {
		if (t == null) {
			return 0;
		}
		return propertyMapper.insertSelective(t);
	}

	@Override
	public int update(Property t) {
		if (t == null) {
			return 0;
		}
		return propertyMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return propertyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<Property> page, Property t) {

	}

	@Override
	public List<Property> queryByCondition(Property property) {
		if (property == null) {
			return null;
		}
		PropertyExample example = new PropertyExample();
		Criteria criteria = example.createCriteria();
		if (property.getName() != null) {
			criteria.andNameLike(PersentLike.makeUpPersentLike(property.getName()));
		}
		if (property.getStatus() != null) {
			criteria.andStatusEqualTo(property.getStatus());
		}
		if (property.getIsDel() != null){
			criteria.andIsDelEqualTo(property.getIsDel());
		}
 		return propertyMapper.selectByExample(example);
	}

}
