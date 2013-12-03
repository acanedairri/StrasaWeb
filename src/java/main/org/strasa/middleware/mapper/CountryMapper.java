package org.strasa.middleware.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.CountryExample;

public interface CountryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@SelectProvider(type = CountrySqlProvider.class, method = "countByExample")
	int countByExample(CountryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@DeleteProvider(type = CountrySqlProvider.class, method = "deleteByExample")
	int deleteByExample(CountryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Delete({ "delete from country",
			"where cntryid = #{cntryid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer cntryid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Insert({
			"insert into country (cntryid, isonum, ",
			"isotwo, isothree, ",
			"faothree, fips, ",
			"wb, isofull, isoabbr, ",
			"cont, scntry, ecntry, ",
			"cchange)",
			"values (#{cntryid,jdbcType=INTEGER}, #{isonum,jdbcType=INTEGER}, ",
			"#{isotwo,jdbcType=VARCHAR}, #{isothree,jdbcType=VARCHAR}, ",
			"#{faothree,jdbcType=VARCHAR}, #{fips,jdbcType=VARCHAR}, ",
			"#{wb,jdbcType=VARCHAR}, #{isofull,jdbcType=VARCHAR}, #{isoabbr,jdbcType=VARCHAR}, ",
			"#{cont,jdbcType=VARCHAR}, #{scntry,jdbcType=INTEGER}, #{ecntry,jdbcType=INTEGER}, ",
			"#{cchange,jdbcType=INTEGER})" })
	int insert(Country record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@InsertProvider(type = CountrySqlProvider.class, method = "insertSelective")
	int insertSelective(Country record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@SelectProvider(type = CountrySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "cntryid", property = "cntryid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "isonum", property = "isonum", jdbcType = JdbcType.INTEGER),
			@Result(column = "isotwo", property = "isotwo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isothree", property = "isothree", jdbcType = JdbcType.VARCHAR),
			@Result(column = "faothree", property = "faothree", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fips", property = "fips", jdbcType = JdbcType.VARCHAR),
			@Result(column = "wb", property = "wb", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isofull", property = "isofull", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isoabbr", property = "isoabbr", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cont", property = "cont", jdbcType = JdbcType.VARCHAR),
			@Result(column = "scntry", property = "scntry", jdbcType = JdbcType.INTEGER),
			@Result(column = "ecntry", property = "ecntry", jdbcType = JdbcType.INTEGER),
			@Result(column = "cchange", property = "cchange", jdbcType = JdbcType.INTEGER) })
	List<Country> selectByExample(CountryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Select({
			"select",
			"cntryid, isonum, isotwo, isothree, faothree, fips, wb, isofull, isoabbr, cont, ",
			"scntry, ecntry, cchange", "from country",
			"where cntryid = #{cntryid,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "cntryid", property = "cntryid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "isonum", property = "isonum", jdbcType = JdbcType.INTEGER),
			@Result(column = "isotwo", property = "isotwo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isothree", property = "isothree", jdbcType = JdbcType.VARCHAR),
			@Result(column = "faothree", property = "faothree", jdbcType = JdbcType.VARCHAR),
			@Result(column = "fips", property = "fips", jdbcType = JdbcType.VARCHAR),
			@Result(column = "wb", property = "wb", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isofull", property = "isofull", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isoabbr", property = "isoabbr", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cont", property = "cont", jdbcType = JdbcType.VARCHAR),
			@Result(column = "scntry", property = "scntry", jdbcType = JdbcType.INTEGER),
			@Result(column = "ecntry", property = "ecntry", jdbcType = JdbcType.INTEGER),
			@Result(column = "cchange", property = "cchange", jdbcType = JdbcType.INTEGER) })
	Country selectByPrimaryKey(Integer cntryid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = CountrySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Country record,
			@Param("example") CountryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = CountrySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Country record,
			@Param("example") CountryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = CountrySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Country record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table country
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Update({ "update country", "set isonum = #{isonum,jdbcType=INTEGER},",
			"isotwo = #{isotwo,jdbcType=VARCHAR},",
			"isothree = #{isothree,jdbcType=VARCHAR},",
			"faothree = #{faothree,jdbcType=VARCHAR},",
			"fips = #{fips,jdbcType=VARCHAR},", "wb = #{wb,jdbcType=VARCHAR},",
			"isofull = #{isofull,jdbcType=VARCHAR},",
			"isoabbr = #{isoabbr,jdbcType=VARCHAR},",
			"cont = #{cont,jdbcType=VARCHAR},",
			"scntry = #{scntry,jdbcType=INTEGER},",
			"ecntry = #{ecntry,jdbcType=INTEGER},",
			"cchange = #{cchange,jdbcType=INTEGER}",
			"where cntryid = #{cntryid,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Country record);
}