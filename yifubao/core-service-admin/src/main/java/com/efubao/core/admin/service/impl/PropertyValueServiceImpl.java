package com.efubao.core.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.PropertyValue;
import com.efubao.core.admin.domain.PropertyValueExample;
import com.efubao.core.admin.domain.PropertyValueExample.Criteria;
import com.efubao.core.admin.mapper.PropertyValueMapper;
import com.efubao.core.admin.service.PropertyValueService;
import com.efubao.core.common.util.PersentLike;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {

	@Autowired
	private PropertyValueMapper propertyValueMapper;

	@Override
	public PropertyValue findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(PropertyValue t) {
		if(t == null){
			return 0;
		}
		return propertyValueMapper.insertSelective(t);
	}

	@Override
	public int update(PropertyValue t) {
		if(t == null){
			return 0;
		}
		return propertyValueMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if(id == null){
			return 0;
		}
		return propertyValueMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<PropertyValue> page, PropertyValue t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<PropertyValue> queryByCondition(PropertyValue propertyValue) {
		if (propertyValue == null) {
			return null;
		}
		PropertyValueExample example = new PropertyValueExample();
		Criteria criteria = example.createCriteria();
		if (propertyValue.getName() != null) {
			criteria.andNameLike(PersentLike.makeUpPersentLike(propertyValue.getName()));
		}
		if (propertyValue.getPropertyId() != null) {
			criteria.andPropertyIdEqualTo(propertyValue.getPropertyId());
		}
		if (propertyValue.getStatus() != null) {
			criteria.andStatusEqualTo(propertyValue.getStatus());
		}
		if (propertyValue.getIsDel() != null){
			criteria.andIsDelEqualTo(propertyValue.getIsDel());
		}
 		return propertyValueMapper.selectByExample(example);
	}
}
