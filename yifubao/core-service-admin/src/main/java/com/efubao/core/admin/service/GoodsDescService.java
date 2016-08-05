package com.efubao.core.admin.service;

import java.util.List;

import com.efubao.core.admin.domain.GoodsDesc;
import com.efubao.core.common.base.BaseService;


public interface GoodsDescService extends BaseService<GoodsDesc>{

	List<GoodsDesc> queryByCondition(GoodsDesc goodsDesc);
	
}
