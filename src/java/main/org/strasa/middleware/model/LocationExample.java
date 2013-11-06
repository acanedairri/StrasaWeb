package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class LocationExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public LocationExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
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

		public Criteria andLocationnameIsNull() {
			addCriterion("locationname is null");
			return (Criteria) this;
		}

		public Criteria andLocationnameIsNotNull() {
			addCriterion("locationname is not null");
			return (Criteria) this;
		}

		public Criteria andLocationnameEqualTo(String value) {
			addCriterion("locationname =", value, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameNotEqualTo(String value) {
			addCriterion("locationname <>", value, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameGreaterThan(String value) {
			addCriterion("locationname >", value, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameGreaterThanOrEqualTo(String value) {
			addCriterion("locationname >=", value, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameLessThan(String value) {
			addCriterion("locationname <", value, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameLessThanOrEqualTo(String value) {
			addCriterion("locationname <=", value, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameLike(String value) {
			addCriterion("locationname like", value, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameNotLike(String value) {
			addCriterion("locationname not like", value, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameIn(List<String> values) {
			addCriterion("locationname in", values, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameNotIn(List<String> values) {
			addCriterion("locationname not in", values, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameBetween(String value1, String value2) {
			addCriterion("locationname between", value1, value2, "locationname");
			return (Criteria) this;
		}

		public Criteria andLocationnameNotBetween(String value1, String value2) {
			addCriterion("locationname not between", value1, value2,
					"locationname");
			return (Criteria) this;
		}

		public Criteria andCountryIsNull() {
			addCriterion("country is null");
			return (Criteria) this;
		}

		public Criteria andCountryIsNotNull() {
			addCriterion("country is not null");
			return (Criteria) this;
		}

		public Criteria andCountryEqualTo(String value) {
			addCriterion("country =", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryNotEqualTo(String value) {
			addCriterion("country <>", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryGreaterThan(String value) {
			addCriterion("country >", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryGreaterThanOrEqualTo(String value) {
			addCriterion("country >=", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryLessThan(String value) {
			addCriterion("country <", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryLessThanOrEqualTo(String value) {
			addCriterion("country <=", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryLike(String value) {
			addCriterion("country like", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryNotLike(String value) {
			addCriterion("country not like", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryIn(List<String> values) {
			addCriterion("country in", values, "country");
			return (Criteria) this;
		}

		public Criteria andCountryNotIn(List<String> values) {
			addCriterion("country not in", values, "country");
			return (Criteria) this;
		}

		public Criteria andCountryBetween(String value1, String value2) {
			addCriterion("country between", value1, value2, "country");
			return (Criteria) this;
		}

		public Criteria andCountryNotBetween(String value1, String value2) {
			addCriterion("country not between", value1, value2, "country");
			return (Criteria) this;
		}

		public Criteria andProvinceIsNull() {
			addCriterion("province is null");
			return (Criteria) this;
		}

		public Criteria andProvinceIsNotNull() {
			addCriterion("province is not null");
			return (Criteria) this;
		}

		public Criteria andProvinceEqualTo(String value) {
			addCriterion("province =", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotEqualTo(String value) {
			addCriterion("province <>", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceGreaterThan(String value) {
			addCriterion("province >", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceGreaterThanOrEqualTo(String value) {
			addCriterion("province >=", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLessThan(String value) {
			addCriterion("province <", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLessThanOrEqualTo(String value) {
			addCriterion("province <=", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLike(String value) {
			addCriterion("province like", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotLike(String value) {
			addCriterion("province not like", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceIn(List<String> values) {
			addCriterion("province in", values, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotIn(List<String> values) {
			addCriterion("province not in", values, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceBetween(String value1, String value2) {
			addCriterion("province between", value1, value2, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotBetween(String value1, String value2) {
			addCriterion("province not between", value1, value2, "province");
			return (Criteria) this;
		}

		public Criteria andRegionIsNull() {
			addCriterion("region is null");
			return (Criteria) this;
		}

		public Criteria andRegionIsNotNull() {
			addCriterion("region is not null");
			return (Criteria) this;
		}

		public Criteria andRegionEqualTo(String value) {
			addCriterion("region =", value, "region");
			return (Criteria) this;
		}

		public Criteria andRegionNotEqualTo(String value) {
			addCriterion("region <>", value, "region");
			return (Criteria) this;
		}

		public Criteria andRegionGreaterThan(String value) {
			addCriterion("region >", value, "region");
			return (Criteria) this;
		}

		public Criteria andRegionGreaterThanOrEqualTo(String value) {
			addCriterion("region >=", value, "region");
			return (Criteria) this;
		}

		public Criteria andRegionLessThan(String value) {
			addCriterion("region <", value, "region");
			return (Criteria) this;
		}

		public Criteria andRegionLessThanOrEqualTo(String value) {
			addCriterion("region <=", value, "region");
			return (Criteria) this;
		}

		public Criteria andRegionLike(String value) {
			addCriterion("region like", value, "region");
			return (Criteria) this;
		}

		public Criteria andRegionNotLike(String value) {
			addCriterion("region not like", value, "region");
			return (Criteria) this;
		}

		public Criteria andRegionIn(List<String> values) {
			addCriterion("region in", values, "region");
			return (Criteria) this;
		}

		public Criteria andRegionNotIn(List<String> values) {
			addCriterion("region not in", values, "region");
			return (Criteria) this;
		}

		public Criteria andRegionBetween(String value1, String value2) {
			addCriterion("region between", value1, value2, "region");
			return (Criteria) this;
		}

		public Criteria andRegionNotBetween(String value1, String value2) {
			addCriterion("region not between", value1, value2, "region");
			return (Criteria) this;
		}

		public Criteria andAltitudeIsNull() {
			addCriterion("altitude is null");
			return (Criteria) this;
		}

		public Criteria andAltitudeIsNotNull() {
			addCriterion("altitude is not null");
			return (Criteria) this;
		}

		public Criteria andAltitudeEqualTo(String value) {
			addCriterion("altitude =", value, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeNotEqualTo(String value) {
			addCriterion("altitude <>", value, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeGreaterThan(String value) {
			addCriterion("altitude >", value, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeGreaterThanOrEqualTo(String value) {
			addCriterion("altitude >=", value, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeLessThan(String value) {
			addCriterion("altitude <", value, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeLessThanOrEqualTo(String value) {
			addCriterion("altitude <=", value, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeLike(String value) {
			addCriterion("altitude like", value, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeNotLike(String value) {
			addCriterion("altitude not like", value, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeIn(List<String> values) {
			addCriterion("altitude in", values, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeNotIn(List<String> values) {
			addCriterion("altitude not in", values, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeBetween(String value1, String value2) {
			addCriterion("altitude between", value1, value2, "altitude");
			return (Criteria) this;
		}

		public Criteria andAltitudeNotBetween(String value1, String value2) {
			addCriterion("altitude not between", value1, value2, "altitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeIsNull() {
			addCriterion("latitude is null");
			return (Criteria) this;
		}

		public Criteria andLatitudeIsNotNull() {
			addCriterion("latitude is not null");
			return (Criteria) this;
		}

		public Criteria andLatitudeEqualTo(String value) {
			addCriterion("latitude =", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotEqualTo(String value) {
			addCriterion("latitude <>", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeGreaterThan(String value) {
			addCriterion("latitude >", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
			addCriterion("latitude >=", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLessThan(String value) {
			addCriterion("latitude <", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLessThanOrEqualTo(String value) {
			addCriterion("latitude <=", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLike(String value) {
			addCriterion("latitude like", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotLike(String value) {
			addCriterion("latitude not like", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeIn(List<String> values) {
			addCriterion("latitude in", values, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotIn(List<String> values) {
			addCriterion("latitude not in", values, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeBetween(String value1, String value2) {
			addCriterion("latitude between", value1, value2, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotBetween(String value1, String value2) {
			addCriterion("latitude not between", value1, value2, "latitude");
			return (Criteria) this;
		}

		public Criteria andWeatherstationIsNull() {
			addCriterion("weatherstation is null");
			return (Criteria) this;
		}

		public Criteria andWeatherstationIsNotNull() {
			addCriterion("weatherstation is not null");
			return (Criteria) this;
		}

		public Criteria andWeatherstationEqualTo(String value) {
			addCriterion("weatherstation =", value, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationNotEqualTo(String value) {
			addCriterion("weatherstation <>", value, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationGreaterThan(String value) {
			addCriterion("weatherstation >", value, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationGreaterThanOrEqualTo(String value) {
			addCriterion("weatherstation >=", value, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationLessThan(String value) {
			addCriterion("weatherstation <", value, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationLessThanOrEqualTo(String value) {
			addCriterion("weatherstation <=", value, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationLike(String value) {
			addCriterion("weatherstation like", value, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationNotLike(String value) {
			addCriterion("weatherstation not like", value, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationIn(List<String> values) {
			addCriterion("weatherstation in", values, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationNotIn(List<String> values) {
			addCriterion("weatherstation not in", values, "weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationBetween(String value1, String value2) {
			addCriterion("weatherstation between", value1, value2,
					"weatherstation");
			return (Criteria) this;
		}

		public Criteria andWeatherstationNotBetween(String value1, String value2) {
			addCriterion("weatherstation not between", value1, value2,
					"weatherstation");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table location
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
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
     * This class corresponds to the database table location
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}