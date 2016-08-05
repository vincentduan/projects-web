package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.OrderStatusStream;
import com.efubao.core.order.domain.OrderStatusStreamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderStatusStreamMapper {
    int countByExample(OrderStatusStreamExample example);

    int deleteByExample(OrderStatusStreamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderStatusStream record);

    int insertSelective(OrderStatusStream record);

    List<OrderStatusStream> selectByExample(OrderStatusStreamExample example);

    OrderStatusStream selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderStatusStream record, @Param("example") OrderStatusStreamExample example);

    int updateByExample(@Param("record") OrderStatusStream record, @Param("example") OrderStatusStreamExample example);

    int updateByPrimaryKeySelective(OrderStatusStream record);

    int updateByPrimaryKey(OrderStatusStream record);
}