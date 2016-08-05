package com.efubao.core.admin.service;

import java.util.List;

import com.efubao.core.admin.domain.GoodsProperty;
import com.efubao.core.admin.domain.GoodsPropertyExample;
import com.efubao.core.common.base.BaseService;

public interface GoodsPropertyService extends BaseService<GoodsProperty> {

	List<GoodsProperty> selectByExample(GoodsPropertyExample example);

	List<GoodsProperty> getGoodsPropertyListByGoodsId(Long id);

	List<GoodsProperty> queryByCondition(GoodsProperty g);

}
