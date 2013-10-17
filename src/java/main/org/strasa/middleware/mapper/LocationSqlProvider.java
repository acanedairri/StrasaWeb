package org.strasa.middleware.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.LocationExample.Criteria;
import org.strasa.middleware.model.LocationExample.Criterion;
import org.strasa.middleware.model.LocationExample;

public class LocationSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String countByExample(LocationExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("location");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String deleteByExample(LocationExample example) {
		BEGIN();
		DELETE_FROM("location");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String insertSelective(Location record) {
		BEGIN();
		INSERT_INTO("location");
		if (record.getLtype() != null) {
			VALUES("ltype", "#{ltype,jdbcType=INTEGER}");
		}
		if (record.getNllp() != null) {
			VALUES("nllp", "#{nllp,jdbcType=INTEGER}");
		}
		if (record.getLname() != null) {
			VALUES("lname", "#{lname,jdbcType=VARCHAR}");
		}
		if (record.getLabbr() != null) {
			VALUES("labbr", "#{labbr,jdbcType=VARCHAR}");
		}
		if (record.getSnl3id() != null) {
			VALUES("snl3id", "#{snl3id,jdbcType=INTEGER}");
		}
		if (record.getSnl2id() != null) {
			VALUES("snl2id", "#{snl2id,jdbcType=INTEGER}");
		}
		if (record.getSnl1id() != null) {
			VALUES("snl1id", "#{snl1id,jdbcType=INTEGER}");
		}
		if (record.getCntryid() != null) {
			VALUES("cntryid", "#{cntryid,jdbcType=INTEGER}");
		}
		if (record.getLrplce() != null) {
			VALUES("lrplce", "#{lrplce,jdbcType=INTEGER}");
		}
		if (record.getNnpid() != null) {
			VALUES("nnpid", "#{nnpid,jdbcType=INTEGER}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String selectByExample(LocationExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("ltype");
		SELECT("nllp");
		SELECT("lname");
		SELECT("labbr");
		SELECT("snl3id");
		SELECT("snl2id");
		SELECT("snl1id");
		SELECT("cntryid");
		SELECT("lrplce");
		SELECT("nnpid");
		FROM("location");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		Location record = (Location) parameter.get("record");
		LocationExample example = (LocationExample) parameter.get("example");
		BEGIN();
		UPDATE("location");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getLtype() != null) {
			SET("ltype = #{record.ltype,jdbcType=INTEGER}");
		}
		if (record.getNllp() != null) {
			SET("nllp = #{record.nllp,jdbcType=INTEGER}");
		}
		if (record.getLname() != null) {
			SET("lname = #{record.lname,jdbcType=VARCHAR}");
		}
		if (record.getLabbr() != null) {
			SET("labbr = #{record.labbr,jdbcType=VARCHAR}");
		}
		if (record.getSnl3id() != null) {
			SET("snl3id = #{record.snl3id,jdbcType=INTEGER}");
		}
		if (record.getSnl2id() != null) {
			SET("snl2id = #{record.snl2id,jdbcType=INTEGER}");
		}
		if (record.getSnl1id() != null) {
			SET("snl1id = #{record.snl1id,jdbcType=INTEGER}");
		}
		if (record.getCntryid() != null) {
			SET("cntryid = #{record.cntryid,jdbcType=INTEGER}");
		}
		if (record.getLrplce() != null) {
			SET("lrplce = #{record.lrplce,jdbcType=INTEGER}");
		}
		if (record.getNnpid() != null) {
			SET("nnpid = #{record.nnpid,jdbcType=INTEGER}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("location");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("ltype = #{record.ltype,jdbcType=INTEGER}");
		SET("nllp = #{record.nllp,jdbcType=INTEGER}");
		SET("lname = #{record.lname,jdbcType=VARCHAR}");
		SET("labbr = #{record.labbr,jdbcType=VARCHAR}");
		SET("snl3id = #{record.snl3id,jdbcType=INTEGER}");
		SET("snl2id = #{record.snl2id,jdbcType=INTEGER}");
		SET("snl1id = #{record.snl1id,jdbcType=INTEGER}");
		SET("cntryid = #{record.cntryid,jdbcType=INTEGER}");
		SET("lrplce = #{record.lrplce,jdbcType=INTEGER}");
		SET("nnpid = #{record.nnpid,jdbcType=INTEGER}");
		LocationExample example = (LocationExample) parameter.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String updateByPrimaryKeySelective(Location record) {
		BEGIN();
		UPDATE("location");
		if (record.getLtype() != null) {
			SET("ltype = #{ltype,jdbcType=INTEGER}");
		}
		if (record.getNllp() != null) {
			SET("nllp = #{nllp,jdbcType=INTEGER}");
		}
		if (record.getLname() != null) {
			SET("lname = #{lname,jdbcType=VARCHAR}");
		}
		if (record.getLabbr() != null) {
			SET("labbr = #{labbr,jdbcType=VARCHAR}");
		}
		if (record.getSnl3id() != null) {
			SET("snl3id = #{snl3id,jdbcType=INTEGER}");
		}
		if (record.getSnl2id() != null) {
			SET("snl2id = #{snl2id,jdbcType=INTEGER}");
		}
		if (record.getSnl1id() != null) {
			SET("snl1id = #{snl1id,jdbcType=INTEGER}");
		}
		if (record.getCntryid() != null) {
			SET("cntryid = #{cntryid,jdbcType=INTEGER}");
		}
		if (record.getLrplce() != null) {
			SET("lrplce = #{lrplce,jdbcType=INTEGER}");
		}
		if (record.getNnpid() != null) {
			SET("nnpid = #{nnpid,jdbcType=INTEGER}");
		}
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	protected void applyWhere(LocationExample example,
			boolean includeExamplePhrase) {
		if (example == null) {
			return;
		}
		String parmPhrase1;
		String parmPhrase1_th;
		String parmPhrase2;
		String parmPhrase2_th;
		String parmPhrase3;
		String parmPhrase3_th;
		if (includeExamplePhrase) {
			parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		} else {
			parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		}
		StringBuilder sb = new StringBuilder();
		List<Criteria> oredCriteria = example.getOredCriteria();
		boolean firstCriteria = true;
		for (int i = 0; i < oredCriteria.size(); i++) {
			Criteria criteria = oredCriteria.get(i);
			if (criteria.isValid()) {
				if (firstCriteria) {
					firstCriteria = false;
				} else {
					sb.append(" or ");
				}
				sb.append('(');
				List<Criterion> criterions = criteria.getAllCriteria();
				boolean firstCriterion = true;
				for (int j = 0; j < criterions.size(); j++) {
					Criterion criterion = criterions.get(j);
					if (firstCriterion) {
						firstCriterion = false;
					} else {
						sb.append(" and ");
					}
					if (criterion.isNoValue()) {
						sb.append(criterion.getCondition());
					} else if (criterion.isSingleValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase1,
									criterion.getCondition(), i, j));
						} else {
							sb.append(String.format(parmPhrase1_th,
									criterion.getCondition(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase2,
									criterion.getCondition(), i, j, i, j));
						} else {
							sb.append(String.format(parmPhrase2_th,
									criterion.getCondition(), i, j,
									criterion.getTypeHandler(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isListValue()) {
						sb.append(criterion.getCondition());
						sb.append(" (");
						List<?> listItems = (List<?>) criterion.getValue();
						boolean comma = false;
						for (int k = 0; k < listItems.size(); k++) {
							if (comma) {
								sb.append(", ");
							} else {
								comma = true;
							}
							if (criterion.getTypeHandler() == null) {
								sb.append(String.format(parmPhrase3, i, j, k));
							} else {
								sb.append(String.format(parmPhrase3_th, i, j,
										k, criterion.getTypeHandler()));
							}
						}
						sb.append(')');
					}
				}
				sb.append(')');
			}
		}
		if (sb.length() > 0) {
			WHERE(sb.toString());
		}
	}
}