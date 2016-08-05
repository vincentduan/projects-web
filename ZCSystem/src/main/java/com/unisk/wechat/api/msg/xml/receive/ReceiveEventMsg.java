package com.unisk.wechat.api.msg.xml.receive;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

/**
 * 
 * @Description:用于封装请求过来的xml格式的 事件消息内容
 * @author shijingbang
 * @Date 2015年11月26日
 */
public class ReceiveEventMsg extends Msg {
	private static final long serialVersionUID = -541659296417874601L;
	private String agentId;// 企业应用的id，整型。可在应用的设置页面查看

	private String event;// 事件类型

	private String eventKey;// 事件类型 下对应的key

	public String getAgentId() {
		return agentId;
	}

	@XmlElement(name = "AgentID")
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getEvent() {
		return event;
	}

	@XmlElement(name = "Event")
	@XmlCDATA
	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	@XmlElement(name = "EventKey")
	@XmlCDATA
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
