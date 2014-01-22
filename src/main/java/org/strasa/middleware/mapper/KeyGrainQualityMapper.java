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
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyGrainQualityExample;

public interface KeyGrainQualityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@SelectProvider(type = KeyGrainQualitySqlProvider.class, method = "countByExample")
	int countByExample(KeyGrainQualityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@DeleteProvider(type = KeyGrainQualitySqlProvider.class, method = "deleteByExample")
	int deleteByExample(KeyGrainQualityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@Delete({ "delete from keygrainquality",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@Insert({ "insert into keygrainquality (value)",
			"values (#{value,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(KeyGrainQuality record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@InsertProvider(type = KeyGrainQualitySqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(KeyGrainQuality record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@SelectProvider(type = KeyGrainQualitySqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	List<KeyGrainQuality> selectByExample(KeyGrainQualityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@Select({ "select", "id, value", "from keygrainquality",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	KeyGrainQuality selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@UpdateProvider(type = KeyGrainQualitySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") KeyGrainQuality record,
			@Param("example") KeyGrainQualityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@UpdateProvider(type = KeyGrainQualitySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") KeyGrainQuality record,
			@Param("example") KeyGrainQualityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@UpdateProvider(type = KeyGrainQualitySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(KeyGrainQuality record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keygrainquality
	 * @mbggenerated  Mon Jan 13 10:11:19 SGT 2014
	 */
	@Update({ "update keygrainquality",
			"set value = #{value,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(KeyGrainQuality record);
}