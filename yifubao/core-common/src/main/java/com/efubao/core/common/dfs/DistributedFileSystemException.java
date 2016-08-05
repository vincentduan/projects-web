package com.efubao.core.common.dfs;

import org.springframework.core.NestedRuntimeException;

/**
 * 分布式文件系统异常。
 * 
 * @see NestedRuntimeException
 */
public class DistributedFileSystemException extends NestedRuntimeException {
	
	private static final long serialVersionUID = -5363328862858087052L;

	public DistributedFileSystemException(String message) {
		super(message);
	}
	
	public DistributedFileSystemException(String message, Throwable cause) {
		super(message, cause);
	}
}
