package com.unisk.zc.entitys.commons;

import java.io.Serializable;

import com.unisk.zc.utils.Constant;



public class ResBean implements Serializable {
	
	private static final long serialVersionUID = -2305190961826394607L;
	
	private String status = "0";
	private String reset = Constant.SUCCESS_CODE;
	private String desc = Constant.SUCCESS_DESC;
	
	
	public String getStatus() {
		return status;
	}
	public String getReset() {
		return reset;
	}
	public String getDesc() {
		return desc;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setReset(String reset) {
		this.reset = reset;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
