package org.strasa.web.browsestudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.PlantingTypeManagerImpl;
import org.strasa.middleware.manager.StudyAgronomyManagerImpl;
import org.strasa.middleware.manager.StudyDesignManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.PlantingType;
import org.strasa.middleware.model.Study;
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
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Rows;

 
public class Index {
  
//	private List<StudyAgronomy> agroInfo = studyAgroMan.initializeStudyAgronomy(sites);
//	private List<StudyDesign> designInfo = studyDesignMan.initializeStudyDesign(sites);
//	private List<Ecotype> ecotypes = ecotypeMan.getAllEcotypes();
//	private List<PlantingType> plantingtypes = plantingtypeMan.getAllPlantingTypes();
//
//
//	private StudySite selectedSite = sites.get(0);
//	private StudyAgronomy selectedAgroInfo = getAgroInfoBySiteID(selectedSite.getId());
//	private StudyDesign selectedDesignInfo = getDesignInfoBySiteID(selectedSite.getId());
//	private PlantingType selectedSitePlantingType = plantingtypes.get(selectedAgroInfo.getPlantingtypeid()-1); //.getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());
//
//	private double sampleID;
//	protected boolean goToNextPage=true;
	
//	private StudyDesign getDesignInfoBySiteID(Integer id) {
//		// TODO Auto-generated method stub
//		for(StudyDesign d: designInfo ){
//			if(d.getStudysiteid()==id){
//				System.out.println("Selected Design info id: "+ d.getStudysiteid());
//				return d;
//			}
//		}
//		return null;
//	}
//
//	private StudyAgronomy getAgroInfoBySiteID(Integer id) {
//		// TODO Auto-generated method stub
//		for(StudyAgronomy a: agroInfo ){
//			if(a.getStudysiteid()==id){
//				System.out.println("Selected Agronomy info id: "+ a.getStudysiteid());
//				return a;
//			}
//		}
//		return null;
//	}
//
//	@GlobalCommand
//	@NotifyChange("sampleID")
//	public void testGlobalCom(@BindingParam("studyID")double newVal){
//		sampleID = newVal;
//	}
//	
//	@NotifyChange("*")
//	@Command("updateDesignInfo")
//	public void updateDesignInfo(@BindingParam("id") Integer id){
//			setSelectedAgroInfo(getAgroInfoBySiteID(id));
//			setSelectedDesignInfo(getDesignInfoBySiteID(id));
//			selectedSitePlantingType = plantingtypes.get(selectedAgroInfo.getPlantingtypeid()-1); //.getPlantingTypeById(selectedAgroInfo.getPlantingtypeid());
//			System.out.println("selected row id: "+ Integer.toString(id));
//			
//	}
//	
//	
//	@Command("updateSelectedSitePlantingType")
//	public void updateSelectedSitePlantingType(){
//			selectedAgroInfo.setPlantingtypeid(selectedSitePlantingType.getId());
//	}
//	
//	@Command("saveSiteAgroDesignInfo")
//	public void saveSiteAgroDesignInfo(){
//			studySiteMan.updateStudySite(sites);
//			studyAgroMan.updateStudyAgronomy(agroInfo);
//			studyDesignMan.updateStudyDesign(designInfo);
//			
//			Messagebox.show("Changes saved.");
//	}
//	
//	@Override
//	public boolean validateTab() {
////		goToNextPage=false;
////		// TODO Auto-generated method stub
////		if (Messagebox.show("Delete?", "Prompt", Messagebox.YES|Messagebox.NO,
////			    Messagebox.QUESTION) == Messagebox.YES) {
////			    //execute only if the YES button is clicked
////			goToNextPage =true;
////		}
////		
//		return goToNextPage;
//	}
		
}