package org.strasa.web.uploadstudy.view.pojos;

import java.util.Arrays;
import java.util.List;

public class UploadCSVDataVariableModel {
	
	private String currentVariable;
	private String newVariable;
	private boolean isHeaderExisting = false;
	List<String> systemHeader = Arrays.asList("GName","Site","Location","Season","Year");
	public boolean modified;
	public boolean isEditable() {
		if(systemHeader.contains(currentVariable)) return false;
		
		return true;
	}

	
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

	public boolean isHeaderExisting() {
		return isHeaderExisting;
	}

	public void setHeaderExisting(boolean isHeaderExisting) {
		this.isHeaderExisting = isHeaderExisting;
	}

	public UploadCSVDataVariableModel(String curr, String newVar){
		currentVariable = curr;
		newVariable = newVar;
	}
	public UploadCSVDataVariableModel(String curr, String newVar,boolean ex){
		currentVariable = curr;
		newVariable = newVar;
		isHeaderExisting = ex;
	}
}
