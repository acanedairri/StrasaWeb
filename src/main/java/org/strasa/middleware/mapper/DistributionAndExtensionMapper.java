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
import org.strasa.middleware.model.DistributionAndExtension;
import org.strasa.middleware.model.DistributionAndExtensionExample;

public interface DistributionAndExtensionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @SelectProvider(type=DistributionAndExtensionSqlProvider.class, method="countByExample")
    int countByExample(DistributionAndExtensionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @DeleteProvider(type=DistributionAndExtensionSqlProvider.class, method="deleteByExample")
    int deleteByExample(DistributionAndExtensionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @Delete({
        "delete from distributionandextension",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @Insert({
        "insert into distributionandextension (programid, projectid, ",
        "germplasmname, yearextension, ",
        "locationextension, countryextension, ",
        "plantingarea, datasource, ",
        "seedavailability, amountseeddistributed, ",
        "numfarmersadopted, amountseedsproduced, ",
        "userid)",
        "values (#{programid,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{germplasmname,jdbcType=VARCHAR}, #{yearextension,jdbcType=VARCHAR}, ",
        "#{locationextension,jdbcType=VARCHAR}, #{countryextension,jdbcType=VARCHAR}, ",
        "#{plantingarea,jdbcType=DOUBLE}, #{datasource,jdbcType=VARCHAR}, ",
        "#{seedavailability,jdbcType=INTEGER}, #{amountseeddistributed,jdbcType=INTEGER}, ",
        "#{numfarmersadopted,jdbcType=INTEGER}, #{amountseedsproduced,jdbcType=DOUBLE}, ",
        "#{userid,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(DistributionAndExtension record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @InsertProvider(type=DistributionAndExtensionSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(DistributionAndExtension record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @SelectProvider(type=DistributionAndExtensionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="programid", property="programid", jdbcType=JdbcType.INTEGER),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="germplasmname", property="germplasmname", jdbcType=JdbcType.VARCHAR),
        @Result(column="yearextension", property="yearextension", jdbcType=JdbcType.VARCHAR),
        @Result(column="locationextension", property="locationextension", jdbcType=JdbcType.VARCHAR),
        @Result(column="countryextension", property="countryextension", jdbcType=JdbcType.VARCHAR),
        @Result(column="plantingarea", property="plantingarea", jdbcType=JdbcType.DOUBLE),
        @Result(column="datasource", property="datasource", jdbcType=JdbcType.VARCHAR),
        @Result(column="seedavailability", property="seedavailability", jdbcType=JdbcType.INTEGER),
        @Result(column="amountseeddistributed", property="amountseeddistributed", jdbcType=JdbcType.INTEGER),
        @Result(column="numfarmersadopted", property="numfarmersadopted", jdbcType=JdbcType.INTEGER),
        @Result(column="amountseedsproduced", property="amountseedsproduced", jdbcType=JdbcType.DOUBLE),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER)
    })
    List<DistributionAndExtension> selectByExample(DistributionAndExtensionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @Select({
        "select",
        "id, programid, projectid, germplasmname, yearextension, locationextension, countryextension, ",
        "plantingarea, datasource, seedavailability, amountseeddistributed, numfarmersadopted, ",
        "amountseedsproduced, userid",
        "from distributionandextension",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="programid", property="programid", jdbcType=JdbcType.INTEGER),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="germplasmname", property="germplasmname", jdbcType=JdbcType.VARCHAR),
        @Result(column="yearextension", property="yearextension", jdbcType=JdbcType.VARCHAR),
        @Result(column="locationextension", property="locationextension", jdbcType=JdbcType.VARCHAR),
        @Result(column="countryextension", property="countryextension", jdbcType=JdbcType.VARCHAR),
        @Result(column="plantingarea", property="plantingarea", jdbcType=JdbcType.DOUBLE),
        @Result(column="datasource", property="datasource", jdbcType=JdbcType.VARCHAR),
        @Result(column="seedavailability", property="seedavailability", jdbcType=JdbcType.INTEGER),
        @Result(column="amountseeddistributed", property="amountseeddistributed", jdbcType=JdbcType.INTEGER),
        @Result(column="numfarmersadopted", property="numfarmersadopted", jdbcType=JdbcType.INTEGER),
        @Result(column="amountseedsproduced", property="amountseedsproduced", jdbcType=JdbcType.DOUBLE),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER)
    })
    DistributionAndExtension selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @UpdateProvider(type=DistributionAndExtensionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DistributionAndExtension record, @Param("example") DistributionAndExtensionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @UpdateProvider(type=DistributionAndExtensionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DistributionAndExtension record, @Param("example") DistributionAndExtensionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @UpdateProvider(type=DistributionAndExtensionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DistributionAndExtension record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table distributionandextension
     *
     * @mbggenerated Tue Feb 18 13:50:57 SGT 2014
     */
    @Update({
        "update distributionandextension",
        "set programid = #{programid,jdbcType=INTEGER},",
          "projectid = #{projectid,jdbcType=INTEGER},",
          "germplasmname = #{germplasmname,jdbcType=VARCHAR},",
          "yearextension = #{yearextension,jdbcType=VARCHAR},",
          "locationextension = #{locationextension,jdbcType=VARCHAR},",
          "countryextension = #{countryextension,jdbcType=VARCHAR},",
          "plantingarea = #{plantingarea,jdbcType=DOUBLE},",
          "datasource = #{datasource,jdbcType=VARCHAR},",
          "seedavailability = #{seedavailability,jdbcType=INTEGER},",
          "amountseeddistributed = #{amountseeddistributed,jdbcType=INTEGER},",
          "numfarmersadopted = #{numfarmersadopted,jdbcType=INTEGER},",
          "amountseedsproduced = #{amountseedsproduced,jdbcType=DOUBLE},",
          "userid = #{userid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DistributionAndExtension record);
}