package com.efubao.core.admin.mapper;

import com.efubao.core.admin.domain.MeasureType;
import com.efubao.core.admin.domain.MeasureTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureTypeMapper {
    int countByExample(MeasureTypeExample example);

    int deleteByExample(MeasureTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureType record);

    int insertSelective(MeasureType record);

    List<MeasureType> selectByExample(MeasureTypeExample example);

    MeasureType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureType record, @Param("example") MeasureTypeExample example);

    int updateByExample(@Param("record") MeasureType record, @Param("example") MeasureTypeExample example);

    int updateByPrimaryKeySelective(MeasureType record);

    int updateByPrimaryKey(MeasureType record);
}