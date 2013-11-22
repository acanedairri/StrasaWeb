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
	@Wire("#tab5")
	Tab tab5;
	private UploadData uploadData;
	private int selectedIndex = 1;
	private boolean[] tabDisabled = {false,true,true,true,true};
	private long studyID = 7;
	private boolean isRaw;
	
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
	
	 @NotifyChange("*")
	 @GlobalCommand("disableTabs")
	 public void disableTabs(){
		 tabDisabled[0] = false;
		 tabDisabled[1] = true;
		 tabDisabled[2] = true;
		 tabDisabled[3] = true;
		 tabDisabled[4] = true;
		 System.out.println("Disabled Tabs Called");
	 }
	  
	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName,
			@BindingParam("target") Tabpanel panel) {
		System.out.println(zulFileName);
		if (panel != null && panel.getChildren().isEmpty()) {
			 Map arg = new HashMap();
		        arg.put("studyID", studyID);
		        arg.put("isRaw", isRaw);
			Executions.createComponents(zulFileName, panel, arg);
			
		}
	}
	@NotifyChange("*")
	@GlobalCommand("nextTab")
	public void nextTab(@BindingParam("model") ProcessTabViewModel uploadData) {
		
		
		if(!uploadData.validateTab()){
			return;
		}
		if(selectedIndex == 0){
			isRaw = uploadData.isRaw;
			studyID = uploadData.getStudyID();
			System.out.println("IsRaw: " + uploadData.uploadToFolder );

		}
		if(uploadData.uploadToFolder){
			selectedIndex = 3;
		}

//		System.out.println("Sample: " + uploadData.getTxtProject());

//		selectedIndex++;
		

		tabDisabled[selectedIndex + 1] = false;
		if(uploadData.uploadToFolder){
			selectedIndex = 3;
		}
		Tab[] tabs = {tab1,tab2,tab3,tab4,tab5};
		
		Events.sendEvent("onSelect",tabs[selectedIndex + 1],tabs[selectedIndex + 1]);
		System.out.println("INDEX: " + selectedIndex);
		if(uploadData.uploadToFolder){
			tabDisabled[4] = false;
			System.out.println("FINISH LOADED: ");
			Events.sendEvent("onSelect",tab5,tab5);

			Events.sendEvent("onSelect",tab5,tab5);

			Events.sendEvent("onSelect",tab5,tab5);
		}
		selectedIndex++;
	
	}
	@NotifyChange("*")
	public void changeTab(){
		System.out.println("Called to change tab");
		selectedIndex++;
	}
}
