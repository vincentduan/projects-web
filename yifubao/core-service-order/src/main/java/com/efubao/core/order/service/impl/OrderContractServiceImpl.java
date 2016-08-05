package com.efubao.core.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderContract;
import com.efubao.core.order.mapper.OrderContractMapper;
import com.efubao.core.order.service.OrderContractService;

@Service
public class OrderContractServiceImpl implements OrderContractService {

	@Autowired
	private OrderContractMapper orderContractMapper;

	@Override
	public OrderContract findById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return null;
		}
		return orderContractMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(OrderContract t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return orderContractMapper.insertSelective(t);
	}

	@Override
	public int update(OrderContract t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return orderContractMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return 0;
		}
		return orderContractMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<OrderContract> page, OrderContract t) {
		// TODO Auto-generated method stub

	}

}
