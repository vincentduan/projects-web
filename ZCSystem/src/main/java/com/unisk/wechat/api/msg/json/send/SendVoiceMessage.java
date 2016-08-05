package com.unisk.wechat.api.msg.json.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unisk.wechat.api.util.BooleanSerializer;

/**
 * 
 * @Description:主动发送json消息 之 音频消息
 * @author shijingbang
 * @Date 2015年11月25日
 */
public class SendVoiceMessage extends CommonMessage {
	private static final long serialVersionUID = -8142632078314446336L;

	@JsonProperty(value = "voice")
	private VoiceContent voice;// 音频内容

	@JsonSerialize(using = BooleanSerializer.class)
	@JsonProperty(value = "safe")
	private boolean safe;// 表示是否是保密消息，0表示否，1表示是，默认0

	public VoiceContent getVoice() {
		return voice;
	}

	public void setVoice(VoiceContent voice) {
		this.voice = voice;
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public static class VoiceContent {

		@JsonProperty(value = "media_id")
		private String mediaId;// 语音文件id，可以调用上传临时素材或者永久素材接口获取

		public VoiceContent() {
			super();
		}

		public VoiceContent(String mediaId) {
			super();
			this.mediaId = mediaId;
		}

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}

}
