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
import org.strasa.middleware.model.Georef;
import org.strasa.middleware.model.GeorefExample;

public interface GeorefMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 10 13:49:48 SGT 2013
	 */
	@SelectProvider(type = GeorefSqlProvider.class, method = "countByExample")
	int countByExample(GeorefExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 10 13:49:48 SGT 2013
	 */
	@DeleteProvider(type = GeorefSqlProvider.class, method = "deleteByExample")
	int deleteByExample(GeorefExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 10 13:49:48 SGT 2013
	 */
	@Insert({
			"insert into georef (locid, llpn, ",
			"lat, lon, alt, ",
			"llsource, ll_fmt, ",
			"ll_datum, ll_uncert, ",
			"llref, lldate, lluid)",
			"values (#{locid,jdbcType=INTEGER}, #{llpn,jdbcType=INTEGER}, ",
			"#{lat,jdbcType=DOUBLE}, #{lon,jdbcType=DOUBLE}, #{alt,jdbcType=DOUBLE}, ",
			"#{llsource,jdbcType=INTEGER}, #{llFmt,jdbcType=INTEGER}, ",
			"#{llDatum,jdbcType=INTEGER}, #{llUncert,jdbcType=DOUBLE}, ",
			"#{llref,jdbcType=INTEGER}, #{lldate,jdbcType=INTEGER}, #{lluid,jdbcType=INTEGER})" })
	int insert(Georef record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 10 13:49:48 SGT 2013
	 */
	@InsertProvider(type = GeorefSqlProvider.class, method = "insertSelective")
	int insertSelective(Georef record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 10 13:49:48 SGT 2013
	 */
	@SelectProvider(type = GeorefSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "locid", property = "locid", jdbcType = JdbcType.INTEGER),
			@Result(column = "llpn", property = "llpn", jdbcType = JdbcType.INTEGER),
			@Result(column = "lat", property = "lat", jdbcType = JdbcType.DOUBLE),
			@Result(column = "lon", property = "lon", jdbcType = JdbcType.DOUBLE),
			@Result(column = "alt", property = "alt", jdbcType = JdbcType.DOUBLE),
			@Result(column = "llsource", property = "llsource", jdbcType = JdbcType.INTEGER),
			@Result(column = "ll_fmt", property = "llFmt", jdbcType = JdbcType.INTEGER),
			@Result(column = "ll_datum", property = "llDatum", jdbcType = JdbcType.INTEGER),
			@Result(column = "ll_uncert", property = "llUncert", jdbcType = JdbcType.DOUBLE),
			@Result(column = "llref", property = "llref", jdbcType = JdbcType.INTEGER),
			@Result(column = "lldate", property = "lldate", jdbcType = JdbcType.INTEGER),
			@Result(column = "lluid", property = "lluid", jdbcType = JdbcType.INTEGER) })
	List<Georef> selectByExample(GeorefExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 10 13:49:48 SGT 2013
	 */
	@UpdateProvider(type = GeorefSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Georef record,
			@Param("example") GeorefExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table georef
	 * @mbggenerated  Thu Oct 10 13:49:48 SGT 2013
	 */
	@UpdateProvider(type = GeorefSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Georef record,
			@Param("example") GeorefExample example);
}