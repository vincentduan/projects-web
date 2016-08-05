package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.OrderContractGoods;

public interface OrderContractGoodsService extends BaseService<OrderContractGoods>{
	
	List<OrderContractGoods> queryByCondition(OrderContractGoods orderContractGoods);

}
