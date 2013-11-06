package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.PlantingTypeManagerImpl;
import org.strasa.middleware.manager.StudyAgronomyManagerImpl;
import org.strasa.middleware.manager.StudyDesignManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.PlantingType;
import org.strasa.middleware.model.StudyAgronomy;
import org.strasa.middleware.model.StudyDesign;
import org.strasa.middleware.model.StudySite;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;

public class StudySiteInfo extends ProcessTabViewModel {
	private StudySiteManagerImpl studySiteMan;
	private StudyAgronomyManagerImpl studyAgroMan;
	private StudyDesignManagerImpl studyDesignMan;
	private EcotypeManagerImpl ecotypeMan;
	private PlantingTypeManagerImpl plantingtypeMan;

	private List<StudySiteInfoModel> sites;
	private List<StudyAgronomy> agroInfo;
	private List<StudyDesign> designInfo;
	private List<Ecotype> ecotypes;
	private List<PlantingType> plantingtypes;

	private StudySite selectedSite;
	private StudyAgronomy selectedAgroInfo = new StudyAgronomy();;
	private StudyDesign selectedDesignInfo = new StudyDesign();; 
	private PlantingType selectedSitePlantingType; // .getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());

	private double sampleID;
	protected boolean goToNextPage = true;

	public List<PlantingType> getPlantingtypes() {

		return plantingtypes;
	}

	public void setPlantingtypes(List<PlantingType> plantingtypes) {
		this.plantingtypes = plantingtypes;
	}

	public PlantingType getSelectedSitePlantingType() {
		return selectedSitePlantingType;
	}

	public void setSelectedSitePlantingType(
			PlantingType selectedSitePlantingType) {
		this.selectedSitePlantingType = selectedSitePlantingType;
	}

	public StudyAgronomy getSelectedAgroInfo() {
		return selectedAgroInfo;
	}

	public void setSelectedAgroInfo(StudyAgronomy selectedAgroInfo) {
		this.selectedAgroInfo = selectedAgroInfo;
	}

	public StudyDesign getSelectedDesignInfo() {
		return selectedDesignInfo;
	}

	public void setSelectedDesignInfo(StudyDesign selectedDesignInfo) {
		this.selectedDesignInfo = selectedDesignInfo;
	}

	public List<StudyAgronomy> getAgroInfo() {
		return agroInfo;
	}

	public void setAgroInfo(List<StudyAgronomy> agroInfo) {
		this.agroInfo = agroInfo;
	}

	public List<StudyDesign> getDesignInfo() {
		return designInfo;
	}

	public void setDesignInfo(List<StudyDesign> designInfo) {
		this.designInfo = designInfo;
	}

	public double getSampleID() {
		return sampleID;
	}

	public void setSampleID(double sampleID) {
		this.sampleID = sampleID;
	}

	public List<Ecotype> getEcotypes() {
		return ecotypes;
	}

	public void setEcotypes(List<Ecotype> ecotypes) {
		this.ecotypes = ecotypes;
	}

	public List<StudySiteInfoModel> getSites() {
		return sites;
	}

	public void setSites(List<StudySiteInfoModel> sites) {
		this.sites = sites;
	}

	private StudyDesign getDesignInfoBySiteID(Integer id) {
		// TODO Auto-generated method stub
		for (StudyDesign d : designInfo) {
			if (d.getStudysiteid() == id) {
				System.out.println("Selected Design info id: "
						+ d.getStudysiteid());
				return d;
			}
		}
		return null;
	}

	private StudyAgronomy getAgroInfoBySiteID(Integer id) {
		// TODO Auto-generated method stub
		for (StudyAgronomy a : agroInfo) {
			if (a.getStudysiteid() == id) {
				System.out.println("Selected Agronomy info id: "
						+ a.getStudysiteid());
				return a;
			}
		}
		return null;
	}

	@GlobalCommand
	@NotifyChange("sampleID")
	public void testGlobalCom(@BindingParam("studyID") double newVal) {
		sampleID = newVal;
	}

