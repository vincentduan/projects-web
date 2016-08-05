package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.OrderMeasureAddress;
import com.efubao.core.order.domain.OrderMeasureAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMeasureAddressMapper {
    int countByExample(OrderMeasureAddressExample example);

    int deleteByExample(OrderMeasureAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderMeasureAddress record);

    int insertSelective(OrderMeasureAddress record);

    List<OrderMeasureAddress> selectByExample(OrderMeasureAddressExample example);

    OrderMeasureAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderMeasureAddress record, @Param("example") OrderMeasureAddressExample example);

    int updateByExample(@Param("record") OrderMeasureAddress record, @Param("example") OrderMeasureAddressExample example);

    int updateByPrimaryKeySelective(OrderMeasureAddress record);

    int updateByPrimaryKey(OrderMeasureAddress record);
}