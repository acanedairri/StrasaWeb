package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Timer;

import com.mysql.jdbc.StringUtils;

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

	@Wire("#tabpanel1")
	Tabpanel tabpanel1;
	@Wire("#tabpanel2")
	Tabpanel tabpanel2;
	@Wire("#tabpanel3")
	Tabpanel tabpanel3;
	@Wire("#tabpanel4")
	Tabpanel tabpanel4;
	@Wire("#tabpanel5")
	Tabpanel tabpanel5;

	ArrayList<Tabpanel> arrTabPanels = new ArrayList<Tabpanel>();
	private UploadData uploadData;
	private int selectedIndex = 1;
	private boolean[] tabDisabled = { false, true, true, true, true };

	private ProcessTabViewModel uploadModel;

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

	@Init
	public void init() {
		// editing mode
		uploadModel = new ProcessTabViewModel();

		if (!StringUtils.isNullOrEmpty(Executions.getCurrent().getParameter("studyid"))) {
			uploadModel.setStudyID(Integer.parseInt(Executions.getCurrent().getParameter("studyid")));
			uploadModel.setUpdateMode(true);
			tabDisabled[0] = false;
			tabDisabled[1] = false;
			tabDisabled[2] = false;
			tabDisabled[3] = false;
			tabDisabled[4] = false;
		}
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) final Component view) {

		Selectors.wireComponents(view, this, false);

		// wire event listener
		// Selectors.wireEventListeners(view, this);

//		arrTabPanels.add(tabpanel1); 

		arrTabPanels.add(tabpanel2);

		arrTabPanels.add(tabpanel3);

		arrTabPanels.add(tabpanel4);

		arrTabPanels.add(tabpanel5);
//		selectedIndex = 0;
		
		Timer timer = new Timer(10);
		timer.setRepeats(false);
		timer.setPage(view.getPage());
		timer.addEventListener("onTimer", new EventListener() {
			public void onEvent(Event event) throws Exception {
				Events.sendEvent("onSelect", view.getFellow("tab6"), view.getFellow("tab6"));
				System.out.println("SELECT");
				selectedIndex = 0;

			}
		});
		

	}

	@NotifyChange("*")
	@GlobalCommand("disableTabs")
	public void disableTabs() {
		tabDisabled[0] = false;
		tabDisabled[1] = true;
		tabDisabled[2] = true;
		tabDisabled[3] = true;
		tabDisabled[4] = true;
		System.out.println("Disabled Tabs Called");
	}

	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName, @BindingParam("target") Tabpanel panel) {
		System.out.println(zulFileName);
		if (panel != null && panel.getChildren().isEmpty()) {
			Map arg = new HashMap();
			arg.put("uploadModel", uploadModel);

			Executions.createComponents(zulFileName, panel, arg);

		}
	}

	@NotifyChange("*")
	@GlobalCommand("nextTab")
	public void nextTab(@BindingParam("model") ProcessTabViewModel uploadData) {

		if (!uploadData.validateTab()) {
			return;
		}
		if (selectedIndex == 0) {
			
			uploadModel = uploadData;
			System.out.println("IsRaw: " + uploadData.isDataReUploaded + " ");

		}
		if (uploadData.uploadToFolder) {
			selectedIndex = 3;
		}

		if (selectedIndex + 1 < arrTabPanels.size()) {

			arrTabPanels.get(selectedIndex + 1).getChildren().clear();
		}

		// System.out.println("Sample: " + uploadData.getTxtProject());

		// selectedIndex++;

		tabDisabled[selectedIndex + 1] = false;
		if (uploadData.uploadToFolder) {
			selectedIndex = 3;
		}
		Tab[] tabs = { tab1, tab2, tab3, tab4, tab5 };

		Events.sendEvent("onSelect", tabs[selectedIndex + 1], tabs[selectedIndex + 1]);
		System.out.println("INDEX: " + selectedIndex);
		if (uploadData.uploadToFolder) {
			tabDisabled[4] = false;
			System.out.println("FINISH LOADED: ");
			Events.sendEvent("onSelect", tab5, tab5);

			Events.sendEvent("onSelect", tab5, tab5);

			Events.sendEvent("onSelect", tab5, tab5);
			tab5.setDisabled(false);
			tab5.setSelected(true);
			Events.sendEvent(new Event("onSelect", tab5, null));
			return;
		}
		selectedIndex++;

	}

	@NotifyChange("*")
	public void changeTab() {
		System.out.println("Called to change tab");
		selectedIndex++;
	}
}
