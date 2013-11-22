package org.strasa.web.browsestudy.view.model;

import java.util.List;

import org.strasa.middleware.manager.BrowseStudyManagerImpl;
import org.strasa.middleware.manager.CountryManagerImpl;
import org.strasa.middleware.manager.LocationManagerImpl;
import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyTypeManagerImpl;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.StudyType;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;

public class SearchResult {
	private BrowseStudyManagerImpl browseStudyManagerImpl= new BrowseStudyManagerImpl();

	private List<StudySearchResultModel> searchResult = null;

	@NotifyChange("*")
	@GlobalCommand
	public void updateSearchFilterResult(@BindingParam("searchFilter")StudySearchFilterModel searchFilter, @BindingParam("searchValidation")boolean searchValidation){
		if(searchValidation){
		searchFilter.shared = checkIfEmpty(searchFilter.shared);
		searchFilter.studyname = checkIfEmpty(searchFilter.studyname);
		searchFilter.country = checkIfEmpty(searchFilter.country);
		
		searchResult = browseStudyManagerImpl.getStudySearchResult(searchFilter);
		System.out.println("Size:"+searchResult.size());
		}else{
			 Messagebox.show("Please filter your search.", "Search Filter too broad", Messagebox.OK, Messagebox.EXCLAMATION);
		}
	}

	@NotifyChange("*")
	@GlobalCommand
	public void updateSummaryResult(@BindingParam("summaryFilter")StudySummaryModel summary){
		StudySearchFilterModel searchFilter = new StudySearchFilterModel();
		searchFilter.setProgramid(summary.getProgramId());
		searchFilter.setProjectid(summary.getProjectId());
		
		searchResult = browseStudyManagerImpl.getStudySearchResult(searchFilter);
		System.out.println("Size:"+searchResult.size());

	}
	@NotifyChange("*")
	@GlobalCommand
	public void updateSummaryResultByStudyType(@BindingParam("summaryFilter")StudySummaryModel summary, @BindingParam("studyTypeId")Integer studyTypeId){
		StudySearchFilterModel searchFilter = new StudySearchFilterModel();
		searchFilter.setProgramid(summary.getProgramId());
		searchFilter.setProjectid(summary.getProjectId());
		searchFilter.setStudytypeid(studyTypeId);
		searchResult = browseStudyManagerImpl.getStudySearchResult(searchFilter);
		System.out.println("Result "+summary.toString());

	}
	private String checkIfEmpty(String string) {
		// TODO Auto-generated method stub
		try{
			if(string.isEmpty()) return null;
		}catch(NullPointerException npe){
//			System.out.println("Caught Null Pointer Exception at SearchResult.java under user browse study");
		}
		
		return string;
	}

	public List<StudySearchResultModel> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<StudySearchResultModel> searchResult) {
		this.searchResult = searchResult;
	}

	public BrowseStudyManagerImpl getBrowseStudyManagerImpl() {
		return browseStudyManagerImpl;
	}

	public void setBrowseStudyManagerImpl(BrowseStudyManagerImpl browseStudyManagerImpl) {
		this.browseStudyManagerImpl = browseStudyManagerImpl;
	}
}
