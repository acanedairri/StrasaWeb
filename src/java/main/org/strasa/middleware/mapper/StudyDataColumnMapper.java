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
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.middleware.model.StudyDataColumnExample;

public interface StudyDataColumnMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@SelectProvider(type = StudyDataColumnSqlProvider.class, method = "countByExample")
	int countByExample(StudyDataColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@DeleteProvider(type = StudyDataColumnSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyDataColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@Delete({ "delete from studydatacolumn",
			"where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@Insert({
			"insert into studydatacolumn (studyid, dataset, ",
			"columnheader, datatype)",
			"values (#{studyid,jdbcType=INTEGER}, #{dataset,jdbcType=INTEGER}, ",
			"#{columnheader,jdbcType=VARCHAR}, #{datatype,jdbcType=CHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyDataColumn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@InsertProvider(type = StudyDataColumnSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyDataColumn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@SelectProvider(type = StudyDataColumnSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "dataset", property = "dataset", jdbcType = JdbcType.INTEGER),
			@Result(column = "columnheader", property = "columnheader", jdbcType = JdbcType.VARCHAR),
			@Result(column = "datatype", property = "datatype", jdbcType = JdbcType.CHAR) })
	List<StudyDataColumn> selectByExample(StudyDataColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@Select({ "select", "id, studyid, dataset, columnheader, datatype",
			"from studydatacolumn", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "dataset", property = "dataset", jdbcType = JdbcType.INTEGER),
			@Result(column = "columnheader", property = "columnheader", jdbcType = JdbcType.VARCHAR),
			@Result(column = "datatype", property = "datatype", jdbcType = JdbcType.CHAR) })
	StudyDataColumn selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@UpdateProvider(type = StudyDataColumnSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyDataColumn record,
			@Param("example") StudyDataColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@UpdateProvider(type = StudyDataColumnSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyDataColumn record,
			@Param("example") StudyDataColumnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@UpdateProvider(type = StudyDataColumnSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudyDataColumn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studydatacolumn
	 * @mbggenerated  Fri Dec 13 11:10:23 SGT 2013
	 */
	@Update({ "update studydatacolumn",
			"set studyid = #{studyid,jdbcType=INTEGER},",
			"dataset = #{dataset,jdbcType=INTEGER},",
			"columnheader = #{columnheader,jdbcType=VARCHAR},",
			"datatype = #{datatype,jdbcType=CHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudyDataColumn record);
}