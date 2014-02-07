package org.strasa.middleware.mapper;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.strasa.middleware.model.StudyDerivedData;
import org.strasa.middleware.model.StudyDerivedDataExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudyDerivedDataMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@SelectProvider(type = StudyDerivedDataSqlProvider.class, method = "countByExample")
	int countByExample(StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@DeleteProvider(type = StudyDerivedDataSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Delete({ "delete from studyderiveddata",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Insert({
			"insert into studyderiveddata (studyid, dataset, ",
			"datarow, datacolumn, ",
			"datavalue, shared, userid)",
			"values (#{studyid,jdbcType=INTEGER}, #{dataset,jdbcType=INTEGER}, ",
			"#{datarow,jdbcType=INTEGER}, #{datacolumn,jdbcType=VARCHAR}, ",
			"#{datavalue,jdbcType=VARCHAR}, #{shared,jdbcType=BIT}, #{userid,jdbcType=INTEGER})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyDerivedData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@InsertProvider(type = StudyDerivedDataSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyDerivedData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@SelectProvider(type = StudyDerivedDataSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "dataset", property = "dataset", jdbcType = JdbcType.INTEGER),
			@Result(column = "datarow", property = "datarow", jdbcType = JdbcType.INTEGER),
			@Result(column = "datacolumn", property = "datacolumn", jdbcType = JdbcType.VARCHAR),
			@Result(column = "datavalue", property = "datavalue", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shared", property = "shared", jdbcType = JdbcType.BIT),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER) })
	List<StudyDerivedData> selectByExample(StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Select({
			"select",
			"id, studyid, dataset, datarow, datacolumn, datavalue, shared, userid",
			"from studyderiveddata", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "dataset", property = "dataset", jdbcType = JdbcType.INTEGER),
			@Result(column = "datarow", property = "datarow", jdbcType = JdbcType.INTEGER),
			@Result(column = "datacolumn", property = "datacolumn", jdbcType = JdbcType.VARCHAR),
			@Result(column = "datavalue", property = "datavalue", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shared", property = "shared", jdbcType = JdbcType.BIT),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER) })
	StudyDerivedData selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = StudyDerivedDataSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyDerivedData record,
			@Param("example") StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = StudyDerivedDataSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyDerivedData record,
			@Param("example") StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = StudyDerivedDataSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudyDerivedData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Update({ "update studyderiveddata",
			"set studyid = #{studyid,jdbcType=INTEGER},",
			"dataset = #{dataset,jdbcType=INTEGER},",
			"datarow = #{datarow,jdbcType=INTEGER},",
			"datacolumn = #{datacolumn,jdbcType=VARCHAR},",
			"datavalue = #{datavalue,jdbcType=VARCHAR},",
			"shared = #{shared,jdbcType=BIT},",
			"userid = #{userid,jdbcType=INTEGER}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudyDerivedData record);
}