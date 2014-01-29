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
import org.strasa.middleware.model.GermplasmReleaseInfo;
import org.strasa.middleware.model.GermplasmReleaseInfoExample;

public interface GermplasmReleaseInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@SelectProvider(type = GermplasmReleaseInfoSqlProvider.class, method = "countByExample")
	int countByExample(GermplasmReleaseInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@DeleteProvider(type = GermplasmReleaseInfoSqlProvider.class, method = "deleteByExample")
	int deleteByExample(GermplasmReleaseInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@Delete({ "delete from germplasmreleaseinfo",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@Insert({
			"insert into germplasmreleaseinfo (germplasmname, attribute, ",
			"value)",
			"values (#{germplasmname,jdbcType=VARCHAR}, #{attribute,jdbcType=VARCHAR}, ",
			"#{value,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(GermplasmReleaseInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@InsertProvider(type = GermplasmReleaseInfoSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(GermplasmReleaseInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@SelectProvider(type = GermplasmReleaseInfoSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "germplasmname", property = "germplasmname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "attribute", property = "attribute", jdbcType = JdbcType.VARCHAR),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	List<GermplasmReleaseInfo> selectByExample(
			GermplasmReleaseInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@Select({ "select", "id, germplasmname, attribute, value",
			"from germplasmreleaseinfo", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "germplasmname", property = "germplasmname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "attribute", property = "attribute", jdbcType = JdbcType.VARCHAR),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	GermplasmReleaseInfo selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@UpdateProvider(type = GermplasmReleaseInfoSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") GermplasmReleaseInfo record,
			@Param("example") GermplasmReleaseInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@UpdateProvider(type = GermplasmReleaseInfoSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") GermplasmReleaseInfo record,
			@Param("example") GermplasmReleaseInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@UpdateProvider(type = GermplasmReleaseInfoSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(GermplasmReleaseInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmreleaseinfo
	 * @mbggenerated  Wed Jan 29 14:13:59 SGT 2014
	 */
	@Update({ "update germplasmreleaseinfo",
			"set germplasmname = #{germplasmname,jdbcType=VARCHAR},",
			"attribute = #{attribute,jdbcType=VARCHAR},",
			"value = #{value,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(GermplasmReleaseInfo record);
}