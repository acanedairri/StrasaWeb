package org.strasa.web.admin.view.model;

import java.util.HashMap;
import java.util.Map;

import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudyTypeManagerImpl;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyType;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Tabpanel;


public class AdminSettings {

	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName,
			@BindingParam("target") Tabpanel panel) {
		if (panel != null && panel.getChildren().isEmpty()) {
			 Map arg = new HashMap();
			Executions.createComponents(zulFileName, panel, arg);
			
		}
	}
	
//	@Init
//	public void init(@ExecutionArgParam("studyId") Integer studyId){
//		this.setStudyId(studyId);
//
//		System.out.println("studyId"+ Integer.toString(studyId));
//		selectedStudy = studyMan.getStudyById(studyId);
//		try{
//			selectedProgram = proramMan.getProgramById(selectedStudy.getProgramid());
//		}catch(IndexOutOfBoundsException o){
//			selectedProgram = new Program();
//		}
//		try{
//			selectedProject = projectMan.getProjectById(selectedStudy.getProjectid());
//		}catch(IndexOutOfBoundsException o){
//			selectedProject = new Project();
//		}
//		try{
//			selectedStudyType = studyTypeMan.getStudyTypeById(selectedStudy.getStudytypeid());
//		}catch(IndexOutOfBoundsException o){
//			selectedStudyType = new StudyType();
//		}
//
//	}

}