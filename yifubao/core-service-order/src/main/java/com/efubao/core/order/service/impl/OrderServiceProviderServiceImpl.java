package com.efubao.core.order.service.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderServiceProvider;
import com.efubao.core.order.domain.OrderServiceProviderExample;
import com.efubao.core.order.domain.OrderServiceProviderExample.Criteria;
import com.efubao.core.order.mapper.OrderServiceProviderMapper;
import com.efubao.core.order.service.OrderServiceProviderService;

@Service
public class OrderServiceProviderServiceImpl implements OrderServiceProviderService {
	@Autowired
	public OrderServiceProviderMapper orderServiceProviderMapper;

	@Override
	public OrderServiceProvider findById(Long id) {
		if (id == null) {
			return null;
		}
		return orderServiceProviderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(OrderServiceProvider t) {
		if (t == null) {
			return 0;
		}
		return orderServiceProviderMapper.insertSelective(t);
	}

	@Override
	public int update(OrderServiceProvider t) {
		if (t == null) {
			return 0;
		}
		return orderServiceProviderMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return orderServiceProviderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<OrderServiceProvider> page, OrderServiceProvider t) {
		OrderServiceProviderExample orderServiceProviderExample = new OrderServiceProviderExample();
		Criteria criteria = orderServiceProviderExample.createCriteria();
		if (t.getSpId() != null) {
			criteria.andSpIdEqualTo(t.getSpId());
		}
		if (t.getStatus() != null) {
			criteria.andStatusEqualTo(t.getStatus());
		}
		page2Exam(page, orderServiceProviderExample);
		int total = orderServiceProviderMapper.countByExample(orderServiceProviderExample);
		List<OrderServiceProvider> list = orderServiceProviderMapper.selectByExample(orderServiceProviderExample);
		page.setTotalCount(total);
		page.setResult(list);
	}

	/**
	 * 分页对象组装分页查询条件
	 * 
	 * @param p 分页对象
	 * @param c 查询条件
	 */
	private void page2Exam(Page<OrderServiceProvider> p, OrderServiceProviderExample c) {
		if (p != null && c != null) {
			c.setLimitEnd(p.getPageSize());
			c.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

			if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
				c.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
			}
		}
	}

	@Override
	public List<OrderServiceProvider> getSpListByOrderNo(String orderNo) {
		OrderServiceProviderExample orderServiceProviderExample = new OrderServiceProviderExample();
		Criteria criteria = orderServiceProviderExample.createCriteria();
		criteria.andOrderNoEqualTo(orderNo);
		criteria.andStatusEqualTo(1);
		return orderServiceProviderMapper.selectByExample(orderServiceProviderExample);
	}
}
