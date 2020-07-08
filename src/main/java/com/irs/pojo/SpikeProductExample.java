package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class SpikeProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpikeProductExample() {
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

        public Criteria andSpIdIsNull() {
            addCriterion("sp_id is null");
            return (Criteria) this;
        }

        public Criteria andSpIdIsNotNull() {
            addCriterion("sp_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpIdEqualTo(Integer value) {
            addCriterion("sp_id =", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotEqualTo(Integer value) {
            addCriterion("sp_id <>", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThan(Integer value) {
            addCriterion("sp_id >", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_id >=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThan(Integer value) {
            addCriterion("sp_id <", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThanOrEqualTo(Integer value) {
            addCriterion("sp_id <=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdIn(List<Integer> values) {
            addCriterion("sp_id in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotIn(List<Integer> values) {
            addCriterion("sp_id not in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdBetween(Integer value1, Integer value2) {
            addCriterion("sp_id between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_id not between", value1, value2, "spId");
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

        public Criteria andPOldpriceIsNull() {
            addCriterion("p_oldprice is null");
            return (Criteria) this;
        }

        public Criteria andPOldpriceIsNotNull() {
            addCriterion("p_oldprice is not null");
            return (Criteria) this;
        }

        public Criteria andPOldpriceEqualTo(String value) {
            addCriterion("p_oldprice =", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceNotEqualTo(String value) {
            addCriterion("p_oldprice <>", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceGreaterThan(String value) {
            addCriterion("p_oldprice >", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceGreaterThanOrEqualTo(String value) {
            addCriterion("p_oldprice >=", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceLessThan(String value) {
            addCriterion("p_oldprice <", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceLessThanOrEqualTo(String value) {
            addCriterion("p_oldprice <=", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceLike(String value) {
            addCriterion("p_oldprice like", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceNotLike(String value) {
            addCriterion("p_oldprice not like", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceIn(List<String> values) {
            addCriterion("p_oldprice in", values, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceNotIn(List<String> values) {
            addCriterion("p_oldprice not in", values, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceBetween(String value1, String value2) {
            addCriterion("p_oldprice between", value1, value2, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceNotBetween(String value1, String value2) {
            addCriterion("p_oldprice not between", value1, value2, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceIsNull() {
            addCriterion("p_nowprice is null");
            return (Criteria) this;
        }

        public Criteria andPNowpriceIsNotNull() {
            addCriterion("p_nowprice is not null");
            return (Criteria) this;
        }

        public Criteria andPNowpriceEqualTo(String value) {
            addCriterion("p_nowprice =", value, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceNotEqualTo(String value) {
            addCriterion("p_nowprice <>", value, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceGreaterThan(String value) {
            addCriterion("p_nowprice >", value, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceGreaterThanOrEqualTo(String value) {
            addCriterion("p_nowprice >=", value, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceLessThan(String value) {
            addCriterion("p_nowprice <", value, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceLessThanOrEqualTo(String value) {
            addCriterion("p_nowprice <=", value, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceLike(String value) {
            addCriterion("p_nowprice like", value, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceNotLike(String value) {
            addCriterion("p_nowprice not like", value, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceIn(List<String> values) {
            addCriterion("p_nowprice in", values, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceNotIn(List<String> values) {
            addCriterion("p_nowprice not in", values, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceBetween(String value1, String value2) {
            addCriterion("p_nowprice between", value1, value2, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andPNowpriceNotBetween(String value1, String value2) {
            addCriterion("p_nowprice not between", value1, value2, "pNowprice");
            return (Criteria) this;
        }

        public Criteria andSpStatusIsNull() {
            addCriterion("sp_status is null");
            return (Criteria) this;
        }

        public Criteria andSpStatusIsNotNull() {
            addCriterion("sp_status is not null");
            return (Criteria) this;
        }

        public Criteria andSpStatusEqualTo(Integer value) {
            addCriterion("sp_status =", value, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusNotEqualTo(Integer value) {
            addCriterion("sp_status <>", value, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusGreaterThan(Integer value) {
            addCriterion("sp_status >", value, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_status >=", value, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusLessThan(Integer value) {
            addCriterion("sp_status <", value, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sp_status <=", value, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusIn(List<Integer> values) {
            addCriterion("sp_status in", values, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusNotIn(List<Integer> values) {
            addCriterion("sp_status not in", values, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusBetween(Integer value1, Integer value2) {
            addCriterion("sp_status between", value1, value2, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_status not between", value1, value2, "spStatus");
            return (Criteria) this;
        }

        public Criteria andSpNumIsNull() {
            addCriterion("sp_num is null");
            return (Criteria) this;
        }

        public Criteria andSpNumIsNotNull() {
            addCriterion("sp_num is not null");
            return (Criteria) this;
        }

        public Criteria andSpNumEqualTo(Integer value) {
            addCriterion("sp_num =", value, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumNotEqualTo(Integer value) {
            addCriterion("sp_num <>", value, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumGreaterThan(Integer value) {
            addCriterion("sp_num >", value, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_num >=", value, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumLessThan(Integer value) {
            addCriterion("sp_num <", value, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumLessThanOrEqualTo(Integer value) {
            addCriterion("sp_num <=", value, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumIn(List<Integer> values) {
            addCriterion("sp_num in", values, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumNotIn(List<Integer> values) {
            addCriterion("sp_num not in", values, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumBetween(Integer value1, Integer value2) {
            addCriterion("sp_num between", value1, value2, "spNum");
            return (Criteria) this;
        }

        public Criteria andSpNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_num not between", value1, value2, "spNum");
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