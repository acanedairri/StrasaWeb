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

public interface StudyDerivedDataMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@SelectProvider(type = StudyDerivedDataSqlProvider.class, method = "countByExample")
	int countByExample(StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@DeleteProvider(type = StudyDerivedDataSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@Insert({
			"insert into studyderiveddata (studyid, datarow, ",
			"datacolumn, datavalue)",
			"values (#{studyid,jdbcType=INTEGER}, #{datarow,jdbcType=INTEGER}, ",
			"#{datacolumn,jdbcType=VARCHAR}, #{datavalue,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyDerivedData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@InsertProvider(type = StudyDerivedDataSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyDerivedData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@SelectProvider(type = StudyDerivedDataSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "datarow", property = "datarow", jdbcType = JdbcType.INTEGER),
			@Result(column = "datacolumn", property = "datacolumn", jdbcType = JdbcType.VARCHAR),
			@Result(column = "datavalue", property = "datavalue", jdbcType = JdbcType.VARCHAR) })
	List<StudyDerivedData> selectByExample(StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@UpdateProvider(type = StudyDerivedDataSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyDerivedData record,
			@Param("example") StudyDerivedDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyderiveddata
	 * @mbggenerated  Fri Oct 18 13:25:23 SGT 2013
	 */
	@UpdateProvider(type = StudyDerivedDataSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyDerivedData record,
			@Param("example") StudyDerivedDataExample example);
}