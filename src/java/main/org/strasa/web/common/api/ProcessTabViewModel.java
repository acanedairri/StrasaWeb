package org.strasa.web.common.api;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;

public class ProcessTabViewModel {

	private double studyID;
	private Component mainView;

	
	
	public void initSpecial(){
		
	}

	public Component getMainView() {
		return mainView;
	}

	public void setMainView(Component mainView) {
		this.mainView = mainView;
	}

	public boolean validateTab(){
		return false;
	}

	public double getStudyID() {
		return studyID;
	}

	public void setStudyID(double studyID) {
		this.studyID = studyID;
	}
}