package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.MeasureOrderAddress;
import com.efubao.core.order.domain.MeasureOrderAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureOrderAddressMapper {
    int countByExample(MeasureOrderAddressExample example);

    int deleteByExample(MeasureOrderAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureOrderAddress record);

    int insertSelective(MeasureOrderAddress record);

    List<MeasureOrderAddress> selectByExample(MeasureOrderAddressExample example);

    MeasureOrderAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureOrderAddress record, @Param("example") MeasureOrderAddressExample example);

    int updateByExample(@Param("record") MeasureOrderAddress record, @Param("example") MeasureOrderAddressExample example);

    int updateByPrimaryKeySelective(MeasureOrderAddress record);

    int updateByPrimaryKey(MeasureOrderAddress record);
}