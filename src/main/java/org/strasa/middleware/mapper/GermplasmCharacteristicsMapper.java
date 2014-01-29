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
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmCharacteristicsExample;

public interface GermplasmCharacteristicsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@SelectProvider(type = GermplasmCharacteristicsSqlProvider.class, method = "countByExample")
	int countByExample(GermplasmCharacteristicsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@DeleteProvider(type = GermplasmCharacteristicsSqlProvider.class, method = "deleteByExample")
	int deleteByExample(GermplasmCharacteristicsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@Delete({ "delete from germplasmcharacteristics",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@Insert({
			"insert into germplasmcharacteristics (germplasmname, attribute, ",
			"keyvalue)",
			"values (#{germplasmname,jdbcType=VARCHAR}, #{attribute,jdbcType=VARCHAR}, ",
			"#{keyvalue,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(GermplasmCharacteristics record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@InsertProvider(type = GermplasmCharacteristicsSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(GermplasmCharacteristics record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@SelectProvider(type = GermplasmCharacteristicsSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "germplasmname", property = "germplasmname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "attribute", property = "attribute", jdbcType = JdbcType.VARCHAR),
			@Result(column = "keyvalue", property = "keyvalue", jdbcType = JdbcType.VARCHAR) })
	List<GermplasmCharacteristics> selectByExample(
			GermplasmCharacteristicsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@Select({ "select", "id, germplasmname, attribute, keyvalue",
			"from germplasmcharacteristics",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "germplasmname", property = "germplasmname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "attribute", property = "attribute", jdbcType = JdbcType.VARCHAR),
			@Result(column = "keyvalue", property = "keyvalue", jdbcType = JdbcType.VARCHAR) })
	GermplasmCharacteristics selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@UpdateProvider(type = GermplasmCharacteristicsSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(
			@Param("record") GermplasmCharacteristics record,
			@Param("example") GermplasmCharacteristicsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@UpdateProvider(type = GermplasmCharacteristicsSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") GermplasmCharacteristics record,
			@Param("example") GermplasmCharacteristicsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@UpdateProvider(type = GermplasmCharacteristicsSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(GermplasmCharacteristics record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmcharacteristics
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@Update({ "update germplasmcharacteristics",
			"set germplasmname = #{germplasmname,jdbcType=VARCHAR},",
			"attribute = #{attribute,jdbcType=VARCHAR},",
			"keyvalue = #{keyvalue,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(GermplasmCharacteristics record);
}