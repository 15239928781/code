package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class IntegralsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntegralsExample() {
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

        public Criteria andITypeIsNull() {
            addCriterion("i_type is null");
            return (Criteria) this;
        }

        public Criteria andITypeIsNotNull() {
            addCriterion("i_type is not null");
            return (Criteria) this;
        }

        public Criteria andITypeEqualTo(Integer value) {
            addCriterion("i_type =", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeNotEqualTo(Integer value) {
            addCriterion("i_type <>", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeGreaterThan(Integer value) {
            addCriterion("i_type >", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_type >=", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeLessThan(Integer value) {
            addCriterion("i_type <", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeLessThanOrEqualTo(Integer value) {
            addCriterion("i_type <=", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeIn(List<Integer> values) {
            addCriterion("i_type in", values, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeNotIn(List<Integer> values) {
            addCriterion("i_type not in", values, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeBetween(Integer value1, Integer value2) {
            addCriterion("i_type between", value1, value2, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeNotBetween(Integer value1, Integer value2) {
            addCriterion("i_type not between", value1, value2, "iType");
            return (Criteria) this;
        }

        public Criteria andIAddtimeIsNull() {
            addCriterion("i_addtime is null");
            return (Criteria) this;
        }

        public Criteria andIAddtimeIsNotNull() {
            addCriterion("i_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andIAddtimeEqualTo(String value) {
            addCriterion("i_addtime =", value, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeNotEqualTo(String value) {
            addCriterion("i_addtime <>", value, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeGreaterThan(String value) {
            addCriterion("i_addtime >", value, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("i_addtime >=", value, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeLessThan(String value) {
            addCriterion("i_addtime <", value, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeLessThanOrEqualTo(String value) {
            addCriterion("i_addtime <=", value, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeLike(String value) {
            addCriterion("i_addtime like", value, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeNotLike(String value) {
            addCriterion("i_addtime not like", value, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeIn(List<String> values) {
            addCriterion("i_addtime in", values, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeNotIn(List<String> values) {
            addCriterion("i_addtime not in", values, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeBetween(String value1, String value2) {
            addCriterion("i_addtime between", value1, value2, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andIAddtimeNotBetween(String value1, String value2) {
            addCriterion("i_addtime not between", value1, value2, "iAddtime");
            return (Criteria) this;
        }

        public Criteria andINumIsNull() {
            addCriterion("i_num is null");
            return (Criteria) this;
        }

        public Criteria andINumIsNotNull() {
            addCriterion("i_num is not null");
            return (Criteria) this;
        }

        public Criteria andINumEqualTo(Integer value) {
            addCriterion("i_num =", value, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumNotEqualTo(Integer value) {
            addCriterion("i_num <>", value, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumGreaterThan(Integer value) {
            addCriterion("i_num >", value, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_num >=", value, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumLessThan(Integer value) {
            addCriterion("i_num <", value, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumLessThanOrEqualTo(Integer value) {
            addCriterion("i_num <=", value, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumIn(List<Integer> values) {
            addCriterion("i_num in", values, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumNotIn(List<Integer> values) {
            addCriterion("i_num not in", values, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumBetween(Integer value1, Integer value2) {
            addCriterion("i_num between", value1, value2, "iNum");
            return (Criteria) this;
        }

        public Criteria andINumNotBetween(Integer value1, Integer value2) {
            addCriterion("i_num not between", value1, value2, "iNum");
            return (Criteria) this;
        }

        public Criteria andIStatusIsNull() {
            addCriterion("i_status is null");
            return (Criteria) this;
        }

        public Criteria andIStatusIsNotNull() {
            addCriterion("i_status is not null");
            return (Criteria) this;
        }

        public Criteria andIStatusEqualTo(Integer value) {
            addCriterion("i_status =", value, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusNotEqualTo(Integer value) {
            addCriterion("i_status <>", value, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusGreaterThan(Integer value) {
            addCriterion("i_status >", value, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_status >=", value, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusLessThan(Integer value) {
            addCriterion("i_status <", value, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusLessThanOrEqualTo(Integer value) {
            addCriterion("i_status <=", value, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusIn(List<Integer> values) {
            addCriterion("i_status in", values, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusNotIn(List<Integer> values) {
            addCriterion("i_status not in", values, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusBetween(Integer value1, Integer value2) {
            addCriterion("i_status between", value1, value2, "iStatus");
            return (Criteria) this;
        }

        public Criteria andIStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("i_status not between", value1, value2, "iStatus");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
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

        public Criteria andIEndtimeIsNull() {
            addCriterion("i_endtime is null");
            return (Criteria) this;
        }

        public Criteria andIEndtimeIsNotNull() {
            addCriterion("i_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andIEndtimeEqualTo(String value) {
            addCriterion("i_endtime =", value, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeNotEqualTo(String value) {
            addCriterion("i_endtime <>", value, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeGreaterThan(String value) {
            addCriterion("i_endtime >", value, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("i_endtime >=", value, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeLessThan(String value) {
            addCriterion("i_endtime <", value, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeLessThanOrEqualTo(String value) {
            addCriterion("i_endtime <=", value, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeLike(String value) {
            addCriterion("i_endtime like", value, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeNotLike(String value) {
            addCriterion("i_endtime not like", value, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeIn(List<String> values) {
            addCriterion("i_endtime in", values, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeNotIn(List<String> values) {
            addCriterion("i_endtime not in", values, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeBetween(String value1, String value2) {
            addCriterion("i_endtime between", value1, value2, "iEndtime");
            return (Criteria) this;
        }

        public Criteria andIEndtimeNotBetween(String value1, String value2) {
            addCriterion("i_endtime not between", value1, value2, "iEndtime");
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }
    }

    /**
     */
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