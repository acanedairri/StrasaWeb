package org.strasa.middleware.mapper.other;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.strasa.web.browsestudy.view.model.StudySummaryModel;
import org.strasa.web.extensiondata.view.model.ExtensionDataListModel;
import org.strasa.web.extensiondata.view.model.ExtensionDataSummaryModel;
import org.strasa.web.extensiondata.view.model.SummaryModel;

public interface ExtensionDataSummaryMapper {

/*	@Select("Select countryrelease as data,count(germplasmname)as totalcount from extensiondata group by countryrelease")
	List<ExtensionDataSummaryModel> selectExtentionDataSummaryByCountryRelease();


	@Select("Select year as data,count(germplasmname)as totalcount from extensiondata group by year")
	List<ExtensionDataSummaryModel> selectExtentionDataSummaryByYear();


	@Select("select t1.*, t2.name as programName,t3.name as projectName  from extensiondata as t1 left join program as t2 on t1.programid=t2.id left join project as t3 on t1.projectid=t3.id")
	List<ExtensionDataListModel> selectExtentionDataList();*/

	//Extention
	//Germplasm vs Year and Country
	//select t2.name,t1.year,t1.countryextension,t1.germplasmname,sum(t1.area) as sumArea from extensiondata as t1 left join program as t2 on t1.programid=t2.id group by programid,germplasmname order by countryextension,year
	@Select("select t2.name as programName,yearextension,t1.countryextension,t1.germplasmname,sum(area) as sumArea from extensiondata as t1 left join program as t2 on t1.programid=t2.id group by programid,germplasmname order by countryextension,yearextension")
	List<SummaryModel> selectAreaSummaryGermplasmByYearandCountryExtension();
	
	
	//Germplasm vs Country
	//select programid,germplasmname,countryextension,sum(area) as sumArea from extensiondata group by programid,germplasmname,countryextension order by countryrelease,year
	@Select("select t2.name as programName,t1.germplasmname,t1.countryextension,sum(t1.area) as sumArea from extensiondata as t1 left join program as t2 on t1.programid=t2.id group by programid,germplasmname,countryextension order by countryextension,yearextension")
	List<SummaryModel> selectAreaSummaryGermplasmByCountryExtension();

	
	//Germplasm vs Year
	//select programid,germplasmname,year,sum(area) as sumArea from extensiondata group by programid,germplasmname,year order by programid,year,germplasmname
	@Select("select t2.name as programName,t1.germplasmname,t1.yearextension,sum(t1.area) as sumArea from extensiondata as t1 left join program as t2 on t1.programid=t2.id group by programid,germplasmname,yearextension order by countryextension,yearextension")
	List<SummaryModel> selectAreaSummaryGermplasmByYear();
	

	
	
	//Release Information
	//No of Variety Release by country and year
	//select programid,countryrelease,year,count(germplasmname) as noOfVariety from extensiondata group by programid,year order by programid,year,germplasmname
	
	@Select("select t2.name as programName,t1.countryrelease,t1.yearrelease,count(t1.germplasmname) as countVariety from extensiondata as t1 left join program as t2 on t1.programid=t2.id group by programid,yearrelease order by programid,yearrelease,germplasmname")
	List<SummaryModel> selectNoOfVarietyReleaseByCountryAndYear();
	

	//No of Variety by CountryRelease
	//select programid,countryrelease,count(germplasmname) as noOfVariety from extensiondata group by programid order by programid,germplasmname
	@Select("select t2.name as programName,t1.countryrelease,count(t1.germplasmname) as countVariety from extensiondata as t1 left join program as t2 on t1.programid=t2.id group by programid order by programid,germplasmname")
	List<SummaryModel> selectNoOfVarietyReleaseByCountryRelease();
	
	
	//No of Variety by Year
	//select programid,year,count(germplasmname) as noOfVariety from extensiondata group by programid,year order by programid,year
	@Select("select t2.name as programName, t1.programid as programid,t1.yearrelease,count(t1.germplasmname) as countVariety from extensiondata as t1 left join program as t2 on t1.programid=t2.id group by programid,yearrelease order by programid,yearrelease")
	List<SummaryModel> selectNoOfVarietyReleaseByYear();
	
	//Names of Variety by Year
    @Select("select distinct germplasmname from extensiondata where yearrelease=#{year} and programid=#{programid}")
    List<String> selectVarietyNamesOfVarietyReleaseByYear(@Param("year")String year,@Param("programid")Integer programid);
}
