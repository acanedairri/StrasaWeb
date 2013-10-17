package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class LocationExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public LocationExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
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
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
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

		public Criteria andLtypeIsNull() {
			addCriterion("ltype is null");
			return (Criteria) this;
		}

		public Criteria andLtypeIsNotNull() {
			addCriterion("ltype is not null");
			return (Criteria) this;
		}

		public Criteria andLtypeEqualTo(Integer value) {
			addCriterion("ltype =", value, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeNotEqualTo(Integer value) {
			addCriterion("ltype <>", value, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeGreaterThan(Integer value) {
			addCriterion("ltype >", value, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ltype >=", value, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeLessThan(Integer value) {
			addCriterion("ltype <", value, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeLessThanOrEqualTo(Integer value) {
			addCriterion("ltype <=", value, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeIn(List<Integer> values) {
			addCriterion("ltype in", values, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeNotIn(List<Integer> values) {
			addCriterion("ltype not in", values, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeBetween(Integer value1, Integer value2) {
			addCriterion("ltype between", value1, value2, "ltype");
			return (Criteria) this;
		}

		public Criteria andLtypeNotBetween(Integer value1, Integer value2) {
			addCriterion("ltype not between", value1, value2, "ltype");
			return (Criteria) this;
		}

		public Criteria andNllpIsNull() {
			addCriterion("nllp is null");
			return (Criteria) this;
		}

		public Criteria andNllpIsNotNull() {
			addCriterion("nllp is not null");
			return (Criteria) this;
		}

		public Criteria andNllpEqualTo(Integer value) {
			addCriterion("nllp =", value, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpNotEqualTo(Integer value) {
			addCriterion("nllp <>", value, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpGreaterThan(Integer value) {
			addCriterion("nllp >", value, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpGreaterThanOrEqualTo(Integer value) {
			addCriterion("nllp >=", value, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpLessThan(Integer value) {
			addCriterion("nllp <", value, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpLessThanOrEqualTo(Integer value) {
			addCriterion("nllp <=", value, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpIn(List<Integer> values) {
			addCriterion("nllp in", values, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpNotIn(List<Integer> values) {
			addCriterion("nllp not in", values, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpBetween(Integer value1, Integer value2) {
			addCriterion("nllp between", value1, value2, "nllp");
			return (Criteria) this;
		}

		public Criteria andNllpNotBetween(Integer value1, Integer value2) {
			addCriterion("nllp not between", value1, value2, "nllp");
			return (Criteria) this;
		}

		public Criteria andLnameIsNull() {
			addCriterion("lname is null");
			return (Criteria) this;
		}

		public Criteria andLnameIsNotNull() {
			addCriterion("lname is not null");
			return (Criteria) this;
		}

		public Criteria andLnameEqualTo(String value) {
			addCriterion("lname =", value, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameNotEqualTo(String value) {
			addCriterion("lname <>", value, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameGreaterThan(String value) {
			addCriterion("lname >", value, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameGreaterThanOrEqualTo(String value) {
			addCriterion("lname >=", value, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameLessThan(String value) {
			addCriterion("lname <", value, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameLessThanOrEqualTo(String value) {
			addCriterion("lname <=", value, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameLike(String value) {
			addCriterion("lname like", value, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameNotLike(String value) {
			addCriterion("lname not like", value, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameIn(List<String> values) {
			addCriterion("lname in", values, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameNotIn(List<String> values) {
			addCriterion("lname not in", values, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameBetween(String value1, String value2) {
			addCriterion("lname between", value1, value2, "lname");
			return (Criteria) this;
		}

		public Criteria andLnameNotBetween(String value1, String value2) {
			addCriterion("lname not between", value1, value2, "lname");
			return (Criteria) this;
		}

		public Criteria andLabbrIsNull() {
			addCriterion("labbr is null");
			return (Criteria) this;
		}

		public Criteria andLabbrIsNotNull() {
			addCriterion("labbr is not null");
			return (Criteria) this;
		}

		public Criteria andLabbrEqualTo(String value) {
			addCriterion("labbr =", value, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrNotEqualTo(String value) {
			addCriterion("labbr <>", value, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrGreaterThan(String value) {
			addCriterion("labbr >", value, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrGreaterThanOrEqualTo(String value) {
			addCriterion("labbr >=", value, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrLessThan(String value) {
			addCriterion("labbr <", value, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrLessThanOrEqualTo(String value) {
			addCriterion("labbr <=", value, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrLike(String value) {
			addCriterion("labbr like", value, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrNotLike(String value) {
			addCriterion("labbr not like", value, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrIn(List<String> values) {
			addCriterion("labbr in", values, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrNotIn(List<String> values) {
			addCriterion("labbr not in", values, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrBetween(String value1, String value2) {
			addCriterion("labbr between", value1, value2, "labbr");
			return (Criteria) this;
		}

		public Criteria andLabbrNotBetween(String value1, String value2) {
			addCriterion("labbr not between", value1, value2, "labbr");
			return (Criteria) this;
		}

		public Criteria andSnl3idIsNull() {
			addCriterion("snl3id is null");
			return (Criteria) this;
		}

		public Criteria andSnl3idIsNotNull() {
			addCriterion("snl3id is not null");
			return (Criteria) this;
		}

		public Criteria andSnl3idEqualTo(Integer value) {
			addCriterion("snl3id =", value, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idNotEqualTo(Integer value) {
			addCriterion("snl3id <>", value, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idGreaterThan(Integer value) {
			addCriterion("snl3id >", value, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idGreaterThanOrEqualTo(Integer value) {
			addCriterion("snl3id >=", value, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idLessThan(Integer value) {
			addCriterion("snl3id <", value, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idLessThanOrEqualTo(Integer value) {
			addCriterion("snl3id <=", value, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idIn(List<Integer> values) {
			addCriterion("snl3id in", values, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idNotIn(List<Integer> values) {
			addCriterion("snl3id not in", values, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idBetween(Integer value1, Integer value2) {
			addCriterion("snl3id between", value1, value2, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl3idNotBetween(Integer value1, Integer value2) {
			addCriterion("snl3id not between", value1, value2, "snl3id");
			return (Criteria) this;
		}

		public Criteria andSnl2idIsNull() {
			addCriterion("snl2id is null");
			return (Criteria) this;
		}

		public Criteria andSnl2idIsNotNull() {
			addCriterion("snl2id is not null");
			return (Criteria) this;
		}

		public Criteria andSnl2idEqualTo(Integer value) {
			addCriterion("snl2id =", value, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idNotEqualTo(Integer value) {
			addCriterion("snl2id <>", value, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idGreaterThan(Integer value) {
			addCriterion("snl2id >", value, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idGreaterThanOrEqualTo(Integer value) {
			addCriterion("snl2id >=", value, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idLessThan(Integer value) {
			addCriterion("snl2id <", value, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idLessThanOrEqualTo(Integer value) {
			addCriterion("snl2id <=", value, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idIn(List<Integer> values) {
			addCriterion("snl2id in", values, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idNotIn(List<Integer> values) {
			addCriterion("snl2id not in", values, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idBetween(Integer value1, Integer value2) {
			addCriterion("snl2id between", value1, value2, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl2idNotBetween(Integer value1, Integer value2) {
			addCriterion("snl2id not between", value1, value2, "snl2id");
			return (Criteria) this;
		}

		public Criteria andSnl1idIsNull() {
			addCriterion("snl1id is null");
			return (Criteria) this;
		}

		public Criteria andSnl1idIsNotNull() {
			addCriterion("snl1id is not null");
			return (Criteria) this;
		}

		public Criteria andSnl1idEqualTo(Integer value) {
			addCriterion("snl1id =", value, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idNotEqualTo(Integer value) {
			addCriterion("snl1id <>", value, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idGreaterThan(Integer value) {
			addCriterion("snl1id >", value, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idGreaterThanOrEqualTo(Integer value) {
			addCriterion("snl1id >=", value, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idLessThan(Integer value) {
			addCriterion("snl1id <", value, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idLessThanOrEqualTo(Integer value) {
			addCriterion("snl1id <=", value, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idIn(List<Integer> values) {
			addCriterion("snl1id in", values, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idNotIn(List<Integer> values) {
			addCriterion("snl1id not in", values, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idBetween(Integer value1, Integer value2) {
			addCriterion("snl1id between", value1, value2, "snl1id");
			return (Criteria) this;
		}

		public Criteria andSnl1idNotBetween(Integer value1, Integer value2) {
			addCriterion("snl1id not between", value1, value2, "snl1id");
			return (Criteria) this;
		}

		public Criteria andCntryidIsNull() {
			addCriterion("cntryid is null");
			return (Criteria) this;
		}

		public Criteria andCntryidIsNotNull() {
			addCriterion("cntryid is not null");
			return (Criteria) this;
		}

		public Criteria andCntryidEqualTo(Integer value) {
			addCriterion("cntryid =", value, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidNotEqualTo(Integer value) {
			addCriterion("cntryid <>", value, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidGreaterThan(Integer value) {
			addCriterion("cntryid >", value, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidGreaterThanOrEqualTo(Integer value) {
			addCriterion("cntryid >=", value, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidLessThan(Integer value) {
			addCriterion("cntryid <", value, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidLessThanOrEqualTo(Integer value) {
			addCriterion("cntryid <=", value, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidIn(List<Integer> values) {
			addCriterion("cntryid in", values, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidNotIn(List<Integer> values) {
			addCriterion("cntryid not in", values, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidBetween(Integer value1, Integer value2) {
			addCriterion("cntryid between", value1, value2, "cntryid");
			return (Criteria) this;
		}

		public Criteria andCntryidNotBetween(Integer value1, Integer value2) {
			addCriterion("cntryid not between", value1, value2, "cntryid");
			return (Criteria) this;
		}

		public Criteria andLrplceIsNull() {
			addCriterion("lrplce is null");
			return (Criteria) this;
		}

		public Criteria andLrplceIsNotNull() {
			addCriterion("lrplce is not null");
			return (Criteria) this;
		}

		public Criteria andLrplceEqualTo(Integer value) {
			addCriterion("lrplce =", value, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceNotEqualTo(Integer value) {
			addCriterion("lrplce <>", value, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceGreaterThan(Integer value) {
			addCriterion("lrplce >", value, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceGreaterThanOrEqualTo(Integer value) {
			addCriterion("lrplce >=", value, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceLessThan(Integer value) {
			addCriterion("lrplce <", value, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceLessThanOrEqualTo(Integer value) {
			addCriterion("lrplce <=", value, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceIn(List<Integer> values) {
			addCriterion("lrplce in", values, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceNotIn(List<Integer> values) {
			addCriterion("lrplce not in", values, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceBetween(Integer value1, Integer value2) {
			addCriterion("lrplce between", value1, value2, "lrplce");
			return (Criteria) this;
		}

		public Criteria andLrplceNotBetween(Integer value1, Integer value2) {
			addCriterion("lrplce not between", value1, value2, "lrplce");
			return (Criteria) this;
		}

		public Criteria andNnpidIsNull() {
			addCriterion("nnpid is null");
			return (Criteria) this;
		}

		public Criteria andNnpidIsNotNull() {
			addCriterion("nnpid is not null");
			return (Criteria) this;
		}

		public Criteria andNnpidEqualTo(Integer value) {
			addCriterion("nnpid =", value, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidNotEqualTo(Integer value) {
			addCriterion("nnpid <>", value, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidGreaterThan(Integer value) {
			addCriterion("nnpid >", value, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidGreaterThanOrEqualTo(Integer value) {
			addCriterion("nnpid >=", value, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidLessThan(Integer value) {
			addCriterion("nnpid <", value, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidLessThanOrEqualTo(Integer value) {
			addCriterion("nnpid <=", value, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidIn(List<Integer> values) {
			addCriterion("nnpid in", values, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidNotIn(List<Integer> values) {
			addCriterion("nnpid not in", values, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidBetween(Integer value1, Integer value2) {
			addCriterion("nnpid between", value1, value2, "nnpid");
			return (Criteria) this;
		}

		public Criteria andNnpidNotBetween(Integer value1, Integer value2) {
			addCriterion("nnpid not between", value1, value2, "nnpid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
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
     * @mbggenerated do_not_delete_during_merge Wed Oct 09 16:20:41 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}