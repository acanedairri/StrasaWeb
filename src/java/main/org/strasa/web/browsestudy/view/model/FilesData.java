package org.strasa.web.browsestudy.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.StudyFileManagerImpl;
import org.strasa.middleware.model.StudyFile;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

public class FilesData {
	private StudyFileManagerImpl studyFileMan;

	private  List<StudyFile> files = new  ArrayList<StudyFile>() ;
	
	public FilesData() {
		// TODO Auto-generated constructor stub
	}

	@Init
	public void init(@ExecutionArgParam("studyid") Integer studyId){
		
		studyFileMan = new StudyFileManagerImpl();

		setFiles(studyFileMan.getFileByStudyIdAndDataType(studyId, "fd"));
	}

	public List<StudyFile> getFiles() {
		return files;
	}

	public void setFiles(List<StudyFile> files) {
		this.files = files;
	}
}
