package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.BaseOrder;

public interface BaseOrderService extends BaseService<BaseOrder>{
	
	public BaseOrder findByOrderNo(String orderNo);
	
	List<BaseOrder> queryByCondition(BaseOrder baseOrder);

	public int deleteByOrderNo(String orderNo);
}
