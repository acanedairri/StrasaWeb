package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class GermplasmCharacteristicsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public GermplasmCharacteristicsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
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

		public Criteria andAttributeIsNull() {
			addCriterion("attribute is null");
			return (Criteria) this;
		}

		public Criteria andAttributeIsNotNull() {
			addCriterion("attribute is not null");
			return (Criteria) this;
		}

		public Criteria andAttributeEqualTo(String value) {
			addCriterion("attribute =", value, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeNotEqualTo(String value) {
			addCriterion("attribute <>", value, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeGreaterThan(String value) {
			addCriterion("attribute >", value, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeGreaterThanOrEqualTo(String value) {
			addCriterion("attribute >=", value, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeLessThan(String value) {
			addCriterion("attribute <", value, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeLessThanOrEqualTo(String value) {
			addCriterion("attribute <=", value, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeLike(String value) {
			addCriterion("attribute like", value, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeNotLike(String value) {
			addCriterion("attribute not like", value, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeIn(List<String> values) {
			addCriterion("attribute in", values, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeNotIn(List<String> values) {
			addCriterion("attribute not in", values, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeBetween(String value1, String value2) {
			addCriterion("attribute between", value1, value2, "attribute");
			return (Criteria) this;
		}

		public Criteria andAttributeNotBetween(String value1, String value2) {
			addCriterion("attribute not between", value1, value2, "attribute");
			return (Criteria) this;
		}

		public Criteria andValueIsNull() {
			addCriterion("value is null");
			return (Criteria) this;
		}

		public Criteria andValueIsNotNull() {
			addCriterion("value is not null");
			return (Criteria) this;
		}

		public Criteria andValueEqualTo(String value) {
			addCriterion("value =", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotEqualTo(String value) {
			addCriterion("value <>", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThan(String value) {
			addCriterion("value >", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThanOrEqualTo(String value) {
			addCriterion("value >=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThan(String value) {
			addCriterion("value <", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThanOrEqualTo(String value) {
			addCriterion("value <=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLike(String value) {
			addCriterion("value like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotLike(String value) {
			addCriterion("value not like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueIn(List<String> values) {
			addCriterion("value in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotIn(List<String> values) {
			addCriterion("value not in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueBetween(String value1, String value2) {
			addCriterion("value between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotBetween(String value1, String value2) {
			addCriterion("value not between", value1, value2, "value");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
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
     * This class corresponds to the database table germplasmcharacteristics
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}