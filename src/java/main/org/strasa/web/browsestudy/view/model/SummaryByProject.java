package org.strasa.web.browsestudy.view.model;

import java.util.List;

public class SummaryByProject {
	
	
	List<SummaryByProjectModel>  summaryByProjectData= new SummaryMockData().getSummaryByProject();

	public List<SummaryByProjectModel> getSummaryByProjectData() {
		return summaryByProjectData;
	}

	public void setSummaryByProjectData(
			List<SummaryByProjectModel> summaryByProjectData) {
		this.summaryByProjectData = summaryByProjectData;
	}
	
	

}
