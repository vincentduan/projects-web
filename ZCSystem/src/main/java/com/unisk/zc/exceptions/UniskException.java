package com.unisk.zc.exceptions;

import com.unisk.zc.entitys.commons.ResBean;

import net.sf.json.JSONObject;

public class UniskException extends Exception {

	/** TODO */
	private static final long serialVersionUID = -7792483842925635491L;

	private String errorCode;
	private String errorDesc;

	public UniskException() {
		super();
	}

	public UniskException(String message, Throwable cause) {
		super(message, cause);
		cause.getStackTrace();
	}

	public UniskException(String message) {
		super(message);
	}

	public UniskException(Throwable cause) {
		super(cause);
		cause.printStackTrace();

	}
	/**
	 * 返回异常中的错误码
	 * @param errorCode
	 * @param errorDesc
	 * @param message
	 */
	public UniskException(String errorCode,String errorDesc,String message){
		super(message);
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}
	
	public static RuntimeException unchecked(Exception e){
	    if ((e instanceof RuntimeException)) {
	      return (RuntimeException)e;
	    }
	    return new RuntimeException(e);
	}
	 
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}
	
	public String toString(){
		ResBean bean = new ResBean();
		bean.setStatus("1");
		bean.setReset(errorCode);
		bean.setDesc(errorDesc);
		
		JSONObject json = JSONObject.fromObject(bean);
		
		return json.toString();
	}
	
	public ResBean toResBean(){
		ResBean bean = new ResBean();
		bean.setStatus("1");
		bean.setReset(errorCode);
		bean.setDesc(errorDesc);
		
		return bean;
	}

}
