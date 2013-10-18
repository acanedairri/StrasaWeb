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
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyBioticExample;

public interface KeyBioticMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@SelectProvider(type = KeyBioticSqlProvider.class, method = "countByExample")
	int countByExample(KeyBioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@DeleteProvider(type = KeyBioticSqlProvider.class, method = "deleteByExample")
	int deleteByExample(KeyBioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Delete({ "delete from keybiotic", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Insert({ "insert into keybiotic (value)",
			"values (#{value,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(KeyBiotic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@InsertProvider(type = KeyBioticSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(KeyBiotic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@SelectProvider(type = KeyBioticSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	List<KeyBiotic> selectByExample(KeyBioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Select({ "select", "id, value", "from keybiotic",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	KeyBiotic selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@UpdateProvider(type = KeyBioticSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") KeyBiotic record,
			@Param("example") KeyBioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@UpdateProvider(type = KeyBioticSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") KeyBiotic record,
			@Param("example") KeyBioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@UpdateProvider(type = KeyBioticSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(KeyBiotic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keybiotic
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Update({ "update keybiotic", "set value = #{value,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(KeyBiotic record);
}