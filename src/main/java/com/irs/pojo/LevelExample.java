package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class LevelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LevelExample() {
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

        public Criteria andLeIdIsNull() {
            addCriterion("le_id is null");
            return (Criteria) this;
        }

        public Criteria andLeIdIsNotNull() {
            addCriterion("le_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeIdEqualTo(Integer value) {
            addCriterion("le_id =", value, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdNotEqualTo(Integer value) {
            addCriterion("le_id <>", value, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdGreaterThan(Integer value) {
            addCriterion("le_id >", value, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("le_id >=", value, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdLessThan(Integer value) {
            addCriterion("le_id <", value, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdLessThanOrEqualTo(Integer value) {
            addCriterion("le_id <=", value, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdIn(List<Integer> values) {
            addCriterion("le_id in", values, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdNotIn(List<Integer> values) {
            addCriterion("le_id not in", values, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdBetween(Integer value1, Integer value2) {
            addCriterion("le_id between", value1, value2, "leId");
            return (Criteria) this;
        }

        public Criteria andLeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("le_id not between", value1, value2, "leId");
            return (Criteria) this;
        }

        public Criteria andLeNameIsNull() {
            addCriterion("le_name is null");
            return (Criteria) this;
        }

        public Criteria andLeNameIsNotNull() {
            addCriterion("le_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeNameEqualTo(String value) {
            addCriterion("le_name =", value, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameNotEqualTo(String value) {
            addCriterion("le_name <>", value, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameGreaterThan(String value) {
            addCriterion("le_name >", value, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameGreaterThanOrEqualTo(String value) {
            addCriterion("le_name >=", value, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameLessThan(String value) {
            addCriterion("le_name <", value, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameLessThanOrEqualTo(String value) {
            addCriterion("le_name <=", value, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameLike(String value) {
            addCriterion("le_name like", value, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameNotLike(String value) {
            addCriterion("le_name not like", value, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameIn(List<String> values) {
            addCriterion("le_name in", values, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameNotIn(List<String> values) {
            addCriterion("le_name not in", values, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameBetween(String value1, String value2) {
            addCriterion("le_name between", value1, value2, "leName");
            return (Criteria) this;
        }

        public Criteria andLeNameNotBetween(String value1, String value2) {
            addCriterion("le_name not between", value1, value2, "leName");
            return (Criteria) this;
        }

        public Criteria andR1IsNull() {
            addCriterion("R1 is null");
            return (Criteria) this;
        }

        public Criteria andR1IsNotNull() {
            addCriterion("R1 is not null");
            return (Criteria) this;
        }

        public Criteria andR1EqualTo(String value) {
            addCriterion("R1 =", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotEqualTo(String value) {
            addCriterion("R1 <>", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1GreaterThan(String value) {
            addCriterion("R1 >", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1GreaterThanOrEqualTo(String value) {
            addCriterion("R1 >=", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1LessThan(String value) {
            addCriterion("R1 <", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1LessThanOrEqualTo(String value) {
            addCriterion("R1 <=", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1Like(String value) {
            addCriterion("R1 like", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotLike(String value) {
            addCriterion("R1 not like", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1In(List<String> values) {
            addCriterion("R1 in", values, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotIn(List<String> values) {
            addCriterion("R1 not in", values, "r1");
            return (Criteria) this;
        }

        public Criteria andR1Between(String value1, String value2) {
            addCriterion("R1 between", value1, value2, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotBetween(String value1, String value2) {
            addCriterion("R1 not between", value1, value2, "r1");
            return (Criteria) this;
        }

        public Criteria andR2IsNull() {
            addCriterion("R2 is null");
            return (Criteria) this;
        }

        public Criteria andR2IsNotNull() {
            addCriterion("R2 is not null");
            return (Criteria) this;
        }

        public Criteria andR2EqualTo(String value) {
            addCriterion("R2 =", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotEqualTo(String value) {
            addCriterion("R2 <>", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2GreaterThan(String value) {
            addCriterion("R2 >", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2GreaterThanOrEqualTo(String value) {
            addCriterion("R2 >=", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2LessThan(String value) {
            addCriterion("R2 <", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2LessThanOrEqualTo(String value) {
            addCriterion("R2 <=", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2Like(String value) {
            addCriterion("R2 like", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotLike(String value) {
            addCriterion("R2 not like", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2In(List<String> values) {
            addCriterion("R2 in", values, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotIn(List<String> values) {
            addCriterion("R2 not in", values, "r2");
            return (Criteria) this;
        }

        public Criteria andR2Between(String value1, String value2) {
            addCriterion("R2 between", value1, value2, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotBetween(String value1, String value2) {
            addCriterion("R2 not between", value1, value2, "r2");
            return (Criteria) this;
        }

        public Criteria andLeDiscountIsNull() {
            addCriterion("le_discount is null");
            return (Criteria) this;
        }

        public Criteria andLeDiscountIsNotNull() {
            addCriterion("le_discount is not null");
            return (Criteria) this;
        }

        public Criteria andLeDiscountEqualTo(String value) {
            addCriterion("le_discount =", value, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountNotEqualTo(String value) {
            addCriterion("le_discount <>", value, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountGreaterThan(String value) {
            addCriterion("le_discount >", value, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("le_discount >=", value, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountLessThan(String value) {
            addCriterion("le_discount <", value, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountLessThanOrEqualTo(String value) {
            addCriterion("le_discount <=", value, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountLike(String value) {
            addCriterion("le_discount like", value, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountNotLike(String value) {
            addCriterion("le_discount not like", value, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountIn(List<String> values) {
            addCriterion("le_discount in", values, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountNotIn(List<String> values) {
            addCriterion("le_discount not in", values, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountBetween(String value1, String value2) {
            addCriterion("le_discount between", value1, value2, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeDiscountNotBetween(String value1, String value2) {
            addCriterion("le_discount not between", value1, value2, "leDiscount");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreIsNull() {
            addCriterion("le_minScore is null");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreIsNotNull() {
            addCriterion("le_minScore is not null");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreEqualTo(Integer value) {
            addCriterion("le_minScore =", value, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreNotEqualTo(Integer value) {
            addCriterion("le_minScore <>", value, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreGreaterThan(Integer value) {
            addCriterion("le_minScore >", value, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("le_minScore >=", value, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreLessThan(Integer value) {
            addCriterion("le_minScore <", value, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreLessThanOrEqualTo(Integer value) {
            addCriterion("le_minScore <=", value, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreIn(List<Integer> values) {
            addCriterion("le_minScore in", values, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreNotIn(List<Integer> values) {
            addCriterion("le_minScore not in", values, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreBetween(Integer value1, Integer value2) {
            addCriterion("le_minScore between", value1, value2, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMinscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("le_minScore not between", value1, value2, "leMinscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreIsNull() {
            addCriterion("le_maxScore is null");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreIsNotNull() {
            addCriterion("le_maxScore is not null");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreEqualTo(Integer value) {
            addCriterion("le_maxScore =", value, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreNotEqualTo(Integer value) {
            addCriterion("le_maxScore <>", value, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreGreaterThan(Integer value) {
            addCriterion("le_maxScore >", value, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("le_maxScore >=", value, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreLessThan(Integer value) {
            addCriterion("le_maxScore <", value, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreLessThanOrEqualTo(Integer value) {
            addCriterion("le_maxScore <=", value, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreIn(List<Integer> values) {
            addCriterion("le_maxScore in", values, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreNotIn(List<Integer> values) {
            addCriterion("le_maxScore not in", values, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreBetween(Integer value1, Integer value2) {
            addCriterion("le_maxScore between", value1, value2, "leMaxscore");
            return (Criteria) this;
        }

        public Criteria andLeMaxscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("le_maxScore not between", value1, value2, "leMaxscore");
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