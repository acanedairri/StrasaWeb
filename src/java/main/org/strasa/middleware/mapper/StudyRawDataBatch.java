package org.strasa.middleware.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.custom.RawLocationModel;

public interface StudyRawDataBatch {
	String MQL_LOCATION="SELECT DISTINCT "		
			+ "t1.datavalue as locationname, "
			+ "t2.datavalue as country, " 
			+ "t3.datavalue as province, " 
			+ "t4.datavalue as region, "
			+ "t5.datavalue as altitude, "
			+ "t6.datavalue as latitude, "
			+ "t7.datavalue as weatherstation "
			+ "FROM ${param2} t1 "
			+ "LEFT JOIN (SELECT datavalue,datarow FROM ${param2} WHERE datacolumn='Country') t2 ON t1.datarow = t2.datarow "
			+ "LEFT JOIN (SELECT datavalue,datarow FROM ${param2} WHERE datacolumn='Province') t3 ON t1.datarow = t3.datarow "
			+ "LEFT JOIN (SELECT datavalue,datarow FROM ${param2} WHERE datacolumn='Region') t4 ON t1.datarow = t4.datarow "
			+ "LEFT JOIN (SELECT datavalue,datarow FROM ${param2} WHERE datacolumn='Altitude') t5 ON t1.datarow = t5.datarow "
			+ "LEFT JOIN (SELECT datavalue,datarow FROM ${param2} WHERE datacolumn='Latitude') t6 ON t1.datarow = t6.datarow "
			+ "LEFT JOIN (SELECT datavalue,datarow FROM ${param2} WHERE datacolumn='Weather Station') t7 ON t1.datarow = t7.datarow "
			+ "WHERE t1.studyid = #{param1} AND t1.datacolumn = 'Location'";
			
 public void insertBatchRaw(List<StudyRawData> datalist);
 public void insertBatchDerived(List<StudyRawData> datalist);
 @Select(MQL_LOCATION)
 public List<Location> getRawLocation(int studyid, String tname);
 
}
