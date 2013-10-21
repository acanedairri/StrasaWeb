package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.PlantingTypeManagerImpl;
import org.strasa.middleware.manager.StudyAgronomyManagerImpl;
import org.strasa.middleware.manager.StudyDesignManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.PlantingType;
import org.strasa.middleware.model.StudyAgronomy;
import org.strasa.middleware.model.StudyDesign;
import org.strasa.middleware.model.StudySite;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Window;

 
public class DefineStudySite extends ProcessTabViewModel{
    private StudySiteManagerImpl studySiteMan = new StudySiteManagerImpl();
    private StudyAgronomyManagerImpl studyAgroMan = new StudyAgronomyManagerImpl();
    private StudyDesignManagerImpl studyDesignMan = new StudyDesignManagerImpl();    
    private EcotypeManagerImpl ecotypeMan = new EcotypeManagerImpl();    
    private PlantingTypeManagerImpl plantingtypeMan = new PlantingTypeManagerImpl();
    
	private List<StudySite> sites = studySiteMan.initializeStudySites(1);
//		private List<StudySite> sites = studySiteMan.initializeStudySites(Integer.parseInt(Double.toString(sampleID)));
	private List<StudyAgronomy> agroInfo = studyAgroMan.initializeStudyAgronomy(sites);
	private List<StudyDesign> designInfo = studyDesignMan.initializeStudyDesign(sites);
	private List<Ecotype> ecotypes = ecotypeMan.getAllEcotypes();
	private List<PlantingType> plantingtypes = plantingtypeMan.getAllPlantingTypes();


	private StudySite selectedSite = sites.get(0);
	private StudyAgronomy selectedAgroInfo = getAgroInfoBySiteID(selectedSite.getId());
	private StudyDesign selectedDesignInfo = getDesignInfoBySiteID(selectedSite.getId());
	private PlantingType selectedSitePlantingType = plantingtypes.get(selectedAgroInfo.getPlantingtypeid()-1); //.getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());
	
	public List<PlantingType> getPlantingtypes() {
		return plantingtypes;
	}

	public void setPlantingtypes(List<PlantingType> plantingtypes) {
		this.plantingtypes = plantingtypes;
	}
	
	public PlantingType getSelectedSitePlantingType() {
		return selectedSitePlantingType;
	}

	public void setSelectedSitePlantingType(PlantingType selectedSitePlantingType) {
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

	private double sampleID;
	
	
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
	public List<StudySite> getSites() {
		return sites;
	}
	public void setSites(List<StudySite> sites) {
		this.sites = sites;
	}
	
	private StudyDesign getDesignInfoBySiteID(Integer id) {
		// TODO Auto-generated method stub
		for(StudyDesign d: designInfo ){
			if(d.getStudysiteid()==id){
				System.out.println("Selected Design info id: "+ d.getStudysiteid());
				return d;
			}
		}
		return null;
	}

	private StudyAgronomy getAgroInfoBySiteID(Integer id) {
		// TODO Auto-generated method stub
		for(StudyAgronomy a: agroInfo ){
			if(a.getStudysiteid()==id){
				System.out.println("Selected Agronomy info id: "+ a.getStudysiteid());
				return a;
			}
		}
		return null;
	}

	@GlobalCommand
	@NotifyChange("sampleID")
	public void testGlobalCom(@BindingParam("studyID")double newVal){
		sampleID = newVal;
	}
	
	@NotifyChange("*")
	@Command("updateDesignInfo")
	public void updateDesignInfo(@BindingParam("id") Integer id){
//		selectedSite=
			setSelectedAgroInfo(getAgroInfoBySiteID(id));
			setSelectedDesignInfo(getDesignInfoBySiteID(id));
			selectedSitePlantingType = plantingtypes.get(selectedAgroInfo.getPlantingtypeid()-1); //.getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());
			System.out.println("selected row id: "+ Integer.toString(id));
			
	}
	
	
	@Command("updateSelectedSitePlantingType")
	public void updateSelectedSitePlantingType(){
//		selectedSite=
			selectedAgroInfo.setPlantingtypeid(selectedSitePlantingType.getId());
	}
	
	@Command("saveSiteAgroDesignInfo")
	public void saveSiteAgroDesignInfo(){
//		selectedSite=
			studySiteMan.updateStudySite(sites);
			studyAgroMan.updateStudyAgronomy(agroInfo);
			studyDesignMan.updateStudyDesign(designInfo);
			
			Messagebox.show("Changes saved.");
	}
	
	@Override
	public boolean validateTab() {
		// TODO Auto-generated method stub
		return true;
	}

	@Init
	public void init(@ExecutionArgParam("studyID") double studyID) {
		sampleID = studyID;	
	}
		
}