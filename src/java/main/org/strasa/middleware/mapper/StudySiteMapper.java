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
import org.strasa.middleware.model.StudySite;
import org.strasa.middleware.model.StudySiteExample;

public interface StudySiteMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@SelectProvider(type = StudySiteSqlProvider.class, method = "countByExample")
	int countByExample(StudySiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@DeleteProvider(type = StudySiteSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudySiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@Delete({ "delete from studysite", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@Insert({
			"insert into studysite (studyid, sitename, ",
			"sitelocation, ecotypeid, ",
			"soiltype, soilph)",
			"values (#{studyid,jdbcType=INTEGER}, #{sitename,jdbcType=VARCHAR}, ",
			"#{sitelocation,jdbcType=VARCHAR}, #{ecotypeid,jdbcType=INTEGER}, ",
			"#{soiltype,jdbcType=VARCHAR}, #{soilph,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudySite record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@InsertProvider(type = StudySiteSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudySite record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@SelectProvider(type = StudySiteSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "sitename", property = "sitename", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sitelocation", property = "sitelocation", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ecotypeid", property = "ecotypeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "soiltype", property = "soiltype", jdbcType = JdbcType.VARCHAR),
			@Result(column = "soilph", property = "soilph", jdbcType = JdbcType.VARCHAR) })
	List<StudySite> selectByExample(StudySiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@Select({ "select",
			"id, studyid, sitename, sitelocation, ecotypeid, soiltype, soilph",
			"from studysite", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "sitename", property = "sitename", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sitelocation", property = "sitelocation", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ecotypeid", property = "ecotypeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "soiltype", property = "soiltype", jdbcType = JdbcType.VARCHAR),
			@Result(column = "soilph", property = "soilph", jdbcType = JdbcType.VARCHAR) })
	StudySite selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@UpdateProvider(type = StudySiteSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudySite record,
			@Param("example") StudySiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@UpdateProvider(type = StudySiteSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudySite record,
			@Param("example") StudySiteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@UpdateProvider(type = StudySiteSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudySite record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studysite
	 * @mbggenerated  Thu Oct 17 13:40:28 SGT 2013
	 */
	@Update({ "update studysite", "set studyid = #{studyid,jdbcType=INTEGER},",
			"sitename = #{sitename,jdbcType=VARCHAR},",
			"sitelocation = #{sitelocation,jdbcType=VARCHAR},",
			"ecotypeid = #{ecotypeid,jdbcType=INTEGER},",
			"soiltype = #{soiltype,jdbcType=VARCHAR},",
			"soilph = #{soilph,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudySite record);
}