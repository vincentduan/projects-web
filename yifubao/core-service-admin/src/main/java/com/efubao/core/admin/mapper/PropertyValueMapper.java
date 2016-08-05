package com.efubao.core.admin.mapper;

import com.efubao.core.admin.domain.PropertyValue;
import com.efubao.core.admin.domain.PropertyValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyValueMapper {
    int countByExample(PropertyValueExample example);

    int deleteByExample(PropertyValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PropertyValue record);

    int insertSelective(PropertyValue record);

    List<PropertyValue> selectByExample(PropertyValueExample example);

    PropertyValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PropertyValue record, @Param("example") PropertyValueExample example);

    int updateByExample(@Param("record") PropertyValue record, @Param("example") PropertyValueExample example);

    int updateByPrimaryKeySelective(PropertyValue record);

    int updateByPrimaryKey(PropertyValue record);
}