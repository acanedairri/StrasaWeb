package org.strasa.web.maintenance.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.model.Study;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Tabpanel;


public class EditUploadedStudies {
	
	@Wire("#divMain")
	public Div divMain;
	
	@Wire("#divUpdateStudy")
	public Div divUpdateStudy;
	
	
	StudyManagerImpl studyMan;
	ProgramManagerImpl programMan;
	ProjectManagerImpl projectMan;

	
	private List<EditStudyModel> editStudyList;
	

	@Init
	public void init(){
		Integer studyId=1;
		
		studyMan = new StudyManagerImpl();
		programMan = new ProgramManagerImpl();
		projectMan = new ProjectManagerImpl();
		setEditStudyList(new ArrayList<EditStudyModel>());

		populateEditStudyList();
	}
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {

		Selectors.wireComponents(view, this, false);
		divUpdateStudy.setVisible(false);
	}

	private void populateEditStudyList() {
		// TODO Auto-generated method stub
		setEditStudyList(new ArrayList<EditStudyModel>());
		List<Study> studies = new ArrayList<Study>();
		studies = studyMan.getStudiesByUserID(1);
		int ctr=0;
		for(Study s: studies){
			EditStudyModel e = new EditStudyModel();
			e.setIndex(ctr);
			e.setStudy(s);
			e.setPrivacy(false);
			e.setProgram(programMan.getProgramById(s.getProgramid()));
			e.setProject(projectMan.getProjectById(s.getProjectid()));
			
			editStudyList.add(e);
			ctr++;
		}
		
	}

	public List<EditStudyModel> getEditStudyList() {
		
		return editStudyList;
	}

	public void setEditStudyList(List<EditStudyModel> editStudyList) {
		this.editStudyList = editStudyList;
	}
	
	
	@Command
	public void loadMainDiv(){
		divUpdateStudy.setVisible(false);
		divMain.setVisible(true);
	}
	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName,
			@BindingParam("target") Tabpanel panel) {
		if (panel != null && panel.getChildren().isEmpty()) {
			 Map<String, Integer> arg = new HashMap<String, Integer>();
		        arg.put("userId", editStudyList.get(0).getStudy().getUserid());
			Executions.createComponents(zulFileName, panel, arg);
			
		}
	}
	
	@Command
	public void editStudy(@ContextParam(ContextType.VIEW) Component view,@BindingParam("studyID") Integer studyid){
		divMain.setVisible(false);
//		divUpdateStudy.detach();
		divUpdateStudy.setVisible(true);
		Map arg = new HashMap();
		arg.put("studyID", studyid);
		List<Component> list = Selectors.find(view, "#divUpdateStudyContainer");
		 Components.removeAllChildren(list.get(0));
		Executions.createComponents("/user/updatestudy/index.zul" , list.get(0), arg);
	}
	
	@Command
	public void addStudy(@ContextParam(ContextType.VIEW) Component view){
		divMain.setVisible(false);
//		divUpdateStudy.detach();
		divUpdateStudy.setVisible(true);
		Map arg = new HashMap();
		List<Component> list = Selectors.find(view, "#divUpdateStudyContainer");
		 Components.removeAllChildren(list.get(0));
		Executions.createComponents("/user/uploadstudy/index.zul" , list.get(0), arg);
	}
	@NotifyChange("editStudyList")
	@Command("deleteStudy")
	public void deleteStudy(@BindingParam("studyId") Integer studyId){
		studyMan.deleteStudyById(studyId);
		populateEditStudyList();
	}

	@NotifyChange("*")
	@Command("changeStudyPrivacy")
	public void onCheck(@BindingParam("study") Study study){
//		System.out.println("id: "+Integer.toString(study.getId()));
//		if(study.getShared()) study.setShared(1);
		System.out.println("shared:" +study.getShared());
		studyMan.updateStudyById(study);
		Messagebox.show("Changes saved.");
	}
}