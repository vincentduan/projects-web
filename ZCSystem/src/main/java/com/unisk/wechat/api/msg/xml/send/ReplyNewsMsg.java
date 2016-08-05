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
 * @Description:被动响应消息 --图文消息(news消息)
 * @author shijingbang
 * @Date 2015年11月20日
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReplyNewsMsg extends Msg {

	private static final long serialVersionUID = -5755579932121722010L;

	private long articleCount;// 图文消息条数

	private List<InnerNewsMsg> news;// 图文消息集合

	public long getArticleCount() {
		return articleCount;
	}

	@XmlElement(name = "ArticleCount")
	public void setArticleCount(long articleCount) {
		this.articleCount = articleCount;
	}

	public List<InnerNewsMsg> getNews() {
		return news;
	}

	@XmlElementWrapper(name = "Articles")
	@XmlElement(name = "item")
	public void setNews(List<InnerNewsMsg> news) {
		this.news = news;
	}

	@XmlAccessorType(XmlAccessType.PROPERTY)
	public static class InnerNewsMsg {
		private String title;// 图文消息标题
		private String description;// 图文消息描述
		private String picUrl;// 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
		private String url;// 点击图文消息跳转链接

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

		public String getPicUrl() {
			return picUrl;
		}

		@XmlElement(name = "PicUrl")
		@XmlCDATA
		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public String getUrl() {
			return url;
		}

		@XmlElement(name = "Url")
		@XmlCDATA
		public void setUrl(String url) {
			this.url = url;
		}
	}

}
