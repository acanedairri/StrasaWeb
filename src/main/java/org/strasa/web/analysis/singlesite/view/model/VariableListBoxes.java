package org.strasa.web.analysis.singlesite.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;


public class VariableListBoxes extends Div implements IdSpace {
	private static final long serialVersionUID = 5183321186606483396L;

	@Wire
	private Listbox numericLb;
	@Wire
	private Listbox responseLb;

	@Wire
	private Listbox factorLb;

	private ListModelList<String> numericModel;
	private ListModelList<String> responseDataModel;

	@Init
	public void init(){
//		numericModel = ;
//		responseDataModel = ;
//		
//		Selectors.wireComponents(this, this, false);
//		Selectors.wireEventListeners(this, this);

		//        typeOfDualBox = kind;
		//        if(list2.size()==0){
			//            // dualListBoxFactory is a spring factory which created the right list of handled objects.
		//            list2.addAll(dualListBoxFactory.findAllForType(kind));
		//        }
	}

	@Listen("onClick = #chooseResponseBtn")
	public void chooseItem() {
		Events.postEvent(new ChooseEvent(this, chooseOne()));
	}

	@Listen("onClick = #removeResponseBtn")
	public void unchooseItem() {
		Events.postEvent(new ChooseEvent(this, unchooseOne()));
	}

	@Listen("onClick = #chooseAllBtn")
	public void chooseAllItem() {
		for (int i = 0, j = numericModel.getSize(); i < j; i++) {
			responseDataModel.add(numericModel.getElementAt(i));
		}
		numericModel.clear();
	}

	@Listen("onClick = #removeAllBtn")
	public void unchooseAll() {
		for (int i = 0, j = responseDataModel.getSize(); i < j; i++) {
			numericModel.add(responseDataModel.getElementAt(i));
		}
		responseDataModel.clear();
	}

	@Listen("onClick = #topBtn")
	public void top() {
		int i = 0;
		Iterator<String> iterator = new LinkedHashSet<String>(responseDataModel.getSelection()).iterator();
		while (iterator.hasNext()) {
			String selectedItem = iterator.next();
			responseDataModel.remove(selectedItem);
			responseDataModel.add(i++, selectedItem);
			responseDataModel.addToSelection(selectedItem);
		}
	}

	@Listen("onClick = #upBtn")
	public void up() {
		Set<String> selected = responseDataModel.getSelection();
		if (selected.isEmpty())
			return;
		int index = responseDataModel.indexOf(selected.iterator().next());
		if (index == 0 || index < 0)
			return;
		String selectedItem = responseDataModel.get(index);
		responseDataModel.remove(selectedItem);
		responseDataModel.add(--index, selectedItem);
		responseDataModel.addToSelection(selectedItem);

	}

	@Listen("onClick = #downBtn")
	public void down() {
		Set<String> selected = responseDataModel.getSelection();
		if (selected.isEmpty())
			return;
		int index = responseDataModel.indexOf(selected.iterator().next());
		if (index == responseDataModel.size() - 1 || index < 0)
			return;
		String selectedItem = responseDataModel.get(index);
		responseDataModel.remove(selectedItem);
		responseDataModel.add(++index, selectedItem);
		responseDataModel.addToSelection(selectedItem);
	}

	@Listen("onClick = #bottomBtn")
	public void bottom() {
		Iterator<String> iterator = new LinkedHashSet<String>(responseDataModel.getSelection()).iterator();
		while (iterator.hasNext()) {
			String selectedItem = iterator.next();
			responseDataModel.remove(selectedItem);
			responseDataModel.add(selectedItem);
			responseDataModel.addToSelection(selectedItem);
		}
	}

	/**
	 * Set new numeric ListModelList.
	 * 
	 * @param numeric
	 *            is the data of numeric list model
	 */
	public void setModel(List<String> numeric) {
		numericLb.setModel(this.numericModel = new ListModelList<String>(numeric));
		responseDataModel.clear();
	}

	/**
	 * @return current response data list
	 */
	public List<String> getresponseDataList() {
		return new ArrayList<String>(responseDataModel);
	}

	private Set<String> chooseOne() {
		Set<String> set = numericModel.getSelection();
		System.out.println("addResponse");
		for (String selectedItem : set) {
			responseDataModel.add(selectedItem);
			numericModel.remove(selectedItem);
		}
		return set;
	}

	private Set<String> unchooseOne() {
		Set<String> set = responseDataModel.getSelection();
		System.out.println("removeResponse");
		for (String selectedItem : set) {
			numericModel.add(selectedItem);
			responseDataModel.remove(selectedItem);
		}
		return set;
	}

	// Customized Event
	public class ChooseEvent extends Event {
		private static final long serialVersionUID = -7334906383953342976L;

		public ChooseEvent(Component target, Set<String> data) {
			super("onChoose", target, data);
		}
	}
}
