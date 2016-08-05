package com.efubao.core.sp.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.GoodsCase;

public interface GoodsCaseService extends BaseService<GoodsCase> {

	List<GoodsCase> queryByCondition(GoodsCase c);

}
