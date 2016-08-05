package com.unisk.wechat.web.support;

import com.unisk.wechat.api.msg.json.send.CommonMessage;
import com.unisk.wechat.api.msg.json.send.SendFileMessage;
import com.unisk.wechat.api.msg.json.send.SendFileMessage.FileContent;
import com.unisk.wechat.api.msg.json.send.SendImageMessage;
import com.unisk.wechat.api.msg.json.send.SendImageMessage.ImageContent;
import com.unisk.wechat.api.msg.json.send.SendVideoMessage;
import com.unisk.wechat.api.msg.json.send.SendVideoMessage.VideoContent;
import com.unisk.wechat.api.msg.json.send.SendVoiceMessage;
import com.unisk.wechat.api.msg.json.send.SendVoiceMessage.VoiceContent;

public class SendCommonMessageFactory {
	/**
	 * 根据NoticeFormData数据封装普通文件消息
	 * 
	 * @param data
	 * @return
	 * @author bang
	 */
	public static SendFileMessage getSendFileMessage(NoticeFormData data) {
		SendFileMessage msg = new SendFileMessage();
		setCommonProperties(msg, data);
		FileContent file = new FileContent();
		file.setMediaId(data.getMediaId());
		msg.setFile(file);
		return msg;
	}

	/**
	 * 根据NoticeFormData数据封装音频消息
	 * 
	 * @param data
	 * @return
	 * @author bang
	 */
	public static SendVoiceMessage getSendVoiceMessage(NoticeFormData data) {
		SendVoiceMessage msg = new SendVoiceMessage();
		setCommonProperties(msg, data);
		VoiceContent voice = new VoiceContent();
		voice.setMediaId(data.getMediaId());
		msg.setVoice(voice);
		return msg;
	}

	/**
	 * 根据NoticeFormData数据封装视频消息
	 * 
	 * @param data
	 * @return
	 * @author bang
	 */
	public static SendVideoMessage getSendVideoMessage(NoticeFormData data) {
		SendVideoMessage msg = new SendVideoMessage();
		setCommonProperties(msg, data);
		VideoContent video = new VideoContent();
		video.setMediaId(data.getMediaId());
		msg.setVideo(video);
		return msg;
	}

	/**
	 * 根据NoticeFormData数据封装图片消息
	 * 
	 * @param data
	 * @return
	 * @author bang
	 */
	public static SendImageMessage getSendImageMessage(NoticeFormData data) {
		SendImageMessage msg = new SendImageMessage();
		setCommonProperties(msg, data);
		ImageContent image = new ImageContent();
		image.setMediaId(data.getMediaId());
		msg.setImage(image);
		return msg;
	}

	/**
	 * 设置通用属性
	 * 
	 * @param msg
	 * @param data
	 * @author bang
	 */
	public static void setCommonProperties(CommonMessage msg, NoticeFormData data) {
		msg.setAgentId(data.getAgentId());
		msg.setMsgType(data.getMsgType());
		msg.setToParty(data.getSelectedDepartmentIdsList());
		msg.setToTag(data.getSelectedTagIdsList());
		msg.setToUser(data.getSelectedUserIdsList());
	}
}
