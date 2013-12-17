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
import org.strasa.middleware.model.ExtensionData;
import org.strasa.middleware.model.ExtensionDataExample;

public interface ExtensionDataMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@SelectProvider(type = ExtensionDataSqlProvider.class, method = "countByExample")
	int countByExample(ExtensionDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@DeleteProvider(type = ExtensionDataSqlProvider.class, method = "deleteByExample")
	int deleteByExample(ExtensionDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@Delete({ "delete from extensiondata", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@Insert({
			"insert into extensiondata (germplasmname, year, ",
			"location, area, datasource)",
			"values (#{germplasmname,jdbcType=VARCHAR}, #{year,jdbcType=VARCHAR}, ",
			"#{location,jdbcType=VARCHAR}, #{area,jdbcType=DOUBLE}, #{datasource,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(ExtensionData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@InsertProvider(type = ExtensionDataSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(ExtensionData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@SelectProvider(type = ExtensionDataSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "germplasmname", property = "germplasmname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "year", property = "year", jdbcType = JdbcType.VARCHAR),
			@Result(column = "location", property = "location", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.DOUBLE),
			@Result(column = "datasource", property = "datasource", jdbcType = JdbcType.VARCHAR) })
	List<ExtensionData> selectByExample(ExtensionDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@Select({ "select", "id, germplasmname, year, location, area, datasource",
			"from extensiondata", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "germplasmname", property = "germplasmname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "year", property = "year", jdbcType = JdbcType.VARCHAR),
			@Result(column = "location", property = "location", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.DOUBLE),
			@Result(column = "datasource", property = "datasource", jdbcType = JdbcType.VARCHAR) })
	ExtensionData selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@UpdateProvider(type = ExtensionDataSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") ExtensionData record,
			@Param("example") ExtensionDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@UpdateProvider(type = ExtensionDataSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") ExtensionData record,
			@Param("example") ExtensionDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@UpdateProvider(type = ExtensionDataSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(ExtensionData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table extensiondata
	 * @mbggenerated  Mon Dec 16 13:38:57 SGT 2013
	 */
	@Update({ "update extensiondata",
			"set germplasmname = #{germplasmname,jdbcType=VARCHAR},",
			"year = #{year,jdbcType=VARCHAR},",
			"location = #{location,jdbcType=VARCHAR},",
			"area = #{area,jdbcType=DOUBLE},",
			"datasource = #{datasource,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(ExtensionData record);
}