package org.strasa.web.distributionandextension.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.strasa.middleware.manager.DistributionAndExtensionManagerImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

public class ExtGYCgrid {


	@SuppressWarnings("unused")
	private List<SummaryModel> areaSummaryGYC=new ArrayList<SummaryModel>();  //gce
	private SummaryFilter filter= new SummaryFilter();
	List<SummaryModel> currentModelGYC=  new ArrayList<SummaryModel>();
	static List<SummaryModel> allDataGYC=  new ArrayList<SummaryModel>();


	@Init
	public void setData(){
		DistributionAndExtensionManagerImpl mgr= new DistributionAndExtensionManagerImpl();
		this.areaSummaryGYC=mgr.getAreaSummaryGermplasmByYearandCountryExtension();
		allDataGYC=mgr.getAreaSummaryGermplasmByYearandCountryExtension();
		currentModelGYC=mgr.getAreaSummaryGermplasmByYearandCountryExtension();
	}

	public SummaryFilter getFilter() {
		return filter;
	}

	public void setFilter(SummaryFilter filter) {
		this.filter = filter;
	}

	public List<SummaryModel> getCurrentModelGCE() {
		return currentModelGYC;
	}

	public void setCurrentModelGYC(List<SummaryModel> currentModelGYC) {
		this.currentModelGYC = currentModelGYC;
	}

	public List<SummaryModel> getAreaSummaryGYC() {
		return new ListModelList<SummaryModel>(currentModelGYC);
	}

	public void setAreaSummaryGYC(
			List<SummaryModel> areaSummaryGYC) {
		this.areaSummaryGYC = areaSummaryGYC;
	}

	public static List<SummaryModel> getGYC(SummaryFilter filter){
		List<SummaryModel> someResult = new ArrayList<SummaryModel>();
		String programName = filter.getProgramName().toLowerCase();
		String yearExtension = filter.getYearExtention().toLowerCase();
		String countryExtension=filter.getCountryExtension().toLowerCase();
		String germplasmName=filter.getGermplasmName().toLowerCase();

		for (Iterator<SummaryModel> i = allDataGYC.iterator(); i.hasNext();) {
			SummaryModel tmp = i.next();
			if (tmp.getProgramName().toLowerCase().contains(programName) && 
					tmp.getCountryextension().toLowerCase().contains(countryExtension) && 
					tmp.getYearextension().toLowerCase().contains(yearExtension) && 
					tmp.getGermplasmname().toLowerCase().contains(germplasmName)) {
				someResult.add(tmp);
			}
		}
		return someResult;
	}	

	@Command
	@NotifyChange({"areaSummaryGYC"})
	public void changeFilter() {
		currentModelGYC = getGYC(filter);
	}

}
