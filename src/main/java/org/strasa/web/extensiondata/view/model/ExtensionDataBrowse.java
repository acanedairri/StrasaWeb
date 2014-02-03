package org.strasa.web.extensiondata.view.model;

import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.zkoss.bind.annotation.Init;

public class ExtensionDataBrowse {


	private List<ExtensionDataSummaryModel> summaryByCountry;
	private List<ExtensionDataSummaryModel> summaryByYear;
	
	
	
	@Init
	public void setData(){
		ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
		this.summaryByCountry=mgr.getCountOfGermplasmByCountrRealease();
		this.summaryByYear=mgr.getCountOfGermplasmByYear();
	}


	public List<ExtensionDataSummaryModel> getSummaryByCountry() {
		return summaryByCountry;
	}
	public void setSummaryByCountry(List<ExtensionDataSummaryModel> summaryByCountry) {
		this.summaryByCountry = summaryByCountry;
	}
	public List<ExtensionDataSummaryModel> getSummaryByYear() {
		return summaryByYear;
	}
	public void setSummaryByYear(List<ExtensionDataSummaryModel> summaryByYear) {
		this.summaryByYear = summaryByYear;
	}

	









}
