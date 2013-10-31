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

import org.strasa.middleware.model.Georef;
import org.strasa.middleware.model.GeorefExample;
import org.strasa.middleware.model.GeorefExample.Criteria;
import org.strasa.middleware.model.GeorefExample.Criterion;

public class GeorefSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 31 10:09:04 SGT 2013
	 */
	public String countByExample(GeorefExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("georef");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 31 10:09:04 SGT 2013
	 */
	public String deleteByExample(GeorefExample example) {
		BEGIN();
		DELETE_FROM("georef");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 31 10:09:04 SGT 2013
	 */
	public String insertSelective(Georef record) {
		BEGIN();
		INSERT_INTO("georef");
		if (record.getLocid() != null) {
			VALUES("locid", "#{locid,jdbcType=INTEGER}");
		}
		if (record.getLlpn() != null) {
			VALUES("llpn", "#{llpn,jdbcType=INTEGER}");
		}
		if (record.getLat() != null) {
			VALUES("lat", "#{lat,jdbcType=DOUBLE}");
		}
		if (record.getLon() != null) {
			VALUES("lon", "#{lon,jdbcType=DOUBLE}");
		}
		if (record.getAlt() != null) {
			VALUES("alt", "#{alt,jdbcType=DOUBLE}");
		}
		if (record.getLlsource() != null) {
			VALUES("llsource", "#{llsource,jdbcType=INTEGER}");
		}
		if (record.getLlFmt() != null) {
			VALUES("ll_fmt", "#{llFmt,jdbcType=INTEGER}");
		}
		if (record.getLlDatum() != null) {
			VALUES("ll_datum", "#{llDatum,jdbcType=INTEGER}");
		}
		if (record.getLlUncert() != null) {
			VALUES("ll_uncert", "#{llUncert,jdbcType=DOUBLE}");
		}
		if (record.getLlref() != null) {
			VALUES("llref", "#{llref,jdbcType=INTEGER}");
		}
		if (record.getLldate() != null) {
			VALUES("lldate", "#{lldate,jdbcType=INTEGER}");
		}
		if (record.getLluid() != null) {
			VALUES("lluid", "#{lluid,jdbcType=INTEGER}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 31 10:09:04 SGT 2013
	 */
	public String selectByExample(GeorefExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("locid");
		} else {
			SELECT("locid");
		}
		SELECT("llpn");
		SELECT("lat");
		SELECT("lon");
		SELECT("alt");
		SELECT("llsource");
		SELECT("ll_fmt");
		SELECT("ll_datum");
		SELECT("ll_uncert");
		SELECT("llref");
		SELECT("lldate");
		SELECT("lluid");
		FROM("georef");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 31 10:09:04 SGT 2013
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		Georef record = (Georef) parameter.get("record");
		GeorefExample example = (GeorefExample) parameter.get("example");
		BEGIN();
		UPDATE("georef");
		if (record.getLocid() != null) {
			SET("locid = #{record.locid,jdbcType=INTEGER}");
		}
		if (record.getLlpn() != null) {
			SET("llpn = #{record.llpn,jdbcType=INTEGER}");
		}
		if (record.getLat() != null) {
			SET("lat = #{record.lat,jdbcType=DOUBLE}");
		}
		if (record.getLon() != null) {
			SET("lon = #{record.lon,jdbcType=DOUBLE}");
		}
		if (record.getAlt() != null) {
			SET("alt = #{record.alt,jdbcType=DOUBLE}");
		}
		if (record.getLlsource() != null) {
			SET("llsource = #{record.llsource,jdbcType=INTEGER}");
		}
		if (record.getLlFmt() != null) {
			SET("ll_fmt = #{record.llFmt,jdbcType=INTEGER}");
		}
		if (record.getLlDatum() != null) {
			SET("ll_datum = #{record.llDatum,jdbcType=INTEGER}");
		}
		if (record.getLlUncert() != null) {
			SET("ll_uncert = #{record.llUncert,jdbcType=DOUBLE}");
		}
		if (record.getLlref() != null) {
			SET("llref = #{record.llref,jdbcType=INTEGER}");
		}
		if (record.getLldate() != null) {
			SET("lldate = #{record.lldate,jdbcType=INTEGER}");
		}
		if (record.getLluid() != null) {
			SET("lluid = #{record.lluid,jdbcType=INTEGER}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 31 10:09:04 SGT 2013
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("georef");
		SET("locid = #{record.locid,jdbcType=INTEGER}");
		SET("llpn = #{record.llpn,jdbcType=INTEGER}");
		SET("lat = #{record.lat,jdbcType=DOUBLE}");
		SET("lon = #{record.lon,jdbcType=DOUBLE}");
		SET("alt = #{record.alt,jdbcType=DOUBLE}");
		SET("llsource = #{record.llsource,jdbcType=INTEGER}");
		SET("ll_fmt = #{record.llFmt,jdbcType=INTEGER}");
		SET("ll_datum = #{record.llDatum,jdbcType=INTEGER}");
		SET("ll_uncert = #{record.llUncert,jdbcType=DOUBLE}");
		SET("llref = #{record.llref,jdbcType=INTEGER}");
		SET("lldate = #{record.lldate,jdbcType=INTEGER}");
		SET("lluid = #{record.lluid,jdbcType=INTEGER}");
		GeorefExample example = (GeorefExample) parameter.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 31 10:09:04 SGT 2013
	 */
	protected void applyWhere(GeorefExample example,
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