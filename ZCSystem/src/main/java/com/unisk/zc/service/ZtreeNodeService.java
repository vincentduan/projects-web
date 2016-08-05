package com.unisk.zc.service;

import java.util.List;

import com.unisk.zc.entitys.ZtreeNode;

public interface ZtreeNodeService extends BaseService<ZtreeNode> {
	List<ZtreeNode> selectAllByDept();

	List<ZtreeNode> selectAllByTag();
}
