package com.efubao.core.order.service;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.MeasureOrderAddress;

public interface MeasureOrderAddressService extends BaseService<MeasureOrderAddress>{

	public MeasureOrderAddress findByMeasureOrderNo(String orderNo);
}
