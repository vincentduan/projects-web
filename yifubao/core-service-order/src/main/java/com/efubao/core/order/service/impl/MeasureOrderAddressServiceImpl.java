package com.efubao.core.order.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.MeasureOrderAddress;
import com.efubao.core.order.domain.MeasureOrderAddressExample;
import com.efubao.core.order.mapper.MeasureOrderAddressMapper;
import com.efubao.core.order.service.MeasureOrderAddressService;

@Service
public class MeasureOrderAddressServiceImpl implements MeasureOrderAddressService {

	@Autowired
	private MeasureOrderAddressMapper mapper;

	@Override
	public MeasureOrderAddress findById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return null;
		}
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MeasureOrderAddress t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return mapper.insertSelective(t);
	}

	@Override
	public int update(MeasureOrderAddress t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return mapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return 0;
		}
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<MeasureOrderAddress> page, MeasureOrderAddress t) {
		// TODO Auto-generated method stub

	}

	@Override
	public MeasureOrderAddress findByMeasureOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		if (null == orderNo) {
			return null;
		}
		MeasureOrderAddressExample example = new MeasureOrderAddressExample();
		MeasureOrderAddressExample.Criteria criteria = example.createCriteria();
		criteria.andMeasureOrderNoEqualTo(orderNo);

		List<MeasureOrderAddress> addresses = mapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(addresses))
			return addresses.get(0);
		return null;
	}

}
