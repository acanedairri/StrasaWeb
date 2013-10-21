package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.StudyLocationManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.StudyLocation;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudySite;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class DefineStudyLocation extends ProcessTabViewModel{
    
	private double sampleID;
	private StudyLocationManagerImpl studyLocationManager = new StudyLocationManagerImpl();
	private StudyRawDataManagerImpl studyRawDataManager = new StudyRawDataManagerImpl();
	
	private List<StudyLocation> locations = studyLocationManager.getAllStudyLocations(1);
	private List<StudyRawData> studyrawdata = studyRawDataManager.getAllStudyRawData();

	
	@GlobalCommand
	@NotifyChange("sampleID")
	public void testGlobalCom(@BindingParam("studyID")double newVal){
		sampleID = newVal;
	}


	public boolean validateTab() {
	// TODO Auto-generated method stub
	return false;
	}

	@Init
	public void init(@ExecutionArgParam("studyID") double studyID) {
	sampleID = studyID;	
	}
	
	
	public double getSampleID() {
		return sampleID;
	}
	public void setSampleID(double sampleID) {
		this.sampleID = sampleID;
	}

	public List<StudyRawData> geStudyRawDatas() {
		return studyrawdata;
	}
	public void setStudyRawData(List<StudyRawData> studyrawdata) {
		this.studyrawdata = studyrawdata;
	}
	public List<StudyLocation> getLocations() {
		return locations;
	}
	public void setlocations(List<StudyLocation> locations) {
		this.locations = locations;
	}
}