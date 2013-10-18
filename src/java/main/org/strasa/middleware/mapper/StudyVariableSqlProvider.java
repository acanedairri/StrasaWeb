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
import org.strasa.middleware.model.StudyVariable;
import org.strasa.middleware.model.StudyVariableExample.Criteria;
import org.strasa.middleware.model.StudyVariableExample.Criterion;
import org.strasa.middleware.model.StudyVariableExample;

public class StudyVariableSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Oct 18 17:20:35 SGT 2013
	 */
	public String countByExample(StudyVariableExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("studyvariable");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Oct 18 17:20:35 SGT 2013
	 */
	public String deleteByExample(StudyVariableExample example) {
		BEGIN();
		DELETE_FROM("studyvariable");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Oct 18 17:20:35 SGT 2013
	 */
	public String insertSelective(StudyVariable record) {
		BEGIN();
		INSERT_INTO("studyvariable");
		if (record.getVariablecode() != null) {
			VALUES("variablecode", "#{variablecode,jdbcType=VARCHAR}");
		}
		if (record.getDescription() != null) {
			VALUES("description", "#{description,jdbcType=VARCHAR}");
		}
		if (record.getProperty() != null) {
			VALUES("property", "#{property,jdbcType=VARCHAR}");
		}
		if (record.getMethod() != null) {
			VALUES("method", "#{method,jdbcType=VARCHAR}");
		}
		if (record.getScale() != null) {
			VALUES("scale", "#{scale,jdbcType=INTEGER}");
		}
		if (record.getApplytofilter() != null) {
			VALUES("applytofilter", "#{applytofilter,jdbcType=CHAR}");
		}
		if (record.getDefaultcolumn() != null) {
			VALUES("defaultcolumn", "#{defaultcolumn,jdbcType=CHAR}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Oct 18 17:20:35 SGT 2013
	 */
	public String selectByExample(StudyVariableExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("variablecode");
		SELECT("description");
		SELECT("property");
		SELECT("method");
		SELECT("scale");
		SELECT("applytofilter");
		SELECT("defaultcolumn");
		FROM("studyvariable");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Oct 18 17:20:35 SGT 2013
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		StudyVariable record = (StudyVariable) parameter.get("record");
		StudyVariableExample example = (StudyVariableExample) parameter
				.get("example");
		BEGIN();
		UPDATE("studyvariable");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getVariablecode() != null) {
			SET("variablecode = #{record.variablecode,jdbcType=VARCHAR}");
		}
		if (record.getDescription() != null) {
			SET("description = #{record.description,jdbcType=VARCHAR}");
		}
		if (record.getProperty() != null) {
			SET("property = #{record.property,jdbcType=VARCHAR}");
		}
		if (record.getMethod() != null) {
			SET("method = #{record.method,jdbcType=VARCHAR}");
		}
		if (record.getScale() != null) {
			SET("scale = #{record.scale,jdbcType=INTEGER}");
		}
		if (record.getApplytofilter() != null) {
			SET("applytofilter = #{record.applytofilter,jdbcType=CHAR}");
		}
		if (record.getDefaultcolumn() != null) {
			SET("defaultcolumn = #{record.defaultcolumn,jdbcType=CHAR}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Oct 18 17:20:35 SGT 2013
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("studyvariable");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("variablecode = #{record.variablecode,jdbcType=VARCHAR}");
		SET("description = #{record.description,jdbcType=VARCHAR}");
		SET("property = #{record.property,jdbcType=VARCHAR}");
		SET("method = #{record.method,jdbcType=VARCHAR}");
		SET("scale = #{record.scale,jdbcType=INTEGER}");
		SET("applytofilter = #{record.applytofilter,jdbcType=CHAR}");
		SET("defaultcolumn = #{record.defaultcolumn,jdbcType=CHAR}");
		StudyVariableExample example = (StudyVariableExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Oct 18 17:20:35 SGT 2013
	 */
	public String updateByPrimaryKeySelective(StudyVariable record) {
		BEGIN();
		UPDATE("studyvariable");
		if (record.getVariablecode() != null) {
			SET("variablecode = #{variablecode,jdbcType=VARCHAR}");
		}
		if (record.getDescription() != null) {
			SET("description = #{description,jdbcType=VARCHAR}");
		}
		if (record.getProperty() != null) {
			SET("property = #{property,jdbcType=VARCHAR}");
		}
		if (record.getMethod() != null) {
			SET("method = #{method,jdbcType=VARCHAR}");
		}
		if (record.getScale() != null) {
			SET("scale = #{scale,jdbcType=INTEGER}");
		}
		if (record.getApplytofilter() != null) {
			SET("applytofilter = #{applytofilter,jdbcType=CHAR}");
		}
		if (record.getDefaultcolumn() != null) {
			SET("defaultcolumn = #{defaultcolumn,jdbcType=CHAR}");
		}
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Fri Oct 18 17:20:35 SGT 2013
	 */
	protected void applyWhere(StudyVariableExample example,
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