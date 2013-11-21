package org.strasa.web.browsestudy.view.model;

import java.util.List;

import org.strasa.middleware.manager.BrowseStudyManagerImpl;
import org.strasa.middleware.manager.CountryManagerImpl;
import org.strasa.middleware.manager.LocationManagerImpl;
import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyTypeManagerImpl;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.StudyType;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

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
	private List<Location> locationList = locationMan.getAllLocations();

	private boolean validation = false;
	private int validationCount = 0;

	public StudySearchFilterModel getSearchFilter() {
		return searchFilter;
	}


	public void setSearchFilter(StudySearchFilterModel searchFilter) {
		this.searchFilter = searchFilter;
	}

	public List<Program> getProgramList() {
		programList.add(0, new Program());
		return programList;
	}

	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}

	public List<Project> getProjectList() {
		projectList.add(0, new Project());
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<StudyType> getStudyTypeList() {
		studyTypeList.add(0, new StudyType());
		return studyTypeList;
	}

	public void setStudyTypeList(List<StudyType> studyTypeList) {
		this.studyTypeList = studyTypeList;
	}

	public List<Country> getCountryList() {
		countryList.add(0, new Country());
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public List<Location> getLocationList() {
		locationList.add(0, new Location());
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	@Command
	public void updateSearchFilterValidation(@BindingParam("validateObject")Object validateObject){
		try{
			System.out.print("Object value is "+validateObject.toString());
			if(validateObject.toString().equals("")) validationCount--; //may natanggalan ng filter
			else if(validateObject.toString().equals("0"))validationCount--;
			else validationCount++; //may nagkaroon ng value
		}catch(NullPointerException npe){
			validationCount--; // object was set to Null
		}

		if(validationCount>0) validation=true; //meaning may atleast one na filter
		else validation=false; //lahat ng filter ay empty

		System.out.print(Integer.toString(validationCount)+ "number of Filters\n");
	}


	public boolean isValidation() {
		return validation;
	}


	public void setValidation(boolean validation) {
		this.validation = validation;
	}

}
