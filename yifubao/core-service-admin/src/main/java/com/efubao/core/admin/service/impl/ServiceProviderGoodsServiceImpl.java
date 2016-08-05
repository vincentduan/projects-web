package com.efubao.core.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.ServiceProviderGoods;
import com.efubao.core.admin.mapper.ServiceProviderGoodsMapper;
import com.efubao.core.admin.service.ServiceProviderGoodsService;

@Service
public class ServiceProviderGoodsServiceImpl implements ServiceProviderGoodsService {

	@Autowired
	private ServiceProviderGoodsMapper serviceProviderGoodsMapper;

	@Override
	public ServiceProviderGoods findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(ServiceProviderGoods t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ServiceProviderGoods t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void queryByPage(Page<ServiceProviderGoods> page,
			ServiceProviderGoods t) {
		// TODO Auto-generated method stub
		
	}

	
}
