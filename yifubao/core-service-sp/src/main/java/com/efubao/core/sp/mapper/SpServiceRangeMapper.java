package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.SpServiceRange;
import com.efubao.core.sp.domain.SpServiceRangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpServiceRangeMapper {
    int countByExample(SpServiceRangeExample example);

    int deleteByExample(SpServiceRangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpServiceRange record);

    int insertSelective(SpServiceRange record);

    List<SpServiceRange> selectByExample(SpServiceRangeExample example);

    SpServiceRange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpServiceRange record, @Param("example") SpServiceRangeExample example);

    int updateByExample(@Param("record") SpServiceRange record, @Param("example") SpServiceRangeExample example);

    int updateByPrimaryKeySelective(SpServiceRange record);

    int updateByPrimaryKey(SpServiceRange record);
}