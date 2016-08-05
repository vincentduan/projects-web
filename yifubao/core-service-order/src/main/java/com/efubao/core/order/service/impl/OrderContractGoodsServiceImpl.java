package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderContractGoods;
import com.efubao.core.order.domain.OrderContractGoodsExample;
import com.efubao.core.order.domain.OrderContractGoodsExample.Criteria;
import com.efubao.core.order.domain.OrderCustomDemandExample;
import com.efubao.core.order.mapper.OrderContractGoodsMapper;
import com.efubao.core.order.service.OrderContractGoodsService;

@Service
public class OrderContractGoodsServiceImpl implements OrderContractGoodsService {

	@Autowired
	private OrderContractGoodsMapper orderContractGoodsMapper;

	@Override
	public OrderContractGoods findById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return null;
		}
		return orderContractGoodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(OrderContractGoods t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return orderContractGoodsMapper.insertSelective(t);
	}

	@Override
	public int update(OrderContractGoods t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return orderContractGoodsMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return 0;
		}
		return orderContractGoodsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<OrderContractGoods> page, OrderContractGoods t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderContractGoods> queryByCondition(OrderContractGoods orderContractGoods) {
		if (null == orderContractGoods) {
			return null;
		}
		OrderContractGoodsExample example = new OrderContractGoodsExample();
		Criteria criteria = example.createCriteria();
		if (orderContractGoods.getOrderContractId() != null) {
			criteria.andOrderContractIdEqualTo(orderContractGoods.getOrderContractId());
		}

		return orderContractGoodsMapper.selectByExample(example);
	}

}
