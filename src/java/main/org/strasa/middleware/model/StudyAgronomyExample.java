package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudyAgronomyExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public StudyAgronomyExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
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

		protected void addCriterionForJDBCDate(String condition, Date value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()),
					property);
		}

		protected void addCriterionForJDBCDate(String condition,
				List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1,
				Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()),
					new java.sql.Date(value2.getTime()), property);
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
			addCriterion("studysiteid not between", value1, value2,
					"studysiteid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidIsNull() {
			addCriterion("plantingtypeid is null");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidIsNotNull() {
			addCriterion("plantingtypeid is not null");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidEqualTo(Integer value) {
			addCriterion("plantingtypeid =", value, "plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidNotEqualTo(Integer value) {
			addCriterion("plantingtypeid <>", value, "plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidGreaterThan(Integer value) {
			addCriterion("plantingtypeid >", value, "plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidGreaterThanOrEqualTo(Integer value) {
			addCriterion("plantingtypeid >=", value, "plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidLessThan(Integer value) {
			addCriterion("plantingtypeid <", value, "plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidLessThanOrEqualTo(Integer value) {
			addCriterion("plantingtypeid <=", value, "plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidIn(List<Integer> values) {
			addCriterion("plantingtypeid in", values, "plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidNotIn(List<Integer> values) {
			addCriterion("plantingtypeid not in", values, "plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidBetween(Integer value1, Integer value2) {
			addCriterion("plantingtypeid between", value1, value2,
					"plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andPlantingtypeidNotBetween(Integer value1,
				Integer value2) {
			addCriterion("plantingtypeid not between", value1, value2,
					"plantingtypeid");
			return (Criteria) this;
		}

		public Criteria andSowingdateIsNull() {
			addCriterion("sowingdate is null");
			return (Criteria) this;
		}

		public Criteria andSowingdateIsNotNull() {
			addCriterion("sowingdate is not null");
			return (Criteria) this;
		}

		public Criteria andSowingdateEqualTo(Date value) {
			addCriterionForJDBCDate("sowingdate =", value, "sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateNotEqualTo(Date value) {
			addCriterionForJDBCDate("sowingdate <>", value, "sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateGreaterThan(Date value) {
			addCriterionForJDBCDate("sowingdate >", value, "sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("sowingdate >=", value, "sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateLessThan(Date value) {
			addCriterionForJDBCDate("sowingdate <", value, "sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("sowingdate <=", value, "sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateIn(List<Date> values) {
			addCriterionForJDBCDate("sowingdate in", values, "sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateNotIn(List<Date> values) {
			addCriterionForJDBCDate("sowingdate not in", values, "sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("sowingdate between", value1, value2,
					"sowingdate");
			return (Criteria) this;
		}

		public Criteria andSowingdateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("sowingdate not between", value1, value2,
					"sowingdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateIsNull() {
			addCriterion("harvestdate is null");
			return (Criteria) this;
		}

		public Criteria andHarvestdateIsNotNull() {
			addCriterion("harvestdate is not null");
			return (Criteria) this;
		}

		public Criteria andHarvestdateEqualTo(Date value) {
			addCriterionForJDBCDate("harvestdate =", value, "harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateNotEqualTo(Date value) {
			addCriterionForJDBCDate("harvestdate <>", value, "harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateGreaterThan(Date value) {
			addCriterionForJDBCDate("harvestdate >", value, "harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("harvestdate >=", value, "harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateLessThan(Date value) {
			addCriterionForJDBCDate("harvestdate <", value, "harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("harvestdate <=", value, "harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateIn(List<Date> values) {
			addCriterionForJDBCDate("harvestdate in", values, "harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateNotIn(List<Date> values) {
			addCriterionForJDBCDate("harvestdate not in", values, "harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("harvestdate between", value1, value2,
					"harvestdate");
			return (Criteria) this;
		}

		public Criteria andHarvestdateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("harvestdate not between", value1, value2,
					"harvestdate");
			return (Criteria) this;
		}

		public Criteria andFertilizationIsNull() {
			addCriterion("fertilization is null");
			return (Criteria) this;
		}

		public Criteria andFertilizationIsNotNull() {
			addCriterion("fertilization is not null");
			return (Criteria) this;
		}

		public Criteria andFertilizationEqualTo(String value) {
			addCriterion("fertilization =", value, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationNotEqualTo(String value) {
			addCriterion("fertilization <>", value, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationGreaterThan(String value) {
			addCriterion("fertilization >", value, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationGreaterThanOrEqualTo(String value) {
			addCriterion("fertilization >=", value, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationLessThan(String value) {
			addCriterion("fertilization <", value, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationLessThanOrEqualTo(String value) {
			addCriterion("fertilization <=", value, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationLike(String value) {
			addCriterion("fertilization like", value, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationNotLike(String value) {
			addCriterion("fertilization not like", value, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationIn(List<String> values) {
			addCriterion("fertilization in", values, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationNotIn(List<String> values) {
			addCriterion("fertilization not in", values, "fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationBetween(String value1, String value2) {
			addCriterion("fertilization between", value1, value2,
					"fertilization");
			return (Criteria) this;
		}

		public Criteria andFertilizationNotBetween(String value1, String value2) {
			addCriterion("fertilization not between", value1, value2,
					"fertilization");
			return (Criteria) this;
		}

		public Criteria andDensityIsNull() {
			addCriterion("density is null");
			return (Criteria) this;
		}

		public Criteria andDensityIsNotNull() {
			addCriterion("density is not null");
			return (Criteria) this;
		}

		public Criteria andDensityEqualTo(String value) {
			addCriterion("density =", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityNotEqualTo(String value) {
			addCriterion("density <>", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityGreaterThan(String value) {
			addCriterion("density >", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityGreaterThanOrEqualTo(String value) {
			addCriterion("density >=", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityLessThan(String value) {
			addCriterion("density <", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityLessThanOrEqualTo(String value) {
			addCriterion("density <=", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityLike(String value) {
			addCriterion("density like", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityNotLike(String value) {
			addCriterion("density not like", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityIn(List<String> values) {
			addCriterion("density in", values, "density");
			return (Criteria) this;
		}

		public Criteria andDensityNotIn(List<String> values) {
			addCriterion("density not in", values, "density");
			return (Criteria) this;
		}

		public Criteria andDensityBetween(String value1, String value2) {
			addCriterion("density between", value1, value2, "density");
			return (Criteria) this;
		}

		public Criteria andDensityNotBetween(String value1, String value2) {
			addCriterion("density not between", value1, value2, "density");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table studyagronomy
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
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
     * This class corresponds to the database table studyagronomy
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}