package com.unisk.wechat.api.msg.json.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unisk.wechat.api.util.BooleanSerializer;

/**
 * 
 * @Description:主动发送json消息 之 图片消息
 * @author shijingbang
 * @Date 2015年11月25日
 */
public class SendImageMessage extends CommonMessage {

	private static final long serialVersionUID = -8081428676937614368L;

	@JsonProperty(value = "image")
	private ImageContent image;// 图片内容

	@JsonSerialize(using = BooleanSerializer.class)
	@JsonProperty(value = "safe")
	private boolean safe;// 表示是否是保密消息，0表示否，1表示是，默认0

	public ImageContent getImage() {
		return image;
	}

	public void setImage(ImageContent image) {
		this.image = image;
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public static class ImageContent {
		@JsonProperty(value = "media_id")
		private String mediaId;// 图片媒体文件id，可以调用上传临时素材或者永久素材接口获取,永久素材media_id必须由发消息的应用创建

		public ImageContent() {
			super();
		}

		public ImageContent(String mediaId) {
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
