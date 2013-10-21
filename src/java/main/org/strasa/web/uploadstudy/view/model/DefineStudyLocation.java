package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.StudyLocationManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.StudyLocation;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudySite;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class DefineStudyLocation {
     
	private StudyLocationManagerImpl studyLocationManager = new StudyLocationManagerImpl();
	private StudyRawDataManagerImpl studyRawDataManager = new StudyRawDataManagerImpl();
	
	private List<StudyLocation> locations = studyLocationManager.getAllStudyLocations(1);
	private List<StudyRawData> studyrawdata = studyRawDataManager.getAllStudyRawData();
    

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