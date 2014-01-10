package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class ExtensionDataExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public ExtensionDataExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Thu Jan 09 09:44:59 SGT 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table extensiondata
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

		public Criteria andGermplasmnameIsNull() {
			addCriterion("germplasmname is null");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameIsNotNull() {
			addCriterion("germplasmname is not null");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameEqualTo(String value) {
			addCriterion("germplasmname =", value, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameNotEqualTo(String value) {
			addCriterion("germplasmname <>", value, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameGreaterThan(String value) {
			addCriterion("germplasmname >", value, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameGreaterThanOrEqualTo(String value) {
			addCriterion("germplasmname >=", value, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameLessThan(String value) {
			addCriterion("germplasmname <", value, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameLessThanOrEqualTo(String value) {
			addCriterion("germplasmname <=", value, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameLike(String value) {
			addCriterion("germplasmname like", value, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameNotLike(String value) {
			addCriterion("germplasmname not like", value, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameIn(List<String> values) {
			addCriterion("germplasmname in", values, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameNotIn(List<String> values) {
			addCriterion("germplasmname not in", values, "germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameBetween(String value1, String value2) {
			addCriterion("germplasmname between", value1, value2,
					"germplasmname");
			return (Criteria) this;
		}

		public Criteria andGermplasmnameNotBetween(String value1, String value2) {
			addCriterion("germplasmname not between", value1, value2,
					"germplasmname");
			return (Criteria) this;
		}

		public Criteria andYearIsNull() {
			addCriterion("year is null");
			return (Criteria) this;
		}

		public Criteria andYearIsNotNull() {
			addCriterion("year is not null");
			return (Criteria) this;
		}

		public Criteria andYearEqualTo(String value) {
			addCriterion("year =", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearNotEqualTo(String value) {
			addCriterion("year <>", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearGreaterThan(String value) {
			addCriterion("year >", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearGreaterThanOrEqualTo(String value) {
			addCriterion("year >=", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearLessThan(String value) {
			addCriterion("year <", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearLessThanOrEqualTo(String value) {
			addCriterion("year <=", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearLike(String value) {
			addCriterion("year like", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearNotLike(String value) {
			addCriterion("year not like", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearIn(List<String> values) {
			addCriterion("year in", values, "year");
			return (Criteria) this;
		}

		public Criteria andYearNotIn(List<String> values) {
			addCriterion("year not in", values, "year");
			return (Criteria) this;
		}

		public Criteria andYearBetween(String value1, String value2) {
			addCriterion("year between", value1, value2, "year");
			return (Criteria) this;
		}

		public Criteria andYearNotBetween(String value1, String value2) {
			addCriterion("year not between", value1, value2, "year");
			return (Criteria) this;
		}

		public Criteria andLocationIsNull() {
			addCriterion("location is null");
			return (Criteria) this;
		}

		public Criteria andLocationIsNotNull() {
			addCriterion("location is not null");
			return (Criteria) this;
		}

		public Criteria andLocationEqualTo(String value) {
			addCriterion("location =", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotEqualTo(String value) {
			addCriterion("location <>", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThan(String value) {
			addCriterion("location >", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThanOrEqualTo(String value) {
			addCriterion("location >=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThan(String value) {
			addCriterion("location <", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThanOrEqualTo(String value) {
			addCriterion("location <=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLike(String value) {
			addCriterion("location like", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotLike(String value) {
			addCriterion("location not like", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationIn(List<String> values) {
			addCriterion("location in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotIn(List<String> values) {
			addCriterion("location not in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationBetween(String value1, String value2) {
			addCriterion("location between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotBetween(String value1, String value2) {
			addCriterion("location not between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andAreaIsNull() {
			addCriterion("area is null");
			return (Criteria) this;
		}

		public Criteria andAreaIsNotNull() {
			addCriterion("area is not null");
			return (Criteria) this;
		}

		public Criteria andAreaEqualTo(Double value) {
			addCriterion("area =", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotEqualTo(Double value) {
			addCriterion("area <>", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThan(Double value) {
			addCriterion("area >", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThanOrEqualTo(Double value) {
			addCriterion("area >=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThan(Double value) {
			addCriterion("area <", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThanOrEqualTo(Double value) {
			addCriterion("area <=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaIn(List<Double> values) {
			addCriterion("area in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotIn(List<Double> values) {
			addCriterion("area not in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaBetween(Double value1, Double value2) {
			addCriterion("area between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotBetween(Double value1, Double value2) {
			addCriterion("area not between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andDatasourceIsNull() {
			addCriterion("datasource is null");
			return (Criteria) this;
		}

		public Criteria andDatasourceIsNotNull() {
			addCriterion("datasource is not null");
			return (Criteria) this;
		}

		public Criteria andDatasourceEqualTo(String value) {
			addCriterion("datasource =", value, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceNotEqualTo(String value) {
			addCriterion("datasource <>", value, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceGreaterThan(String value) {
			addCriterion("datasource >", value, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceGreaterThanOrEqualTo(String value) {
			addCriterion("datasource >=", value, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceLessThan(String value) {
			addCriterion("datasource <", value, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceLessThanOrEqualTo(String value) {
			addCriterion("datasource <=", value, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceLike(String value) {
			addCriterion("datasource like", value, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceNotLike(String value) {
			addCriterion("datasource not like", value, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceIn(List<String> values) {
			addCriterion("datasource in", values, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceNotIn(List<String> values) {
			addCriterion("datasource not in", values, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceBetween(String value1, String value2) {
			addCriterion("datasource between", value1, value2, "datasource");
			return (Criteria) this;
		}

		public Criteria andDatasourceNotBetween(String value1, String value2) {
			addCriterion("datasource not between", value1, value2, "datasource");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table extensiondata
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
     * This class corresponds to the database table extensiondata
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}