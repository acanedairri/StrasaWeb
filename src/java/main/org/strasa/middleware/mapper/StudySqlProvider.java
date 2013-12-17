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

import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyExample;
import org.strasa.middleware.model.StudyExample.Criteria;
import org.strasa.middleware.model.StudyExample.Criterion;

public class StudySqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	public String countByExample(StudyExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("study");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	public String deleteByExample(StudyExample example) {
		BEGIN();
		DELETE_FROM("study");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	public String insertSelective(Study record) {
		BEGIN();
		INSERT_INTO("study");
		if (record.getUserid() != null) {
			VALUES("userid", "#{userid,jdbcType=INTEGER}");
		}
		if (record.getProgramid() != null) {
			VALUES("programid", "#{programid,jdbcType=INTEGER}");
		}
		if (record.getProjectid() != null) {
			VALUES("projectid", "#{projectid,jdbcType=INTEGER}");
		}
		if (record.getName() != null) {
			VALUES("name", "#{name,jdbcType=VARCHAR}");
		}
		if (record.getDescription() != null) {
			VALUES("description", "#{description,jdbcType=VARCHAR}");
		}
		if (record.getStudytypeid() != null) {
			VALUES("studytypeid", "#{studytypeid,jdbcType=INTEGER}");
		}
		if (record.getStartyear() != null) {
			VALUES("startyear", "#{startyear,jdbcType=VARCHAR}");
		}
		if (record.getEndyear() != null) {
			VALUES("endyear", "#{endyear,jdbcType=VARCHAR}");
		}
		if (record.getRemarks() != null) {
			VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
		}
		if (record.getShared() != null) {
			VALUES("shared", "#{shared,jdbcType=CHAR}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	public String selectByExample(StudyExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("userid");
		SELECT("programid");
		SELECT("projectid");
		SELECT("name");
		SELECT("description");
		SELECT("studytypeid");
		SELECT("startyear");
		SELECT("endyear");
		SELECT("remarks");
		SELECT("shared");
		FROM("study");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		Study record = (Study) parameter.get("record");
		StudyExample example = (StudyExample) parameter.get("example");
		BEGIN();
		UPDATE("study");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getUserid() != null) {
			SET("userid = #{record.userid,jdbcType=INTEGER}");
		}
		if (record.getProgramid() != null) {
			SET("programid = #{record.programid,jdbcType=INTEGER}");
		}
		if (record.getProjectid() != null) {
			SET("projectid = #{record.projectid,jdbcType=INTEGER}");
		}
		if (record.getName() != null) {
			SET("name = #{record.name,jdbcType=VARCHAR}");
		}
		if (record.getDescription() != null) {
			SET("description = #{record.description,jdbcType=VARCHAR}");
		}
		if (record.getStudytypeid() != null) {
			SET("studytypeid = #{record.studytypeid,jdbcType=INTEGER}");
		}
		if (record.getStartyear() != null) {
			SET("startyear = #{record.startyear,jdbcType=VARCHAR}");
		}
		if (record.getEndyear() != null) {
			SET("endyear = #{record.endyear,jdbcType=VARCHAR}");
		}
		if (record.getRemarks() != null) {
			SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
		}
		if (record.getShared() != null) {
			SET("shared = #{record.shared,jdbcType=CHAR}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("study");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("userid = #{record.userid,jdbcType=INTEGER}");
		SET("programid = #{record.programid,jdbcType=INTEGER}");
		SET("projectid = #{record.projectid,jdbcType=INTEGER}");
		SET("name = #{record.name,jdbcType=VARCHAR}");
		SET("description = #{record.description,jdbcType=VARCHAR}");
		SET("studytypeid = #{record.studytypeid,jdbcType=INTEGER}");
		SET("startyear = #{record.startyear,jdbcType=VARCHAR}");
		SET("endyear = #{record.endyear,jdbcType=VARCHAR}");
		SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
		SET("shared = #{record.shared,jdbcType=CHAR}");
		StudyExample example = (StudyExample) parameter.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	public String updateByPrimaryKeySelective(Study record) {
		BEGIN();
		UPDATE("study");
		if (record.getUserid() != null) {
			SET("userid = #{userid,jdbcType=INTEGER}");
		}
		if (record.getProgramid() != null) {
			SET("programid = #{programid,jdbcType=INTEGER}");
		}
		if (record.getProjectid() != null) {
			SET("projectid = #{projectid,jdbcType=INTEGER}");
		}
		if (record.getName() != null) {
			SET("name = #{name,jdbcType=VARCHAR}");
		}
		if (record.getDescription() != null) {
			SET("description = #{description,jdbcType=VARCHAR}");
		}
		if (record.getStudytypeid() != null) {
			SET("studytypeid = #{studytypeid,jdbcType=INTEGER}");
		}
		if (record.getStartyear() != null) {
			SET("startyear = #{startyear,jdbcType=VARCHAR}");
		}
		if (record.getEndyear() != null) {
			SET("endyear = #{endyear,jdbcType=VARCHAR}");
		}
		if (record.getRemarks() != null) {
			SET("remarks = #{remarks,jdbcType=VARCHAR}");
		}
		if (record.getShared() != null) {
			SET("shared = #{shared,jdbcType=CHAR}");
		}
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	protected void applyWhere(StudyExample example, boolean includeExamplePhrase) {
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