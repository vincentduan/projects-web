package com.efubao.core.admin.mapper;

import com.efubao.core.admin.domain.MeasureProperty;
import com.efubao.core.admin.domain.MeasurePropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasurePropertyMapper {
    int countByExample(MeasurePropertyExample example);

    int deleteByExample(MeasurePropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureProperty record);

    int insertSelective(MeasureProperty record);

    List<MeasureProperty> selectByExample(MeasurePropertyExample example);

    MeasureProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureProperty record, @Param("example") MeasurePropertyExample example);

    int updateByExample(@Param("record") MeasureProperty record, @Param("example") MeasurePropertyExample example);

    int updateByPrimaryKeySelective(MeasureProperty record);

    int updateByPrimaryKey(MeasureProperty record);
}