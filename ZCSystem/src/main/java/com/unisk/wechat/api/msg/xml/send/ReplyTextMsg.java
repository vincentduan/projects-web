package com.unisk.wechat.api.msg.xml.send;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

/**
 * 被动响应消息--普通文本消息
 * 
 * @author bang
 * @Date 2015-11-18
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReplyTextMsg extends Msg {

	private static final long serialVersionUID = 4961359264970837782L;

	private String content; // 文本消息内容

	public String getContent() {
		return content;
	}

	@XmlElement(name = "Content")
	@XmlCDATA
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReplyTextMsg [content=" + content + "]";
	}

}
