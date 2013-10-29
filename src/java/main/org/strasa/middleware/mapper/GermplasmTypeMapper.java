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
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.GermplasmTypeExample;

public interface GermplasmTypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@SelectProvider(type = GermplasmTypeSqlProvider.class, method = "countByExample")
	int countByExample(GermplasmTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@DeleteProvider(type = GermplasmTypeSqlProvider.class, method = "deleteByExample")
	int deleteByExample(GermplasmTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@Delete({ "delete from germplasmtype", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@Insert({ "insert into germplasmtype (germplasmtype, description)",
			"values (#{germplasmtype,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(GermplasmType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@InsertProvider(type = GermplasmTypeSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(GermplasmType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@SelectProvider(type = GermplasmTypeSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "germplasmtype", property = "germplasmtype", jdbcType = JdbcType.VARCHAR),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR) })
	List<GermplasmType> selectByExample(GermplasmTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@Select({ "select", "id, germplasmtype, description", "from germplasmtype",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "germplasmtype", property = "germplasmtype", jdbcType = JdbcType.VARCHAR),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR) })
	GermplasmType selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@UpdateProvider(type = GermplasmTypeSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") GermplasmType record,
			@Param("example") GermplasmTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@UpdateProvider(type = GermplasmTypeSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") GermplasmType record,
			@Param("example") GermplasmTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@UpdateProvider(type = GermplasmTypeSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(GermplasmType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table germplasmtype
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@Update({ "update germplasmtype",
			"set germplasmtype = #{germplasmtype,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(GermplasmType record);
}