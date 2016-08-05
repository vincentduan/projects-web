package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.ReceiveAddress;
import com.efubao.core.order.domain.ReceiveAddressExample;
import com.efubao.core.order.mapper.ReceiveAddressMapper;
import com.efubao.core.order.service.ReceiveAddressService;
@Service
public class ReceiveAddressServiceImpl implements ReceiveAddressService {
	@Autowired
	public ReceiveAddressMapper receiveAddressMapper;

	@Override
	public ReceiveAddress findById(Long id) {
		if(id == null){
			return null;
		}
		return receiveAddressMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(ReceiveAddress t) {
		if(t == null){
			return 0;
		}
		return receiveAddressMapper.insertSelective(t);
	}

	@Override
	public int update(ReceiveAddress t) {
		if(t == null){
			return 0;
		}
		return receiveAddressMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if(id == null){
			return 0;
		}
		return receiveAddressMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<ReceiveAddress> page, ReceiveAddress t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ReceiveAddress> queryByCondition(ReceiveAddress reciveAddress) {
		if(reciveAddress == null){
			return null;
		}
		ReceiveAddressExample example = new ReceiveAddressExample();
		ReceiveAddressExample.Criteria criteria = example.createCriteria();
		if(reciveAddress.getOrderNo() != null){
			criteria.andOrderNoEqualTo(reciveAddress.getOrderNo());
		}
		
		return receiveAddressMapper.selectByExample(example);
	}

}
