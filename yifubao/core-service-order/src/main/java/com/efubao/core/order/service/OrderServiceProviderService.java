package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.OrderServiceProvider;

public interface OrderServiceProviderService extends BaseService<OrderServiceProvider> {

	List<OrderServiceProvider> getSpListByOrderNo(String orderNo);

}
