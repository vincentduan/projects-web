package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.OrderContractGoods;
import com.efubao.core.order.domain.OrderContractGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderContractGoodsMapper {
    int countByExample(OrderContractGoodsExample example);

    int deleteByExample(OrderContractGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderContractGoods record);

    int insertSelective(OrderContractGoods record);

    List<OrderContractGoods> selectByExample(OrderContractGoodsExample example);

    OrderContractGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderContractGoods record, @Param("example") OrderContractGoodsExample example);

    int updateByExample(@Param("record") OrderContractGoods record, @Param("example") OrderContractGoodsExample example);

    int updateByPrimaryKeySelective(OrderContractGoods record);

    int updateByPrimaryKey(OrderContractGoods record);
}