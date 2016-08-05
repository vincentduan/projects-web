package com.unisk.zc.mapper;

import java.util.List;
import java.util.Map;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.NoticeMessage;
import com.unisk.zc.entitys.NoticeMessageReceiver;

public interface NoticeMessageMapper extends BaseMapper<NoticeMessage> {
	public List<NoticeMessage> getNoticeMessageByWXId(String wxid);

	public Page<NoticeMessage> getNoticeMessageByWXIdPage(NoticeMessageReceiver msg);

	public Page<Map<String, Object>> selectMapPageByRange(NoticeMessage message);
}
