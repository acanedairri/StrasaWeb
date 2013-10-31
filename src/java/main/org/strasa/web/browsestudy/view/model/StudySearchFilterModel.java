package org.strasa.web.browsestudy.view.model;

public class StudySearchFilterModel {

	String shared;
	int programid;
	int projectid;
	String studyname;
	int studytypeid;
	String startyear;
	String endyear;
	String country;
	String location;
	
	
	
	
	
	public StudySearchFilterModel() {
		this.shared =null;
		this.programid = 0;
		this.projectid = 0;
		this.studyname = null;
		this.studytypeid = 0;
		this.startyear = null;
		this.endyear = null;
		this.country = null;
		this.location = null;
	}
	public String getShared() {
		return shared;
	}
	public void setShared(String shared) {
		this.shared = shared;
	}
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
	public String getStudyname() {
		return studyname;
	}
	public void setStudyname(String studyname) {
		this.studyname = studyname;
	}
	public int getStudytypeid() {
		return studytypeid;
	}
	public void setStudytypeid(int studytypeid) {
		this.studytypeid = studytypeid;
	}
	public String getStartyear() {
		return startyear;
	}
	public void setStartyear(String startyear) {
		this.startyear = startyear;
	}
	public String getEndyear() {
		return endyear;
	}
	public void setEndyear(String endyear) {
		this.endyear = endyear;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
