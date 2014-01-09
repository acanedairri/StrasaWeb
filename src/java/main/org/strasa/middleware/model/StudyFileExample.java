package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class StudyFileExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public StudyFileExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
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

		public Criteria andStudyidIsNull() {
			addCriterion("studyid is null");
			return (Criteria) this;
		}

		public Criteria andStudyidIsNotNull() {
			addCriterion("studyid is not null");
			return (Criteria) this;
		}

		public Criteria andStudyidEqualTo(Integer value) {
			addCriterion("studyid =", value, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidNotEqualTo(Integer value) {
			addCriterion("studyid <>", value, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidGreaterThan(Integer value) {
			addCriterion("studyid >", value, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidGreaterThanOrEqualTo(Integer value) {
			addCriterion("studyid >=", value, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidLessThan(Integer value) {
			addCriterion("studyid <", value, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidLessThanOrEqualTo(Integer value) {
			addCriterion("studyid <=", value, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidIn(List<Integer> values) {
			addCriterion("studyid in", values, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidNotIn(List<Integer> values) {
			addCriterion("studyid not in", values, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidBetween(Integer value1, Integer value2) {
			addCriterion("studyid between", value1, value2, "studyid");
			return (Criteria) this;
		}

		public Criteria andStudyidNotBetween(Integer value1, Integer value2) {
			addCriterion("studyid not between", value1, value2, "studyid");
			return (Criteria) this;
		}

		public Criteria andFilenameIsNull() {
			addCriterion("filename is null");
			return (Criteria) this;
		}

		public Criteria andFilenameIsNotNull() {
			addCriterion("filename is not null");
			return (Criteria) this;
		}

		public Criteria andFilenameEqualTo(String value) {
			addCriterion("filename =", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameNotEqualTo(String value) {
			addCriterion("filename <>", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameGreaterThan(String value) {
			addCriterion("filename >", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameGreaterThanOrEqualTo(String value) {
			addCriterion("filename >=", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameLessThan(String value) {
			addCriterion("filename <", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameLessThanOrEqualTo(String value) {
			addCriterion("filename <=", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameLike(String value) {
			addCriterion("filename like", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameNotLike(String value) {
			addCriterion("filename not like", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameIn(List<String> values) {
			addCriterion("filename in", values, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameNotIn(List<String> values) {
			addCriterion("filename not in", values, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameBetween(String value1, String value2) {
			addCriterion("filename between", value1, value2, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameNotBetween(String value1, String value2) {
			addCriterion("filename not between", value1, value2, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenamegenIsNull() {
			addCriterion("filenamegen is null");
			return (Criteria) this;
		}

		public Criteria andFilenamegenIsNotNull() {
			addCriterion("filenamegen is not null");
			return (Criteria) this;
		}

		public Criteria andFilenamegenEqualTo(String value) {
			addCriterion("filenamegen =", value, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenNotEqualTo(String value) {
			addCriterion("filenamegen <>", value, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenGreaterThan(String value) {
			addCriterion("filenamegen >", value, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenGreaterThanOrEqualTo(String value) {
			addCriterion("filenamegen >=", value, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenLessThan(String value) {
			addCriterion("filenamegen <", value, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenLessThanOrEqualTo(String value) {
			addCriterion("filenamegen <=", value, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenLike(String value) {
			addCriterion("filenamegen like", value, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenNotLike(String value) {
			addCriterion("filenamegen not like", value, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenIn(List<String> values) {
			addCriterion("filenamegen in", values, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenNotIn(List<String> values) {
			addCriterion("filenamegen not in", values, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenBetween(String value1, String value2) {
			addCriterion("filenamegen between", value1, value2, "filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilenamegenNotBetween(String value1, String value2) {
			addCriterion("filenamegen not between", value1, value2,
					"filenamegen");
			return (Criteria) this;
		}

		public Criteria andFilepathIsNull() {
			addCriterion("filepath is null");
			return (Criteria) this;
		}

		public Criteria andFilepathIsNotNull() {
			addCriterion("filepath is not null");
			return (Criteria) this;
		}

		public Criteria andFilepathEqualTo(String value) {
			addCriterion("filepath =", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathNotEqualTo(String value) {
			addCriterion("filepath <>", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathGreaterThan(String value) {
			addCriterion("filepath >", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathGreaterThanOrEqualTo(String value) {
			addCriterion("filepath >=", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathLessThan(String value) {
			addCriterion("filepath <", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathLessThanOrEqualTo(String value) {
			addCriterion("filepath <=", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathLike(String value) {
			addCriterion("filepath like", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathNotLike(String value) {
			addCriterion("filepath not like", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathIn(List<String> values) {
			addCriterion("filepath in", values, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathNotIn(List<String> values) {
			addCriterion("filepath not in", values, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathBetween(String value1, String value2) {
			addCriterion("filepath between", value1, value2, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathNotBetween(String value1, String value2) {
			addCriterion("filepath not between", value1, value2, "filepath");
			return (Criteria) this;
		}

		public Criteria andTypeofdataIsNull() {
			addCriterion("typeofdata is null");
			return (Criteria) this;
		}

		public Criteria andTypeofdataIsNotNull() {
			addCriterion("typeofdata is not null");
			return (Criteria) this;
		}

		public Criteria andTypeofdataEqualTo(String value) {
			addCriterion("typeofdata =", value, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataNotEqualTo(String value) {
			addCriterion("typeofdata <>", value, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataGreaterThan(String value) {
			addCriterion("typeofdata >", value, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataGreaterThanOrEqualTo(String value) {
			addCriterion("typeofdata >=", value, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataLessThan(String value) {
			addCriterion("typeofdata <", value, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataLessThanOrEqualTo(String value) {
			addCriterion("typeofdata <=", value, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataLike(String value) {
			addCriterion("typeofdata like", value, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataNotLike(String value) {
			addCriterion("typeofdata not like", value, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataIn(List<String> values) {
			addCriterion("typeofdata in", values, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataNotIn(List<String> values) {
			addCriterion("typeofdata not in", values, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataBetween(String value1, String value2) {
			addCriterion("typeofdata between", value1, value2, "typeofdata");
			return (Criteria) this;
		}

		public Criteria andTypeofdataNotBetween(String value1, String value2) {
			addCriterion("typeofdata not between", value1, value2, "typeofdata");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table studyfile
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
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
     * This class corresponds to the database table studyfile
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}