package com.efubao.core.sp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-09
 *
 */
public class SpContract implements Serializable {
	/**  */
	private Long id;

	/** 合同名称 */
	private String contractName;

	/** 合同编号 */
	private String contractNum;

	/** 合同有效开始日期 */
	private Date validStartDate;

	/** 合同有效结束日期 */
	private Date validEndDate;

	/** 发票类型:1普通发票;2-增值税发票 */
	private String invoiceType;

	/** 平台佣金比例 */
	private BigDecimal commissionPercent;

	/** 预付款比例 */
	private BigDecimal prepaymentPercent;

	/** 履约保证金比例 */
	private BigDecimal creditDepositPercent;

	/** 质保金比例 */
	private BigDecimal qualityDepositPercent;

	/** 平台技术服务费 */
	private BigDecimal serviceFee;

	/** 服务商ID */
	private Long spId;

	/** 结算类型:1-实时结算 */
	private Integer balanceType;

	/** 审批状态:1-待审核;2-审核通过;3-审核不通过 */
	private Integer checkStatus;

	/** 状态:1-合作 */
	private Integer status;

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

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public Date getValidStartDate() {
		return validStartDate;
	}

	public void setValidStartDate(Date validStartDate) {
		this.validStartDate = validStartDate;
	}

	public Date getValidEndDate() {
		return validEndDate;
	}

	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public BigDecimal getCommissionPercent() {
		return commissionPercent;
	}

	public void setCommissionPercent(BigDecimal commissionPercent) {
		this.commissionPercent = commissionPercent;
	}

	public BigDecimal getPrepaymentPercent() {
		return prepaymentPercent;
	}

	public void setPrepaymentPercent(BigDecimal prepaymentPercent) {
		this.prepaymentPercent = prepaymentPercent;
	}

	public BigDecimal getCreditDepositPercent() {
		return creditDepositPercent;
	}

	public void setCreditDepositPercent(BigDecimal creditDepositPercent) {
		this.creditDepositPercent = creditDepositPercent;
	}

	public BigDecimal getQualityDepositPercent() {
		return qualityDepositPercent;
	}

	public void setQualityDepositPercent(BigDecimal qualityDepositPercent) {
		this.qualityDepositPercent = qualityDepositPercent;
	}

	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Long getSpId() {
		return spId;
	}

	public void setSpId(Long spId) {
		this.spId = spId;
	}

	public Integer getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(Integer balanceType) {
		this.balanceType = balanceType;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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