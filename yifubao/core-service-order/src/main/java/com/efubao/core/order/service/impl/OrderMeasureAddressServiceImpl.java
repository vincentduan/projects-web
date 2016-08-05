package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.OrderMeasureAddressExample;
import com.efubao.core.order.domain.OrderMeasureAddressExample.Criteria;
import com.efubao.core.order.service.OrderMeasureAddressService;
import com.efubao.core.order.mapper.OrderMeasureAddressMapper;

@Service
public class OrderMeasureAddressServiceImpl implements OrderMeasureAddressService {

	@Autowired
	public OrderMeasureAddressMapper orderMeasureAddressMapper;

	@Override
	public OrderMeasureAddress findById(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return null;
		}
		return orderMeasureAddressMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(OrderMeasureAddress t) {
		if (t == null) {
			return 0;
		}
		return orderMeasureAddressMapper.insertSelective(t);
	}

	@Override
	public int update(OrderMeasureAddress t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return orderMeasureAddressMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return 0;
		}
		return orderMeasureAddressMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<OrderMeasureAddress> page, OrderMeasureAddress t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderMeasureAddress> queryByCondition(OrderMeasureAddress orderMeasureAddress) {
		if (orderMeasureAddress == null) {
			return null;
		}
		OrderMeasureAddressExample example = new OrderMeasureAddressExample();
		Criteria criteria = example.createCriteria();
		if (orderMeasureAddress.getOrderNo() != null) {
			criteria.andOrderNoEqualTo(orderMeasureAddress.getOrderNo());
		}
		return orderMeasureAddressMapper.selectByExample(example);
	}

}
