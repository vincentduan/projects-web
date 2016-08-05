package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.MeasureInfo;
import com.efubao.core.order.domain.MeasureInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureInfoMapper {
    int countByExample(MeasureInfoExample example);

    int deleteByExample(MeasureInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureInfo record);

    int insertSelective(MeasureInfo record);

    List<MeasureInfo> selectByExample(MeasureInfoExample example);

    MeasureInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureInfo record, @Param("example") MeasureInfoExample example);

    int updateByExample(@Param("record") MeasureInfo record, @Param("example") MeasureInfoExample example);

    int updateByPrimaryKeySelective(MeasureInfo record);

    int updateByPrimaryKey(MeasureInfo record);
}