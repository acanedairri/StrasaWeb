package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class StudyExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public StudyExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andUseridIsNull() {
			addCriterion("userid is null");
			return (Criteria) this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("userid is not null");
			return (Criteria) this;
		}

		public Criteria andUseridEqualTo(Integer value) {
			addCriterion("userid =", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotEqualTo(Integer value) {
			addCriterion("userid <>", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThan(Integer value) {
			addCriterion("userid >", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("userid >=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThan(Integer value) {
			addCriterion("userid <", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThanOrEqualTo(Integer value) {
			addCriterion("userid <=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridIn(List<Integer> values) {
			addCriterion("userid in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotIn(List<Integer> values) {
			addCriterion("userid not in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridBetween(Integer value1, Integer value2) {
			addCriterion("userid between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("userid not between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andProgramidIsNull() {
			addCriterion("programid is null");
			return (Criteria) this;
		}

		public Criteria andProgramidIsNotNull() {
			addCriterion("programid is not null");
			return (Criteria) this;
		}

		public Criteria andProgramidEqualTo(Integer value) {
			addCriterion("programid =", value, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidNotEqualTo(Integer value) {
			addCriterion("programid <>", value, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidGreaterThan(Integer value) {
			addCriterion("programid >", value, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidGreaterThanOrEqualTo(Integer value) {
			addCriterion("programid >=", value, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidLessThan(Integer value) {
			addCriterion("programid <", value, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidLessThanOrEqualTo(Integer value) {
			addCriterion("programid <=", value, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidIn(List<Integer> values) {
			addCriterion("programid in", values, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidNotIn(List<Integer> values) {
			addCriterion("programid not in", values, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidBetween(Integer value1, Integer value2) {
			addCriterion("programid between", value1, value2, "programid");
			return (Criteria) this;
		}

		public Criteria andProgramidNotBetween(Integer value1, Integer value2) {
			addCriterion("programid not between", value1, value2, "programid");
			return (Criteria) this;
		}

		public Criteria andProjectidIsNull() {
			addCriterion("projectid is null");
			return (Criteria) this;
		}

		public Criteria andProjectidIsNotNull() {
			addCriterion("projectid is not null");
			return (Criteria) this;
		}

		public Criteria andProjectidEqualTo(Integer value) {
			addCriterion("projectid =", value, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidNotEqualTo(Integer value) {
			addCriterion("projectid <>", value, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidGreaterThan(Integer value) {
			addCriterion("projectid >", value, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidGreaterThanOrEqualTo(Integer value) {
			addCriterion("projectid >=", value, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidLessThan(Integer value) {
			addCriterion("projectid <", value, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidLessThanOrEqualTo(Integer value) {
			addCriterion("projectid <=", value, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidIn(List<Integer> values) {
			addCriterion("projectid in", values, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidNotIn(List<Integer> values) {
			addCriterion("projectid not in", values, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidBetween(Integer value1, Integer value2) {
			addCriterion("projectid between", value1, value2, "projectid");
			return (Criteria) this;
		}

		public Criteria andProjectidNotBetween(Integer value1, Integer value2) {
			addCriterion("projectid not between", value1, value2, "projectid");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2,
					"description");
			return (Criteria) this;
		}

		public Criteria andStudytypeidIsNull() {
			addCriterion("studytypeid is null");
			return (Criteria) this;
		}

		public Criteria andStudytypeidIsNotNull() {
			addCriterion("studytypeid is not null");
			return (Criteria) this;
		}

		public Criteria andStudytypeidEqualTo(Integer value) {
			addCriterion("studytypeid =", value, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidNotEqualTo(Integer value) {
			addCriterion("studytypeid <>", value, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidGreaterThan(Integer value) {
			addCriterion("studytypeid >", value, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidGreaterThanOrEqualTo(Integer value) {
			addCriterion("studytypeid >=", value, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidLessThan(Integer value) {
			addCriterion("studytypeid <", value, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidLessThanOrEqualTo(Integer value) {
			addCriterion("studytypeid <=", value, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidIn(List<Integer> values) {
			addCriterion("studytypeid in", values, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidNotIn(List<Integer> values) {
			addCriterion("studytypeid not in", values, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidBetween(Integer value1, Integer value2) {
			addCriterion("studytypeid between", value1, value2, "studytypeid");
			return (Criteria) this;
		}

		public Criteria andStudytypeidNotBetween(Integer value1, Integer value2) {
			addCriterion("studytypeid not between", value1, value2,
					"studytypeid");
			return (Criteria) this;
		}

		public Criteria andStartyearIsNull() {
			addCriterion("startyear is null");
			return (Criteria) this;
		}

		public Criteria andStartyearIsNotNull() {
			addCriterion("startyear is not null");
			return (Criteria) this;
		}

		public Criteria andStartyearEqualTo(String value) {
			addCriterion("startyear =", value, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearNotEqualTo(String value) {
			addCriterion("startyear <>", value, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearGreaterThan(String value) {
			addCriterion("startyear >", value, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearGreaterThanOrEqualTo(String value) {
			addCriterion("startyear >=", value, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearLessThan(String value) {
			addCriterion("startyear <", value, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearLessThanOrEqualTo(String value) {
			addCriterion("startyear <=", value, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearLike(String value) {
			addCriterion("startyear like", value, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearNotLike(String value) {
			addCriterion("startyear not like", value, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearIn(List<String> values) {
			addCriterion("startyear in", values, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearNotIn(List<String> values) {
			addCriterion("startyear not in", values, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearBetween(String value1, String value2) {
			addCriterion("startyear between", value1, value2, "startyear");
			return (Criteria) this;
		}

		public Criteria andStartyearNotBetween(String value1, String value2) {
			addCriterion("startyear not between", value1, value2, "startyear");
			return (Criteria) this;
		}

		public Criteria andEndyearIsNull() {
			addCriterion("endyear is null");
			return (Criteria) this;
		}

		public Criteria andEndyearIsNotNull() {
			addCriterion("endyear is not null");
			return (Criteria) this;
		}

		public Criteria andEndyearEqualTo(String value) {
			addCriterion("endyear =", value, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearNotEqualTo(String value) {
			addCriterion("endyear <>", value, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearGreaterThan(String value) {
			addCriterion("endyear >", value, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearGreaterThanOrEqualTo(String value) {
			addCriterion("endyear >=", value, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearLessThan(String value) {
			addCriterion("endyear <", value, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearLessThanOrEqualTo(String value) {
			addCriterion("endyear <=", value, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearLike(String value) {
			addCriterion("endyear like", value, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearNotLike(String value) {
			addCriterion("endyear not like", value, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearIn(List<String> values) {
			addCriterion("endyear in", values, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearNotIn(List<String> values) {
			addCriterion("endyear not in", values, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearBetween(String value1, String value2) {
			addCriterion("endyear between", value1, value2, "endyear");
			return (Criteria) this;
		}

		public Criteria andEndyearNotBetween(String value1, String value2) {
			addCriterion("endyear not between", value1, value2, "endyear");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNull() {
			addCriterion("remarks is null");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNotNull() {
			addCriterion("remarks is not null");
			return (Criteria) this;
		}

		public Criteria andRemarksEqualTo(String value) {
			addCriterion("remarks =", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotEqualTo(String value) {
			addCriterion("remarks <>", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThan(String value) {
			addCriterion("remarks >", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThanOrEqualTo(String value) {
			addCriterion("remarks >=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThan(String value) {
			addCriterion("remarks <", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThanOrEqualTo(String value) {
			addCriterion("remarks <=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLike(String value) {
			addCriterion("remarks like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotLike(String value) {
			addCriterion("remarks not like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksIn(List<String> values) {
			addCriterion("remarks in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotIn(List<String> values) {
			addCriterion("remarks not in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksBetween(String value1, String value2) {
			addCriterion("remarks between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotBetween(String value1, String value2) {
			addCriterion("remarks not between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andSharedIsNull() {
			addCriterion("shared is null");
			return (Criteria) this;
		}

		public Criteria andSharedIsNotNull() {
			addCriterion("shared is not null");
			return (Criteria) this;
		}

		public Criteria andSharedEqualTo(Boolean value) {
			addCriterion("shared =", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedNotEqualTo(Boolean value) {
			addCriterion("shared <>", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedGreaterThan(Boolean value) {
			addCriterion("shared >", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("shared >=", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedLessThan(Boolean value) {
			addCriterion("shared <", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedLessThanOrEqualTo(Boolean value) {
			addCriterion("shared <=", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedIn(List<Boolean> values) {
			addCriterion("shared in", values, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedNotIn(List<Boolean> values) {
			addCriterion("shared not in", values, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedBetween(Boolean value1, Boolean value2) {
			addCriterion("shared between", value1, value2, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("shared not between", value1, value2, "shared");
			return (Criteria) this;
		}

		public Criteria andDatecreatedIsNull() {
			addCriterion("datecreated is null");
			return (Criteria) this;
		}

		public Criteria andDatecreatedIsNotNull() {
			addCriterion("datecreated is not null");
			return (Criteria) this;
		}

		public Criteria andDatecreatedEqualTo(Date value) {
			addCriterion("datecreated =", value, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedNotEqualTo(Date value) {
			addCriterion("datecreated <>", value, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedGreaterThan(Date value) {
			addCriterion("datecreated >", value, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedGreaterThanOrEqualTo(Date value) {
			addCriterion("datecreated >=", value, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedLessThan(Date value) {
			addCriterion("datecreated <", value, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedLessThanOrEqualTo(Date value) {
			addCriterion("datecreated <=", value, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedIn(List<Date> values) {
			addCriterion("datecreated in", values, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedNotIn(List<Date> values) {
			addCriterion("datecreated not in", values, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedBetween(Date value1, Date value2) {
			addCriterion("datecreated between", value1, value2, "datecreated");
			return (Criteria) this;
		}

		public Criteria andDatecreatedNotBetween(Date value1, Date value2) {
			addCriterion("datecreated not between", value1, value2,
					"datecreated");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedIsNull() {
			addCriterion("datelastmodified is null");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedIsNotNull() {
			addCriterion("datelastmodified is not null");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedEqualTo(Date value) {
			addCriterion("datelastmodified =", value, "datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedNotEqualTo(Date value) {
			addCriterion("datelastmodified <>", value, "datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedGreaterThan(Date value) {
			addCriterion("datelastmodified >", value, "datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedGreaterThanOrEqualTo(Date value) {
			addCriterion("datelastmodified >=", value, "datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedLessThan(Date value) {
			addCriterion("datelastmodified <", value, "datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedLessThanOrEqualTo(Date value) {
			addCriterion("datelastmodified <=", value, "datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedIn(List<Date> values) {
			addCriterion("datelastmodified in", values, "datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedNotIn(List<Date> values) {
			addCriterion("datelastmodified not in", values, "datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedBetween(Date value1, Date value2) {
			addCriterion("datelastmodified between", value1, value2,
					"datelastmodified");
			return (Criteria) this;
		}

		public Criteria andDatelastmodifiedNotBetween(Date value1, Date value2) {
			addCriterion("datelastmodified not between", value1, value2,
					"datelastmodified");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table study
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table study
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}