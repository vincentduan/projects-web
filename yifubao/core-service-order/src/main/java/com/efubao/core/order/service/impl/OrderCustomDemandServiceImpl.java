package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomDemandExample;
import com.efubao.core.order.domain.OrderCustomDemandExample.Criteria;
import com.efubao.core.order.mapper.OrderCustomDemandMapper;
import com.efubao.core.order.service.OrderCustomDemandService;

@Service
public class OrderCustomDemandServiceImpl implements OrderCustomDemandService {
	@Autowired
	public OrderCustomDemandMapper orderCustomDemandMapper;

	@Override
	public OrderCustomDemand findById(Long id) {
		if (null == id) {
			return null;
		}
		return orderCustomDemandMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(OrderCustomDemand t) {
		if (null == t) {
			return 0;
		}
		return orderCustomDemandMapper.insertSelective(t);
	}

	@Override
	public int update(OrderCustomDemand t) {
		if (null == t) {
			return 0;
		}
		return orderCustomDemandMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (null == id) {
			return 0;
		}
		return orderCustomDemandMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<OrderCustomDemand> page, OrderCustomDemand t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderCustomDemand> queryByCondition(OrderCustomDemand orderCustomDemand) {
		if (null == orderCustomDemand) {
			return null;
		}
		OrderCustomDemandExample example = new OrderCustomDemandExample();
		Criteria criteria = example.createCriteria();
		if (orderCustomDemand.getOrderNo() != null) {
			criteria.andOrderNoEqualTo(orderCustomDemand.getOrderNo());
		}

		return orderCustomDemandMapper.selectByExample(example);
	}

}
