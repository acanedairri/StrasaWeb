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
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudyRawDataExample;

public interface StudyRawDataMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@SelectProvider(type = StudyRawDataSqlProvider.class, method = "countByExample")
	int countByExample(StudyRawDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@DeleteProvider(type = StudyRawDataSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyRawDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@Delete({ "delete from studyrawdata", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@Insert({
			"insert into studyrawdata (studyid, datarow, ",
			"datacolumn, datavalue)",
			"values (#{studyid,jdbcType=INTEGER}, #{datarow,jdbcType=INTEGER}, ",
			"#{datacolumn,jdbcType=VARCHAR}, #{datavalue,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyRawData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@InsertProvider(type = StudyRawDataSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyRawData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@SelectProvider(type = StudyRawDataSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "datarow", property = "datarow", jdbcType = JdbcType.INTEGER),
			@Result(column = "datacolumn", property = "datacolumn", jdbcType = JdbcType.VARCHAR),
			@Result(column = "datavalue", property = "datavalue", jdbcType = JdbcType.VARCHAR) })
	List<StudyRawData> selectByExample(StudyRawDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@Select({ "select", "id, studyid, datarow, datacolumn, datavalue",
			"from studyrawdata", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "datarow", property = "datarow", jdbcType = JdbcType.INTEGER),
			@Result(column = "datacolumn", property = "datacolumn", jdbcType = JdbcType.VARCHAR),
			@Result(column = "datavalue", property = "datavalue", jdbcType = JdbcType.VARCHAR) })
	StudyRawData selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@UpdateProvider(type = StudyRawDataSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyRawData record,
			@Param("example") StudyRawDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@UpdateProvider(type = StudyRawDataSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyRawData record,
			@Param("example") StudyRawDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@UpdateProvider(type = StudyRawDataSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudyRawData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyrawdata
	 * @mbggenerated  Fri Oct 25 17:15:33 SGT 2013
	 */
	@Update({ "update studyrawdata",
			"set studyid = #{studyid,jdbcType=INTEGER},",
			"datarow = #{datarow,jdbcType=INTEGER},",
			"datacolumn = #{datacolumn,jdbcType=VARCHAR},",
			"datavalue = #{datavalue,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudyRawData record);
}