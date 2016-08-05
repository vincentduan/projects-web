package com.unisk.wechat.api.msg.xml.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

/**
 * 
 * @Description:接收音频消息
 * @author shijingbang
 * @Date 2015年11月20日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReceiveVoiceMsg extends Msg {

	private static final long serialVersionUID = -704718235149968850L;
	private String mediaId;// 语音媒体文件id，可以调用获取媒体文件接口拉取数据
	private String format;// 语音格式，如amr，speex等
	private String msgId;// 消息id，64位整型
	private String agentID;// 企业应用的id，整型。可在应用的设置页面查看

	public String getMediaId() {
		return mediaId;
	}

	@XmlElement(name = "MediaId")
	@XmlCDATA
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	@XmlElement(name = "Format")
	@XmlCDATA
	public void setFormat(String format) {
		this.format = format;
	}

	public String getMsgId() {
		return msgId;
	}

	@XmlElement(name = "MsgId")
	@XmlCDATA
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getAgentID() {
		return agentID;
	}

	@XmlElement(name = "AgentID")
	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}
}
