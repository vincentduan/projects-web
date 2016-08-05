package com.unisk.wechat.api.msg.json.send;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @Description:主动发送json消息 之图文消息
 * @author shijingbang
 * @Date 2015年11月25日
 */
public class SendNewsMessage extends CommonMessage {
	private static final long serialVersionUID = -7391183758921795677L;

	@JsonProperty(value = "news")
	private NewsContent news;// 图文消息内容

	public NewsContent getNews() {
		return news;
	}

	public void setNews(NewsContent news) {
		this.news = news;
	}

	public static class NewsContent {

		@JsonProperty(value = "articles")
		private List<NewsArticle> articles;// 图文消息，一个图文消息支持1到10条图文

		public List<NewsArticle> getArticles() {
			return articles;
		}

		public void setArticles(List<NewsArticle> articles) {
			this.articles = articles;
		}
	}

	public static class NewsArticle {

		@JsonProperty(value = "title")
		private String title;// 标题

		@JsonProperty(value = "description")
		private String description;// 描述

		@JsonProperty(value = "url")
		private String url;// 点击后跳转的链接。

		@JsonProperty(value = "picurl")
		private String picurl;// 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80。如不填，在客户端不显示图片

		public NewsArticle() {
			super();
		}

		public NewsArticle(String title, String description, String url, String picurl) {
			super();
			this.title = title;
			this.description = description;
			this.url = url;
			this.picurl = picurl;
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

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getPicurl() {
			return picurl;
		}

		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}
	}
}
