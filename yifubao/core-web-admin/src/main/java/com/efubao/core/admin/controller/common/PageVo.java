package com.efubao.core.admin.controller.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页vo
 * 
 * 
 * @param <T>
 */
public class PageVo<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3504380790868428811L;
	/** 分页参数 */
	private int pageNo = 1;
	/** */
	private int pageSize = -1;
	/** 返回结果 */
	private List<T> result = new ArrayList<T>();
	/** */
	private long totalCount = -1;
	/** */
	private long totalPages = -1;

	public PageVo() {

	}

	public PageVo(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 根据pageSize与totalCount计算总页数, 默认值为-1.
	 */
	public long getTotalPages() {
		if (totalCount < 0) {
			return -1;
		}

		long count = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		return count;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

}
