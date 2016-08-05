package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.OrderCustomDemand;
import com.efubao.core.order.domain.OrderCustomDemandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCustomDemandMapper {
    int countByExample(OrderCustomDemandExample example);

    int deleteByExample(OrderCustomDemandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCustomDemand record);

    int insertSelective(OrderCustomDemand record);

    List<OrderCustomDemand> selectByExample(OrderCustomDemandExample example);

    OrderCustomDemand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCustomDemand record, @Param("example") OrderCustomDemandExample example);

    int updateByExample(@Param("record") OrderCustomDemand record, @Param("example") OrderCustomDemandExample example);

    int updateByPrimaryKeySelective(OrderCustomDemand record);

    int updateByPrimaryKey(OrderCustomDemand record);
}