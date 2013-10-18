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
import org.strasa.middleware.model.StudyLocation;
import org.strasa.middleware.model.StudyLocationExample;

public interface StudyLocationMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@SelectProvider(type = StudyLocationSqlProvider.class, method = "countByExample")
	int countByExample(StudyLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@DeleteProvider(type = StudyLocationSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@Delete({ "delete from studylocation", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@Insert({
			"insert into studylocation (studyid, locationname, ",
			"country, province, ",
			"region, altitude, ",
			"latitude, weatherstation)",
			"values (#{studyid,jdbcType=INTEGER}, #{locationname,jdbcType=VARCHAR}, ",
			"#{country,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
			"#{region,jdbcType=VARCHAR}, #{altitude,jdbcType=VARCHAR}, ",
			"#{latitude,jdbcType=VARCHAR}, #{weatherstation,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyLocation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@InsertProvider(type = StudyLocationSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyLocation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@SelectProvider(type = StudyLocationSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "locationname", property = "locationname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR),
			@Result(column = "province", property = "province", jdbcType = JdbcType.VARCHAR),
			@Result(column = "region", property = "region", jdbcType = JdbcType.VARCHAR),
			@Result(column = "altitude", property = "altitude", jdbcType = JdbcType.VARCHAR),
			@Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR),
			@Result(column = "weatherstation", property = "weatherstation", jdbcType = JdbcType.VARCHAR) })
	List<StudyLocation> selectByExample(StudyLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@Select({
			"select",
			"id, studyid, locationname, country, province, region, altitude, latitude, weatherstation",
			"from studylocation", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "locationname", property = "locationname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR),
			@Result(column = "province", property = "province", jdbcType = JdbcType.VARCHAR),
			@Result(column = "region", property = "region", jdbcType = JdbcType.VARCHAR),
			@Result(column = "altitude", property = "altitude", jdbcType = JdbcType.VARCHAR),
			@Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR),
			@Result(column = "weatherstation", property = "weatherstation", jdbcType = JdbcType.VARCHAR) })
	StudyLocation selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@UpdateProvider(type = StudyLocationSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyLocation record,
			@Param("example") StudyLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@UpdateProvider(type = StudyLocationSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyLocation record,
			@Param("example") StudyLocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@UpdateProvider(type = StudyLocationSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudyLocation record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studylocation
	 * @mbggenerated  Fri Oct 18 14:25:01 SGT 2013
	 */
	@Update({ "update studylocation",
			"set studyid = #{studyid,jdbcType=INTEGER},",
			"locationname = #{locationname,jdbcType=VARCHAR},",
			"country = #{country,jdbcType=VARCHAR},",
			"province = #{province,jdbcType=VARCHAR},",
			"region = #{region,jdbcType=VARCHAR},",
			"altitude = #{altitude,jdbcType=VARCHAR},",
			"latitude = #{latitude,jdbcType=VARCHAR},",
			"weatherstation = #{weatherstation,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudyLocation record);
}