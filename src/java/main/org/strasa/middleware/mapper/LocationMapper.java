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
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.LocationExample;

public interface LocationMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@SelectProvider(type = LocationSqlProvider.class, method = "countByExample")
	int countByExample(LocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@DeleteProvider(type = LocationSqlProvider.class, method = "deleteByExample")
	int deleteByExample(LocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@Delete({ "delete from location", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@Insert({
			"insert into location (locationname, country, ",
			"province, region, ",
			"altitude, latitude, ",
			"weatherstation)",
			"values (#{locationname,jdbcType=VARCHAR}, #{country,jdbcType=VARCHAR}, ",
			"#{province,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, ",
			"#{altitude,jdbcType=VARCHAR}, #{latitude,jdbcType=VARCHAR}, ",
			"#{weatherstation,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Location record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@InsertProvider(type = LocationSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(Location record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@SelectProvider(type = LocationSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "locationname", property = "locationname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR),
			@Result(column = "province", property = "province", jdbcType = JdbcType.VARCHAR),
			@Result(column = "region", property = "region", jdbcType = JdbcType.VARCHAR),
			@Result(column = "altitude", property = "altitude", jdbcType = JdbcType.VARCHAR),
			@Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR),
			@Result(column = "weatherstation", property = "weatherstation", jdbcType = JdbcType.VARCHAR) })
	List<Location> selectByExample(LocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@Select({
			"select",
			"id, locationname, country, province, region, altitude, latitude, weatherstation",
			"from location", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "locationname", property = "locationname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR),
			@Result(column = "province", property = "province", jdbcType = JdbcType.VARCHAR),
			@Result(column = "region", property = "region", jdbcType = JdbcType.VARCHAR),
			@Result(column = "altitude", property = "altitude", jdbcType = JdbcType.VARCHAR),
			@Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR),
			@Result(column = "weatherstation", property = "weatherstation", jdbcType = JdbcType.VARCHAR) })
	Location selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@UpdateProvider(type = LocationSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Location record,
			@Param("example") LocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@UpdateProvider(type = LocationSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Location record,
			@Param("example") LocationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@UpdateProvider(type = LocationSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Location record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table location
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@Update({ "update location",
			"set locationname = #{locationname,jdbcType=VARCHAR},",
			"country = #{country,jdbcType=VARCHAR},",
			"province = #{province,jdbcType=VARCHAR},",
			"region = #{region,jdbcType=VARCHAR},",
			"altitude = #{altitude,jdbcType=VARCHAR},",
			"latitude = #{latitude,jdbcType=VARCHAR},",
			"weatherstation = #{weatherstation,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Location record);
}