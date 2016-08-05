package com.efubao.core.admin.mapper;

import com.efubao.core.admin.domain.GoodsSKU;
import com.efubao.core.admin.domain.GoodsSKUExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSKUMapper {
    int countByExample(GoodsSKUExample example);

    int deleteByExample(GoodsSKUExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsSKU record);

    int insertSelective(GoodsSKU record);

    List<GoodsSKU> selectByExample(GoodsSKUExample example);

    GoodsSKU selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsSKU record, @Param("example") GoodsSKUExample example);

    int updateByExample(@Param("record") GoodsSKU record, @Param("example") GoodsSKUExample example);

    int updateByPrimaryKeySelective(GoodsSKU record);

    int updateByPrimaryKey(GoodsSKU record);
    
    List<GoodsSKU> selectByGoods(String name,Integer categoryId,Integer start,Integer end);
    
    int selectByGoodsCounts(String name,Integer categoryId);
}