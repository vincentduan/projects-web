package com.unisk.zc.mapper;

import java.util.List;

import com.unisk.zc.entitys.ZtreeNode;

public interface ZtreeNodeMapper extends BaseMapper<ZtreeNode> {
	List<ZtreeNode> selectAllByDept();

	List<ZtreeNode> selectAllByTag();
}
