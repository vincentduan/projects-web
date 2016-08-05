/**
 * BusinessException.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.core.common.exception;

/**
 * business exception
 * 业务异常
 *
 */
public class BusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7540358735854798964L;
	
	/** 状态码 */
	private int id = 0;

	/**
	 * contractor
	 * @param message error message
	 */
	public BusinessException(final String message) {
		super(message);
	}
	
	/**
	 * contractor
	 * @param id error code
	 * @param message error message
	 */
	public BusinessException(final int id, final String message) {
		super(message);
		this.id = id;
	}

	@Override
	public String getMessage() {
        return super.getMessage();
    }
	
	public int getId() {
		return id;
	}

}
