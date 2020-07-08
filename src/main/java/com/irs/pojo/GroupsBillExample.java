package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class GroupsBillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupsBillExample() {
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

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(String value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(String value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(String value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(String value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(String value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(String value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLike(String value) {
            addCriterion("o_id like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotLike(String value) {
            addCriterion("o_id not like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<String> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<String> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(String value1, String value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(String value1, String value2) {
            addCriterion("o_id not between", value1, value2, "oId");
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

        public Criteria andGCreatetimeIsNull() {
            addCriterion("g_createtime is null");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeIsNotNull() {
            addCriterion("g_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeEqualTo(String value) {
            addCriterion("g_createtime =", value, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeNotEqualTo(String value) {
            addCriterion("g_createtime <>", value, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeGreaterThan(String value) {
            addCriterion("g_createtime >", value, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("g_createtime >=", value, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeLessThan(String value) {
            addCriterion("g_createtime <", value, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("g_createtime <=", value, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeLike(String value) {
            addCriterion("g_createtime like", value, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeNotLike(String value) {
            addCriterion("g_createtime not like", value, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeIn(List<String> values) {
            addCriterion("g_createtime in", values, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeNotIn(List<String> values) {
            addCriterion("g_createtime not in", values, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeBetween(String value1, String value2) {
            addCriterion("g_createtime between", value1, value2, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGCreatetimeNotBetween(String value1, String value2) {
            addCriterion("g_createtime not between", value1, value2, "gCreatetime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeIsNull() {
            addCriterion("g_endtime is null");
            return (Criteria) this;
        }

        public Criteria andGEndtimeIsNotNull() {
            addCriterion("g_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andGEndtimeEqualTo(String value) {
            addCriterion("g_endtime =", value, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeNotEqualTo(String value) {
            addCriterion("g_endtime <>", value, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeGreaterThan(String value) {
            addCriterion("g_endtime >", value, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("g_endtime >=", value, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeLessThan(String value) {
            addCriterion("g_endtime <", value, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeLessThanOrEqualTo(String value) {
            addCriterion("g_endtime <=", value, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeLike(String value) {
            addCriterion("g_endtime like", value, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeNotLike(String value) {
            addCriterion("g_endtime not like", value, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeIn(List<String> values) {
            addCriterion("g_endtime in", values, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeNotIn(List<String> values) {
            addCriterion("g_endtime not in", values, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeBetween(String value1, String value2) {
            addCriterion("g_endtime between", value1, value2, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andGEndtimeNotBetween(String value1, String value2) {
            addCriterion("g_endtime not between", value1, value2, "gEndtime");
            return (Criteria) this;
        }

        public Criteria andAValidityIsNull() {
            addCriterion("a_validity is null");
            return (Criteria) this;
        }

        public Criteria andAValidityIsNotNull() {
            addCriterion("a_validity is not null");
            return (Criteria) this;
        }

        public Criteria andAValidityEqualTo(Integer value) {
            addCriterion("a_validity =", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityNotEqualTo(Integer value) {
            addCriterion("a_validity <>", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityGreaterThan(Integer value) {
            addCriterion("a_validity >", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_validity >=", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityLessThan(Integer value) {
            addCriterion("a_validity <", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityLessThanOrEqualTo(Integer value) {
            addCriterion("a_validity <=", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityIn(List<Integer> values) {
            addCriterion("a_validity in", values, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityNotIn(List<Integer> values) {
            addCriterion("a_validity not in", values, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityBetween(Integer value1, Integer value2) {
            addCriterion("a_validity between", value1, value2, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityNotBetween(Integer value1, Integer value2) {
            addCriterion("a_validity not between", value1, value2, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAMemberIsNull() {
            addCriterion("a_member is null");
            return (Criteria) this;
        }

        public Criteria andAMemberIsNotNull() {
            addCriterion("a_member is not null");
            return (Criteria) this;
        }

        public Criteria andAMemberEqualTo(Integer value) {
            addCriterion("a_member =", value, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberNotEqualTo(Integer value) {
            addCriterion("a_member <>", value, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberGreaterThan(Integer value) {
            addCriterion("a_member >", value, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_member >=", value, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberLessThan(Integer value) {
            addCriterion("a_member <", value, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberLessThanOrEqualTo(Integer value) {
            addCriterion("a_member <=", value, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberIn(List<Integer> values) {
            addCriterion("a_member in", values, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberNotIn(List<Integer> values) {
            addCriterion("a_member not in", values, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberBetween(Integer value1, Integer value2) {
            addCriterion("a_member between", value1, value2, "aMember");
            return (Criteria) this;
        }

        public Criteria andAMemberNotBetween(Integer value1, Integer value2) {
            addCriterion("a_member not between", value1, value2, "aMember");
            return (Criteria) this;
        }

        public Criteria andACanjiaIsNull() {
            addCriterion("a_canjia is null");
            return (Criteria) this;
        }

        public Criteria andACanjiaIsNotNull() {
            addCriterion("a_canjia is not null");
            return (Criteria) this;
        }

        public Criteria andACanjiaEqualTo(Integer value) {
            addCriterion("a_canjia =", value, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaNotEqualTo(Integer value) {
            addCriterion("a_canjia <>", value, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaGreaterThan(Integer value) {
            addCriterion("a_canjia >", value, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_canjia >=", value, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaLessThan(Integer value) {
            addCriterion("a_canjia <", value, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaLessThanOrEqualTo(Integer value) {
            addCriterion("a_canjia <=", value, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaIn(List<Integer> values) {
            addCriterion("a_canjia in", values, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaNotIn(List<Integer> values) {
            addCriterion("a_canjia not in", values, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaBetween(Integer value1, Integer value2) {
            addCriterion("a_canjia between", value1, value2, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andACanjiaNotBetween(Integer value1, Integer value2) {
            addCriterion("a_canjia not between", value1, value2, "aCanjia");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andColonelIsNull() {
            addCriterion("colonel is null");
            return (Criteria) this;
        }

        public Criteria andColonelIsNotNull() {
            addCriterion("colonel is not null");
            return (Criteria) this;
        }

        public Criteria andColonelEqualTo(Integer value) {
            addCriterion("colonel =", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelNotEqualTo(Integer value) {
            addCriterion("colonel <>", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelGreaterThan(Integer value) {
            addCriterion("colonel >", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelGreaterThanOrEqualTo(Integer value) {
            addCriterion("colonel >=", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelLessThan(Integer value) {
            addCriterion("colonel <", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelLessThanOrEqualTo(Integer value) {
            addCriterion("colonel <=", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelIn(List<Integer> values) {
            addCriterion("colonel in", values, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelNotIn(List<Integer> values) {
            addCriterion("colonel not in", values, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelBetween(Integer value1, Integer value2) {
            addCriterion("colonel between", value1, value2, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelNotBetween(Integer value1, Integer value2) {
            addCriterion("colonel not between", value1, value2, "colonel");
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

        public Criteria andBIdIsNull() {
            addCriterion("b_id is null");
            return (Criteria) this;
        }

        public Criteria andBIdIsNotNull() {
            addCriterion("b_id is not null");
            return (Criteria) this;
        }

        public Criteria andBIdEqualTo(Integer value) {
            addCriterion("b_id =", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotEqualTo(Integer value) {
            addCriterion("b_id <>", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThan(Integer value) {
            addCriterion("b_id >", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_id >=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThan(Integer value) {
            addCriterion("b_id <", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_id <=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdIn(List<Integer> values) {
            addCriterion("b_id in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotIn(List<Integer> values) {
            addCriterion("b_id not in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdBetween(Integer value1, Integer value2) {
            addCriterion("b_id between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_id not between", value1, value2, "bId");
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