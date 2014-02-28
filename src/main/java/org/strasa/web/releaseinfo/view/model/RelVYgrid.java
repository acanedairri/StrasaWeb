package org.strasa.web.releaseinfo.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.strasa.middleware.manager.DistributionAndExtensionManagerImpl;
import org.strasa.middleware.manager.ReleaseInfoManagerImpl;
import org.strasa.web.distributionandextension.view.model.SummaryFilter;
import org.strasa.web.releaseinfo.view.model.ReleaseInfoSummaryModel;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

public class RelVYgrid {


	@SuppressWarnings("unused")
	private List<ReleaseInfoSummaryModel> noVY=new ArrayList<ReleaseInfoSummaryModel>();  //vy
	private SummaryFilter filter= new SummaryFilter();
	List<ReleaseInfoSummaryModel> currentModelVY=  new ArrayList<ReleaseInfoSummaryModel>();
	static List<ReleaseInfoSummaryModel> allDataVY=  new ArrayList<ReleaseInfoSummaryModel>();


	@Init
	public void setData(){
		ReleaseInfoManagerImpl mgr= new ReleaseInfoManagerImpl();
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

	public List<ReleaseInfoSummaryModel> getCurrentModelVY() {
		return currentModelVY;
	}

	public void setCurrentModelVY(List<ReleaseInfoSummaryModel> currentModelVY) {
		this.currentModelVY = currentModelVY;
	}

	public List<ReleaseInfoSummaryModel> getNoVY() {
		return new ListModelList<ReleaseInfoSummaryModel>(currentModelVY);
	}

	public void setNoVY(
			List<ReleaseInfoSummaryModel> noVY) {
		this.noVY = noVY;
	}

	public static List<ReleaseInfoSummaryModel> getVY(SummaryFilter filter){
		List<ReleaseInfoSummaryModel> someResult = new ArrayList<ReleaseInfoSummaryModel>();
		String programName = filter.getProgramName().toLowerCase();
		String yearRelease = filter.getYearRelease().toLowerCase();

		for (Iterator<ReleaseInfoSummaryModel> i = allDataVY.iterator(); i.hasNext();) {
			ReleaseInfoSummaryModel tmp = i.next();
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
