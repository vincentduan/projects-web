package com.efubao.core.sp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.efubao.core.common.base.BasePo;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-09
 *
 */
public class MeasureMaster extends BasePo implements Serializable {
    /**  */
    private Long id;

    /** 姓名 */
    private String name;

    /** 手机号 */
    private String mobile;

    /** 密码 */
    private String pwd;

    /** 专业评价:12345 */
    private BigDecimal specialtyEvaluation;

    /** 量体经验 */
    private String measureExperience;

    /** 个人介绍 */
    private String introduction;

    /** 头像图片路径 */
    private String avatarImagePath;

    /** 性别:1-男;2-女 */
    private Integer gender;

    /** 状态:1-正常;2-冻结 */
    private Integer status;

    /** 服务商ID */
    private Long spId;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public BigDecimal getSpecialtyEvaluation() {
        return specialtyEvaluation;
    }

    public void setSpecialtyEvaluation(BigDecimal specialtyEvaluation) {
        this.specialtyEvaluation = specialtyEvaluation;
    }

    public String getMeasureExperience() {
        return measureExperience;
    }

    public void setMeasureExperience(String measureExperience) {
        this.measureExperience = measureExperience;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatarImagePath() {
        return avatarImagePath;
    }

    public void setAvatarImagePath(String avatarImagePath) {
        this.avatarImagePath = avatarImagePath;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
    
}