package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.OrderContract;
import com.efubao.core.order.domain.OrderContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderContractMapper {
    int countByExample(OrderContractExample example);

    int deleteByExample(OrderContractExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderContract record);

    int insertSelective(OrderContract record);

    List<OrderContract> selectByExample(OrderContractExample example);

    OrderContract selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderContract record, @Param("example") OrderContractExample example);

    int updateByExample(@Param("record") OrderContract record, @Param("example") OrderContractExample example);

    int updateByPrimaryKeySelective(OrderContract record);

    int updateByPrimaryKey(OrderContract record);
}