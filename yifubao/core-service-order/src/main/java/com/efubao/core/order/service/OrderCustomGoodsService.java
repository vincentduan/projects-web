package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.OrderCustomGoods;

public interface OrderCustomGoodsService extends BaseService<OrderCustomGoods>{

	List<OrderCustomGoods> queryByCondition(OrderCustomGoods orderCustomGoods);
}
