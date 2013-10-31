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
import org.strasa.middleware.model.StudyGermplasm;
import org.strasa.middleware.model.StudyGermplasmExample;

public interface StudyGermplasmMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@SelectProvider(type = StudyGermplasmSqlProvider.class, method = "countByExample")
	int countByExample(StudyGermplasmExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@DeleteProvider(type = StudyGermplasmSqlProvider.class, method = "deleteByExample")
	int deleteByExample(StudyGermplasmExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@Delete({ "delete from studygermplasm", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@Insert({
			"insert into studygermplasm (studyid, gid, ",
			"germplasmname, othername, ",
			"breeder, germplasmtypeid, ",
			"irnumber, ircross, ",
			"parentage, femaleparent, ",
			"maleparent, selectionhistory, ",
			"source, remarks)",
			"values (#{studyid,jdbcType=INTEGER}, #{gid,jdbcType=INTEGER}, ",
			"#{germplasmname,jdbcType=VARCHAR}, #{othername,jdbcType=VARCHAR}, ",
			"#{breeder,jdbcType=VARCHAR}, #{germplasmtypeid,jdbcType=INTEGER}, ",
			"#{irnumber,jdbcType=VARCHAR}, #{ircross,jdbcType=VARCHAR}, ",
			"#{parentage,jdbcType=VARCHAR}, #{femaleparent,jdbcType=VARCHAR}, ",
			"#{maleparent,jdbcType=VARCHAR}, #{selectionhistory,jdbcType=VARCHAR}, ",
			"#{source,jdbcType=VARCHAR}, #{remarks,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudyGermplasm record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@InsertProvider(type = StudyGermplasmSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(StudyGermplasm record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@SelectProvider(type = StudyGermplasmSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "gid", property = "gid", jdbcType = JdbcType.INTEGER),
			@Result(column = "germplasmname", property = "germplasmname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "othername", property = "othername", jdbcType = JdbcType.VARCHAR),
			@Result(column = "breeder", property = "breeder", jdbcType = JdbcType.VARCHAR),
			@Result(column = "germplasmtypeid", property = "germplasmtypeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "irnumber", property = "irnumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ircross", property = "ircross", jdbcType = JdbcType.VARCHAR),
			@Result(column = "parentage", property = "parentage", jdbcType = JdbcType.VARCHAR),
			@Result(column = "femaleparent", property = "femaleparent", jdbcType = JdbcType.VARCHAR),
			@Result(column = "maleparent", property = "maleparent", jdbcType = JdbcType.VARCHAR),
			@Result(column = "selectionhistory", property = "selectionhistory", jdbcType = JdbcType.VARCHAR),
			@Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remarks", property = "remarks", jdbcType = JdbcType.VARCHAR) })
	List<StudyGermplasm> selectByExample(StudyGermplasmExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@Select({
			"select",
			"id, studyid, gid, germplasmname, othername, breeder, germplasmtypeid, irnumber, ",
			"ircross, parentage, femaleparent, maleparent, selectionhistory, source, remarks",
			"from studygermplasm", "where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "studyid", property = "studyid", jdbcType = JdbcType.INTEGER),
			@Result(column = "gid", property = "gid", jdbcType = JdbcType.INTEGER),
			@Result(column = "germplasmname", property = "germplasmname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "othername", property = "othername", jdbcType = JdbcType.VARCHAR),
			@Result(column = "breeder", property = "breeder", jdbcType = JdbcType.VARCHAR),
			@Result(column = "germplasmtypeid", property = "germplasmtypeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "irnumber", property = "irnumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ircross", property = "ircross", jdbcType = JdbcType.VARCHAR),
			@Result(column = "parentage", property = "parentage", jdbcType = JdbcType.VARCHAR),
			@Result(column = "femaleparent", property = "femaleparent", jdbcType = JdbcType.VARCHAR),
			@Result(column = "maleparent", property = "maleparent", jdbcType = JdbcType.VARCHAR),
			@Result(column = "selectionhistory", property = "selectionhistory", jdbcType = JdbcType.VARCHAR),
			@Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remarks", property = "remarks", jdbcType = JdbcType.VARCHAR) })
	StudyGermplasm selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@UpdateProvider(type = StudyGermplasmSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") StudyGermplasm record,
			@Param("example") StudyGermplasmExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@UpdateProvider(type = StudyGermplasmSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") StudyGermplasm record,
			@Param("example") StudyGermplasmExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@UpdateProvider(type = StudyGermplasmSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(StudyGermplasm record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table studygermplasm
	 * @mbggenerated  Thu Oct 31 10:09:05 SGT 2013
	 */
	@Update({ "update studygermplasm",
			"set studyid = #{studyid,jdbcType=INTEGER},",
			"gid = #{gid,jdbcType=INTEGER},",
			"germplasmname = #{germplasmname,jdbcType=VARCHAR},",
			"othername = #{othername,jdbcType=VARCHAR},",
			"breeder = #{breeder,jdbcType=VARCHAR},",
			"germplasmtypeid = #{germplasmtypeid,jdbcType=INTEGER},",
			"irnumber = #{irnumber,jdbcType=VARCHAR},",
			"ircross = #{ircross,jdbcType=VARCHAR},",
			"parentage = #{parentage,jdbcType=VARCHAR},",
			"femaleparent = #{femaleparent,jdbcType=VARCHAR},",
			"maleparent = #{maleparent,jdbcType=VARCHAR},",
			"selectionhistory = #{selectionhistory,jdbcType=VARCHAR},",
			"source = #{source,jdbcType=VARCHAR},",
			"remarks = #{remarks,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(StudyGermplasm record);
}