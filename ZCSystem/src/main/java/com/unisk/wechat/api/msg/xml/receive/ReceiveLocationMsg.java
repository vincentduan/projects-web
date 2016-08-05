package com.unisk.wechat.api.msg.xml.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

/**
 * 
 * @Description:接收地理位置消息
 * @author shijingbang
 * @Date 2015年11月20日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReceiveLocationMsg extends Msg {

	private static final long serialVersionUID = -3197167500762810157L;
	private String locationX;// 地理位置纬度
	private String locationY;// 地理位置经度
	private String scale;// 地图缩放大小
	private String label;// 地理位置信息
	private String msgId;// 消息id，64位整型
	private String agentID;// 企业应用的id，整型。可在应用的设置页面查看

	public String getLocationX() {
		return locationX;
	}

	@XmlElement(name = "Location_X")
	@XmlCDATA
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	@XmlElement(name = "Location_Y")
	@XmlCDATA
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getScale() {
		return scale;
	}

	@XmlElement(name = "Scale")
	@XmlCDATA
	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	@XmlElement(name = "Label")
	@XmlCDATA
	public void setLabel(String label) {
		this.label = label;
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
