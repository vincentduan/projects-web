package com.efubao.core.admin.service;

import java.util.List;

import com.efubao.core.admin.domain.GoodsPropertyValue;
import com.efubao.core.admin.domain.GoodsPropertyValueExample;
import com.efubao.core.common.base.BaseService;

public interface GoodsPropertyValueService extends BaseService<GoodsPropertyValue> {

	List<GoodsPropertyValue> selectByExample(GoodsPropertyValueExample goodsPropertyValueExample);

	List<GoodsPropertyValue> getGoodsPropertyValueListByGoodsPropertyId(List<Long> ids);

}
