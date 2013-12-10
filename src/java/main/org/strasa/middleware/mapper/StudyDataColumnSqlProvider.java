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
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.middleware.model.StudyDataColumnExample.Criteria;
import org.strasa.middleware.model.StudyDataColumnExample.Criterion;
import org.strasa.middleware.model.StudyDataColumnExample;

public class StudyDataColumnSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	public String countByExample(StudyDataColumnExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("studydatacolumn");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	public String deleteByExample(StudyDataColumnExample example) {
		BEGIN();
		DELETE_FROM("studydatacolumn");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	public String insertSelective(StudyDataColumn record) {
		BEGIN();
		INSERT_INTO("studydatacolumn");
		if (record.getStudyid() != null) {
			VALUES("studyid", "#{studyid,jdbcType=INTEGER}");
		}
		if (record.getColumnheader() != null) {
			VALUES("columnheader", "#{columnheader,jdbcType=VARCHAR}");
		}
		if (record.getDatatype() != null) {
			VALUES("datatype", "#{datatype,jdbcType=CHAR}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	public String selectByExample(StudyDataColumnExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("studyid");
		SELECT("columnheader");
		SELECT("datatype");
		FROM("studydatacolumn");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		StudyDataColumn record = (StudyDataColumn) parameter.get("record");
		StudyDataColumnExample example = (StudyDataColumnExample) parameter
				.get("example");
		BEGIN();
		UPDATE("studydatacolumn");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getStudyid() != null) {
			SET("studyid = #{record.studyid,jdbcType=INTEGER}");
		}
		if (record.getColumnheader() != null) {
			SET("columnheader = #{record.columnheader,jdbcType=VARCHAR}");
		}
		if (record.getDatatype() != null) {
			SET("datatype = #{record.datatype,jdbcType=CHAR}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("studydatacolumn");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("studyid = #{record.studyid,jdbcType=INTEGER}");
		SET("columnheader = #{record.columnheader,jdbcType=VARCHAR}");
		SET("datatype = #{record.datatype,jdbcType=CHAR}");
		StudyDataColumnExample example = (StudyDataColumnExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	public String updateByPrimaryKeySelective(StudyDataColumn record) {
		BEGIN();
		UPDATE("studydatacolumn");
		if (record.getStudyid() != null) {
			SET("studyid = #{studyid,jdbcType=INTEGER}");
		}
		if (record.getColumnheader() != null) {
			SET("columnheader = #{columnheader,jdbcType=VARCHAR}");
		}
		if (record.getDatatype() != null) {
			SET("datatype = #{datatype,jdbcType=CHAR}");
		}
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	protected void applyWhere(StudyDataColumnExample example,
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