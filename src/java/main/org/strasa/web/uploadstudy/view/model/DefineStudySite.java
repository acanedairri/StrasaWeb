package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.StudySite;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Rows;

 
public class DefineStudySite {
    private StudySiteManagerImpl studySiteMan = new StudySiteManagerImpl();
    private EcotypeManagerImpl ecotypeMan = new EcotypeManagerImpl();
	private List<StudySite> sites = studySiteMan.getAllStudySites();
	
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
	
//	@Init
//	public void init(@ContextParam(ContextType.VIEW) Component view){
//			if(sites.isEmpty()){
//				
//			}
//		
//	}
	
}