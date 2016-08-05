package com.efubao.core.common.base;

import com.efubao.common.util.Page;

   
 
/**
 * 业务逻辑service基类,提供基本的CRUD
 * 
 * 
 * @param <T>:泛型对象
 */
public interface BaseService<T> {  

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 *            主键
	 * @return 实体对象
	 */
	T findById(Long id);

	/**
	 * 添加
	 * 
	 * @param t
	 *            实体对象
	 * @return 0：失败，1：成功
	 */
	int save(T t);

	/**
	 * 更新，更新实体对象
	 * 
	 * @param t
	 *            实体对象
	 * @return 0:失败，1：成功
	 */
	int update(T t);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键
	 * @return 0：失败，1：成功
	 */
	int deleteById(Long id);

	void queryByPage(Page<T> page, T t);
}
