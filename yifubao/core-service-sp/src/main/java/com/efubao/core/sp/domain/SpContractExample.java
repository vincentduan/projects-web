package com.efubao.core.sp.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SpContractExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected int limitStart = -1;

	protected int limitEnd = -1;

	public SpContractExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	public int getLimitStart() {
		return limitStart;
	}

	public void setLimitEnd(int limitEnd) {
		this.limitEnd = limitEnd;
	}

	public int getLimitEnd() {
		return limitEnd;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andContractNameIsNull() {
			addCriterion("contract_name is null");
			return (Criteria) this;
		}

		public Criteria andContractNameIsNotNull() {
			addCriterion("contract_name is not null");
			return (Criteria) this;
		}

		public Criteria andContractNameEqualTo(String value) {
			addCriterion("contract_name =", value, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameNotEqualTo(String value) {
			addCriterion("contract_name <>", value, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameGreaterThan(String value) {
			addCriterion("contract_name >", value, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameGreaterThanOrEqualTo(String value) {
			addCriterion("contract_name >=", value, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameLessThan(String value) {
			addCriterion("contract_name <", value, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameLessThanOrEqualTo(String value) {
			addCriterion("contract_name <=", value, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameLike(String value) {
			addCriterion("contract_name like", value, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameNotLike(String value) {
			addCriterion("contract_name not like", value, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameIn(List<String> values) {
			addCriterion("contract_name in", values, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameNotIn(List<String> values) {
			addCriterion("contract_name not in", values, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameBetween(String value1, String value2) {
			addCriterion("contract_name between", value1, value2, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNameNotBetween(String value1, String value2) {
			addCriterion("contract_name not between", value1, value2, "contractName");
			return (Criteria) this;
		}

		public Criteria andContractNumIsNull() {
			addCriterion("contract_num is null");
			return (Criteria) this;
		}

		public Criteria andContractNumIsNotNull() {
			addCriterion("contract_num is not null");
			return (Criteria) this;
		}

		public Criteria andContractNumEqualTo(String value) {
			addCriterion("contract_num =", value, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumNotEqualTo(String value) {
			addCriterion("contract_num <>", value, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumGreaterThan(String value) {
			addCriterion("contract_num >", value, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumGreaterThanOrEqualTo(String value) {
			addCriterion("contract_num >=", value, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumLessThan(String value) {
			addCriterion("contract_num <", value, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumLessThanOrEqualTo(String value) {
			addCriterion("contract_num <=", value, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumLike(String value) {
			addCriterion("contract_num like", value, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumNotLike(String value) {
			addCriterion("contract_num not like", value, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumIn(List<String> values) {
			addCriterion("contract_num in", values, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumNotIn(List<String> values) {
			addCriterion("contract_num not in", values, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumBetween(String value1, String value2) {
			addCriterion("contract_num between", value1, value2, "contractNum");
			return (Criteria) this;
		}

		public Criteria andContractNumNotBetween(String value1, String value2) {
			addCriterion("contract_num not between", value1, value2, "contractNum");
			return (Criteria) this;
		}

		public Criteria andValidStartDateIsNull() {
			addCriterion("valid_start_date is null");
			return (Criteria) this;
		}

		public Criteria andValidStartDateIsNotNull() {
			addCriterion("valid_start_date is not null");
			return (Criteria) this;
		}

		public Criteria andValidStartDateEqualTo(Date value) {
			addCriterionForJDBCDate("valid_start_date =", value, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("valid_start_date <>", value, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateGreaterThan(Date value) {
			addCriterionForJDBCDate("valid_start_date >", value, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("valid_start_date >=", value, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateLessThan(Date value) {
			addCriterionForJDBCDate("valid_start_date <", value, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("valid_start_date <=", value, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateIn(List<Date> values) {
			addCriterionForJDBCDate("valid_start_date in", values, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("valid_start_date not in", values, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("valid_start_date between", value1, value2, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidStartDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("valid_start_date not between", value1, value2, "validStartDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateIsNull() {
			addCriterion("valid_end_date is null");
			return (Criteria) this;
		}

		public Criteria andValidEndDateIsNotNull() {
			addCriterion("valid_end_date is not null");
			return (Criteria) this;
		}

		public Criteria andValidEndDateEqualTo(Date value) {
			addCriterionForJDBCDate("valid_end_date =", value, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("valid_end_date <>", value, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateGreaterThan(Date value) {
			addCriterionForJDBCDate("valid_end_date >", value, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("valid_end_date >=", value, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateLessThan(Date value) {
			addCriterionForJDBCDate("valid_end_date <", value, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("valid_end_date <=", value, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateIn(List<Date> values) {
			addCriterionForJDBCDate("valid_end_date in", values, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("valid_end_date not in", values, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("valid_end_date between", value1, value2, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andValidEndDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("valid_end_date not between", value1, value2, "validEndDate");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIsNull() {
			addCriterion("invoice_type is null");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIsNotNull() {
			addCriterion("invoice_type is not null");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeEqualTo(String value) {
			addCriterion("invoice_type =", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotEqualTo(String value) {
			addCriterion("invoice_type <>", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeGreaterThan(String value) {
			addCriterion("invoice_type >", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
			addCriterion("invoice_type >=", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeLessThan(String value) {
			addCriterion("invoice_type <", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
			addCriterion("invoice_type <=", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeLike(String value) {
			addCriterion("invoice_type like", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotLike(String value) {
			addCriterion("invoice_type not like", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIn(List<String> values) {
			addCriterion("invoice_type in", values, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotIn(List<String> values) {
			addCriterion("invoice_type not in", values, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeBetween(String value1, String value2) {
			addCriterion("invoice_type between", value1, value2, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
			addCriterion("invoice_type not between", value1, value2, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentIsNull() {
			addCriterion("commission_percent is null");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentIsNotNull() {
			addCriterion("commission_percent is not null");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentEqualTo(BigDecimal value) {
			addCriterion("commission_percent =", value, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentNotEqualTo(BigDecimal value) {
			addCriterion("commission_percent <>", value, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentGreaterThan(BigDecimal value) {
			addCriterion("commission_percent >", value, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("commission_percent >=", value, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentLessThan(BigDecimal value) {
			addCriterion("commission_percent <", value, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("commission_percent <=", value, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentIn(List<BigDecimal> values) {
			addCriterion("commission_percent in", values, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentNotIn(List<BigDecimal> values) {
			addCriterion("commission_percent not in", values, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commission_percent between", value1, value2, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andCommissionPercentNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commission_percent not between", value1, value2, "commissionPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentIsNull() {
			addCriterion("prepayment_percent is null");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentIsNotNull() {
			addCriterion("prepayment_percent is not null");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentEqualTo(BigDecimal value) {
			addCriterion("prepayment_percent =", value, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentNotEqualTo(BigDecimal value) {
			addCriterion("prepayment_percent <>", value, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentGreaterThan(BigDecimal value) {
			addCriterion("prepayment_percent >", value, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("prepayment_percent >=", value, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentLessThan(BigDecimal value) {
			addCriterion("prepayment_percent <", value, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("prepayment_percent <=", value, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentIn(List<BigDecimal> values) {
			addCriterion("prepayment_percent in", values, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentNotIn(List<BigDecimal> values) {
			addCriterion("prepayment_percent not in", values, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("prepayment_percent between", value1, value2, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andPrepaymentPercentNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("prepayment_percent not between", value1, value2, "prepaymentPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentIsNull() {
			addCriterion("credit_deposit_percent is null");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentIsNotNull() {
			addCriterion("credit_deposit_percent is not null");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentEqualTo(BigDecimal value) {
			addCriterion("credit_deposit_percent =", value, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentNotEqualTo(BigDecimal value) {
			addCriterion("credit_deposit_percent <>", value, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentGreaterThan(BigDecimal value) {
			addCriterion("credit_deposit_percent >", value, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("credit_deposit_percent >=", value, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentLessThan(BigDecimal value) {
			addCriterion("credit_deposit_percent <", value, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("credit_deposit_percent <=", value, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentIn(List<BigDecimal> values) {
			addCriterion("credit_deposit_percent in", values, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentNotIn(List<BigDecimal> values) {
			addCriterion("credit_deposit_percent not in", values, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("credit_deposit_percent between", value1, value2, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andCreditDepositPercentNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("credit_deposit_percent not between", value1, value2, "creditDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentIsNull() {
			addCriterion("quality_deposit_percent is null");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentIsNotNull() {
			addCriterion("quality_deposit_percent is not null");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentEqualTo(BigDecimal value) {
			addCriterion("quality_deposit_percent =", value, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentNotEqualTo(BigDecimal value) {
			addCriterion("quality_deposit_percent <>", value, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentGreaterThan(BigDecimal value) {
			addCriterion("quality_deposit_percent >", value, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("quality_deposit_percent >=", value, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentLessThan(BigDecimal value) {
			addCriterion("quality_deposit_percent <", value, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("quality_deposit_percent <=", value, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentIn(List<BigDecimal> values) {
			addCriterion("quality_deposit_percent in", values, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentNotIn(List<BigDecimal> values) {
			addCriterion("quality_deposit_percent not in", values, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("quality_deposit_percent between", value1, value2, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andQualityDepositPercentNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("quality_deposit_percent not between", value1, value2, "qualityDepositPercent");
			return (Criteria) this;
		}

		public Criteria andServiceFeeIsNull() {
			addCriterion("service_fee is null");
			return (Criteria) this;
		}

		public Criteria andServiceFeeIsNotNull() {
			addCriterion("service_fee is not null");
			return (Criteria) this;
		}

		public Criteria andServiceFeeEqualTo(BigDecimal value) {
			addCriterion("service_fee =", value, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
			addCriterion("service_fee <>", value, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeGreaterThan(BigDecimal value) {
			addCriterion("service_fee >", value, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("service_fee >=", value, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeLessThan(BigDecimal value) {
			addCriterion("service_fee <", value, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("service_fee <=", value, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeIn(List<BigDecimal> values) {
			addCriterion("service_fee in", values, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
			addCriterion("service_fee not in", values, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("service_fee between", value1, value2, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("service_fee not between", value1, value2, "serviceFee");
			return (Criteria) this;
		}

		public Criteria andSpIdIsNull() {
			addCriterion("sp_id is null");
			return (Criteria) this;
		}

		public Criteria andSpIdIsNotNull() {
			addCriterion("sp_id is not null");
			return (Criteria) this;
		}

		public Criteria andSpIdEqualTo(Long value) {
			addCriterion("sp_id =", value, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdNotEqualTo(Long value) {
			addCriterion("sp_id <>", value, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdGreaterThan(Long value) {
			addCriterion("sp_id >", value, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdGreaterThanOrEqualTo(Long value) {
			addCriterion("sp_id >=", value, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdLessThan(Long value) {
			addCriterion("sp_id <", value, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdLessThanOrEqualTo(Long value) {
			addCriterion("sp_id <=", value, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdIn(List<Long> values) {
			addCriterion("sp_id in", values, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdNotIn(List<Long> values) {
			addCriterion("sp_id not in", values, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdBetween(Long value1, Long value2) {
			addCriterion("sp_id between", value1, value2, "spId");
			return (Criteria) this;
		}

		public Criteria andSpIdNotBetween(Long value1, Long value2) {
			addCriterion("sp_id not between", value1, value2, "spId");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeIsNull() {
			addCriterion("balance_type is null");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeIsNotNull() {
			addCriterion("balance_type is not null");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeEqualTo(Integer value) {
			addCriterion("balance_type =", value, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeNotEqualTo(Integer value) {
			addCriterion("balance_type <>", value, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeGreaterThan(Integer value) {
			addCriterion("balance_type >", value, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("balance_type >=", value, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeLessThan(Integer value) {
			addCriterion("balance_type <", value, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeLessThanOrEqualTo(Integer value) {
			addCriterion("balance_type <=", value, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeIn(List<Integer> values) {
			addCriterion("balance_type in", values, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeNotIn(List<Integer> values) {
			addCriterion("balance_type not in", values, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeBetween(Integer value1, Integer value2) {
			addCriterion("balance_type between", value1, value2, "balanceType");
			return (Criteria) this;
		}

		public Criteria andBalanceTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("balance_type not between", value1, value2, "balanceType");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIsNull() {
			addCriterion("check_status is null");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIsNotNull() {
			addCriterion("check_status is not null");
			return (Criteria) this;
		}

		public Criteria andCheckStatusEqualTo(Integer value) {
			addCriterion("check_status =", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotEqualTo(Integer value) {
			addCriterion("check_status <>", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusGreaterThan(Integer value) {
			addCriterion("check_status >", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("check_status >=", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusLessThan(Integer value) {
			addCriterion("check_status <", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
			addCriterion("check_status <=", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIn(List<Integer> values) {
			addCriterion("check_status in", values, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotIn(List<Integer> values) {
			addCriterion("check_status not in", values, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
			addCriterion("check_status between", value1, value2, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("check_status not between", value1, value2, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Timestamp value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Timestamp value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Timestamp value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Timestamp value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Timestamp> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Timestamp> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Timestamp value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Timestamp value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Timestamp value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Timestamp> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNull() {
			addCriterion("is_del is null");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNotNull() {
			addCriterion("is_del is not null");
			return (Criteria) this;
		}

		public Criteria andIsDelEqualTo(Boolean value) {
			addCriterion("is_del =", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotEqualTo(Boolean value) {
			addCriterion("is_del <>", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThan(Boolean value) {
			addCriterion("is_del >", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_del >=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThan(Boolean value) {
			addCriterion("is_del <", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThanOrEqualTo(Boolean value) {
			addCriterion("is_del <=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelIn(List<Boolean> values) {
			addCriterion("is_del in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotIn(List<Boolean> values) {
			addCriterion("is_del not in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelBetween(Boolean value1, Boolean value2) {
			addCriterion("is_del between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_del not between", value1, value2, "isDel");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}