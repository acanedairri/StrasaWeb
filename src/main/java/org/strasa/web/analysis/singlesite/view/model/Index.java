package org.strasa.web.analysis.singlesite.view.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.analysis.rserve.manager.RServeManager;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.StudyType;
import org.strasa.web.analysis.view.model.SingleSiteAnalysisModel;
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
import org.zkoss.zul.Image;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class Index {	

	private Tab resultTab;
	private RServeManager rServeManager;

	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){

	}

	@GlobalCommand("displaySsaResult")
	@NotifyChange("*")
	public void displaySsaResult(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view, @BindingParam("ssaModel") SingleSiteAnalysisModel ssaModel) {
		rServeManager = new RServeManager();
		rServeManager.doSingleEnvironmentAnalysis(ssaModel);
		
		Tabpanels tabPanels = (Tabpanels) component.getFellow("tabPanels");
		Tabs tabs = (Tabs) component.getFellow("tabs");

		Tabpanel newPanel = new Tabpanel();
		Tab newTab = new Tab();
		newTab.setLabel(new File(ssaModel.getOutFileName()).getParentFile().getName());
		newTab.setClosable(true);

		//initialize view after view construction.
		Include studyInformationPage = new Include();
		studyInformationPage.setParent(newPanel);
		studyInformationPage.setSrc("/user/analysis/textviewer.zul");

		tabPanels.appendChild(newPanel);
		tabs.appendChild(newTab);
	}

	public Tab getResultTab() {
		return resultTab;
	}

	public void setResultTab(Tab resultTab) {
		this.resultTab = resultTab;
	}

}
