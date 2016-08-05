package com.unisk.wechat.web.support;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.unisk.wechat.api.msg.json.send.CommonMessage;
import com.unisk.wechat.api.util.UploadType;

public class NoticeFormData {
	private String title;
	private String content;
	private String uploadType;
	private String selectedDepartmentIds;
	private String selectedTagIds;
	private String selectedUserIds;
	private String fileName;
	private String url;
	private String filePath;
	private String agentId;
	private String msgType;
	private String mediaId;

	private List<String> selectedDepartmentIdsList;
	private List<String> selectedTagIdsList;
	private List<String> selectedUserIdsList;

	public CommonMessage getCommonMessageByMsgType() {
		if (StringUtils.equalsIgnoreCase(UploadType.video.name(), this.getMsgType())) {
			return SendCommonMessageFactory.getSendVideoMessage(this);
		} else if (StringUtils.equalsIgnoreCase(UploadType.voice.name(), this.getMsgType())) {
			return SendCommonMessageFactory.getSendVoiceMessage(this);
		} else if (StringUtils.equalsIgnoreCase(UploadType.image.name(), this.getMsgType())) {
			return SendCommonMessageFactory.getSendImageMessage(this);
		}
		return SendCommonMessageFactory.getSendFileMessage(this);
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

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public String getSelectedDepartmentIds() {
		return selectedDepartmentIds;
	}

	public void setSelectedDepartmentIds(String selectedDepartmentIds) {
		this.getSelectedDepartmentIdsList();
		this.selectedDepartmentIds = selectedDepartmentIds;
	}

	public String getSelectedTagIds() {
		this.getSelectedTagIdsList();
		return selectedTagIds;
	}

	public void setSelectedTagIds(String selectedTagIds) {
		this.getSelectedUserIdsList();
		this.selectedTagIds = selectedTagIds;
	}

	public String getSelectedUserIds() {
		return selectedUserIds;
	}

	public void setSelectedUserIds(String selectedUserIds) {
		this.selectedUserIds = selectedUserIds;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getSelectedDepartmentIdsList() {
		if (StringUtils.isNotBlank(this.selectedDepartmentIds)) {
			selectedDepartmentIdsList = Arrays.asList(selectedDepartmentIds.split(","));
		}
		return selectedDepartmentIdsList;
	}

	public void setSelectedDepartmentIdsList(List<String> selectedDepartmentIdsList) {
		this.selectedDepartmentIdsList = selectedDepartmentIdsList;
	}

	public List<String> getSelectedTagIdsList() {
		if (StringUtils.isNotBlank(this.selectedTagIds)) {
			selectedTagIdsList = Arrays.asList(selectedTagIds.split(","));
		}
		return selectedTagIdsList;
	}

	public void setSelectedTagIdsList(List<String> selectedTagIdsList) {
		this.selectedTagIdsList = selectedTagIdsList;
	}

	public List<String> getSelectedUserIdsList() {
		if (StringUtils.isNotBlank(this.selectedUserIds)) {
			selectedUserIdsList = Arrays.asList(selectedUserIds.split(","));
		}
		return selectedUserIdsList;
	}

	public void setSelectedUserIdsList(List<String> selectedUserIdsList) {
		this.selectedUserIdsList = selectedUserIdsList;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "NoticeFormData [title=" + title + ", content=" + content + ", uploadType=" + uploadType + ", selectedDepartmentIds=" + selectedDepartmentIds + ", selectedTagIds="
				+ selectedTagIds + ", selectedUserIds=" + selectedUserIds + ", fileName=" + fileName + ", url=" + url + ", filePath=" + filePath + "]";
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
