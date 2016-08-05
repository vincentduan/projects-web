package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.ServiceProvider;
import com.efubao.core.sp.domain.ServiceProviderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ServiceProviderMapper {
    int countByExample(ServiceProviderExample example);

    int deleteByExample(ServiceProviderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServiceProvider record);

    int insertSelective(ServiceProvider record);

    List<ServiceProvider> selectByExampleWithBLOBs(ServiceProviderExample example);

    List<ServiceProvider> selectByExample(ServiceProviderExample example);

    ServiceProvider selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServiceProvider record, @Param("example") ServiceProviderExample example);

    int updateByExampleWithBLOBs(@Param("record") ServiceProvider record, @Param("example") ServiceProviderExample example);

    int updateByExample(@Param("record") ServiceProvider record, @Param("example") ServiceProviderExample example);

    int updateByPrimaryKeySelective(ServiceProvider record);

    int updateByPrimaryKeyWithBLOBs(ServiceProvider record);

    int updateByPrimaryKey(ServiceProvider record);
    
//    List<ServiceProvider> getServiceP(Map<String,Object> map);
//    
//    int countServiceP(Map<String,Object> map);
    
    List<ServiceProvider> getServiceP(String spName,Integer categoryId,Integer start,Integer end);
  
    int countServiceP(String spName,Integer categoryId,Integer start,Integer end);
}