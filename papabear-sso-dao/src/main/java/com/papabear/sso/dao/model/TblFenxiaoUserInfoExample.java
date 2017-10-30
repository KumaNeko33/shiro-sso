package com.papabear.sso.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblFenxiaoUserInfoExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public TblFenxiaoUserInfoExample() {
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

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorIsNull() {
            addCriterion("is_superior is null");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorIsNotNull() {
            addCriterion("is_superior is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorEqualTo(Byte value) {
            addCriterion("is_superior =", value, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorNotEqualTo(Byte value) {
            addCriterion("is_superior <>", value, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorGreaterThan(Byte value) {
            addCriterion("is_superior >", value, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_superior >=", value, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorLessThan(Byte value) {
            addCriterion("is_superior <", value, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorLessThanOrEqualTo(Byte value) {
            addCriterion("is_superior <=", value, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorIn(List<Byte> values) {
            addCriterion("is_superior in", values, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorNotIn(List<Byte> values) {
            addCriterion("is_superior not in", values, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorBetween(Byte value1, Byte value2) {
            addCriterion("is_superior between", value1, value2, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIsSuperiorNotBetween(Byte value1, Byte value2) {
            addCriterion("is_superior not between", value1, value2, "isSuperior");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdIsNull() {
            addCriterion("introducer_id is null");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdIsNotNull() {
            addCriterion("introducer_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdEqualTo(Long value) {
            addCriterion("introducer_id =", value, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdNotEqualTo(Long value) {
            addCriterion("introducer_id <>", value, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdGreaterThan(Long value) {
            addCriterion("introducer_id >", value, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("introducer_id >=", value, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdLessThan(Long value) {
            addCriterion("introducer_id <", value, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdLessThanOrEqualTo(Long value) {
            addCriterion("introducer_id <=", value, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdIn(List<Long> values) {
            addCriterion("introducer_id in", values, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdNotIn(List<Long> values) {
            addCriterion("introducer_id not in", values, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdBetween(Long value1, Long value2) {
            addCriterion("introducer_id between", value1, value2, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIntroducerIdNotBetween(Long value1, Long value2) {
            addCriterion("introducer_id not between", value1, value2, "introducerId");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedIsNull() {
            addCriterion("is_certified is null");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedIsNotNull() {
            addCriterion("is_certified is not null");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedEqualTo(Byte value) {
            addCriterion("is_certified =", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedNotEqualTo(Byte value) {
            addCriterion("is_certified <>", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedGreaterThan(Byte value) {
            addCriterion("is_certified >", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_certified >=", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedLessThan(Byte value) {
            addCriterion("is_certified <", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedLessThanOrEqualTo(Byte value) {
            addCriterion("is_certified <=", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedIn(List<Byte> values) {
            addCriterion("is_certified in", values, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedNotIn(List<Byte> values) {
            addCriterion("is_certified not in", values, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedBetween(Byte value1, Byte value2) {
            addCriterion("is_certified between", value1, value2, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_certified not between", value1, value2, "isCertified");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Float value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Float value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Float value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Float value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Float value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Float> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Float> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Float value1, Float value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Float value1, Float value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyIsNull() {
            addCriterion("confirm_money is null");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyIsNotNull() {
            addCriterion("confirm_money is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyEqualTo(Float value) {
            addCriterion("confirm_money =", value, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyNotEqualTo(Float value) {
            addCriterion("confirm_money <>", value, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyGreaterThan(Float value) {
            addCriterion("confirm_money >", value, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("confirm_money >=", value, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyLessThan(Float value) {
            addCriterion("confirm_money <", value, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyLessThanOrEqualTo(Float value) {
            addCriterion("confirm_money <=", value, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyIn(List<Float> values) {
            addCriterion("confirm_money in", values, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyNotIn(List<Float> values) {
            addCriterion("confirm_money not in", values, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyBetween(Float value1, Float value2) {
            addCriterion("confirm_money between", value1, value2, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andConfirmMoneyNotBetween(Float value1, Float value2) {
            addCriterion("confirm_money not between", value1, value2, "confirmMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyIsNull() {
            addCriterion("usable_money is null");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyIsNotNull() {
            addCriterion("usable_money is not null");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyEqualTo(Float value) {
            addCriterion("usable_money =", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotEqualTo(Float value) {
            addCriterion("usable_money <>", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyGreaterThan(Float value) {
            addCriterion("usable_money >", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("usable_money >=", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyLessThan(Float value) {
            addCriterion("usable_money <", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyLessThanOrEqualTo(Float value) {
            addCriterion("usable_money <=", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyIn(List<Float> values) {
            addCriterion("usable_money in", values, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotIn(List<Float> values) {
            addCriterion("usable_money not in", values, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyBetween(Float value1, Float value2) {
            addCriterion("usable_money between", value1, value2, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotBetween(Float value1, Float value2) {
            addCriterion("usable_money not between", value1, value2, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyIsNull() {
            addCriterion("last_money is null");
            return (Criteria) this;
        }

        public Criteria andLastMoneyIsNotNull() {
            addCriterion("last_money is not null");
            return (Criteria) this;
        }

        public Criteria andLastMoneyEqualTo(Float value) {
            addCriterion("last_money =", value, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyNotEqualTo(Float value) {
            addCriterion("last_money <>", value, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyGreaterThan(Float value) {
            addCriterion("last_money >", value, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("last_money >=", value, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyLessThan(Float value) {
            addCriterion("last_money <", value, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyLessThanOrEqualTo(Float value) {
            addCriterion("last_money <=", value, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyIn(List<Float> values) {
            addCriterion("last_money in", values, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyNotIn(List<Float> values) {
            addCriterion("last_money not in", values, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyBetween(Float value1, Float value2) {
            addCriterion("last_money between", value1, value2, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andLastMoneyNotBetween(Float value1, Float value2) {
            addCriterion("last_money not between", value1, value2, "lastMoney");
            return (Criteria) this;
        }

        public Criteria andOriginIsNull() {
            addCriterion("origin is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("origin is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(Byte value) {
            addCriterion("origin =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(Byte value) {
            addCriterion("origin <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(Byte value) {
            addCriterion("origin >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(Byte value) {
            addCriterion("origin >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(Byte value) {
            addCriterion("origin <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(Byte value) {
            addCriterion("origin <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<Byte> values) {
            addCriterion("origin in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<Byte> values) {
            addCriterion("origin not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(Byte value1, Byte value2) {
            addCriterion("origin between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(Byte value1, Byte value2) {
            addCriterion("origin not between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdIsNull() {
            addCriterion("mall_grade_id is null");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdIsNotNull() {
            addCriterion("mall_grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdEqualTo(Long value) {
            addCriterion("mall_grade_id =", value, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdNotEqualTo(Long value) {
            addCriterion("mall_grade_id <>", value, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdGreaterThan(Long value) {
            addCriterion("mall_grade_id >", value, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mall_grade_id >=", value, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdLessThan(Long value) {
            addCriterion("mall_grade_id <", value, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdLessThanOrEqualTo(Long value) {
            addCriterion("mall_grade_id <=", value, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdIn(List<Long> values) {
            addCriterion("mall_grade_id in", values, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdNotIn(List<Long> values) {
            addCriterion("mall_grade_id not in", values, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdBetween(Long value1, Long value2) {
            addCriterion("mall_grade_id between", value1, value2, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeIdNotBetween(Long value1, Long value2) {
            addCriterion("mall_grade_id not between", value1, value2, "mallGradeId");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameIsNull() {
            addCriterion("mall_grade_name is null");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameIsNotNull() {
            addCriterion("mall_grade_name is not null");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameEqualTo(String value) {
            addCriterion("mall_grade_name =", value, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameNotEqualTo(String value) {
            addCriterion("mall_grade_name <>", value, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameGreaterThan(String value) {
            addCriterion("mall_grade_name >", value, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("mall_grade_name >=", value, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameLessThan(String value) {
            addCriterion("mall_grade_name <", value, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameLessThanOrEqualTo(String value) {
            addCriterion("mall_grade_name <=", value, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameLike(String value) {
            addCriterion("mall_grade_name like", value, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameNotLike(String value) {
            addCriterion("mall_grade_name not like", value, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameIn(List<String> values) {
            addCriterion("mall_grade_name in", values, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameNotIn(List<String> values) {
            addCriterion("mall_grade_name not in", values, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameBetween(String value1, String value2) {
            addCriterion("mall_grade_name between", value1, value2, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andMallGradeNameNotBetween(String value1, String value2) {
            addCriterion("mall_grade_name not between", value1, value2, "mallGradeName");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNull() {
            addCriterion("bank_number is null");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNotNull() {
            addCriterion("bank_number is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumberEqualTo(String value) {
            addCriterion("bank_number =", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotEqualTo(String value) {
            addCriterion("bank_number <>", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThan(String value) {
            addCriterion("bank_number >", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThanOrEqualTo(String value) {
            addCriterion("bank_number >=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThan(String value) {
            addCriterion("bank_number <", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThanOrEqualTo(String value) {
            addCriterion("bank_number <=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLike(String value) {
            addCriterion("bank_number like", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotLike(String value) {
            addCriterion("bank_number not like", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberIn(List<String> values) {
            addCriterion("bank_number in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotIn(List<String> values) {
            addCriterion("bank_number not in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberBetween(String value1, String value2) {
            addCriterion("bank_number between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotBetween(String value1, String value2) {
            addCriterion("bank_number not between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumberEqualTo(String value) {
            addCriterion("card_number =", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotEqualTo(String value) {
            addCriterion("card_number <>", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThan(String value) {
            addCriterion("card_number >", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("card_number >=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThan(String value) {
            addCriterion("card_number <", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThanOrEqualTo(String value) {
            addCriterion("card_number <=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLike(String value) {
            addCriterion("card_number like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotLike(String value) {
            addCriterion("card_number not like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIn(List<String> values) {
            addCriterion("card_number in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotIn(List<String> values) {
            addCriterion("card_number not in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberBetween(String value1, String value2) {
            addCriterion("card_number between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotBetween(String value1, String value2) {
            addCriterion("card_number not between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberIsNull() {
            addCriterion("ali_pay_number is null");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberIsNotNull() {
            addCriterion("ali_pay_number is not null");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberEqualTo(String value) {
            addCriterion("ali_pay_number =", value, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberNotEqualTo(String value) {
            addCriterion("ali_pay_number <>", value, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberGreaterThan(String value) {
            addCriterion("ali_pay_number >", value, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ali_pay_number >=", value, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberLessThan(String value) {
            addCriterion("ali_pay_number <", value, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberLessThanOrEqualTo(String value) {
            addCriterion("ali_pay_number <=", value, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberLike(String value) {
            addCriterion("ali_pay_number like", value, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberNotLike(String value) {
            addCriterion("ali_pay_number not like", value, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberIn(List<String> values) {
            addCriterion("ali_pay_number in", values, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberNotIn(List<String> values) {
            addCriterion("ali_pay_number not in", values, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberBetween(String value1, String value2) {
            addCriterion("ali_pay_number between", value1, value2, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andAliPayNumberNotBetween(String value1, String value2) {
            addCriterion("ali_pay_number not between", value1, value2, "aliPayNumber");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNull() {
            addCriterion("create_date_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNotNull() {
            addCriterion("create_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeEqualTo(Date value) {
            addCriterion("create_date_time =", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotEqualTo(Date value) {
            addCriterion("create_date_time <>", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThan(Date value) {
            addCriterion("create_date_time >", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date_time >=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThan(Date value) {
            addCriterion("create_date_time <", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_date_time <=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIn(List<Date> values) {
            addCriterion("create_date_time in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotIn(List<Date> values) {
            addCriterion("create_date_time not in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("create_date_time between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_date_time not between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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