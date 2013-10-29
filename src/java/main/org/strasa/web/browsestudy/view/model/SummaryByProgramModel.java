package org.strasa.web.browsestudy.view.model;

public class SummaryByProgramModel {

	int programid;
	int projectid;
	String programName;
	int projectCount;
	int studyCount;
	int countStudyTypePBT;
	int countStudyTypeOnFarm;
	int countStudyTypeExprimentStation;
	int countStudyTypeGlasshouse;
	int countStudyTypeLab;
	
	
	public int getProgramid() {
		return programid;
	}
	public void setProgramid(int programid) {
		this.programid = programid;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public int getProjectCount() {
		return projectCount;
	}
	public void setProjectCount(int projectCount) {
		this.projectCount = projectCount;
	}
	public int getStudyCount() {
		return studyCount;
	}
	public void setStudyCount(int studyCount) {
		this.studyCount = studyCount;
	}

	
	

}
