package com.unisk.zc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.BaseQuery;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.mapper.BaseMapper;
import com.unisk.zc.service.BaseService;

public abstract class BaseServiceImpl<T extends BaseQuery<T>> implements BaseService<T> {

	private BaseMapper<T> baseMapper;

	public BaseMapper<T> getBaseMapper() {
		Assert.notNull(baseMapper, "baseMapper未初始化,子类继承BaseServiceImpl时必须初始化注入...");
		return baseMapper;
	}

	/**
	 * 子类继承BaseServiceImpl时，必须调用super.setBaseMapper方法将子类的Mapper对象注入进来
	 * 
	 * @author shijingbang
	 */
	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public Page<T> selectByPage(T t) throws UniskException {
		List<T> list = getBaseMapper().selectListByPage(t);
		Page<T> page = t.getPage();
		page.setData(list);
		return page;
	}

	@Override
	public T findById(Integer id) throws UniskException {
		return getBaseMapper().selectByPrimaryKey(id);
	}

	@Override
	public int delete(Integer id) throws UniskException {
		return getBaseMapper().deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T t) throws UniskException {
		return getBaseMapper().insert(t);
	}

	@Override
	public int update(T t) throws UniskException {
		return getBaseMapper().updateByPrimaryKeySelective(t);
	}

	// ***********************以下是可选择实现的方法***************************//
	/**
	 * 参数 T，查询一个<Object,Object>类型的Map
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	@Override
	public Map<String, Object> selectMap(T t) throws UniskException {
		return getBaseMapper().selectMap(t);
	}

	@Override
	public List<Map<String, Object>> selectMapList(T t) throws UniskException {
		return getBaseMapper().selectMapList(t);
	}

	private List<Map<String, Object>> selectListMapPage(T t) throws UniskException {
		return getBaseMapper().selectListMapPage(t);
	}

	@Override
	public Page<Map<String, Object>> selectMapPage(T t) throws UniskException {
		List<Map<String, Object>> list = this.selectListMapPage(t);
		Page<T> page = t.getPage();
		// 创建一个封装了Map的page实例，将查询参数t中的值拷贝过来
		Page<Map<String, Object>> pageMap = new Page<Map<String, Object>>();
		pageMap.setCurrentPage(page.getCurrentPage());
		pageMap.setMaxNum(page.getMaxNum());
		pageMap.setStartNum(page.getStartNum());
		pageMap.setTotalCount(page.getTotalCount());
		pageMap.setTotalPage(page.getTotalPage());
		pageMap.setData(list);
		return pageMap;
	}

	/**
	 * 参数T,查询T类型的List集合
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	@Override
	public List<T> selectList(T t) throws UniskException {
		return getBaseMapper().selectList(t);
	}

	/**
	 * 参数T，查询一个T类型的对象
	 * 
	 * @param t
	 * @return
	 * @throws UniskException
	 */
	@Override
	public T selectOne(T t) throws UniskException {
		return getBaseMapper().selectOne(t);
	}
}
