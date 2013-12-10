package org.strasa.web.crossstudyquery.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.CrossStudyQueryManagerImpl;
import org.strasa.middleware.model.StudyVariable;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;

public class CrossStudyQuery extends StudyVariable{

	List<StudyVariable> variablelist;
	ArrayList<CrossStudyQueryFilterModel> crossStudyFilterModelList = new ArrayList<CrossStudyQueryFilterModel>();
	String variableValue;
	String studyVariable=null;
	String operator;
	private CrossStudyQueryManagerImpl mgr;


	public List<StudyVariable> getVariablelist() {
		return variablelist;
	}
	public void setVariablelist(ListModelList<StudyVariable> variablelist) {
		this.variablelist = variablelist;
	}
	public ArrayList<CrossStudyQueryFilterModel> getCrossStudyFilterModelList() {
		return crossStudyFilterModelList;
	}
	public void setCrossStudyFilterModelList(
			ArrayList<CrossStudyQueryFilterModel> crossStudyFilterModelList) {
		this.crossStudyFilterModelList = crossStudyFilterModelList;
	}



	public String getVariableValue() {
		return variableValue;
	}
	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}


	public String getStudyVariable() {
		return studyVariable;
	}
	public void setStudyVariable(String studyVariable) {
		this.studyVariable = studyVariable;
	}



	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Init
	public void init(){
		mgr= new CrossStudyQueryManagerImpl();
		this.variablelist= new ListModelList<StudyVariable>(mgr.getStudyVariable());

	}

	@Command
	@NotifyChange({"variablelist"})
	public void changeFilter(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view) {
		Bandbox variableSelected= (Bandbox) component.getFellow("studyVariable");
		if(variableSelected.getValue().length() > 0){
			this.variablelist= new ListModelList<StudyVariable>(mgr.getStudyVariableLike(variableSelected.getValue()));
		}else{
			this.variablelist= new ListModelList<StudyVariable>(mgr.getStudyVariable());
		}
	}


	@Command
	@NotifyChange({"crossStudyFilterModelList"})
	public void AddCriteria(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view) {
		Bandbox variableSelected= (Bandbox) component.getFellow("studyVariable");
		CrossStudyQueryFilterModel criteria = new CrossStudyQueryFilterModel();
		criteria.setVariable(variableSelected.getValue());
		criteria.setOperator(operator);
		criteria.setValueString(variableValue);

		this.crossStudyFilterModelList.add(criteria);

	}

	@Command
	@NotifyChange({"crossStudyFilterModelList"})
	public void reset(){
		this.crossStudyFilterModelList= new ArrayList<CrossStudyQueryFilterModel>();
	}

	@Command
	@NotifyChange({"crossStudyFilterModelList"})
	public void DeleteCriteria(@BindingParam("rowIndex") int index){
		this.crossStudyFilterModelList.remove(index);
	}


	@Command
	public void RunQuery(){

		final CrossStudyQueryManagerImpl crossStudyQueryManagerImpl= new CrossStudyQueryManagerImpl(); 

		ArrayList<CrossStudyQueryFilterModel> filters = new ArrayList<CrossStudyQueryFilterModel>();

		// Field

		CrossStudyQueryFilterModel fieldStudyId= new CrossStudyQueryFilterModel();
		fieldStudyId.setVariable("studyid");
		fieldStudyId.setColumnAs("field");
		filters.add(fieldStudyId);


		CrossStudyQueryFilterModel fieldDataRow= new CrossStudyQueryFilterModel();
		fieldDataRow.setVariable("datarow");
		fieldDataRow.setColumnAs("field");
		filters.add(fieldDataRow);

		CrossStudyQueryFilterModel fieldStudyName= new CrossStudyQueryFilterModel();
		fieldStudyName.setVariable("studyname");
		fieldStudyName.setColumnAs("field");
		filters.add(fieldStudyName);

		CrossStudyQueryFilterModel fieldGName= new CrossStudyQueryFilterModel();
		fieldGName.setVariable("GName");
		fieldDataRow.setColumnAs("field");
		filters.add(fieldGName);

		//Get Other Field
		int sizeFieldSelected=crossStudyFilterModelList.size();
		int counter=1;
		for(CrossStudyQueryFilterModel f:crossStudyFilterModelList){
			CrossStudyQueryFilterModel field= new CrossStudyQueryFilterModel();
			field.setVariable(f.getVariable());
			field.setColumnAs("field");
			if(counter==sizeFieldSelected){
				field.setOrderCriteria("last");
			}
			counter++;
			filters.add(field);
		}


		for(CrossStudyQueryFilterModel f:filters){

			System.out.println(f.getVariable());
			System.out.println(f.getOperator());
			System.out.println(f.orderCriteria);
			System.out.println(f.columnAs);
			System.out.println(f.valueDouble);
			System.out.println(f.valueString);
			System.out.println(f.valueString);
			System.out.println("-------------------");

		}



	}

}
