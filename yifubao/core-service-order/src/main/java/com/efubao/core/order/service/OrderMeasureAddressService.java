package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.OrderMeasureAddress;

public interface OrderMeasureAddressService extends BaseService<OrderMeasureAddress>{

	List<OrderMeasureAddress> queryByCondition(OrderMeasureAddress orderMeasureAddress);
}
