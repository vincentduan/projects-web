package com.efubao.core.bigc.controller.common;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.bigc.vo.OrderCustomDemandVo;
import com.efubao.core.bigc.vo.OrderCustomerInfoVo;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.ReceiveAddress;
import com.efubao.core.order.service.BaseOrderService;
import com.efubao.core.order.service.OrderCustomDemandService;
import com.efubao.core.order.service.OrderCustomGoodsService;
import com.efubao.core.order.service.OrderCustomerInfoService;
import com.efubao.core.order.service.OrderMeasureAddressService;
import com.efubao.core.order.service.OrderServiceProviderService;
import com.efubao.core.order.service.OrderStatusStreamService;
import com.efubao.core.order.service.ReceiveAddressService;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.service.ServiceProviderService;

public class CommonOrderInfo {

	@Autowired
	public BaseOrderService baseOrderService;
	@Autowired
	public OrderCustomerInfoService orderCustomerInfoService;
	@Autowired
	public CategoryService categoryService;
	@Autowired
	public OrderCustomDemandService orderCustomDemandService;
	@Autowired
	public OrderStatusStreamService orderStatusStreamService;
	@Autowired
	public OrderMeasureAddressService orderMeasureAddressService;
	@Autowired
	public ReceiveAddressService receiveAddressService;
	@Autowired
	public OrderCustomGoodsService orderCustomGoodsService;
	@Autowired
	public OrderServiceProviderService orderServiceProviderService;
	@Autowired
	public ServiceProviderService serviceProviderService;

	public BaseOrder getBaseOrder(String orderNo) {
		BaseOrder baseOrder = baseOrderService.findByOrderNo(orderNo);
		return baseOrder;
	}

	public OrderCustomerInfoVo getOrderCInfoVo(String orderNo) {

		OrderCustomerInfo orderCustomerInfo = new OrderCustomerInfo();
		OrderMeasureAddress orderMeasureAddress = new OrderMeasureAddress();
		ReceiveAddress reciveAddress = new ReceiveAddress();
		OrderCustomerInfoVo orderCustomerInfoVo = new OrderCustomerInfoVo();
		orderCustomerInfo.setOrderNo(orderNo);
		List<OrderCustomerInfo> list = orderCustomerInfoService.queryByCondition(orderCustomerInfo);
		if (list.size() > 0) {
			orderCustomerInfoVo.setOrderCustomerInfo(list.get(0));
		}
		orderMeasureAddress.setOrderNo(orderNo);
		List<OrderMeasureAddress> li = orderMeasureAddressService.queryByCondition(orderMeasureAddress);
		orderCustomerInfoVo.setList(li);

		reciveAddress.setOrderNo(orderNo);
		List<ReceiveAddress> listra = receiveAddressService.queryByCondition(reciveAddress);
		if (listra.size() > 0) {
			orderCustomerInfoVo.setReceiveAddress(listra.get(0));
		}
		return orderCustomerInfoVo;
	}

	public OrderCustomDemandVo getOrderCDemandVo(String orderNo) {
		Integer count = 0;
		OrderCustomDemandVo orderCustomDemandVo = new OrderCustomDemandVo();
		OrderCustomDemand orderCustomDemand = new OrderCustomDemand();
		OrderCustomGoods orderCustomGoods = new OrderCustomGoods();
		ServiceProvider serviceProvider = new ServiceProvider();

		orderCustomDemand.setOrderNo(orderNo);
		List<OrderCustomDemand> lists = orderCustomDemandService.queryByCondition(orderCustomDemand);
		if (lists.size() > 0) {
			if (lists.get(0).getId() > 0) {
				orderCustomGoods.setOrderCustomDemandId(lists.get(0).getId());
			}
			if (StringUtils.isNotBlank(String.valueOf(lists.get(0).getSpId()))) {
				serviceProvider = serviceProviderService.findById(lists.get(0).getSpId());
				orderCustomDemandVo.setServiceProvider(serviceProvider);
			}
		}
		List<OrderCustomGoods> l = orderCustomGoodsService.queryByCondition(orderCustomGoods);

		for (OrderCustomGoods ocg : l) {
			count += ocg.getGoodsNum();
		}
		orderCustomDemandVo.setOrderCustomGoods(l);
		orderCustomDemandVo.setOrderCustomDemand(lists.get(0));
		orderCustomDemandVo.setCount(count);

		return orderCustomDemandVo;
	}

}
