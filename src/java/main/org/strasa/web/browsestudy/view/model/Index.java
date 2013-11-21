package org.strasa.web.browsestudy.view.model;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

public class Index {	

	@NotifyChange
	@GlobalCommand
	public void openNewSearchInfoTab(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view,@BindingParam("studyId")Integer studyId, @BindingParam("studyName")String studyName){
		
		Tabpanels tabPanels = (Tabpanels) component.getFellow("tabPanels");
		Tabs tabs = (Tabs) component.getFellow("tabs");
		Tabbox tabBox = (Tabbox) component.getFellow("tabBox");
		
		Tab newTab = new Tab();
		newTab.setLabel(studyName);

		Tabpanel newPanel = new Tabpanel();
		
		//initialize view after view construction.
		Include studyInformationPage = new Include();
		studyInformationPage.setSrc("/user/browsestudy/studyinformation.zul");
		studyInformationPage.setParent(newPanel);
		
//		studyInformationPage.setAttribute("studyId", studyId);
		studyInformationPage.setDynamicProperty("studyId", studyId);
		tabPanels.appendChild(newPanel);
		tabs.appendChild(newTab);

		tabBox.setSelectedPanel(newPanel);
	}

}
