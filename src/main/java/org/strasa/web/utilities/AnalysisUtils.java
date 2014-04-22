package org.strasa.web.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.input.ReaderInputStream;
import org.spring.security.model.SecurityUtil;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

public class AnalysisUtils {

	private static final String FILE_SEPARATOR  = System.getProperty("file.separator");

	public static ListModelList<String> getNumericAsListModel(ArrayList<String> variableInfo) {
		// TODO Auto-generated method stub
		ListModelList<String> modelList = new ListModelList<String>();
		for(String s : variableInfo){
			if(s.contains(":Numeric")) modelList.add(s.split(":")[0]);
		}
		return modelList;
	}

	public static ListModelList<String> getFactorsAsListModel(ArrayList<String> variableInfo) {
		// TODO Auto-generated method stub
		ListModelList<String> modelList = new ListModelList<String>();
		for(String s : variableInfo){
			if(s.contains(":Factor")) modelList.add(s.split(":")[0]);
		}
		return modelList;
	}

	public static boolean isColumnNumeric(ArrayList<String> varInfo,
			String selectedItem) {
		// TODO Auto-generated method stub
		for(String s : varInfo){
			if(s.split(":")[0].equals(selectedItem) && s.contains("Numeric")) return true;
		}
		return false;
	}


	public static String getOutputFolderName(String fileName, String analysisType) {
		// TODO Auto-generated method stub
		String outputFolderName;
		if(analysisType.equals("ssa")) outputFolderName = "SingleSiteAnalysis" ;
		else outputFolderName = "unknown analysis";

		return new File(fileName).getName()+"("+ outputFolderName+"_"+getTimeStamp()+")";
	}
	
	public static String getTimeStamp() {
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		return Long.toString(now.getTimeInMillis());
	}
	
	public static String createOutputFolder(String fileName, String analysisType) {
		// TODO Auto-generated method stub
		String dataFileName = fileName.replaceAll(".csv", "");
		dataFileName = dataFileName.replaceAll(".tmp", "");
		
		String userFolderPath =  Sessions.getCurrent().getWebApp().getRealPath("resultanalysis")+ FILE_SEPARATOR +
				SecurityUtil.getDbUser().getUsername()+ FILE_SEPARATOR+ "Single-Site";

		String outputStudyPath = userFolderPath+ FILE_SEPARATOR + getOutputFolderName(dataFileName, analysisType) +FILE_SEPARATOR;
		
		if(createFolder(userFolderPath)){
			createFolder(outputStudyPath);
		}
		return outputStudyPath;
	}
	
	public static boolean createFolder(String folderPath){
		File outputFolder = new File(folderPath);
		
		if(outputFolder.exists()) return true;
		return outputFolder.mkdir();
	}

	public static ArrayList<String> getVarNames(ArrayList<String> varInfo) {
		// TODO Auto-generated method stub
		ArrayList<String> modelList = new ArrayList<String>();
		for(String s : varInfo){
			modelList.add(s.split(":")[0]);
		}
		return modelList;
	}
}