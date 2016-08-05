package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.OrderServiceProvider;
import com.efubao.core.order.domain.OrderServiceProviderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderServiceProviderMapper {
    int countByExample(OrderServiceProviderExample example);

    int deleteByExample(OrderServiceProviderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderServiceProvider record);

    int insertSelective(OrderServiceProvider record);

    List<OrderServiceProvider> selectByExample(OrderServiceProviderExample example);

    OrderServiceProvider selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderServiceProvider record, @Param("example") OrderServiceProviderExample example);

    int updateByExample(@Param("record") OrderServiceProvider record, @Param("example") OrderServiceProviderExample example);

    int updateByPrimaryKeySelective(OrderServiceProvider record);

    int updateByPrimaryKey(OrderServiceProvider record);
}