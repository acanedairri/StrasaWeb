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
import org.strasa.middleware.model.StudyVariable;
import org.strasa.middleware.model.StudyVariableExample;

public interface StudyVariableMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@SelectProvider(type = StudyVariableSqlProvider.class, method = "countByExample")
	int countByExample(StudyVariableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@DeleteProvider(type = StudyVariableSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyVariableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@Delete({ "delete from studyvariable", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@Insert({
			"insert into studyvariable (variablecode, description, ",
			"property, method, ",
			"scale, applytofilter, ",
			"defaultcolumn)",
			"values (#{variablecode,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
			"#{property,jdbcType=VARCHAR}, #{method,jdbcType=VARCHAR}, ",
			"#{scale,jdbcType=INTEGER}, #{applytofilter,jdbcType=CHAR}, ",
			"#{defaultcolumn,jdbcType=CHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyVariable record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@InsertProvider(type = StudyVariableSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyVariable record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@SelectProvider(type = StudyVariableSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "variablecode", property = "variablecode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
			@Result(column = "property", property = "property", jdbcType = JdbcType.VARCHAR),
			@Result(column = "method", property = "method", jdbcType = JdbcType.VARCHAR),
			@Result(column = "scale", property = "scale", jdbcType = JdbcType.INTEGER),
			@Result(column = "applytofilter", property = "applytofilter", jdbcType = JdbcType.CHAR),
			@Result(column = "defaultcolumn", property = "defaultcolumn", jdbcType = JdbcType.CHAR) })
	List<StudyVariable> selectByExample(StudyVariableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@Select({
			"select",
			"id, variablecode, description, property, method, scale, applytofilter, defaultcolumn",
			"from studyvariable", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "variablecode", property = "variablecode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
			@Result(column = "property", property = "property", jdbcType = JdbcType.VARCHAR),
			@Result(column = "method", property = "method", jdbcType = JdbcType.VARCHAR),
			@Result(column = "scale", property = "scale", jdbcType = JdbcType.INTEGER),
			@Result(column = "applytofilter", property = "applytofilter", jdbcType = JdbcType.CHAR),
			@Result(column = "defaultcolumn", property = "defaultcolumn", jdbcType = JdbcType.CHAR) })
	StudyVariable selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@UpdateProvider(type = StudyVariableSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyVariable record,
			@Param("example") StudyVariableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@UpdateProvider(type = StudyVariableSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyVariable record,
			@Param("example") StudyVariableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@UpdateProvider(type = StudyVariableSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudyVariable record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyvariable
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@Update({ "update studyvariable",
			"set variablecode = #{variablecode,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR},",
			"property = #{property,jdbcType=VARCHAR},",
			"method = #{method,jdbcType=VARCHAR},",
			"scale = #{scale,jdbcType=INTEGER},",
			"applytofilter = #{applytofilter,jdbcType=CHAR},",
			"defaultcolumn = #{defaultcolumn,jdbcType=CHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudyVariable record);
}