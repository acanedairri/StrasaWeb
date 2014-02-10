package org.strasa.web.extensiondata.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

public class RelVYgrid {


	@SuppressWarnings("unused")
	private List<SummaryModel> noVY=new ArrayList<SummaryModel>();  //vy
	private SummaryFilter filter= new SummaryFilter();
	List<SummaryModel> currentModelVY=  new ArrayList<SummaryModel>();
	static List<SummaryModel> allDataVY=  new ArrayList<SummaryModel>();


	@Init
	public void setData(){
		ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
//		this.areaSummaryVY=mgr.getAreaSummaryGermplasmByYear();
		allDataVY=mgr.getNoOfVarietyReleaseByYear();
		currentModelVY=mgr.getNoOfVarietyReleaseByYear();
	}

	public SummaryFilter getFilter() {
		return filter;
	}

	public void setFilter(SummaryFilter filter) {
		this.filter = filter;
	}

	public List<SummaryModel> getCurrentModelVY() {
		return currentModelVY;
	}

	public void setCurrentModelVY(List<SummaryModel> currentModelVY) {
		this.currentModelVY = currentModelVY;
	}

	public List<SummaryModel> getNoVY() {
		return new ListModelList<SummaryModel>(currentModelVY);
	}

	public void setNoVY(
			List<SummaryModel> noVY) {
		this.noVY = noVY;
	}

	public static List<SummaryModel> getVY(SummaryFilter filter){
		List<SummaryModel> someResult = new ArrayList<SummaryModel>();
		String programName = filter.getProgramName().toLowerCase();
		String yearRelease = filter.getYearRelease().toLowerCase();

		for (Iterator<SummaryModel> i = allDataVY.iterator(); i.hasNext();) {
			SummaryModel tmp = i.next();
			if (tmp.getProgramName().toLowerCase().contains(programName) && 
					tmp.getYearrelease().toLowerCase().contains(yearRelease)) {
				someResult.add(tmp);
			}
		}
		return someResult;
	}	

	@Command
	@NotifyChange({"noVY"})
	public void changeFilter() {
		currentModelVY = getVY(filter);
	}

}
