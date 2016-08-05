package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.SpContract;
import com.efubao.core.sp.domain.SpContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpContractMapper {
    int countByExample(SpContractExample example);

    int deleteByExample(SpContractExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpContract record);

    int insertSelective(SpContract record);

    List<SpContract> selectByExample(SpContractExample example);

    SpContract selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpContract record, @Param("example") SpContractExample example);

    int updateByExample(@Param("record") SpContract record, @Param("example") SpContractExample example);

    int updateByPrimaryKeySelective(SpContract record);

    int updateByPrimaryKey(SpContract record);
}