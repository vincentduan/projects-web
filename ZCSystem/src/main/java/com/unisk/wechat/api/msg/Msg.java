package com.unisk.wechat.api.msg;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用消息实体封装类，文本消息，图片消息等格式都包含此属性
 * 
 * @author bang
 * @Date 2015-11-18
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Msg implements Serializable {
	private static final long serialVersionUID = -2508363707277366521L;
	protected static final Logger logger = LoggerFactory.getLogger(Msg.class);
	public static final String MSG_TYPE = "MsgType"; // 消息类型
	public static final String MSG_TYPE_TEXT = "text"; // 文本消息
	public static final String MSG_TYPE_IMAGE = "image"; // 图片消息
	public static final String MSG_TYPE_MUSIC = "music"; // 音乐消息
	public static final String MSG_TYPE_LOCATION = "location"; // 地理位置消息
	public static final String MSG_TYPE_LINK = "link"; // 链接消息
	public static final String MSG_TYPE_IMAGE_TEXT = "news"; // 图文消息
	public static final String MSG_TYPE_IMAGE_TEXT_MUTI = "mpnews"; // 图文消息
	public static final String MSG_TYPE_EVENT = "Event"; // 事件消息
	public static final String MSG_TYPE_EVENT_KEY = "EventKey"; // 事件消息Key
	public static final String MSG_TYPE_VOICE = "voice"; // 语音识别消息
	public static final String MSG_TYPE_VIDEO = "video"; // 视频消息
	public static final String MSG_TYPE_SHORT_VIDEO = "shortvideo"; // 小视频消息

	private String toUserName; // 开发者微信号(企业号CorpID)
	private String fromUserName; // 发送方帐号（成员UserID,一个OpenID）
	private String createTime; // 消息创建时间 （整型）
	private String msgType; // 消息类型：text\image\...

	public String getToUserName() {
		return toUserName;
	}

	@XmlElement(name = "ToUserName")
	@XmlCDATA
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	@XmlElement(name = "FromUserName")
	@XmlCDATA
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	@XmlElement(name = "CreateTime")
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	@XmlElement(name = "MsgType")
	@XmlCDATA
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@Override
	public String toString() {
		return "Msg [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime + ", msgType=" + msgType;
	}
}
