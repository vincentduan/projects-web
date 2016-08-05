package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.ReceiveAddress;

public interface ReceiveAddressService extends BaseService<ReceiveAddress>{

	List<ReceiveAddress> queryByCondition(ReceiveAddress receiveAddress);
}
