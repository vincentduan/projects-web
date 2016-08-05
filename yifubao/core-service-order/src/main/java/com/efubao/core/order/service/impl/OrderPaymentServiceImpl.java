package com.efubao.core.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderPayment;
import com.efubao.core.order.mapper.OrderPaymentMapper;
import com.efubao.core.order.service.OrderPaymentService;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {
	@Autowired
	public OrderPaymentMapper orderPaymentMapper;

	@Override
	public OrderPayment findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(OrderPayment t) {
		if(t == null){
			return 0;
		}
		return orderPaymentMapper.insertSelective(t);
	}

	@Override
	public int update(OrderPayment t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void queryByPage(Page<OrderPayment> page, OrderPayment t) {
		// TODO Auto-generated method stub

	}

}
