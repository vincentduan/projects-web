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
 * @Description:被动响应消息--音频消息
 * @author shijingbang
 * @Date 2015年11月20日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReplyVoiceMsg extends Msg {
	private static final long serialVersionUID = -7506074098286714376L;

	private List<String> mediaIds;// 语音文件id

	public List<String> getMediaIds() {
		return mediaIds;
	}

	@XmlElementWrapper(name = "Voice")
	@XmlElement(name = "MediaId")
	@XmlCDATA
	public void setMediaIds(List<String> mediaIds) {
		this.mediaIds = mediaIds;
	}
}
