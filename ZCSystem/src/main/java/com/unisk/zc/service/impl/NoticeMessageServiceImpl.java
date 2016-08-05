package com.unisk.zc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisk.wechat.api.msg.json.send.SendFileMessage;
import com.unisk.wechat.api.msg.json.send.SendImageMessage;
import com.unisk.wechat.api.msg.json.send.SendNewsMessage;
import com.unisk.wechat.api.msg.json.send.SendNewsMessage.NewsArticle;
import com.unisk.wechat.api.msg.json.send.SendVideoMessage;
import com.unisk.wechat.api.msg.json.send.SendVoiceMessage;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.NoticeMessage;
import com.unisk.zc.entitys.NoticeMessageReceiver;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.mapper.NoticeMessageMapper;
import com.unisk.zc.service.NoticeMessageReceiverService;
import com.unisk.zc.service.NoticeMessageService;
import com.unisk.zc.service.UniskUserService;

@Service
public class NoticeMessageServiceImpl extends BaseServiceImpl<NoticeMessage> implements NoticeMessageService {

	private NoticeMessageMapper noticeMesssageMapper;

	@Autowired
	NoticeMessageReceiverService noticeMessageReceiverService;
	@Autowired
	UniskUserService uniskUserService;

	public NoticeMessageMapper getNoticeMesssageMapper() {
		return noticeMesssageMapper;
	}

	@Autowired
	public void setNoticeMesssageMapper(NoticeMessageMapper noticeMesssageMapper) {
		this.noticeMesssageMapper = noticeMesssageMapper;
		super.setBaseMapper(noticeMesssageMapper);
	}

	@Override
	public List<NoticeMessage> getNoticeMessageByWXId(String wxid) {
		return noticeMesssageMapper.getNoticeMessageByWXId(wxid);
	}

	@Override
	public Page<NoticeMessage> getNoticeMessageByWXIdPage(NoticeMessageReceiver msg) {
		return noticeMesssageMapper.getNoticeMessageByWXIdPage(msg);
	}

	@Override
	public Page<Map<String, Object>> selectMapPageByRange(NoticeMessage message) {
		return noticeMesssageMapper.selectMapPageByRange(message);
	}

	@Override
	public void saveNoticeByNewsMessage(SendNewsMessage wechatMsg) throws UniskException {
		// 保存公告
		NewsArticle article = wechatMsg.getNews().getArticles().get(0);
		NoticeMessage msg = new NoticeMessage();
		msg.setAgentId(wechatMsg.getAgentId());
		msg.setMsgType(wechatMsg.getMsgType());
		msg.setCreateTime(new Date());
		UniskUser user = UserUtils.getUser();
		if (user != null && user.getId() != null) {
			msg.setCreateUserId(user.getId());
			msg.setFromUserName(user.getUsername());
		}
		msg.setModifyTime(new Date());
		msg.setModifyUserId(msg.getCreateUserId());
		msg.setPicUrl(article.getPicurl());
		msg.setUrl(article.getUrl());
		boolean isAll = isAllSend(wechatMsg.getToUser());
		msg.setIsAll(isAll ? 1 : 0);
		msg.setStatus(1);// 状态,0:草稿,1:已发送,2:已作废
		msg.setTitle(article.getTitle());
		msg.setContent(article.getDescription());
		msg.setToTagList(wechatMsg.getToTag());
		msg.setToUserList(wechatMsg.getToUser());
		msg.setToPartyList(wechatMsg.getToParty());
		msg.setDelMark(0);// 删除标记，0：存在，1：删除
		this.insert(msg);// 保存

		HashSet<String> set = new HashSet<String>();// 通过HashSet去除重复元素
		// 群发时保存所有用户
		if (isAll) {
			set.addAll(uniskUserService.selectAllUserIds());
		} else {
			if (wechatMsg.getToParty() != null && wechatMsg.getToParty().size() > 0) {
				List<String> userIdsByDeptIds = uniskUserService.selectUserIdsByDeptIds(wechatMsg.getToParty());
				set.addAll(userIdsByDeptIds);

			}
			if (wechatMsg.getToTag() != null && wechatMsg.getToTag().size() > 0) {
				List<String> userIdsByTagIds = uniskUserService.selectUserIdsByTagIds(wechatMsg.getToTag());
				set.addAll(userIdsByTagIds);
			}
			set.addAll(wechatMsg.getToUser());
		}

		// 保存公告对应的接收人信息
		List<NoticeMessageReceiver> receivers = new ArrayList<NoticeMessageReceiver>();
		for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
			NoticeMessageReceiver receiver = new NoticeMessageReceiver();
			receiver.setIsread(0);// 是否已阅读，0：未阅读，1：已阅读
			receiver.setIssend(2);// 是否已发送，0：草稿，1：发送失败，2：已发送
			receiver.setMessageid(msg.getId());
			receiver.setDelmark(0);// 删除标记，0：存在，1：删除
			receiver.setCreatetime(new Date());
			receiver.setCreateuserid(msg.getCreateUserId());
			receiver.setModifytime(new Date());
			receiver.setModifyuserid(msg.getModifyUserId());
			receiver.setSendtime(new Date());
			receiver.setReceiverusername(iter.next());
			receivers.add(receiver);
		}
		String sqlId = "com.unisk.is.mapper.NoticeMessageReceiverMapper.insert";
		noticeMessageReceiverService.batchInsert(sqlId, receivers);// 批量入库
	}

	public boolean isAllSend(List<String> userIds) {
		boolean flag = false;
		for (int i = 0; userIds != null && userIds.size() > 0 && i < userIds.size(); i++) {
			if ("@all".equals(userIds.get(i))) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public void saveNoticeByFileMessage(SendFileMessage msg) {
	}

	@Override
	public void saveNoticeByVoiceMessage(SendVoiceMessage msg) {
	}

	@Override
	public void saveNoticeByVideoMessage(SendVideoMessage msg) {
	}

	@Override
	public void saveNoticeByImageMessage(SendImageMessage msg) {
	}
}
