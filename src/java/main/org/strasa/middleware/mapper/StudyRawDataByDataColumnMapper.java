package org.strasa.middleware.mapper;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudyRawDataByDataColumnExample;

public interface StudyRawDataByDataColumnMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studyrawdata
     *
     * @mbggenerated Fri Oct 25 13:11:54 SGT 2013
     */
    @SelectProvider(type=StudyRawDataByDataColumnSqlProvider.class, method="countByExample")
    int countByExample(StudyRawDataByDataColumnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studyrawdata
     *
     * @mbggenerated Fri Oct 25 13:11:54 SGT 2013
     */
    @DeleteProvider(type=StudyRawDataByDataColumnSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudyRawDataByDataColumnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studyrawdata
     *
     * @mbggenerated Fri Oct 25 13:11:54 SGT 2013
     */
    @Insert({
        "insert into studyrawdata (studyid, datacolumn, ",
        "datavalue)",
        "values (#{studyid,jdbcType=INTEGER}, #{datacolumn,jdbcType=VARCHAR}, ",
        "#{datavalue,jdbcType=VARCHAR})"
    })
    int insert(StudyRawDataByDataColumn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studyrawdata
     *
     * @mbggenerated Fri Oct 25 13:11:54 SGT 2013
     */
    @InsertProvider(type=StudyRawDataByDataColumnSqlProvider.class, method="insertSelective")
    int insertSelective(StudyRawDataByDataColumn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studyrawdata
     *
     * @mbggenerated Fri Oct 25 13:11:54 SGT 2013
     */
    @SelectProvider(type=StudyRawDataByDataColumnSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="studyid", property="studyid", jdbcType=JdbcType.INTEGER),
        @Result(column="datacolumn", property="datacolumn", jdbcType=JdbcType.VARCHAR),
        @Result(column="datavalue", property="datavalue", jdbcType=JdbcType.VARCHAR)
    })
    List<StudyRawDataByDataColumn> selectByExample(StudyRawDataByDataColumnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studyrawdata
     *
     * @mbggenerated Fri Oct 25 13:11:54 SGT 2013
     */
    @UpdateProvider(type=StudyRawDataByDataColumnSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudyRawDataByDataColumn record, @Param("example") StudyRawDataByDataColumnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studyrawdata
     *
     * @mbggenerated Fri Oct 25 13:11:54 SGT 2013
     */
    @UpdateProvider(type=StudyRawDataByDataColumnSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudyRawDataByDataColumn record, @Param("example") StudyRawDataByDataColumnExample example);
}