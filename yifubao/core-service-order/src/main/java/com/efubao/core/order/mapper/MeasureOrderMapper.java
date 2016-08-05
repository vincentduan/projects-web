package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.MeasureOrder;
import com.efubao.core.order.domain.MeasureOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureOrderMapper {
    int countByExample(MeasureOrderExample example);
    
    long sumMeasureNum();

    int deleteByExample(MeasureOrderExample example);

    int deleteByPrimaryKey(String measureOrderNo);

    int insert(MeasureOrder record);

    int insertSelective(MeasureOrder record);

    List<MeasureOrder> selectByExample(MeasureOrderExample example);

    MeasureOrder selectByPrimaryKey(String measureOrderNo);

    int updateByExampleSelective(@Param("record") MeasureOrder record, @Param("example") MeasureOrderExample example);

    int updateByExample(@Param("record") MeasureOrder record, @Param("example") MeasureOrderExample example);

    int updateByPrimaryKeySelective(MeasureOrder record);

    int updateByPrimaryKey(MeasureOrder record);
    
    Integer sumMeasureNumByConditon(MeasureOrder record);
}