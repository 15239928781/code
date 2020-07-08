package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopCategoryExample() {
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

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andCImageIsNull() {
            addCriterion("c_image is null");
            return (Criteria) this;
        }

        public Criteria andCImageIsNotNull() {
            addCriterion("c_image is not null");
            return (Criteria) this;
        }

        public Criteria andCImageEqualTo(String value) {
            addCriterion("c_image =", value, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageNotEqualTo(String value) {
            addCriterion("c_image <>", value, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageGreaterThan(String value) {
            addCriterion("c_image >", value, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageGreaterThanOrEqualTo(String value) {
            addCriterion("c_image >=", value, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageLessThan(String value) {
            addCriterion("c_image <", value, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageLessThanOrEqualTo(String value) {
            addCriterion("c_image <=", value, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageLike(String value) {
            addCriterion("c_image like", value, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageNotLike(String value) {
            addCriterion("c_image not like", value, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageIn(List<String> values) {
            addCriterion("c_image in", values, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageNotIn(List<String> values) {
            addCriterion("c_image not in", values, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageBetween(String value1, String value2) {
            addCriterion("c_image between", value1, value2, "cImage");
            return (Criteria) this;
        }

        public Criteria andCImageNotBetween(String value1, String value2) {
            addCriterion("c_image not between", value1, value2, "cImage");
            return (Criteria) this;
        }

        public Criteria andCIsshowIsNull() {
            addCriterion("c_Isshow is null");
            return (Criteria) this;
        }

        public Criteria andCIsshowIsNotNull() {
            addCriterion("c_Isshow is not null");
            return (Criteria) this;
        }

        public Criteria andCIsshowEqualTo(Integer value) {
            addCriterion("c_Isshow =", value, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowNotEqualTo(Integer value) {
            addCriterion("c_Isshow <>", value, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowGreaterThan(Integer value) {
            addCriterion("c_Isshow >", value, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_Isshow >=", value, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowLessThan(Integer value) {
            addCriterion("c_Isshow <", value, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowLessThanOrEqualTo(Integer value) {
            addCriterion("c_Isshow <=", value, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowIn(List<Integer> values) {
            addCriterion("c_Isshow in", values, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowNotIn(List<Integer> values) {
            addCriterion("c_Isshow not in", values, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowBetween(Integer value1, Integer value2) {
            addCriterion("c_Isshow between", value1, value2, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCIsshowNotBetween(Integer value1, Integer value2) {
            addCriterion("c_Isshow not between", value1, value2, "cIsshow");
            return (Criteria) this;
        }

        public Criteria andCSortingIsNull() {
            addCriterion("c_sorting is null");
            return (Criteria) this;
        }

        public Criteria andCSortingIsNotNull() {
            addCriterion("c_sorting is not null");
            return (Criteria) this;
        }

        public Criteria andCSortingEqualTo(Integer value) {
            addCriterion("c_sorting =", value, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingNotEqualTo(Integer value) {
            addCriterion("c_sorting <>", value, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingGreaterThan(Integer value) {
            addCriterion("c_sorting >", value, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_sorting >=", value, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingLessThan(Integer value) {
            addCriterion("c_sorting <", value, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingLessThanOrEqualTo(Integer value) {
            addCriterion("c_sorting <=", value, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingIn(List<Integer> values) {
            addCriterion("c_sorting in", values, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingNotIn(List<Integer> values) {
            addCriterion("c_sorting not in", values, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingBetween(Integer value1, Integer value2) {
            addCriterion("c_sorting between", value1, value2, "cSorting");
            return (Criteria) this;
        }

        public Criteria andCSortingNotBetween(Integer value1, Integer value2) {
            addCriterion("c_sorting not between", value1, value2, "cSorting");
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