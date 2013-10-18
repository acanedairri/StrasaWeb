package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public UserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
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

		public Criteria andLastnameIsNull() {
			addCriterion("lastname is null");
			return (Criteria) this;
		}

		public Criteria andLastnameIsNotNull() {
			addCriterion("lastname is not null");
			return (Criteria) this;
		}

		public Criteria andLastnameEqualTo(String value) {
			addCriterion("lastname =", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameNotEqualTo(String value) {
			addCriterion("lastname <>", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameGreaterThan(String value) {
			addCriterion("lastname >", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameGreaterThanOrEqualTo(String value) {
			addCriterion("lastname >=", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameLessThan(String value) {
			addCriterion("lastname <", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameLessThanOrEqualTo(String value) {
			addCriterion("lastname <=", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameLike(String value) {
			addCriterion("lastname like", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameNotLike(String value) {
			addCriterion("lastname not like", value, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameIn(List<String> values) {
			addCriterion("lastname in", values, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameNotIn(List<String> values) {
			addCriterion("lastname not in", values, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameBetween(String value1, String value2) {
			addCriterion("lastname between", value1, value2, "lastname");
			return (Criteria) this;
		}

		public Criteria andLastnameNotBetween(String value1, String value2) {
			addCriterion("lastname not between", value1, value2, "lastname");
			return (Criteria) this;
		}

		public Criteria andFirstnameIsNull() {
			addCriterion("firstname is null");
			return (Criteria) this;
		}

		public Criteria andFirstnameIsNotNull() {
			addCriterion("firstname is not null");
			return (Criteria) this;
		}

		public Criteria andFirstnameEqualTo(String value) {
			addCriterion("firstname =", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameNotEqualTo(String value) {
			addCriterion("firstname <>", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameGreaterThan(String value) {
			addCriterion("firstname >", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameGreaterThanOrEqualTo(String value) {
			addCriterion("firstname >=", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameLessThan(String value) {
			addCriterion("firstname <", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameLessThanOrEqualTo(String value) {
			addCriterion("firstname <=", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameLike(String value) {
			addCriterion("firstname like", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameNotLike(String value) {
			addCriterion("firstname not like", value, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameIn(List<String> values) {
			addCriterion("firstname in", values, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameNotIn(List<String> values) {
			addCriterion("firstname not in", values, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameBetween(String value1, String value2) {
			addCriterion("firstname between", value1, value2, "firstname");
			return (Criteria) this;
		}

		public Criteria andFirstnameNotBetween(String value1, String value2) {
			addCriterion("firstname not between", value1, value2, "firstname");
			return (Criteria) this;
		}

		public Criteria andMiIsNull() {
			addCriterion("mi is null");
			return (Criteria) this;
		}

		public Criteria andMiIsNotNull() {
			addCriterion("mi is not null");
			return (Criteria) this;
		}

		public Criteria andMiEqualTo(String value) {
			addCriterion("mi =", value, "mi");
			return (Criteria) this;
		}

		public Criteria andMiNotEqualTo(String value) {
			addCriterion("mi <>", value, "mi");
			return (Criteria) this;
		}

		public Criteria andMiGreaterThan(String value) {
			addCriterion("mi >", value, "mi");
			return (Criteria) this;
		}

		public Criteria andMiGreaterThanOrEqualTo(String value) {
			addCriterion("mi >=", value, "mi");
			return (Criteria) this;
		}

		public Criteria andMiLessThan(String value) {
			addCriterion("mi <", value, "mi");
			return (Criteria) this;
		}

		public Criteria andMiLessThanOrEqualTo(String value) {
			addCriterion("mi <=", value, "mi");
			return (Criteria) this;
		}

		public Criteria andMiLike(String value) {
			addCriterion("mi like", value, "mi");
			return (Criteria) this;
		}

		public Criteria andMiNotLike(String value) {
			addCriterion("mi not like", value, "mi");
			return (Criteria) this;
		}

		public Criteria andMiIn(List<String> values) {
			addCriterion("mi in", values, "mi");
			return (Criteria) this;
		}

		public Criteria andMiNotIn(List<String> values) {
			addCriterion("mi not in", values, "mi");
			return (Criteria) this;
		}

		public Criteria andMiBetween(String value1, String value2) {
			addCriterion("mi between", value1, value2, "mi");
			return (Criteria) this;
		}

		public Criteria andMiNotBetween(String value1, String value2) {
			addCriterion("mi not between", value1, value2, "mi");
			return (Criteria) this;
		}

		public Criteria andAgencyIsNull() {
			addCriterion("agency is null");
			return (Criteria) this;
		}

		public Criteria andAgencyIsNotNull() {
			addCriterion("agency is not null");
			return (Criteria) this;
		}

		public Criteria andAgencyEqualTo(String value) {
			addCriterion("agency =", value, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyNotEqualTo(String value) {
			addCriterion("agency <>", value, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyGreaterThan(String value) {
			addCriterion("agency >", value, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyGreaterThanOrEqualTo(String value) {
			addCriterion("agency >=", value, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyLessThan(String value) {
			addCriterion("agency <", value, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyLessThanOrEqualTo(String value) {
			addCriterion("agency <=", value, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyLike(String value) {
			addCriterion("agency like", value, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyNotLike(String value) {
			addCriterion("agency not like", value, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyIn(List<String> values) {
			addCriterion("agency in", values, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyNotIn(List<String> values) {
			addCriterion("agency not in", values, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyBetween(String value1, String value2) {
			addCriterion("agency between", value1, value2, "agency");
			return (Criteria) this;
		}

		public Criteria andAgencyNotBetween(String value1, String value2) {
			addCriterion("agency not between", value1, value2, "agency");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
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

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andRoleIsNull() {
			addCriterion("role is null");
			return (Criteria) this;
		}

		public Criteria andRoleIsNotNull() {
			addCriterion("role is not null");
			return (Criteria) this;
		}

		public Criteria andRoleEqualTo(String value) {
			addCriterion("role =", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotEqualTo(String value) {
			addCriterion("role <>", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleGreaterThan(String value) {
			addCriterion("role >", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleGreaterThanOrEqualTo(String value) {
			addCriterion("role >=", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLessThan(String value) {
			addCriterion("role <", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLessThanOrEqualTo(String value) {
			addCriterion("role <=", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLike(String value) {
			addCriterion("role like", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotLike(String value) {
			addCriterion("role not like", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleIn(List<String> values) {
			addCriterion("role in", values, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotIn(List<String> values) {
			addCriterion("role not in", values, "role");
			return (Criteria) this;
		}

		public Criteria andRoleBetween(String value1, String value2) {
			addCriterion("role between", value1, value2, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotBetween(String value1, String value2) {
			addCriterion("role not between", value1, value2, "role");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
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
     * This class corresponds to the database table user
     *
     * @mbggenerated do_not_delete_during_merge Wed Oct 09 16:20:43 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}