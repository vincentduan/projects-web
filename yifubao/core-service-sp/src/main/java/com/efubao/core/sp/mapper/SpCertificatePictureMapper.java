package com.efubao.core.sp.mapper;

import com.efubao.core.sp.domain.SpCertificatePicture;
import com.efubao.core.sp.domain.SpCertificatePictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpCertificatePictureMapper {
    int countByExample(SpCertificatePictureExample example);

    int deleteByExample(SpCertificatePictureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpCertificatePicture record);

    int insertSelective(SpCertificatePicture record);

    List<SpCertificatePicture> selectByExample(SpCertificatePictureExample example);

    SpCertificatePicture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpCertificatePicture record, @Param("example") SpCertificatePictureExample example);

    int updateByExample(@Param("record") SpCertificatePicture record, @Param("example") SpCertificatePictureExample example);

    int updateByPrimaryKeySelective(SpCertificatePicture record);

    int updateByPrimaryKey(SpCertificatePicture record);
}