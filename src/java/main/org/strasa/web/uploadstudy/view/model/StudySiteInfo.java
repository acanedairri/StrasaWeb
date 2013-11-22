package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.PlantingTypeManagerImpl;
import org.strasa.middleware.manager.StudyAgronomyManagerImpl;
import org.strasa.middleware.manager.StudyDesignManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.mapper.StudySiteSqlProvider;
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

import com.mysql.jdbc.StringUtils;

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
	private boolean noSite = false;
	private StudySite selectedSite;
	private StudyAgronomy selectedAgroInfo = new StudyAgronomy();;
	private StudyDesign selectedDesignInfo = new StudyDesign();; 
	private PlantingType selectedSitePlantingType; // .getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());
	private int selectedID = 0;
	private int sID;
	private boolean isRaw = false;
	protected boolean goToNextPage = true;
	private int selectedPlantingIndex =0;
	private boolean applyToAll = false;
	public boolean isApplyToAll() {
		return applyToAll;
	}

	public void setApplyToAll(boolean applyToAll) {
		this.applyToAll = applyToAll;
	}

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
		return sID;
	}

	public void setSampleID(int sampleID) {
		this.sID = sampleID;
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
		selectedAgroInfo = sites.get(id).getSelectedAgroInfo();
		selectedDesignInfo = sites.get(id).getSelectedDesignInfo();
			selectedPlantingIndex = sites.get(id).selectedPlantingIndex;
		selectedID = id;
		
		
//		setSelectedAgroInfo(getAgroInfoBySiteID(id));
//		setSelectedDesignInfo(getDesignInfoBySiteID(id));
//		selectedSitePlantingType = plantingtypes.get(selectedAgroInfo
//				.getPlantingtypeid() - 1); // .getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());
		System.out.println("selected row id: " + Integer.toString(id));

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
	
		

		for(StudySiteInfoModel site: sites){
			if(StringUtils.isNullOrEmpty(site.getSitename()) || StringUtils.isEmptyOrWhitespaceOnly(site.getSitename())){
				Messagebox.show("Error: Site names must not be empty.", "Upload Error",
						Messagebox.OK, Messagebox.ERROR);
				return false;
			}
			if(StringUtils.isNullOrEmpty(site.getSitelocation()) || StringUtils.isEmptyOrWhitespaceOnly(site.getSitelocation())){
				Messagebox.show("Error: Locations must not be empty.", "Upload Error",
						Messagebox.OK, Messagebox.ERROR);
				return false;
			}
		}
		
	
		 System.out.println("LOOP : " + sites.size());
		List<StudySite> lstSites = new ArrayList<StudySite>();
		 List<StudyAgronomy> lstAgro = new ArrayList<StudyAgronomy>();
		 List<StudyDesign> designInfo = new ArrayList<StudyDesign>();
		 StudySiteManagerImpl siteMan = new StudySiteManagerImpl(isRaw);
		 if(applyToAll){
			 
		 selectedAgroInfo = sites.get(selectedID).selectedAgroInfo;
		 selectedDesignInfo = sites.get(selectedID).selectedDesignInfo;
		 }
		 for(StudySiteInfoModel data : sites){
			 data.setStudyid(sID);
			 if(data.getId() == null){
				 
				 StudySite siteData = data;
				 
				 siteMan.addStudySite(siteData);
				 
				 if(applyToAll){
					 selectedAgroInfo.setStudysiteid(data.getId());
					 selectedDesignInfo.setStudysiteid(data.getId());
					 studyAgroMan.addStudyAgronomy(selectedAgroInfo);
					 studyDesignMan.addStudyDesign(selectedDesignInfo);
				 }
				 else{
				 data.selectedAgroInfo.setStudysiteid(data.getId());
				 data.selectedDesignInfo.setStudysiteid(data.getId());
				 studyAgroMan.addStudyAgronomy(data.selectedAgroInfo);
				 studyDesignMan.addStudyDesign(data.selectedDesignInfo);
				 }
			 }
			 else{
				 siteMan.updateStudySite(data);

				 if(applyToAll){
					 selectedAgroInfo.setStudysiteid(data.getId());
					 selectedDesignInfo.setStudysiteid(data.getId());
					 studyAgroMan.updateStudyAgronomy(selectedAgroInfo);
					 studyDesignMan.updateStudyDesign(selectedDesignInfo);
					 
				 }
				 else{
					 studyAgroMan.updateStudyAgronomy(data.selectedAgroInfo);
					 studyDesignMan.updateStudyDesign(data.selectedDesignInfo);
					 	 
				 }
			 }
			 
		 }

		
		
		
		
		
		return goToNextPage;
	}

	@Init
	public void init(@ExecutionArgParam("studyID") long studyID, @ExecutionArgParam("isRaw") boolean isRaw ) {
		sID = (int) studyID;
		this.isRaw = isRaw;
		studySiteMan = new StudySiteManagerImpl(isRaw);
		studyAgroMan = new StudyAgronomyManagerImpl();
		studyDesignMan = new StudyDesignManagerImpl();
		ecotypeMan = new EcotypeManagerImpl();
		plantingtypeMan = new PlantingTypeManagerImpl();
		sites = new ArrayList<StudySiteInfoModel>();
		


		StudyRawDataManagerImpl studyRawMan = new StudyRawDataManagerImpl(isRaw);
		if(!studyRawMan.hasSiteColumnData(sID)){
			StudySiteInfoModel siteInfo = new StudySiteInfoModel();
			siteInfo.selectedDesignInfo = new StudyDesign();
			siteInfo.selectedSitePlantingType = new PlantingType();
			siteInfo.selectedAgroInfo = new StudyAgronomy();
			siteInfo.setYear(new StudyManagerImpl().getStudyById(sID).getStartyear());
			siteInfo.setSeason("NO SEASON");
			
			sites.add(siteInfo);
			
			ecotypes = ecotypeMan.getAllEcotypes();
			plantingtypes = plantingtypeMan.getAllPlantingTypes();
			selectedSite = sites.get(0);
			
			noSite = false;
			return;
		}
		String studyStartYear = new StudyManagerImpl().getStudyById(sID).getStartyear();
		
		List<StudySite> subsites = studySiteMan.getAllStudySites(sID);
		if(subsites.isEmpty()){
				List<StudySite> lstSiteRaw = studyRawMan.getStudySiteInfo(sID);
				for(StudySite siteData : lstSiteRaw){
					StudySiteInfoModel siteInfo = new StudySiteInfoModel(siteData);
					if(siteInfo.getYear().isEmpty() || siteInfo.getYear().equals("") || siteInfo.getYear() == null) {
				
						siteInfo.setYear(studyStartYear);
					}
						
					siteInfo.selectedDesignInfo = new StudyDesign();
					siteInfo.selectedSitePlantingType = new PlantingType();
					siteInfo.selectedAgroInfo = new StudyAgronomy();
					sites.add(siteInfo);
				}
		}
		else{
			for(StudySite siteData : subsites) {
				StudySiteInfoModel siteInfo = new StudySiteInfoModel(siteData);
				siteInfo.selectedDesignInfo = studyDesignMan.getStudyDesign(siteData.getId());
				siteInfo.selectedSitePlantingType = plantingtypeMan.getPlantingTypeById(siteInfo.getSelectedAgroInfo().getPlantingtypeid());
				//TODO: SOMETHING FISHY
				System.out.println(siteInfo + " " + " " + siteInfo.selectedAgroInfo + " " + studyAgroMan + " " + siteInfo.getId());
				siteInfo.selectedAgroInfo = studyAgroMan.getStudyAgronomy(siteInfo.getId());
				sites.add(siteInfo);
			}
			
		}
		
		
		ecotypes = ecotypeMan.getAllEcotypes();
		plantingtypes = plantingtypeMan.getAllPlantingTypes();
		selectedSite = sites.get(0);
		

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
			this.setSoiltype(s.getSoiltype());
			this.setStudyid(s.getStudyid());
			this.setYear(s.getYear());
			
		}
		
		public StudySiteInfoModel(){
			
		}
		public StudyAgronomy getSelectedAgroInfo() {
			if(selectedAgroInfo == null) return new StudyAgronomy();
			return selectedAgroInfo;
		}
		public void setSelectedAgroInfo(StudyAgronomy selectedAgroInfo) {

			this.selectedAgroInfo = selectedAgroInfo;
		}
		public StudyDesign getSelectedDesignInfo() {
			
			if(selectedDesignInfo == null){
				StudyDesign rec = new StudyDesign();
				rec.setId(sID);
				return rec;
			}
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