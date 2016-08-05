package com.efubao.core.sp.vo;

import java.math.BigDecimal;
import java.util.List;

import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.OrderContract;
import com.efubao.core.order.domain.OrderContractGoods;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.domain.SpContract;

public class OrderContractVo {
	
    public int totalNum;
    
    public BigDecimal finalMoney;
    
    public OrderContractVo orderContractVo;
    
    public ServiceProvider serviceProvider;
    
    public OrderContract orderContract;
    
    public List<OrderContractGoods> list;
    
    public SpContract spContract;
    
    public BaseOrder baseOrder;

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public OrderContract getOrderContract() {
		return orderContract;
	}

	public void setOrderContract(OrderContract orderContract) {
		this.orderContract = orderContract;
	}

	public List<OrderContractGoods> getList() {
		return list;
	}

	public void setList(List<OrderContractGoods> list) {
		this.list = list;
	}

	public OrderContractVo getOrderContractVo() {
		return orderContractVo;
	}

	public void setOrderContractVo(OrderContractVo orderContractVo) {
		this.orderContractVo = orderContractVo;
	}

	public SpContract getSpContract() {
		return spContract;
	}

	public void setSpContract(SpContract spContract) {
		this.spContract = spContract;
	}

	public BaseOrder getBaseOrder() {
		return baseOrder;
	}

	public void setBaseOrder(BaseOrder baseOrder) {
		this.baseOrder = baseOrder;
	}

	public BigDecimal getFinalMoney() {
		return finalMoney;
	}

	public void setFinalMoney(BigDecimal finalMoney) {
		this.finalMoney = finalMoney;
	}
	
}
