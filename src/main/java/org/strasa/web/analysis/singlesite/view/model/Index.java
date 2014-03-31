package org.strasa.web.analysis.singlesite.view.model;

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
import org.zkoss.zk.ui.Executions;
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
private static HashMap<String,Tab> activeStudyIds;

private Tab resultTab;

	public static void removeFromTab(int studyId){
		activeStudyIds.remove(studyId);
	}

	 @AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		activeStudyIds = new HashMap<String,Tab>();
		
		Tabpanels tabPanels = (Tabpanels) component.getFellow("tabPanels");
		Tabs tabs = (Tabs) component.getFellow("tabs");
		Tabbox tabBox = (Tabbox) component.getFellow("tabBox");
		
		Tabpanel newPanel = new Tabpanel();
		Tab newTab = new Tab();
		newTab.setLabel("Result");
		
		//initialize view after view construction.
		Include studyInformationPage = new Include();
		studyInformationPage.setParent(newPanel);
		studyInformationPage.setDynamicProperty("resultTab", newTab);
		studyInformationPage.setSrc("/user/analysis/textviewer.zul");
		
		tabPanels.appendChild(newPanel);
		tabs.appendChild(newTab);
		
		Tabpanel newGraphsPanel = new Tabpanel();
		Tab newGraphsTab = new Tab();
		newGraphsTab.setLabel("Graphs");
		
		//initialize view after view construction.
		Include graphsPage = new Include();
		graphsPage.setParent(newGraphsPanel);
		graphsPage.setDynamicProperty("graphsTab", newGraphsTab);
		graphsPage.setSrc("/user/home.zul");
		
		tabPanels.appendChild(newGraphsPanel);
		tabs.appendChild(newGraphsTab);
		
		tabBox.setSelectedIndex(0);
	}

	public Tab getResultTab() {
		return resultTab;
	}

	public void setResultTab(Tab resultTab) {
		this.resultTab = resultTab;
	}

}
