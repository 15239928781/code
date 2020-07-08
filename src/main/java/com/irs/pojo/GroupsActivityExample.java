package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class GroupsActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupsActivityExample() {
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

        public Criteria andACeatetimeIsNull() {
            addCriterion("a_ceatetime is null");
            return (Criteria) this;
        }

        public Criteria andACeatetimeIsNotNull() {
            addCriterion("a_ceatetime is not null");
            return (Criteria) this;
        }

        public Criteria andACeatetimeEqualTo(String value) {
            addCriterion("a_ceatetime =", value, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeNotEqualTo(String value) {
            addCriterion("a_ceatetime <>", value, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeGreaterThan(String value) {
            addCriterion("a_ceatetime >", value, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("a_ceatetime >=", value, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeLessThan(String value) {
            addCriterion("a_ceatetime <", value, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeLessThanOrEqualTo(String value) {
            addCriterion("a_ceatetime <=", value, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeLike(String value) {
            addCriterion("a_ceatetime like", value, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeNotLike(String value) {
            addCriterion("a_ceatetime not like", value, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeIn(List<String> values) {
            addCriterion("a_ceatetime in", values, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeNotIn(List<String> values) {
            addCriterion("a_ceatetime not in", values, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeBetween(String value1, String value2) {
            addCriterion("a_ceatetime between", value1, value2, "aCeatetime");
            return (Criteria) this;
        }

        public Criteria andACeatetimeNotBetween(String value1, String value2) {
            addCriterion("a_ceatetime not between", value1, value2, "aCeatetime");
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

        public Criteria andAValidityEqualTo(String value) {
            addCriterion("a_validity =", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityNotEqualTo(String value) {
            addCriterion("a_validity <>", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityGreaterThan(String value) {
            addCriterion("a_validity >", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityGreaterThanOrEqualTo(String value) {
            addCriterion("a_validity >=", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityLessThan(String value) {
            addCriterion("a_validity <", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityLessThanOrEqualTo(String value) {
            addCriterion("a_validity <=", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityLike(String value) {
            addCriterion("a_validity like", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityNotLike(String value) {
            addCriterion("a_validity not like", value, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityIn(List<String> values) {
            addCriterion("a_validity in", values, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityNotIn(List<String> values) {
            addCriterion("a_validity not in", values, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityBetween(String value1, String value2) {
            addCriterion("a_validity between", value1, value2, "aValidity");
            return (Criteria) this;
        }

        public Criteria andAValidityNotBetween(String value1, String value2) {
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

        public Criteria andADescIsNull() {
            addCriterion("a_desc is null");
            return (Criteria) this;
        }

        public Criteria andADescIsNotNull() {
            addCriterion("a_desc is not null");
            return (Criteria) this;
        }

        public Criteria andADescEqualTo(String value) {
            addCriterion("a_desc =", value, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescNotEqualTo(String value) {
            addCriterion("a_desc <>", value, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescGreaterThan(String value) {
            addCriterion("a_desc >", value, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescGreaterThanOrEqualTo(String value) {
            addCriterion("a_desc >=", value, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescLessThan(String value) {
            addCriterion("a_desc <", value, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescLessThanOrEqualTo(String value) {
            addCriterion("a_desc <=", value, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescLike(String value) {
            addCriterion("a_desc like", value, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescNotLike(String value) {
            addCriterion("a_desc not like", value, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescIn(List<String> values) {
            addCriterion("a_desc in", values, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescNotIn(List<String> values) {
            addCriterion("a_desc not in", values, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescBetween(String value1, String value2) {
            addCriterion("a_desc between", value1, value2, "aDesc");
            return (Criteria) this;
        }

        public Criteria andADescNotBetween(String value1, String value2) {
            addCriterion("a_desc not between", value1, value2, "aDesc");
            return (Criteria) this;
        }

        public Criteria andASortIsNull() {
            addCriterion("a_sort is null");
            return (Criteria) this;
        }

        public Criteria andASortIsNotNull() {
            addCriterion("a_sort is not null");
            return (Criteria) this;
        }

        public Criteria andASortEqualTo(Integer value) {
            addCriterion("a_sort =", value, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortNotEqualTo(Integer value) {
            addCriterion("a_sort <>", value, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortGreaterThan(Integer value) {
            addCriterion("a_sort >", value, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_sort >=", value, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortLessThan(Integer value) {
            addCriterion("a_sort <", value, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortLessThanOrEqualTo(Integer value) {
            addCriterion("a_sort <=", value, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortIn(List<Integer> values) {
            addCriterion("a_sort in", values, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortNotIn(List<Integer> values) {
            addCriterion("a_sort not in", values, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortBetween(Integer value1, Integer value2) {
            addCriterion("a_sort between", value1, value2, "aSort");
            return (Criteria) this;
        }

        public Criteria andASortNotBetween(Integer value1, Integer value2) {
            addCriterion("a_sort not between", value1, value2, "aSort");
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