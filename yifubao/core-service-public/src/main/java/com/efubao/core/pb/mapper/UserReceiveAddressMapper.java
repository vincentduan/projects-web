package com.efubao.core.pb.mapper;

import com.efubao.core.pb.domain.UserReceiveAddress;
import com.efubao.core.pb.domain.UserReceiveAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserReceiveAddressMapper {
    int countByExample(UserReceiveAddressExample example);

    int deleteByExample(UserReceiveAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserReceiveAddress record);

    int insertSelective(UserReceiveAddress record);

    List<UserReceiveAddress> selectByExample(UserReceiveAddressExample example);

    UserReceiveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserReceiveAddress record, @Param("example") UserReceiveAddressExample example);

    int updateByExample(@Param("record") UserReceiveAddress record, @Param("example") UserReceiveAddressExample example);

    int updateByPrimaryKeySelective(UserReceiveAddress record);

    int updateByPrimaryKey(UserReceiveAddress record);
}