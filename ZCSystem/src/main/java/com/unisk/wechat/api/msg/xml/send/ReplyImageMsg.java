package com.unisk.wechat.api.msg.xml.send;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

/**
 * 
 * @Description:被动响应消息--image消息
 * @author shijingbang
 * @Date 2015年11月18日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReplyImageMsg extends Msg {

	private static final long serialVersionUID = -8777915216855051258L;

	private String picUrl; // 图片链接

	private String msgId; // 消息id，64位整型

	private List<String> mediaId; // 图片消息媒体id

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

	public List<String> getMediaId() {
		return mediaId;
	}

	@XmlElementWrapper(name = "Image")
	@XmlElement(name = "MediaId")
	@XmlCDATA
	public void setMediaId(List<String> mediaId) {
		this.mediaId = mediaId;
	}

}
