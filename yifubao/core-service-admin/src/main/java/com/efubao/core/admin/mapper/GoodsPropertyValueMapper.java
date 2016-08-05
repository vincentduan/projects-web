package com.efubao.core.admin.mapper;

import com.efubao.core.admin.domain.GoodsPropertyValue;
import com.efubao.core.admin.domain.GoodsPropertyValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsPropertyValueMapper {
    int countByExample(GoodsPropertyValueExample example);

    int deleteByExample(GoodsPropertyValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsPropertyValue record);

    int insertSelective(GoodsPropertyValue record);

    List<GoodsPropertyValue> selectByExample(GoodsPropertyValueExample example);

    GoodsPropertyValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsPropertyValue record, @Param("example") GoodsPropertyValueExample example);

    int updateByExample(@Param("record") GoodsPropertyValue record, @Param("example") GoodsPropertyValueExample example);

    int updateByPrimaryKeySelective(GoodsPropertyValue record);

    int updateByPrimaryKey(GoodsPropertyValue record);
}