package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.MeasureGoods;
import com.efubao.core.order.domain.MeasureGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureGoodsMapper {
    int countByExample(MeasureGoodsExample example);

    int deleteByExample(MeasureGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureGoods record);

    int insertSelective(MeasureGoods record);

    List<MeasureGoods> selectByExample(MeasureGoodsExample example);

    MeasureGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureGoods record, @Param("example") MeasureGoodsExample example);

    int updateByExample(@Param("record") MeasureGoods record, @Param("example") MeasureGoodsExample example);

    int updateByPrimaryKeySelective(MeasureGoods record);

    int updateByPrimaryKey(MeasureGoods record);
}