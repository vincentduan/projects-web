package com.efubao.core.sp.service;

import java.util.List;
import java.util.Map;

import com.efubao.common.util.Page;
import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.ServiceProvider;

public interface ServiceProviderService extends BaseService<ServiceProvider> {

	List<ServiceProvider> queryByCondition(ServiceProvider serviceProvider);

	List<ServiceProvider> getSpListByIds(List<Long> spids);
	
	void getServiceP(Page<ServiceProvider> page,String spName,Integer categoryId,Integer start,Integer end);

}
