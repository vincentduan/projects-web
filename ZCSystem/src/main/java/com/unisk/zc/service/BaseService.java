package com.unisk.zc.service;

import java.util.List;
import java.util.Map;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.BaseQuery;
import com.unisk.zc.exceptions.UniskException;

public interface BaseService<T extends BaseQuery<T>> {

	/**
	 * 分页
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	public Page<T> selectByPage(T t) throws UniskException;

	/**
	 * 按ID查询T类型的对象
	 * 
	 * @param id
	 * @return
	 * @throws UniskException
	 */
	public T findById(Integer id) throws UniskException;

	/**
	 * 按ID进行逻辑删除，更新delmark属性值
	 * 
	 * @param id
	 * @return
	 * @throws UniskException
	 */
	public int delete(Integer id) throws UniskException;

	/**
	 * 插入T类型的对象
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	public int insert(T t) throws UniskException;

	/**
	 * 更新T类型的对象
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	public int update(T t) throws UniskException;

	// ***********************以下是可选择实现的方法***************************//
	/**
	 * 参数 T，查询一个<String,Object>类型的Map
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	public Map<String, Object> selectMap(T t) throws UniskException;

	/**
	 * 参数 T，返回满足查询条件的List集合(没经过分页处理)，集合元素是一个<String,Object>类型的Map
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	public List<Map<String, Object>> selectMapList(T t) throws UniskException;

	/**
	 * 参数 T，分页查询一个list集合，封装成分页对象Page
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	public Page<Map<String, Object>> selectMapPage(T t) throws UniskException;

	/**
	 * 参数T,查询T类型的List集合
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	public List<T> selectList(T t) throws UniskException;

	/**
	 * 参数T，查询一个T类型的对象
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	public T selectOne(T t) throws UniskException;

}
