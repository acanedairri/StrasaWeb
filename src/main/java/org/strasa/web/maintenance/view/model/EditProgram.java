package org.strasa.web.maintenance.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.model.Program;
import org.strasa.web.uploadstudy.view.model.AddProgram;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


public class EditProgram {
	ProgramManagerImpl programMan;
	StudyManagerImpl studyMan;
	List<ProgramStatus> programList = new ArrayList<ProgramStatus>(); 

	public List<ProgramStatus> getProgramList() {
		return programList;
	}
	public void setProgramList(List<ProgramStatus> programList) {
		this.programList = programList;
	}
	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view){
		programMan = new ProgramManagerImpl();
		studyMan = new StudyManagerImpl();
		 makeProgramStatus(programMan.getProgramByUserId());
		//		programList = new ArrayList<program>();

//		programList = makeProgramStatus(programMan.getProgramByUserId(userId));
	}

	private void makeProgramStatus(List<Program> programByUserId) {
		// TODO Auto-generated method stub
		
		programList.clear();
		for (Program p: programByUserId){
			ProgramStatus ps = new ProgramStatus(p,false);
			programList.add(ps);
		}
	}
	
	@Command
	public void changeEditableStatus(@BindingParam("ProgramStatus") ProgramStatus ps) {
		ps.setEditingStatus(!ps.getEditingStatus());
		refreshRowTemplate(ps);
	}

	@Command
	public void confirm(@BindingParam("ProgramStatus") ProgramStatus ps) {
		changeEditableStatus(ps);
		refreshRowTemplate(ps);
		programMan.updateProgram(ps.getProgram());
		Messagebox.show("Changes saved.");
	}

	public void refreshRowTemplate(ProgramStatus ps) {
		/*
		 * This code is special and notifies ZK that the bean's value
		 * has changed as it is used in the template mechanism.
		 * This stops the entire Grid's data from being refreshed
		 */
		BindUtils.postNotifyChange(null, null, ps, "editingStatus");
	}
	@NotifyChange("programList")
	@Command("deleteProgram")
	public void deleteStudy(@BindingParam("programId") Integer programId){

		if(studyMan.getStudyByProgramId(programId).isEmpty()){
			programMan.deleteProgramById(programId);
			makeProgramStatus(programMan.getProgramByUserId());
			Messagebox.show("Changes saved.");
		}
		else  Messagebox.show("Cannot delete a program with studies.", "Error", Messagebox.OK, Messagebox.ERROR); 
	}

	@NotifyChange("*")
	@Command("addProgram")
	public void addProgram(@ContextParam(ContextType.COMPONENT) Component component) {
		Window win = (Window) component.getFellow("editProgramWindow");
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar", null);

		Window popup = (Window) Executions.createComponents(
				AddProgram.ZUL_PATH, win, params);

		popup.doModal();
		makeProgramStatus(programMan.getProgramByUserId());
	}

	@NotifyChange("programList")
	@Command("refreshProgramList")
	public void refreshProgramList(@BindingParam("selected") Program selected) {
		makeProgramStatus(programMan.getProgramByUserId());
	}
	
	public class ProgramStatus {
	    private Program p;
	    private boolean editingStatus;
	     
	    public ProgramStatus(Program p, boolean editingStatus) {
	        this.p = p;
	        this.editingStatus = editingStatus;
	    }
	     
	    public Program getProgram() {
	        return p;
	    }
	     
	    public boolean getEditingStatus() {
	        return editingStatus;
	    }
	     
	    public void setEditingStatus(boolean editingStatus) {
	        this.editingStatus = editingStatus;
	    }
	}
}