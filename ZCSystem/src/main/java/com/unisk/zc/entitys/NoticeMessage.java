package com.unisk.zc.entitys;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 公告消息实体类
 * 
 * @Description:
 * @author shijingbang
 * @Date 2016年1月11日
 */
public class NoticeMessage extends BaseQuery<NoticeMessage> {
	private Integer id;// 消息ID
	private String fromUserName;// 发送人
	private Integer isAll;// 是否全部发送
	private String title;// 标题
	private String content;// 公告消息正文内容
	private String url;// 公告消息访问的URL
	private String picUrl;// 公告消息的图片
	private String extFile;// 附件地址
	private String remarks;// 备注
	private Integer delMark;// 删除标识
	private Date createTime; // 创建时间
	private Integer createUserId;// 创建人ID
	private Date modifyTime;// 修改时间
	private Integer modifyUserId;// 修改人用户ID
	private Integer allowComment;// 是否允许评论,0:否,1:是
	private Integer allowWaterMark;// 是否添加水印,0:否,1:是
	private Integer allowShare;// 是否允许分享,0:否,1:是
	private Integer allowMass;// 群发提醒,0:否,1:是
	private Integer allowOnTime;// 是否开启定时,0:否,1:是
	private Date onTime;// 预约发送时间[定时]
	private Integer status;// 状态
	private Integer allowShow;// 是否显示,0:否,1:是
	private Integer agreeCount;// 赞成数[点赞]
	private String msgType;// 消息类型
	private String agentId;// 应用ID
	private String toUser;// 接收用户列表 ，以英文,拼接
	private List<String> toUserList;
	private String toParty;// 接收的部门列表，以英文,拼接
	private List<String> toPartyList;
	private String toTag;// 接收的标签列表,以英文,拼接
	private List<String> toTagList;
	private Integer kindsid;//

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Integer getIsAll() {
		return isAll;
	}

	public void setIsAll(Integer isAll) {
		this.isAll = isAll;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getExtFile() {
		return extFile;
	}

	public void setExtFile(String extFile) {
		this.extFile = extFile;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getDelMark() {
		return delMark;
	}

	public void setDelMark(Integer delMark) {
		this.delMark = delMark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public Integer getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}

	public Integer getAllowWaterMark() {
		return allowWaterMark;
	}

	public void setAllowWaterMark(Integer allowWaterMark) {
		this.allowWaterMark = allowWaterMark;
	}

	public Date getOnTime() {
		return onTime;
	}

	public void setOnTime(Date onTime) {
		this.onTime = onTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAllowShare() {
		return allowShare;
	}

	public void setAllowShare(Integer allowShare) {
		this.allowShare = allowShare;
	}

	public Integer getAllowMass() {
		return allowMass;
	}

	public void setAllowMass(Integer allowMass) {
		this.allowMass = allowMass;
	}

	public Integer getAllowOnTime() {
		return allowOnTime;
	}

	public void setAllowOnTime(Integer allowOnTime) {
		this.allowOnTime = allowOnTime;
	}

	public Integer getAllowShow() {
		return allowShow;
	}

	public void setAllowShow(Integer allowShow) {
		this.allowShow = allowShow;
	}

	public Integer getAgreeCount() {
		return agreeCount;
	}

	public void setAgreeCount(Integer agreeCount) {
		this.agreeCount = agreeCount;
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

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public List<String> getToUserList() {
		if (StringUtils.isNotBlank(toUser)) {
			toUserList = Arrays.asList(toUser.split(","));
		}
		return toUserList;
	}

	public void setToUserList(List<String> toUserList) {
		if (toUserList != null && toUserList.size() > 0) {
			toUser = org.springframework.util.StringUtils.collectionToDelimitedString(toUserList, ",");
		}
		this.toUserList = toUserList;
	}

	public String getToParty() {
		return toParty;
	}

	public void setToParty(String toParty) {
		this.toParty = toParty;
	}

	public List<String> getToPartyList() {
		if (StringUtils.isNotBlank(toParty)) {
			toPartyList = Arrays.asList(toParty.split(","));
		}
		return toPartyList;
	}

	public void setToPartyList(List<String> toPartyList) {
		if (toPartyList != null && toPartyList.size() > 0) {
			toParty = org.springframework.util.StringUtils.collectionToDelimitedString(toPartyList, ",");
		}
		this.toPartyList = toPartyList;
	}

	public String getToTag() {
		return toTag;
	}

	public void setToTag(String toTag) {
		this.toTag = toTag;
	}

	public List<String> getToTagList() {
		if (StringUtils.isNotBlank(toTag)) {
			toTagList = Arrays.asList(toTag.split(","));
		}
		return toTagList;
	}

	public void setToTagList(List<String> toTagList) {
		if (toTagList != null && toTagList.size() > 0) {
			toTag = org.springframework.util.StringUtils.collectionToDelimitedString(toTagList, ",");
		}
		this.toTagList = toTagList;
	}

	public Integer getKindsid() {
		return kindsid;
	}

	public void setKindsid(Integer kindsid) {
		this.kindsid = kindsid;
	}
}
