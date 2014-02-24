package org.strasa.web.releaseinfo.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.strasa.middleware.manager.ReleaseInfoManagerImpl;
import org.strasa.web.extensionanddistributiondata.view.model.SummaryFilter;
import org.strasa.web.extensionanddistributiondata.view.model.SummaryModel;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

public class RelVCYgrid {


	@SuppressWarnings("unused")
	private List<SummaryModel> noVCY=new ArrayList<SummaryModel>();  //gce
	private SummaryFilter filter= new SummaryFilter();
	List<SummaryModel> currentModelVCY=  new ArrayList<SummaryModel>();
	static List<SummaryModel> allDataVCY=  new ArrayList<SummaryModel>();


	@Init
	public void setData(){
		ReleaseInfoManagerImpl mgr= new ReleaseInfoManagerImpl();
//		this.areaSummaryVCY=mgr.getAreaSummaryGermplasmByYear();
		allDataVCY=mgr.getNoOfVarietyReleaseByCountryAndYear();
		currentModelVCY=mgr.getNoOfVarietyReleaseByCountryAndYear();
	}

	public SummaryFilter getFilter() {
		return filter;
	}

	public void setFilter(SummaryFilter filter) {
		this.filter = filter;
	}

	public List<SummaryModel> getCurrentModelVCY() {
		return currentModelVCY;
	}

	public void setCurrentModelVCY(List<SummaryModel> currentModelVCY) {
		this.currentModelVCY = currentModelVCY;
	}

	public List<SummaryModel> getNoVCY() {
		return new ListModelList<SummaryModel>(currentModelVCY);
	}

	public void setNoVCY(
			List<SummaryModel> noVCY) {
		this.noVCY = noVCY;
	}

	public static List<SummaryModel> getVCY(SummaryFilter vcy){
		List<SummaryModel> someResult = new ArrayList<SummaryModel>();
		String programName = vcy.getProgramName().toLowerCase();
		String yearRelease = vcy.getYearRelease().toLowerCase();
		String counrtyRelease=vcy.getCounrtyRelease().toLowerCase();

		for (Iterator<SummaryModel> i = allDataVCY.iterator(); i.hasNext();) {
			SummaryModel tmp = i.next();
			if (tmp.getProgramName().toLowerCase().contains(programName) && 
					tmp.getYearrelease().toLowerCase().contains(yearRelease) && 
					tmp.getCountryrelease().toLowerCase().contains(counrtyRelease)) {
				someResult.add(tmp);
			}
		}
		return someResult;
	}	

	@Command
	@NotifyChange({"noVCY"})
	public void changeFilter() {
		currentModelVCY = getVCY(filter);
	}

}
