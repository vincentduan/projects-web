package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.MeasureMaster;
import com.efubao.core.sp.domain.MeasureMasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureMasterMapper {
    int countByExample(MeasureMasterExample example);

    int deleteByExample(MeasureMasterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureMaster record);

    int insertSelective(MeasureMaster record);

    List<MeasureMaster> selectByExample(MeasureMasterExample example);

    MeasureMaster selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureMaster record, @Param("example") MeasureMasterExample example);

    int updateByExample(@Param("record") MeasureMaster record, @Param("example") MeasureMasterExample example);

    int updateByPrimaryKeySelective(MeasureMaster record);

    int updateByPrimaryKey(MeasureMaster record);
}