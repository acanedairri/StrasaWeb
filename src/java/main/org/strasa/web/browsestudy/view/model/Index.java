package org.strasa.web.browsestudy.view.model;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

@SuppressWarnings({ "rawtypes", "serial" })
public class Index extends SelectorComposer<Component>{
	
	@Wire
	Tabbox tabBox;
	@Wire
	Tabs tabs;
	@Wire
	Tabpanels tabPanels;
	
	public void createNewTab(){
		Tab newTab = new Tab();
		newTab.setLabel("study1");
		
		Tabpanel newPanel = new Tabpanel();
		//initialize view after view construction.
		Include pageDefineStudySite = new Include();
		pageDefineStudySite.setSrc("/user/browsestudy/studyinformation.zul");
		pageDefineStudySite.setParent(newPanel);
		newPanel.appendChild(pageDefineStudySite);
		
		tabPanels.appendChild(newPanel);
		tabs.appendChild(newTab);
		
		tabBox.setSelectedIndex(1);	
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		Tab newTab = new Tab();
		newTab.setLabel("study1");
		
		Tabpanel newPanel = new Tabpanel();
		//initialize view after view construction.
		Include pageDefineStudySite = new Include();
		pageDefineStudySite.setSrc("/user/browsestudy/studyinformation.zul");
		pageDefineStudySite.setParent(newPanel);
		newPanel.appendChild(pageDefineStudySite);
		
		tabPanels.appendChild(newPanel);
		tabs.appendChild(newTab);
		
		tabBox.setSelectedIndex(2);	
	}
	
}