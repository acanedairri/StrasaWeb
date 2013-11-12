package org.strasa.web.uploadstudy.view.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.CountryManagerImpl;
import org.strasa.middleware.manager.StudyLocationManagerImpl;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.Location;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;

public class StudyLocationInfo extends ProcessTabViewModel{
    
	private int studyId = 25;
	private boolean isRaw = false;
	private List<Location> lstUnknownLocations = new ArrayList<Location>();
	private List<Location> lstLocations = new ArrayList<Location>();
	private List<String> lstCountry = new ArrayList<String>();

	private StudyLocationManagerImpl studyLocationManager;
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
		return lstLocations;
	}


	public void setLstKnowLocations(List<Location> lstKnowLocations) {
		this.lstLocations = lstKnowLocations;
	}


	public boolean validateTab() {
		for(Location loc:lstLocations){
			if(loc.getLocationname().isEmpty()){
				Messagebox.show("Location must not be empty", "OK", Messagebox.OK, Messagebox.EXCLAMATION);
				return false;
			}
		}
		studyLocationManager.updateStudyLocation(lstLocations,studyId);
		return true;
	}

	@Init
	public void init(@ExecutionArgParam("studyID") double studyID,@ExecutionArgParam("isRaw") boolean isRaw) {
		
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("_______________________________________________________________");
		System.out.println("Staring debugging :" + StudyLocationInfo.class.getName());
		System.out.println("_______________________________________________________________");
		System.out.println("Raw: " + isRaw);
		System.out.println("StudyID: " + studyID);
		this.isRaw = isRaw;
		studyId = (int) studyID;
//	public void init(){
//		
//		this.isRaw = true;
//		mockStudyId = 45;
		
		 studyLocationManager = new StudyLocationManagerImpl(isRaw);
		List<List<Location>> locationInit = studyLocationManager.initializeStudyLocations(studyId);
		lstLocations.addAll(locationInit.get(0));
		lstUnknownLocations.addAll(locationInit.get(1));
		Map<String,ArrayList<String>> constructedRow = new HashMap<String,ArrayList<String>>();
		System.out.println("KnownLocationSize: " + lstLocations.size());
		System.out.println("UnknownLocationSize:" + lstUnknownLocations.size());
		
		for(int i = 0 ; i < lstUnknownLocations.size(); i++){
			if(constructedRow.containsKey(lstUnknownLocations.get(i).getLocationname())){
			lstUnknownLocations.get(i).setLocationname(constructedRow.get(lstUnknownLocations.get(i).getLocationname()).get(0));
			lstUnknownLocations.get(i).setCountry(constructedRow.get(lstUnknownLocations.get(i).getLocationname()).get(1));
			System.out.println(constructedRow.get(lstUnknownLocations.get(i).getLocationname()).get(1) + " COUNTRY");
			}
		}
		List<Country> lCountries = getCountryList();
		for(Country data : lCountries){
			lstCountry.add(data.getIsoabbr());
		}
		lstLocations.addAll(lstUnknownLocations);
		if(lstLocations.isEmpty()){
			lstLocations.add(new Location());
		}
		
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