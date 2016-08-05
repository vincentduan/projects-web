package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.OrderStatusStream;

public interface OrderStatusStreamService extends BaseService<OrderStatusStream>{

	List<OrderStatusStream> queryByCondition(OrderStatusStream orderStatusStream);
}
