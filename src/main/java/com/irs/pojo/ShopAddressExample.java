package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopAddressExample() {
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

        public Criteria andAIdIsNull() {
            addCriterion("a_id is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("a_id is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(Integer value) {
            addCriterion("a_id =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(Integer value) {
            addCriterion("a_id <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(Integer value) {
            addCriterion("a_id >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_id >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(Integer value) {
            addCriterion("a_id <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(Integer value) {
            addCriterion("a_id <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<Integer> values) {
            addCriterion("a_id in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<Integer> values) {
            addCriterion("a_id not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(Integer value1, Integer value2) {
            addCriterion("a_id between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(Integer value1, Integer value2) {
            addCriterion("a_id not between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andANameIsNull() {
            addCriterion("a_name is null");
            return (Criteria) this;
        }

        public Criteria andANameIsNotNull() {
            addCriterion("a_name is not null");
            return (Criteria) this;
        }

        public Criteria andANameEqualTo(String value) {
            addCriterion("a_name =", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotEqualTo(String value) {
            addCriterion("a_name <>", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameGreaterThan(String value) {
            addCriterion("a_name >", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameGreaterThanOrEqualTo(String value) {
            addCriterion("a_name >=", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLessThan(String value) {
            addCriterion("a_name <", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLessThanOrEqualTo(String value) {
            addCriterion("a_name <=", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLike(String value) {
            addCriterion("a_name like", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotLike(String value) {
            addCriterion("a_name not like", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameIn(List<String> values) {
            addCriterion("a_name in", values, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotIn(List<String> values) {
            addCriterion("a_name not in", values, "aName");
            return (Criteria) this;
        }

        public Criteria andANameBetween(String value1, String value2) {
            addCriterion("a_name between", value1, value2, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotBetween(String value1, String value2) {
            addCriterion("a_name not between", value1, value2, "aName");
            return (Criteria) this;
        }

        public Criteria andATelIsNull() {
            addCriterion("a_tel is null");
            return (Criteria) this;
        }

        public Criteria andATelIsNotNull() {
            addCriterion("a_tel is not null");
            return (Criteria) this;
        }

        public Criteria andATelEqualTo(String value) {
            addCriterion("a_tel =", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelNotEqualTo(String value) {
            addCriterion("a_tel <>", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelGreaterThan(String value) {
            addCriterion("a_tel >", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelGreaterThanOrEqualTo(String value) {
            addCriterion("a_tel >=", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelLessThan(String value) {
            addCriterion("a_tel <", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelLessThanOrEqualTo(String value) {
            addCriterion("a_tel <=", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelLike(String value) {
            addCriterion("a_tel like", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelNotLike(String value) {
            addCriterion("a_tel not like", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelIn(List<String> values) {
            addCriterion("a_tel in", values, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelNotIn(List<String> values) {
            addCriterion("a_tel not in", values, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelBetween(String value1, String value2) {
            addCriterion("a_tel between", value1, value2, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelNotBetween(String value1, String value2) {
            addCriterion("a_tel not between", value1, value2, "aTel");
            return (Criteria) this;
        }

        public Criteria andAProviceIsNull() {
            addCriterion("a_provice is null");
            return (Criteria) this;
        }

        public Criteria andAProviceIsNotNull() {
            addCriterion("a_provice is not null");
            return (Criteria) this;
        }

        public Criteria andAProviceEqualTo(String value) {
            addCriterion("a_provice =", value, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceNotEqualTo(String value) {
            addCriterion("a_provice <>", value, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceGreaterThan(String value) {
            addCriterion("a_provice >", value, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceGreaterThanOrEqualTo(String value) {
            addCriterion("a_provice >=", value, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceLessThan(String value) {
            addCriterion("a_provice <", value, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceLessThanOrEqualTo(String value) {
            addCriterion("a_provice <=", value, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceLike(String value) {
            addCriterion("a_provice like", value, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceNotLike(String value) {
            addCriterion("a_provice not like", value, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceIn(List<String> values) {
            addCriterion("a_provice in", values, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceNotIn(List<String> values) {
            addCriterion("a_provice not in", values, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceBetween(String value1, String value2) {
            addCriterion("a_provice between", value1, value2, "aProvice");
            return (Criteria) this;
        }

        public Criteria andAProviceNotBetween(String value1, String value2) {
            addCriterion("a_provice not between", value1, value2, "aProvice");
            return (Criteria) this;
        }

        public Criteria andACityIsNull() {
            addCriterion("a_city is null");
            return (Criteria) this;
        }

        public Criteria andACityIsNotNull() {
            addCriterion("a_city is not null");
            return (Criteria) this;
        }

        public Criteria andACityEqualTo(String value) {
            addCriterion("a_city =", value, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityNotEqualTo(String value) {
            addCriterion("a_city <>", value, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityGreaterThan(String value) {
            addCriterion("a_city >", value, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityGreaterThanOrEqualTo(String value) {
            addCriterion("a_city >=", value, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityLessThan(String value) {
            addCriterion("a_city <", value, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityLessThanOrEqualTo(String value) {
            addCriterion("a_city <=", value, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityLike(String value) {
            addCriterion("a_city like", value, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityNotLike(String value) {
            addCriterion("a_city not like", value, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityIn(List<String> values) {
            addCriterion("a_city in", values, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityNotIn(List<String> values) {
            addCriterion("a_city not in", values, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityBetween(String value1, String value2) {
            addCriterion("a_city between", value1, value2, "aCity");
            return (Criteria) this;
        }

        public Criteria andACityNotBetween(String value1, String value2) {
            addCriterion("a_city not between", value1, value2, "aCity");
            return (Criteria) this;
        }

        public Criteria andAAreaIsNull() {
            addCriterion("a_area is null");
            return (Criteria) this;
        }

        public Criteria andAAreaIsNotNull() {
            addCriterion("a_area is not null");
            return (Criteria) this;
        }

        public Criteria andAAreaEqualTo(String value) {
            addCriterion("a_area =", value, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaNotEqualTo(String value) {
            addCriterion("a_area <>", value, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaGreaterThan(String value) {
            addCriterion("a_area >", value, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaGreaterThanOrEqualTo(String value) {
            addCriterion("a_area >=", value, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaLessThan(String value) {
            addCriterion("a_area <", value, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaLessThanOrEqualTo(String value) {
            addCriterion("a_area <=", value, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaLike(String value) {
            addCriterion("a_area like", value, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaNotLike(String value) {
            addCriterion("a_area not like", value, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaIn(List<String> values) {
            addCriterion("a_area in", values, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaNotIn(List<String> values) {
            addCriterion("a_area not in", values, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaBetween(String value1, String value2) {
            addCriterion("a_area between", value1, value2, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAreaNotBetween(String value1, String value2) {
            addCriterion("a_area not between", value1, value2, "aArea");
            return (Criteria) this;
        }

        public Criteria andAAddressIsNull() {
            addCriterion("a_address is null");
            return (Criteria) this;
        }

        public Criteria andAAddressIsNotNull() {
            addCriterion("a_address is not null");
            return (Criteria) this;
        }

        public Criteria andAAddressEqualTo(String value) {
            addCriterion("a_address =", value, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressNotEqualTo(String value) {
            addCriterion("a_address <>", value, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressGreaterThan(String value) {
            addCriterion("a_address >", value, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressGreaterThanOrEqualTo(String value) {
            addCriterion("a_address >=", value, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressLessThan(String value) {
            addCriterion("a_address <", value, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressLessThanOrEqualTo(String value) {
            addCriterion("a_address <=", value, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressLike(String value) {
            addCriterion("a_address like", value, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressNotLike(String value) {
            addCriterion("a_address not like", value, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressIn(List<String> values) {
            addCriterion("a_address in", values, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressNotIn(List<String> values) {
            addCriterion("a_address not in", values, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressBetween(String value1, String value2) {
            addCriterion("a_address between", value1, value2, "aAddress");
            return (Criteria) this;
        }

        public Criteria andAAddressNotBetween(String value1, String value2) {
            addCriterion("a_address not between", value1, value2, "aAddress");
            return (Criteria) this;
        }

        public Criteria andALalIsNull() {
            addCriterion("a_lal is null");
            return (Criteria) this;
        }

        public Criteria andALalIsNotNull() {
            addCriterion("a_lal is not null");
            return (Criteria) this;
        }

        public Criteria andALalEqualTo(String value) {
            addCriterion("a_lal =", value, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalNotEqualTo(String value) {
            addCriterion("a_lal <>", value, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalGreaterThan(String value) {
            addCriterion("a_lal >", value, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalGreaterThanOrEqualTo(String value) {
            addCriterion("a_lal >=", value, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalLessThan(String value) {
            addCriterion("a_lal <", value, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalLessThanOrEqualTo(String value) {
            addCriterion("a_lal <=", value, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalLike(String value) {
            addCriterion("a_lal like", value, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalNotLike(String value) {
            addCriterion("a_lal not like", value, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalIn(List<String> values) {
            addCriterion("a_lal in", values, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalNotIn(List<String> values) {
            addCriterion("a_lal not in", values, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalBetween(String value1, String value2) {
            addCriterion("a_lal between", value1, value2, "aLal");
            return (Criteria) this;
        }

        public Criteria andALalNotBetween(String value1, String value2) {
            addCriterion("a_lal not between", value1, value2, "aLal");
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

        public Criteria andAStatusIsNull() {
            addCriterion("a_status is null");
            return (Criteria) this;
        }

        public Criteria andAStatusIsNotNull() {
            addCriterion("a_status is not null");
            return (Criteria) this;
        }

        public Criteria andAStatusEqualTo(Integer value) {
            addCriterion("a_status =", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusNotEqualTo(Integer value) {
            addCriterion("a_status <>", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusGreaterThan(Integer value) {
            addCriterion("a_status >", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_status >=", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusLessThan(Integer value) {
            addCriterion("a_status <", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusLessThanOrEqualTo(Integer value) {
            addCriterion("a_status <=", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusIn(List<Integer> values) {
            addCriterion("a_status in", values, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusNotIn(List<Integer> values) {
            addCriterion("a_status not in", values, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusBetween(Integer value1, Integer value2) {
            addCriterion("a_status between", value1, value2, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("a_status not between", value1, value2, "aStatus");
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