package org.strasa.web.uploadstudy.view.model;

import java.util.HashMap;
import java.util.Map;

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
	private int selectedIndex = 0;
	private boolean[] tabDisabled = {false,true,true,true};
	
	
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
	        //wire event listener
//	      Selectors.wireEventListeners(view, this);
	    }
	
	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName,
			@BindingParam("target") Tabpanel panel) {

		if (panel != null && panel.getChildren().isEmpty()) {
			 Map arg = new HashMap();
		        arg.put("studyID", Math.random());
			Executions.createComponents(zulFileName, panel, arg);
			
		}
	}
	@NotifyChange("*")
	@GlobalCommand("sampleCommand")
	public void sampleCommand(@BindingParam("model") UploadData uploadData) {
		System.out.println("Sample: " + uploadData.getTxtProject());

//		selectedIndex++;
		System.out.println("Sample: " + selectedIndex);

		tabDisabled[1] = false;
			Events.sendEvent("onSelect",tab2,tab2);
			changeTab();
	
	}
	@NotifyChange("*")
	public void changeTab(){
		selectedIndex++;
	}
}
