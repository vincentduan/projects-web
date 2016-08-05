package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.GoodsCase;
import com.efubao.core.sp.domain.GoodsCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCaseMapper {
    int countByExample(GoodsCaseExample example);

    int deleteByExample(GoodsCaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCase record);

    int insertSelective(GoodsCase record);

    List<GoodsCase> selectByExampleWithBLOBs(GoodsCaseExample example);

    List<GoodsCase> selectByExample(GoodsCaseExample example);

    GoodsCase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCase record, @Param("example") GoodsCaseExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsCase record, @Param("example") GoodsCaseExample example);

    int updateByExample(@Param("record") GoodsCase record, @Param("example") GoodsCaseExample example);

    int updateByPrimaryKeySelective(GoodsCase record);

    int updateByPrimaryKeyWithBLOBs(GoodsCase record);

    int updateByPrimaryKey(GoodsCase record);
}