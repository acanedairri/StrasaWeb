package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.CountryManagerImpl;
import org.strasa.middleware.manager.LocationManagerImpl;
import org.strasa.middleware.manager.StudyLocationManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.StudySite;
import org.strasa.web.common.api.FormValidator;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;

import com.mysql.jdbc.StringUtils;

public class StudyLocationInfo extends ProcessTabViewModel {

	private int studyId;
	private FormValidator formValidator = new FormValidator();
	private boolean isRaw = false;
	private boolean noLocation;
	private List<Location> lstUnknownLocations = new ArrayList<Location>();
	private List<Location> lstLocations = new ArrayList<Location>();
	private ArrayList<String> cmbCountry = new ArrayList<String>();

	private StudyLocationManagerImpl studyLocationManager;

	public ArrayList<String> getCmbCountry() {
		return cmbCountry;
	}

	public void setCmbCountry(ArrayList<String> cmbCountry) {
		this.cmbCountry = cmbCountry;
	}

	public List<Country> getCountryList() {
		return new CountryManagerImpl().getAllCountry();
	}

	private double sampleID;

	@GlobalCommand
	@NotifyChange("sampleID")
	public void testGlobalCom(@BindingParam("studyID") double newVal) {
		sampleID = newVal;
	}

	public List<Location> getLstUnknownLocations() {
		return lstUnknownLocations;
	}

	public void setLstUnknownLocations(List<Location> lstUnknownLocations) {
		this.lstUnknownLocations = lstUnknownLocations;
	}

	public List<Location> getLstLocations() {
		return lstLocations;
	}

	public void setLstLocations(List<Location> lstLocations) {
		this.lstLocations = lstLocations;
	}

	public boolean validateTab() {
		for (Location loc : lstLocations) {
			if (StringUtils.isNullOrEmpty(loc.getLocationname())) {
				Messagebox.show("Location must not be empty", "OK",
						Messagebox.OK, Messagebox.EXCLAMATION);
				return false;
			}
			if (loc.getId() == null) {
				if (StringUtils.isNullOrEmpty(loc.getAltitude())) {
					Messagebox.show("Altitude in " + loc.getLocationname() +" must not be empty", "OK",
							Messagebox.OK, Messagebox.EXCLAMATION);
					return false;
				}
				if (StringUtils.isNullOrEmpty(loc.getLatitude())) {
					Messagebox.show("Latitude in " + loc.getLocationname() +" must not be empty", "OK",
							Messagebox.OK, Messagebox.EXCLAMATION);
					return false;
				}
				if (StringUtils.isNullOrEmpty(loc.getWeatherstation())) {
					Messagebox.show("Weather Station in " + loc.getLocationname() +" must not be empty", "OK",
							Messagebox.OK, Messagebox.EXCLAMATION);
					return false;
				}
			
				
			}
		}

	
		studyLocationManager.updateStudyLocation(lstLocations, studyId);
		return true;
	}

	public FormValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(FormValidator formValidator) {
		this.formValidator = formValidator;
	}

	@Init
	public void init(@ExecutionArgParam("studyID") double studyID,
			@ExecutionArgParam("isRaw") boolean isRaw) {

		System.out
				.println("_______________________________________________________________");
		System.out.println("Staring debugging :"
				+ StudyLocationInfo.class.getName());
		System.out
				.println("_______________________________________________________________");
		System.out.println("Raw: " + isRaw);
		System.out.println("StudyID: " + studyID);

		this.isRaw = isRaw;
		studyId = (int) studyID;
		// public void init(){
		//
		// this.isRaw = true;
		// mockStudyId = 45;

		studyLocationManager = new StudyLocationManagerImpl(isRaw);
		List<Country> lCountries = getCountryList();
		for (Country data : lCountries) {
			cmbCountry.add(data.getIsoabbr());
		}
		StudyRawDataManagerImpl rawMan = new StudyRawDataManagerImpl(isRaw);
	

		List<List<Location>> locationInit = studyLocationManager
				.initializeStudyLocations(studyId);
		lstLocations.addAll(locationInit.get(0));
		lstUnknownLocations.addAll(locationInit.get(1));
		Map<String, ArrayList<String>> constructedRow = new HashMap<String, ArrayList<String>>();
		System.out.println("KnownLocationSize: " + lstLocations.size());
		System.out.println("UnknownLocationSize:" + lstUnknownLocations.size());

		HashMap<String, Location> lstRawLoc = rawMan
				.getStudyLocationInfoToMap(studyId);
		StudySiteManagerImpl siteMan = new StudySiteManagerImpl(isRaw);
		List<StudySite> lstStudySite = siteMan.getAllStudySites(studyId);
		for (int i = 0; i < lstUnknownLocations.size(); i++) {
			if (lstRawLoc.containsKey(lstUnknownLocations.get(i)
					.getLocationname())) {

				lstLocations.add(lstRawLoc.get(lstUnknownLocations.get(i)
						.getLocationname()));

			}
		}
		LocationManagerImpl locMan  = new LocationManagerImpl(); 
		for(StudySite site : lstStudySite){
			if(!lstRawLoc.containsKey(site.getSitelocation())){
				Location newLoc = new Location();
				newLoc.setLocationname(site.getSitelocation());

				if(locMan.getLocationByLocationName(newLoc.getLocationname()) != null)
					newLoc = locMan.getLocationByLocationName(site.getSitelocation());
				System.out.println("Added new Location from site");
				
				lstLocations.add(newLoc);
			}
		}
		
		

	}

	public double getSampleID() {
		return sampleID;
	}

	public void setSampleID(double sampleID) {
		this.sampleID = sampleID;
	}

	@Command("saveLocationInfo")
	public void saveLocationInfo() {
		// selectedSite=
		// studyLocationManager.updateStudyLocation(locations);

		Messagebox.show("Changes saved.");
	}
}