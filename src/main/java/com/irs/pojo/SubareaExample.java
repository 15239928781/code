package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class SubareaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubareaExample() {
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

        public Criteria andSbIdIsNull() {
            addCriterion("sb_id is null");
            return (Criteria) this;
        }

        public Criteria andSbIdIsNotNull() {
            addCriterion("sb_id is not null");
            return (Criteria) this;
        }

        public Criteria andSbIdEqualTo(Long value) {
            addCriterion("sb_id =", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotEqualTo(Long value) {
            addCriterion("sb_id <>", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdGreaterThan(Long value) {
            addCriterion("sb_id >", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sb_id >=", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdLessThan(Long value) {
            addCriterion("sb_id <", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdLessThanOrEqualTo(Long value) {
            addCriterion("sb_id <=", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdIn(List<Long> values) {
            addCriterion("sb_id in", values, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotIn(List<Long> values) {
            addCriterion("sb_id not in", values, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdBetween(Long value1, Long value2) {
            addCriterion("sb_id between", value1, value2, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotBetween(Long value1, Long value2) {
            addCriterion("sb_id not between", value1, value2, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbNameIsNull() {
            addCriterion("sb_name is null");
            return (Criteria) this;
        }

        public Criteria andSbNameIsNotNull() {
            addCriterion("sb_name is not null");
            return (Criteria) this;
        }

        public Criteria andSbNameEqualTo(String value) {
            addCriterion("sb_name =", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotEqualTo(String value) {
            addCriterion("sb_name <>", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameGreaterThan(String value) {
            addCriterion("sb_name >", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameGreaterThanOrEqualTo(String value) {
            addCriterion("sb_name >=", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLessThan(String value) {
            addCriterion("sb_name <", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLessThanOrEqualTo(String value) {
            addCriterion("sb_name <=", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLike(String value) {
            addCriterion("sb_name like", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotLike(String value) {
            addCriterion("sb_name not like", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameIn(List<String> values) {
            addCriterion("sb_name in", values, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotIn(List<String> values) {
            addCriterion("sb_name not in", values, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameBetween(String value1, String value2) {
            addCriterion("sb_name between", value1, value2, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotBetween(String value1, String value2) {
            addCriterion("sb_name not between", value1, value2, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbIsshowIsNull() {
            addCriterion("sb_isshow is null");
            return (Criteria) this;
        }

        public Criteria andSbIsshowIsNotNull() {
            addCriterion("sb_isshow is not null");
            return (Criteria) this;
        }

        public Criteria andSbIsshowEqualTo(Integer value) {
            addCriterion("sb_isshow =", value, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowNotEqualTo(Integer value) {
            addCriterion("sb_isshow <>", value, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowGreaterThan(Integer value) {
            addCriterion("sb_isshow >", value, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowGreaterThanOrEqualTo(Integer value) {
            addCriterion("sb_isshow >=", value, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowLessThan(Integer value) {
            addCriterion("sb_isshow <", value, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowLessThanOrEqualTo(Integer value) {
            addCriterion("sb_isshow <=", value, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowIn(List<Integer> values) {
            addCriterion("sb_isshow in", values, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowNotIn(List<Integer> values) {
            addCriterion("sb_isshow not in", values, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowBetween(Integer value1, Integer value2) {
            addCriterion("sb_isshow between", value1, value2, "sbIsshow");
            return (Criteria) this;
        }

        public Criteria andSbIsshowNotBetween(Integer value1, Integer value2) {
            addCriterion("sb_isshow not between", value1, value2, "sbIsshow");
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