package org.strasa.web.data.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.model.StudyVariable;

public class VariableListData {

	public List<VariableModel> mailData = new ArrayList<VariableModel>();
	
	
	public List<VariableModel> getMailData()  {
		return mailData;
	}
	public void setDataList(List<VariableModel> dataList) {
		this.mailData = dataList;
	}
	public VariableListData(){
	
	}
	public VariableListData(String[] initVal){
		for(String val : initVal){
			mailData.add(new VariableModel(val,"-"));
		}
	}
	

	public class VariableModel {
		
		private String currentVariable;
		private String newVariable;
		
		public String getCurrentVariable() {
			return currentVariable;
		}

		public void setCurrentVariable(String currentVariable) {
			this.currentVariable = currentVariable;
		}

		public String getNewVariable() {
			return newVariable;
		}

		public void setNewVariable(String newVariable) {
			this.newVariable = newVariable;
		}

		public VariableModel(String curr, String newVar){
			currentVariable = curr;
			newVariable = newVar;
		}
		
	}

}
