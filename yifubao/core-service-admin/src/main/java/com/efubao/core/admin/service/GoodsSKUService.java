package com.efubao.core.admin.service;

import java.util.List;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.GoodsSKU;
import com.efubao.core.common.base.BaseService;


public interface GoodsSKUService extends BaseService<GoodsSKU>{

	List<GoodsSKU> queryByCondition(GoodsSKU g);
	
	void searchGoodsSku(Page<GoodsSKU> page,String name,Integer id,Integer start,Integer end);
	
}
