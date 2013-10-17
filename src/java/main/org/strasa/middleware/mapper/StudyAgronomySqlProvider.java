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
import org.strasa.middleware.model.StudyAgronomy;
import org.strasa.middleware.model.StudyAgronomyExample.Criteria;
import org.strasa.middleware.model.StudyAgronomyExample.Criterion;
import org.strasa.middleware.model.StudyAgronomyExample;

public class StudyAgronomySqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String countByExample(StudyAgronomyExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("studyagronomy");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String deleteByExample(StudyAgronomyExample example) {
		BEGIN();
		DELETE_FROM("studyagronomy");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String insertSelective(StudyAgronomy record) {
		BEGIN();
		INSERT_INTO("studyagronomy");
		if (record.getStudysiteid() != null) {
			VALUES("studysiteid", "#{studysiteid,jdbcType=INTEGER}");
		}
		if (record.getPlantingtypeid() != null) {
			VALUES("plantingtypeid", "#{plantingtypeid,jdbcType=INTEGER}");
		}
		if (record.getSowingdate() != null) {
			VALUES("sowingdate", "#{sowingdate,jdbcType=DATE}");
		}
		if (record.getHarvestdate() != null) {
			VALUES("harvestdate", "#{harvestdate,jdbcType=DATE}");
		}
		if (record.getFertilization() != null) {
			VALUES("fertilization", "#{fertilization,jdbcType=VARCHAR}");
		}
		if (record.getDensity() != null) {
			VALUES("density", "#{density,jdbcType=VARCHAR}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String selectByExample(StudyAgronomyExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("studysiteid");
		SELECT("plantingtypeid");
		SELECT("sowingdate");
		SELECT("harvestdate");
		SELECT("fertilization");
		SELECT("density");
		FROM("studyagronomy");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		StudyAgronomy record = (StudyAgronomy) parameter.get("record");
		StudyAgronomyExample example = (StudyAgronomyExample) parameter
				.get("example");
		BEGIN();
		UPDATE("studyagronomy");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getStudysiteid() != null) {
			SET("studysiteid = #{record.studysiteid,jdbcType=INTEGER}");
		}
		if (record.getPlantingtypeid() != null) {
			SET("plantingtypeid = #{record.plantingtypeid,jdbcType=INTEGER}");
		}
		if (record.getSowingdate() != null) {
			SET("sowingdate = #{record.sowingdate,jdbcType=DATE}");
		}
		if (record.getHarvestdate() != null) {
			SET("harvestdate = #{record.harvestdate,jdbcType=DATE}");
		}
		if (record.getFertilization() != null) {
			SET("fertilization = #{record.fertilization,jdbcType=VARCHAR}");
		}
		if (record.getDensity() != null) {
			SET("density = #{record.density,jdbcType=VARCHAR}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("studyagronomy");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("studysiteid = #{record.studysiteid,jdbcType=INTEGER}");
		SET("plantingtypeid = #{record.plantingtypeid,jdbcType=INTEGER}");
		SET("sowingdate = #{record.sowingdate,jdbcType=DATE}");
		SET("harvestdate = #{record.harvestdate,jdbcType=DATE}");
		SET("fertilization = #{record.fertilization,jdbcType=VARCHAR}");
		SET("density = #{record.density,jdbcType=VARCHAR}");
		StudyAgronomyExample example = (StudyAgronomyExample) parameter
				.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	public String updateByPrimaryKeySelective(StudyAgronomy record) {
		BEGIN();
		UPDATE("studyagronomy");
		if (record.getStudysiteid() != null) {
			SET("studysiteid = #{studysiteid,jdbcType=INTEGER}");
		}
		if (record.getPlantingtypeid() != null) {
			SET("plantingtypeid = #{plantingtypeid,jdbcType=INTEGER}");
		}
		if (record.getSowingdate() != null) {
			SET("sowingdate = #{sowingdate,jdbcType=DATE}");
		}
		if (record.getHarvestdate() != null) {
			SET("harvestdate = #{harvestdate,jdbcType=DATE}");
		}
		if (record.getFertilization() != null) {
			SET("fertilization = #{fertilization,jdbcType=VARCHAR}");
		}
		if (record.getDensity() != null) {
			SET("density = #{density,jdbcType=VARCHAR}");
		}
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyagronomy
	 * @mbggenerated  Thu Oct 17 14:15:13 SGT 2013
	 */
	protected void applyWhere(StudyAgronomyExample example,
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