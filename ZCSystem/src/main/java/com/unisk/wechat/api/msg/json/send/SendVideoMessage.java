package com.unisk.wechat.api.msg.json.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unisk.wechat.api.util.BooleanSerializer;

/**
 * 
 * @Description:主动发送json消息 之视频消息
 * @author shijingbang
 * @Date 2015年11月25日
 */
public class SendVideoMessage extends CommonMessage {

	private static final long serialVersionUID = -8355723654654104638L;
	@JsonProperty(value = "video")
	private VideoContent video;// 视频内容

	@JsonSerialize(using = BooleanSerializer.class)
	@JsonProperty(value = "safe")
	private boolean safe;// 表示是否是保密消息，0表示否，1表示是，默认0

	public VideoContent getVideo() {
		return video;
	}

	public void setVideo(VideoContent video) {
		this.video = video;
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public static class VideoContent {

		@JsonProperty(value = "media_id")
		private String mediaId;// 视频媒体文件id，可以调用上传临时素材或者永久素材接口获取

		@JsonProperty(value = "title")
		private String title;// 视频消息的标题

		@JsonProperty(value = "description")
		private String description;// 视频消息的描述

		public VideoContent() {
			super();
		}

		public VideoContent(String mediaId, String title, String description) {
			super();
			this.mediaId = mediaId;
			this.title = title;
			this.description = description;
		}

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}

}
