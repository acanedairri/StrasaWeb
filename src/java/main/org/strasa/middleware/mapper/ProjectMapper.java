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
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.ProjectExample;

public interface ProjectMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@SelectProvider(type = ProjectSqlProvider.class, method = "countByExample")
	int countByExample(ProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@DeleteProvider(type = ProjectSqlProvider.class, method = "deleteByExample")
	int deleteByExample(ProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Delete({ "delete from project", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Insert({
			"insert into project (userid, programid, ",
			"name, objective, ",
			"pi, leadinginstitute, ",
			"collaborators, fundingagency)",
			"values (#{userid,jdbcType=INTEGER}, #{programid,jdbcType=INTEGER}, ",
			"#{name,jdbcType=VARCHAR}, #{objective,jdbcType=VARCHAR}, ",
			"#{pi,jdbcType=VARCHAR}, #{leadinginstitute,jdbcType=VARCHAR}, ",
			"#{collaborators,jdbcType=VARCHAR}, #{fundingagency,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Project record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@InsertProvider(type = ProjectSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(Project record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@SelectProvider(type = ProjectSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
			@Result(column = "programid", property = "programid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "objective", property = "objective", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pi", property = "pi", jdbcType = JdbcType.VARCHAR),
			@Result(column = "leadinginstitute", property = "leadinginstitute", jdbcType = JdbcType.VARCHAR),
			@Result(column = "collaborators", property = "collaborators", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fundingagency", property = "fundingagency", jdbcType = JdbcType.VARCHAR) })
	List<Project> selectByExample(ProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Select({
			"select",
			"id, userid, programid, name, objective, pi, leadinginstitute, collaborators, ",
			"fundingagency", "from project",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
			@Result(column = "programid", property = "programid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "objective", property = "objective", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pi", property = "pi", jdbcType = JdbcType.VARCHAR),
			@Result(column = "leadinginstitute", property = "leadinginstitute", jdbcType = JdbcType.VARCHAR),
			@Result(column = "collaborators", property = "collaborators", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fundingagency", property = "fundingagency", jdbcType = JdbcType.VARCHAR) })
	Project selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = ProjectSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Project record,
			@Param("example") ProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = ProjectSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Project record,
			@Param("example") ProjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = ProjectSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Project record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Update({ "update project", "set userid = #{userid,jdbcType=INTEGER},",
			"programid = #{programid,jdbcType=INTEGER},",
			"name = #{name,jdbcType=VARCHAR},",
			"objective = #{objective,jdbcType=VARCHAR},",
			"pi = #{pi,jdbcType=VARCHAR},",
			"leadinginstitute = #{leadinginstitute,jdbcType=VARCHAR},",
			"collaborators = #{collaborators,jdbcType=VARCHAR},",
			"fundingagency = #{fundingagency,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Project record);
}