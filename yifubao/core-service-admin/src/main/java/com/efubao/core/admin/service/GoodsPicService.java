package com.efubao.core.admin.service;

import java.util.List;

import com.efubao.core.admin.domain.GoodsPic;
import com.efubao.core.common.base.BaseService;


public interface GoodsPicService extends BaseService<GoodsPic>{

	List<GoodsPic> queryByCondition(GoodsPic g);
	
}
