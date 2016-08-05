package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderMeasureAddressExample;
import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.domain.OrderStatusStreamExample;
import com.efubao.core.order.domain.OrderStatusStreamExample.Criteria;
import com.efubao.core.order.service.OrderStatusStreamService;
import com.efubao.core.order.mapper.OrderStatusStreamMapper;
@Service
public class OrderStatusStreamServiceImpl implements OrderStatusStreamService {
    @Autowired
	public OrderStatusStreamMapper orderStatusStreamMapper;
	@Override
	public OrderStatusStream findById(Long id) {
		if(id == null){
			return null;
		}
		return orderStatusStreamMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(OrderStatusStream t) {
		if(t == null){
			return 0;
		}
		return orderStatusStreamMapper.insertSelective(t);
	}

	@Override
	public int update(OrderStatusStream t) {
		if(t == null){
			return 0;
		}
		return orderStatusStreamMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if(id == null){
			return 0;
		}
		return orderStatusStreamMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<OrderStatusStream> page, OrderStatusStream t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderStatusStream> queryByCondition(OrderStatusStream orderStatusStream) {
		if(orderStatusStream == null){
			return null;
		}
		OrderStatusStreamExample example = new OrderStatusStreamExample();
		Criteria criteria = example.createCriteria();
		if(orderStatusStream.getOrderNo()!=null){
			criteria.andOrderNoEqualTo(orderStatusStream.getOrderNo());
		}
		return orderStatusStreamMapper.selectByExample(example);
	}

}
