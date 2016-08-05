/**
 * BusinessExceptionEnum.java
 * Copyright (c) 2013 by lashou.com
 */
package com.efubao.core.auth.exception;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * business exception enum
 *
 */
public enum BusinessExceptionEnum {
	
	/**
	 * form expired
	 */
	FORM_EXPIRED(501, "表单数据已过期，已有他人在您之前修改了数据，请在其基础上再修改后提交"),
	/**
	 * user have not any group
	 */
	NO_GROUP(502, "V系统账户没有开通，请发送邮件给v@lashou-inc.com，抄送城市经理进行开通。邮件里请写明自己所属城市或者组！");
	/**
	 * BusinessException
	 */
	private BusinessException be;
	
	/**
	 * a
	 * @param code error code
	 * @param message error message
	 */
	private BusinessExceptionEnum(final int code, final String message) {
		this.be = new BusinessException(code, message);
	}

	/**
	 * Return the enum constant of this type with the specified integer value.
	 * @param code error code
	 * @return the enum constant with the specified integer value
	 * @throws IllegalArgumentException if this enum has no constant for the specified integer value
	 */
	public static BusinessExceptionEnum valueOf(int code) {
		for (BusinessExceptionEnum bee : values()) {
			if (bee.be.getId() == code) {
				return bee;
			}
		}
		throw new IllegalArgumentException("No matching constant for [" + code + "]");
	}
	
	/**
	 * Return a string representation of this qualification ID.
	 * @return qualification ID and fullname
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public BusinessException getBe() {
		return be;
	}
	
}
