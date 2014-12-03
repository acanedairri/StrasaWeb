package org.strasa.web.managegermplasm.view.model;

import java.util.ArrayList;

import org.strasa.middleware.manager.GermplasmManagerImpl;
import org.strasa.middleware.manager.StudyGermplasmManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.model.Germplasm;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;

public class AdvanceGermplasmSearch {

	@Wire("#tabData")
	Tabbox tabBox;

	Germplasm selectedGermplasm;
	ArrayList<Germplasm> lstGermplasm = new ArrayList<Germplasm>();

	@Init
	public void init() {

		GermplasmManagerImpl germMan = new GermplasmManagerImpl();
		lstGermplasm.addAll(germMan.getAllGermplasm());

	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);

	}

	public Germplasm getSelectedGermplasm() {
		return selectedGermplasm;
	}

	public void setSelectedGermplasm(Germplasm selectedGermplasm) {
		this.selectedGermplasm = selectedGermplasm;
	}

	public ArrayList<Germplasm> getLstGermplasm() {
		return lstGermplasm;
	}

	public void setLstGermplasm(ArrayList<Germplasm> lstGermplasm) {
		this.lstGermplasm = lstGermplasm;
	}

	@Command("query")
	public void queryResult() {
		Components.removeAllChildren(tabBox.getTabs());
		Components.removeAllChildren(tabBox.getTabpanels());

		ArrayList<Integer> lstStudyIds = new StudyGermplasmManagerImpl().getStudyIDFromGermplasmID(selectedGermplasm.getId());
		StudyManagerImpl studyMan = new StudyManagerImpl();
		for (Integer studyID : lstStudyIds) {
			System.out.println("STUDYID: " + studyID);
			Tab newTab = new Tab(studyMan.getStudyById(studyID).getName());
			Tabpanel tabPanel = new Tabpanel();

			Include include = new Include();

			include.setSrc("/user/managegermplasm/data.zul");
			include.setDynamicProperty("studyId", studyID);
			include.setDynamicProperty("dataset", null);
			include.setDynamicProperty("dataType", "rd");
			include.setDynamicProperty("GName", selectedGermplasm.getGermplasmname());

			tabPanel.appendChild(include);

			tabBox.getTabs().appendChild(newTab);
			tabBox.getTabpanels().appendChild(tabPanel);

		}

	}

}
