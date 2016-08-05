package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.MeasureOrderStatusStream;
import com.efubao.core.order.domain.MeasureOrderStatusStreamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureOrderStatusStreamMapper {
    int countByExample(MeasureOrderStatusStreamExample example);

    int deleteByExample(MeasureOrderStatusStreamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeasureOrderStatusStream record);

    int insertSelective(MeasureOrderStatusStream record);

    List<MeasureOrderStatusStream> selectByExample(MeasureOrderStatusStreamExample example);

    MeasureOrderStatusStream selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeasureOrderStatusStream record, @Param("example") MeasureOrderStatusStreamExample example);

    int updateByExample(@Param("record") MeasureOrderStatusStream record, @Param("example") MeasureOrderStatusStreamExample example);

    int updateByPrimaryKeySelective(MeasureOrderStatusStream record);

    int updateByPrimaryKey(MeasureOrderStatusStream record);
}