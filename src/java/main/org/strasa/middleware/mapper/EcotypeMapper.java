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
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.EcotypeExample;

public interface EcotypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@SelectProvider(type = EcotypeSqlProvider.class, method = "countByExample")
	int countByExample(EcotypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@DeleteProvider(type = EcotypeSqlProvider.class, method = "deleteByExample")
	int deleteByExample(EcotypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Delete({ "delete from ecotype", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Insert({ "insert into ecotype (ecotype)",
			"values (#{ecotype,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Ecotype record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@InsertProvider(type = EcotypeSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(Ecotype record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@SelectProvider(type = EcotypeSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "ecotype", property = "ecotype", jdbcType = JdbcType.VARCHAR) })
	List<Ecotype> selectByExample(EcotypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Select({ "select", "id, ecotype", "from ecotype",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "ecotype", property = "ecotype", jdbcType = JdbcType.VARCHAR) })
	Ecotype selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@UpdateProvider(type = EcotypeSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Ecotype record,
			@Param("example") EcotypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@UpdateProvider(type = EcotypeSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Ecotype record,
			@Param("example") EcotypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@UpdateProvider(type = EcotypeSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Ecotype record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ecotype
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Update({ "update ecotype", "set ecotype = #{ecotype,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Ecotype record);
}