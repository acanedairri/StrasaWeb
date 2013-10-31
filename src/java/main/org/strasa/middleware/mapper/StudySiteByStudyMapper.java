package org.strasa.middleware.mapper;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.strasa.middleware.model.StudySiteByStudy;
import org.strasa.middleware.model.StudySiteByStudyExample;

public interface StudySiteByStudyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@SelectProvider(type = StudySiteByStudySqlProvider.class, method = "countByExample")
	int countByExample(StudySiteByStudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@DeleteProvider(type = StudySiteByStudySqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudySiteByStudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@Insert({
			"insert into studyrawdata (studyid, datacolumn, ",
			"datavalue)",
			"values (#{studyid,jdbcType=INTEGER}, #{datacolumn,jdbcType=VARCHAR}, ",
			"#{datavalue,jdbcType=VARCHAR})" })
	int insert(StudySiteByStudy record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@InsertProvider(type = StudySiteByStudySqlProvider.class, method = "insertSelective")
	int insertSelective(StudySiteByStudy record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@SelectProvider(type = StudySiteByStudySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "datacolumn", property = "datacolumn", jdbcType = JdbcType.VARCHAR),
			@Result(column = "datavalue", property = "datavalue", jdbcType = JdbcType.VARCHAR) })
	List<StudySiteByStudy> selectByExample(StudySiteByStudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@UpdateProvider(type = StudySiteByStudySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudySiteByStudy record,
			@Param("example") StudySiteByStudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@UpdateProvider(type = StudySiteByStudySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudySiteByStudy record,
			@Param("example") StudySiteByStudyExample example);
}