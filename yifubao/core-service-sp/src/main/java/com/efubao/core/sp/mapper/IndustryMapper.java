package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.Industry;
import com.efubao.core.sp.domain.IndustryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndustryMapper {
    int countByExample(IndustryExample example);

    int deleteByExample(IndustryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Industry record);

    int insertSelective(Industry record);

    List<Industry> selectByExample(IndustryExample example);

    Industry selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Industry record, @Param("example") IndustryExample example);

    int updateByExample(@Param("record") Industry record, @Param("example") IndustryExample example);

    int updateByPrimaryKeySelective(Industry record);

    int updateByPrimaryKey(Industry record);
}