	@NotifyChange("*")
	@Command("updateDesignInfo")
	public void updateDesignInfo(@BindingParam("id") Integer id) {
		setSelectedAgroInfo(getAgroInfoBySiteID(id));
		setSelectedDesignInfo(getDesignInfoBySiteID(id));
//		selectedSitePlantingType = plantingtypes.get(selectedAgroInfo
//				.getPlantingtypeid() - 1); // .getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());
//		System.out.println("selected row id: " + Integer.toString(id));

	}

	@Command("updateSelectedSitePlantingType")
	public void updateSelectedSitePlantingType() {
		selectedAgroInfo.setPlantingtypeid(selectedSitePlantingType.getId());
	}

	@Command("saveSiteAgroDesignInfo")
	public void saveSiteAgroDesignInfo() {
//		studySiteMan.updateStudySite(sites);
		studyAgroMan.updateStudyAgronomy(agroInfo);
		studyDesignMan.updateStudyDesign(designInfo);

		Messagebox.show("Changes saved.");
	}

	@Override
	public boolean validateTab() {

		return goToNextPage;
	}

	@Init
	public void init() {
		sampleID = 22;
		
		studySiteMan = new StudySiteManagerImpl();
		studyAgroMan = new StudyAgronomyManagerImpl();
		studyDesignMan = new StudyDesignManagerImpl();
		ecotypeMan = new EcotypeManagerImpl();
		plantingtypeMan = new PlantingTypeManagerImpl();

		List<StudySite> subsites = studySiteMan.initializeStudySites(22);
		for(StudySite siteD : subsites){
			
			StudySiteInfoModel siteInfo = (StudySiteInfoModel) siteD;
//			siteInfo.selectedAgroInfo = studyAgr
			sites.add((StudySiteInfoModel) siteD);
			
		}
	
		ecotypes = ecotypeMan.getAllEcotypes();
		plantingtypes = plantingtypeMan.getAllPlantingTypes();

		selectedSite = sites.get(0);
		selectedAgroInfo = getAgroInfoBySiteID(selectedSite.getId());
		selectedDesignInfo = getDesignInfoBySiteID(selectedSite.getId());
		if(selectedAgroInfo != null) selectedSitePlantingType = plantingtypes.get(selectedAgroInfo
				.getPlantingtypeid() - 1); // .getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());
		
		StudyRawDataManagerImpl studyRawMan = new StudyRawDataManagerImpl();
		 HashMap<String, ArrayList<String>> lstRawData = studyRawMan.constructDataRawAsMap((int)sampleID, new String[]{"Site","Location"}, "Site", true);
		
		for(int i = 0; i < sites.size(); i++){
			if(lstRawData.containsKey(sites.get(i).getSitename())) {
				sites.get(i).setSitename(lstRawData.get(sites.get(i).getSitename()).get(0));
				sites.get(i).setSitelocation(lstRawData.get(sites.get(i).getSitename()).get(1));
			}
		}
		if(selectedAgroInfo == null){
			selectedAgroInfo = new StudyAgronomy();
		}
		if(selectedDesignInfo == null) selectedDesignInfo = new StudyDesign();
		
		
		
	}
	
	@Command
	@NotifyChange("*")
	public void applyToAll(){
		
	}
	
	
	public class StudySiteInfoModel extends StudySite{
		private StudyAgronomy selectedAgroInfo = new StudyAgronomy();;
		private StudyDesign selectedDesignInfo = new StudyDesign();; 
		private PlantingType selectedSitePlantingType = new PlantingType();
		public StudyAgronomy getSelectedAgroInfo() {
			return selectedAgroInfo;
		}
		public void setSelectedAgroInfo(StudyAgronomy selectedAgroInfo) {
			this.selectedAgroInfo = selectedAgroInfo;
		}
		public StudyDesign getSelectedDesignInfo() {
			return selectedDesignInfo;
		}
		public void setSelectedDesignInfo(StudyDesign selectedDesignInfo) {
			this.selectedDesignInfo = selectedDesignInfo;
		}
		public PlantingType getSelectedSitePlantingType() {
			return selectedSitePlantingType;
		}
		public void setSelectedSitePlantingType(PlantingType selectedSitePlantingType) {
			this.selectedSitePlantingType = selectedSitePlantingType;
		}
		
	}

}