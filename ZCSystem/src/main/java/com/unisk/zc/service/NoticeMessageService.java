package com.unisk.zc.service;

import java.util.List;
import java.util.Map;

import com.unisk.wechat.api.msg.json.send.SendFileMessage;
import com.unisk.wechat.api.msg.json.send.SendImageMessage;
import com.unisk.wechat.api.msg.json.send.SendNewsMessage;
import com.unisk.wechat.api.msg.json.send.SendVideoMessage;
import com.unisk.wechat.api.msg.json.send.SendVoiceMessage;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.NoticeMessage;
import com.unisk.zc.entitys.NoticeMessageReceiver;
import com.unisk.zc.exceptions.UniskException;

public interface NoticeMessageService extends BaseService<NoticeMessage> {

	public List<NoticeMessage> getNoticeMessageByWXId(String wxid);

	public Page<NoticeMessage> getNoticeMessageByWXIdPage(NoticeMessageReceiver msg);

	public Page<Map<String, Object>> selectMapPageByRange(NoticeMessage message);

	public void saveNoticeByNewsMessage(SendNewsMessage msg) throws UniskException;

	public void saveNoticeByFileMessage(SendFileMessage msg) throws UniskException;

	public void saveNoticeByVoiceMessage(SendVoiceMessage msg) throws UniskException;

	public void saveNoticeByVideoMessage(SendVideoMessage msg) throws UniskException;

	public void saveNoticeByImageMessage(SendImageMessage msg) throws UniskException;
}
