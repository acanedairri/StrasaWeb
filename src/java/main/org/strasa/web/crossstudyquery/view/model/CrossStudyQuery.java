package org.strasa.web.crossstudyquery.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.CrossStudyQueryManagerImpl;
import org.strasa.middleware.model.StudyVariable;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class CrossStudyQuery extends StudyVariable{

	List<StudyVariable> variablelist;
	ArrayList<CrossStudyQueryFilterModel> crossStudyFilterModelList;
	String variableValue;
	String studyVariable;
	private CrossStudyQueryManagerImpl mgr;


	public List<StudyVariable> getVariablelist() {
		return variablelist;
	}
	public void setVariablelist(List<StudyVariable> variablelist) {
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

	@Init
	public void init(){
		mgr= new CrossStudyQueryManagerImpl();
		this.variablelist= mgr.getStudyVariable();

	}

	@Command
	@NotifyChange({"variablelist"})
	public void changeFilter(@BindingParam("variable") String variable) {
		this.variablelist= (ArrayList<StudyVariable>) mgr.getStudyVariableLike(variable);
	}


}
