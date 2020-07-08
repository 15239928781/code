package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopProductExample() {
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

        public Criteria andPPriceIsNull() {
            addCriterion("p_price is null");
            return (Criteria) this;
        }

        public Criteria andPPriceIsNotNull() {
            addCriterion("p_price is not null");
            return (Criteria) this;
        }

        public Criteria andPPriceEqualTo(Double value) {
            addCriterion("p_price =", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotEqualTo(Double value) {
            addCriterion("p_price <>", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThan(Double value) {
            addCriterion("p_price >", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("p_price >=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThan(Double value) {
            addCriterion("p_price <", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThanOrEqualTo(Double value) {
            addCriterion("p_price <=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceIn(List<Double> values) {
            addCriterion("p_price in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotIn(List<Double> values) {
            addCriterion("p_price not in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceBetween(Double value1, Double value2) {
            addCriterion("p_price between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotBetween(Double value1, Double value2) {
            addCriterion("p_price not between", value1, value2, "pPrice");
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

        public Criteria andPOldpriceEqualTo(Double value) {
            addCriterion("p_oldprice =", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceNotEqualTo(Double value) {
            addCriterion("p_oldprice <>", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceGreaterThan(Double value) {
            addCriterion("p_oldprice >", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("p_oldprice >=", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceLessThan(Double value) {
            addCriterion("p_oldprice <", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceLessThanOrEqualTo(Double value) {
            addCriterion("p_oldprice <=", value, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceIn(List<Double> values) {
            addCriterion("p_oldprice in", values, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceNotIn(List<Double> values) {
            addCriterion("p_oldprice not in", values, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceBetween(Double value1, Double value2) {
            addCriterion("p_oldprice between", value1, value2, "pOldprice");
            return (Criteria) this;
        }

        public Criteria andPOldpriceNotBetween(Double value1, Double value2) {
            addCriterion("p_oldprice not between", value1, value2, "pOldprice");
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

        public Criteria andPAddtimeIsNull() {
            addCriterion("p_addtime is null");
            return (Criteria) this;
        }

        public Criteria andPAddtimeIsNotNull() {
            addCriterion("p_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andPAddtimeEqualTo(String value) {
            addCriterion("p_addtime =", value, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeNotEqualTo(String value) {
            addCriterion("p_addtime <>", value, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeGreaterThan(String value) {
            addCriterion("p_addtime >", value, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("p_addtime >=", value, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeLessThan(String value) {
            addCriterion("p_addtime <", value, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeLessThanOrEqualTo(String value) {
            addCriterion("p_addtime <=", value, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeLike(String value) {
            addCriterion("p_addtime like", value, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeNotLike(String value) {
            addCriterion("p_addtime not like", value, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeIn(List<String> values) {
            addCriterion("p_addtime in", values, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeNotIn(List<String> values) {
            addCriterion("p_addtime not in", values, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeBetween(String value1, String value2) {
            addCriterion("p_addtime between", value1, value2, "pAddtime");
            return (Criteria) this;
        }

        public Criteria andPAddtimeNotBetween(String value1, String value2) {
            addCriterion("p_addtime not between", value1, value2, "pAddtime");
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

        public Criteria andPIshotIsNull() {
            addCriterion("p_ishot is null");
            return (Criteria) this;
        }

        public Criteria andPIshotIsNotNull() {
            addCriterion("p_ishot is not null");
            return (Criteria) this;
        }

        public Criteria andPIshotEqualTo(Integer value) {
            addCriterion("p_ishot =", value, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotNotEqualTo(Integer value) {
            addCriterion("p_ishot <>", value, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotGreaterThan(Integer value) {
            addCriterion("p_ishot >", value, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_ishot >=", value, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotLessThan(Integer value) {
            addCriterion("p_ishot <", value, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotLessThanOrEqualTo(Integer value) {
            addCriterion("p_ishot <=", value, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotIn(List<Integer> values) {
            addCriterion("p_ishot in", values, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotNotIn(List<Integer> values) {
            addCriterion("p_ishot not in", values, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotBetween(Integer value1, Integer value2) {
            addCriterion("p_ishot between", value1, value2, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIshotNotBetween(Integer value1, Integer value2) {
            addCriterion("p_ishot not between", value1, value2, "pIshot");
            return (Criteria) this;
        }

        public Criteria andPIsonIsNull() {
            addCriterion("p_ison is null");
            return (Criteria) this;
        }

        public Criteria andPIsonIsNotNull() {
            addCriterion("p_ison is not null");
            return (Criteria) this;
        }

        public Criteria andPIsonEqualTo(Integer value) {
            addCriterion("p_ison =", value, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonNotEqualTo(Integer value) {
            addCriterion("p_ison <>", value, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonGreaterThan(Integer value) {
            addCriterion("p_ison >", value, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_ison >=", value, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonLessThan(Integer value) {
            addCriterion("p_ison <", value, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonLessThanOrEqualTo(Integer value) {
            addCriterion("p_ison <=", value, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonIn(List<Integer> values) {
            addCriterion("p_ison in", values, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonNotIn(List<Integer> values) {
            addCriterion("p_ison not in", values, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonBetween(Integer value1, Integer value2) {
            addCriterion("p_ison between", value1, value2, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIsonNotBetween(Integer value1, Integer value2) {
            addCriterion("p_ison not between", value1, value2, "pIson");
            return (Criteria) this;
        }

        public Criteria andPIscouponIsNull() {
            addCriterion("p_iscoupon is null");
            return (Criteria) this;
        }

        public Criteria andPIscouponIsNotNull() {
            addCriterion("p_iscoupon is not null");
            return (Criteria) this;
        }

        public Criteria andPIscouponEqualTo(Integer value) {
            addCriterion("p_iscoupon =", value, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponNotEqualTo(Integer value) {
            addCriterion("p_iscoupon <>", value, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponGreaterThan(Integer value) {
            addCriterion("p_iscoupon >", value, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_iscoupon >=", value, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponLessThan(Integer value) {
            addCriterion("p_iscoupon <", value, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponLessThanOrEqualTo(Integer value) {
            addCriterion("p_iscoupon <=", value, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponIn(List<Integer> values) {
            addCriterion("p_iscoupon in", values, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponNotIn(List<Integer> values) {
            addCriterion("p_iscoupon not in", values, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponBetween(Integer value1, Integer value2) {
            addCriterion("p_iscoupon between", value1, value2, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscouponNotBetween(Integer value1, Integer value2) {
            addCriterion("p_iscoupon not between", value1, value2, "pIscoupon");
            return (Criteria) this;
        }

        public Criteria andPIscoreIsNull() {
            addCriterion("p_iscore is null");
            return (Criteria) this;
        }

        public Criteria andPIscoreIsNotNull() {
            addCriterion("p_iscore is not null");
            return (Criteria) this;
        }

        public Criteria andPIscoreEqualTo(Integer value) {
            addCriterion("p_iscore =", value, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreNotEqualTo(Integer value) {
            addCriterion("p_iscore <>", value, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreGreaterThan(Integer value) {
            addCriterion("p_iscore >", value, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_iscore >=", value, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreLessThan(Integer value) {
            addCriterion("p_iscore <", value, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreLessThanOrEqualTo(Integer value) {
            addCriterion("p_iscore <=", value, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreIn(List<Integer> values) {
            addCriterion("p_iscore in", values, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreNotIn(List<Integer> values) {
            addCriterion("p_iscore not in", values, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreBetween(Integer value1, Integer value2) {
            addCriterion("p_iscore between", value1, value2, "pIscore");
            return (Criteria) this;
        }

        public Criteria andPIscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("p_iscore not between", value1, value2, "pIscore");
            return (Criteria) this;
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

        public Criteria andPNumIsNull() {
            addCriterion("p_num is null");
            return (Criteria) this;
        }

        public Criteria andPNumIsNotNull() {
            addCriterion("p_num is not null");
            return (Criteria) this;
        }

        public Criteria andPNumEqualTo(Integer value) {
            addCriterion("p_num =", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumNotEqualTo(Integer value) {
            addCriterion("p_num <>", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumGreaterThan(Integer value) {
            addCriterion("p_num >", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_num >=", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumLessThan(Integer value) {
            addCriterion("p_num <", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumLessThanOrEqualTo(Integer value) {
            addCriterion("p_num <=", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumIn(List<Integer> values) {
            addCriterion("p_num in", values, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumNotIn(List<Integer> values) {
            addCriterion("p_num not in", values, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumBetween(Integer value1, Integer value2) {
            addCriterion("p_num between", value1, value2, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumNotBetween(Integer value1, Integer value2) {
            addCriterion("p_num not between", value1, value2, "pNum");
            return (Criteria) this;
        }

        public Criteria andPStockIsNull() {
            addCriterion("p_stock is null");
            return (Criteria) this;
        }

        public Criteria andPStockIsNotNull() {
            addCriterion("p_stock is not null");
            return (Criteria) this;
        }

        public Criteria andPStockEqualTo(Integer value) {
            addCriterion("p_stock =", value, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockNotEqualTo(Integer value) {
            addCriterion("p_stock <>", value, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockGreaterThan(Integer value) {
            addCriterion("p_stock >", value, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_stock >=", value, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockLessThan(Integer value) {
            addCriterion("p_stock <", value, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockLessThanOrEqualTo(Integer value) {
            addCriterion("p_stock <=", value, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockIn(List<Integer> values) {
            addCriterion("p_stock in", values, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockNotIn(List<Integer> values) {
            addCriterion("p_stock not in", values, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockBetween(Integer value1, Integer value2) {
            addCriterion("p_stock between", value1, value2, "pStock");
            return (Criteria) this;
        }

        public Criteria andPStockNotBetween(Integer value1, Integer value2) {
            addCriterion("p_stock not between", value1, value2, "pStock");
            return (Criteria) this;
        }

        public Criteria andPIsfeeIsNull() {
            addCriterion("p_isfee is null");
            return (Criteria) this;
        }

        public Criteria andPIsfeeIsNotNull() {
            addCriterion("p_isfee is not null");
            return (Criteria) this;
        }

        public Criteria andPIsfeeEqualTo(Integer value) {
            addCriterion("p_isfee =", value, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeNotEqualTo(Integer value) {
            addCriterion("p_isfee <>", value, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeGreaterThan(Integer value) {
            addCriterion("p_isfee >", value, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_isfee >=", value, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeLessThan(Integer value) {
            addCriterion("p_isfee <", value, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeLessThanOrEqualTo(Integer value) {
            addCriterion("p_isfee <=", value, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeIn(List<Integer> values) {
            addCriterion("p_isfee in", values, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeNotIn(List<Integer> values) {
            addCriterion("p_isfee not in", values, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeBetween(Integer value1, Integer value2) {
            addCriterion("p_isfee between", value1, value2, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIsfeeNotBetween(Integer value1, Integer value2) {
            addCriterion("p_isfee not between", value1, value2, "pIsfee");
            return (Criteria) this;
        }

        public Criteria andPIskillIsNull() {
            addCriterion("p_iskill is null");
            return (Criteria) this;
        }

        public Criteria andPIskillIsNotNull() {
            addCriterion("p_iskill is not null");
            return (Criteria) this;
        }

        public Criteria andPIskillEqualTo(Integer value) {
            addCriterion("p_iskill =", value, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillNotEqualTo(Integer value) {
            addCriterion("p_iskill <>", value, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillGreaterThan(Integer value) {
            addCriterion("p_iskill >", value, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_iskill >=", value, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillLessThan(Integer value) {
            addCriterion("p_iskill <", value, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillLessThanOrEqualTo(Integer value) {
            addCriterion("p_iskill <=", value, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillIn(List<Integer> values) {
            addCriterion("p_iskill in", values, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillNotIn(List<Integer> values) {
            addCriterion("p_iskill not in", values, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillBetween(Integer value1, Integer value2) {
            addCriterion("p_iskill between", value1, value2, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIskillNotBetween(Integer value1, Integer value2) {
            addCriterion("p_iskill not between", value1, value2, "pIskill");
            return (Criteria) this;
        }

        public Criteria andPIsgroupIsNull() {
            addCriterion("p_isgroup is null");
            return (Criteria) this;
        }

        public Criteria andPIsgroupIsNotNull() {
            addCriterion("p_isgroup is not null");
            return (Criteria) this;
        }

        public Criteria andPIsgroupEqualTo(String value) {
            addCriterion("p_isgroup =", value, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupNotEqualTo(String value) {
            addCriterion("p_isgroup <>", value, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupGreaterThan(String value) {
            addCriterion("p_isgroup >", value, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupGreaterThanOrEqualTo(String value) {
            addCriterion("p_isgroup >=", value, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupLessThan(String value) {
            addCriterion("p_isgroup <", value, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupLessThanOrEqualTo(String value) {
            addCriterion("p_isgroup <=", value, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupLike(String value) {
            addCriterion("p_isgroup like", value, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupNotLike(String value) {
            addCriterion("p_isgroup not like", value, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupIn(List<String> values) {
            addCriterion("p_isgroup in", values, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupNotIn(List<String> values) {
            addCriterion("p_isgroup not in", values, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupBetween(String value1, String value2) {
            addCriterion("p_isgroup between", value1, value2, "pIsgroup");
            return (Criteria) this;
        }

        public Criteria andPIsgroupNotBetween(String value1, String value2) {
            addCriterion("p_isgroup not between", value1, value2, "pIsgroup");
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

        public Criteria andPIspcIsNull() {
            addCriterion("p_ispc is null");
            return (Criteria) this;
        }

        public Criteria andPIspcIsNotNull() {
            addCriterion("p_ispc is not null");
            return (Criteria) this;
        }

        public Criteria andPIspcEqualTo(Integer value) {
            addCriterion("p_ispc =", value, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcNotEqualTo(Integer value) {
            addCriterion("p_ispc <>", value, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcGreaterThan(Integer value) {
            addCriterion("p_ispc >", value, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_ispc >=", value, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcLessThan(Integer value) {
            addCriterion("p_ispc <", value, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcLessThanOrEqualTo(Integer value) {
            addCriterion("p_ispc <=", value, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcIn(List<Integer> values) {
            addCriterion("p_ispc in", values, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcNotIn(List<Integer> values) {
            addCriterion("p_ispc not in", values, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcBetween(Integer value1, Integer value2) {
            addCriterion("p_ispc between", value1, value2, "pIspc");
            return (Criteria) this;
        }

        public Criteria andPIspcNotBetween(Integer value1, Integer value2) {
            addCriterion("p_ispc not between", value1, value2, "pIspc");
            return (Criteria) this;
        }

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(Integer value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(Integer value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(Integer value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(Integer value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<Integer> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<Integer> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(Integer value1, Integer value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
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

        public Criteria andPTuijianIsNull() {
            addCriterion("p_tuijian is null");
            return (Criteria) this;
        }

        public Criteria andPTuijianIsNotNull() {
            addCriterion("p_tuijian is not null");
            return (Criteria) this;
        }

        public Criteria andPTuijianEqualTo(Integer value) {
            addCriterion("p_tuijian =", value, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianNotEqualTo(Integer value) {
            addCriterion("p_tuijian <>", value, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianGreaterThan(Integer value) {
            addCriterion("p_tuijian >", value, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_tuijian >=", value, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianLessThan(Integer value) {
            addCriterion("p_tuijian <", value, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianLessThanOrEqualTo(Integer value) {
            addCriterion("p_tuijian <=", value, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianIn(List<Integer> values) {
            addCriterion("p_tuijian in", values, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianNotIn(List<Integer> values) {
            addCriterion("p_tuijian not in", values, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianBetween(Integer value1, Integer value2) {
            addCriterion("p_tuijian between", value1, value2, "pTuijian");
            return (Criteria) this;
        }

        public Criteria andPTuijianNotBetween(Integer value1, Integer value2) {
            addCriterion("p_tuijian not between", value1, value2, "pTuijian");
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