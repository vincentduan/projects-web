package com.unisk.wechat.api.msg.xml.receive;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 
 * @Description:用于封装微信平台发送过来的加密过得xml格式消息
 * @author shijingbang
 * @Date 2015年11月24日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestMsg implements Serializable {
	private static final long serialVersionUID = -6276787226245782977L;
	@XmlCDATA
	@XmlElement(name = "Encrypt")
	private String encryptMsg;// 加密后的密文

	@XmlCDATA
	@XmlElement(name = "AgentID")
	private String agentId;// 应用代理ID

	@XmlCDATA
	@XmlElement(name = "ToUserName")
	private String toUserName;// 企业号CorpID

	public String getEncryptMsg() {
		return encryptMsg;
	}

	public void setEncryptMsg(String encryptMsg) {
		this.encryptMsg = encryptMsg;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	@Override
	public String toString() {
		return "RequestMsg [encryptMsg=" + encryptMsg + ", agentId=" + agentId + ", toUserName=" + toUserName + "]";
	}
}
