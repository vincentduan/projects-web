package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.MeasureGoods;

public interface MeasureGoodsService extends BaseService<MeasureGoods>{

	public List<MeasureGoods> queryByMeasureOrderNo(String orderNo);
}