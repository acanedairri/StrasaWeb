package org.strasa.web.extensiondata.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

public class ExtGYgrid {


	@SuppressWarnings("unused")
	private List<SummaryModel> areaSummaryGY=new ArrayList<SummaryModel>();  //gce
	private SummaryFilter filter= new SummaryFilter();
	List<SummaryModel> currentModelGY=  new ArrayList<SummaryModel>();
	static List<SummaryModel> allDataGY=  new ArrayList<SummaryModel>();


	@Init
	public void setData(){
		ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
//		this.areaSummaryGY=mgr.getAreaSummaryGermplasmByYear();
		allDataGY=mgr.getAreaSummaryGermplasmByYear();
		currentModelGY=mgr.getAreaSummaryGermplasmByYear();
	}

	public SummaryFilter getFilter() {
		return filter;
	}

	public void setFilter(SummaryFilter filter) {
		this.filter = filter;
	}

	public List<SummaryModel> getCurrentModelGY() {
		return currentModelGY;
	}

	public void setCurrentModelGY(List<SummaryModel> currentModelGY) {
		this.currentModelGY = currentModelGY;
	}

	public List<SummaryModel> getAreaSummaryGY() {
		return new ListModelList<SummaryModel>(currentModelGY);
	}

	public void setAreaSummaryGY(
			List<SummaryModel> areaSummaryGY) {
		this.areaSummaryGY = areaSummaryGY;
	}

	public static List<SummaryModel> getGY(SummaryFilter gce){
		List<SummaryModel> someResult = new ArrayList<SummaryModel>();
		String programName = gce.getProgramName().toLowerCase();
		String yearExtension = gce.getYearExtention().toLowerCase();
		String germplasmName=gce.getGermplasmName().toLowerCase();

		for (Iterator<SummaryModel> i = allDataGY.iterator(); i.hasNext();) {
			SummaryModel tmp = i.next();
			if (tmp.getProgramName().toLowerCase().contains(programName) && 
					tmp.getYearextension().toLowerCase().contains(yearExtension) && 
					tmp.getGermplasmname().toLowerCase().contains(germplasmName)) {
				someResult.add(tmp);
			}
		}
		return someResult;
	}	

	@Command
	@NotifyChange({"areaSummaryGY"})
	public void changeFilter() {
		currentModelGY = getGY(filter);
	}

}
