package org.strasa.web.browsestudy.view.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.strasa.middleware.manager.StudyFileManagerImpl;
import org.strasa.middleware.model.StudyFile;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Messagebox;

public class FilesData {
	private StudyFileManagerImpl studyFileMan;

	private  List<StudyFile> files = new  ArrayList<StudyFile>() ;
	
	private String dataType="fd"; // genotypic data
	
	public FilesData() {
		// TODO Auto-generated constructor stub
	}


	public List<StudyFile> getFiles() {
		return files;
	}

	public void setFiles(List<StudyFile> files) {
		this.files = files;
	}
	
	@Init
	public void init(@ExecutionArgParam("studyid") Integer studyId){
		
		studyFileMan = new StudyFileManagerImpl();

		setFiles(studyFileMan.getFileByStudyIdAndDataType(studyId, dataType));
	}
	
	@GlobalCommand
	public void downloadFile(@BindingParam("filePath")String filePath,@BindingParam("dataType") String dataType){
		FileInputStream inputStream;
        try {
        	String repSrcPath = Sessions.getCurrent().getWebApp().getRealPath(filePath);
            File file = new File(repSrcPath);
            if (file.exists()) {
                inputStream = new FileInputStream(file);
                Filedownload.save(inputStream, new MimetypesFileTypeMap().getContentType(file), extractFileName(file,dataType));
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}


	private String extractFileName(File file, String dataType) {
		String extractedFileName;
		
		if(dataType.equals("dd") || dataType.equals("rd")) extractedFileName=(file.getName().split(".csv")[0])+".csv";
		else extractedFileName=(file.getName().split(".txt")[0])+".txt";

		return extractedFileName;
	}


	public String getDataType() {
		return dataType;
	}


	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
