package org.strasa.web.browsestudy.view.model;

import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudyTypeManagerImpl;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyType;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;


public class StudyInformation {
	StudyManagerImpl studyMan = new StudyManagerImpl();
	ProgramManagerImpl proramMan = new ProgramManagerImpl();
	ProjectManagerImpl projectMan = new ProjectManagerImpl();
	StudyTypeManagerImpl studyTypeMan= new StudyTypeManagerImpl();

	private Study selectedStudy = new Study();
	private Program selectedProgram = new Program();
	private Project selectedProject = new Project();
	private StudyType selectedStudyType = new StudyType();

	@NotifyChange("*")
	@GlobalCommand
	public void openStudyData(@BindingParam("studyId")Integer studyId){
		System.out.println("studyId"+ Integer.toString(studyId));
		selectedStudy = studyMan.getStudyById(studyId);
		try{
			selectedProgram = proramMan.getProgramById(selectedStudy.getProgramid());
		}catch(IndexOutOfBoundsException o){
			selectedProgram = new Program();
		}
		try{
			selectedProject = projectMan.getProjectById(selectedStudy.getProjectid());
		}catch(IndexOutOfBoundsException o){
			selectedProject = new Project();
		}
		try{
			selectedStudyType = studyTypeMan.getStudyTypeById(selectedStudy.getStudytypeid());
		}catch(IndexOutOfBoundsException o){
			selectedStudyType = new StudyType();
		}

	}

	public Study getSelectedStudy() {
		return selectedStudy;
	}


	public Program getSelectedProgram() {
		return selectedProgram;
	}

	public Project getSelectedProject() {
		return selectedProject;
	}

	public StudyType getSelectedStudyType() {
		return selectedStudyType;
	}

}