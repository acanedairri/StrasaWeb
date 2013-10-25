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
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.ProgramExample;

public interface ProgramMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@SelectProvider(type = ProgramSqlProvider.class, method = "countByExample")
	int countByExample(ProgramExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@DeleteProvider(type = ProgramSqlProvider.class, method = "deleteByExample")
	int deleteByExample(ProgramExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@Delete({ "delete from program", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@Insert({ "insert into program (userid, name, ",
			"objective, coordinator, ", "leadinginstitute, collaborator)",
			"values (#{userid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{objective,jdbcType=VARCHAR}, #{coordinator,jdbcType=VARCHAR}, ",
			"#{leadinginstitute,jdbcType=VARCHAR}, #{collaborator,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Program record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@InsertProvider(type = ProgramSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(Program record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@SelectProvider(type = ProgramSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "objective", property = "objective", jdbcType = JdbcType.VARCHAR),
			@Result(column = "coordinator", property = "coordinator", jdbcType = JdbcType.VARCHAR),
			@Result(column = "leadinginstitute", property = "leadinginstitute", jdbcType = JdbcType.VARCHAR),
			@Result(column = "collaborator", property = "collaborator", jdbcType = JdbcType.VARCHAR) })
	List<Program> selectByExample(ProgramExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@Select({
			"select",
			"id, userid, name, objective, coordinator, leadinginstitute, collaborator",
			"from program", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "objective", property = "objective", jdbcType = JdbcType.VARCHAR),
			@Result(column = "coordinator", property = "coordinator", jdbcType = JdbcType.VARCHAR),
			@Result(column = "leadinginstitute", property = "leadinginstitute", jdbcType = JdbcType.VARCHAR),
			@Result(column = "collaborator", property = "collaborator", jdbcType = JdbcType.VARCHAR) })
	Program selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@UpdateProvider(type = ProgramSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Program record,
			@Param("example") ProgramExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@UpdateProvider(type = ProgramSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Program record,
			@Param("example") ProgramExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@UpdateProvider(type = ProgramSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Program record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table program
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@Update({ "update program", "set userid = #{userid,jdbcType=INTEGER},",
			"name = #{name,jdbcType=VARCHAR},",
			"objective = #{objective,jdbcType=VARCHAR},",
			"coordinator = #{coordinator,jdbcType=VARCHAR},",
			"leadinginstitute = #{leadinginstitute,jdbcType=VARCHAR},",
			"collaborator = #{collaborator,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Program record);
}