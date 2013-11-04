package org.strasa.web.uploadstudy.view.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.model.StudyVariable;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zul.Row;

public class DataColumnChanged {
	public static String ZUL_PATH = "/user/uploadstudy/datacolumnchanged.zul";
	private Binder parBinder;
	private String oldVar;
	private Component mainView;
	private StudyVariable selectedVar;
	
	 
	private List<StudyVariable> varList = new ArrayList<StudyVariable>(); 
	
	@Init
	public void Init(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view ,@ExecutionArgParam("oldVar")  String oldVar) {

	        StudyVariableManagerImpl studyVarMan = new StudyVariableManagerImpl();
	        varList = studyVarMan.getVariables(oldVar);
	        this.oldVar = oldVar;
	        System.out.println(oldVar);
	        mainView = view;
	        parBinder = (Binder) view.getParent().getAttribute("binder");
	    }

	public String getOldVar() {
		return oldVar;
	}

	public StudyVariable getSelectedVar() {
		return selectedVar;
	}

	public void setSelectedVar(StudyVariable selectedVar) {
		System.out.println(selectedVar.getDescription());
		this.selectedVar = selectedVar;
		Binder bind = parBinder;
		if (bind == null)
			return;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("newValue", selectedVar.getVariablecode());
		params.put("oldVar", oldVar);

		// this.parBinder.postCommand("change", params);
		bind.postCommand("refreshVarList", params);
		
		mainView.detach();
	}

	public void setOldVar(String oldVar) {
		this.oldVar = oldVar;
	}

	public List<StudyVariable> getVarList() {
		return varList;
	}

	public void setVarList(List<StudyVariable> varList) {
		this.varList = varList;
	}
	@Command("selectVar")
	public void change(@ContextParam(ContextType.VIEW) Component view, @BindingParam("selVar") String selectedVar) {
		
		Binder bind = parBinder;
		if (bind == null)
			return;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("newValue", selectedVar);

		// this.parBinder.postCommand("change", params);
		bind.postCommand("change", params);
		
		view.detach();
	}
	
	
	public void onItemClicked(Event ev) throws Exception {
		Event origin;
		// get event target
		if (ev instanceof ForwardEvent) {
			origin = Events.getRealOrigin((ForwardEvent)ev);
		} else {
			origin = ev;
		}
		Component target = origin.getTarget();
		System.out.print(((Row)target).getValue());
	}
	
}
