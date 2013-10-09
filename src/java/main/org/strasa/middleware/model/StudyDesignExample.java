package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class StudyDesignExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public StudyDesignExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
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

        public Criteria andStudysiteidIsNull() {
            addCriterion("studysiteid is null");
            return (Criteria) this;
        }

        public Criteria andStudysiteidIsNotNull() {
            addCriterion("studysiteid is not null");
            return (Criteria) this;
        }

        public Criteria andStudysiteidEqualTo(Integer value) {
            addCriterion("studysiteid =", value, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidNotEqualTo(Integer value) {
            addCriterion("studysiteid <>", value, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidGreaterThan(Integer value) {
            addCriterion("studysiteid >", value, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studysiteid >=", value, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidLessThan(Integer value) {
            addCriterion("studysiteid <", value, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidLessThanOrEqualTo(Integer value) {
            addCriterion("studysiteid <=", value, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidIn(List<Integer> values) {
            addCriterion("studysiteid in", values, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidNotIn(List<Integer> values) {
            addCriterion("studysiteid not in", values, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidBetween(Integer value1, Integer value2) {
            addCriterion("studysiteid between", value1, value2, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andStudysiteidNotBetween(Integer value1, Integer value2) {
            addCriterion("studysiteid not between", value1, value2, "studysiteid");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureIsNull() {
            addCriterion("treatmentstructure is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureIsNotNull() {
            addCriterion("treatmentstructure is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureEqualTo(String value) {
            addCriterion("treatmentstructure =", value, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureNotEqualTo(String value) {
            addCriterion("treatmentstructure <>", value, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureGreaterThan(String value) {
            addCriterion("treatmentstructure >", value, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureGreaterThanOrEqualTo(String value) {
            addCriterion("treatmentstructure >=", value, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureLessThan(String value) {
            addCriterion("treatmentstructure <", value, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureLessThanOrEqualTo(String value) {
            addCriterion("treatmentstructure <=", value, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureLike(String value) {
            addCriterion("treatmentstructure like", value, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureNotLike(String value) {
            addCriterion("treatmentstructure not like", value, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureIn(List<String> values) {
            addCriterion("treatmentstructure in", values, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureNotIn(List<String> values) {
            addCriterion("treatmentstructure not in", values, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureBetween(String value1, String value2) {
            addCriterion("treatmentstructure between", value1, value2, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andTreatmentstructureNotBetween(String value1, String value2) {
            addCriterion("treatmentstructure not between", value1, value2, "treatmentstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureIsNull() {
            addCriterion("designstructure is null");
            return (Criteria) this;
        }

        public Criteria andDesignstructureIsNotNull() {
            addCriterion("designstructure is not null");
            return (Criteria) this;
        }

        public Criteria andDesignstructureEqualTo(String value) {
            addCriterion("designstructure =", value, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureNotEqualTo(String value) {
            addCriterion("designstructure <>", value, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureGreaterThan(String value) {
            addCriterion("designstructure >", value, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureGreaterThanOrEqualTo(String value) {
            addCriterion("designstructure >=", value, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureLessThan(String value) {
            addCriterion("designstructure <", value, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureLessThanOrEqualTo(String value) {
            addCriterion("designstructure <=", value, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureLike(String value) {
            addCriterion("designstructure like", value, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureNotLike(String value) {
            addCriterion("designstructure not like", value, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureIn(List<String> values) {
            addCriterion("designstructure in", values, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureNotIn(List<String> values) {
            addCriterion("designstructure not in", values, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureBetween(String value1, String value2) {
            addCriterion("designstructure between", value1, value2, "designstructure");
            return (Criteria) this;
        }

        public Criteria andDesignstructureNotBetween(String value1, String value2) {
            addCriterion("designstructure not between", value1, value2, "designstructure");
            return (Criteria) this;
        }

        public Criteria andPlotsizeIsNull() {
            addCriterion("plotsize is null");
            return (Criteria) this;
        }

        public Criteria andPlotsizeIsNotNull() {
            addCriterion("plotsize is not null");
            return (Criteria) this;
        }

        public Criteria andPlotsizeEqualTo(String value) {
            addCriterion("plotsize =", value, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeNotEqualTo(String value) {
            addCriterion("plotsize <>", value, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeGreaterThan(String value) {
            addCriterion("plotsize >", value, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeGreaterThanOrEqualTo(String value) {
            addCriterion("plotsize >=", value, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeLessThan(String value) {
            addCriterion("plotsize <", value, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeLessThanOrEqualTo(String value) {
            addCriterion("plotsize <=", value, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeLike(String value) {
            addCriterion("plotsize like", value, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeNotLike(String value) {
            addCriterion("plotsize not like", value, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeIn(List<String> values) {
            addCriterion("plotsize in", values, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeNotIn(List<String> values) {
            addCriterion("plotsize not in", values, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeBetween(String value1, String value2) {
            addCriterion("plotsize between", value1, value2, "plotsize");
            return (Criteria) this;
        }

        public Criteria andPlotsizeNotBetween(String value1, String value2) {
            addCriterion("plotsize not between", value1, value2, "plotsize");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table studydesign
     *
     * @mbggenerated do_not_delete_during_merge Wed Oct 09 16:20:41 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table studydesign
     *
     * @mbggenerated Wed Oct 09 16:20:41 SGT 2013
     */
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