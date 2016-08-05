package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.SpCategoryRelation;
import com.efubao.core.sp.domain.SpCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpCategoryRelationMapper {
    int countByExample(SpCategoryRelationExample example);

    int deleteByExample(SpCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpCategoryRelation record);

    int insertSelective(SpCategoryRelation record);

    List<SpCategoryRelation> selectByExample(SpCategoryRelationExample example);

    SpCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpCategoryRelation record, @Param("example") SpCategoryRelationExample example);

    int updateByExample(@Param("record") SpCategoryRelation record, @Param("example") SpCategoryRelationExample example);

    int updateByPrimaryKeySelective(SpCategoryRelation record);

    int updateByPrimaryKey(SpCategoryRelation record);
}