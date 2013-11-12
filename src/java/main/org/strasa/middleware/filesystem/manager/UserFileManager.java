package org.strasa.middleware.filesystem.manager;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.strasa.middleware.manager.StudyFileManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.UserManagerImpl;
import org.strasa.middleware.model.StudyFile;
import org.strasa.web.common.api.Encryptions;
import org.zkoss.zk.ui.Sessions;

public class UserFileManager {
	public static String FILE_TYPE_GENOTYPE = "GENOTYPE"; 
	public static String FILE_TYPE_PHENOTYPE = "PHENOTYPE";
	public static String BASE_PATH = Sessions.getCurrent().getWebApp().getRealPath("/UPLOADS/");
	
	public void createNewFileFromUpload(int userid, int studyid, String realName,File dataFile, String fileType){
		
		File BASE_FOLDER = new File(buildUserPath(userid, studyid));
		if(!BASE_FOLDER.exists()) BASE_FOLDER.mkdirs();
		File movedFile = new File(BASE_FOLDER.getAbsolutePath() + dataFile.getName());
		try {
			 FileUtils.moveFileToDirectory(dataFile, new File(BASE_FOLDER.getAbsolutePath() + "/"),true);
				movedFile.renameTo(new File(String.valueOf(  Calendar.getInstance().getTimeInMillis()+ realName)));
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		dataFile.renameTo(new File(BASE_FOLDER.getAbsolutePath() + dataFile.getName())); 
//		System.out.println("File moved to: " + BASE_FOLDER.getAbsolutePath());
		StudyFile fileRec = new StudyFile();
		fileRec.setFilename(realName);
		fileRec.setFilenamegen(dataFile.getName());
		fileRec.setFilepath(dataFile.getAbsolutePath());
		fileRec.setStudyid(studyid);
		fileRec.setTypeofdata(fileType);
		new StudyFileManagerImpl().addRecord(fileRec);
	}
	public String buildUserPath(int userid, int studyid){
		
		String userBasePath =  Encryptions.encryptStringToNumber(new UserManagerImpl().getUserById(userid).getUsername(),userid); 
		String studyBasePath;
		if(studyid == 0){
			studyBasePath = "tmp";
		}
		else{
			studyBasePath = Encryptions.encryptStringToNumber(new StudyManagerImpl().getStudyById(studyid).getName(), studyid);
		}
		
		return BASE_PATH + "/" + userBasePath + "/" + studyBasePath + "/" ;
	}
	
}
