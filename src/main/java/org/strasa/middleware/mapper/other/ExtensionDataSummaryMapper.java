package org.strasa.middleware.mapper.other;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.strasa.web.browsestudy.view.model.StudySummaryModel;
import org.strasa.web.extensiondata.view.model.ExtensionDataSummaryModel;

public interface ExtensionDataSummaryMapper {

	@Select("Select countryrelease as data,count(germplasmname)as totalcount from extensiondata group by countryrelease")
	List<ExtensionDataSummaryModel> selectExtentionDataSummaryByCountryRelease();
	
	
	@Select("Select year as data,count(germplasmname)as totalcount from extensiondata group by year")
	List<ExtensionDataSummaryModel> selectExtentionDataSummaryByYear();
	
}
