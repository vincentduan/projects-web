package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomGoodsExample;
import com.efubao.core.order.domain.OrderCustomGoodsExample.Criteria;
import com.efubao.core.order.mapper.OrderCustomGoodsMapper;
import com.efubao.core.order.service.OrderCustomGoodsService;
@Service
public class OrderCustomGoodsServiceImpl implements OrderCustomGoodsService {
	@Autowired
	public OrderCustomGoodsMapper orderCustomGoodsMapper;

	@Override
	public OrderCustomGoods findById(Long id) {
		if(id == null){
			return null;
		}
		return orderCustomGoodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(OrderCustomGoods t) {
		if(t == null){
			return 0;
		}
		return orderCustomGoodsMapper.insertSelective(t);
	}

	@Override
	public int update(OrderCustomGoods t) {
		if(t == null){
			return 0;
		}
		return orderCustomGoodsMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if(id == null){
			return 0;
		}
		return orderCustomGoodsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<OrderCustomGoods> page, OrderCustomGoods t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderCustomGoods> queryByCondition(OrderCustomGoods orderCustomGoods) {

		if(orderCustomGoods == null){
			return null;
		}
		OrderCustomGoodsExample example = new OrderCustomGoodsExample();
		Criteria criteria = example.createCriteria();
		if(orderCustomGoods.getOrderCustomDemandId() !=null){
			criteria.andOrderCustomDemandIdEqualTo(orderCustomGoods.getOrderCustomDemandId());
		}
		return orderCustomGoodsMapper.selectByExample(example);
	}

}
