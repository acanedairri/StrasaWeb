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

import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.ProjectExample;
import org.strasa.middleware.model.ProjectExample.Criteria;
import org.strasa.middleware.model.ProjectExample.Criterion;

public class ProjectSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String countByExample(ProjectExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("project");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String deleteByExample(ProjectExample example) {
		BEGIN();
		DELETE_FROM("project");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String insertSelective(Project record) {
		BEGIN();
		INSERT_INTO("project");
		if (record.getUserid() != null) {
			VALUES("userid", "#{userid,jdbcType=INTEGER}");
		}
		if (record.getProgramid() != null) {
			VALUES("programid", "#{programid,jdbcType=INTEGER}");
		}
		if (record.getName() != null) {
			VALUES("name", "#{name,jdbcType=VARCHAR}");
		}
		if (record.getObjective() != null) {
			VALUES("objective", "#{objective,jdbcType=VARCHAR}");
		}
		if (record.getPi() != null) {
			VALUES("pi", "#{pi,jdbcType=VARCHAR}");
		}
		if (record.getLeadinginstitute() != null) {
			VALUES("leadinginstitute", "#{leadinginstitute,jdbcType=VARCHAR}");
		}
		if (record.getCollaborators() != null) {
			VALUES("collaborators", "#{collaborators,jdbcType=VARCHAR}");
		}
		if (record.getFundingagency() != null) {
			VALUES("fundingagency", "#{fundingagency,jdbcType=VARCHAR}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String selectByExample(ProjectExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("userid");
		SELECT("programid");
		SELECT("name");
		SELECT("objective");
		SELECT("pi");
		SELECT("leadinginstitute");
		SELECT("collaborators");
		SELECT("fundingagency");
		FROM("project");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		Project record = (Project) parameter.get("record");
		ProjectExample example = (ProjectExample) parameter.get("example");
		BEGIN();
		UPDATE("project");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getUserid() != null) {
			SET("userid = #{record.userid,jdbcType=INTEGER}");
		}
		if (record.getProgramid() != null) {
			SET("programid = #{record.programid,jdbcType=INTEGER}");
		}
		if (record.getName() != null) {
			SET("name = #{record.name,jdbcType=VARCHAR}");
		}
		if (record.getObjective() != null) {
			SET("objective = #{record.objective,jdbcType=VARCHAR}");
		}
		if (record.getPi() != null) {
			SET("pi = #{record.pi,jdbcType=VARCHAR}");
		}
		if (record.getLeadinginstitute() != null) {
			SET("leadinginstitute = #{record.leadinginstitute,jdbcType=VARCHAR}");
		}
		if (record.getCollaborators() != null) {
			SET("collaborators = #{record.collaborators,jdbcType=VARCHAR}");
		}
		if (record.getFundingagency() != null) {
			SET("fundingagency = #{record.fundingagency,jdbcType=VARCHAR}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("project");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("userid = #{record.userid,jdbcType=INTEGER}");
		SET("programid = #{record.programid,jdbcType=INTEGER}");
		SET("name = #{record.name,jdbcType=VARCHAR}");
		SET("objective = #{record.objective,jdbcType=VARCHAR}");
		SET("pi = #{record.pi,jdbcType=VARCHAR}");
		SET("leadinginstitute = #{record.leadinginstitute,jdbcType=VARCHAR}");
		SET("collaborators = #{record.collaborators,jdbcType=VARCHAR}");
		SET("fundingagency = #{record.fundingagency,jdbcType=VARCHAR}");
		ProjectExample example = (ProjectExample) parameter.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	public String updateByPrimaryKeySelective(Project record) {
		BEGIN();
		UPDATE("project");
		if (record.getUserid() != null) {
			SET("userid = #{userid,jdbcType=INTEGER}");
		}
		if (record.getProgramid() != null) {
			SET("programid = #{programid,jdbcType=INTEGER}");
		}
		if (record.getName() != null) {
			SET("name = #{name,jdbcType=VARCHAR}");
		}
		if (record.getObjective() != null) {
			SET("objective = #{objective,jdbcType=VARCHAR}");
		}
		if (record.getPi() != null) {
			SET("pi = #{pi,jdbcType=VARCHAR}");
		}
		if (record.getLeadinginstitute() != null) {
			SET("leadinginstitute = #{leadinginstitute,jdbcType=VARCHAR}");
		}
		if (record.getCollaborators() != null) {
			SET("collaborators = #{collaborators,jdbcType=VARCHAR}");
		}
		if (record.getFundingagency() != null) {
			SET("fundingagency = #{fundingagency,jdbcType=VARCHAR}");
		}
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	protected void applyWhere(ProjectExample example,
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