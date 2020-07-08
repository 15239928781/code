package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class PsbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PsbExample() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andSbidIsNull() {
            addCriterion("sbid is null");
            return (Criteria) this;
        }

        public Criteria andSbidIsNotNull() {
            addCriterion("sbid is not null");
            return (Criteria) this;
        }

        public Criteria andSbidEqualTo(Long value) {
            addCriterion("sbid =", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotEqualTo(Long value) {
            addCriterion("sbid <>", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidGreaterThan(Long value) {
            addCriterion("sbid >", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidGreaterThanOrEqualTo(Long value) {
            addCriterion("sbid >=", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidLessThan(Long value) {
            addCriterion("sbid <", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidLessThanOrEqualTo(Long value) {
            addCriterion("sbid <=", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidIn(List<Long> values) {
            addCriterion("sbid in", values, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotIn(List<Long> values) {
            addCriterion("sbid not in", values, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidBetween(Long value1, Long value2) {
            addCriterion("sbid between", value1, value2, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotBetween(Long value1, Long value2) {
            addCriterion("sbid not between", value1, value2, "sbid");
            return (Criteria) this;
        }

        public Criteria andPsbPricesIsNull() {
            addCriterion("psb_prices is null");
            return (Criteria) this;
        }

        public Criteria andPsbPricesIsNotNull() {
            addCriterion("psb_prices is not null");
            return (Criteria) this;
        }

        public Criteria andPsbPricesEqualTo(Double value) {
            addCriterion("psb_prices =", value, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesNotEqualTo(Double value) {
            addCriterion("psb_prices <>", value, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesGreaterThan(Double value) {
            addCriterion("psb_prices >", value, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesGreaterThanOrEqualTo(Double value) {
            addCriterion("psb_prices >=", value, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesLessThan(Double value) {
            addCriterion("psb_prices <", value, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesLessThanOrEqualTo(Double value) {
            addCriterion("psb_prices <=", value, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesIn(List<Double> values) {
            addCriterion("psb_prices in", values, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesNotIn(List<Double> values) {
            addCriterion("psb_prices not in", values, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesBetween(Double value1, Double value2) {
            addCriterion("psb_prices between", value1, value2, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbPricesNotBetween(Double value1, Double value2) {
            addCriterion("psb_prices not between", value1, value2, "psbPrices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesIsNull() {
            addCriterion("psb_oldprices is null");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesIsNotNull() {
            addCriterion("psb_oldprices is not null");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesEqualTo(Double value) {
            addCriterion("psb_oldprices =", value, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesNotEqualTo(Double value) {
            addCriterion("psb_oldprices <>", value, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesGreaterThan(Double value) {
            addCriterion("psb_oldprices >", value, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesGreaterThanOrEqualTo(Double value) {
            addCriterion("psb_oldprices >=", value, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesLessThan(Double value) {
            addCriterion("psb_oldprices <", value, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesLessThanOrEqualTo(Double value) {
            addCriterion("psb_oldprices <=", value, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesIn(List<Double> values) {
            addCriterion("psb_oldprices in", values, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesNotIn(List<Double> values) {
            addCriterion("psb_oldprices not in", values, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesBetween(Double value1, Double value2) {
            addCriterion("psb_oldprices between", value1, value2, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsbOldpricesNotBetween(Double value1, Double value2) {
            addCriterion("psb_oldprices not between", value1, value2, "psbOldprices");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseIsNull() {
            addCriterion("psd_isuse is null");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseIsNotNull() {
            addCriterion("psd_isuse is not null");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseEqualTo(Integer value) {
            addCriterion("psd_isuse =", value, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseNotEqualTo(Integer value) {
            addCriterion("psd_isuse <>", value, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseGreaterThan(Integer value) {
            addCriterion("psd_isuse >", value, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("psd_isuse >=", value, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseLessThan(Integer value) {
            addCriterion("psd_isuse <", value, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseLessThanOrEqualTo(Integer value) {
            addCriterion("psd_isuse <=", value, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseIn(List<Integer> values) {
            addCriterion("psd_isuse in", values, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseNotIn(List<Integer> values) {
            addCriterion("psd_isuse not in", values, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseBetween(Integer value1, Integer value2) {
            addCriterion("psd_isuse between", value1, value2, "psdIsuse");
            return (Criteria) this;
        }

        public Criteria andPsdIsuseNotBetween(Integer value1, Integer value2) {
            addCriterion("psd_isuse not between", value1, value2, "psdIsuse");
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