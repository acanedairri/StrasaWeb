package org.strasa.web.extensiondata.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.CountryManagerImpl;
import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.strasa.middleware.manager.GermplasmManagerImpl;
import org.strasa.middleware.manager.LocationManagerImpl;
import org.strasa.middleware.manager.StudyLocationManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.ExtensionData;
import org.strasa.middleware.model.Location;
import org.strasa.web.uploadstudy.view.model.AddLocation;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


public class EditExtensionData {
	ExtensionDataManagerImpl man;
	StudySiteManagerImpl studySiteMan;
	List<RowStatus> rowList = new ArrayList<RowStatus>(); 
	private ArrayList<String> cmbCountry = new ArrayList<String>(); 

	public List<RowStatus> getRowList() {
		return rowList;
	}

	public void setRowList(List<RowStatus> rowList) {
		this.rowList = rowList;
	}

	@AfterCompose
	public void init(@ContextParam(ContextType.VIEW) Component view){
		man = new ExtensionDataManagerImpl();
		studySiteMan = new StudySiteManagerImpl();
		makeRowStatus(man.getAllExtensionData());

		List<Country> lCountries = new CountryManagerImpl().getAllCountry();
		for (Country data : lCountries) {
			cmbCountry.add(data.getIsoabbr());
		}
	}

	private void makeRowStatus(List<ExtensionData> list) {
		// TODO Auto-generated method stub

		rowList.clear();
		for (ExtensionData p: list){
			RowStatus ps = new RowStatus(p,false);
			rowList.add(ps);
		}
	}

	@Command
	public void changeEditableStatus(@BindingParam("RowStatus") RowStatus ps) {
		ps.setEditingStatus(!ps.getEditingStatus());
		refreshRowTemplate(ps);
	}

	@Command
	public void confirm(@BindingParam("RowStatus") RowStatus ps) {
		changeEditableStatus(ps);
		refreshRowTemplate(ps);
		man.updateExtensionData(ps.getValue());
		Messagebox.show("Changes saved.");
	}

	public void refreshRowTemplate(RowStatus ps) {
		/*
		 * This code is special and notifies ZK that the bean's value
		 * has changed as it is used in the template mechanism.
		 * This stops the entire Grid's data from being refreshed
		 */
		BindUtils.postNotifyChange(null, null, ps, "editingStatus");
	}

	@NotifyChange("rowList")
	@Command("delete")
	public void delete(@BindingParam("id") Integer Id){
		//		if(studySiteMan.getSiteByEcotypeId(Id).isEmpty()){
		man.deleteById(Id);
		makeRowStatus(man.getAllExtensionData());
		Messagebox.show("Changes saved.");
		//		} else  Messagebox.show("Cannot delete an extension data that is in use.", "Error", Messagebox.OK, Messagebox.ERROR); 
	}

	//	@NotifyChange("list")
	@Command("add")
	public void add(@ContextParam(ContextType.COMPONENT) Component component) {
		Window win = (Window) component.getFellow("editExtensionWindow");
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar", null);

		Window popup = (Window) Executions.createComponents(
				AddExtensionData.ZUL_PATH, win, params);

		popup.doModal();
	}

	@NotifyChange("rowList")
	@Command("refreshList")
	public void refreshList() {
		makeRowStatus(man.getAllExtensionData());
	}


	public ArrayList<String> getCmbCountry() {
		return cmbCountry;
	}

	public void setCmbCountry(ArrayList<String> cmbCountry) {
		this.cmbCountry = cmbCountry;
	}


	public class RowStatus {
		private  ExtensionData value;
		private boolean editingStatus;

		public RowStatus(ExtensionData p, boolean editingStatus) {
			this.setValue(p);
			this.editingStatus = editingStatus;
		}


		public boolean getEditingStatus() {
			return editingStatus;
		}

		public void setEditingStatus(boolean editingStatus) {
			this.editingStatus = editingStatus;
		}


		public ExtensionData getValue() {
			return value;
		}


		public void setValue(ExtensionData p) {
			this.value = p;
		}
	}
}