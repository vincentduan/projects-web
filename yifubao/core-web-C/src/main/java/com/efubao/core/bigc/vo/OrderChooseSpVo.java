package com.efubao.core.bigc.vo;

import java.sql.Timestamp;

import com.efubao.core.sp.domain.ServiceProvider;

/**
 * Title: <br>
 * Description: 选择供应商列表信息<br>
 * Date: 2016年3月12日 <br>
 * 
 * @author duandingyang
 */
public class OrderChooseSpVo {
	String orderNo;
	ServiceProvider serviceProvider;
	int status;
	Timestamp create_time;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

}
