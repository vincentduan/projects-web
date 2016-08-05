package com.unisk.zc.entitys;

import java.util.Date;

public class NoticeMessageComment extends BaseQuery<NoticeMessageComment> {
	private Long id;

	private String openid;

	private Integer messid;

	private String comment;

	private String remarks;

	private Byte delmark;

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid == null ? null : openid.trim();
	}

	public Integer getMessid() {
		return messid;
	}

	public void setMessid(Integer messid) {
		this.messid = messid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public Byte getDelmark() {
		return delmark;
	}

	public void setDelmark(Byte delmark) {
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