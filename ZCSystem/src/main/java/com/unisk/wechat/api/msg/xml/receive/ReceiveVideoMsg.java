package com.unisk.wechat.api.msg.xml.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

/**
 * 
 * @Description:接收视频消息
 * @author shijingbang
 * @Date 2015年11月20日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReceiveVideoMsg extends Msg {
	private static final long serialVersionUID = 72512008185450303L;

	private String mediaId;// 视频媒体文件id，可以调用获取媒体文件接口拉取数据
	private String thumbMediaId;// 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据
	private String msgId;// 消息id，64位整型
	private String agentId;// 企业应用的id，整型。可在应用的设置页面查看

	public String getMediaId() {
		return mediaId;
	}

	@XmlElement(name = "MediaId")
	@XmlCDATA
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	@XmlElement(name = "ThumbMediaId")
	@XmlCDATA
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
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
