package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.OrderCustomGoods;
import com.efubao.core.order.domain.OrderCustomGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCustomGoodsMapper {
    int countByExample(OrderCustomGoodsExample example);

    int deleteByExample(OrderCustomGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCustomGoods record);

    int insertSelective(OrderCustomGoods record);

    List<OrderCustomGoods> selectByExample(OrderCustomGoodsExample example);

    OrderCustomGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCustomGoods record, @Param("example") OrderCustomGoodsExample example);

    int updateByExample(@Param("record") OrderCustomGoods record, @Param("example") OrderCustomGoodsExample example);

    int updateByPrimaryKeySelective(OrderCustomGoods record);

    int updateByPrimaryKey(OrderCustomGoods record);
}