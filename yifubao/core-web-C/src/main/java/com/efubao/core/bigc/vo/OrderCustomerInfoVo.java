package com.efubao.core.bigc.vo;

import java.io.Serializable;
import java.util.List;

import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.ReceiveAddress;

/**
 * 
 * Title: 订单详情，客户信息<br>
 * Description: <br>
 * Date: 2016年3月12日 <br>
 * 
 * @author
 */
public class OrderCustomerInfoVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderCustomerInfo orderCustomerInfo;

	public ReceiveAddress receiveAddress;

	public List<OrderMeasureAddress> list;

	public OrderCustomerInfo getOrderCustomerInfo() {
		return orderCustomerInfo;
	}

	public void setOrderCustomerInfo(OrderCustomerInfo orderCustomerInfo) {
		this.orderCustomerInfo = orderCustomerInfo;
	}

	public List<OrderMeasureAddress> getList() {
		return list;
	}

	public void setList(List<OrderMeasureAddress> list) {
		this.list = list;
	}

	public ReceiveAddress getReceiveAddress() {
		return receiveAddress;
	}

	public void setReceiveAddress(ReceiveAddress receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

}
