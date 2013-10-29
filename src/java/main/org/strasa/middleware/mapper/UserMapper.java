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
import org.strasa.middleware.model.User;
import org.strasa.middleware.model.UserExample;

public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@SelectProvider(type = UserSqlProvider.class, method = "countByExample")
	int countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@DeleteProvider(type = UserSqlProvider.class, method = "deleteByExample")
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@Delete({ "delete from user", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@Insert({
			"insert into user (lastname, firstname, ",
			"mi, agency, username, ",
			"password, email, ",
			"address, country, ",
			"status, role, dateregistered)",
			"values (#{lastname,jdbcType=VARCHAR}, #{firstname,jdbcType=VARCHAR}, ",
			"#{mi,jdbcType=VARCHAR}, #{agency,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
			"#{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
			"#{address,jdbcType=VARCHAR}, #{country,jdbcType=VARCHAR}, ",
			"#{status,jdbcType=BIT}, #{role,jdbcType=CHAR}, #{dateregistered,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@SelectProvider(type = UserSqlProvider.class, method = "selectByExample")
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
			@Result(column = "role", property = "role", jdbcType = JdbcType.CHAR),
			@Result(column = "dateregistered", property = "dateregistered", jdbcType = JdbcType.TIMESTAMP) })
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@Select({
			"select",
			"id, lastname, firstname, mi, agency, username, password, email, address, country, ",
			"status, role, dateregistered", "from user",
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
			@Result(column = "role", property = "role", jdbcType = JdbcType.CHAR),
			@Result(column = "dateregistered", property = "dateregistered", jdbcType = JdbcType.TIMESTAMP) })
	User selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
	 */
	@UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Tue Oct 29 15:37:45 SGT 2013
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
			"role = #{role,jdbcType=CHAR},",
			"dateregistered = #{dateregistered,jdbcType=TIMESTAMP}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(User record);
}