package org.strasa.web.maintenance.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudyTypeManagerImpl;
import org.strasa.middleware.manager.UserManagerImpl;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyType;
import org.strasa.middleware.model.User;
import org.strasa.web.uploadstudy.view.model.AddProject;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Window;


public class EditProject {
	ProjectManagerImpl projectMan;

	List<Project> projectList;
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	@Init
	public void init(){
		Integer userId=1;

		projectMan = new ProjectManagerImpl();
		//		projectList = new ArrayList<Project>();

		projectList = projectMan.getProjectByUserId(userId);
	}
	//
	//	@NotifyChange("*")
	//	@Command("onChecked")
	//	public void addUser(@BindingParam("user") User user){
	//		UserManagerImpl userManagerImp =  new UserManagerImpl();
	//		userManagerImp.updateUser(user);
	//	public class 
	@Command("addProject")
	public void addProject(@BindingParam("target") Tabpanel panel) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar", null);
		params.put("programID",1); //yah better change this! Make Dynamic
		params.put("parent", panel);

		Window popup = (Window) Executions.createComponents(
				AddProject.ZUL_PATH, panel, params);

		popup.doModal();
	}
}