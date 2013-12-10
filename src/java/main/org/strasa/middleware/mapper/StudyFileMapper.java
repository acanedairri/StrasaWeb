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
import org.strasa.middleware.model.StudyFile;
import org.strasa.middleware.model.StudyFileExample;

public interface StudyFileMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@SelectProvider(type = StudyFileSqlProvider.class, method = "countByExample")
	int countByExample(StudyFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@DeleteProvider(type = StudyFileSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@Delete({ "delete from studyfile", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@Insert({
			"insert into studyfile (userid, studyid, ",
			"filename, filenamegen, ",
			"filepath, typeofdata)",
			"values (#{userid,jdbcType=INTEGER}, #{studyid,jdbcType=INTEGER}, ",
			"#{filename,jdbcType=VARCHAR}, #{filenamegen,jdbcType=VARCHAR}, ",
			"#{filepath,jdbcType=VARCHAR}, #{typeofdata,jdbcType=CHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@InsertProvider(type = StudyFileSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@SelectProvider(type = StudyFileSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "filename", property = "filename", jdbcType = JdbcType.VARCHAR),
			@Result(column = "filenamegen", property = "filenamegen", jdbcType = JdbcType.VARCHAR),
			@Result(column = "filepath", property = "filepath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "typeofdata", property = "typeofdata", jdbcType = JdbcType.CHAR) })
	List<StudyFile> selectByExample(StudyFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@Select({ "select",
			"id, userid, studyid, filename, filenamegen, filepath, typeofdata",
			"from studyfile", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "filename", property = "filename", jdbcType = JdbcType.VARCHAR),
			@Result(column = "filenamegen", property = "filenamegen", jdbcType = JdbcType.VARCHAR),
			@Result(column = "filepath", property = "filepath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "typeofdata", property = "typeofdata", jdbcType = JdbcType.CHAR) })
	StudyFile selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@UpdateProvider(type = StudyFileSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyFile record,
			@Param("example") StudyFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@UpdateProvider(type = StudyFileSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyFile record,
			@Param("example") StudyFileExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@UpdateProvider(type = StudyFileSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudyFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studyfile
	 * @mbggenerated  Tue Dec 10 09:23:53 SGT 2013
	 */
	@Update({ "update studyfile", "set userid = #{userid,jdbcType=INTEGER},",
			"studyid = #{studyid,jdbcType=INTEGER},",
			"filename = #{filename,jdbcType=VARCHAR},",
			"filenamegen = #{filenamegen,jdbcType=VARCHAR},",
			"filepath = #{filepath,jdbcType=VARCHAR},",
			"typeofdata = #{typeofdata,jdbcType=CHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudyFile record);
}