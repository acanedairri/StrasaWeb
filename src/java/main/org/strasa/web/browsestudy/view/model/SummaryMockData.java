package org.strasa.web.browsestudy.view.model;

import java.util.ArrayList;
import java.util.List;

public class SummaryMockData {


	private List<SummaryByProjectModel> summaryByProject;
	private List<SummaryByProgramModel> summaryByProgram;
	private List<SummaryByCountryAndLocationModel> summaryByCountryAndLocation;
	
	
	SummaryMockData(){
		setSummaryByProject();
		
	}
	
	
	
	public List<SummaryByProjectModel> getSummaryByProject() {
		return summaryByProject;
	}


	public void setSummaryByProject() {

		List<SummaryByProjectModel> records= new ArrayList<SummaryByProjectModel>();

		for(int i=1;i< 20;i++){
			SummaryByProjectModel data= new SummaryByProjectModel();
			data.setProjectid(1);
			data.setProgramName("Program"+i);
			data.setProjectName("Project "+i);
			data.setStudyCount(i*5);
			records.add(data);
		}

		this.summaryByProject = records;
	}
	public List<SummaryByProgramModel> getSummaryByProgram() {
		return summaryByProgram;
	}
	public void setSummaryByProgram(List<SummaryByProgramModel> summaryByProgram) {
		this.summaryByProgram = summaryByProgram;
	}
	public List<SummaryByCountryAndLocationModel> getSummaryByCountryAndLocation() {
		return summaryByCountryAndLocation;
	}
	public void setSummaryByCountryAndLocation(
			List<SummaryByCountryAndLocationModel> summaryByCountryAndLocation) {
		this.summaryByCountryAndLocation = summaryByCountryAndLocation;
	}



}
