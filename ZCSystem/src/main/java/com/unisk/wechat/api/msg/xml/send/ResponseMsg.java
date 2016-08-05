package com.unisk.wechat.api.msg.xml.send;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 
 * @Description:微信 被动响应消息 实体类
 * @author shijingbang
 * @Date 2015年11月19日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseMsg implements Serializable {

	private static final long serialVersionUID = -1883945667132867179L;

	@XmlCDATA
	@XmlElement(name = "Encrypt")
	private String encryptMsg;// 加密后的密文

	@XmlCDATA
	@XmlElement(name = "MsgSignature")
	private String msgSignature;// 消息签名

	@XmlElement(name = "TimeStamp")
	private long timeStamp;// 时间戳

	@XmlCDATA
	@XmlElement(name = "Nonce")
	private String nonce;// 随机数

	public String getEncryptMsg() {
		return encryptMsg;
	}

	public void setEncryptMsg(String encryptMsg) {
		this.encryptMsg = encryptMsg;
	}

	public String getMsgSignature() {
		return msgSignature;
	}

	public void setMsgSignature(String msgSignature) {
		this.msgSignature = msgSignature;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

}
