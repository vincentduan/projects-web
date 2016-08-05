package com.efubao.core.admin.controller.common;



public class ResObj<T> {

	private int code;

	private MsgObj message;

	private PageVo<T> page;

	private T businessObj;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public MsgObj getMessage() {
		return message;
	}

	public void setMessage(MsgObj message) {
		this.message = message;
	}

	public PageVo<T> getPage() {
		return page;
	}

	public void setPage(PageVo<T> page) {
		this.page = page;
	}

	public T getBusinessObj() {
		return businessObj;
	}

	public void setBusinessObj(T businessObj) {
		this.businessObj = businessObj;
	}

}
