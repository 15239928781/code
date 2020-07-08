package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopActivityExample() {
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

        public Criteria andAPicIsNull() {
            addCriterion("a_pic is null");
            return (Criteria) this;
        }

        public Criteria andAPicIsNotNull() {
            addCriterion("a_pic is not null");
            return (Criteria) this;
        }

        public Criteria andAPicEqualTo(String value) {
            addCriterion("a_pic =", value, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicNotEqualTo(String value) {
            addCriterion("a_pic <>", value, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicGreaterThan(String value) {
            addCriterion("a_pic >", value, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicGreaterThanOrEqualTo(String value) {
            addCriterion("a_pic >=", value, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicLessThan(String value) {
            addCriterion("a_pic <", value, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicLessThanOrEqualTo(String value) {
            addCriterion("a_pic <=", value, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicLike(String value) {
            addCriterion("a_pic like", value, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicNotLike(String value) {
            addCriterion("a_pic not like", value, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicIn(List<String> values) {
            addCriterion("a_pic in", values, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicNotIn(List<String> values) {
            addCriterion("a_pic not in", values, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicBetween(String value1, String value2) {
            addCriterion("a_pic between", value1, value2, "aPic");
            return (Criteria) this;
        }

        public Criteria andAPicNotBetween(String value1, String value2) {
            addCriterion("a_pic not between", value1, value2, "aPic");
            return (Criteria) this;
        }

        public Criteria andATypeIsNull() {
            addCriterion("a_type is null");
            return (Criteria) this;
        }

        public Criteria andATypeIsNotNull() {
            addCriterion("a_type is not null");
            return (Criteria) this;
        }

        public Criteria andATypeEqualTo(Integer value) {
            addCriterion("a_type =", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotEqualTo(Integer value) {
            addCriterion("a_type <>", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeGreaterThan(Integer value) {
            addCriterion("a_type >", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_type >=", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeLessThan(Integer value) {
            addCriterion("a_type <", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeLessThanOrEqualTo(Integer value) {
            addCriterion("a_type <=", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeIn(List<Integer> values) {
            addCriterion("a_type in", values, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotIn(List<Integer> values) {
            addCriterion("a_type not in", values, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeBetween(Integer value1, Integer value2) {
            addCriterion("a_type between", value1, value2, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotBetween(Integer value1, Integer value2) {
            addCriterion("a_type not between", value1, value2, "aType");
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

        public Criteria andANumIsNull() {
            addCriterion("a_num is null");
            return (Criteria) this;
        }

        public Criteria andANumIsNotNull() {
            addCriterion("a_num is not null");
            return (Criteria) this;
        }

        public Criteria andANumEqualTo(Integer value) {
            addCriterion("a_num =", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumNotEqualTo(Integer value) {
            addCriterion("a_num <>", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumGreaterThan(Integer value) {
            addCriterion("a_num >", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_num >=", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumLessThan(Integer value) {
            addCriterion("a_num <", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumLessThanOrEqualTo(Integer value) {
            addCriterion("a_num <=", value, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumIn(List<Integer> values) {
            addCriterion("a_num in", values, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumNotIn(List<Integer> values) {
            addCriterion("a_num not in", values, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumBetween(Integer value1, Integer value2) {
            addCriterion("a_num between", value1, value2, "aNum");
            return (Criteria) this;
        }

        public Criteria andANumNotBetween(Integer value1, Integer value2) {
            addCriterion("a_num not between", value1, value2, "aNum");
            return (Criteria) this;
        }

        public Criteria andAUrlIsNull() {
            addCriterion("a_url is null");
            return (Criteria) this;
        }

        public Criteria andAUrlIsNotNull() {
            addCriterion("a_url is not null");
            return (Criteria) this;
        }

        public Criteria andAUrlEqualTo(String value) {
            addCriterion("a_url =", value, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlNotEqualTo(String value) {
            addCriterion("a_url <>", value, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlGreaterThan(String value) {
            addCriterion("a_url >", value, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlGreaterThanOrEqualTo(String value) {
            addCriterion("a_url >=", value, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlLessThan(String value) {
            addCriterion("a_url <", value, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlLessThanOrEqualTo(String value) {
            addCriterion("a_url <=", value, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlLike(String value) {
            addCriterion("a_url like", value, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlNotLike(String value) {
            addCriterion("a_url not like", value, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlIn(List<String> values) {
            addCriterion("a_url in", values, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlNotIn(List<String> values) {
            addCriterion("a_url not in", values, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlBetween(String value1, String value2) {
            addCriterion("a_url between", value1, value2, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAUrlNotBetween(String value1, String value2) {
            addCriterion("a_url not between", value1, value2, "aUrl");
            return (Criteria) this;
        }

        public Criteria andAStarttimeIsNull() {
            addCriterion("a_starttime is null");
            return (Criteria) this;
        }

        public Criteria andAStarttimeIsNotNull() {
            addCriterion("a_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andAStarttimeEqualTo(String value) {
            addCriterion("a_starttime =", value, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeNotEqualTo(String value) {
            addCriterion("a_starttime <>", value, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeGreaterThan(String value) {
            addCriterion("a_starttime >", value, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("a_starttime >=", value, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeLessThan(String value) {
            addCriterion("a_starttime <", value, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeLessThanOrEqualTo(String value) {
            addCriterion("a_starttime <=", value, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeLike(String value) {
            addCriterion("a_starttime like", value, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeNotLike(String value) {
            addCriterion("a_starttime not like", value, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeIn(List<String> values) {
            addCriterion("a_starttime in", values, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeNotIn(List<String> values) {
            addCriterion("a_starttime not in", values, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeBetween(String value1, String value2) {
            addCriterion("a_starttime between", value1, value2, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAStarttimeNotBetween(String value1, String value2) {
            addCriterion("a_starttime not between", value1, value2, "aStarttime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeIsNull() {
            addCriterion("a_endtime is null");
            return (Criteria) this;
        }

        public Criteria andAEndtimeIsNotNull() {
            addCriterion("a_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andAEndtimeEqualTo(String value) {
            addCriterion("a_endtime =", value, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeNotEqualTo(String value) {
            addCriterion("a_endtime <>", value, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeGreaterThan(String value) {
            addCriterion("a_endtime >", value, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("a_endtime >=", value, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeLessThan(String value) {
            addCriterion("a_endtime <", value, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeLessThanOrEqualTo(String value) {
            addCriterion("a_endtime <=", value, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeLike(String value) {
            addCriterion("a_endtime like", value, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeNotLike(String value) {
            addCriterion("a_endtime not like", value, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeIn(List<String> values) {
            addCriterion("a_endtime in", values, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeNotIn(List<String> values) {
            addCriterion("a_endtime not in", values, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeBetween(String value1, String value2) {
            addCriterion("a_endtime between", value1, value2, "aEndtime");
            return (Criteria) this;
        }

        public Criteria andAEndtimeNotBetween(String value1, String value2) {
            addCriterion("a_endtime not between", value1, value2, "aEndtime");
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