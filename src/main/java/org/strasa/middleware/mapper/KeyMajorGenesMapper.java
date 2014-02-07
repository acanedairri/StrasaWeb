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
import org.strasa.middleware.model.KeyMajorGenes;
import org.strasa.middleware.model.KeyMajorGenesExample;

public interface KeyMajorGenesMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@SelectProvider(type = KeyMajorGenesSqlProvider.class, method = "countByExample")
	int countByExample(KeyMajorGenesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@DeleteProvider(type = KeyMajorGenesSqlProvider.class, method = "deleteByExample")
	int deleteByExample(KeyMajorGenesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Delete({ "delete from keymajorgenes", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Insert({ "insert into keymajorgenes (value)",
			"values (#{value,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(KeyMajorGenes record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@InsertProvider(type = KeyMajorGenesSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(KeyMajorGenes record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@SelectProvider(type = KeyMajorGenesSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	List<KeyMajorGenes> selectByExample(KeyMajorGenesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Select({ "select", "id, value", "from keymajorgenes",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	KeyMajorGenes selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = KeyMajorGenesSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") KeyMajorGenes record,
			@Param("example") KeyMajorGenesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = KeyMajorGenesSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") KeyMajorGenes record,
			@Param("example") KeyMajorGenesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = KeyMajorGenesSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(KeyMajorGenes record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keymajorgenes
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Update({ "update keymajorgenes", "set value = #{value,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(KeyMajorGenes record);
}