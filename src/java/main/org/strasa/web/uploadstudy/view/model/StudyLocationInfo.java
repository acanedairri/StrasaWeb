package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.CountryManagerImpl;
import org.strasa.middleware.manager.StudyLocationManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.Location;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;

public class StudyLocationInfo extends ProcessTabViewModel{
    
	private StudyLocationManagerImpl studyLocationManager = new StudyLocationManagerImpl();
	private int mockStudyId = 22;
	private List<Location> lstUnknownLocations = new ArrayList<Location>();
	private List<Location> lstKnowLocations = new ArrayList<Location>();
	private List<String> lstCountry = new ArrayList<String>();
	
	public List<String> getLstCountry() {
		return lstCountry;
	}


	public void setLstCountry(List<String> lstCountry) {
		this.lstCountry = lstCountry;
	}


	public List<Country> getCountryList(){
		return new CountryManagerImpl().getAllCountry();
	}

	private double sampleID;
	@GlobalCommand
	@NotifyChange("sampleID")
	public void testGlobalCom(@BindingParam("studyID")double newVal){
		sampleID = newVal;
	}


	public List<Location> getLstUnknownLocations() {
		return lstUnknownLocations;
	}


	public void setLstUnknownLocations(List<Location> lstUnknownLocations) {
		this.lstUnknownLocations = lstUnknownLocations;
	}


	public List<Location> getLstKnowLocations() {
		return lstKnowLocations;
	}


	public void setLstKnowLocations(List<Location> lstKnowLocations) {
		this.lstKnowLocations = lstKnowLocations;
	}


	public boolean validateTab() {
	// TODO Auto-generated method stub
	return false;
	}

//	@Init
//	public void init(@ExecutionArgParam("studyID") double studyID) {
//	sampleID = studyID;	
//	
//	
//	}
	
	@Init
	public void init(){
		List<List<Location>> locationInit = studyLocationManager.initializeStudyLocations(mockStudyId);
		lstKnowLocations.addAll(locationInit.get(0));
		lstUnknownLocations.addAll(locationInit.get(1));
		Map<String,ArrayList<String>> constructedRow = new HashMap<String,ArrayList<String>>();
		ArrayList<ArrayList<String>> lstPreCons = new StudyRawDataManagerImpl().constructDataRaw(mockStudyId, new String[]{"Location","Country"}, "Location", true);
		for(ArrayList<String> lstSubCons : lstPreCons){
			constructedRow.put(lstSubCons.get(0), lstSubCons);
		}
		for(int i = 0 ; i < lstUnknownLocations.size(); i++){
			lstUnknownLocations.get(i).setLocationname(constructedRow.get(lstUnknownLocations.get(i).getLocationname()).get(0));
			lstUnknownLocations.get(i).setCountry("India");
			System.out.println(constructedRow.get(lstUnknownLocations.get(i).getLocationname()).get(1) + " COUNTRY");
		}
		List<Country> lCountries = getCountryList();
		for(Country data : lCountries){
			lstCountry.add(data.getIsoabbr());
		}
		System.out.println(lstUnknownLocations.get(0).getId());
		lstKnowLocations.addAll(lstUnknownLocations);
	}
	
	
	public double getSampleID() {
		return sampleID;
	}
	public void setSampleID(double sampleID) {
		this.sampleID = sampleID;
	}
	
	
	@Command("saveLocationInfo")
	public void saveLocationInfo(){
//		selectedSite=
//		studyLocationManager.updateStudyLocation(locations);
		
		Messagebox.show("Changes saved.");
	}
}