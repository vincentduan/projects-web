package com.efubao.core.pb.service;

import java.util.List;

import com.efubao.core.pb.domain.City;

/**
 * 城市字典service
 * 
 * @author zhangzhiyong
 * 
 */
public interface CityService {

	City findById(Long id);

	List<City> findByPid(Long parentId);

	List<City> findByClevel(Integer levelType, String name);

}
