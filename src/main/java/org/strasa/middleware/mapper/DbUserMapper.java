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
import org.strasa.middleware.model.DbUser;
import org.strasa.middleware.model.DbUserExample;

public interface DbUserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@SelectProvider(type = DbUserSqlProvider.class, method = "countByExample")
	int countByExample(DbUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@DeleteProvider(type = DbUserSqlProvider.class, method = "deleteByExample")
	int deleteByExample(DbUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Delete({ "delete from user", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Insert({
			"insert into user (lastname, firstname, ",
			"mi, agency, username, ",
			"password, email, ",
			"address, country, ",
			"status, role, active, ",
			"dateregistered)",
			"values (#{lastname,jdbcType=VARCHAR}, #{firstname,jdbcType=VARCHAR}, ",
			"#{mi,jdbcType=VARCHAR}, #{agency,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
			"#{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
			"#{address,jdbcType=VARCHAR}, #{country,jdbcType=VARCHAR}, ",
			"#{status,jdbcType=BIT}, #{role,jdbcType=VARCHAR}, #{active,jdbcType=BIT}, ",
			"#{dateregistered,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(DbUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@InsertProvider(type = DbUserSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(DbUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@SelectProvider(type = DbUserSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "lastname", property = "lastname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "firstname", property = "firstname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "mi", property = "mi", jdbcType = JdbcType.VARCHAR),
			@Result(column = "agency", property = "agency", jdbcType = JdbcType.VARCHAR),
			@Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
			@Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
			@Result(column = "role", property = "role", jdbcType = JdbcType.VARCHAR),
			@Result(column = "active", property = "active", jdbcType = JdbcType.BIT),
			@Result(column = "dateregistered", property = "dateregistered", jdbcType = JdbcType.TIMESTAMP) })
	List<DbUser> selectByExample(DbUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Select({
			"select",
			"id, lastname, firstname, mi, agency, username, password, email, address, country, ",
			"status, role, active, dateregistered", "from user",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "lastname", property = "lastname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "firstname", property = "firstname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "mi", property = "mi", jdbcType = JdbcType.VARCHAR),
			@Result(column = "agency", property = "agency", jdbcType = JdbcType.VARCHAR),
			@Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
			@Result(column = "country", property = "country", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
			@Result(column = "role", property = "role", jdbcType = JdbcType.VARCHAR),
			@Result(column = "active", property = "active", jdbcType = JdbcType.BIT),
			@Result(column = "dateregistered", property = "dateregistered", jdbcType = JdbcType.TIMESTAMP) })
	DbUser selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = DbUserSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") DbUser record,
			@Param("example") DbUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = DbUserSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") DbUser record,
			@Param("example") DbUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@UpdateProvider(type = DbUserSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(DbUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Feb 07 10:48:01 SGT 2014
	 */
	@Update({ "update user", "set lastname = #{lastname,jdbcType=VARCHAR},",
			"firstname = #{firstname,jdbcType=VARCHAR},",
			"mi = #{mi,jdbcType=VARCHAR},",
			"agency = #{agency,jdbcType=VARCHAR},",
			"username = #{username,jdbcType=VARCHAR},",
			"password = #{password,jdbcType=VARCHAR},",
			"email = #{email,jdbcType=VARCHAR},",
			"address = #{address,jdbcType=VARCHAR},",
			"country = #{country,jdbcType=VARCHAR},",
			"status = #{status,jdbcType=BIT},",
			"role = #{role,jdbcType=VARCHAR},",
			"active = #{active,jdbcType=BIT},",
			"dateregistered = #{dateregistered,jdbcType=TIMESTAMP}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(DbUser record);
}