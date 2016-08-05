package com.efubao.core.sp.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomerInfo;
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
	// 定制的客户的信息
	public OrderCustomerInfo orderCustomerInfo;
	// 定制的状态的信息
	public int status;
	public Timestamp createTime;

	public int orderStatus;

	private BigDecimal totalMoney;
	private BigDecimal frontMoney;
	private BigDecimal balancePayment;

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getFrontMoney() {
		return frontMoney;
	}

	public void setFrontMoney(BigDecimal frontMoney) {
		this.frontMoney = frontMoney;
	}

	public BigDecimal getBalancePayment() {
		return balancePayment;
	}

	public void setBalancePayment(BigDecimal balancePayment) {
		this.balancePayment = balancePayment;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public OrderCustomerInfo getOrderCustomerInfo() {
		return orderCustomerInfo;
	}

	public void setOrderCustomerInfo(OrderCustomerInfo orderCustomerInfo) {
		this.orderCustomerInfo = orderCustomerInfo;
	}

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
