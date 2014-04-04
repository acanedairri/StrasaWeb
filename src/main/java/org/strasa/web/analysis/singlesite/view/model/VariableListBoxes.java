package org.strasa.web.analysis.singlesite.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.analysis.rserve.manager.RServeManager;
import org.strasa.web.utilities.AnalysisUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;


public class VariableListBoxes{
	
	//Managers
	private RServeManager rServeMgr;
	
	//Zul file components
	@Wire
	private Button chooseResponseBtn;
	
	private Listbox numericLb;
	private Listbox responseLb;
	private Listbox factorLb;
	

	//DataModels
	private ListModelList<String> numericModel;
	private ListModelList<String> responseModel;
	private ListModelList<String> factorModel;

	//Rserve Parameters
	private int fileFormat=1;
	private String separator="NULL";;
	private String tempFileName;
	private String fileName=System.getProperty("user.dir")+ System.getProperty("file.separator") + "sample_datasets" + System.getProperty("file.separator") + "RCB_ME.csv";

	//Class Variables
	private ArrayList<String> varInfo;

	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireEventListeners(view, this);
		
		numericLb = (Listbox) component.getFellow("numericLb");
		responseLb = (Listbox) component.getFellow("responseLb");
		factorLb = (Listbox) component.getFellow("factorLb");
		
		Div otherVarsDiv = (Div) component.getFellow("othervariables");
//		
//		Tabpanel newPanel = new Tabpanel();
//		Tab newTab = new Tab();
//		newTab.setLabel("Study List");
		
		//initialize view after view construction.
		Include includeOtherVars = new Include();
		includeOtherVars.setParent(otherVarsDiv);
		includeOtherVars.setDynamicProperty("factorModel", factorModel);
		includeOtherVars.setSrc("/user/analysis/singlesite/othervars.zul");
		
	}
	
	@GlobalCommand("setSsaListvariables")
	@NotifyChange("*")
	public void setSsaListvariables(@BindingParam("filePath")String filepath){
	    //...

		rServeMgr = new RServeManager();
		varInfo = rServeMgr.getVariableInfo(filepath.replace("\\", "/"), fileFormat, separator);
		
		numericModel= AnalysisUtils.getNumericAsListModel(varInfo);
		factorModel= AnalysisUtils.getFactorsAsListModel(varInfo);
		responseModel = new ListModelList<String>();
		
		numericLb.setModel(numericModel);
		factorLb.setModel(factorModel);
		responseLb.setModel(responseModel);
		
	}
	
	@Listen("onClick = #chooseResponseBtn")
	@NotifyChange("*")
	public void addResponse(MouseEvent event) {
		chooseResponseVariable();
	}

	@Listen("onClick = #removeResponseBtn")
	@NotifyChange("*")
	public void removeResponse(MouseEvent event) {
		unchooseResponseVariable();
	}

	@Listen("onClick = #toNumericBtn")
	@NotifyChange("*")
	public void up() {
		toNumeric();
	}
	@Listen("onClick = #toFactorBtn")
	@NotifyChange("*")
	public void down() {
		toFactor();
	}

	/**
	 * Set new numeric ListModelList.
	 * 
	 * @param numeric
	 *            is the data of numeric list model
	 */
	public void setModel(List<String> numeric) {
		numericLb.setModel(this.numericModel = new ListModelList<String>(numeric));
		responseModel.clear();
	}

	/**
	 * @return current response data list
	 */
	public List<String> getresponseDataList() {
		return new ArrayList<String>(responseModel);
	}


	private void toFactor() {
		// TODO Auto-generated method stub
		
		Set<String> set = numericModel.getSelection();
		for (String selectedItem : set) {
			factorModel.add(selectedItem);
			numericModel.remove(selectedItem);
		}
		
//		if (selected.isEmpty())
//			return;
//		int index = numericModel.indexOf(selected.iterator().next());
//		if (index == numericModel.size() - 1 || index < 0)
//			return;
//		String selectedItem = numericModel.get(index);
//		numericModel.remove(selectedItem);
//		factorModel.add(++index, selectedItem);
//		factorModel.addToSelection(selectedItem);
	}

	private void toNumeric() {
		// TODO Auto-generated method stub
		Set<String> set = factorModel.getSelection();
		fileName = fileName.replace("\\", "/");
		for (String selectedItem : set) {
			if (AnalysisUtils.isColumnNumeric(varInfo, selectedItem)){
			numericModel.add(selectedItem);
			factorModel.remove(selectedItem);
			}
			else{
				Messagebox.show("Can't move variable.\n"+selectedItem+ " is not Numeric.");
				System.out.println("Not Numeric");
			}
		}
//		if (selected.isEmpty())
//			return;
//		int index = factorModel.indexOf(selected.iterator().next());
//		if (index == 0 || index < 0)
//			return;
//		String selectedItem = factorModel.get(index);
//		factorModel.remove(selectedItem);
//		numericModel.add(--index, selectedItem);
//		numericModel.addToSelection(selectedItem);

	}

	
	private void chooseResponseVariable() {
		Set<String> set = numericModel.getSelection();
//		System.out.println("addResponse");
		for (String selectedItem : set) {
			responseModel.add(selectedItem);
			numericModel.remove(selectedItem);
		}
	}

	private void unchooseResponseVariable() {
		Set<String> set = responseModel.getSelection();
//		System.out.println("removeResponse");
		for (String selectedItem : set) {
			numericModel.add(selectedItem);
			responseModel.remove(selectedItem);
		}
	}

	// Customized Event
	public class ChooseEvent extends Event {
		private static final long serialVersionUID = -7334906383953342976L;

		public ChooseEvent(Component target, Set<String> data) {
			super("onChoose", target, data);
		}
	}
	
}
