package com.unisk.zc.service;

import java.util.List;

import com.unisk.zc.entitys.NoticeMessageReceiver;

public interface NoticeMessageReceiverService extends BaseService<NoticeMessageReceiver> {

	public void batchInsert(String statement, List<NoticeMessageReceiver> list);
}
