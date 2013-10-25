package org.strasa.web.browsestudy.view.model;

import java.util.List;

public class SummaryByProgram {
	
	
	List<SummaryByProgramModel>  summaryByProgramData= new SummaryMockData().getSummaryByProgram();

	public List<SummaryByProgramModel> getSummaryByProgramData() {
		return summaryByProgramData;
	}

	public void setSummaryByProgramData(
			List<SummaryByProgramModel> summaryByProgramData) {
		this.summaryByProgramData = summaryByProgramData;
	}

	
	
	

}
