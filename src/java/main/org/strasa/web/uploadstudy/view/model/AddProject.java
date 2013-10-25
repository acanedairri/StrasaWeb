package org.strasa.web.uploadstudy.view.model;

import java.util.HashMap;
import java.util.Map;

import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.model.Project;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Messagebox;

public class AddProject {
	public static String ZUL_PATH = "/user/uploadstudy/addproject.zul";
	private String name, objective, pi,fundingagency, coordinator, institute, collaborators;
	private Component mainView;
	private Binder parBinder;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getPi() {
		return pi;
	}

	public void setPi(String pi) {
		this.pi = pi;
	}

	public String getFundingagency() {
		return fundingagency;
	}

	public void setFundingagency(String fundingagency) {
		this.fundingagency = fundingagency;
	}

	public String getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(String collaborators) {
		this.collaborators = collaborators;
	}

	public Component getMainView() {
		return mainView;
	}

	public void setMainView(Component mainView) {
		this.mainView = mainView;
	}

	public Binder getParBinder() {
		return parBinder;
	}

	public void setParBinder(Binder parBinder) {
		this.parBinder = parBinder;
	}

	@Init
	public void Init(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view ,@ExecutionArgParam("oldVar")  String oldVar) {

	        mainView = view;
	        parBinder = (Binder) view.getParent().getAttribute("binder");
	        
	}
	
	@Command("add")
	public void add(){
		ProjectManagerImpl programMan = new ProjectManagerImpl();
		Project record = new Project();
		record.setCollaborators(collaborators);
//		record.setCoordinators(coordinator);
		record.setLeadinginstitute(institute);
		record.setName(name);
		record.setObjective(objective);
		
		//TODO IMPORTANT!!! Must change this to real UserID
		record.setUserid(1);
		programMan.addProject(record);
		
		//TODO Validate!!
		Messagebox.show("Program successfully added to database!", "Add", Messagebox.OK, Messagebox.INFORMATION);
//		System.out.println("SavePath: "+CsvPath);
		
		
		Binder bind = parBinder;
		if (bind == null)
			return;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("selected",name);

		// this.parBinder.postCommand("change", params);
		bind.postCommand("refreshProjectList", params);
		mainView.detach();
	}
	
}
