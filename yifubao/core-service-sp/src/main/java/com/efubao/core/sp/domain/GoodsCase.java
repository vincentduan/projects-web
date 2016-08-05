package com.efubao.core.sp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.efubao.core.common.base.BasePo;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-15
 *
 */
public class GoodsCase extends BasePo implements Serializable {
    /**  */
    private Long id;

    /** 案例名称 */
    private String caseName;

    /** 定制方案 */
    private String plan;

    /** 定制费用:0-保密 */
    private BigDecimal cost;

    /** 客户名称 */
    private String customerName;

    /** 行业ID */
    private Long industryId;

    /** 所属品类 */
    private Long categoryId;

    /** 服务商ID:0-平台案例 */
    private Long spId;

    /** 客户评价 */
    private String customerEvaluation;

    /** 定制数量 */
    private Integer customNum;

    /** 定制周期(天数) */
    private Integer customCycle;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    /** 案例描述 */
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public String getCustomerEvaluation() {
        return customerEvaluation;
    }

    public void setCustomerEvaluation(String customerEvaluation) {
        this.customerEvaluation = customerEvaluation;
    }

    public Integer getCustomNum() {
        return customNum;
    }

    public void setCustomNum(Integer customNum) {
        this.customNum = customNum;
    }

    public Integer getCustomCycle() {
        return customCycle;
    }

    public void setCustomCycle(Integer customCycle) {
        this.customCycle = customCycle;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}