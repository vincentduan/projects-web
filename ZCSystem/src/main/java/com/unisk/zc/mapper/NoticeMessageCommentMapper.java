package com.unisk.zc.mapper;

import com.unisk.zc.entitys.NoticeMessageComment;

public interface NoticeMessageCommentMapper {
	int deleteByPrimaryKey(Long id);

	int insert(NoticeMessageComment record);

	int insertSelective(NoticeMessageComment record);

	NoticeMessageComment selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(NoticeMessageComment record);

	int updateByPrimaryKey(NoticeMessageComment record);
}