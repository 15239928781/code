package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class GroupsProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupsProductExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andAOldpriceIsNull() {
            addCriterion("a_oldprice is null");
            return (Criteria) this;
        }

        public Criteria andAOldpriceIsNotNull() {
            addCriterion("a_oldprice is not null");
            return (Criteria) this;
        }

        public Criteria andAOldpriceEqualTo(String value) {
            addCriterion("a_oldprice =", value, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceNotEqualTo(String value) {
            addCriterion("a_oldprice <>", value, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceGreaterThan(String value) {
            addCriterion("a_oldprice >", value, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceGreaterThanOrEqualTo(String value) {
            addCriterion("a_oldprice >=", value, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceLessThan(String value) {
            addCriterion("a_oldprice <", value, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceLessThanOrEqualTo(String value) {
            addCriterion("a_oldprice <=", value, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceLike(String value) {
            addCriterion("a_oldprice like", value, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceNotLike(String value) {
            addCriterion("a_oldprice not like", value, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceIn(List<String> values) {
            addCriterion("a_oldprice in", values, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceNotIn(List<String> values) {
            addCriterion("a_oldprice not in", values, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceBetween(String value1, String value2) {
            addCriterion("a_oldprice between", value1, value2, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andAOldpriceNotBetween(String value1, String value2) {
            addCriterion("a_oldprice not between", value1, value2, "aOldprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceIsNull() {
            addCriterion("a_nowprice is null");
            return (Criteria) this;
        }

        public Criteria andANowpriceIsNotNull() {
            addCriterion("a_nowprice is not null");
            return (Criteria) this;
        }

        public Criteria andANowpriceEqualTo(String value) {
            addCriterion("a_nowprice =", value, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceNotEqualTo(String value) {
            addCriterion("a_nowprice <>", value, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceGreaterThan(String value) {
            addCriterion("a_nowprice >", value, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceGreaterThanOrEqualTo(String value) {
            addCriterion("a_nowprice >=", value, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceLessThan(String value) {
            addCriterion("a_nowprice <", value, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceLessThanOrEqualTo(String value) {
            addCriterion("a_nowprice <=", value, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceLike(String value) {
            addCriterion("a_nowprice like", value, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceNotLike(String value) {
            addCriterion("a_nowprice not like", value, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceIn(List<String> values) {
            addCriterion("a_nowprice in", values, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceNotIn(List<String> values) {
            addCriterion("a_nowprice not in", values, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceBetween(String value1, String value2) {
            addCriterion("a_nowprice between", value1, value2, "aNowprice");
            return (Criteria) this;
        }

        public Criteria andANowpriceNotBetween(String value1, String value2) {
            addCriterion("a_nowprice not between", value1, value2, "aNowprice");
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

        public Criteria andPImageIsNull() {
            addCriterion("p_image is null");
            return (Criteria) this;
        }

        public Criteria andPImageIsNotNull() {
            addCriterion("p_image is not null");
            return (Criteria) this;
        }

        public Criteria andPImageEqualTo(String value) {
            addCriterion("p_image =", value, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageNotEqualTo(String value) {
            addCriterion("p_image <>", value, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageGreaterThan(String value) {
            addCriterion("p_image >", value, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageGreaterThanOrEqualTo(String value) {
            addCriterion("p_image >=", value, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageLessThan(String value) {
            addCriterion("p_image <", value, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageLessThanOrEqualTo(String value) {
            addCriterion("p_image <=", value, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageLike(String value) {
            addCriterion("p_image like", value, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageNotLike(String value) {
            addCriterion("p_image not like", value, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageIn(List<String> values) {
            addCriterion("p_image in", values, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageNotIn(List<String> values) {
            addCriterion("p_image not in", values, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageBetween(String value1, String value2) {
            addCriterion("p_image between", value1, value2, "pImage");
            return (Criteria) this;
        }

        public Criteria andPImageNotBetween(String value1, String value2) {
            addCriterion("p_image not between", value1, value2, "pImage");
            return (Criteria) this;
        }

        public Criteria andPDescIsNull() {
            addCriterion("p_desc is null");
            return (Criteria) this;
        }

        public Criteria andPDescIsNotNull() {
            addCriterion("p_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPDescEqualTo(String value) {
            addCriterion("p_desc =", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotEqualTo(String value) {
            addCriterion("p_desc <>", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescGreaterThan(String value) {
            addCriterion("p_desc >", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescGreaterThanOrEqualTo(String value) {
            addCriterion("p_desc >=", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLessThan(String value) {
            addCriterion("p_desc <", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLessThanOrEqualTo(String value) {
            addCriterion("p_desc <=", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLike(String value) {
            addCriterion("p_desc like", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotLike(String value) {
            addCriterion("p_desc not like", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescIn(List<String> values) {
            addCriterion("p_desc in", values, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotIn(List<String> values) {
            addCriterion("p_desc not in", values, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescBetween(String value1, String value2) {
            addCriterion("p_desc between", value1, value2, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotBetween(String value1, String value2) {
            addCriterion("p_desc not between", value1, value2, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIsNull() {
            addCriterion("p_createtime is null");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIsNotNull() {
            addCriterion("p_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeEqualTo(String value) {
            addCriterion("p_createtime =", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotEqualTo(String value) {
            addCriterion("p_createtime <>", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeGreaterThan(String value) {
            addCriterion("p_createtime >", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("p_createtime >=", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeLessThan(String value) {
            addCriterion("p_createtime <", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("p_createtime <=", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeLike(String value) {
            addCriterion("p_createtime like", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotLike(String value) {
            addCriterion("p_createtime not like", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIn(List<String> values) {
            addCriterion("p_createtime in", values, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotIn(List<String> values) {
            addCriterion("p_createtime not in", values, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeBetween(String value1, String value2) {
            addCriterion("p_createtime between", value1, value2, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotBetween(String value1, String value2) {
            addCriterion("p_createtime not between", value1, value2, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeIsNull() {
            addCriterion("p_endtime is null");
            return (Criteria) this;
        }

        public Criteria andPEndtimeIsNotNull() {
            addCriterion("p_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andPEndtimeEqualTo(String value) {
            addCriterion("p_endtime =", value, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeNotEqualTo(String value) {
            addCriterion("p_endtime <>", value, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeGreaterThan(String value) {
            addCriterion("p_endtime >", value, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("p_endtime >=", value, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeLessThan(String value) {
            addCriterion("p_endtime <", value, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeLessThanOrEqualTo(String value) {
            addCriterion("p_endtime <=", value, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeLike(String value) {
            addCriterion("p_endtime like", value, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeNotLike(String value) {
            addCriterion("p_endtime not like", value, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeIn(List<String> values) {
            addCriterion("p_endtime in", values, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeNotIn(List<String> values) {
            addCriterion("p_endtime not in", values, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeBetween(String value1, String value2) {
            addCriterion("p_endtime between", value1, value2, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPEndtimeNotBetween(String value1, String value2) {
            addCriterion("p_endtime not between", value1, value2, "pEndtime");
            return (Criteria) this;
        }

        public Criteria andPValidityIsNull() {
            addCriterion("p_validity is null");
            return (Criteria) this;
        }

        public Criteria andPValidityIsNotNull() {
            addCriterion("p_validity is not null");
            return (Criteria) this;
        }

        public Criteria andPValidityEqualTo(Integer value) {
            addCriterion("p_validity =", value, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityNotEqualTo(Integer value) {
            addCriterion("p_validity <>", value, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityGreaterThan(Integer value) {
            addCriterion("p_validity >", value, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_validity >=", value, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityLessThan(Integer value) {
            addCriterion("p_validity <", value, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityLessThanOrEqualTo(Integer value) {
            addCriterion("p_validity <=", value, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityIn(List<Integer> values) {
            addCriterion("p_validity in", values, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityNotIn(List<Integer> values) {
            addCriterion("p_validity not in", values, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityBetween(Integer value1, Integer value2) {
            addCriterion("p_validity between", value1, value2, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPValidityNotBetween(Integer value1, Integer value2) {
            addCriterion("p_validity not between", value1, value2, "pValidity");
            return (Criteria) this;
        }

        public Criteria andPMemberIsNull() {
            addCriterion("p_member is null");
            return (Criteria) this;
        }

        public Criteria andPMemberIsNotNull() {
            addCriterion("p_member is not null");
            return (Criteria) this;
        }

        public Criteria andPMemberEqualTo(Integer value) {
            addCriterion("p_member =", value, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberNotEqualTo(Integer value) {
            addCriterion("p_member <>", value, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberGreaterThan(Integer value) {
            addCriterion("p_member >", value, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_member >=", value, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberLessThan(Integer value) {
            addCriterion("p_member <", value, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberLessThanOrEqualTo(Integer value) {
            addCriterion("p_member <=", value, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberIn(List<Integer> values) {
            addCriterion("p_member in", values, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberNotIn(List<Integer> values) {
            addCriterion("p_member not in", values, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberBetween(Integer value1, Integer value2) {
            addCriterion("p_member between", value1, value2, "pMember");
            return (Criteria) this;
        }

        public Criteria andPMemberNotBetween(Integer value1, Integer value2) {
            addCriterion("p_member not between", value1, value2, "pMember");
            return (Criteria) this;
        }

        public Criteria andAMaxnumIsNull() {
            addCriterion("a_maxnum is null");
            return (Criteria) this;
        }

        public Criteria andAMaxnumIsNotNull() {
            addCriterion("a_maxnum is not null");
            return (Criteria) this;
        }

        public Criteria andAMaxnumEqualTo(Integer value) {
            addCriterion("a_maxnum =", value, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumNotEqualTo(Integer value) {
            addCriterion("a_maxnum <>", value, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumGreaterThan(Integer value) {
            addCriterion("a_maxnum >", value, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_maxnum >=", value, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumLessThan(Integer value) {
            addCriterion("a_maxnum <", value, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumLessThanOrEqualTo(Integer value) {
            addCriterion("a_maxnum <=", value, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumIn(List<Integer> values) {
            addCriterion("a_maxnum in", values, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumNotIn(List<Integer> values) {
            addCriterion("a_maxnum not in", values, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumBetween(Integer value1, Integer value2) {
            addCriterion("a_maxnum between", value1, value2, "aMaxnum");
            return (Criteria) this;
        }

        public Criteria andAMaxnumNotBetween(Integer value1, Integer value2) {
            addCriterion("a_maxnum not between", value1, value2, "aMaxnum");
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