package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.OrderCustomerInfo;
import com.efubao.core.order.domain.OrderCustomerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCustomerInfoMapper {
    int countByExample(OrderCustomerInfoExample example);

    int deleteByExample(OrderCustomerInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCustomerInfo record);

    int insertSelective(OrderCustomerInfo record);

    List<OrderCustomerInfo> selectByExample(OrderCustomerInfoExample example);

    OrderCustomerInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCustomerInfo record, @Param("example") OrderCustomerInfoExample example);

    int updateByExample(@Param("record") OrderCustomerInfo record, @Param("example") OrderCustomerInfoExample example);

    int updateByPrimaryKeySelective(OrderCustomerInfo record);

    int updateByPrimaryKey(OrderCustomerInfo record);
}