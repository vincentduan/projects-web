package com.unisk.wechat.api.support;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unisk.wechat.api.util.BeanUtils;

/**
 * 
 * @Description:微信消息处理抽象类，子类实现process方法，处理腾讯微信平台发送过来的各类消息、事件
 * @author shijingbang
 * @Date 2015年11月19日
 */
public abstract class MessageHandler {
	private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);
	private String msgType;// 消息类型

	private String event;// 事件类型

	private String eventKey;// 事件类型Key

	public MessageHandler(String msgType) {
		this(msgType, null);
	}

	/**
	 * 基于微信内嵌的事件 消息
	 * 
	 * @param msgType
	 * @param event
	 */
	public MessageHandler(String msgType, String event) {
		this.msgType = msgType;
		this.event = event;
	}

	/**
	 * 基于用于自定义的事件消息 eventKey由用户自定义
	 * 
	 * @param msgType
	 * @param event
	 * @param eventKey
	 */
	public MessageHandler(String msgType, String event, String eventKey) {
		super();
		this.msgType = msgType;
		this.event = event;
		this.eventKey = eventKey;
	}

	public String process(Map<String, Object> map) {
		return processRequest(map);
	};

	/**
	 * 处理请求
	 * 
	 * @param map
	 * @return
	 */
	public abstract String processRequest(Map<String, Object> map);

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * 将请求参数map封装成对应的消息实体封装Bean
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public <T> T convertMapToBean(Map<String, Object> map, Class<T> clazz) {

		T t;
		try {
			t = clazz.newInstance();
			BeanUtils.copyProperties(t, map);
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

}
