package org.strasa.web.extensiondata.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

public class ExtensionDataBrowse2 {

	
	private List<SummaryModel> areaSummaryGermplasmByYearandCountryExtension; //gyce
	private List<SummaryModel> areaSummaryGermplasmByYear;  //gy
	private static List<SummaryModel> areaSummaryGermplasmByCountryExtension;  //gce
	private List<SummaryModel> noOfVarietyReleaseByCountryAndYear; //vrcy;
	private List<SummaryModel> noOfVarietyReleaseByCountryRelease; // vrc
	private List<SummaryModel> noOfVarietyReleaseByYear; // vry
	private GermplasmCountryExtensionFilter gceFilter= new GermplasmCountryExtensionFilter();
	
	List<SummaryModel> currentModelGCE=  new ArrayList<SummaryModel>();
	static List<SummaryModel> allDataGCE=  new ArrayList<SummaryModel>();
	
	
	
	@Init
	public void setData(){
		ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
		
		this.areaSummaryGermplasmByYearandCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		this.areaSummaryGermplasmByYear=mgr.getAreaSummaryGermplasmByYear();
		this.areaSummaryGermplasmByCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		this.noOfVarietyReleaseByCountryAndYear=mgr.getNoOfVarietyReleaseByCountryAndYear();
		this.noOfVarietyReleaseByCountryRelease=mgr.getNoOfVarietyReleaseByCountryRelease();
		this.noOfVarietyReleaseByYear=mgr.getNoOfVarietyReleaseByYear();
		
		
		allDataGCE=mgr.getAreaSummaryGermplasmByCountryExtension();
		currentModelGCE=mgr.getAreaSummaryGermplasmByCountryExtension();
	}
	

	
	

	public GermplasmCountryExtensionFilter getGceFilter() {
		return gceFilter;
	}


	public void setGceFilter(GermplasmCountryExtensionFilter gceFilter) {
		this.gceFilter = gceFilter;
	}

	public List<SummaryModel> getCurrentModelGCE() {
		return currentModelGCE;
	}


	public void setCurrentModelGCE(List<SummaryModel> currentModelGCE) {
		this.currentModelGCE = currentModelGCE;
	}





	public List<SummaryModel> getAreaSummaryGermplasmByYearandCountryExtension() {
		return areaSummaryGermplasmByYearandCountryExtension;
	}





	public void setAreaSummaryGermplasmByYearandCountryExtension(
			List<SummaryModel> areaSummaryGermplasmByYearandCountryExtension) {
		this.areaSummaryGermplasmByYearandCountryExtension = areaSummaryGermplasmByYearandCountryExtension;
	}





	public List<SummaryModel> getAreaSummaryGermplasmByYear() {
		return areaSummaryGermplasmByYear;
	}





	public void setAreaSummaryGermplasmByYear(
			List<SummaryModel> areaSummaryGermplasmByYear) {
		this.areaSummaryGermplasmByYear = areaSummaryGermplasmByYear;
	}





	public List<SummaryModel> getAreaSummaryGermplasmByCountryExtension() {
		return new ListModelList<SummaryModel>(currentModelGCE);
	}





	public void setAreaSummaryGermplasmByCountryExtension(
			List<SummaryModel> areaSummaryGermplasmByCountryExtension) {
		this.areaSummaryGermplasmByCountryExtension = areaSummaryGermplasmByCountryExtension;
	}





	public List<SummaryModel> getNoOfVarietyReleaseByCountryAndYear() {
		return noOfVarietyReleaseByCountryAndYear;
	}





	public void setNoOfVarietyReleaseByCountryAndYear(
			List<SummaryModel> noOfVarietyReleaseByCountryAndYear) {
		this.noOfVarietyReleaseByCountryAndYear = noOfVarietyReleaseByCountryAndYear;
	}





	public List<SummaryModel> getNoOfVarietyReleaseByCountryRelease() {
		return noOfVarietyReleaseByCountryRelease;
	}





	public void setNoOfVarietyReleaseByCountryRelease(
			List<SummaryModel> noOfVarietyReleaseByCountryRelease) {
		this.noOfVarietyReleaseByCountryRelease = noOfVarietyReleaseByCountryRelease;
	}





	public List<SummaryModel> getNoOfVarietyReleaseByYear() {
		return noOfVarietyReleaseByYear;
	}





	public void setNoOfVarietyReleaseByYear(
			List<SummaryModel> noOfVarietyReleaseByYear) {
		this.noOfVarietyReleaseByYear = noOfVarietyReleaseByYear;
	}




public static List<SummaryModel> getGCE(GermplasmCountryExtensionFilter gce){
		
		
		List<SummaryModel> someResult = new ArrayList<SummaryModel>();
		String programName = gce.getProgramName().toLowerCase();
		String countryExtension=gce.getCountryExtension().toLowerCase();
		String germplasmName=gce.getGermplasmName().toLowerCase();
		
		for (Iterator<SummaryModel> i = allDataGCE.iterator(); i.hasNext();) {
			SummaryModel tmp = i.next();
			if (tmp.getProgramName().toLowerCase().contains(programName) && 
					tmp.getCountryextension().toLowerCase().contains(countryExtension) && 
					tmp.getGermplasmname().toLowerCase().contains(germplasmName)) {
				someResult.add(tmp);
			}
		}
		return someResult;
	}	


@Command
@NotifyChange({"areaSummaryGermplasmByCountryExtension"})
public void changeFilter() {
	currentModelGCE = getGCE(gceFilter);
}




}
