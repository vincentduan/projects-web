package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.MeasureOrderStatusStream;

public interface MeasureOrderStatusStreamService extends BaseService<MeasureOrderStatusStream> {
	
	public List<MeasureOrderStatusStream> findByOrderNo(String orderNo);
}
