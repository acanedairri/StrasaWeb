package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class CountryExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public CountryExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
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

		public Criteria andIsonumIsNull() {
			addCriterion("isonum is null");
			return (Criteria) this;
		}

		public Criteria andIsonumIsNotNull() {
			addCriterion("isonum is not null");
			return (Criteria) this;
		}

		public Criteria andIsonumEqualTo(Integer value) {
			addCriterion("isonum =", value, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumNotEqualTo(Integer value) {
			addCriterion("isonum <>", value, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumGreaterThan(Integer value) {
			addCriterion("isonum >", value, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumGreaterThanOrEqualTo(Integer value) {
			addCriterion("isonum >=", value, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumLessThan(Integer value) {
			addCriterion("isonum <", value, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumLessThanOrEqualTo(Integer value) {
			addCriterion("isonum <=", value, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumIn(List<Integer> values) {
			addCriterion("isonum in", values, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumNotIn(List<Integer> values) {
			addCriterion("isonum not in", values, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumBetween(Integer value1, Integer value2) {
			addCriterion("isonum between", value1, value2, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsonumNotBetween(Integer value1, Integer value2) {
			addCriterion("isonum not between", value1, value2, "isonum");
			return (Criteria) this;
		}

		public Criteria andIsotwoIsNull() {
			addCriterion("isotwo is null");
			return (Criteria) this;
		}

		public Criteria andIsotwoIsNotNull() {
			addCriterion("isotwo is not null");
			return (Criteria) this;
		}

		public Criteria andIsotwoEqualTo(String value) {
			addCriterion("isotwo =", value, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoNotEqualTo(String value) {
			addCriterion("isotwo <>", value, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoGreaterThan(String value) {
			addCriterion("isotwo >", value, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoGreaterThanOrEqualTo(String value) {
			addCriterion("isotwo >=", value, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoLessThan(String value) {
			addCriterion("isotwo <", value, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoLessThanOrEqualTo(String value) {
			addCriterion("isotwo <=", value, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoLike(String value) {
			addCriterion("isotwo like", value, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoNotLike(String value) {
			addCriterion("isotwo not like", value, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoIn(List<String> values) {
			addCriterion("isotwo in", values, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoNotIn(List<String> values) {
			addCriterion("isotwo not in", values, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoBetween(String value1, String value2) {
			addCriterion("isotwo between", value1, value2, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsotwoNotBetween(String value1, String value2) {
			addCriterion("isotwo not between", value1, value2, "isotwo");
			return (Criteria) this;
		}

		public Criteria andIsothreeIsNull() {
			addCriterion("isothree is null");
			return (Criteria) this;
		}

		public Criteria andIsothreeIsNotNull() {
			addCriterion("isothree is not null");
			return (Criteria) this;
		}

		public Criteria andIsothreeEqualTo(String value) {
			addCriterion("isothree =", value, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeNotEqualTo(String value) {
			addCriterion("isothree <>", value, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeGreaterThan(String value) {
			addCriterion("isothree >", value, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeGreaterThanOrEqualTo(String value) {
			addCriterion("isothree >=", value, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeLessThan(String value) {
			addCriterion("isothree <", value, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeLessThanOrEqualTo(String value) {
			addCriterion("isothree <=", value, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeLike(String value) {
			addCriterion("isothree like", value, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeNotLike(String value) {
			addCriterion("isothree not like", value, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeIn(List<String> values) {
			addCriterion("isothree in", values, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeNotIn(List<String> values) {
			addCriterion("isothree not in", values, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeBetween(String value1, String value2) {
			addCriterion("isothree between", value1, value2, "isothree");
			return (Criteria) this;
		}

		public Criteria andIsothreeNotBetween(String value1, String value2) {
			addCriterion("isothree not between", value1, value2, "isothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeIsNull() {
			addCriterion("faothree is null");
			return (Criteria) this;
		}

		public Criteria andFaothreeIsNotNull() {
			addCriterion("faothree is not null");
			return (Criteria) this;
		}

		public Criteria andFaothreeEqualTo(String value) {
			addCriterion("faothree =", value, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeNotEqualTo(String value) {
			addCriterion("faothree <>", value, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeGreaterThan(String value) {
			addCriterion("faothree >", value, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeGreaterThanOrEqualTo(String value) {
			addCriterion("faothree >=", value, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeLessThan(String value) {
			addCriterion("faothree <", value, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeLessThanOrEqualTo(String value) {
			addCriterion("faothree <=", value, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeLike(String value) {
			addCriterion("faothree like", value, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeNotLike(String value) {
			addCriterion("faothree not like", value, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeIn(List<String> values) {
			addCriterion("faothree in", values, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeNotIn(List<String> values) {
			addCriterion("faothree not in", values, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeBetween(String value1, String value2) {
			addCriterion("faothree between", value1, value2, "faothree");
			return (Criteria) this;
		}

		public Criteria andFaothreeNotBetween(String value1, String value2) {
			addCriterion("faothree not between", value1, value2, "faothree");
			return (Criteria) this;
		}

		public Criteria andFipsIsNull() {
			addCriterion("fips is null");
			return (Criteria) this;
		}

		public Criteria andFipsIsNotNull() {
			addCriterion("fips is not null");
			return (Criteria) this;
		}

		public Criteria andFipsEqualTo(String value) {
			addCriterion("fips =", value, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsNotEqualTo(String value) {
			addCriterion("fips <>", value, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsGreaterThan(String value) {
			addCriterion("fips >", value, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsGreaterThanOrEqualTo(String value) {
			addCriterion("fips >=", value, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsLessThan(String value) {
			addCriterion("fips <", value, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsLessThanOrEqualTo(String value) {
			addCriterion("fips <=", value, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsLike(String value) {
			addCriterion("fips like", value, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsNotLike(String value) {
			addCriterion("fips not like", value, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsIn(List<String> values) {
			addCriterion("fips in", values, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsNotIn(List<String> values) {
			addCriterion("fips not in", values, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsBetween(String value1, String value2) {
			addCriterion("fips between", value1, value2, "fips");
			return (Criteria) this;
		}

		public Criteria andFipsNotBetween(String value1, String value2) {
			addCriterion("fips not between", value1, value2, "fips");
			return (Criteria) this;
		}

		public Criteria andWbIsNull() {
			addCriterion("wb is null");
			return (Criteria) this;
		}

		public Criteria andWbIsNotNull() {
			addCriterion("wb is not null");
			return (Criteria) this;
		}

		public Criteria andWbEqualTo(String value) {
			addCriterion("wb =", value, "wb");
			return (Criteria) this;
		}

		public Criteria andWbNotEqualTo(String value) {
			addCriterion("wb <>", value, "wb");
			return (Criteria) this;
		}

		public Criteria andWbGreaterThan(String value) {
			addCriterion("wb >", value, "wb");
			return (Criteria) this;
		}

		public Criteria andWbGreaterThanOrEqualTo(String value) {
			addCriterion("wb >=", value, "wb");
			return (Criteria) this;
		}

		public Criteria andWbLessThan(String value) {
			addCriterion("wb <", value, "wb");
			return (Criteria) this;
		}

		public Criteria andWbLessThanOrEqualTo(String value) {
			addCriterion("wb <=", value, "wb");
			return (Criteria) this;
		}

		public Criteria andWbLike(String value) {
			addCriterion("wb like", value, "wb");
			return (Criteria) this;
		}

		public Criteria andWbNotLike(String value) {
			addCriterion("wb not like", value, "wb");
			return (Criteria) this;
		}

		public Criteria andWbIn(List<String> values) {
			addCriterion("wb in", values, "wb");
			return (Criteria) this;
		}

		public Criteria andWbNotIn(List<String> values) {
			addCriterion("wb not in", values, "wb");
			return (Criteria) this;
		}

		public Criteria andWbBetween(String value1, String value2) {
			addCriterion("wb between", value1, value2, "wb");
			return (Criteria) this;
		}

		public Criteria andWbNotBetween(String value1, String value2) {
			addCriterion("wb not between", value1, value2, "wb");
			return (Criteria) this;
		}

		public Criteria andIsofullIsNull() {
			addCriterion("isofull is null");
			return (Criteria) this;
		}

		public Criteria andIsofullIsNotNull() {
			addCriterion("isofull is not null");
			return (Criteria) this;
		}

		public Criteria andIsofullEqualTo(String value) {
			addCriterion("isofull =", value, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullNotEqualTo(String value) {
			addCriterion("isofull <>", value, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullGreaterThan(String value) {
			addCriterion("isofull >", value, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullGreaterThanOrEqualTo(String value) {
			addCriterion("isofull >=", value, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullLessThan(String value) {
			addCriterion("isofull <", value, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullLessThanOrEqualTo(String value) {
			addCriterion("isofull <=", value, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullLike(String value) {
			addCriterion("isofull like", value, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullNotLike(String value) {
			addCriterion("isofull not like", value, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullIn(List<String> values) {
			addCriterion("isofull in", values, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullNotIn(List<String> values) {
			addCriterion("isofull not in", values, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullBetween(String value1, String value2) {
			addCriterion("isofull between", value1, value2, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsofullNotBetween(String value1, String value2) {
			addCriterion("isofull not between", value1, value2, "isofull");
			return (Criteria) this;
		}

		public Criteria andIsoabbrIsNull() {
			addCriterion("isoabbr is null");
			return (Criteria) this;
		}

		public Criteria andIsoabbrIsNotNull() {
			addCriterion("isoabbr is not null");
			return (Criteria) this;
		}

		public Criteria andIsoabbrEqualTo(String value) {
			addCriterion("isoabbr =", value, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrNotEqualTo(String value) {
			addCriterion("isoabbr <>", value, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrGreaterThan(String value) {
			addCriterion("isoabbr >", value, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrGreaterThanOrEqualTo(String value) {
			addCriterion("isoabbr >=", value, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrLessThan(String value) {
			addCriterion("isoabbr <", value, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrLessThanOrEqualTo(String value) {
			addCriterion("isoabbr <=", value, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrLike(String value) {
			addCriterion("isoabbr like", value, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrNotLike(String value) {
			addCriterion("isoabbr not like", value, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrIn(List<String> values) {
			addCriterion("isoabbr in", values, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrNotIn(List<String> values) {
			addCriterion("isoabbr not in", values, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrBetween(String value1, String value2) {
			addCriterion("isoabbr between", value1, value2, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andIsoabbrNotBetween(String value1, String value2) {
			addCriterion("isoabbr not between", value1, value2, "isoabbr");
			return (Criteria) this;
		}

		public Criteria andContIsNull() {
			addCriterion("cont is null");
			return (Criteria) this;
		}

		public Criteria andContIsNotNull() {
			addCriterion("cont is not null");
			return (Criteria) this;
		}

		public Criteria andContEqualTo(String value) {
			addCriterion("cont =", value, "cont");
			return (Criteria) this;
		}

		public Criteria andContNotEqualTo(String value) {
			addCriterion("cont <>", value, "cont");
			return (Criteria) this;
		}

		public Criteria andContGreaterThan(String value) {
			addCriterion("cont >", value, "cont");
			return (Criteria) this;
		}

		public Criteria andContGreaterThanOrEqualTo(String value) {
			addCriterion("cont >=", value, "cont");
			return (Criteria) this;
		}

		public Criteria andContLessThan(String value) {
			addCriterion("cont <", value, "cont");
			return (Criteria) this;
		}

		public Criteria andContLessThanOrEqualTo(String value) {
			addCriterion("cont <=", value, "cont");
			return (Criteria) this;
		}

		public Criteria andContLike(String value) {
			addCriterion("cont like", value, "cont");
			return (Criteria) this;
		}

		public Criteria andContNotLike(String value) {
			addCriterion("cont not like", value, "cont");
			return (Criteria) this;
		}

		public Criteria andContIn(List<String> values) {
			addCriterion("cont in", values, "cont");
			return (Criteria) this;
		}

		public Criteria andContNotIn(List<String> values) {
			addCriterion("cont not in", values, "cont");
			return (Criteria) this;
		}

		public Criteria andContBetween(String value1, String value2) {
			addCriterion("cont between", value1, value2, "cont");
			return (Criteria) this;
		}

		public Criteria andContNotBetween(String value1, String value2) {
			addCriterion("cont not between", value1, value2, "cont");
			return (Criteria) this;
		}

		public Criteria andScntryIsNull() {
			addCriterion("scntry is null");
			return (Criteria) this;
		}

		public Criteria andScntryIsNotNull() {
			addCriterion("scntry is not null");
			return (Criteria) this;
		}

		public Criteria andScntryEqualTo(Integer value) {
			addCriterion("scntry =", value, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryNotEqualTo(Integer value) {
			addCriterion("scntry <>", value, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryGreaterThan(Integer value) {
			addCriterion("scntry >", value, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryGreaterThanOrEqualTo(Integer value) {
			addCriterion("scntry >=", value, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryLessThan(Integer value) {
			addCriterion("scntry <", value, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryLessThanOrEqualTo(Integer value) {
			addCriterion("scntry <=", value, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryIn(List<Integer> values) {
			addCriterion("scntry in", values, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryNotIn(List<Integer> values) {
			addCriterion("scntry not in", values, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryBetween(Integer value1, Integer value2) {
			addCriterion("scntry between", value1, value2, "scntry");
			return (Criteria) this;
		}

		public Criteria andScntryNotBetween(Integer value1, Integer value2) {
			addCriterion("scntry not between", value1, value2, "scntry");
			return (Criteria) this;
		}

		public Criteria andEcntryIsNull() {
			addCriterion("ecntry is null");
			return (Criteria) this;
		}

		public Criteria andEcntryIsNotNull() {
			addCriterion("ecntry is not null");
			return (Criteria) this;
		}

		public Criteria andEcntryEqualTo(Integer value) {
			addCriterion("ecntry =", value, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryNotEqualTo(Integer value) {
			addCriterion("ecntry <>", value, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryGreaterThan(Integer value) {
			addCriterion("ecntry >", value, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryGreaterThanOrEqualTo(Integer value) {
			addCriterion("ecntry >=", value, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryLessThan(Integer value) {
			addCriterion("ecntry <", value, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryLessThanOrEqualTo(Integer value) {
			addCriterion("ecntry <=", value, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryIn(List<Integer> values) {
			addCriterion("ecntry in", values, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryNotIn(List<Integer> values) {
			addCriterion("ecntry not in", values, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryBetween(Integer value1, Integer value2) {
			addCriterion("ecntry between", value1, value2, "ecntry");
			return (Criteria) this;
		}

		public Criteria andEcntryNotBetween(Integer value1, Integer value2) {
			addCriterion("ecntry not between", value1, value2, "ecntry");
			return (Criteria) this;
		}

		public Criteria andCchangeIsNull() {
			addCriterion("cchange is null");
			return (Criteria) this;
		}

		public Criteria andCchangeIsNotNull() {
			addCriterion("cchange is not null");
			return (Criteria) this;
		}

		public Criteria andCchangeEqualTo(Integer value) {
			addCriterion("cchange =", value, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeNotEqualTo(Integer value) {
			addCriterion("cchange <>", value, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeGreaterThan(Integer value) {
			addCriterion("cchange >", value, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeGreaterThanOrEqualTo(Integer value) {
			addCriterion("cchange >=", value, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeLessThan(Integer value) {
			addCriterion("cchange <", value, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeLessThanOrEqualTo(Integer value) {
			addCriterion("cchange <=", value, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeIn(List<Integer> values) {
			addCriterion("cchange in", values, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeNotIn(List<Integer> values) {
			addCriterion("cchange not in", values, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeBetween(Integer value1, Integer value2) {
			addCriterion("cchange between", value1, value2, "cchange");
			return (Criteria) this;
		}

		public Criteria andCchangeNotBetween(Integer value1, Integer value2) {
			addCriterion("cchange not between", value1, value2, "cchange");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table country
	 * @mbggenerated  Wed Nov 27 10:48:14 SGT 2013
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
     * This class corresponds to the database table country
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 25 13:11:54 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}