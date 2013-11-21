package org.strasa.web.browsestudy.view.model;

import java.util.List;

import org.strasa.middleware.manager.StudyFileManagerImpl;
import org.strasa.middleware.model.StudyFile;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

public class GenotypicData {
	private StudyFileManagerImpl studyFileMan;

	private  List<StudyFile> genotypicFiles;
	
	public GenotypicData() {
		// TODO Auto-generated constructor stub
	}

	@Init
	public void init(@ExecutionArgParam("studyid") Integer studyId){
		
		studyFileMan = new StudyFileManagerImpl();
		
		setGenotypicFiles(studyFileMan.getFileByStudyIdAndDataType(studyId, "gd"));
	}

	public List<StudyFile> getGenotypicFiles() {
		return genotypicFiles;
	}

	public void setGenotypicFiles(List<StudyFile> genotypicFiles) {
		this.genotypicFiles = genotypicFiles;
	}
}
