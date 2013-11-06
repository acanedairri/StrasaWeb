package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public ProjectExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Wed Nov 06 16:19:45 SGT 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table project
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

		public Criteria andPiIsNull() {
			addCriterion("pi is null");
			return (Criteria) this;
		}

		public Criteria andPiIsNotNull() {
			addCriterion("pi is not null");
			return (Criteria) this;
		}

		public Criteria andPiEqualTo(String value) {
			addCriterion("pi =", value, "pi");
			return (Criteria) this;
		}

		public Criteria andPiNotEqualTo(String value) {
			addCriterion("pi <>", value, "pi");
			return (Criteria) this;
		}

		public Criteria andPiGreaterThan(String value) {
			addCriterion("pi >", value, "pi");
			return (Criteria) this;
		}

		public Criteria andPiGreaterThanOrEqualTo(String value) {
			addCriterion("pi >=", value, "pi");
			return (Criteria) this;
		}

		public Criteria andPiLessThan(String value) {
			addCriterion("pi <", value, "pi");
			return (Criteria) this;
		}

		public Criteria andPiLessThanOrEqualTo(String value) {
			addCriterion("pi <=", value, "pi");
			return (Criteria) this;
		}

		public Criteria andPiLike(String value) {
			addCriterion("pi like", value, "pi");
			return (Criteria) this;
		}

		public Criteria andPiNotLike(String value) {
			addCriterion("pi not like", value, "pi");
			return (Criteria) this;
		}

		public Criteria andPiIn(List<String> values) {
			addCriterion("pi in", values, "pi");
			return (Criteria) this;
		}

		public Criteria andPiNotIn(List<String> values) {
			addCriterion("pi not in", values, "pi");
			return (Criteria) this;
		}

		public Criteria andPiBetween(String value1, String value2) {
			addCriterion("pi between", value1, value2, "pi");
			return (Criteria) this;
		}

		public Criteria andPiNotBetween(String value1, String value2) {
			addCriterion("pi not between", value1, value2, "pi");
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

		public Criteria andCollaboratorsIsNull() {
			addCriterion("collaborators is null");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsIsNotNull() {
			addCriterion("collaborators is not null");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsEqualTo(String value) {
			addCriterion("collaborators =", value, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsNotEqualTo(String value) {
			addCriterion("collaborators <>", value, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsGreaterThan(String value) {
			addCriterion("collaborators >", value, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsGreaterThanOrEqualTo(String value) {
			addCriterion("collaborators >=", value, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsLessThan(String value) {
			addCriterion("collaborators <", value, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsLessThanOrEqualTo(String value) {
			addCriterion("collaborators <=", value, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsLike(String value) {
			addCriterion("collaborators like", value, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsNotLike(String value) {
			addCriterion("collaborators not like", value, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsIn(List<String> values) {
			addCriterion("collaborators in", values, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsNotIn(List<String> values) {
			addCriterion("collaborators not in", values, "collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsBetween(String value1, String value2) {
			addCriterion("collaborators between", value1, value2,
					"collaborators");
			return (Criteria) this;
		}

		public Criteria andCollaboratorsNotBetween(String value1, String value2) {
			addCriterion("collaborators not between", value1, value2,
					"collaborators");
			return (Criteria) this;
		}

		public Criteria andFundingagencyIsNull() {
			addCriterion("fundingagency is null");
			return (Criteria) this;
		}

		public Criteria andFundingagencyIsNotNull() {
			addCriterion("fundingagency is not null");
			return (Criteria) this;
		}

		public Criteria andFundingagencyEqualTo(String value) {
			addCriterion("fundingagency =", value, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyNotEqualTo(String value) {
			addCriterion("fundingagency <>", value, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyGreaterThan(String value) {
			addCriterion("fundingagency >", value, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyGreaterThanOrEqualTo(String value) {
			addCriterion("fundingagency >=", value, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyLessThan(String value) {
			addCriterion("fundingagency <", value, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyLessThanOrEqualTo(String value) {
			addCriterion("fundingagency <=", value, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyLike(String value) {
			addCriterion("fundingagency like", value, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyNotLike(String value) {
			addCriterion("fundingagency not like", value, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyIn(List<String> values) {
			addCriterion("fundingagency in", values, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyNotIn(List<String> values) {
			addCriterion("fundingagency not in", values, "fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyBetween(String value1, String value2) {
			addCriterion("fundingagency between", value1, value2,
					"fundingagency");
			return (Criteria) this;
		}

		public Criteria andFundingagencyNotBetween(String value1, String value2) {
			addCriterion("fundingagency not between", value1, value2,
					"fundingagency");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table project
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
     * This class corresponds to the database table project
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}