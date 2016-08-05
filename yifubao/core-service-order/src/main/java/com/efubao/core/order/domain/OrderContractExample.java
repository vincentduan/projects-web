package com.efubao.core.order.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public OrderContractExample() {
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
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
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

        public Criteria andMakeDaysIsNull() {
            addCriterion("make_days is null");
            return (Criteria) this;
        }

        public Criteria andMakeDaysIsNotNull() {
            addCriterion("make_days is not null");
            return (Criteria) this;
        }

        public Criteria andMakeDaysEqualTo(Integer value) {
            addCriterion("make_days =", value, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysNotEqualTo(Integer value) {
            addCriterion("make_days <>", value, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysGreaterThan(Integer value) {
            addCriterion("make_days >", value, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("make_days >=", value, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysLessThan(Integer value) {
            addCriterion("make_days <", value, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysLessThanOrEqualTo(Integer value) {
            addCriterion("make_days <=", value, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysIn(List<Integer> values) {
            addCriterion("make_days in", values, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysNotIn(List<Integer> values) {
            addCriterion("make_days not in", values, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysBetween(Integer value1, Integer value2) {
            addCriterion("make_days between", value1, value2, "makeDays");
            return (Criteria) this;
        }

        public Criteria andMakeDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("make_days not between", value1, value2, "makeDays");
            return (Criteria) this;
        }

        public Criteria andCustomCycleIsNull() {
            addCriterion("custom_cycle is null");
            return (Criteria) this;
        }

        public Criteria andCustomCycleIsNotNull() {
            addCriterion("custom_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andCustomCycleEqualTo(Integer value) {
            addCriterion("custom_cycle =", value, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleNotEqualTo(Integer value) {
            addCriterion("custom_cycle <>", value, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleGreaterThan(Integer value) {
            addCriterion("custom_cycle >", value, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("custom_cycle >=", value, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleLessThan(Integer value) {
            addCriterion("custom_cycle <", value, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleLessThanOrEqualTo(Integer value) {
            addCriterion("custom_cycle <=", value, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleIn(List<Integer> values) {
            addCriterion("custom_cycle in", values, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleNotIn(List<Integer> values) {
            addCriterion("custom_cycle not in", values, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleBetween(Integer value1, Integer value2) {
            addCriterion("custom_cycle between", value1, value2, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("custom_cycle not between", value1, value2, "customCycle");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyIsNull() {
            addCriterion("custom_money is null");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyIsNotNull() {
            addCriterion("custom_money is not null");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyEqualTo(Short value) {
            addCriterion("custom_money =", value, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyNotEqualTo(Short value) {
            addCriterion("custom_money <>", value, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyGreaterThan(Short value) {
            addCriterion("custom_money >", value, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyGreaterThanOrEqualTo(Short value) {
            addCriterion("custom_money >=", value, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyLessThan(Short value) {
            addCriterion("custom_money <", value, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyLessThanOrEqualTo(Short value) {
            addCriterion("custom_money <=", value, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyIn(List<Short> values) {
            addCriterion("custom_money in", values, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyNotIn(List<Short> values) {
            addCriterion("custom_money not in", values, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyBetween(Short value1, Short value2) {
            addCriterion("custom_money between", value1, value2, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomMoneyNotBetween(Short value1, Short value2) {
            addCriterion("custom_money not between", value1, value2, "customMoney");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIsNull() {
            addCriterion("custom_category is null");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIsNotNull() {
            addCriterion("custom_category is not null");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryEqualTo(String value) {
            addCriterion("custom_category =", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryNotEqualTo(String value) {
            addCriterion("custom_category <>", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryGreaterThan(String value) {
            addCriterion("custom_category >", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("custom_category >=", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryLessThan(String value) {
            addCriterion("custom_category <", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryLessThanOrEqualTo(String value) {
            addCriterion("custom_category <=", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryLike(String value) {
            addCriterion("custom_category like", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryNotLike(String value) {
            addCriterion("custom_category not like", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIn(List<String> values) {
            addCriterion("custom_category in", values, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryNotIn(List<String> values) {
            addCriterion("custom_category not in", values, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryBetween(String value1, String value2) {
            addCriterion("custom_category between", value1, value2, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryNotBetween(String value1, String value2) {
            addCriterion("custom_category not between", value1, value2, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyIsNull() {
            addCriterion("custom_property is null");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyIsNotNull() {
            addCriterion("custom_property is not null");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyEqualTo(String value) {
            addCriterion("custom_property =", value, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyNotEqualTo(String value) {
            addCriterion("custom_property <>", value, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyGreaterThan(String value) {
            addCriterion("custom_property >", value, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("custom_property >=", value, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyLessThan(String value) {
            addCriterion("custom_property <", value, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyLessThanOrEqualTo(String value) {
            addCriterion("custom_property <=", value, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyLike(String value) {
            addCriterion("custom_property like", value, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyNotLike(String value) {
            addCriterion("custom_property not like", value, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyIn(List<String> values) {
            addCriterion("custom_property in", values, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyNotIn(List<String> values) {
            addCriterion("custom_property not in", values, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyBetween(String value1, String value2) {
            addCriterion("custom_property between", value1, value2, "customProperty");
            return (Criteria) this;
        }

        public Criteria andCustomPropertyNotBetween(String value1, String value2) {
            addCriterion("custom_property not between", value1, value2, "customProperty");
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
            addCriterion("valid_start_date =", value, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateNotEqualTo(Date value) {
            addCriterion("valid_start_date <>", value, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateGreaterThan(Date value) {
            addCriterion("valid_start_date >", value, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_start_date >=", value, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateLessThan(Date value) {
            addCriterion("valid_start_date <", value, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateLessThanOrEqualTo(Date value) {
            addCriterion("valid_start_date <=", value, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateIn(List<Date> values) {
            addCriterion("valid_start_date in", values, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateNotIn(List<Date> values) {
            addCriterion("valid_start_date not in", values, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateBetween(Date value1, Date value2) {
            addCriterion("valid_start_date between", value1, value2, "validStartDate");
            return (Criteria) this;
        }

        public Criteria andValidStartDateNotBetween(Date value1, Date value2) {
            addCriterion("valid_start_date not between", value1, value2, "validStartDate");
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
            addCriterion("valid_end_date =", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateNotEqualTo(Date value) {
            addCriterion("valid_end_date <>", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateGreaterThan(Date value) {
            addCriterion("valid_end_date >", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_end_date >=", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateLessThan(Date value) {
            addCriterion("valid_end_date <", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateLessThanOrEqualTo(Date value) {
            addCriterion("valid_end_date <=", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateIn(List<Date> values) {
            addCriterion("valid_end_date in", values, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateNotIn(List<Date> values) {
            addCriterion("valid_end_date not in", values, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateBetween(Date value1, Date value2) {
            addCriterion("valid_end_date between", value1, value2, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateNotBetween(Date value1, Date value2) {
            addCriterion("valid_end_date not between", value1, value2, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyIsNull() {
            addCriterion("front_money is null");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyIsNotNull() {
            addCriterion("front_money is not null");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyEqualTo(BigDecimal value) {
            addCriterion("front_money =", value, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyNotEqualTo(BigDecimal value) {
            addCriterion("front_money <>", value, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyGreaterThan(BigDecimal value) {
            addCriterion("front_money >", value, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("front_money >=", value, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyLessThan(BigDecimal value) {
            addCriterion("front_money <", value, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("front_money <=", value, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyIn(List<BigDecimal> values) {
            addCriterion("front_money in", values, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyNotIn(List<BigDecimal> values) {
            addCriterion("front_money not in", values, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("front_money between", value1, value2, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andFrontMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("front_money not between", value1, value2, "frontMoney");
            return (Criteria) this;
        }

        public Criteria andQualityDepositIsNull() {
            addCriterion("quality_deposit is null");
            return (Criteria) this;
        }

        public Criteria andQualityDepositIsNotNull() {
            addCriterion("quality_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andQualityDepositEqualTo(BigDecimal value) {
            addCriterion("quality_deposit =", value, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositNotEqualTo(BigDecimal value) {
            addCriterion("quality_deposit <>", value, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositGreaterThan(BigDecimal value) {
            addCriterion("quality_deposit >", value, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("quality_deposit >=", value, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositLessThan(BigDecimal value) {
            addCriterion("quality_deposit <", value, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("quality_deposit <=", value, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositIn(List<BigDecimal> values) {
            addCriterion("quality_deposit in", values, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositNotIn(List<BigDecimal> values) {
            addCriterion("quality_deposit not in", values, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quality_deposit between", value1, value2, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andQualityDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quality_deposit not between", value1, value2, "qualityDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositIsNull() {
            addCriterion("credit_deposit is null");
            return (Criteria) this;
        }

        public Criteria andCreditDepositIsNotNull() {
            addCriterion("credit_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditDepositEqualTo(BigDecimal value) {
            addCriterion("credit_deposit =", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositNotEqualTo(BigDecimal value) {
            addCriterion("credit_deposit <>", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositGreaterThan(BigDecimal value) {
            addCriterion("credit_deposit >", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_deposit >=", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositLessThan(BigDecimal value) {
            addCriterion("credit_deposit <", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_deposit <=", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositIn(List<BigDecimal> values) {
            addCriterion("credit_deposit in", values, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositNotIn(List<BigDecimal> values) {
            addCriterion("credit_deposit not in", values, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_deposit between", value1, value2, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_deposit not between", value1, value2, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentIsNull() {
            addCriterion("balance_payment is null");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentIsNotNull() {
            addCriterion("balance_payment is not null");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentEqualTo(BigDecimal value) {
            addCriterion("balance_payment =", value, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentNotEqualTo(BigDecimal value) {
            addCriterion("balance_payment <>", value, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentGreaterThan(BigDecimal value) {
            addCriterion("balance_payment >", value, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_payment >=", value, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentLessThan(BigDecimal value) {
            addCriterion("balance_payment <", value, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_payment <=", value, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentIn(List<BigDecimal> values) {
            addCriterion("balance_payment in", values, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentNotIn(List<BigDecimal> values) {
            addCriterion("balance_payment not in", values, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_payment between", value1, value2, "balancePayment");
            return (Criteria) this;
        }

        public Criteria andBalancePaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_payment not between", value1, value2, "balancePayment");
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

        public Criteria andIsCustomerAgreeIsNull() {
            addCriterion("is_customer_agree is null");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeIsNotNull() {
            addCriterion("is_customer_agree is not null");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeEqualTo(Boolean value) {
            addCriterion("is_customer_agree =", value, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeNotEqualTo(Boolean value) {
            addCriterion("is_customer_agree <>", value, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeGreaterThan(Boolean value) {
            addCriterion("is_customer_agree >", value, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_customer_agree >=", value, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeLessThan(Boolean value) {
            addCriterion("is_customer_agree <", value, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_customer_agree <=", value, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeIn(List<Boolean> values) {
            addCriterion("is_customer_agree in", values, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeNotIn(List<Boolean> values) {
            addCriterion("is_customer_agree not in", values, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_customer_agree between", value1, value2, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andIsCustomerAgreeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_customer_agree not between", value1, value2, "isCustomerAgree");
            return (Criteria) this;
        }

        public Criteria andMeasureNumIsNull() {
            addCriterion("measure_num is null");
            return (Criteria) this;
        }

        public Criteria andMeasureNumIsNotNull() {
            addCriterion("measure_num is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureNumEqualTo(Integer value) {
            addCriterion("measure_num =", value, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumNotEqualTo(Integer value) {
            addCriterion("measure_num <>", value, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumGreaterThan(Integer value) {
            addCriterion("measure_num >", value, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("measure_num >=", value, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumLessThan(Integer value) {
            addCriterion("measure_num <", value, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumLessThanOrEqualTo(Integer value) {
            addCriterion("measure_num <=", value, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumIn(List<Integer> values) {
            addCriterion("measure_num in", values, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumNotIn(List<Integer> values) {
            addCriterion("measure_num not in", values, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumBetween(Integer value1, Integer value2) {
            addCriterion("measure_num between", value1, value2, "measureNum");
            return (Criteria) this;
        }

        public Criteria andMeasureNumNotBetween(Integer value1, Integer value2) {
            addCriterion("measure_num not between", value1, value2, "measureNum");
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