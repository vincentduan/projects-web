package com.efubao.core.admin.service;


import java.util.List;

import com.efubao.core.admin.domain.PropertyValue;
import com.efubao.core.common.base.BaseService;


public interface PropertyValueService extends BaseService<PropertyValue>{

	List<PropertyValue> queryByCondition(PropertyValue propertyValue);
}
