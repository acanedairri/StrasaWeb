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
	public int dataset = 0;
	
	public boolean isRaw() {
		return isRaw;
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
