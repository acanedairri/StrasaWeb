package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.model.Ecotype;
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
import org.zkoss.zul.Rows;

 
public class DefineStudySite extends ProcessTabViewModel{
    private StudySiteManagerImpl studySiteMan = new StudySiteManagerImpl();
    private EcotypeManagerImpl ecotypeMan = new EcotypeManagerImpl();
	private List<StudySite> sites = studySiteMan.getAllStudySites(1);
	
	private double sampleID;
	
	
	public double getSampleID() {
		return sampleID;
	}

	public void setSampleID(double sampleID) {
		this.sampleID = sampleID;
	}

//	@Init
//	public void init(@ExecutionArgParam("studyID")double newVal){
//		sampleID = newVal;
//	}
	
	
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