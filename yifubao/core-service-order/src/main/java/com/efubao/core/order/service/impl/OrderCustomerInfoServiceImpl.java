package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderCustomerInfoExample;
import com.efubao.core.order.domain.OrderCustomerInfoExample.Criteria;
import com.efubao.core.order.mapper.OrderCustomerInfoMapper;
import com.efubao.core.order.service.OrderCustomerInfoService;

@Service
public class OrderCustomerInfoServiceImpl implements OrderCustomerInfoService {

	@Autowired
	public OrderCustomerInfoMapper orderCustomerInfoMapper;

	@Override
	public OrderCustomerInfo findById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return null;
		}
		return orderCustomerInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(OrderCustomerInfo t) {
		if (null == t) {
			return 0;
		}
		return orderCustomerInfoMapper.insertSelective(t);
	}

	@Override
	public int update(OrderCustomerInfo t) {
		if (null == t) {
			return 0;
		}
		return orderCustomerInfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return 0;
		}
		return orderCustomerInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<OrderCustomerInfo> page, OrderCustomerInfo t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderCustomerInfo> queryByCondition(OrderCustomerInfo orderCustomerInfo) {
		if (null == orderCustomerInfo) {
			return null;
		}
		OrderCustomerInfoExample example = new OrderCustomerInfoExample();
		Criteria criteria = example.createCriteria();
		if (null != orderCustomerInfo.getOrderNo()) {
			criteria.andOrderNoEqualTo(orderCustomerInfo.getOrderNo());
		}
		return orderCustomerInfoMapper.selectByExample(example);
	}

}
