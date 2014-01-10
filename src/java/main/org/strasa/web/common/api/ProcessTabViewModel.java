package org.strasa.web.common.api;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;

public class ProcessTabViewModel {
	public boolean isRaw = true;
	public int studyID;
	private Component mainView;
	public boolean uploadToFolder = false;
	public int dataset = 1;
	public boolean isUpdateMode = false;
	public int userID = 1;
	public boolean isRaw() {
		return isRaw;
	}
	
	public boolean isDataReUploaded = false;
	
	
	public boolean isDataReUploaded() {
		return isDataReUploaded;
	}


	public void setDataReUploaded(boolean isDataReUploaded) {
		this.isDataReUploaded = isDataReUploaded;
	}


	public int getUserID() {
		return userID;
	}


	@Override
	public String toString() {
		return "ProcessTabViewModel [isRaw=" + isRaw + ", studyID=" + studyID
				+ ", mainView=" + mainView + ", uploadToFolder="
				+ uploadToFolder + ", dataset=" + dataset + ", isUpdateMode="
				+ isUpdateMode + ", userID=" + userID + ", isDataReUploaded="
				+ isDataReUploaded + "]";
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public void initValues(ProcessTabViewModel uploadModel){
		if(uploadModel == null){
			System.out.println("NULL");
			return;
		}
		isRaw = uploadModel.isRaw;
		uploadToFolder = uploadModel.uploadToFolder;
	    setStudyID(uploadModel.getStudyID());
		setUpdateMode(uploadModel.isUpdateMode);
		this.userID = uploadModel.userID;
		this.isDataReUploaded = uploadModel.isDataReUploaded;
		this.setDataset(uploadModel.getDataset());
		
	}

	public boolean isUpdateMode() {
		return isUpdateMode;
	}


	public void setUpdateMode(boolean isUpdateMode) {
		this.isUpdateMode = isUpdateMode;
	}


	public void setRaw(boolean isRaw) {
		this.isRaw = isRaw;
	}

	public boolean isUploadToFolder() {
		return uploadToFolder;
	}

	public void setUploadToFolder(boolean uploadToFolder) {
		this.uploadToFolder = uploadToFolder;
	}

	public int getDataset() {
		return dataset;
	}

	public void setDataset(int dataset) {
		this.dataset = dataset;
	}

	public void initSpecial(){
		
	}

	public Component getMainView() {
		return mainView;
	}

	public void setMainView(Component mainView) {
		this.mainView = mainView;
	}

	public boolean validateTab(){
		return false;
	}

	public int getStudyID() {
		return studyID;
	}

	public void setStudyID(int studyID) {
		this.studyID = studyID;
	}
}
