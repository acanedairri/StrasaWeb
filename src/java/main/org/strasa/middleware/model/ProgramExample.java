package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class ProgramExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public ProgramExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
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

		public Criteria andObjectiveIsNull() {
			addCriterion("objective is null");
			return (Criteria) this;
		}

		public Criteria andObjectiveIsNotNull() {
			addCriterion("objective is not null");
			return (Criteria) this;
		}

		public Criteria andObjectiveEqualTo(String value) {
			addCriterion("objective =", value, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveNotEqualTo(String value) {
			addCriterion("objective <>", value, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveGreaterThan(String value) {
			addCriterion("objective >", value, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveGreaterThanOrEqualTo(String value) {
			addCriterion("objective >=", value, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveLessThan(String value) {
			addCriterion("objective <", value, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveLessThanOrEqualTo(String value) {
			addCriterion("objective <=", value, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveLike(String value) {
			addCriterion("objective like", value, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveNotLike(String value) {
			addCriterion("objective not like", value, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveIn(List<String> values) {
			addCriterion("objective in", values, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveNotIn(List<String> values) {
			addCriterion("objective not in", values, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveBetween(String value1, String value2) {
			addCriterion("objective between", value1, value2, "objective");
			return (Criteria) this;
		}

		public Criteria andObjectiveNotBetween(String value1, String value2) {
			addCriterion("objective not between", value1, value2, "objective");
			return (Criteria) this;
		}

		public Criteria andCoordinatorIsNull() {
			addCriterion("coordinator is null");
			return (Criteria) this;
		}

		public Criteria andCoordinatorIsNotNull() {
			addCriterion("coordinator is not null");
			return (Criteria) this;
		}

		public Criteria andCoordinatorEqualTo(String value) {
			addCriterion("coordinator =", value, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorNotEqualTo(String value) {
			addCriterion("coordinator <>", value, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorGreaterThan(String value) {
			addCriterion("coordinator >", value, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorGreaterThanOrEqualTo(String value) {
			addCriterion("coordinator >=", value, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorLessThan(String value) {
			addCriterion("coordinator <", value, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorLessThanOrEqualTo(String value) {
			addCriterion("coordinator <=", value, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorLike(String value) {
			addCriterion("coordinator like", value, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorNotLike(String value) {
			addCriterion("coordinator not like", value, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorIn(List<String> values) {
			addCriterion("coordinator in", values, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorNotIn(List<String> values) {
			addCriterion("coordinator not in", values, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorBetween(String value1, String value2) {
			addCriterion("coordinator between", value1, value2, "coordinator");
			return (Criteria) this;
		}

		public Criteria andCoordinatorNotBetween(String value1, String value2) {
			addCriterion("coordinator not between", value1, value2,
					"coordinator");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteIsNull() {
			addCriterion("leadinginstitute is null");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteIsNotNull() {
			addCriterion("leadinginstitute is not null");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteEqualTo(String value) {
			addCriterion("leadinginstitute =", value, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteNotEqualTo(String value) {
			addCriterion("leadinginstitute <>", value, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteGreaterThan(String value) {
			addCriterion("leadinginstitute >", value, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteGreaterThanOrEqualTo(String value) {
			addCriterion("leadinginstitute >=", value, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteLessThan(String value) {
			addCriterion("leadinginstitute <", value, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteLessThanOrEqualTo(String value) {
			addCriterion("leadinginstitute <=", value, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteLike(String value) {
			addCriterion("leadinginstitute like", value, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteNotLike(String value) {
			addCriterion("leadinginstitute not like", value, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteIn(List<String> values) {
			addCriterion("leadinginstitute in", values, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteNotIn(List<String> values) {
			addCriterion("leadinginstitute not in", values, "leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteBetween(String value1, String value2) {
			addCriterion("leadinginstitute between", value1, value2,
					"leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andLeadinginstituteNotBetween(String value1,
				String value2) {
			addCriterion("leadinginstitute not between", value1, value2,
					"leadinginstitute");
			return (Criteria) this;
		}

		public Criteria andCollaboratorIsNull() {
			addCriterion("collaborator is null");
			return (Criteria) this;
		}

		public Criteria andCollaboratorIsNotNull() {
			addCriterion("collaborator is not null");
			return (Criteria) this;
		}

		public Criteria andCollaboratorEqualTo(String value) {
			addCriterion("collaborator =", value, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorNotEqualTo(String value) {
			addCriterion("collaborator <>", value, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorGreaterThan(String value) {
			addCriterion("collaborator >", value, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorGreaterThanOrEqualTo(String value) {
			addCriterion("collaborator >=", value, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorLessThan(String value) {
			addCriterion("collaborator <", value, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorLessThanOrEqualTo(String value) {
			addCriterion("collaborator <=", value, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorLike(String value) {
			addCriterion("collaborator like", value, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorNotLike(String value) {
			addCriterion("collaborator not like", value, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorIn(List<String> values) {
			addCriterion("collaborator in", values, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorNotIn(List<String> values) {
			addCriterion("collaborator not in", values, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorBetween(String value1, String value2) {
			addCriterion("collaborator between", value1, value2, "collaborator");
			return (Criteria) this;
		}

		public Criteria andCollaboratorNotBetween(String value1, String value2) {
			addCriterion("collaborator not between", value1, value2,
					"collaborator");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table program
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
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
     * This class corresponds to the database table program
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}