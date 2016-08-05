package com.efubao.core.sp.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ServiceProviderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ServiceProviderExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andShortnameIsNull() {
            addCriterion("shortname is null");
            return (Criteria) this;
        }

        public Criteria andShortnameIsNotNull() {
            addCriterion("shortname is not null");
            return (Criteria) this;
        }

        public Criteria andShortnameEqualTo(String value) {
            addCriterion("shortname =", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotEqualTo(String value) {
            addCriterion("shortname <>", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameGreaterThan(String value) {
            addCriterion("shortname >", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameGreaterThanOrEqualTo(String value) {
            addCriterion("shortname >=", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLessThan(String value) {
            addCriterion("shortname <", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLessThanOrEqualTo(String value) {
            addCriterion("shortname <=", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLike(String value) {
            addCriterion("shortname like", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotLike(String value) {
            addCriterion("shortname not like", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameIn(List<String> values) {
            addCriterion("shortname in", values, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotIn(List<String> values) {
            addCriterion("shortname not in", values, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameBetween(String value1, String value2) {
            addCriterion("shortname between", value1, value2, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotBetween(String value1, String value2) {
            addCriterion("shortname not between", value1, value2, "shortname");
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

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrIsNull() {
            addCriterion("registered_addr is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrIsNotNull() {
            addCriterion("registered_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrEqualTo(String value) {
            addCriterion("registered_addr =", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrNotEqualTo(String value) {
            addCriterion("registered_addr <>", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrGreaterThan(String value) {
            addCriterion("registered_addr >", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrGreaterThanOrEqualTo(String value) {
            addCriterion("registered_addr >=", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrLessThan(String value) {
            addCriterion("registered_addr <", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrLessThanOrEqualTo(String value) {
            addCriterion("registered_addr <=", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrLike(String value) {
            addCriterion("registered_addr like", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrNotLike(String value) {
            addCriterion("registered_addr not like", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrIn(List<String> values) {
            addCriterion("registered_addr in", values, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrNotIn(List<String> values) {
            addCriterion("registered_addr not in", values, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrBetween(String value1, String value2) {
            addCriterion("registered_addr between", value1, value2, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrNotBetween(String value1, String value2) {
            addCriterion("registered_addr not between", value1, value2, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIsNull() {
            addCriterion("registered_capital is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIsNotNull() {
            addCriterion("registered_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalEqualTo(Long value) {
            addCriterion("registered_capital =", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotEqualTo(Long value) {
            addCriterion("registered_capital <>", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalGreaterThan(Long value) {
            addCriterion("registered_capital >", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalGreaterThanOrEqualTo(Long value) {
            addCriterion("registered_capital >=", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalLessThan(Long value) {
            addCriterion("registered_capital <", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalLessThanOrEqualTo(Long value) {
            addCriterion("registered_capital <=", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIn(List<Long> values) {
            addCriterion("registered_capital in", values, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotIn(List<Long> values) {
            addCriterion("registered_capital not in", values, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalBetween(Long value1, Long value2) {
            addCriterion("registered_capital between", value1, value2, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotBetween(Long value1, Long value2) {
            addCriterion("registered_capital not between", value1, value2, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoIsNull() {
            addCriterion("business_licence_no is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoIsNotNull() {
            addCriterion("business_licence_no is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoEqualTo(String value) {
            addCriterion("business_licence_no =", value, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoNotEqualTo(String value) {
            addCriterion("business_licence_no <>", value, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoGreaterThan(String value) {
            addCriterion("business_licence_no >", value, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoGreaterThanOrEqualTo(String value) {
            addCriterion("business_licence_no >=", value, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoLessThan(String value) {
            addCriterion("business_licence_no <", value, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoLessThanOrEqualTo(String value) {
            addCriterion("business_licence_no <=", value, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoLike(String value) {
            addCriterion("business_licence_no like", value, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoNotLike(String value) {
            addCriterion("business_licence_no not like", value, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoIn(List<String> values) {
            addCriterion("business_licence_no in", values, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoNotIn(List<String> values) {
            addCriterion("business_licence_no not in", values, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoBetween(String value1, String value2) {
            addCriterion("business_licence_no between", value1, value2, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenceNoNotBetween(String value1, String value2) {
            addCriterion("business_licence_no not between", value1, value2, "businessLicenceNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoIsNull() {
            addCriterion("tax_registration_no is null");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoIsNotNull() {
            addCriterion("tax_registration_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoEqualTo(String value) {
            addCriterion("tax_registration_no =", value, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoNotEqualTo(String value) {
            addCriterion("tax_registration_no <>", value, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoGreaterThan(String value) {
            addCriterion("tax_registration_no >", value, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoGreaterThanOrEqualTo(String value) {
            addCriterion("tax_registration_no >=", value, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoLessThan(String value) {
            addCriterion("tax_registration_no <", value, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoLessThanOrEqualTo(String value) {
            addCriterion("tax_registration_no <=", value, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoLike(String value) {
            addCriterion("tax_registration_no like", value, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoNotLike(String value) {
            addCriterion("tax_registration_no not like", value, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoIn(List<String> values) {
            addCriterion("tax_registration_no in", values, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoNotIn(List<String> values) {
            addCriterion("tax_registration_no not in", values, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoBetween(String value1, String value2) {
            addCriterion("tax_registration_no between", value1, value2, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNoNotBetween(String value1, String value2) {
            addCriterion("tax_registration_no not between", value1, value2, "taxRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("org_code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("org_code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateIsNull() {
            addCriterion("business_start_date is null");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateIsNotNull() {
            addCriterion("business_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("business_start_date =", value, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("business_start_date <>", value, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("business_start_date >", value, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("business_start_date >=", value, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateLessThan(Date value) {
            addCriterionForJDBCDate("business_start_date <", value, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("business_start_date <=", value, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("business_start_date in", values, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("business_start_date not in", values, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("business_start_date between", value1, value2, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("business_start_date not between", value1, value2, "businessStartDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateIsNull() {
            addCriterion("business_end_date is null");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateIsNotNull() {
            addCriterion("business_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("business_end_date =", value, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("business_end_date <>", value, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("business_end_date >", value, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("business_end_date >=", value, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateLessThan(Date value) {
            addCriterionForJDBCDate("business_end_date <", value, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("business_end_date <=", value, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("business_end_date in", values, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("business_end_date not in", values, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("business_end_date between", value1, value2, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("business_end_date not between", value1, value2, "businessEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeIsNull() {
            addCriterion("business_range is null");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeIsNotNull() {
            addCriterion("business_range is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeEqualTo(String value) {
            addCriterion("business_range =", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeNotEqualTo(String value) {
            addCriterion("business_range <>", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeGreaterThan(String value) {
            addCriterion("business_range >", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeGreaterThanOrEqualTo(String value) {
            addCriterion("business_range >=", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeLessThan(String value) {
            addCriterion("business_range <", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeLessThanOrEqualTo(String value) {
            addCriterion("business_range <=", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeLike(String value) {
            addCriterion("business_range like", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeNotLike(String value) {
            addCriterion("business_range not like", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeIn(List<String> values) {
            addCriterion("business_range in", values, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeNotIn(List<String> values) {
            addCriterion("business_range not in", values, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeBetween(String value1, String value2) {
            addCriterion("business_range between", value1, value2, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeNotBetween(String value1, String value2) {
            addCriterion("business_range not between", value1, value2, "businessRange");
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

        public Criteria andLogoImagePathIsNull() {
            addCriterion("logo_image_path is null");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathIsNotNull() {
            addCriterion("logo_image_path is not null");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathEqualTo(String value) {
            addCriterion("logo_image_path =", value, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathNotEqualTo(String value) {
            addCriterion("logo_image_path <>", value, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathGreaterThan(String value) {
            addCriterion("logo_image_path >", value, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("logo_image_path >=", value, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathLessThan(String value) {
            addCriterion("logo_image_path <", value, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathLessThanOrEqualTo(String value) {
            addCriterion("logo_image_path <=", value, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathLike(String value) {
            addCriterion("logo_image_path like", value, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathNotLike(String value) {
            addCriterion("logo_image_path not like", value, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathIn(List<String> values) {
            addCriterion("logo_image_path in", values, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathNotIn(List<String> values) {
            addCriterion("logo_image_path not in", values, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathBetween(String value1, String value2) {
            addCriterion("logo_image_path between", value1, value2, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andLogoImagePathNotBetween(String value1, String value2) {
            addCriterion("logo_image_path not between", value1, value2, "logoImagePath");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIsNull() {
            addCriterion("service_category is null");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIsNotNull() {
            addCriterion("service_category is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryEqualTo(String value) {
            addCriterion("service_category =", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotEqualTo(String value) {
            addCriterion("service_category <>", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryGreaterThan(String value) {
            addCriterion("service_category >", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("service_category >=", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryLessThan(String value) {
            addCriterion("service_category <", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryLessThanOrEqualTo(String value) {
            addCriterion("service_category <=", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryLike(String value) {
            addCriterion("service_category like", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotLike(String value) {
            addCriterion("service_category not like", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIn(List<String> values) {
            addCriterion("service_category in", values, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotIn(List<String> values) {
            addCriterion("service_category not in", values, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryBetween(String value1, String value2) {
            addCriterion("service_category between", value1, value2, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotBetween(String value1, String value2) {
            addCriterion("service_category not between", value1, value2, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureIsNull() {
            addCriterion("is_support_measure is null");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureIsNotNull() {
            addCriterion("is_support_measure is not null");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureEqualTo(Boolean value) {
            addCriterion("is_support_measure =", value, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureNotEqualTo(Boolean value) {
            addCriterion("is_support_measure <>", value, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureGreaterThan(Boolean value) {
            addCriterion("is_support_measure >", value, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_support_measure >=", value, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureLessThan(Boolean value) {
            addCriterion("is_support_measure <", value, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureLessThanOrEqualTo(Boolean value) {
            addCriterion("is_support_measure <=", value, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureIn(List<Boolean> values) {
            addCriterion("is_support_measure in", values, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureNotIn(List<Boolean> values) {
            addCriterion("is_support_measure not in", values, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureBetween(Boolean value1, Boolean value2) {
            addCriterion("is_support_measure between", value1, value2, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andIsSupportMeasureNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_support_measure not between", value1, value2, "isSupportMeasure");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Long value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Long value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Long value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Long value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Long value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Long> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Long> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Long value1, Long value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Long value1, Long value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
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

        public Criteria andUpdatorIsNull() {
            addCriterion("updator is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("updator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(Long value) {
            addCriterion("updator =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(Long value) {
            addCriterion("updator <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(Long value) {
            addCriterion("updator >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(Long value) {
            addCriterion("updator >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(Long value) {
            addCriterion("updator <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(Long value) {
            addCriterion("updator <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<Long> values) {
            addCriterion("updator in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<Long> values) {
            addCriterion("updator not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(Long value1, Long value2) {
            addCriterion("updator between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(Long value1, Long value2) {
            addCriterion("updator not between", value1, value2, "updator");
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

        public Criteria andCheckStateIsNull() {
            addCriterion("check_state is null");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNotNull() {
            addCriterion("check_state is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStateEqualTo(Integer value) {
            addCriterion("check_state =", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotEqualTo(Integer value) {
            addCriterion("check_state <>", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThan(Integer value) {
            addCriterion("check_state >", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_state >=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThan(Integer value) {
            addCriterion("check_state <", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThanOrEqualTo(Integer value) {
            addCriterion("check_state <=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateIn(List<Integer> values) {
            addCriterion("check_state in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotIn(List<Integer> values) {
            addCriterion("check_state not in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateBetween(Integer value1, Integer value2) {
            addCriterion("check_state between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotBetween(Integer value1, Integer value2) {
            addCriterion("check_state not between", value1, value2, "checkState");
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