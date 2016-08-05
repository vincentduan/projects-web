package com.efubao.core.order.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BaseOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public BaseOrderExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdIsNull() {
            addCriterion("order_contract_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdIsNotNull() {
            addCriterion("order_contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdEqualTo(Long value) {
            addCriterion("order_contract_id =", value, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdNotEqualTo(Long value) {
            addCriterion("order_contract_id <>", value, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdGreaterThan(Long value) {
            addCriterion("order_contract_id >", value, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_contract_id >=", value, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdLessThan(Long value) {
            addCriterion("order_contract_id <", value, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdLessThanOrEqualTo(Long value) {
            addCriterion("order_contract_id <=", value, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdIn(List<Long> values) {
            addCriterion("order_contract_id in", values, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdNotIn(List<Long> values) {
            addCriterion("order_contract_id not in", values, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdBetween(Long value1, Long value2) {
            addCriterion("order_contract_id between", value1, value2, "orderContractId");
            return (Criteria) this;
        }

        public Criteria andOrderContractIdNotBetween(Long value1, Long value2) {
            addCriterion("order_contract_id not between", value1, value2, "orderContractId");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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