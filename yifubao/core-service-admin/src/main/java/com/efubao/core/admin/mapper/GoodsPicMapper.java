package com.efubao.core.admin.mapper;

import com.efubao.core.admin.domain.GoodsPic;
import com.efubao.core.admin.domain.GoodsPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsPicMapper {
    int countByExample(GoodsPicExample example);

    int deleteByExample(GoodsPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsPic record);

    int insertSelective(GoodsPic record);

    List<GoodsPic> selectByExample(GoodsPicExample example);

    GoodsPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsPic record, @Param("example") GoodsPicExample example);

    int updateByExample(@Param("record") GoodsPic record, @Param("example") GoodsPicExample example);

    int updateByPrimaryKeySelective(GoodsPic record);

    int updateByPrimaryKey(GoodsPic record);
}