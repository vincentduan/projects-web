package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.MeasureOrderProperty;

public interface MeasureOrderPropertyService extends BaseService<MeasureOrderProperty> {

	public List<MeasureOrderProperty> queryByMeasureOrderNo(String orderNo);
}
