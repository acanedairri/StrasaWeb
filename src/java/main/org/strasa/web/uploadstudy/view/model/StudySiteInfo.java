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
	private int selectedID = 0;
	private int sampleID;
	private boolean isRaw = false;
	protected boolean goToNextPage = true;
	private int selectedPlantingIndex =0;
	public int getSelectedPlantingIndex() {
		return selectedPlantingIndex;
	}

	public void setSelectedPlantingIndex(int selectedPlantingIndex) {
		this.selectedPlantingIndex = selectedPlantingIndex;
	}

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
		System.out.print("OTU");
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

	public void setSampleID(int sampleID) {
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



	@NotifyChange("*")
	@Command("updateDesignInfo")
	public void updateDesignInfo(@BindingParam("id") Integer id) {

		
		sites.get(selectedID).selectedPlantingIndex = selectedPlantingIndex;
		selectedAgroInfo = sites.get(id).selectedAgroInfo;
		selectedDesignInfo = sites.get(id).selectedDesignInfo;
			selectedPlantingIndex = sites.get(id).selectedPlantingIndex;
		selectedID = id;
		
//		setSelectedAgroInfo(getAgroInfoBySiteID(id));
//		setSelectedDesignInfo(getDesignInfoBySiteID(id));
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
         
		List<StudySite> lstSites = new ArrayList<StudySite>();
		 List<StudyAgronomy> lstAgro = new ArrayList<StudyAgronomy>();
		 List<StudyDesign> designInfo = new ArrayList<StudyDesign>();
		 for(StudySiteInfoModel data : sites){
			 StudySite siteData = data;
			 lstAgro.add(data.getSelectedAgroInfo());
			 designInfo.add(data.selectedDesignInfo);
		 }
		studySiteMan.updateStudySite(lstSites);
		studyAgroMan.updateStudyAgronomy(agroInfo);
		studyDesignMan.updateStudyDesign(designInfo);

		Messagebox.show("Changes saved.");
	}

	@Override
	public boolean validateTab() {
		List<StudySite> lstSites = new ArrayList<StudySite>();
		 List<StudyAgronomy> lstAgro = new ArrayList<StudyAgronomy>();
		 List<StudyDesign> designInfo = new ArrayList<StudyDesign>();
		 for(StudySiteInfoModel data : sites){
			 StudySite siteData = data;
			 lstAgro.add(data.getSelectedAgroInfo());
			 designInfo.add(data.selectedDesignInfo);
		 }
		studySiteMan.updateStudySite(lstSites);
		studyAgroMan.updateStudyAgronomy(lstAgro);
		studyDesignMan.updateStudyDesign(designInfo);
		return goToNextPage;
	}

	@Init
	public void init(@ExecutionArgParam("studyID") long studyID, @ExecutionArgParam("isRaw") boolean isRaw ) {
		sampleID = (int) studyID;
		this.isRaw = isRaw;
		studySiteMan = new StudySiteManagerImpl(isRaw);
		studyAgroMan = new StudyAgronomyManagerImpl();
		studyDesignMan = new StudyDesignManagerImpl();
		ecotypeMan = new EcotypeManagerImpl();
		plantingtypeMan = new PlantingTypeManagerImpl();
		sites = new ArrayList<StudySiteInfoModel>();
		List<StudySite> subsites = studySiteMan.initializeStudySites(22);
		for(StudySite siteD : subsites){
			
			StudySiteInfoModel siteInfo = new StudySiteInfoModel(siteD);
			siteInfo.selectedAgroInfo = studyAgroMan.getStudyAgronomy(siteD.getId());
			siteInfo.selectedDesignInfo = studyDesignMan.getStudyDesign(siteD.getId());
			if(siteInfo.selectedDesignInfo == null) siteInfo.selectedDesignInfo = new StudyDesign();
			if(siteInfo.selectedAgroInfo != null) siteInfo.selectedSitePlantingType = plantingtypeMan.getPlantingTypeById(siteInfo.getSelectedAgroInfo().getPlantingtypeid());
			else{
				siteInfo.selectedSitePlantingType = new PlantingType();
			}
			sites.add(siteInfo);
			
		}
	
		ecotypes = ecotypeMan.getAllEcotypes();
		plantingtypes = plantingtypeMan.getAllPlantingTypes();

		selectedSite = sites.get(0);
		
		StudyRawDataManagerImpl studyRawMan = new StudyRawDataManagerImpl(isRaw);
		 HashMap<String, ArrayList<String>> lstRawData = studyRawMan.constructDataRawAsMap((int)sampleID, new String[]{"Site","Location"}, "Site", true);
		
		for(int i = 0; i < sites.size(); i++){
			if(lstRawData.containsKey(sites.get(i).getSitename())) {
				sites.get(i).setSitename(lstRawData.get(sites.get(i).getSitename()).get(0));
				sites.get(i).setSitelocation(lstRawData.get(sites.get(i).getSitename()).get(1));
			}
		}
		
		updateDesignInfo(0);
		
		
		
	}
	
	@Command
	@NotifyChange("*")
	public void applyToAll(){
		for(int i = 0; i < sites.size(); i++){
			sites.get(i).selectedAgroInfo = selectedAgroInfo;
			sites.get(i).selectedDesignInfo = selectedDesignInfo;
			sites.get(i).selectedPlantingIndex = selectedPlantingIndex;
			sites.get(i).selectedSitePlantingType = selectedSitePlantingType;
			
		}
	}
	
	
	public class StudySiteInfoModel extends StudySite{
		private StudyAgronomy selectedAgroInfo = new StudyAgronomy();
		private StudyDesign selectedDesignInfo = new StudyDesign();
		private PlantingType selectedSitePlantingType = new PlantingType();
		private int selectedPlantingIndex;
		public StudySiteInfoModel(StudySite s){
			this.setEcotypeid(s.getEcotypeid());
			this.setSeason(s.getSeason());
			this.setSitelocation(s.getSitelocation());
			this.setSitename(s.getSitename());
			this.setSoilph(s.getSoilph());
			this.setSoiltype(s.getSoiltype());
			this.setSoiltype(this.getSoiltype());
			this.setStudyid(this.getStudyid());
			this.setYear(this.getYear());
			
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
		public PlantingType getSelectedSitePlantingType() {

			System.out.println(selectedSitePlantingType.getPlanting());
			return selectedSitePlantingType;
		}
		public void setSelectedSitePlantingType(PlantingType selectedSitePlantingType) {
			this.selectedSitePlantingType = selectedSitePlantingType;

			System.out.println(selectedSitePlantingType.getPlanting());
		}
		
	}

}