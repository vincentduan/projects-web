package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.OrderCustomerInfo;

public interface OrderCustomerInfoService extends BaseService<OrderCustomerInfo>{
	
	List<OrderCustomerInfo> queryByCondition(OrderCustomerInfo orderCustomerInfo);

}
