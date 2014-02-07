package org.strasa.web.extensiondata.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

public class GCEgrid {


	@SuppressWarnings("unused")
	private List<SummaryModel> areaSummaryGermplasmByCountryExtension=new ArrayList<SummaryModel>();  //gce
	private GCEFilter gceFilter= new GCEFilter();
	List<SummaryModel> currentModelGCE=  new ArrayList<SummaryModel>();
	static List<SummaryModel> allDataGCE=  new ArrayList<SummaryModel>();


	@Init
	public void setData(){
		ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
		this.areaSummaryGermplasmByCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		allDataGCE=mgr.getAreaSummaryGermplasmByCountryExtension();
		currentModelGCE=mgr.getAreaSummaryGermplasmByCountryExtension();
	}

	public GCEFilter getGceFilter() {
		return gceFilter;
	}

	public void setGceFilter(GCEFilter gceFilter) {
		this.gceFilter = gceFilter;
	}

	public List<SummaryModel> getCurrentModelGCE() {
		return currentModelGCE;
	}

	public void setCurrentModelGCE(List<SummaryModel> currentModelGCE) {
		this.currentModelGCE = currentModelGCE;
	}

	public List<SummaryModel> getAreaSummaryGermplasmByCountryExtension() {
		return new ListModelList<SummaryModel>(currentModelGCE);
	}

	public void setAreaSummaryGermplasmByCountryExtension(
			List<SummaryModel> areaSummaryGermplasmByCountryExtension) {
		this.areaSummaryGermplasmByCountryExtension = areaSummaryGermplasmByCountryExtension;
	}

	public static List<SummaryModel> getGCE(GCEFilter gce){
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
