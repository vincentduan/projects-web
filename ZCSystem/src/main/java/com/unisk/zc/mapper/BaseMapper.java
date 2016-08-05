package com.unisk.zc.mapper;

import java.util.List;
import java.util.Map;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.BaseQuery;

public interface BaseMapper<T> {

	/**
	 * 查询满足查询条件的单行数据，以Map封装返回
	 * 
	 * @param query
	 * @return
	 * @author shijingbang
	 */
	Map<String, Object> selectMap(BaseQuery<T> query);

	/**
	 * 查询满足查询条件的数据集合(不分页处理)，以Map封装返回数据集合
	 * 
	 * @param query
	 * @return
	 * @author shijingbang
	 */
	List<Map<String, Object>> selectMapList(BaseQuery<T> query);

	/**
	 * 查询满足查询条件的数据集合(分页处理)，以Map封装返回数据集合
	 * 
	 * @param t
	 * @return
	 */
	public List<Map<String, Object>> selectListMapPage(T t);

	/**
	 * 分页查询 分页查询满足查询条件的list集合，以数据库实体表对应的java实体类封装返回集合
	 * 
	 * @param query
	 * @return 分页后的List集合，集合元素是对应数据库实体表的java实体封装类
	 * @author shijingbang
	 */
	List<T> selectListByPage(BaseQuery<T> query);

	/**
	 * 按查询条件查询实体对象
	 * 
	 * @param t
	 * @return
	 */
	T selectOne(T t);

	/**
	 * 查询满足查询条件的所有list集合，集合元素是对应数据库实体表的java实体封装类
	 * 
	 * @param query
	 * @return
	 */
	List<T> selectList(BaseQuery<T> query);

	/**
	 * 分页查询 ,分页查询满足查询条件的list集合，以Map封装返回集合数据
	 * 
	 * @param query
	 * @return
	 * @author shijingbang
	 */
	Page<Map<String, Object>> selectListMapPage(BaseQuery<T> query);

	/**
	 * 按ID删除,物理删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入对象T，并返回当前对象T 涵盖全部属性
	 * 
	 * @param record
	 * @return T
	 */
	int insert(T record);

	/**
	 * 插入对象T，并返回当前对象T 涵盖非空属性
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(T record);

	/**
	 * 按主键ID查询，返回主键对应的对象T
	 * 
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(Integer id);

	/**
	 * 更新对象T, 涵盖非空属性
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(T record);

	/**
	 * 更新对象T, 涵盖全部属性
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(T record);
}
