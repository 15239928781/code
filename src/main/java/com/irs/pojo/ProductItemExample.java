package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProductItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductItemExample() {
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

        public Criteria andIIdIsNull() {
            addCriterion("i_id is null");
            return (Criteria) this;
        }

        public Criteria andIIdIsNotNull() {
            addCriterion("i_id is not null");
            return (Criteria) this;
        }

        public Criteria andIIdEqualTo(Integer value) {
            addCriterion("i_id =", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotEqualTo(Integer value) {
            addCriterion("i_id <>", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThan(Integer value) {
            addCriterion("i_id >", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_id >=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThan(Integer value) {
            addCriterion("i_id <", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThanOrEqualTo(Integer value) {
            addCriterion("i_id <=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdIn(List<Integer> values) {
            addCriterion("i_id in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotIn(List<Integer> values) {
            addCriterion("i_id not in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdBetween(Integer value1, Integer value2) {
            addCriterion("i_id between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotBetween(Integer value1, Integer value2) {
            addCriterion("i_id not between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andINameIsNull() {
            addCriterion("i_name is null");
            return (Criteria) this;
        }

        public Criteria andINameIsNotNull() {
            addCriterion("i_name is not null");
            return (Criteria) this;
        }

        public Criteria andINameEqualTo(String value) {
            addCriterion("i_name =", value, "iName");
            return (Criteria) this;
        }

        public Criteria andINameNotEqualTo(String value) {
            addCriterion("i_name <>", value, "iName");
            return (Criteria) this;
        }

        public Criteria andINameGreaterThan(String value) {
            addCriterion("i_name >", value, "iName");
            return (Criteria) this;
        }

        public Criteria andINameGreaterThanOrEqualTo(String value) {
            addCriterion("i_name >=", value, "iName");
            return (Criteria) this;
        }

        public Criteria andINameLessThan(String value) {
            addCriterion("i_name <", value, "iName");
            return (Criteria) this;
        }

        public Criteria andINameLessThanOrEqualTo(String value) {
            addCriterion("i_name <=", value, "iName");
            return (Criteria) this;
        }

        public Criteria andINameLike(String value) {
            addCriterion("i_name like", value, "iName");
            return (Criteria) this;
        }

        public Criteria andINameNotLike(String value) {
            addCriterion("i_name not like", value, "iName");
            return (Criteria) this;
        }

        public Criteria andINameIn(List<String> values) {
            addCriterion("i_name in", values, "iName");
            return (Criteria) this;
        }

        public Criteria andINameNotIn(List<String> values) {
            addCriterion("i_name not in", values, "iName");
            return (Criteria) this;
        }

        public Criteria andINameBetween(String value1, String value2) {
            addCriterion("i_name between", value1, value2, "iName");
            return (Criteria) this;
        }

        public Criteria andINameNotBetween(String value1, String value2) {
            addCriterion("i_name not between", value1, value2, "iName");
            return (Criteria) this;
        }

        public Criteria andITimeIsNull() {
            addCriterion("i_time is null");
            return (Criteria) this;
        }

        public Criteria andITimeIsNotNull() {
            addCriterion("i_time is not null");
            return (Criteria) this;
        }

        public Criteria andITimeEqualTo(String value) {
            addCriterion("i_time =", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotEqualTo(String value) {
            addCriterion("i_time <>", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeGreaterThan(String value) {
            addCriterion("i_time >", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeGreaterThanOrEqualTo(String value) {
            addCriterion("i_time >=", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeLessThan(String value) {
            addCriterion("i_time <", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeLessThanOrEqualTo(String value) {
            addCriterion("i_time <=", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeLike(String value) {
            addCriterion("i_time like", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotLike(String value) {
            addCriterion("i_time not like", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeIn(List<String> values) {
            addCriterion("i_time in", values, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotIn(List<String> values) {
            addCriterion("i_time not in", values, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeBetween(String value1, String value2) {
            addCriterion("i_time between", value1, value2, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotBetween(String value1, String value2) {
            addCriterion("i_time not between", value1, value2, "iTime");
            return (Criteria) this;
        }

        public Criteria andIDescIsNull() {
            addCriterion("i_desc is null");
            return (Criteria) this;
        }

        public Criteria andIDescIsNotNull() {
            addCriterion("i_desc is not null");
            return (Criteria) this;
        }

        public Criteria andIDescEqualTo(String value) {
            addCriterion("i_desc =", value, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescNotEqualTo(String value) {
            addCriterion("i_desc <>", value, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescGreaterThan(String value) {
            addCriterion("i_desc >", value, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescGreaterThanOrEqualTo(String value) {
            addCriterion("i_desc >=", value, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescLessThan(String value) {
            addCriterion("i_desc <", value, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescLessThanOrEqualTo(String value) {
            addCriterion("i_desc <=", value, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescLike(String value) {
            addCriterion("i_desc like", value, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescNotLike(String value) {
            addCriterion("i_desc not like", value, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescIn(List<String> values) {
            addCriterion("i_desc in", values, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescNotIn(List<String> values) {
            addCriterion("i_desc not in", values, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescBetween(String value1, String value2) {
            addCriterion("i_desc between", value1, value2, "iDesc");
            return (Criteria) this;
        }

        public Criteria andIDescNotBetween(String value1, String value2) {
            addCriterion("i_desc not between", value1, value2, "iDesc");
            return (Criteria) this;
        }

        public Criteria andR1IsNull() {
            addCriterion("r1 is null");
            return (Criteria) this;
        }

        public Criteria andR1IsNotNull() {
            addCriterion("r1 is not null");
            return (Criteria) this;
        }

        public Criteria andR1EqualTo(String value) {
            addCriterion("r1 =", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotEqualTo(String value) {
            addCriterion("r1 <>", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1GreaterThan(String value) {
            addCriterion("r1 >", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1GreaterThanOrEqualTo(String value) {
            addCriterion("r1 >=", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1LessThan(String value) {
            addCriterion("r1 <", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1LessThanOrEqualTo(String value) {
            addCriterion("r1 <=", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1Like(String value) {
            addCriterion("r1 like", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotLike(String value) {
            addCriterion("r1 not like", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1In(List<String> values) {
            addCriterion("r1 in", values, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotIn(List<String> values) {
            addCriterion("r1 not in", values, "r1");
            return (Criteria) this;
        }

        public Criteria andR1Between(String value1, String value2) {
            addCriterion("r1 between", value1, value2, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotBetween(String value1, String value2) {
            addCriterion("r1 not between", value1, value2, "r1");
            return (Criteria) this;
        }

        public Criteria andR2IsNull() {
            addCriterion("r2 is null");
            return (Criteria) this;
        }

        public Criteria andR2IsNotNull() {
            addCriterion("r2 is not null");
            return (Criteria) this;
        }

        public Criteria andR2EqualTo(String value) {
            addCriterion("r2 =", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotEqualTo(String value) {
            addCriterion("r2 <>", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2GreaterThan(String value) {
            addCriterion("r2 >", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2GreaterThanOrEqualTo(String value) {
            addCriterion("r2 >=", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2LessThan(String value) {
            addCriterion("r2 <", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2LessThanOrEqualTo(String value) {
            addCriterion("r2 <=", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2Like(String value) {
            addCriterion("r2 like", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotLike(String value) {
            addCriterion("r2 not like", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2In(List<String> values) {
            addCriterion("r2 in", values, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotIn(List<String> values) {
            addCriterion("r2 not in", values, "r2");
            return (Criteria) this;
        }

        public Criteria andR2Between(String value1, String value2) {
            addCriterion("r2 between", value1, value2, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotBetween(String value1, String value2) {
            addCriterion("r2 not between", value1, value2, "r2");
            return (Criteria) this;
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

        public Criteria andIPicIsNull() {
            addCriterion("i_pic is null");
            return (Criteria) this;
        }

        public Criteria andIPicIsNotNull() {
            addCriterion("i_pic is not null");
            return (Criteria) this;
        }

        public Criteria andIPicEqualTo(String value) {
            addCriterion("i_pic =", value, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicNotEqualTo(String value) {
            addCriterion("i_pic <>", value, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicGreaterThan(String value) {
            addCriterion("i_pic >", value, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicGreaterThanOrEqualTo(String value) {
            addCriterion("i_pic >=", value, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicLessThan(String value) {
            addCriterion("i_pic <", value, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicLessThanOrEqualTo(String value) {
            addCriterion("i_pic <=", value, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicLike(String value) {
            addCriterion("i_pic like", value, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicNotLike(String value) {
            addCriterion("i_pic not like", value, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicIn(List<String> values) {
            addCriterion("i_pic in", values, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicNotIn(List<String> values) {
            addCriterion("i_pic not in", values, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicBetween(String value1, String value2) {
            addCriterion("i_pic between", value1, value2, "iPic");
            return (Criteria) this;
        }

        public Criteria andIPicNotBetween(String value1, String value2) {
            addCriterion("i_pic not between", value1, value2, "iPic");
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