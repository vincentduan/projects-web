package com.efubao.core.common.newfileupload.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.core.common.dfs.DistributedFileSystemException;
import com.efubao.core.common.newfileupload.biz.StorageBiz;
import com.efubao.core.common.newfileupload.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private StorageBiz storageBiz;
	
	@Override
	public String uploadResource(String extension, byte[] resourceData, Map<String, String> metadata) {
		return storageBiz.uploadResource(extension, resourceData, metadata);
	}
	
	@Override
	public Map<String, String> getMetadataByPath(String resourcePath) {
		return storageBiz.getMetadataByPath(resourcePath);
	}
	
	@Override
	public void deleteResourceByPath(String resourcePath) {
		storageBiz.deleteResourceByPath(resourcePath);
	}
	
	@Override
	public byte[] downloadResource(String resourcePath) throws DistributedFileSystemException
	{
		return storageBiz.downloadResource(resourcePath);
	}
}
