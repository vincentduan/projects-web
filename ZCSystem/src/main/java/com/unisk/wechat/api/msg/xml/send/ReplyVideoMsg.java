package com.unisk.wechat.api.msg.xml.send;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import com.unisk.wechat.api.msg.Msg;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReplyVideoMsg extends Msg {

	private static final long serialVersionUID = 954851059349010979L;

	private VideoMsg video;

	public VideoMsg getVideo() {
		return video;
	}

	@XmlElement(name = "Video")
	public void setVideo(VideoMsg video) {
		this.video = video;
	}

	@XmlAccessorType(XmlAccessType.PROPERTY)
	public static class VideoMsg implements Serializable {
		private static final long serialVersionUID = 1265971477350587796L;

		private String mediaId;

		private String title;

		private String description;

		public String getMediaId() {
			return mediaId;
		}

		@XmlElement(name = "MediaId")
		@XmlCDATA
		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		public String getTitle() {
			return title;
		}

		@XmlElement(name = "Title")
		@XmlCDATA
		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		@XmlElement(name = "Description")
		@XmlCDATA
		public void setDescription(String description) {
			this.description = description;
		}
	}
}
