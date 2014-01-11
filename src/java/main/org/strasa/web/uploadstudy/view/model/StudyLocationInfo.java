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


	private FormValidator formValidator = new FormValidator();
		private boolean noLocation;
	private List<Location> lstUnknownLocations = new ArrayList<Location>();
	private List<Location> lstLocations = new ArrayList<Location>();
	private ArrayList<String> cmbCountry = new ArrayList<String>();

	private StudyLocationManagerImpl studyLocationManager;

	public ArrayList<String> getCmbCountry() {
		return cmbCountry;
	}
	
	public String editable(int userid){
		System.out.println("functon called: " + this.userID);
		if(userid == this.userID) {
			System.out.println("functon called: " + userid + " returning true");
			
			return "false";
		}
		else return "true";
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

	
		studyLocationManager.updateStudyLocation(lstLocations, studyID);
		return true;
	}

	public FormValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(FormValidator formValidator) {
		this.formValidator = formValidator;
	}


	@Init
	public void init(@ExecutionArgParam("uploadModel") ProcessTabViewModel uploadModel) {

		this.initValues(uploadModel);
		System.out
				.println("_______________________________________________________________");
		System.out.println("Staring debugging :"
				+ StudyLocationInfo.class.getName());
		System.out
				.println("_______________________________________________________________");
		System.out.println("Raw: " + isRaw);
		System.out.println("StudyID: " + studyID);



		studyLocationManager = new StudyLocationManagerImpl(isRaw);
		List<Country> lCountries = getCountryList();
		for (Country data : lCountries) {
			cmbCountry.add(data.getIsoabbr());
		}
		
		lstLocations.addAll(studyLocationManager.getLocationsFromStudySite(studyID,this.dataset.getId()));
		

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