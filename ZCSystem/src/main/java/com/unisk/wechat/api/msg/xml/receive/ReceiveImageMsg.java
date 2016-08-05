package com.unisk.wechat.api.msg.xml.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

/**
 * 
 * @Description:接收图片消息
 * @author shijingbang
 * @Date 2015年11月20日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReceiveImageMsg extends Msg {

	private static final long serialVersionUID = -8791704295493549369L;

	private String picUrl; // 图片链接

	private String msgId; // 消息id，64位整型

	private String mediaId;// 图片媒体文件id，可以调用获取媒体文件接口拉取数据

	private String agentId;// 企业应用的id，整型。可在应用的设置页面查看

	public String getPicUrl() {
		return picUrl;
	}

	@XmlElement(name = "PicUrl")
	@XmlCDATA
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMsgId() {
		return msgId;
	}

	@XmlElement(name = "MsgId")
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMediaId() {
		return mediaId;
	}

	@XmlElement(name = "MediaId")
	@XmlCDATA
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getAgentId() {
		return agentId;
	}

	@XmlElement(name = "AgentID")
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

}
