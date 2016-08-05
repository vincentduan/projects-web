package com.unisk.wechat.api.msg.json.send;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unisk.wechat.api.util.BooleanSerializer;
import com.unisk.wechat.api.util.JsonUtil;

/**
 * 
 * @Description:主动发送json消息 之 普通文本消息
 * @author shijingbang
 * @Date 2015年11月25日
 */
public class SendTextMessage extends CommonMessage {

	private static final long serialVersionUID = -4298893213268406958L;

	@JsonProperty(value = "text")
	private TextContent text;// 消息内容

	@JsonSerialize(using = BooleanSerializer.class)
	@JsonProperty(value = "safe")
	private boolean safe;// 表示是否是保密消息，0表示否，1表示是，默认0

	public TextContent getText() {
		return text;
	}

	public void setText(TextContent text) {
		this.text = text;
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public static class TextContent {

		@JsonProperty(value = "content")
		private String content;// 文本内容

		public TextContent(String content) {
			super();
			this.content = content;
		}

		public TextContent() {
			super();
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public static void main(String[] args) {
		SendTextMessage sendMsg = new SendTextMessage();
		List<String> toUser = new ArrayList<String>();
		toUser.add("@all");
		sendMsg.setToUser(toUser);

		sendMsg.setAgentId("2");
		sendMsg.setMsgType("text");
		sendMsg.setSafe(false);
		sendMsg.setText(new TextContent("shijingbang测试群发接口中...."));
		System.out.println(JsonUtil.toJsonByJackson(sendMsg));
	}

}
