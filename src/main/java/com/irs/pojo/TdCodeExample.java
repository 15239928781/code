package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class TdCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdCodeExample() {
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

        public Criteria andTdIdIsNull() {
            addCriterion("td_id is null");
            return (Criteria) this;
        }

        public Criteria andTdIdIsNotNull() {
            addCriterion("td_id is not null");
            return (Criteria) this;
        }

        public Criteria andTdIdEqualTo(Integer value) {
            addCriterion("td_id =", value, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdNotEqualTo(Integer value) {
            addCriterion("td_id <>", value, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdGreaterThan(Integer value) {
            addCriterion("td_id >", value, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("td_id >=", value, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdLessThan(Integer value) {
            addCriterion("td_id <", value, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdLessThanOrEqualTo(Integer value) {
            addCriterion("td_id <=", value, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdIn(List<Integer> values) {
            addCriterion("td_id in", values, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdNotIn(List<Integer> values) {
            addCriterion("td_id not in", values, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdBetween(Integer value1, Integer value2) {
            addCriterion("td_id between", value1, value2, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("td_id not between", value1, value2, "tdId");
            return (Criteria) this;
        }

        public Criteria andTdCodeIsNull() {
            addCriterion("td_code is null");
            return (Criteria) this;
        }

        public Criteria andTdCodeIsNotNull() {
            addCriterion("td_code is not null");
            return (Criteria) this;
        }

        public Criteria andTdCodeEqualTo(String value) {
            addCriterion("td_code =", value, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeNotEqualTo(String value) {
            addCriterion("td_code <>", value, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeGreaterThan(String value) {
            addCriterion("td_code >", value, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("td_code >=", value, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeLessThan(String value) {
            addCriterion("td_code <", value, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeLessThanOrEqualTo(String value) {
            addCriterion("td_code <=", value, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeLike(String value) {
            addCriterion("td_code like", value, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeNotLike(String value) {
            addCriterion("td_code not like", value, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeIn(List<String> values) {
            addCriterion("td_code in", values, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeNotIn(List<String> values) {
            addCriterion("td_code not in", values, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeBetween(String value1, String value2) {
            addCriterion("td_code between", value1, value2, "tdCode");
            return (Criteria) this;
        }

        public Criteria andTdCodeNotBetween(String value1, String value2) {
            addCriterion("td_code not between", value1, value2, "tdCode");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNull() {
            addCriterion("Background is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNotNull() {
            addCriterion("Background is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundEqualTo(String value) {
            addCriterion("Background =", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotEqualTo(String value) {
            addCriterion("Background <>", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThan(String value) {
            addCriterion("Background >", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("Background >=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThan(String value) {
            addCriterion("Background <", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThanOrEqualTo(String value) {
            addCriterion("Background <=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLike(String value) {
            addCriterion("Background like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotLike(String value) {
            addCriterion("Background not like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundIn(List<String> values) {
            addCriterion("Background in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotIn(List<String> values) {
            addCriterion("Background not in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundBetween(String value1, String value2) {
            addCriterion("Background between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotBetween(String value1, String value2) {
            addCriterion("Background not between", value1, value2, "background");
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