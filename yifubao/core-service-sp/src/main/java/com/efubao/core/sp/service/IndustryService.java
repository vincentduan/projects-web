package com.efubao.core.sp.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.Industry;


public interface IndustryService extends BaseService<Industry>{

	List<Industry> queryAllActiveIndustry();
	
}
