package org.strasa.web.analysis.singlesite.view.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
 
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
    private Listbox candidateLb;
    @Wire
    private Listbox chosenLb;
 
    private ListModelList<String> candidateModel;
    private ListModelList<String> chosenDataModel;
 
    public VariableListBoxes() {
//        Executions.createComponents("/widgets/listbox/dual_listbox/v_dualListbox.zul", this, null);
//        Selectors.wireComponents(this, this, false);
//        Selectors.wireEventListeners(this, this);
//        chosenLb.setModel(chosenDataModel = new ListModelList<String>());
    }
 
    @Listen("onClick = #chooseBtn")
    public void chooseItem() {
        Events.postEvent(new ChooseEvent(this, chooseOne()));
    }
 
    @Listen("onClick = #removeBtn")
    public void unchooseItem() {
        Events.postEvent(new ChooseEvent(this, unchooseOne()));
    }
 
    @Listen("onClick = #chooseAllBtn")
    public void chooseAllItem() {
        for (int i = 0, j = candidateModel.getSize(); i < j; i++) {
            chosenDataModel.add(candidateModel.getElementAt(i));
        }
        candidateModel.clear();
    }
 
    @Listen("onClick = #removeAllBtn")
    public void unchooseAll() {
        for (int i = 0, j = chosenDataModel.getSize(); i < j; i++) {
            candidateModel.add(chosenDataModel.getElementAt(i));
        }
        chosenDataModel.clear();
    }
 
    @Listen("onClick = #topBtn")
    public void top() {
        int i = 0;
        Iterator<String> iterator = new LinkedHashSet<String>(chosenDataModel.getSelection()).iterator();
        while (iterator.hasNext()) {
            String selectedItem = iterator.next();
            chosenDataModel.remove(selectedItem);
            chosenDataModel.add(i++, selectedItem);
            chosenDataModel.addToSelection(selectedItem);
        }
    }
 
    @Listen("onClick = #upBtn")
    public void up() {
        Set<String> selected = chosenDataModel.getSelection();
        if (selected.isEmpty())
            return;
        int index = chosenDataModel.indexOf(selected.iterator().next());
        if (index == 0 || index < 0)
            return;
        String selectedItem = chosenDataModel.get(index);
        chosenDataModel.remove(selectedItem);
        chosenDataModel.add(--index, selectedItem);
        chosenDataModel.addToSelection(selectedItem);
 
    }
 
    @Listen("onClick = #downBtn")
    public void down() {
        Set<String> selected = chosenDataModel.getSelection();
        if (selected.isEmpty())
            return;
        int index = chosenDataModel.indexOf(selected.iterator().next());
        if (index == chosenDataModel.size() - 1 || index < 0)
            return;
        String selectedItem = chosenDataModel.get(index);
        chosenDataModel.remove(selectedItem);
        chosenDataModel.add(++index, selectedItem);
        chosenDataModel.addToSelection(selectedItem);
    }
 
    @Listen("onClick = #bottomBtn")
    public void bottom() {
        Iterator<String> iterator = new LinkedHashSet<String>(chosenDataModel.getSelection()).iterator();
        while (iterator.hasNext()) {
            String selectedItem = iterator.next();
            chosenDataModel.remove(selectedItem);
            chosenDataModel.add(selectedItem);
            chosenDataModel.addToSelection(selectedItem);
        }
    }
 
    /**
     * Set new candidate ListModelList.
     * 
     * @param candidate
     *            is the data of candidate list model
     */
    public void setModel(List<String> candidate) {
        candidateLb.setModel(this.candidateModel = new ListModelList<String>(candidate));
        chosenDataModel.clear();
    }
 
    /**
     * @return current chosen data list
     */
    public List<String> getChosenDataList() {
        return new ArrayList<String>(chosenDataModel);
    }
 
    private Set<String> chooseOne() {
        Set<String> set = candidateModel.getSelection();
        for (String selectedItem : set) {
            chosenDataModel.add(selectedItem);
            candidateModel.remove(selectedItem);
        }
        return set;
    }
 
    private Set<String> unchooseOne() {
        Set<String> set = chosenDataModel.getSelection();
        for (String selectedItem : set) {
            candidateModel.add(selectedItem);
            chosenDataModel.remove(selectedItem);
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
