package com.efubao.core.admin.mapper;

import com.efubao.core.admin.domain.ServiceProviderGoods;
import com.efubao.core.admin.domain.ServiceProviderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceProviderGoodsMapper {
    int countByExample(ServiceProviderGoodsExample example);

    int deleteByExample(ServiceProviderGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServiceProviderGoods record);

    int insertSelective(ServiceProviderGoods record);

    List<ServiceProviderGoods> selectByExample(ServiceProviderGoodsExample example);

    ServiceProviderGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServiceProviderGoods record, @Param("example") ServiceProviderGoodsExample example);

    int updateByExample(@Param("record") ServiceProviderGoods record, @Param("example") ServiceProviderGoodsExample example);

    int updateByPrimaryKeySelective(ServiceProviderGoods record);

    int updateByPrimaryKey(ServiceProviderGoods record);
}