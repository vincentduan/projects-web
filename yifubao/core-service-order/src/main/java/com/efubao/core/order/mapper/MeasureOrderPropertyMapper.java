package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.MeasureOrderProperty;
import com.efubao.core.order.domain.MeasureOrderPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureOrderPropertyMapper {
    int countByExample(MeasureOrderPropertyExample example);

    int deleteByExample(MeasureOrderPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureOrderProperty record);

    int insertSelective(MeasureOrderProperty record);

    List<MeasureOrderProperty> selectByExample(MeasureOrderPropertyExample example);

    MeasureOrderProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureOrderProperty record, @Param("example") MeasureOrderPropertyExample example);

    int updateByExample(@Param("record") MeasureOrderProperty record, @Param("example") MeasureOrderPropertyExample example);

    int updateByPrimaryKeySelective(MeasureOrderProperty record);

    int updateByPrimaryKey(MeasureOrderProperty record);
}