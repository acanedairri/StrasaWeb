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
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyAbioticExample;

public interface KeyAbioticMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@SelectProvider(type = KeyAbioticSqlProvider.class, method = "countByExample")
	int countByExample(KeyAbioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@DeleteProvider(type = KeyAbioticSqlProvider.class, method = "deleteByExample")
	int deleteByExample(KeyAbioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Delete({ "delete from keyabiotic", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Insert({ "insert into keyabiotic (value)",
			"values (#{value,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(KeyAbiotic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@InsertProvider(type = KeyAbioticSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(KeyAbiotic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@SelectProvider(type = KeyAbioticSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	List<KeyAbiotic> selectByExample(KeyAbioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Select({ "select", "id, value", "from keyabiotic",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR) })
	KeyAbiotic selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = KeyAbioticSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") KeyAbiotic record,
			@Param("example") KeyAbioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = KeyAbioticSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") KeyAbiotic record,
			@Param("example") KeyAbioticExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@UpdateProvider(type = KeyAbioticSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(KeyAbiotic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table keyabiotic
	 * @mbggenerated  Mon Dec 02 10:45:06 SGT 2013
	 */
	@Update({ "update keyabiotic", "set value = #{value,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(KeyAbiotic record);
}