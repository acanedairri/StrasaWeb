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
import org.strasa.middleware.model.StudyDataSet;
import org.strasa.middleware.model.StudyDataSetExample;

public interface StudyDataSetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @SelectProvider(type=StudyDataSetSqlProvider.class, method="countByExample")
    int countByExample(StudyDataSetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @DeleteProvider(type=StudyDataSetSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudyDataSetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @Delete({
        "delete from studydataset",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @Insert({
        "insert into studydataset (studyid, title)",
        "values (#{studyid,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(StudyDataSet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @InsertProvider(type=StudyDataSetSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(StudyDataSet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @SelectProvider(type=StudyDataSetSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="studyid", property="studyid", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    List<StudyDataSet> selectByExample(StudyDataSetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @Select({
        "select",
        "id, studyid, title",
        "from studydataset",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="studyid", property="studyid", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    StudyDataSet selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @UpdateProvider(type=StudyDataSetSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudyDataSet record, @Param("example") StudyDataSetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @UpdateProvider(type=StudyDataSetSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudyDataSet record, @Param("example") StudyDataSetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @UpdateProvider(type=StudyDataSetSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudyDataSet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studydataset
     *
     * @mbggenerated Fri Jan 10 16:16:00 SGT 2014
     */
    @Update({
        "update studydataset",
        "set studyid = #{studyid,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudyDataSet record);
}