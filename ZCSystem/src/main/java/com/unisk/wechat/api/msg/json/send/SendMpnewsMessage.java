package com.unisk.wechat.api.msg.json.send;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unisk.wechat.api.util.BooleanSerializer;

/**
 * 
 * @Description:主动发送json消息 之图文消息
 *                         mpnews消息与news消息类似，不同的是图文消息内容存储在微信后台，并且支持保密选项。每个应用每天最多可以发送100次
 * @author shijingbang
 * @Date 2015年11月25日
 */
public class SendMpnewsMessage extends CommonMessage {

	private static final long serialVersionUID = 5260791657332990133L;
	@JsonProperty(value = "mpnews")
	private MpnewsContent mpnews;// 图文消息内容

	@JsonSerialize(using = BooleanSerializer.class)
	@JsonProperty(value = "safe")
	private boolean safe;// 表示是否是保密消息，0表示否，1表示是，默认0

	public MpnewsContent getMpnews() {
		return mpnews;
	}

	public void setMpnews(MpnewsContent mpnews) {
		this.mpnews = mpnews;
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public static class MpnewsContent {

		@JsonProperty(value = "articles")
		private List<MpnewsArticle> articles;// 图文消息，一个图文消息支持1到10条图文

		public List<MpnewsArticle> getArticles() {
			return articles;
		}

		public void setArticles(List<MpnewsArticle> articles) {
			this.articles = articles;
		}
	}

	public static class MpnewsArticle {

		@JsonProperty(value = "title")
		private String title;// 图文消息的标题

		@JsonProperty(value = "thumb_media_id")
		private String thumbMediaId;// 图文消息缩略图的media_id,
									// 可以在上传多媒体文件接口中获得。此处thumb_media_id即上传接口返回的media_id

		@JsonProperty(value = "author")
		private String author;// 图文消息的作者

		@JsonProperty(value = "content_source_url")
		private String contentSourceUrl;// 图文消息点击“阅读原文”之后的页面链接

		@JsonProperty(value = "content")
		private String content;// 图文消息的内容，支持html标签

		@JsonProperty(value = "digest")
		private String digest;// 图文消息的描述

		@JsonSerialize(using = BooleanSerializer.class)
		@JsonProperty(value = "show_cover_pic")
		private boolean showCoverPic;// 是否显示封面，1为显示，0为不显示

		public MpnewsArticle() {
			super();
		}

		public MpnewsArticle(String title, String thumbMediaId, String author, String contentSourceUrl, String content, String digest,
				boolean showCoverPic) {
			super();
			this.title = title;
			this.thumbMediaId = thumbMediaId;
			this.author = author;
			this.contentSourceUrl = contentSourceUrl;
			this.content = content;
			this.digest = digest;
			this.showCoverPic = showCoverPic;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getThumbMediaId() {
			return thumbMediaId;
		}

		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getContentSourceUrl() {
			return contentSourceUrl;
		}

		public void setContentSourceUrl(String contentSourceUrl) {
			this.contentSourceUrl = contentSourceUrl;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getDigest() {
			return digest;
		}

		public void setDigest(String digest) {
			this.digest = digest;
		}

		public boolean isShowCoverPic() {
			return showCoverPic;
		}

		public void setShowCoverPic(boolean showCoverPic) {
			this.showCoverPic = showCoverPic;
		}

	}

	public static void main(String[] args) throws JsonProcessingException {
		SendMpnewsMessage msg = new SendMpnewsMessage();
		MpnewsContent mpnews = new MpnewsContent();
		List<MpnewsArticle> articles = new ArrayList<SendMpnewsMessage.MpnewsArticle>();

		for (int i = 0; i < 3; i++) {
			MpnewsArticle article = new MpnewsArticle();
			article.setAuthor("shijingbang" + i * 11);
			article.setContent("这是测试。。。。" + i * 11);
			article.setContentSourceUrl("http://www.baidu.com");
			article.setDigest("我先测试测试，哈哈。。。。" + i * 11);
			article.setShowCoverPic(true);
			article.setTitle("沃众筹新闻");
			article.setThumbMediaId("43" + i * 11);
			articles.add(article);
		}
		mpnews.setArticles(articles);
		msg.setAgentId("2");
		msg.setMsgType("mpnews");

		List<String> toUser = new ArrayList<String>();
		toUser.add("shijingbang");
		toUser.add("haha");
		toUser.add("zhoujielun");
		msg.setToUser(toUser);

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

		msg.setMpnews(mpnews);

		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(msg);
		System.out.println(result);
	}
}
