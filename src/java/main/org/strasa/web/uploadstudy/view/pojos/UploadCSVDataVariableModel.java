package org.strasa.web.uploadstudy.view.pojos;

public class UploadCSVDataVariableModel {
	
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

	public UploadCSVDataVariableModel(String curr, String newVar){
		currentVariable = curr;
		newVariable = newVar;
	}
	
}
