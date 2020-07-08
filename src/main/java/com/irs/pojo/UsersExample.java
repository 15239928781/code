package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
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

        public Criteria andUTelIsNull() {
            addCriterion("u_tel is null");
            return (Criteria) this;
        }

        public Criteria andUTelIsNotNull() {
            addCriterion("u_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUTelEqualTo(String value) {
            addCriterion("u_tel =", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelNotEqualTo(String value) {
            addCriterion("u_tel <>", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelGreaterThan(String value) {
            addCriterion("u_tel >", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelGreaterThanOrEqualTo(String value) {
            addCriterion("u_tel >=", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelLessThan(String value) {
            addCriterion("u_tel <", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelLessThanOrEqualTo(String value) {
            addCriterion("u_tel <=", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelLike(String value) {
            addCriterion("u_tel like", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelNotLike(String value) {
            addCriterion("u_tel not like", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelIn(List<String> values) {
            addCriterion("u_tel in", values, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelNotIn(List<String> values) {
            addCriterion("u_tel not in", values, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelBetween(String value1, String value2) {
            addCriterion("u_tel between", value1, value2, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelNotBetween(String value1, String value2) {
            addCriterion("u_tel not between", value1, value2, "uTel");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNull() {
            addCriterion("u_password is null");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNotNull() {
            addCriterion("u_password is not null");
            return (Criteria) this;
        }

        public Criteria andUPasswordEqualTo(String value) {
            addCriterion("u_password =", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotEqualTo(String value) {
            addCriterion("u_password <>", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThan(String value) {
            addCriterion("u_password >", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("u_password >=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThan(String value) {
            addCriterion("u_password <", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThanOrEqualTo(String value) {
            addCriterion("u_password <=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLike(String value) {
            addCriterion("u_password like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotLike(String value) {
            addCriterion("u_password not like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordIn(List<String> values) {
            addCriterion("u_password in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotIn(List<String> values) {
            addCriterion("u_password not in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordBetween(String value1, String value2) {
            addCriterion("u_password between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotBetween(String value1, String value2) {
            addCriterion("u_password not between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUSexIsNull() {
            addCriterion("u_sex is null");
            return (Criteria) this;
        }

        public Criteria andUSexIsNotNull() {
            addCriterion("u_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUSexEqualTo(String value) {
            addCriterion("u_sex =", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotEqualTo(String value) {
            addCriterion("u_sex <>", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThan(String value) {
            addCriterion("u_sex >", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThanOrEqualTo(String value) {
            addCriterion("u_sex >=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThan(String value) {
            addCriterion("u_sex <", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThanOrEqualTo(String value) {
            addCriterion("u_sex <=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLike(String value) {
            addCriterion("u_sex like", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotLike(String value) {
            addCriterion("u_sex not like", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexIn(List<String> values) {
            addCriterion("u_sex in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotIn(List<String> values) {
            addCriterion("u_sex not in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexBetween(String value1, String value2) {
            addCriterion("u_sex between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotBetween(String value1, String value2) {
            addCriterion("u_sex not between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUBirthdayIsNull() {
            addCriterion("u_birthday is null");
            return (Criteria) this;
        }

        public Criteria andUBirthdayIsNotNull() {
            addCriterion("u_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andUBirthdayEqualTo(String value) {
            addCriterion("u_birthday =", value, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayNotEqualTo(String value) {
            addCriterion("u_birthday <>", value, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayGreaterThan(String value) {
            addCriterion("u_birthday >", value, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("u_birthday >=", value, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayLessThan(String value) {
            addCriterion("u_birthday <", value, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayLessThanOrEqualTo(String value) {
            addCriterion("u_birthday <=", value, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayLike(String value) {
            addCriterion("u_birthday like", value, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayNotLike(String value) {
            addCriterion("u_birthday not like", value, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayIn(List<String> values) {
            addCriterion("u_birthday in", values, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayNotIn(List<String> values) {
            addCriterion("u_birthday not in", values, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayBetween(String value1, String value2) {
            addCriterion("u_birthday between", value1, value2, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUBirthdayNotBetween(String value1, String value2) {
            addCriterion("u_birthday not between", value1, value2, "uBirthday");
            return (Criteria) this;
        }

        public Criteria andUImgIsNull() {
            addCriterion("u_img is null");
            return (Criteria) this;
        }

        public Criteria andUImgIsNotNull() {
            addCriterion("u_img is not null");
            return (Criteria) this;
        }

        public Criteria andUImgEqualTo(String value) {
            addCriterion("u_img =", value, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgNotEqualTo(String value) {
            addCriterion("u_img <>", value, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgGreaterThan(String value) {
            addCriterion("u_img >", value, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgGreaterThanOrEqualTo(String value) {
            addCriterion("u_img >=", value, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgLessThan(String value) {
            addCriterion("u_img <", value, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgLessThanOrEqualTo(String value) {
            addCriterion("u_img <=", value, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgLike(String value) {
            addCriterion("u_img like", value, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgNotLike(String value) {
            addCriterion("u_img not like", value, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgIn(List<String> values) {
            addCriterion("u_img in", values, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgNotIn(List<String> values) {
            addCriterion("u_img not in", values, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgBetween(String value1, String value2) {
            addCriterion("u_img between", value1, value2, "uImg");
            return (Criteria) this;
        }

        public Criteria andUImgNotBetween(String value1, String value2) {
            addCriterion("u_img not between", value1, value2, "uImg");
            return (Criteria) this;
        }

        public Criteria andUStatusIsNull() {
            addCriterion("u_status is null");
            return (Criteria) this;
        }

        public Criteria andUStatusIsNotNull() {
            addCriterion("u_status is not null");
            return (Criteria) this;
        }

        public Criteria andUStatusEqualTo(Integer value) {
            addCriterion("u_status =", value, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusNotEqualTo(Integer value) {
            addCriterion("u_status <>", value, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusGreaterThan(Integer value) {
            addCriterion("u_status >", value, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_status >=", value, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusLessThan(Integer value) {
            addCriterion("u_status <", value, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusLessThanOrEqualTo(Integer value) {
            addCriterion("u_status <=", value, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusIn(List<Integer> values) {
            addCriterion("u_status in", values, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusNotIn(List<Integer> values) {
            addCriterion("u_status not in", values, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusBetween(Integer value1, Integer value2) {
            addCriterion("u_status between", value1, value2, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("u_status not between", value1, value2, "uStatus");
            return (Criteria) this;
        }

        public Criteria andUIntroductionIsNull() {
            addCriterion("u_Introduction is null");
            return (Criteria) this;
        }

        public Criteria andUIntroductionIsNotNull() {
            addCriterion("u_Introduction is not null");
            return (Criteria) this;
        }

        public Criteria andUIntroductionEqualTo(String value) {
            addCriterion("u_Introduction =", value, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionNotEqualTo(String value) {
            addCriterion("u_Introduction <>", value, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionGreaterThan(String value) {
            addCriterion("u_Introduction >", value, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("u_Introduction >=", value, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionLessThan(String value) {
            addCriterion("u_Introduction <", value, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionLessThanOrEqualTo(String value) {
            addCriterion("u_Introduction <=", value, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionLike(String value) {
            addCriterion("u_Introduction like", value, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionNotLike(String value) {
            addCriterion("u_Introduction not like", value, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionIn(List<String> values) {
            addCriterion("u_Introduction in", values, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionNotIn(List<String> values) {
            addCriterion("u_Introduction not in", values, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionBetween(String value1, String value2) {
            addCriterion("u_Introduction between", value1, value2, "uIntroduction");
            return (Criteria) this;
        }

        public Criteria andUIntroductionNotBetween(String value1, String value2) {
            addCriterion("u_Introduction not between", value1, value2, "uIntroduction");
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

        public Criteria andUIntegralIsNull() {
            addCriterion("u_integral is null");
            return (Criteria) this;
        }

        public Criteria andUIntegralIsNotNull() {
            addCriterion("u_integral is not null");
            return (Criteria) this;
        }

        public Criteria andUIntegralEqualTo(Integer value) {
            addCriterion("u_integral =", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralNotEqualTo(Integer value) {
            addCriterion("u_integral <>", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralGreaterThan(Integer value) {
            addCriterion("u_integral >", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_integral >=", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralLessThan(Integer value) {
            addCriterion("u_integral <", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("u_integral <=", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralIn(List<Integer> values) {
            addCriterion("u_integral in", values, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralNotIn(List<Integer> values) {
            addCriterion("u_integral not in", values, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralBetween(Integer value1, Integer value2) {
            addCriterion("u_integral between", value1, value2, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("u_integral not between", value1, value2, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andULevelIsNull() {
            addCriterion("u_level is null");
            return (Criteria) this;
        }

        public Criteria andULevelIsNotNull() {
            addCriterion("u_level is not null");
            return (Criteria) this;
        }

        public Criteria andULevelEqualTo(Integer value) {
            addCriterion("u_level =", value, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelNotEqualTo(Integer value) {
            addCriterion("u_level <>", value, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelGreaterThan(Integer value) {
            addCriterion("u_level >", value, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_level >=", value, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelLessThan(Integer value) {
            addCriterion("u_level <", value, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelLessThanOrEqualTo(Integer value) {
            addCriterion("u_level <=", value, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelIn(List<Integer> values) {
            addCriterion("u_level in", values, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelNotIn(List<Integer> values) {
            addCriterion("u_level not in", values, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelBetween(Integer value1, Integer value2) {
            addCriterion("u_level between", value1, value2, "uLevel");
            return (Criteria) this;
        }

        public Criteria andULevelNotBetween(Integer value1, Integer value2) {
            addCriterion("u_level not between", value1, value2, "uLevel");
            return (Criteria) this;
        }

        public Criteria andUWxcodeIsNull() {
            addCriterion("u_wxcode is null");
            return (Criteria) this;
        }

        public Criteria andUWxcodeIsNotNull() {
            addCriterion("u_wxcode is not null");
            return (Criteria) this;
        }

        public Criteria andUWxcodeEqualTo(String value) {
            addCriterion("u_wxcode =", value, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeNotEqualTo(String value) {
            addCriterion("u_wxcode <>", value, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeGreaterThan(String value) {
            addCriterion("u_wxcode >", value, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeGreaterThanOrEqualTo(String value) {
            addCriterion("u_wxcode >=", value, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeLessThan(String value) {
            addCriterion("u_wxcode <", value, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeLessThanOrEqualTo(String value) {
            addCriterion("u_wxcode <=", value, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeLike(String value) {
            addCriterion("u_wxcode like", value, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeNotLike(String value) {
            addCriterion("u_wxcode not like", value, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeIn(List<String> values) {
            addCriterion("u_wxcode in", values, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeNotIn(List<String> values) {
            addCriterion("u_wxcode not in", values, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeBetween(String value1, String value2) {
            addCriterion("u_wxcode between", value1, value2, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUWxcodeNotBetween(String value1, String value2) {
            addCriterion("u_wxcode not between", value1, value2, "uWxcode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeIsNull() {
            addCriterion("u_myinvitecode is null");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeIsNotNull() {
            addCriterion("u_myinvitecode is not null");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeEqualTo(String value) {
            addCriterion("u_myinvitecode =", value, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeNotEqualTo(String value) {
            addCriterion("u_myinvitecode <>", value, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeGreaterThan(String value) {
            addCriterion("u_myinvitecode >", value, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeGreaterThanOrEqualTo(String value) {
            addCriterion("u_myinvitecode >=", value, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeLessThan(String value) {
            addCriterion("u_myinvitecode <", value, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeLessThanOrEqualTo(String value) {
            addCriterion("u_myinvitecode <=", value, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeLike(String value) {
            addCriterion("u_myinvitecode like", value, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeNotLike(String value) {
            addCriterion("u_myinvitecode not like", value, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeIn(List<String> values) {
            addCriterion("u_myinvitecode in", values, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeNotIn(List<String> values) {
            addCriterion("u_myinvitecode not in", values, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeBetween(String value1, String value2) {
            addCriterion("u_myinvitecode between", value1, value2, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andUMyinvitecodeNotBetween(String value1, String value2) {
            addCriterion("u_myinvitecode not between", value1, value2, "uMyinvitecode");
            return (Criteria) this;
        }

        public Criteria andURealnameIsNull() {
            addCriterion("u_realname is null");
            return (Criteria) this;
        }

        public Criteria andURealnameIsNotNull() {
            addCriterion("u_realname is not null");
            return (Criteria) this;
        }

        public Criteria andURealnameEqualTo(String value) {
            addCriterion("u_realname =", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotEqualTo(String value) {
            addCriterion("u_realname <>", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameGreaterThan(String value) {
            addCriterion("u_realname >", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameGreaterThanOrEqualTo(String value) {
            addCriterion("u_realname >=", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLessThan(String value) {
            addCriterion("u_realname <", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLessThanOrEqualTo(String value) {
            addCriterion("u_realname <=", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLike(String value) {
            addCriterion("u_realname like", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotLike(String value) {
            addCriterion("u_realname not like", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameIn(List<String> values) {
            addCriterion("u_realname in", values, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotIn(List<String> values) {
            addCriterion("u_realname not in", values, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameBetween(String value1, String value2) {
            addCriterion("u_realname between", value1, value2, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotBetween(String value1, String value2) {
            addCriterion("u_realname not between", value1, value2, "uRealname");
            return (Criteria) this;
        }

        public Criteria andULableIsNull() {
            addCriterion("u_lable is null");
            return (Criteria) this;
        }

        public Criteria andULableIsNotNull() {
            addCriterion("u_lable is not null");
            return (Criteria) this;
        }

        public Criteria andULableEqualTo(String value) {
            addCriterion("u_lable =", value, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableNotEqualTo(String value) {
            addCriterion("u_lable <>", value, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableGreaterThan(String value) {
            addCriterion("u_lable >", value, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableGreaterThanOrEqualTo(String value) {
            addCriterion("u_lable >=", value, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableLessThan(String value) {
            addCriterion("u_lable <", value, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableLessThanOrEqualTo(String value) {
            addCriterion("u_lable <=", value, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableLike(String value) {
            addCriterion("u_lable like", value, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableNotLike(String value) {
            addCriterion("u_lable not like", value, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableIn(List<String> values) {
            addCriterion("u_lable in", values, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableNotIn(List<String> values) {
            addCriterion("u_lable not in", values, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableBetween(String value1, String value2) {
            addCriterion("u_lable between", value1, value2, "uLable");
            return (Criteria) this;
        }

        public Criteria andULableNotBetween(String value1, String value2) {
            addCriterion("u_lable not between", value1, value2, "uLable");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeIsNull() {
            addCriterion("u_invitecode is null");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeIsNotNull() {
            addCriterion("u_invitecode is not null");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeEqualTo(String value) {
            addCriterion("u_invitecode =", value, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeNotEqualTo(String value) {
            addCriterion("u_invitecode <>", value, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeGreaterThan(String value) {
            addCriterion("u_invitecode >", value, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeGreaterThanOrEqualTo(String value) {
            addCriterion("u_invitecode >=", value, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeLessThan(String value) {
            addCriterion("u_invitecode <", value, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeLessThanOrEqualTo(String value) {
            addCriterion("u_invitecode <=", value, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeLike(String value) {
            addCriterion("u_invitecode like", value, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeNotLike(String value) {
            addCriterion("u_invitecode not like", value, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeIn(List<String> values) {
            addCriterion("u_invitecode in", values, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeNotIn(List<String> values) {
            addCriterion("u_invitecode not in", values, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeBetween(String value1, String value2) {
            addCriterion("u_invitecode between", value1, value2, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUInvitecodeNotBetween(String value1, String value2) {
            addCriterion("u_invitecode not between", value1, value2, "uInvitecode");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeIsNull() {
            addCriterion("u_createtime is null");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeIsNotNull() {
            addCriterion("u_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeEqualTo(String value) {
            addCriterion("u_createtime =", value, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeNotEqualTo(String value) {
            addCriterion("u_createtime <>", value, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeGreaterThan(String value) {
            addCriterion("u_createtime >", value, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("u_createtime >=", value, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeLessThan(String value) {
            addCriterion("u_createtime <", value, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("u_createtime <=", value, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeLike(String value) {
            addCriterion("u_createtime like", value, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeNotLike(String value) {
            addCriterion("u_createtime not like", value, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeIn(List<String> values) {
            addCriterion("u_createtime in", values, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeNotIn(List<String> values) {
            addCriterion("u_createtime not in", values, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeBetween(String value1, String value2) {
            addCriterion("u_createtime between", value1, value2, "uCreatetime");
            return (Criteria) this;
        }

        public Criteria andUCreatetimeNotBetween(String value1, String value2) {
            addCriterion("u_createtime not between", value1, value2, "uCreatetime");
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