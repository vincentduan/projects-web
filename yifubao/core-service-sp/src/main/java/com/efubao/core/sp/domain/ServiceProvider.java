package com.efubao.core.sp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-09
 *
 */
public class ServiceProvider implements Serializable {
    /** 主键 */
    private Long id;

    /** 供应商名称 */
    private String name;

    /** 供应商等级:ABCD */
    private String grade;

    /** 供应商简称 */
    private String shortname;

    /** 公司名称 */
    private String companyName;

    /** 法人姓名 */
    private String legalPerson;

    /** 注册地址 */
    private String registeredAddr;

    /** 注册资金 */
    private Long registeredCapital;

    /** 营业执照注册号 */
    private String businessLicenceNo;

    /** 税务登记证号 */
    private String taxRegistrationNo;

    /** 组织机构代码 */
    private String orgCode;

    /** 经营开始日期 */
    private Date businessStartDate;

    /** 经营结束日期 */
    private Date businessEndDate;

    /** 经营范围 */
    private String businessRange;

    /** 备注 */
    private String remarks;

    /** 状态:1-未开通;2-正常;3-冻结 */
    private Integer status;

    /** 服务商logo图片路径 */
    private String logoImagePath;

    /** 服务类别:1-高端定制;2-量体定制;3-标准定制 */
    private String serviceCategory;

    /** 是否支持量体 */
    private Boolean isSupportMeasure;

    /** 创建者 */
    private Long creatorId;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新者 */
    private Long updator;

    /** 更新时间 */
    private Timestamp updateTime;

    /** 审核状态:1-未审核;2-审核通过;3-审核不通过 */
    private Integer checkState;

    /** 是否删除 */
    private Boolean isDel;

    /** 企业简介 */
    private String summary;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegisteredAddr() {
        return registeredAddr;
    }

    public void setRegisteredAddr(String registeredAddr) {
        this.registeredAddr = registeredAddr;
    }

    public Long getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Long registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getBusinessLicenceNo() {
        return businessLicenceNo;
    }

    public void setBusinessLicenceNo(String businessLicenceNo) {
        this.businessLicenceNo = businessLicenceNo;
    }

    public String getTaxRegistrationNo() {
        return taxRegistrationNo;
    }

    public void setTaxRegistrationNo(String taxRegistrationNo) {
        this.taxRegistrationNo = taxRegistrationNo;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Date getBusinessStartDate() {
        return businessStartDate;
    }

    public void setBusinessStartDate(Date businessStartDate) {
        this.businessStartDate = businessStartDate;
    }

    public Date getBusinessEndDate() {
        return businessEndDate;
    }

    public void setBusinessEndDate(Date businessEndDate) {
        this.businessEndDate = businessEndDate;
    }

    public String getBusinessRange() {
        return businessRange;
    }

    public void setBusinessRange(String businessRange) {
        this.businessRange = businessRange;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLogoImagePath() {
        return logoImagePath;
    }

    public void setLogoImagePath(String logoImagePath) {
        this.logoImagePath = logoImagePath;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public Boolean getIsSupportMeasure() {
        return isSupportMeasure;
    }

    public void setIsSupportMeasure(Boolean isSupportMeasure) {
        this.isSupportMeasure = isSupportMeasure;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getUpdator() {
        return updator;
    }

    public void setUpdator(Long updator) {
        this.updator = updator;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}