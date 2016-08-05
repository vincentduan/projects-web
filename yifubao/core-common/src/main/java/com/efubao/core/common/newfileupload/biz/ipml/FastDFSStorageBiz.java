package com.efubao.core.common.newfileupload.biz.ipml;

import java.util.Map;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.core.common.dfs.DistributedFileSystemException;
import com.efubao.core.common.dfs.fastdfs.AbstractStorageClientCallback;
import com.efubao.core.common.dfs.fastdfs.AbstractStorageClientReturnedCallback;
import com.efubao.core.common.dfs.fastdfs.support.StorageClientTemplate;
import com.efubao.core.common.dfs.fastdfs.util.FastDFSUtils;
import com.efubao.core.common.newfileupload.biz.StorageBiz;

@Service
public class FastDFSStorageBiz implements StorageBiz {

	@Autowired
	private StorageClientTemplate storageClientTemplate;
	
	@Override
	public String uploadResource(final String extension, final byte[] resourceData, final Map<String, String> metadata) throws DistributedFileSystemException {
		
		return storageClientTemplate.execute(new AbstractStorageClientReturnedCallback<String>() {
			
			@Override
			public String doInStorageClient(TrackerClient trackerClient, TrackerServer trackerServer, StorageServer storageServer) throws Exception {
				
				StorageClient1 storageClient = FastDFSUtils.newStorageClient1(trackerServer, storageServer);
				String result = storageClient.upload_file1(resourceData, extension, FastDFSUtils.newNameValuePairs(metadata));
				if (result == null) {
					throw new DistributedFileSystemException("upload file fail, error code: " + trackerClient.getErrorCode());
				}
				return result;
			}
		});
	}
	
	@Override
	public Map<String, String> getMetadataByPath(final String resourcePath) throws DistributedFileSystemException {
		return storageClientTemplate.execute(new AbstractStorageClientReturnedCallback<Map<String, String>>() {
			
			@Override
			public Map<String, String> doInStorageClient(TrackerClient trackerClient, TrackerServer trackerServer, StorageServer storageServer)
					throws Exception {
				StorageClient1 storageClient = FastDFSUtils.newStorageClient1(trackerServer, storageServer);
				NameValuePair[] nameValuePairs = storageClient.get_metadata1(resourcePath);
				return FastDFSUtils.newMapFromNameValuePairs(nameValuePairs);
			}
			
			@Override
			public StorageServer getStorageServer(TrackerClient trackerClient, TrackerServer trackerServer) throws Exception {
				return trackerClient.getFetchStorage1(trackerServer, resourcePath);
			}
		});
	}
	
	@Override
	public void deleteResourceByPath(final String resourcePath) throws DistributedFileSystemException {
		
		storageClientTemplate.execute(new AbstractStorageClientCallback() {
			
			@Override
			public void doInStorageClient(TrackerClient trackerClient, TrackerServer trackerServer, StorageServer storageServer) throws Exception {
				StorageClient1 storageClient = FastDFSUtils.newStorageClient1(trackerServer, storageServer);
				int result = storageClient.delete_file1(resourcePath);
				if (result != 0) {
					throw new DistributedFileSystemException("Delete file fail, error code: " + trackerClient.getErrorCode());
				}
			}
			
			@Override
			public StorageServer getStorageServer(TrackerClient trackerClient, TrackerServer trackerServer) throws Exception {
				return trackerClient.getFetchStorage1(trackerServer, resourcePath);
			}
		});
	}
	
	@Override
	public byte[] downloadResource(final String resourcePath) throws DistributedFileSystemException 
	{
		
		return storageClientTemplate.execute(new AbstractStorageClientReturnedCallback<byte[]>(){

			@Override
			public byte[] doInStorageClient(TrackerClient trackerClient, TrackerServer trackerServer, StorageServer storageServer) throws Exception
			{
				
				int index = resourcePath.indexOf("/");
				
				if (index < 0)
				{
					return null;
				}
				
				String group = resourcePath.substring(0, index);
				
				String fileName = resourcePath.substring(index + 1);
				
				StorageClient1 storageClient = FastDFSUtils.newStorageClient1(trackerServer, storageServer);
				
				return storageClient.download_file(group, fileName);
			}
			
		});
	}
}
