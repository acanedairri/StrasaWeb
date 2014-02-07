package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class StudyVariableExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public StudyVariableExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table studyvariable
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

		public Criteria andVariablecodeIsNull() {
			addCriterion("variablecode is null");
			return (Criteria) this;
		}

		public Criteria andVariablecodeIsNotNull() {
			addCriterion("variablecode is not null");
			return (Criteria) this;
		}

		public Criteria andVariablecodeEqualTo(String value) {
			addCriterion("variablecode =", value, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeNotEqualTo(String value) {
			addCriterion("variablecode <>", value, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeGreaterThan(String value) {
			addCriterion("variablecode >", value, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeGreaterThanOrEqualTo(String value) {
			addCriterion("variablecode >=", value, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeLessThan(String value) {
			addCriterion("variablecode <", value, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeLessThanOrEqualTo(String value) {
			addCriterion("variablecode <=", value, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeLike(String value) {
			addCriterion("variablecode like", value, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeNotLike(String value) {
			addCriterion("variablecode not like", value, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeIn(List<String> values) {
			addCriterion("variablecode in", values, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeNotIn(List<String> values) {
			addCriterion("variablecode not in", values, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeBetween(String value1, String value2) {
			addCriterion("variablecode between", value1, value2, "variablecode");
			return (Criteria) this;
		}

		public Criteria andVariablecodeNotBetween(String value1, String value2) {
			addCriterion("variablecode not between", value1, value2,
					"variablecode");
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

		public Criteria andPropertyIsNull() {
			addCriterion("property is null");
			return (Criteria) this;
		}

		public Criteria andPropertyIsNotNull() {
			addCriterion("property is not null");
			return (Criteria) this;
		}

		public Criteria andPropertyEqualTo(String value) {
			addCriterion("property =", value, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyNotEqualTo(String value) {
			addCriterion("property <>", value, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyGreaterThan(String value) {
			addCriterion("property >", value, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyGreaterThanOrEqualTo(String value) {
			addCriterion("property >=", value, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyLessThan(String value) {
			addCriterion("property <", value, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyLessThanOrEqualTo(String value) {
			addCriterion("property <=", value, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyLike(String value) {
			addCriterion("property like", value, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyNotLike(String value) {
			addCriterion("property not like", value, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyIn(List<String> values) {
			addCriterion("property in", values, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyNotIn(List<String> values) {
			addCriterion("property not in", values, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyBetween(String value1, String value2) {
			addCriterion("property between", value1, value2, "property");
			return (Criteria) this;
		}

		public Criteria andPropertyNotBetween(String value1, String value2) {
			addCriterion("property not between", value1, value2, "property");
			return (Criteria) this;
		}

		public Criteria andMethodIsNull() {
			addCriterion("method is null");
			return (Criteria) this;
		}

		public Criteria andMethodIsNotNull() {
			addCriterion("method is not null");
			return (Criteria) this;
		}

		public Criteria andMethodEqualTo(String value) {
			addCriterion("method =", value, "method");
			return (Criteria) this;
		}

		public Criteria andMethodNotEqualTo(String value) {
			addCriterion("method <>", value, "method");
			return (Criteria) this;
		}

		public Criteria andMethodGreaterThan(String value) {
			addCriterion("method >", value, "method");
			return (Criteria) this;
		}

		public Criteria andMethodGreaterThanOrEqualTo(String value) {
			addCriterion("method >=", value, "method");
			return (Criteria) this;
		}

		public Criteria andMethodLessThan(String value) {
			addCriterion("method <", value, "method");
			return (Criteria) this;
		}

		public Criteria andMethodLessThanOrEqualTo(String value) {
			addCriterion("method <=", value, "method");
			return (Criteria) this;
		}

		public Criteria andMethodLike(String value) {
			addCriterion("method like", value, "method");
			return (Criteria) this;
		}

		public Criteria andMethodNotLike(String value) {
			addCriterion("method not like", value, "method");
			return (Criteria) this;
		}

		public Criteria andMethodIn(List<String> values) {
			addCriterion("method in", values, "method");
			return (Criteria) this;
		}

		public Criteria andMethodNotIn(List<String> values) {
			addCriterion("method not in", values, "method");
			return (Criteria) this;
		}

		public Criteria andMethodBetween(String value1, String value2) {
			addCriterion("method between", value1, value2, "method");
			return (Criteria) this;
		}

		public Criteria andMethodNotBetween(String value1, String value2) {
			addCriterion("method not between", value1, value2, "method");
			return (Criteria) this;
		}

		public Criteria andScaleIsNull() {
			addCriterion("scale is null");
			return (Criteria) this;
		}

		public Criteria andScaleIsNotNull() {
			addCriterion("scale is not null");
			return (Criteria) this;
		}

		public Criteria andScaleEqualTo(String value) {
			addCriterion("scale =", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleNotEqualTo(String value) {
			addCriterion("scale <>", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleGreaterThan(String value) {
			addCriterion("scale >", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleGreaterThanOrEqualTo(String value) {
			addCriterion("scale >=", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleLessThan(String value) {
			addCriterion("scale <", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleLessThanOrEqualTo(String value) {
			addCriterion("scale <=", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleLike(String value) {
			addCriterion("scale like", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleNotLike(String value) {
			addCriterion("scale not like", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleIn(List<String> values) {
			addCriterion("scale in", values, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleNotIn(List<String> values) {
			addCriterion("scale not in", values, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleBetween(String value1, String value2) {
			addCriterion("scale between", value1, value2, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleNotBetween(String value1, String value2) {
			addCriterion("scale not between", value1, value2, "scale");
			return (Criteria) this;
		}

		public Criteria andApplytofilterIsNull() {
			addCriterion("applytofilter is null");
			return (Criteria) this;
		}

		public Criteria andApplytofilterIsNotNull() {
			addCriterion("applytofilter is not null");
			return (Criteria) this;
		}

		public Criteria andApplytofilterEqualTo(String value) {
			addCriterion("applytofilter =", value, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterNotEqualTo(String value) {
			addCriterion("applytofilter <>", value, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterGreaterThan(String value) {
			addCriterion("applytofilter >", value, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterGreaterThanOrEqualTo(String value) {
			addCriterion("applytofilter >=", value, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterLessThan(String value) {
			addCriterion("applytofilter <", value, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterLessThanOrEqualTo(String value) {
			addCriterion("applytofilter <=", value, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterLike(String value) {
			addCriterion("applytofilter like", value, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterNotLike(String value) {
			addCriterion("applytofilter not like", value, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterIn(List<String> values) {
			addCriterion("applytofilter in", values, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterNotIn(List<String> values) {
			addCriterion("applytofilter not in", values, "applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterBetween(String value1, String value2) {
			addCriterion("applytofilter between", value1, value2,
					"applytofilter");
			return (Criteria) this;
		}

		public Criteria andApplytofilterNotBetween(String value1, String value2) {
			addCriterion("applytofilter not between", value1, value2,
					"applytofilter");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnIsNull() {
			addCriterion("defaultcolumn is null");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnIsNotNull() {
			addCriterion("defaultcolumn is not null");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnEqualTo(String value) {
			addCriterion("defaultcolumn =", value, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnNotEqualTo(String value) {
			addCriterion("defaultcolumn <>", value, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnGreaterThan(String value) {
			addCriterion("defaultcolumn >", value, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnGreaterThanOrEqualTo(String value) {
			addCriterion("defaultcolumn >=", value, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnLessThan(String value) {
			addCriterion("defaultcolumn <", value, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnLessThanOrEqualTo(String value) {
			addCriterion("defaultcolumn <=", value, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnLike(String value) {
			addCriterion("defaultcolumn like", value, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnNotLike(String value) {
			addCriterion("defaultcolumn not like", value, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnIn(List<String> values) {
			addCriterion("defaultcolumn in", values, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnNotIn(List<String> values) {
			addCriterion("defaultcolumn not in", values, "defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnBetween(String value1, String value2) {
			addCriterion("defaultcolumn between", value1, value2,
					"defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDefaultcolumnNotBetween(String value1, String value2) {
			addCriterion("defaultcolumn not between", value1, value2,
					"defaultcolumn");
			return (Criteria) this;
		}

		public Criteria andDatatypeIsNull() {
			addCriterion("datatype is null");
			return (Criteria) this;
		}

		public Criteria andDatatypeIsNotNull() {
			addCriterion("datatype is not null");
			return (Criteria) this;
		}

		public Criteria andDatatypeEqualTo(String value) {
			addCriterion("datatype =", value, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeNotEqualTo(String value) {
			addCriterion("datatype <>", value, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeGreaterThan(String value) {
			addCriterion("datatype >", value, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeGreaterThanOrEqualTo(String value) {
			addCriterion("datatype >=", value, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeLessThan(String value) {
			addCriterion("datatype <", value, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeLessThanOrEqualTo(String value) {
			addCriterion("datatype <=", value, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeLike(String value) {
			addCriterion("datatype like", value, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeNotLike(String value) {
			addCriterion("datatype not like", value, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeIn(List<String> values) {
			addCriterion("datatype in", values, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeNotIn(List<String> values) {
			addCriterion("datatype not in", values, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeBetween(String value1, String value2) {
			addCriterion("datatype between", value1, value2, "datatype");
			return (Criteria) this;
		}

		public Criteria andDatatypeNotBetween(String value1, String value2) {
			addCriterion("datatype not between", value1, value2, "datatype");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table studyvariable
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
     * This class corresponds to the database table studyvariable
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}