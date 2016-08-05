package com.unisk.zc.entitys;

import java.util.Date;

public class NoticeMessageReceiver extends BaseQuery<NoticeMessageReceiver> {
	private Long id;

	private Integer messageid;

	private String receiverusername;

	private Integer issend;

	private Date sendtime;

	private Integer isread;

	private Date readtime;

	private String remarks;

	private Integer delmark;

	private Date createtime;

	private Integer createuserid;

	private Date modifytime;

	private Integer modifyuserid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMessageid() {
		return messageid;
	}

	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}

	public String getReceiverusername() {
		return receiverusername;
	}

	public void setReceiverusername(String receiverusername) {
		this.receiverusername = receiverusername;
	}

	public Integer getIssend() {
		return issend;
	}

	public void setIssend(Integer issend) {
		this.issend = issend;
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public Integer getIsread() {
		return isread;
	}

	public void setIsread(Integer isread) {
		this.isread = isread;
	}

	public Date getReadtime() {
		return readtime;
	}

	public void setReadtime(Date readtime) {
		this.readtime = readtime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public Integer getDelmark() {
		return delmark;
	}

	public void setDelmark(Integer delmark) {
		this.delmark = delmark;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getModifyuserid() {
		return modifyuserid;
	}

	public void setModifyuserid(Integer modifyuserid) {
		this.modifyuserid = modifyuserid;
	}
}