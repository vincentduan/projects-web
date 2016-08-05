package com.efubao.core.bigc.vo;

import java.io.Serializable;
import java.util.List;

import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.sp.domain.ServiceProvider;

/**
 * 
 * Title: 订单详情，用户定制请求<br>
 * Description: <br>
 * Date: 2016年3月12日 <br>
 * 
 * @author
 */
public class OrderCustomDemandVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int count;
	//
	public OrderCustomDemand orderCustomDemand;
	//
	public List<OrderCustomGoods> orderCustomGoods;

	public ServiceProvider serviceProvider;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public OrderCustomDemand getOrderCustomDemand() {
		return orderCustomDemand;
	}

	public void setOrderCustomDemand(OrderCustomDemand orderCustomDemand) {
		this.orderCustomDemand = orderCustomDemand;
	}

	public List<OrderCustomGoods> getOrderCustomGoods() {
		return orderCustomGoods;
	}

	public void setOrderCustomGoods(List<OrderCustomGoods> orderCustomGoods) {
		this.orderCustomGoods = orderCustomGoods;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

}
