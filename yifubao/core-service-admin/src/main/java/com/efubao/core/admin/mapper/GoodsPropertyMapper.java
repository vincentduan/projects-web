package com.efubao.core.admin.mapper;

import com.efubao.core.admin.domain.GoodsProperty;
import com.efubao.core.admin.domain.GoodsPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsPropertyMapper {
    int countByExample(GoodsPropertyExample example);

    int deleteByExample(GoodsPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProperty record);

    int insertSelective(GoodsProperty record);

    List<GoodsProperty> selectByExample(GoodsPropertyExample example);

    GoodsProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProperty record, @Param("example") GoodsPropertyExample example);

    int updateByExample(@Param("record") GoodsProperty record, @Param("example") GoodsPropertyExample example);

    int updateByPrimaryKeySelective(GoodsProperty record);

    int updateByPrimaryKey(GoodsProperty record);
}