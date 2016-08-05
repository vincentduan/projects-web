package com.efubao.core.order.mapper;

import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.BaseOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseOrderMapper {
    int countByExample(BaseOrderExample example);

    int deleteByExample(BaseOrderExample example);

    int deleteByPrimaryKey(String orderNo);

    int insert(BaseOrder record);

    int insertSelective(BaseOrder record);

    List<BaseOrder> selectByExample(BaseOrderExample example);

    BaseOrder selectByPrimaryKey(String orderNo);

    int updateByExampleSelective(@Param("record") BaseOrder record, @Param("example") BaseOrderExample example);

    int updateByExample(@Param("record") BaseOrder record, @Param("example") BaseOrderExample example);

    int updateByPrimaryKeySelective(BaseOrder record);

    int updateByPrimaryKey(BaseOrder record);
}