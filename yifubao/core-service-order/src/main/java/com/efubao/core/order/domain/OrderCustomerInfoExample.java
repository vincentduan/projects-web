package com.efubao.core.order.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderCustomerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public OrderCustomerInfoExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentIsNull() {
            addCriterion("custom_department is null");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentIsNotNull() {
            addCriterion("custom_department is not null");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentEqualTo(String value) {
            addCriterion("custom_department =", value, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentNotEqualTo(String value) {
            addCriterion("custom_department <>", value, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentGreaterThan(String value) {
            addCriterion("custom_department >", value, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("custom_department >=", value, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentLessThan(String value) {
            addCriterion("custom_department <", value, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentLessThanOrEqualTo(String value) {
            addCriterion("custom_department <=", value, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentLike(String value) {
            addCriterion("custom_department like", value, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentNotLike(String value) {
            addCriterion("custom_department not like", value, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentIn(List<String> values) {
            addCriterion("custom_department in", values, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentNotIn(List<String> values) {
            addCriterion("custom_department not in", values, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentBetween(String value1, String value2) {
            addCriterion("custom_department between", value1, value2, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andCustomDepartmentNotBetween(String value1, String value2) {
            addCriterion("custom_department not between", value1, value2, "customDepartment");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdIsNull() {
            addCriterion("receive_address_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdIsNotNull() {
            addCriterion("receive_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdEqualTo(Long value) {
            addCriterion("receive_address_id =", value, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdNotEqualTo(Long value) {
            addCriterion("receive_address_id <>", value, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdGreaterThan(Long value) {
            addCriterion("receive_address_id >", value, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_address_id >=", value, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdLessThan(Long value) {
            addCriterion("receive_address_id <", value, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdLessThanOrEqualTo(Long value) {
            addCriterion("receive_address_id <=", value, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdIn(List<Long> values) {
            addCriterion("receive_address_id in", values, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdNotIn(List<Long> values) {
            addCriterion("receive_address_id not in", values, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdBetween(Long value1, Long value2) {
            addCriterion("receive_address_id between", value1, value2, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIdNotBetween(Long value1, Long value2) {
            addCriterion("receive_address_id not between", value1, value2, "receiveAddressId");
            return (Criteria) this;
        }

        public Criteria andBespeakNameIsNull() {
            addCriterion("bespeak_name is null");
            return (Criteria) this;
        }

        public Criteria andBespeakNameIsNotNull() {
            addCriterion("bespeak_name is not null");
            return (Criteria) this;
        }

        public Criteria andBespeakNameEqualTo(String value) {
            addCriterion("bespeak_name =", value, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameNotEqualTo(String value) {
            addCriterion("bespeak_name <>", value, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameGreaterThan(String value) {
            addCriterion("bespeak_name >", value, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameGreaterThanOrEqualTo(String value) {
            addCriterion("bespeak_name >=", value, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameLessThan(String value) {
            addCriterion("bespeak_name <", value, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameLessThanOrEqualTo(String value) {
            addCriterion("bespeak_name <=", value, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameLike(String value) {
            addCriterion("bespeak_name like", value, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameNotLike(String value) {
            addCriterion("bespeak_name not like", value, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameIn(List<String> values) {
            addCriterion("bespeak_name in", values, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameNotIn(List<String> values) {
            addCriterion("bespeak_name not in", values, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameBetween(String value1, String value2) {
            addCriterion("bespeak_name between", value1, value2, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakNameNotBetween(String value1, String value2) {
            addCriterion("bespeak_name not between", value1, value2, "bespeakName");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneIsNull() {
            addCriterion("bespeak_phone is null");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneIsNotNull() {
            addCriterion("bespeak_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneEqualTo(String value) {
            addCriterion("bespeak_phone =", value, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneNotEqualTo(String value) {
            addCriterion("bespeak_phone <>", value, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneGreaterThan(String value) {
            addCriterion("bespeak_phone >", value, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("bespeak_phone >=", value, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneLessThan(String value) {
            addCriterion("bespeak_phone <", value, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneLessThanOrEqualTo(String value) {
            addCriterion("bespeak_phone <=", value, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneLike(String value) {
            addCriterion("bespeak_phone like", value, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneNotLike(String value) {
            addCriterion("bespeak_phone not like", value, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneIn(List<String> values) {
            addCriterion("bespeak_phone in", values, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneNotIn(List<String> values) {
            addCriterion("bespeak_phone not in", values, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneBetween(String value1, String value2) {
            addCriterion("bespeak_phone between", value1, value2, "bespeakPhone");
            return (Criteria) this;
        }

        public Criteria andBespeakPhoneNotBetween(String value1, String value2) {
            addCriterion("bespeak_phone not between", value1, value2, "bespeakPhone");
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