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

public class RelVCgrid {


	@SuppressWarnings("unused")
	private List<ReleaseInfoSummaryModel> noVC=new ArrayList<ReleaseInfoSummaryModel>();  //vc
	private SummaryFilter filter= new SummaryFilter();
	List<ReleaseInfoSummaryModel> currentModelVC=  new ArrayList<ReleaseInfoSummaryModel>();
	static List<ReleaseInfoSummaryModel> allDataVC=  new ArrayList<ReleaseInfoSummaryModel>();


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

	public List<ReleaseInfoSummaryModel> getCurrentModelVC() {
		return currentModelVC;
	}

	public void setCurrentModelVC(List<ReleaseInfoSummaryModel> currentModelVC) {
		this.currentModelVC = currentModelVC;
	}

	public List<ReleaseInfoSummaryModel> getNoVC() {
		return new ListModelList<ReleaseInfoSummaryModel>(currentModelVC);
	}

	public void setNoVC(
			List<ReleaseInfoSummaryModel> noVC) {
		this.noVC = noVC;
	}

	public static List<ReleaseInfoSummaryModel> getVC(SummaryFilter vc){
		List<ReleaseInfoSummaryModel> someResult = new ArrayList<ReleaseInfoSummaryModel>();
		String programName = vc.getProgramName().toLowerCase();
		String counrtyRelease=vc.getCounrtyRelease().toLowerCase();

		for (Iterator<ReleaseInfoSummaryModel> i = allDataVC.iterator(); i.hasNext();) {
			ReleaseInfoSummaryModel tmp = i.next();
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
