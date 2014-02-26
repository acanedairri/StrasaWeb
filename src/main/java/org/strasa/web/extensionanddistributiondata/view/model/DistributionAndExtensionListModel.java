package org.strasa.web.extensionanddistributiondata.view.model;

import org.strasa.middleware.model.ExtensionData;

public class DistributionAndExtensionListModel extends ExtensionData {
	
	String programName;
	String projectName;
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
