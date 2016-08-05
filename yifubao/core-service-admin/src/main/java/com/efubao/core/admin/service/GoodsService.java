package com.efubao.core.admin.service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Goods;
import com.efubao.core.admin.domain.GoodsExample;
import com.efubao.core.common.base.BaseService;

public interface GoodsService extends BaseService<Goods> {

	void queryByPageExample(Page<Goods> page, GoodsExample example);

}
