package com.efubao.core.common.newfileupload.service;

import java.util.Map;

import com.efubao.core.common.dfs.DistributedFileSystemException;

public interface ResourceService {
	/**
	 * 上传文件
	 * @param extension
	 * @param resourceData
	 * @param metadata
	 * @return
	 * @throws DistributedFileSystemException
	 */
	String uploadResource(String extension, byte[] resourceData, Map<String, String> metadata) throws DistributedFileSystemException;
	
	/**
	 * 获得文件元信息
	 * @param resourcePath
	 * @return
	 * @throws DistributedFileSystemException
	 */
	Map<String, String> getMetadataByPath(String resourcePath) throws DistributedFileSystemException;
	
	/**
	 * 删除文件
	 * @param resourcePath
	 * @throws DistributedFileSystemException
	 */
	void deleteResourceByPath(String resourcePath) throws DistributedFileSystemException;
	
	/**
	 * 文件下载
	 * @param resourcePath
	 * @return
	 * @throws DistributedFileSystemException
	 */
	byte[] downloadResource(String resourcePath) throws DistributedFileSystemException;
}
