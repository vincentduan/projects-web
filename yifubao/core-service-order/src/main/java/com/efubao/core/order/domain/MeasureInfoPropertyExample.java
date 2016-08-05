package com.efubao.core.order.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MeasureInfoPropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public MeasureInfoPropertyExample() {
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

        public Criteria andMeasureInfoIdIsNull() {
            addCriterion("measure_info_id is null");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdIsNotNull() {
            addCriterion("measure_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdEqualTo(Long value) {
            addCriterion("measure_info_id =", value, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdNotEqualTo(Long value) {
            addCriterion("measure_info_id <>", value, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdGreaterThan(Long value) {
            addCriterion("measure_info_id >", value, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("measure_info_id >=", value, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdLessThan(Long value) {
            addCriterion("measure_info_id <", value, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("measure_info_id <=", value, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdIn(List<Long> values) {
            addCriterion("measure_info_id in", values, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdNotIn(List<Long> values) {
            addCriterion("measure_info_id not in", values, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdBetween(Long value1, Long value2) {
            addCriterion("measure_info_id between", value1, value2, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasureInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("measure_info_id not between", value1, value2, "measureInfoId");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyIsNull() {
            addCriterion("measure_property is null");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyIsNotNull() {
            addCriterion("measure_property is not null");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyEqualTo(String value) {
            addCriterion("measure_property =", value, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyNotEqualTo(String value) {
            addCriterion("measure_property <>", value, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyGreaterThan(String value) {
            addCriterion("measure_property >", value, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyGreaterThanOrEqualTo(String value) {
            addCriterion("measure_property >=", value, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyLessThan(String value) {
            addCriterion("measure_property <", value, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyLessThanOrEqualTo(String value) {
            addCriterion("measure_property <=", value, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyLike(String value) {
            addCriterion("measure_property like", value, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyNotLike(String value) {
            addCriterion("measure_property not like", value, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyIn(List<String> values) {
            addCriterion("measure_property in", values, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyNotIn(List<String> values) {
            addCriterion("measure_property not in", values, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyBetween(String value1, String value2) {
            addCriterion("measure_property between", value1, value2, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyNotBetween(String value1, String value2) {
            addCriterion("measure_property not between", value1, value2, "measureProperty");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueIsNull() {
            addCriterion("measure_property_value is null");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueIsNotNull() {
            addCriterion("measure_property_value is not null");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueEqualTo(String value) {
            addCriterion("measure_property_value =", value, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueNotEqualTo(String value) {
            addCriterion("measure_property_value <>", value, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueGreaterThan(String value) {
            addCriterion("measure_property_value >", value, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueGreaterThanOrEqualTo(String value) {
            addCriterion("measure_property_value >=", value, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueLessThan(String value) {
            addCriterion("measure_property_value <", value, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueLessThanOrEqualTo(String value) {
            addCriterion("measure_property_value <=", value, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueLike(String value) {
            addCriterion("measure_property_value like", value, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueNotLike(String value) {
            addCriterion("measure_property_value not like", value, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueIn(List<String> values) {
            addCriterion("measure_property_value in", values, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueNotIn(List<String> values) {
            addCriterion("measure_property_value not in", values, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueBetween(String value1, String value2) {
            addCriterion("measure_property_value between", value1, value2, "measurePropertyValue");
            return (Criteria) this;
        }

        public Criteria andMeasurePropertyValueNotBetween(String value1, String value2) {
            addCriterion("measure_property_value not between", value1, value2, "measurePropertyValue");
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