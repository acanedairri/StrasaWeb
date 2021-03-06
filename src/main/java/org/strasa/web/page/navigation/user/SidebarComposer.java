package org.strasa.web.page.navigation.user;

import org.zkforge.json.simple.JSONObject;
import org.zkforge.json.simple.JSONValue;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;

public class SidebarComposer extends SelectorComposer<Component> {

	@Wire
	Hlayout main;
	@Wire
	Div sidebar;
	@Wire
	Div contentui;
	@Wire
	Navbar navbar;
	@Wire
	Navitem calitem;
	@Wire
	A toggler;

	@Wire
	Navitem releaseinfo;
	@Wire
	Navitem extension;

	@Wire
	Navitem browsegermplasm;
	@Wire
	Navitem browsestudy;

	@Wire
	Navitem uploadstudy;

	@Wire
	Navitem uploadgermplasm;

	@Wire
	Navitem uploadextension;

	@Wire
	Navitem uploadrelease;

	@Wire
	Navitem singlesite;

	@Wire
	Navitem multisite;
	
	@Wire
	Navitem linkagemapping;

	@Wire
	Navitem settings;

	@Wire
	Navitem createfieldbook;

	@Wire
	Navitem browseanalysisresult;

	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		comp.getFellow("sidebar").addEventListener("onNavigate", new EventListener() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub
				Object obj = JSONValue.parse(arg0.getData().toString());
				JSONObject array = (JSONObject) obj;

				System.out.println("CurrUrl:" + array.get("hashbang").toString().replace("/", ""));
				String compid = array.get("hashbang").toString().replace("/", "");
				if (!sidebar.hasFellow(compid))
					return;
				Navitem currClick = (Navitem) sidebar.getFellow(compid);

				if (currClick != null) {
					Events.postEvent("onClick", currClick, null);
				}
			}
		});
		Clients.evalJavaScript("loadContent();");
	}

	// Toggle sidebar to collapse or expand
	@Listen("onClick = #toggler")
	public void toggleSidebarCollapsed() {
		if (navbar.isCollapsed()) {
			sidebar.setSclass("sidebar");
			navbar.setCollapsed(false);
			calitem.setTooltip("calpp, position=end_center, delay=0");
			toggler.setIconSclass("z-icon-angle-double-left");
		} else {
			sidebar.setSclass("sidebar sidebar-min");
			navbar.setCollapsed(true);
			calitem.setTooltip("");
			toggler.setIconSclass("z-icon-angle-double-right");
		}
		// Force the hlayout contains sidebar to recalculate its size
		Clients.resize(sidebar.getRoot().query("#main"));
	}

	@Listen("onClick = #browsestudy")
	public void browseStudy() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/browsestudy/index.zul", d, null);

	}

	@Listen("onClick = #across")
	public void browseAcrossStudy() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/crossstudyquery/index.zul", d, null);

	}

	@Listen("onClick = #browsegermplasm")
	public void browseGermplasm() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/browsegermplasm/index.zul", d, null);

	}

	@Listen("onClick = #releaseinfo")
	public void browseReleaseinfo() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/releaseinfo/index.zul", d, null);

	}

	@Listen("onClick = #extension")
	public void browseExtension() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/distributionandextension/index.zul", d, null);

	}

	@Listen("onClick = #uploadstudy")
	public void uploadstudy() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/maintenance/edituploadedstudies.zul", d, null);

	}

	@Listen("onClick = #uploadgermplasm")
	public void uploadgermplasm() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/managegermplasm/index.zul", d, null);

	}

	@Listen("onClick = #uploadextension")
	public void uploadextension() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/distributionandextension/editdistributionandextension.zul", d, null);

	}

	@Listen("onClick = #uploadrelease")
	public void uploadrelease() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/releaseinfo/editreleaseinfo.zul", d, null);

	}

	@Listen("onClick = #singlesite")
	public void singlesite() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/analysis/singlesite/index.zul", d, null);
	}
	
	@Listen("onClick = #multisite")
	public void multisite() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/analysis/multisite/index.zul", d, null);
	}

	@Listen("onClick = #linkagemapping")
	public void linkagemapping() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/analysis/linkagemapping/index.zul", d, null);
	}
	@Listen("onClick = #geneticsimilarity")
	public void geneticsimilarity() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/analysis/geneticsimilarity/index.zul", d, null);
	}
	@Listen("onClick = #gblup")
	public void gblup() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/analysis/genomicsselection/gblup/index.zul", d, null);
	}
	@Listen("onClick = #bayesian")
	public void bayesian() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/analysis/genomicsselection/bayesian/index.zul", d, null);
	}
	@Listen("onClick = #settings")
	public void settings() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/maintenance/index.zul", d, null);
	}

	@Listen("onClick = #createfieldbook")
	public void createfieldbook(){
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/createfieldbook/index.zul", d, null);
	}

	@Listen("onClick = #browseanalysisresult")
	public void browseanalysisresult() {
		Div d = (Div) sidebar.getRoot().query("#contentui");
		d.getChildren().clear();
		Executions.createComponents("../user/analysis/resultanalysistree.zul", d, null);
	}

}