package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.StudyAgronomyManagerImpl;
import org.strasa.middleware.manager.StudyDesignManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.model.Ecotype;
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
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Window;

 
public class DefineStudySite extends ProcessTabViewModel{
    private StudySiteManagerImpl studySiteMan = new StudySiteManagerImpl();
    private StudyAgronomyManagerImpl studyAgroMan = new StudyAgronomyManagerImpl();
    private StudyDesignManagerImpl studyDesignMan = new StudyDesignManagerImpl();
    
    private EcotypeManagerImpl ecotypeMan = new EcotypeManagerImpl();
	private List<StudySite> sites = studySiteMan.initializeStudySites(1);
	private List<StudyAgronomy> agroInfo = studyAgroMan.initializeStudyAgronomy(sites);
	private List<StudyDesign> designInfo = studyDesignMan.initializeStudyDesign(sites);
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

	
	@GlobalCommand
	@NotifyChange("sampleID")
	public void testGlobalCom(@BindingParam("studyID")double newVal){
		sampleID = newVal;
	}
	
	private List<Ecotype> ecotypes = ecotypeMan.getAllEcotypes();
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


	@NotifyChange("*")
	@Command("updateDesignInfo")
	public void updateDesignInfo(@BindingParam("id") Integer id){
//		selectedSite=
			System.out.println("selected row id: "+ Integer.toString(id));
			
	}
	
	@Override
	public boolean validateTab() {
		// TODO Auto-generated method stub
		return false;
	}

	@Init
	public void init(@ExecutionArgParam("studyID") double studyID) {
		sampleID = studyID;	
	}
		
}