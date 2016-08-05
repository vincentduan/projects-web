package com.unisk.zc.core.support;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.unisk.zc.entitys.BaseQuery;

/**
 * 
 * @Description:Mybatis 数据库操作基类
 * @author shijingbang
 * @Date 2015年11月26日
 */
@Repository
public class MyBatisBaseDao extends SqlSessionDaoSupport {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisBaseDao.class);

	// 从spring注入原有的sqlSessionTemplate
	@Autowired
	@Qualifier("sqlSessionTemplateUnion")
	private SqlSessionTemplate sqlSessionTemplate;

	public <T> Page<T> selectListByPage(String statement, BaseQuery<T> parameter) {
		List<T> list = this.selectList(statement, parameter);
		parameter.getPage().setData(list);
		return parameter.getPage();
	};

	public <T> Page<Map<String, Object>> selectListMapPage(String statement, BaseQuery<T> parameter) {
		List<Map<String, Object>> list = this.selectList(statement, parameter);
		Page<T> page = parameter.getPage();
		// 创建一个封装了Map的page实例，将查询参数t中的值拷贝过来
		Page<Map<String, Object>> pageMap = new Page<Map<String, Object>>();
		pageMap.setCurrentPage(page.getCurrentPage());
		pageMap.setMaxNum(page.getMaxNum());
		pageMap.setStartNum(page.getStartNum());
		pageMap.setTotalCount(page.getTotalCount());
		pageMap.setTotalPage(page.getTotalPage());
		pageMap.setData(list);
		return pageMap;
	};

	public <T> List<T> selectList(String statement, Object parameter) {
		return this.getSqlSession().selectList(statement, parameter);
	}

	public <T> List<T> selectList(String statement) {
		return this.getSqlSession().selectList(statement);
	}

	public <T> List<T> selectList(String statement, Object parameter, RowBounds rowBounds) {
		return this.getSqlSession().selectList(statement, parameter, rowBounds);
	}

	public <T> T selectOne(String statement) {
		return this.getSqlSession().selectOne(statement);
	}

	public <T> T selectOne(String sqlid, Object parameter) {
		return this.getSqlSession().selectOne(sqlid, parameter);
	}

	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		return this.getSqlSession().selectMap(statement, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
		return this.getSqlSession().selectMap(statement, parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		return this.getSqlSession().selectMap(statement, parameter, mapKey, rowBounds);
	}

	public int delete(String statement) {
		return this.getSqlSession().delete(statement);
	}

	public int delete(String statement, Object parameter) {
		return this.getSqlSession().delete(statement, parameter);
	}

	public int insert(String statement, Object parameter) {
		return this.getSqlSession().insert(statement, parameter);
	}

	public int insert(String statement) {
		return this.getSqlSession().insert(statement);
	}

	public void select(String statement, ResultHandler handler) {
		this.getSqlSession().select(statement, handler);
	}

	public void select(String statement, Object parameter, ResultHandler handler) {
		this.getSqlSession().select(statement, parameter, handler);
	}

	public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
		this.getSqlSession().select(statement, parameter, rowBounds, handler);
	}

	public int update(String sqlid, Object parameter) {
		return this.getSqlSession().update(sqlid, parameter);
	}

	public int update(String statement) {
		return this.getSqlSession().update(statement);
	}

	/**
	 * 批量更新 方法描述：批量更新（效率没有在配置文件上的高）
	 * 
	 * @param statement
	 * @param list
	 * @throws DataAccessException
	 */
	public void batchUpdate(final String statement, @SuppressWarnings("rawtypes") List list) throws DataAccessException {
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		try {
			if (list != null && list.size() > 0) {
				int size = 10000;

				for (int i = 0, n = list.size(); i < n; i++) {
					this.update(statement, list.get(i));
					if (i % 1000 == 0 || i == size - 1) {
						// 手动每1000个一提交，提交后无法回滚
						session.commit();
						// 清理缓存，防止溢出
						session.clearCache();
					}
				}
			}
		} catch (Exception e) {
			session.rollback();
			if (logger.isDebugEnabled()) {
				logger.debug("batchUpdate error: id [" + statement + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 批量插入 方法描述：批量插入（效率没有在配置文件上的高）
	 * 
	 * @param statement
	 * @param list
	 * @throws DataAccessException
	 */
	public void batchInsert(final String statement, @SuppressWarnings("rawtypes") List list) throws DataAccessException {

		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);

		int size = 10000;
		try {
			if (null != list && list.size() > 0) {
				for (int i = 0, n = list.size(); i < n; i++) {
					this.insert(statement, list.get(i));
					if (i % 1000 == 0 || i == size - 1) {
						// 手动每1000个一提交，提交后无法回滚
						session.commit();
						// 清理缓存，防止溢出
						session.clearCache();
					}
				}
			}
		} catch (Exception e) {
			session.rollback();
			if (logger.isDebugEnabled()) {
				logger.debug("batchInsert error: id [" + statement + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 批量删除 方法描述：批量删除（效率没有在配置文件上的高）
	 * 
	 * @param statement
	 * @param list
	 * @throws DataAccessException
	 */
	public void batchDelete(String statement, @SuppressWarnings("rawtypes") List list) throws DataAccessException {
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);

		int size = 10000;
		try {
			if (null != list && list.size() > 0) {
				for (int i = 0, n = list.size(); i < n; i++) {
					this.delete(statement, list.get(i));
					if (i % 1000 == 0 || i == size - 1) {
						// 手动每1000个一提交，提交后无法回滚
						session.commit();
						// 清理缓存，防止溢出
						session.clearCache();
					}
				}
			}
		} catch (Exception e) {
			session.rollback();
			if (logger.isDebugEnabled()) {
				logger.debug("batchDelete error: id [" + statement + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}
}