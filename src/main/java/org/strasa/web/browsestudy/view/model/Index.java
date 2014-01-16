package org.strasa.web.browsestudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.StudyType;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Window;

public class Index {	
//public static ArrayList<Integer> activeStudyIds = new ArrayList<Integer>();
private static HashMap<Integer,Tab> activeStudyIds = new HashMap<Integer,Tab>();

private Tab resultTab;

	public static void removeFromTab(int studyId){
		activeStudyIds.remove(studyId);
	}

	 @AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		Tabpanels tabPanels = (Tabpanels) component.getFellow("resultPanels");
		Tabs tabs = (Tabs) component.getFellow("resultTabs");
		Tabbox tabBox = (Tabbox) component.getFellow("resultTabBox");
		
		Tabpanel newPanel = new Tabpanel();
		Tab newTab = new Tab();
		newTab.setLabel("Result");
		
		//initialize view after view construction.
		Include studyInformationPage = new Include();
		studyInformationPage.setParent(newPanel);
		studyInformationPage.setDynamicProperty("resultTab", newTab);
		studyInformationPage.setSrc("/user/browsestudy/searchresult.zul");
		tabPanels.appendChild(newPanel);
		tabs.appendChild(newTab);
		tabBox.setSelectedPanel(newPanel);
		
		tabBox.setSelectedIndex(0);
//		setResultTab(newTab);
	}
	
	@NotifyChange
	@GlobalCommand
	public void openNewSearchInfoTab(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view,@BindingParam("studyId")  Integer studyId, @BindingParam("studyName")String studyName){
		
		Tabpanels tabPanels = (Tabpanels) component.getFellow("tabPanels");
		Tabs tabs = (Tabs) component.getFellow("tabs");
		Tabbox tabBox = (Tabbox) component.getFellow("tabBox");
		
		if(!activeStudyIds.containsKey(studyId)){
		final int id=studyId;
		Tab newTab = new Tab();
		newTab.setLabel(studyName);
		newTab.setClosable(true);
		newTab.addEventListener("onClose", new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				activeStudyIds.remove(id);
			}
		});
		Tabpanel newPanel = new Tabpanel();
		
		//initialize view after view construction.
		Include studyInformationPage = new Include();
		studyInformationPage.setParent(newPanel);
		studyInformationPage.setSrc("/user/browsestudy/studyinformation.zul");
		studyInformationPage.setDynamicProperty("studyId", studyId);
		tabPanels.appendChild(newPanel);
		tabs.appendChild(newTab);
		tabBox.setSelectedPanel(newPanel);
		
		newTab.setSelected(true);
		activeStudyIds.put(studyId, newTab);
		
		}
		else{
		Tab tab = activeStudyIds.get(studyId);
		tab.setSelected(true);
		}
	}
	
	@NotifyChange
	@Command
	public void openSearchFilterWindow(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		
		//initialize view after view construction.
		Include studyInformationPage = (Include) component.getFellow("searchFilterPanel");
		Window win = (Window) studyInformationPage.getChildren().get(0);
		win.doOverlapped();
	}

	public Tab getResultTab() {
		return resultTab;
	}

	public void setResultTab(Tab resultTab) {
		this.resultTab = resultTab;
	}

}
