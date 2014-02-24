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

public class RelVCgrid {


	@SuppressWarnings("unused")
	private List<SummaryModel> noVC=new ArrayList<SummaryModel>();  //vc
	private SummaryFilter filter= new SummaryFilter();
	List<SummaryModel> currentModelVC=  new ArrayList<SummaryModel>();
	static List<SummaryModel> allDataVC=  new ArrayList<SummaryModel>();


	@Init
	public void setData(){
		ReleaseInfoManagerImpl mgr= new ReleaseInfoManagerImpl();
		allDataVC=mgr.getNoOfVarietyReleaseByCountryRelease();
		currentModelVC=mgr.getNoOfVarietyReleaseByCountryRelease();
	}

	public SummaryFilter getFilter() {
		return filter;
	}

	public void setFilter(SummaryFilter filter) {
		this.filter = filter;
	}

	public List<SummaryModel> getCurrentModelVC() {
		return currentModelVC;
	}

	public void setCurrentModelVC(List<SummaryModel> currentModelVC) {
		this.currentModelVC = currentModelVC;
	}

	public List<SummaryModel> getNoVC() {
		return new ListModelList<SummaryModel>(currentModelVC);
	}

	public void setNoVC(
			List<SummaryModel> noVC) {
		this.noVC = noVC;
	}

	public static List<SummaryModel> getVC(SummaryFilter vc){
		List<SummaryModel> someResult = new ArrayList<SummaryModel>();
		String programName = vc.getProgramName().toLowerCase();
		String counrtyRelease=vc.getCounrtyRelease().toLowerCase();

		for (Iterator<SummaryModel> i = allDataVC.iterator(); i.hasNext();) {
			SummaryModel tmp = i.next();
			if (tmp.getProgramName().toLowerCase().contains(programName) && 
					tmp.getCountryrelease().toLowerCase().contains(counrtyRelease)) {
				someResult.add(tmp);
			}
		}
		return someResult;
	}	

	@Command
	@NotifyChange({"noVC"})
	public void changeFilter() {
		currentModelVC = getVC(filter);
	}

}
