package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.CasePicture;
import com.efubao.core.sp.domain.CasePictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CasePictureMapper {
    int countByExample(CasePictureExample example);

    int deleteByExample(CasePictureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CasePicture record);

    int insertSelective(CasePicture record);

    List<CasePicture> selectByExample(CasePictureExample example);

    CasePicture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CasePicture record, @Param("example") CasePictureExample example);

    int updateByExample(@Param("record") CasePicture record, @Param("example") CasePictureExample example);

    int updateByPrimaryKeySelective(CasePicture record);

    int updateByPrimaryKey(CasePicture record);
}