package org.strasa.web.extensiondata.view.model;

import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.zkoss.bind.annotation.Init;

public class ExtensionDataBrowse {


	private List<ExtensionDataSummaryModel> summaryByCountry;
	private List<ExtensionDataSummaryModel> summaryByYear;
	private List<ExtensionDataListModel> extensionDataList;
	private List<SummaryModel> summaryArea;
	
	private List<SummaryModel> areaSummaryGermplasmByYearandCountryExtension;
	private List<SummaryModel> areaSummaryGermplasmByYear;
	private List<SummaryModel> areaSummaryGermplasmByCountryExtension;
	private List<SummaryModel> noOfVarietyReleaseByCountryAndYear;
	private List<SummaryModel> noOfVarietyReleaseByCountryRelease;
	private List<SummaryModel> noOfVarietyReleaseByYear;
	
	
	
	@Init
	public void setData(){
		ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
		this.summaryByCountry=mgr.getCountOfGermplasmByCountrRealease();
		this.summaryByYear=mgr.getCountOfGermplasmByYear();
		this.extensionDataList=mgr.getExtensionDataList();
		
		this.areaSummaryGermplasmByYearandCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		this.areaSummaryGermplasmByYear=mgr.getAreaSummaryGermplasmByYear();
		this.areaSummaryGermplasmByCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		this.noOfVarietyReleaseByCountryAndYear=mgr.getNoOfVarietyReleaseByCountryAndYear();
		this.noOfVarietyReleaseByCountryRelease=mgr.getNoOfVarietyReleaseByCountryRelease();
		this.noOfVarietyReleaseByYear=mgr.getNoOfVarietyReleaseByYear();
				
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
		return areaSummaryGermplasmByCountryExtension;
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





	public List<SummaryModel> getSummaryArea() {
		return summaryArea;
	}



	public void setSummaryArea(List<SummaryModel> summaryArea) {
		this.summaryArea = summaryArea;
	}



	public List<ExtensionDataSummaryModel> getSummaryByCountry() {
		return summaryByCountry;
	}
	public void setSummaryByCountry(List<ExtensionDataSummaryModel> summaryByCountry) {
		this.summaryByCountry = summaryByCountry;
	}
	public List<ExtensionDataSummaryModel> getSummaryByYear() {
		return summaryByYear;
	}
	public void setSummaryByYear(List<ExtensionDataSummaryModel> summaryByYear) {
		this.summaryByYear = summaryByYear;
	}



	public List<ExtensionDataListModel> getExtensionDataList() {
		return extensionDataList;
	}



	public void setExtensionDataList(List<ExtensionDataListModel> extensionDataList) {
		this.extensionDataList = extensionDataList;
	}

	









}
