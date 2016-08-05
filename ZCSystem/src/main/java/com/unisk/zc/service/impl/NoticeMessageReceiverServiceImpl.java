package com.unisk.zc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisk.zc.core.support.MyBatisBaseDao;
import com.unisk.zc.entitys.NoticeMessageReceiver;
import com.unisk.zc.mapper.NoticeMessageReceiverMapper;
import com.unisk.zc.service.NoticeMessageReceiverService;

@Service
public class NoticeMessageReceiverServiceImpl extends BaseServiceImpl<NoticeMessageReceiver> implements NoticeMessageReceiverService {

	NoticeMessageReceiverMapper noticeMessageReceiverMapper;
	@Autowired
	MyBatisBaseDao baseDao;

	public NoticeMessageReceiverMapper getNoticeMessageReceiverMapper() {
		return noticeMessageReceiverMapper;
	}

	@Autowired
	public void setNoticeMessageReceiverMapper(NoticeMessageReceiverMapper noticeMessageReceiverMapper) {
		this.noticeMessageReceiverMapper = noticeMessageReceiverMapper;
		super.setBaseMapper(noticeMessageReceiverMapper);
	}

	@Override
	public void batchInsert(String statement, List<NoticeMessageReceiver> list) {
		baseDao.batchInsert(statement, list);
	}
}
