package com.unisk.zc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisk.zc.entitys.ZtreeNode;
import com.unisk.zc.mapper.ZtreeNodeMapper;
import com.unisk.zc.service.ZtreeNodeService;

@Service
public class ZtreeNodeServiceImpl extends BaseServiceImpl<ZtreeNode> implements ZtreeNodeService {
	ZtreeNodeMapper ztreeNodeMapper;

	public ZtreeNodeMapper getZtreeNodeMapper() {
		return ztreeNodeMapper;
	}

	@Autowired
	public void setZtreeNodeMapper(ZtreeNodeMapper ztreeNodeMapper) {
		this.ztreeNodeMapper = ztreeNodeMapper;
		super.setBaseMapper(ztreeNodeMapper);
	}

	@Override
	public List<ZtreeNode> selectAllByDept() {
		return ztreeNodeMapper.selectAllByDept();
	}

	@Override
	public List<ZtreeNode> selectAllByTag() {
		return ztreeNodeMapper.selectAllByTag();
	}

}
