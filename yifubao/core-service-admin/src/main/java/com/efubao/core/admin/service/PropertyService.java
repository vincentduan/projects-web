package com.efubao.core.admin.service;

import java.util.List;

import com.efubao.core.admin.domain.Property;
import com.efubao.core.admin.domain.PropertyExample;
import com.efubao.core.common.base.BaseService;

public interface PropertyService extends BaseService<Property> {
	List<Property> queryByCondition(Property property);
}
