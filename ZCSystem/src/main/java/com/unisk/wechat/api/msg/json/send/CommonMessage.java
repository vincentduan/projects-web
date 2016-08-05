package com.unisk.wechat.api.msg.json.send;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unisk.wechat.api.msg.Msg;
import com.unisk.wechat.api.msg.json.send.SendTextMessage.TextContent;
import com.unisk.wechat.api.util.ListStringSerializer;

/**
 * 
 * @Description:微信发送json消息 基础共性属性封装类 子类继承扩展定义不同消息类型的其他属性
 * @author shijingbang
 * @Date 2015年11月24日
 */
@JsonPropertyOrder({ "toUser", "toParty", "toTag", "msgType", "agentId" })
public class CommonMessage implements Serializable {

	private static final long serialVersionUID = -7154785608510545118L;

	// 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
	@JsonSerialize(using = ListStringSerializer.class)
	@JsonProperty(value = "touser")
	private List<String> toUser = new ArrayList<String>();

	@JsonSerialize(using = ListStringSerializer.class)
	@JsonProperty(value = "toparty")
	private List<String> toParty = new ArrayList<String>();// 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数

	@JsonSerialize(using = ListStringSerializer.class)
	@JsonProperty(value = "totag")
	private List<String> toTag = new ArrayList<String>();// 标签ID列表，多个接收者用‘|’分隔。当touser为@all时忽略本参数

	@JsonProperty(value = "msgtype")
	private String msgType;// 消息类型 text\image\voice\video\news\file\mpnews

	@JsonProperty(value = "agentid")
	private String agentId;// 企业应用的id，整型。可在应用的设置页面查看

	public static void main(String[] args) throws JsonProcessingException {
		SendTextMessage msg = new SendTextMessage();
		List<String> toUser = new ArrayList<String>();
		toUser.add("shijingbang");
		toUser.add("haha");
		toUser.add("zhoujielun");
		msg.setToUser(toUser);
		String s = StringUtils.collectionToDelimitedString(toUser, "|");
		System.out.println(s);

		List<String> toParty = new ArrayList<String>();
		toParty.add("部门一");
		toParty.add("部门二");
		toParty.add("部门三");
		msg.setToParty(toParty);

		List<String> toTag = new ArrayList<String>();
		toTag.add("标签一");
		toTag.add("标签二");
		toTag.add("标签三");
		msg.setToTag(toTag);

		msg.setMsgType(Msg.MSG_TYPE_TEXT);
		msg.setAgentId("2");
		TextContent text = new TextContent("我是谁啊");
		msg.setText(text);
		// msg.setSafe(true);

		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(msg);
		System.out.println(result);

	}

	public List<String> getToUser() {
		return toUser;
	}

	public void setToUser(List<String> toUser) {
		this.toUser = toUser;
	}

	public List<String> getToParty() {
		return toParty;
	}

	public void setToParty(List<String> toParty) {
		this.toParty = toParty;
	}

	public List<String> getToTag() {
		return toTag;
	}

	public void setToTag(List<String> toTag) {
		this.toTag = toTag;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

}
