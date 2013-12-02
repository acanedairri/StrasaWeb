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
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyExample;

public interface StudyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@SelectProvider(type = StudySqlProvider.class, method = "countByExample")
	int countByExample(StudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@DeleteProvider(type = StudySqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Delete({ "delete from study", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Insert({
			"insert into study (userid, programid, ",
			"projectid, name, ",
			"description, studytypeid, ",
			"startyear, endyear, ",
			"remarks, shared)",
			"values (#{userid,jdbcType=INTEGER}, #{programid,jdbcType=INTEGER}, ",
			"#{projectid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{description,jdbcType=VARCHAR}, #{studytypeid,jdbcType=INTEGER}, ",
			"#{startyear,jdbcType=VARCHAR}, #{endyear,jdbcType=VARCHAR}, ",
			"#{remarks,jdbcType=VARCHAR}, #{shared,jdbcType=CHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Study record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@InsertProvider(type = StudySqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(Study record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@SelectProvider(type = StudySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
			@Result(column = "programid", property = "programid", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectid", property = "projectid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
			@Result(column = "studytypeid", property = "studytypeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "startyear", property = "startyear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "endyear", property = "endyear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remarks", property = "remarks", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shared", property = "shared", jdbcType = JdbcType.CHAR) })
	List<Study> selectByExample(StudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Select({
			"select",
			"id, userid, programid, projectid, name, description, studytypeid, startyear, ",
			"endyear, remarks, shared", "from study",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
			@Result(column = "programid", property = "programid", jdbcType = JdbcType.INTEGER),
			@Result(column = "projectid", property = "projectid", jdbcType = JdbcType.INTEGER),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
			@Result(column = "studytypeid", property = "studytypeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "startyear", property = "startyear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "endyear", property = "endyear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remarks", property = "remarks", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shared", property = "shared", jdbcType = JdbcType.CHAR) })
	Study selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = StudySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Study record,
			@Param("example") StudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = StudySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Study record,
			@Param("example") StudyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = StudySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Study record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table study
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Update({ "update study", "set userid = #{userid,jdbcType=INTEGER},",
			"programid = #{programid,jdbcType=INTEGER},",
			"projectid = #{projectid,jdbcType=INTEGER},",
			"name = #{name,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR},",
			"studytypeid = #{studytypeid,jdbcType=INTEGER},",
			"startyear = #{startyear,jdbcType=VARCHAR},",
			"endyear = #{endyear,jdbcType=VARCHAR},",
			"remarks = #{remarks,jdbcType=VARCHAR},",
			"shared = #{shared,jdbcType=CHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Study record);
}