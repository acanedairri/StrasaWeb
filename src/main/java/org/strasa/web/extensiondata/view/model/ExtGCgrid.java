package org.strasa.web.extensiondata.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

public class ExtGCgrid {


	@SuppressWarnings("unused")
	private List<SummaryModel> areaSummaryGC=new ArrayList<SummaryModel>();  //gce
	private SummaryFilter filter= new SummaryFilter();
	List<SummaryModel> currentModelGCE=  new ArrayList<SummaryModel>();
	static List<SummaryModel> allDataGC=  new ArrayList<SummaryModel>();


	@Init
	public void setData(){
		ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
		this.areaSummaryGC=mgr.getAreaSummaryGermplasmByCountryExtension();
		allDataGC=mgr.getAreaSummaryGermplasmByCountryExtension();
		currentModelGCE=mgr.getAreaSummaryGermplasmByCountryExtension();
	}

	public SummaryFilter getFilter() {
		return filter;
	}

	public void setFilter(SummaryFilter filter) {
		this.filter = filter;
	}

	public List<SummaryModel> getCurrentModelGCE() {
		return currentModelGCE;
	}

	public void setCurrentModelGCE(List<SummaryModel> currentModelGCE) {
		this.currentModelGCE = currentModelGCE;
	}

	public List<SummaryModel> getAreaSummaryGC() {
		return new ListModelList<SummaryModel>(currentModelGCE);
	}

	public void setAreaSummaryGC(
			List<SummaryModel> areaSummaryGC) {
		this.areaSummaryGC = areaSummaryGC;
	}

	public static List<SummaryModel> getGCE(SummaryFilter filter){
		List<SummaryModel> someResult = new ArrayList<SummaryModel>();
		String programName = filter.getProgramName().toLowerCase();
		String countryExtension=filter.getCountryExtension().toLowerCase();
		String germplasmName=filter.getGermplasmName().toLowerCase();

		for (Iterator<SummaryModel> i = allDataGC.iterator(); i.hasNext();) {
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
	@NotifyChange({"areaSummaryGC"})
	public void changeFilter() {
		currentModelGCE = getGCE(filter);
	}

}
