package org.strasa.web.uploadstudy.view.model;

import java.util.List;

import org.strasa.middleware.manager.StudyLocationManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.model.StudyLocation;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;

public class DefineStudyLocation extends ProcessTabViewModel{
    
	private StudyLocationManagerImpl studyLocationManager = new StudyLocationManagerImpl();
	
	private List<StudyLocation> locations = studyLocationManager.initializeStudyLocations(1);

	private double sampleID;
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
	public List<StudyLocation> getLocations() {
		return locations;
	}
	public void setlocations(List<StudyLocation> locations) {
		this.locations = locations;
	}
	
	@Command("saveLocationInfo")
	public void saveLocationInfo(){
//		selectedSite=
		studyLocationManager.updateStudyLocation(locations);
		
		Messagebox.show("Changes saved.");
	}
}