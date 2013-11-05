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
import org.zkoss.bind.annotation.NotifyChange;

public class Summary {
	private ProgramManagerImpl programMan = new ProgramManagerImpl();
	private ProjectManagerImpl projectMan = new ProjectManagerImpl();
	private StudyTypeManagerImpl studyTypeMan = new StudyTypeManagerImpl();
	private BrowseStudyManagerImpl studyQueryManagerImpl= new BrowseStudyManagerImpl();
	
	private List<StudySummaryModel> summary= studyQueryManagerImpl.getStudySummary();
	private List<Program> programList = programMan.getAllProgram();
	private List<Project> projectList = projectMan.getAllProject();
	private List<StudyType> studyTypeList = studyTypeMan.getAllStudyType();
	
	@NotifyChange("*")
	@Command("updateSearchFilter")
	public void updateSearchFilter(){
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

	public List<StudyType> getStudyTypeList() {
		return studyTypeList;
	}

	public void setStudyTypeList(List<StudyType> studyTypeList) {
		this.studyTypeList = studyTypeList;
	}

	public List<StudySummaryModel> getSummary() {
		return summary;
	}

	public void setSummary(List<StudySummaryModel> summary) {
		this.summary = summary;
	}

}
