package org.strasa.web.uploadstudy.view.model;

import java.util.HashMap;
import java.util.Map;

import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;

public class Index {

	@Wire("#tab1")
	Tab tab1;
	@Wire("#tab2")
	Tab tab2;
	@Wire("#tab3")
	Tab tab3;
	@Wire("#tab4")
	Tab tab4;
	private UploadData uploadData;
	private int selectedIndex = 1;
	private boolean[] tabDisabled = {false,false,false,false};
	private long studyID = 7;
	
	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public UploadData getUploadData() {
		return uploadData;
	}

	public void setUploadData(UploadData uploadData) {
		this.uploadData = uploadData;
	}

	public boolean[] getTabDisabled() {
		return tabDisabled;
	}

	public void setTabDisabled(boolean[] tabDisabled) {
		this.tabDisabled = tabDisabled;
	}

	  @AfterCompose
	    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
	        Selectors.wireComponents(view, this, false);
			Events.sendEvent("onSelect",tab1,tab1);
	        //wire event listener
//	      Selectors.wireEventListeners(view, this);
	    }
	
	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName,
			@BindingParam("target") Tabpanel panel) {

		if (panel != null && panel.getChildren().isEmpty()) {
			 Map arg = new HashMap();
		        arg.put("studyID", studyID);
			Executions.createComponents(zulFileName, panel, arg);
			
		}
	}
	@NotifyChange("*")
	@GlobalCommand("sampleCommand")
	public void sampleCommand(@BindingParam("model") ProcessTabViewModel uploadData) {
		
		
		if(!uploadData.validateTab()){
			return;
		}
		
		studyID = uploadData.getStudyID();
//		System.out.println("Sample: " + uploadData.getTxtProject());

//		selectedIndex++;
		System.out.println("Sample: " + selectedIndex);

		tabDisabled[selectedIndex + 1] = false;
		
		switch(selectedIndex + 1){
		case 1:
			Events.sendEvent("onSelect",tab1,tab1);
		case 2:
			Events.sendEvent("onSelect",tab2,tab2);
		case 3: 	
			Events.sendEvent("onSelect",tab3,tab3);
		case 4:
			Events.sendEvent("onSelect",tab4,tab4);
		}
			changeTab();
	
	}
	@NotifyChange("*")
	public void changeTab(){
		selectedIndex++;
	}
}
