package org.strasa.web.extensiondata.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;

public class ExtensionDataBrowse {
	private ExtensionDataManagerImpl mgr;
	
	private List<String> stringy;
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
		this.stringy = new ArrayList<String>();
		this.stringy.add("1");
		this.stringy.add("2");
		this.stringy.add("3");
//		this.summaryByCountry=mgr.getCountOfGermplasmByCountrRealease();
//		this.summaryByYear=mgr.getCountOfGermplasmByYear();
//		this.extensionDataList=mgr.getExtensionDataList();
		
		mgr= new ExtensionDataManagerImpl();
		this.areaSummaryGermplasmByYearandCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		this.areaSummaryGermplasmByYear=mgr.getAreaSummaryGermplasmByYear();
		this.areaSummaryGermplasmByCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		this.noOfVarietyReleaseByCountryAndYear=mgr.getNoOfVarietyReleaseByCountryAndYear();
		this.noOfVarietyReleaseByCountryRelease=mgr.getNoOfVarietyReleaseByCountryRelease();
		this.noOfVarietyReleaseByYear=mgr.getNoOfVarietyReleaseByYear();
		
//		for(SummaryModel sm : noOfVarietyReleaseByYear){
//			System.out.println("next SM");
//			for(String s: sm.germplasmNames){
//				System.out.println(s);
//			}
//		}
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





	public List<String> getStringy() {
		return stringy;
	}

	public void setStringy(List<String> stringy) {
		this.stringy = stringy;
	}

////	@NotifyChange("*")
//	@Command
//	public void addListCellItems(@ContextParam(ContextType.COMPONENT) Component component,
//			@ContextParam(ContextType.VIEW) Component view,@BindingParam("function") String function,@BindingParam("count") Integer count,@BindingParam("cell") Listcell listcell){
//		if(function.equals("varietyByYear")){
//			Toolbarbutton tb = new Toolbarbutton();
//			tb.setLabel("");
//			listcell.appendChild(tb);
////			for(int i=0;i<count;i++){
////				Toolbarbutton toolbarButton =new Toolbarbutton();
////				toolbarButton.setParent(listcell);
////				toolbarButton.setLabel("toolbarbutton"+Integer.toString(i));
////			}
//		}
//	}
	
	@NotifyChange("*")
	@Command
	public void show(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view,@BindingParam("function") String function,@BindingParam("summaryModel") SummaryModel summaryModel){
		if(function.equals("varietyByYear")){
//			mgr.getVarietyNamesOfVarietyReleaseByYear(summaryModel);
			summaryModel.getGermplasmname();
			System.out.println("");
		}
	}
}
