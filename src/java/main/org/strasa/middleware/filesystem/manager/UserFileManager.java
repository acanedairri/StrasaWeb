package org.strasa.middleware.filesystem.manager;

import java.io.File;

import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.UserManagerImpl;
import org.strasa.web.common.api.Encryptions;
import org.zkoss.zk.ui.Sessions;

public class UserFileManager {
	public static String BASE_PATH = Sessions.getCurrent().getWebApp().getRealPath("/UPLOADS/");
	
	public void createNewFileFromUpload(int userid, int studyid, File dataFile){
		
		File BASE_FOLDER = new File(buildUserPath(userid, studyid));
		if(!BASE_FOLDER.exists()) BASE_FOLDER.mkdirs();
		dataFile.renameTo(new File(BASE_FOLDER.getAbsolutePath() + dataFile.getName())); 
		
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
		
		return BASE_PATH + "/" + userBasePath + "/" + studyBasePath;
	}
	
}
