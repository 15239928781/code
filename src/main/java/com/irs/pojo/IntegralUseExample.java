package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class IntegralUseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntegralUseExample() {
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

        public Criteria andIuIdIsNull() {
            addCriterion("iu_id is null");
            return (Criteria) this;
        }

        public Criteria andIuIdIsNotNull() {
            addCriterion("iu_id is not null");
            return (Criteria) this;
        }

        public Criteria andIuIdEqualTo(Integer value) {
            addCriterion("iu_id =", value, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdNotEqualTo(Integer value) {
            addCriterion("iu_id <>", value, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdGreaterThan(Integer value) {
            addCriterion("iu_id >", value, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("iu_id >=", value, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdLessThan(Integer value) {
            addCriterion("iu_id <", value, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdLessThanOrEqualTo(Integer value) {
            addCriterion("iu_id <=", value, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdIn(List<Integer> values) {
            addCriterion("iu_id in", values, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdNotIn(List<Integer> values) {
            addCriterion("iu_id not in", values, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdBetween(Integer value1, Integer value2) {
            addCriterion("iu_id between", value1, value2, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("iu_id not between", value1, value2, "iuId");
            return (Criteria) this;
        }

        public Criteria andIuNumIsNull() {
            addCriterion("iu_num is null");
            return (Criteria) this;
        }

        public Criteria andIuNumIsNotNull() {
            addCriterion("iu_num is not null");
            return (Criteria) this;
        }

        public Criteria andIuNumEqualTo(Integer value) {
            addCriterion("iu_num =", value, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumNotEqualTo(Integer value) {
            addCriterion("iu_num <>", value, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumGreaterThan(Integer value) {
            addCriterion("iu_num >", value, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("iu_num >=", value, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumLessThan(Integer value) {
            addCriterion("iu_num <", value, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumLessThanOrEqualTo(Integer value) {
            addCriterion("iu_num <=", value, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumIn(List<Integer> values) {
            addCriterion("iu_num in", values, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumNotIn(List<Integer> values) {
            addCriterion("iu_num not in", values, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumBetween(Integer value1, Integer value2) {
            addCriterion("iu_num between", value1, value2, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuNumNotBetween(Integer value1, Integer value2) {
            addCriterion("iu_num not between", value1, value2, "iuNum");
            return (Criteria) this;
        }

        public Criteria andIuPriceIsNull() {
            addCriterion("iu_price is null");
            return (Criteria) this;
        }

        public Criteria andIuPriceIsNotNull() {
            addCriterion("iu_price is not null");
            return (Criteria) this;
        }

        public Criteria andIuPriceEqualTo(String value) {
            addCriterion("iu_price =", value, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceNotEqualTo(String value) {
            addCriterion("iu_price <>", value, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceGreaterThan(String value) {
            addCriterion("iu_price >", value, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceGreaterThanOrEqualTo(String value) {
            addCriterion("iu_price >=", value, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceLessThan(String value) {
            addCriterion("iu_price <", value, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceLessThanOrEqualTo(String value) {
            addCriterion("iu_price <=", value, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceLike(String value) {
            addCriterion("iu_price like", value, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceNotLike(String value) {
            addCriterion("iu_price not like", value, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceIn(List<String> values) {
            addCriterion("iu_price in", values, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceNotIn(List<String> values) {
            addCriterion("iu_price not in", values, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceBetween(String value1, String value2) {
            addCriterion("iu_price between", value1, value2, "iuPrice");
            return (Criteria) this;
        }

        public Criteria andIuPriceNotBetween(String value1, String value2) {
            addCriterion("iu_price not between", value1, value2, "iuPrice");
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

        public Criteria andDIdIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andDIdIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andDIdEqualTo(Integer value) {
            addCriterion("d_id =", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThan(Integer value) {
            addCriterion("d_id >", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThan(Integer value) {
            addCriterion("d_id <", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdIn(List<Integer> values) {
            addCriterion("d_id in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "dId");
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