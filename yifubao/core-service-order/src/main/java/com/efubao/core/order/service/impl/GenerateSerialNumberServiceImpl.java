package com.efubao.core.order.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.core.order.mapper.GenerateSerialNumberMapper;
import com.efubao.core.order.service.GenerateSerialNumberService;

@Service
public class GenerateSerialNumberServiceImpl implements GenerateSerialNumberService {
	
	@Autowired
	private GenerateSerialNumberMapper generateSerialNumberMapper;
	
	@Override
	public String getSerialNumber(SerialNumberEnum Type) {
		
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("type", Type.getValue());
		parameterMap.put("orderNo", -1);
		generateSerialNumberMapper.getSerialNumber(parameterMap);
		return (String)parameterMap.get("orderNo");
	}
}