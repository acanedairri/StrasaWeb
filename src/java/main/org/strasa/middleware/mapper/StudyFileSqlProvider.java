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

import org.strasa.middleware.model.StudyFile;
import org.strasa.middleware.model.StudyFileExample;
import org.strasa.middleware.model.StudyFileExample.Criteria;
import org.strasa.middleware.model.StudyFileExample.Criterion;

public class StudyFileSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	public String countByExample(StudyFileExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("studyfile");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	public String deleteByExample(StudyFileExample example) {
		BEGIN();
		DELETE_FROM("studyfile");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	public String insertSelective(StudyFile record) {
		BEGIN();
		INSERT_INTO("studyfile");
		if (record.getUserid() != null) {
			VALUES("userid", "#{userid,jdbcType=INTEGER}");
		}
		if (record.getStudyid() != null) {
			VALUES("studyid", "#{studyid,jdbcType=INTEGER}");
		}
		if (record.getFilename() != null) {
			VALUES("filename", "#{filename,jdbcType=VARCHAR}");
		}
		if (record.getFilenamegen() != null) {
			VALUES("filenamegen", "#{filenamegen,jdbcType=VARCHAR}");
		}
		if (record.getFilepath() != null) {
			VALUES("filepath", "#{filepath,jdbcType=VARCHAR}");
		}
		if (record.getTypeofdata() != null) {
			VALUES("typeofdata", "#{typeofdata,jdbcType=CHAR}");
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	public String selectByExample(StudyFileExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("userid");
		SELECT("studyid");
		SELECT("filename");
		SELECT("filenamegen");
		SELECT("filepath");
		SELECT("typeofdata");
		FROM("studyfile");
		applyWhere(example, false);
		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		StudyFile record = (StudyFile) parameter.get("record");
		StudyFileExample example = (StudyFileExample) parameter.get("example");
		BEGIN();
		UPDATE("studyfile");
		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getUserid() != null) {
			SET("userid = #{record.userid,jdbcType=INTEGER}");
		}
		if (record.getStudyid() != null) {
			SET("studyid = #{record.studyid,jdbcType=INTEGER}");
		}
		if (record.getFilename() != null) {
			SET("filename = #{record.filename,jdbcType=VARCHAR}");
		}
		if (record.getFilenamegen() != null) {
			SET("filenamegen = #{record.filenamegen,jdbcType=VARCHAR}");
		}
		if (record.getFilepath() != null) {
			SET("filepath = #{record.filepath,jdbcType=VARCHAR}");
		}
		if (record.getTypeofdata() != null) {
			SET("typeofdata = #{record.typeofdata,jdbcType=CHAR}");
		}
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("studyfile");
		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("userid = #{record.userid,jdbcType=INTEGER}");
		SET("studyid = #{record.studyid,jdbcType=INTEGER}");
		SET("filename = #{record.filename,jdbcType=VARCHAR}");
		SET("filenamegen = #{record.filenamegen,jdbcType=VARCHAR}");
		SET("filepath = #{record.filepath,jdbcType=VARCHAR}");
		SET("typeofdata = #{record.typeofdata,jdbcType=CHAR}");
		StudyFileExample example = (StudyFileExample) parameter.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	public String updateByPrimaryKeySelective(StudyFile record) {
		BEGIN();
		UPDATE("studyfile");
		if (record.getUserid() != null) {
			SET("userid = #{userid,jdbcType=INTEGER}");
		}
		if (record.getStudyid() != null) {
			SET("studyid = #{studyid,jdbcType=INTEGER}");
		}
		if (record.getFilename() != null) {
			SET("filename = #{filename,jdbcType=VARCHAR}");
		}
		if (record.getFilenamegen() != null) {
			SET("filenamegen = #{filenamegen,jdbcType=VARCHAR}");
		}
		if (record.getFilepath() != null) {
			SET("filepath = #{filepath,jdbcType=VARCHAR}");
		}
		if (record.getTypeofdata() != null) {
			SET("typeofdata = #{typeofdata,jdbcType=CHAR}");
		}
		WHERE("id = #{id,jdbcType=INTEGER}");
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	protected void applyWhere(StudyFileExample example,
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