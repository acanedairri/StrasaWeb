package org.strasa.middleware.model;

import java.util.ArrayList;
import java.util.List;

public class GermplasmExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public GermplasmExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasm
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table germplasm
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

		public Criteria andGidIsNull() {
			addCriterion("gid is null");
			return (Criteria) this;
		}

		public Criteria andGidIsNotNull() {
			addCriterion("gid is not null");
			return (Criteria) this;
		}

		public Criteria andGidEqualTo(Integer value) {
			addCriterion("gid =", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidNotEqualTo(Integer value) {
			addCriterion("gid <>", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidGreaterThan(Integer value) {
			addCriterion("gid >", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidGreaterThanOrEqualTo(Integer value) {
			addCriterion("gid >=", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidLessThan(Integer value) {
			addCriterion("gid <", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidLessThanOrEqualTo(Integer value) {
			addCriterion("gid <=", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidIn(List<Integer> values) {
			addCriterion("gid in", values, "gid");
			return (Criteria) this;
		}

		public Criteria andGidNotIn(List<Integer> values) {
			addCriterion("gid not in", values, "gid");
			return (Criteria) this;
		}

		public Criteria andGidBetween(Integer value1, Integer value2) {
			addCriterion("gid between", value1, value2, "gid");
			return (Criteria) this;
		}

		public Criteria andGidNotBetween(Integer value1, Integer value2) {
			addCriterion("gid not between", value1, value2, "gid");
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

		public Criteria andOthernameIsNull() {
			addCriterion("othername is null");
			return (Criteria) this;
		}

		public Criteria andOthernameIsNotNull() {
			addCriterion("othername is not null");
			return (Criteria) this;
		}

		public Criteria andOthernameEqualTo(String value) {
			addCriterion("othername =", value, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameNotEqualTo(String value) {
			addCriterion("othername <>", value, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameGreaterThan(String value) {
			addCriterion("othername >", value, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameGreaterThanOrEqualTo(String value) {
			addCriterion("othername >=", value, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameLessThan(String value) {
			addCriterion("othername <", value, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameLessThanOrEqualTo(String value) {
			addCriterion("othername <=", value, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameLike(String value) {
			addCriterion("othername like", value, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameNotLike(String value) {
			addCriterion("othername not like", value, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameIn(List<String> values) {
			addCriterion("othername in", values, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameNotIn(List<String> values) {
			addCriterion("othername not in", values, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameBetween(String value1, String value2) {
			addCriterion("othername between", value1, value2, "othername");
			return (Criteria) this;
		}

		public Criteria andOthernameNotBetween(String value1, String value2) {
			addCriterion("othername not between", value1, value2, "othername");
			return (Criteria) this;
		}

		public Criteria andBreederIsNull() {
			addCriterion("breeder is null");
			return (Criteria) this;
		}

		public Criteria andBreederIsNotNull() {
			addCriterion("breeder is not null");
			return (Criteria) this;
		}

		public Criteria andBreederEqualTo(String value) {
			addCriterion("breeder =", value, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederNotEqualTo(String value) {
			addCriterion("breeder <>", value, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederGreaterThan(String value) {
			addCriterion("breeder >", value, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederGreaterThanOrEqualTo(String value) {
			addCriterion("breeder >=", value, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederLessThan(String value) {
			addCriterion("breeder <", value, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederLessThanOrEqualTo(String value) {
			addCriterion("breeder <=", value, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederLike(String value) {
			addCriterion("breeder like", value, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederNotLike(String value) {
			addCriterion("breeder not like", value, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederIn(List<String> values) {
			addCriterion("breeder in", values, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederNotIn(List<String> values) {
			addCriterion("breeder not in", values, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederBetween(String value1, String value2) {
			addCriterion("breeder between", value1, value2, "breeder");
			return (Criteria) this;
		}

		public Criteria andBreederNotBetween(String value1, String value2) {
			addCriterion("breeder not between", value1, value2, "breeder");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidIsNull() {
			addCriterion("germplasmtypeid is null");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidIsNotNull() {
			addCriterion("germplasmtypeid is not null");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidEqualTo(Integer value) {
			addCriterion("germplasmtypeid =", value, "germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidNotEqualTo(Integer value) {
			addCriterion("germplasmtypeid <>", value, "germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidGreaterThan(Integer value) {
			addCriterion("germplasmtypeid >", value, "germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidGreaterThanOrEqualTo(Integer value) {
			addCriterion("germplasmtypeid >=", value, "germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidLessThan(Integer value) {
			addCriterion("germplasmtypeid <", value, "germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidLessThanOrEqualTo(Integer value) {
			addCriterion("germplasmtypeid <=", value, "germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidIn(List<Integer> values) {
			addCriterion("germplasmtypeid in", values, "germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidNotIn(List<Integer> values) {
			addCriterion("germplasmtypeid not in", values, "germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidBetween(Integer value1, Integer value2) {
			addCriterion("germplasmtypeid between", value1, value2,
					"germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andGermplasmtypeidNotBetween(Integer value1,
				Integer value2) {
			addCriterion("germplasmtypeid not between", value1, value2,
					"germplasmtypeid");
			return (Criteria) this;
		}

		public Criteria andIrnumberIsNull() {
			addCriterion("irnumber is null");
			return (Criteria) this;
		}

		public Criteria andIrnumberIsNotNull() {
			addCriterion("irnumber is not null");
			return (Criteria) this;
		}

		public Criteria andIrnumberEqualTo(String value) {
			addCriterion("irnumber =", value, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberNotEqualTo(String value) {
			addCriterion("irnumber <>", value, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberGreaterThan(String value) {
			addCriterion("irnumber >", value, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberGreaterThanOrEqualTo(String value) {
			addCriterion("irnumber >=", value, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberLessThan(String value) {
			addCriterion("irnumber <", value, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberLessThanOrEqualTo(String value) {
			addCriterion("irnumber <=", value, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberLike(String value) {
			addCriterion("irnumber like", value, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberNotLike(String value) {
			addCriterion("irnumber not like", value, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberIn(List<String> values) {
			addCriterion("irnumber in", values, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberNotIn(List<String> values) {
			addCriterion("irnumber not in", values, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberBetween(String value1, String value2) {
			addCriterion("irnumber between", value1, value2, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrnumberNotBetween(String value1, String value2) {
			addCriterion("irnumber not between", value1, value2, "irnumber");
			return (Criteria) this;
		}

		public Criteria andIrcrossIsNull() {
			addCriterion("ircross is null");
			return (Criteria) this;
		}

		public Criteria andIrcrossIsNotNull() {
			addCriterion("ircross is not null");
			return (Criteria) this;
		}

		public Criteria andIrcrossEqualTo(String value) {
			addCriterion("ircross =", value, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossNotEqualTo(String value) {
			addCriterion("ircross <>", value, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossGreaterThan(String value) {
			addCriterion("ircross >", value, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossGreaterThanOrEqualTo(String value) {
			addCriterion("ircross >=", value, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossLessThan(String value) {
			addCriterion("ircross <", value, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossLessThanOrEqualTo(String value) {
			addCriterion("ircross <=", value, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossLike(String value) {
			addCriterion("ircross like", value, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossNotLike(String value) {
			addCriterion("ircross not like", value, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossIn(List<String> values) {
			addCriterion("ircross in", values, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossNotIn(List<String> values) {
			addCriterion("ircross not in", values, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossBetween(String value1, String value2) {
			addCriterion("ircross between", value1, value2, "ircross");
			return (Criteria) this;
		}

		public Criteria andIrcrossNotBetween(String value1, String value2) {
			addCriterion("ircross not between", value1, value2, "ircross");
			return (Criteria) this;
		}

		public Criteria andParentageIsNull() {
			addCriterion("parentage is null");
			return (Criteria) this;
		}

		public Criteria andParentageIsNotNull() {
			addCriterion("parentage is not null");
			return (Criteria) this;
		}

		public Criteria andParentageEqualTo(String value) {
			addCriterion("parentage =", value, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageNotEqualTo(String value) {
			addCriterion("parentage <>", value, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageGreaterThan(String value) {
			addCriterion("parentage >", value, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageGreaterThanOrEqualTo(String value) {
			addCriterion("parentage >=", value, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageLessThan(String value) {
			addCriterion("parentage <", value, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageLessThanOrEqualTo(String value) {
			addCriterion("parentage <=", value, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageLike(String value) {
			addCriterion("parentage like", value, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageNotLike(String value) {
			addCriterion("parentage not like", value, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageIn(List<String> values) {
			addCriterion("parentage in", values, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageNotIn(List<String> values) {
			addCriterion("parentage not in", values, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageBetween(String value1, String value2) {
			addCriterion("parentage between", value1, value2, "parentage");
			return (Criteria) this;
		}

		public Criteria andParentageNotBetween(String value1, String value2) {
			addCriterion("parentage not between", value1, value2, "parentage");
			return (Criteria) this;
		}

		public Criteria andFemaleparentIsNull() {
			addCriterion("femaleparent is null");
			return (Criteria) this;
		}

		public Criteria andFemaleparentIsNotNull() {
			addCriterion("femaleparent is not null");
			return (Criteria) this;
		}

		public Criteria andFemaleparentEqualTo(String value) {
			addCriterion("femaleparent =", value, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentNotEqualTo(String value) {
			addCriterion("femaleparent <>", value, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentGreaterThan(String value) {
			addCriterion("femaleparent >", value, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentGreaterThanOrEqualTo(String value) {
			addCriterion("femaleparent >=", value, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentLessThan(String value) {
			addCriterion("femaleparent <", value, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentLessThanOrEqualTo(String value) {
			addCriterion("femaleparent <=", value, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentLike(String value) {
			addCriterion("femaleparent like", value, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentNotLike(String value) {
			addCriterion("femaleparent not like", value, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentIn(List<String> values) {
			addCriterion("femaleparent in", values, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentNotIn(List<String> values) {
			addCriterion("femaleparent not in", values, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentBetween(String value1, String value2) {
			addCriterion("femaleparent between", value1, value2, "femaleparent");
			return (Criteria) this;
		}

		public Criteria andFemaleparentNotBetween(String value1, String value2) {
			addCriterion("femaleparent not between", value1, value2,
					"femaleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentIsNull() {
			addCriterion("maleparent is null");
			return (Criteria) this;
		}

		public Criteria andMaleparentIsNotNull() {
			addCriterion("maleparent is not null");
			return (Criteria) this;
		}

		public Criteria andMaleparentEqualTo(String value) {
			addCriterion("maleparent =", value, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentNotEqualTo(String value) {
			addCriterion("maleparent <>", value, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentGreaterThan(String value) {
			addCriterion("maleparent >", value, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentGreaterThanOrEqualTo(String value) {
			addCriterion("maleparent >=", value, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentLessThan(String value) {
			addCriterion("maleparent <", value, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentLessThanOrEqualTo(String value) {
			addCriterion("maleparent <=", value, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentLike(String value) {
			addCriterion("maleparent like", value, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentNotLike(String value) {
			addCriterion("maleparent not like", value, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentIn(List<String> values) {
			addCriterion("maleparent in", values, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentNotIn(List<String> values) {
			addCriterion("maleparent not in", values, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentBetween(String value1, String value2) {
			addCriterion("maleparent between", value1, value2, "maleparent");
			return (Criteria) this;
		}

		public Criteria andMaleparentNotBetween(String value1, String value2) {
			addCriterion("maleparent not between", value1, value2, "maleparent");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryIsNull() {
			addCriterion("selectionhistory is null");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryIsNotNull() {
			addCriterion("selectionhistory is not null");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryEqualTo(String value) {
			addCriterion("selectionhistory =", value, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryNotEqualTo(String value) {
			addCriterion("selectionhistory <>", value, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryGreaterThan(String value) {
			addCriterion("selectionhistory >", value, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryGreaterThanOrEqualTo(String value) {
			addCriterion("selectionhistory >=", value, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryLessThan(String value) {
			addCriterion("selectionhistory <", value, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryLessThanOrEqualTo(String value) {
			addCriterion("selectionhistory <=", value, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryLike(String value) {
			addCriterion("selectionhistory like", value, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryNotLike(String value) {
			addCriterion("selectionhistory not like", value, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryIn(List<String> values) {
			addCriterion("selectionhistory in", values, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryNotIn(List<String> values) {
			addCriterion("selectionhistory not in", values, "selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryBetween(String value1, String value2) {
			addCriterion("selectionhistory between", value1, value2,
					"selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSelectionhistoryNotBetween(String value1,
				String value2) {
			addCriterion("selectionhistory not between", value1, value2,
					"selectionhistory");
			return (Criteria) this;
		}

		public Criteria andSourceIsNull() {
			addCriterion("source is null");
			return (Criteria) this;
		}

		public Criteria andSourceIsNotNull() {
			addCriterion("source is not null");
			return (Criteria) this;
		}

		public Criteria andSourceEqualTo(String value) {
			addCriterion("source =", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotEqualTo(String value) {
			addCriterion("source <>", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThan(String value) {
			addCriterion("source >", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThanOrEqualTo(String value) {
			addCriterion("source >=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThan(String value) {
			addCriterion("source <", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThanOrEqualTo(String value) {
			addCriterion("source <=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLike(String value) {
			addCriterion("source like", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotLike(String value) {
			addCriterion("source not like", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceIn(List<String> values) {
			addCriterion("source in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotIn(List<String> values) {
			addCriterion("source not in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceBetween(String value1, String value2) {
			addCriterion("source between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotBetween(String value1, String value2) {
			addCriterion("source not between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNull() {
			addCriterion("remarks is null");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNotNull() {
			addCriterion("remarks is not null");
			return (Criteria) this;
		}

		public Criteria andRemarksEqualTo(String value) {
			addCriterion("remarks =", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotEqualTo(String value) {
			addCriterion("remarks <>", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThan(String value) {
			addCriterion("remarks >", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThanOrEqualTo(String value) {
			addCriterion("remarks >=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThan(String value) {
			addCriterion("remarks <", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThanOrEqualTo(String value) {
			addCriterion("remarks <=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLike(String value) {
			addCriterion("remarks like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotLike(String value) {
			addCriterion("remarks not like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksIn(List<String> values) {
			addCriterion("remarks in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotIn(List<String> values) {
			addCriterion("remarks not in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksBetween(String value1, String value2) {
			addCriterion("remarks between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotBetween(String value1, String value2) {
			addCriterion("remarks not between", value1, value2, "remarks");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table germplasm
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
     * This class corresponds to the database table germplasm
     *
     * @mbggenerated do_not_delete_during_merge Wed Oct 09 16:20:41 SGT 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}