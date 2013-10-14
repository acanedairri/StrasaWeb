package org.strasa.web.uploadstudy.view.model;

import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.model.Project;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class AddProject {

	private String name;
	private String objective;
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
	
	@Command("addProject")
	public void addProject(){
		System.out.println("Name: " + name + " Objective:" + objective);
		ProjectManagerImpl projectMan = new ProjectManagerImpl();
		Project newProject = new Project();
		newProject.setName(name);
		newProject.setObjective(objective);
		projectMan.addProject(newProject);
	
	}
	
	@NotifyChange("*")
	@Command("clear")
	public void clear(){
		name = "alex";
		objective = "";
	}
	
	
}
