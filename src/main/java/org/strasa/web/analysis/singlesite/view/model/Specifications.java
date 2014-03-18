package org.strasa.web.analysis.singlesite.view.model;

import java.util.ArrayList;
import java.util.List;

import org.analysis.rserve.manager.test.TestRServeManager;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;

public class Specifications {	
	//public static ArrayList<Integer> activeStudyIds = new ArrayList<Integer>();
	
	private String resultRServe;
	private List<String> typeOfDesignList;

	public String getResultRServe() {
		return resultRServe;
	}

	public void setResultRServe(String resultRServe) {
		this.resultRServe = resultRServe;
	}

	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		typeOfDesignList = getTypeOfDesignList();
	}
	
	@NotifyChange("*")
	@Command("runRserve")
	public void DisplayGermplasmInfo(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view) throws RserveException, REXPMismatchException{
		
		TestRServeManager r= new TestRServeManager();
		resultRServe=r.testRServe();
		
		
	}

	public List<String> getTypeOfDesignList() {
		// TODO Auto-generated method stub
		List<String> designs = new ArrayList<String>();
		designs.add("CRD");
		designs.add("RCBD");
		designs.add("Alpha-Lattice");
		designs.add("Row-Column");
		designs.add("Augmented RCBD");
		return designs;
	}

	public void setTypeOfDesignList(List<String> typeOfDesignList) {
		this.typeOfDesignList = typeOfDesignList;
	}

}
