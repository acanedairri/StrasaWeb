package org.strasa.web.uploadstudy.view.model;

import org.strasa.web.common.api.ProccessTabViewModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class TestTab implements ProccessTabViewModel{

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


@Override
public boolean validateTab() {
	// TODO Auto-generated method stub
	return false;
}

@Init
@Override
public void init(@ExecutionArgParam("studyID") double studyID) {
	sampleID = studyID;	
}
	
	
	
}
