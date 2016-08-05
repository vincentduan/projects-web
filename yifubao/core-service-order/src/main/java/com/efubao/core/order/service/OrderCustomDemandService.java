package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.OrderCustomDemand;

public interface OrderCustomDemandService extends BaseService<OrderCustomDemand>{

	List<OrderCustomDemand> queryByCondition(OrderCustomDemand orderCustomDemand);
}
