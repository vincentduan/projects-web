package com.efubao.core.order.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderCustomDemandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public OrderCustomDemandExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCustomNumIsNull() {
            addCriterion("custom_num is null");
            return (Criteria) this;
        }

        public Criteria andCustomNumIsNotNull() {
            addCriterion("custom_num is not null");
            return (Criteria) this;
        }

        public Criteria andCustomNumEqualTo(Integer value) {
            addCriterion("custom_num =", value, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumNotEqualTo(Integer value) {
            addCriterion("custom_num <>", value, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumGreaterThan(Integer value) {
            addCriterion("custom_num >", value, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("custom_num >=", value, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumLessThan(Integer value) {
            addCriterion("custom_num <", value, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumLessThanOrEqualTo(Integer value) {
            addCriterion("custom_num <=", value, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumIn(List<Integer> values) {
            addCriterion("custom_num in", values, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumNotIn(List<Integer> values) {
            addCriterion("custom_num not in", values, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumBetween(Integer value1, Integer value2) {
            addCriterion("custom_num between", value1, value2, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomNumNotBetween(Integer value1, Integer value2) {
            addCriterion("custom_num not between", value1, value2, "customNum");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetIsNull() {
            addCriterion("custom_budget is null");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetIsNotNull() {
            addCriterion("custom_budget is not null");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetEqualTo(BigDecimal value) {
            addCriterion("custom_budget =", value, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetNotEqualTo(BigDecimal value) {
            addCriterion("custom_budget <>", value, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetGreaterThan(BigDecimal value) {
            addCriterion("custom_budget >", value, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("custom_budget >=", value, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetLessThan(BigDecimal value) {
            addCriterion("custom_budget <", value, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("custom_budget <=", value, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetIn(List<BigDecimal> values) {
            addCriterion("custom_budget in", values, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetNotIn(List<BigDecimal> values) {
            addCriterion("custom_budget not in", values, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("custom_budget between", value1, value2, "customBudget");
            return (Criteria) this;
        }

        public Criteria andCustomBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("custom_budget not between", value1, value2, "customBudget");
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

        public Criteria andCategoryPropertyIsNull() {
            addCriterion("category_property is null");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIsNotNull() {
            addCriterion("category_property is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyEqualTo(String value) {
            addCriterion("category_property =", value, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyNotEqualTo(String value) {
            addCriterion("category_property <>", value, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyGreaterThan(String value) {
            addCriterion("category_property >", value, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("category_property >=", value, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyLessThan(String value) {
            addCriterion("category_property <", value, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyLessThanOrEqualTo(String value) {
            addCriterion("category_property <=", value, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyLike(String value) {
            addCriterion("category_property like", value, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyNotLike(String value) {
            addCriterion("category_property not like", value, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIn(List<String> values) {
            addCriterion("category_property in", values, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyNotIn(List<String> values) {
            addCriterion("category_property not in", values, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyBetween(String value1, String value2) {
            addCriterion("category_property between", value1, value2, "categoryProperty");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyNotBetween(String value1, String value2) {
            addCriterion("category_property not between", value1, value2, "categoryProperty");
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

        public Criteria andCustomTypeIsNull() {
            addCriterion("custom_type is null");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIsNotNull() {
            addCriterion("custom_type is not null");
            return (Criteria) this;
        }

        public Criteria andCustomTypeEqualTo(Integer value) {
            addCriterion("custom_type =", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotEqualTo(Integer value) {
            addCriterion("custom_type <>", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeGreaterThan(Integer value) {
            addCriterion("custom_type >", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("custom_type >=", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLessThan(Integer value) {
            addCriterion("custom_type <", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLessThanOrEqualTo(Integer value) {
            addCriterion("custom_type <=", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIn(List<Integer> values) {
            addCriterion("custom_type in", values, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotIn(List<Integer> values) {
            addCriterion("custom_type not in", values, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeBetween(Integer value1, Integer value2) {
            addCriterion("custom_type between", value1, value2, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("custom_type not between", value1, value2, "customType");
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