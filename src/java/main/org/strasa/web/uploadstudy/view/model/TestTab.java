package org.strasa.web.uploadstudy.view.model;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class TestTab {

	private double sampleID;

	
	public double getSampleID() {
		return sampleID;
	}


	public void setSampleID(double sampleID) {
		this.sampleID = sampleID;
	}

	@Init
	public void init(@ExecutionArgParam("newVal")double newVal){
		sampleID = newVal;
	}
	
	
	@GlobalCommand
	@NotifyChange("sampleID")
	public void testGlobalCom(@BindingParam("newVal")double newVal){
		sampleID = newVal;
	}
	
	
	
}
