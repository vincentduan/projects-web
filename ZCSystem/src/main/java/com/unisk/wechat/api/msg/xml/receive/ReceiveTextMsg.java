package com.unisk.wechat.api.msg.xml.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

/**
 * 
 * @Description:接受普通文本消息
 * @author shijingbang
 * @Date 2015年11月20日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReceiveTextMsg extends Msg {
	private static final long serialVersionUID = 5764061031471020604L;
	private String content; // 文本消息内容

	private String msgId; // 消息id，64位整型

	private String agentId;// 企业应用的id，整型。可在应用的设置页面查看

	public String getContent() {
		return content;
	}

	@XmlElement(name = "Content")
	@XmlCDATA
	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	@XmlElement(name = "MsgId")
	@XmlCDATA
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getAgentId() {
		return agentId;
	}

	@XmlElement(name = "AgentID")
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
}
