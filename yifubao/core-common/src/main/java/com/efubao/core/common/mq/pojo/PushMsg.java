package com.efubao.core.common.mq.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * app push message
 * 
 * 
 */
public class PushMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4608249450133480897L;
	/** 消息类型:0-支付，1-退款，2-申诉 ,11-通知（到APP首页）,12-活动详情,13-发现,14-微店,15-消息列表*/
	@JsonProperty("t")
	private int type;
	@JsonProperty("o")
	private BigDecimal orderNo;
	@JsonProperty("m")
	private BigDecimal mallID;
	/** 消息发送时间 */
	@JsonProperty("ct")
	private Date timestamp = new Date();

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BigDecimal getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(BigDecimal orderNo) {
		this.orderNo = orderNo;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public BigDecimal getMallID() {
		return mallID;
	}

	public void setMallID(BigDecimal mallID) {
		this.mallID = mallID;
	}

}
