package org.strasa.web.browsestudy.view.model;

import java.util.List;

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
import org.zkoss.bind.annotation.NotifyChange;

public class SearchFilter {
	private ProgramManagerImpl programMan = new ProgramManagerImpl();
	private ProjectManagerImpl projectMan = new ProjectManagerImpl();
	private StudyTypeManagerImpl studyTypeMan = new StudyTypeManagerImpl();
	private CountryManagerImpl countryMan = new CountryManagerImpl();
	private LocationManagerImpl locationMan = new LocationManagerImpl();
	
	private StudySearchFilterModel searchFilter = new StudySearchFilterModel();
	private List<Program> programList = programMan.getAllProgram();
	private List<Project> projectList = projectMan.getAllProject();
	private List<StudyType> studyTypeList = studyTypeMan.getAllStudyType();
	private List<Country> countryList = countryMan.getAllCountry();
//	private List<Location> locationList = locationMan.
	
	public StudySearchFilterModel getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(StudySearchFilterModel searchFilter) {
		this.searchFilter = searchFilter;
	}

	public List<Program> getProgramList() {
		return programList;
	}

	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	@NotifyChange("*")
	@Command("updateSearchFilter")
	public void updateSearchFilter(){
	}

	public List<StudyType> getStudyTypeList() {
		return studyTypeList;
	}

	public void setStudyTypeList(List<StudyType> studyTypeList) {
		this.studyTypeList = studyTypeList;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

}
