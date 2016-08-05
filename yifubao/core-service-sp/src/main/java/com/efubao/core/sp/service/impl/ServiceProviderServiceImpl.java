package com.efubao.core.sp.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.common.util.PersentLike;
import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.domain.ServiceProviderExample;
import com.efubao.core.sp.domain.ServiceProviderExample.Criteria;
import com.efubao.core.sp.mapper.ServiceProviderMapper;
import com.efubao.core.sp.service.ServiceProviderService;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
	private ServiceProviderMapper serviceProviderMapper;

	@Override
	public ServiceProvider findById(Long id) {
		// TODO Auto-generated method stub
		return serviceProviderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(ServiceProvider t) {
		if (t == null) {
			return 0;
		}
		return serviceProviderMapper.insertSelective(t);
	}

	@Override
	public int update(ServiceProvider t) {
		// TODO Auto-generated method stub
		if (t == null) {
			return 0;
		}
		return serviceProviderMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return serviceProviderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<ServiceProvider> page, ServiceProvider t) {
		ServiceProviderExample example = new ServiceProviderExample();
		ServiceProviderExample.Criteria criteria = example.createCriteria();

		if (t != null) {
			if (StringUtils.isNotBlank(t.getName())) {
				criteria.andNameLike(PersentLike.makeUpPersentLike(t.getName()));
			}

		}
		page2Exam(page, example);
		int total = serviceProviderMapper.countByExample(example);
		List<ServiceProvider> list = serviceProviderMapper.selectByExample(example);
		page.setTotalCount(total);
		page.setResult(list);

	}

	/**
	 * 分页对象组装分页查询条件
	 * 
	 * @param p 分页对象
	 * @param c 查询条件
	 */
	private void page2Exam(Page<ServiceProvider> p, ServiceProviderExample c) {
		if (p != null && c != null) {
			c.setLimitEnd(p.getPageSize());
			c.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

			if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
				c.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
			}
		}
	}

	@Override
	public List<ServiceProvider> queryByCondition(ServiceProvider serviceProvider) {
		if (serviceProvider == null) {
			return null;
		}
		ServiceProviderExample example = new ServiceProviderExample();
		ServiceProviderExample.Criteria criteria = example.createCriteria();

		if (serviceProvider.getStatus() != null) {
			criteria.andStatusEqualTo(serviceProvider.getStatus());
		}
		if (serviceProvider.getIsDel() != null) {
			criteria.andIsDelEqualTo(serviceProvider.getIsDel());
		}
		return serviceProviderMapper.selectByExample(example);
	}

	@Override
	public List<ServiceProvider> getSpListByIds(List<Long> spids) {
		ServiceProviderExample serviceProviderExample = new ServiceProviderExample();
		Criteria criteria = serviceProviderExample.createCriteria();
		criteria.andIdIn(spids);
		return serviceProviderMapper.selectByExample(serviceProviderExample);
	}

	@Override
	public void getServiceP(Page<ServiceProvider> page,String spName,Integer categoryId,Integer start,Integer end) {
		int total = serviceProviderMapper.countServiceP(spName, categoryId, start, end);
		System.out.println(total);
		page.setTotalCount(total);
		List<ServiceProvider> lists = serviceProviderMapper.getServiceP(spName, categoryId, start, end);
		page.setResult(lists);
	}

}
