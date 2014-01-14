package org.strasa.web.uploadstudy.view.model;

import java.util.HashMap;
import java.util.Map;

import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.model.Project;
import org.strasa.web.common.api.FormValidator;
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
		private Component mainView;
	private Binder parBinder;
	private FormValidator formValidator;
	private Project projectModel = new Project();
	public int programID;
	private Integer userID = 1;

	public Project getProjectModel() {
		return projectModel;
	}

	public void setProjectModel(Project projectModel) {
		this.projectModel = projectModel;
	}

	public FormValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(FormValidator formValidator) {
		this.formValidator = formValidator;
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
	public void Init(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view ,@ExecutionArgParam("oldVar")  String oldVar, @ExecutionArgParam("programID") int pID ) {

	        mainView = view;
	        parBinder = (Binder) view.getParent().getAttribute("binder");
	        programID = pID;
	}
	
//	@Init
//	public void Init(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view ,@ExecutionArgParam("oldVar")  String oldVar, @ExecutionArgParam("programID") int pID ) {
//
//	        mainView = view;
//	        parBinder = ctx.getBinder();
//	        programID = pID;
//	}
	
	@Command("add")
	public void add(){
		
		ProjectManagerImpl projectMan = new ProjectManagerImpl();
		if(projectMan.isProjectExist(projectModel.getName(), userID,programID)){
			Messagebox.show("Project name already exist! Choose a different name.", "Validation Error", Messagebox.OK, Messagebox.EXCLAMATION);
			return;
		}
		
		
		try {
			if(!formValidator.getBlankVariables(projectModel,new String[]{"id","userid","programid"}).isEmpty()){
				Messagebox.show("All fields are requied.", "Validation Error", Messagebox.OK, Messagebox.EXCLAMATION);
				return;
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO IMPORTANT!!! Must change this to real UserID
		projectModel.setUserid(userID );
		projectModel.setProgramid(programID);
		projectMan.addProject(projectModel);
		
		
		//TODO Validate!!
		Messagebox.show("Program successfully added to database!", "Add", Messagebox.OK, Messagebox.INFORMATION);
//		System.out.println("SavePath: "+CsvPath);
		
		
		Binder bind = parBinder;
		if (bind == null)
			return;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("selected",projectModel);

		// this.parBinder.postCommand("change", params);
		bind.postCommand("changeProjectList", params);
		mainView.detach();
	}
	@Command
	public void cancel(){
		mainView.detach();
	}
	
}
