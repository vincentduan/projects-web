package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.MeasureInfoProperty;
import com.efubao.core.order.domain.MeasureInfoPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureInfoPropertyMapper {
    int countByExample(MeasureInfoPropertyExample example);

    int deleteByExample(MeasureInfoPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureInfoProperty record);

    int insertSelective(MeasureInfoProperty record);

    List<MeasureInfoProperty> selectByExample(MeasureInfoPropertyExample example);

    MeasureInfoProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureInfoProperty record, @Param("example") MeasureInfoPropertyExample example);

    int updateByExample(@Param("record") MeasureInfoProperty record, @Param("example") MeasureInfoPropertyExample example);

    int updateByPrimaryKeySelective(MeasureInfoProperty record);

    int updateByPrimaryKey(MeasureInfoProperty record);
}