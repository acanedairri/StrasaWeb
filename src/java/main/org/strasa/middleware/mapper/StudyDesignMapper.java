package org.strasa.middleware.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.strasa.middleware.model.StudyDesign;
import org.strasa.middleware.model.StudyDesignExample;

public interface StudyDesignMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@SelectProvider(type = StudyDesignSqlProvider.class, method = "countByExample")
	int countByExample(StudyDesignExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@DeleteProvider(type = StudyDesignSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyDesignExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@Delete({ "delete from studydesign", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@Insert({
			"insert into studydesign (studysiteid, treatmentstructure, ",
			"designstructure, plotsize, ",
			"designfactor1, designfactor2, ",
			"designfactor3, designfactor4)",
			"values (#{studysiteid,jdbcType=INTEGER}, #{treatmentstructure,jdbcType=VARCHAR}, ",
			"#{designstructure,jdbcType=VARCHAR}, #{plotsize,jdbcType=VARCHAR}, ",
			"#{designfactor1,jdbcType=VARCHAR}, #{designfactor2,jdbcType=VARCHAR}, ",
			"#{designfactor3,jdbcType=VARCHAR}, #{designfactor4,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyDesign record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@InsertProvider(type = StudyDesignSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyDesign record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@SelectProvider(type = StudyDesignSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studysiteid", property = "studysiteid", jdbcType = JdbcType.INTEGER),
			@Result(column = "treatmentstructure", property = "treatmentstructure", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designstructure", property = "designstructure", jdbcType = JdbcType.VARCHAR),
			@Result(column = "plotsize", property = "plotsize", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designfactor1", property = "designfactor1", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designfactor2", property = "designfactor2", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designfactor3", property = "designfactor3", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designfactor4", property = "designfactor4", jdbcType = JdbcType.VARCHAR) })
	List<StudyDesign> selectByExample(StudyDesignExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@Select({
			"select",
			"id, studysiteid, treatmentstructure, designstructure, plotsize, designfactor1, ",
			"designfactor2, designfactor3, designfactor4", "from studydesign",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studysiteid", property = "studysiteid", jdbcType = JdbcType.INTEGER),
			@Result(column = "treatmentstructure", property = "treatmentstructure", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designstructure", property = "designstructure", jdbcType = JdbcType.VARCHAR),
			@Result(column = "plotsize", property = "plotsize", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designfactor1", property = "designfactor1", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designfactor2", property = "designfactor2", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designfactor3", property = "designfactor3", jdbcType = JdbcType.VARCHAR),
			@Result(column = "designfactor4", property = "designfactor4", jdbcType = JdbcType.VARCHAR) })
	StudyDesign selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@UpdateProvider(type = StudyDesignSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyDesign record,
			@Param("example") StudyDesignExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@UpdateProvider(type = StudyDesignSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyDesign record,
			@Param("example") StudyDesignExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@UpdateProvider(type = StudyDesignSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudyDesign record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydesign
	 * @mbggenerated  Wed Nov 27 10:48:15 SGT 2013
	 */
	@Update({ "update studydesign",
			"set studysiteid = #{studysiteid,jdbcType=INTEGER},",
			"treatmentstructure = #{treatmentstructure,jdbcType=VARCHAR},",
			"designstructure = #{designstructure,jdbcType=VARCHAR},",
			"plotsize = #{plotsize,jdbcType=VARCHAR},",
			"designfactor1 = #{designfactor1,jdbcType=VARCHAR},",
			"designfactor2 = #{designfactor2,jdbcType=VARCHAR},",
			"designfactor3 = #{designfactor3,jdbcType=VARCHAR},",
			"designfactor4 = #{designfactor4,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudyDesign record);
}