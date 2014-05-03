package org.strasa.web.analysis.view;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.analysis.rserve.manager.RServeManager;
import org.spring.security.model.SecurityUtil;
import org.strasa.web.analysis.view.model.SingleSiteAnalysisModel;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

public class ResultViewer {	
	private RServeManager rServeManager;
	String textFileContent = null;
	private static final String FILE_SEPARATOR  = System.getProperty("file.separator");
	private static String RESULT_ANALYSIS_PATH=FILE_SEPARATOR+"resultanalysis"+FILE_SEPARATOR+SecurityUtil.getUserName()+FILE_SEPARATOR+"Single-Site"+FILE_SEPARATOR;

	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("outputFolderPath") String outputFolderPath){

		System.out.println("outputFolder REsult Analysis:" + outputFolderPath);
		
		//outputTextViewer
		File outputFolder = new File(outputFolderPath);
		if(outputFolder.isDirectory()){
			System.out.println("folder: "+outputFolderPath);
			String[] files = outputFolder.list();
			for(String file: files){
				System.out.println("display: "+file);
				if(file.endsWith(".txt")){
					Tabpanel txtResultPanel = (Tabpanel) component.getFellow("txtResultTab");
					File fileToCreate = new File(outputFolderPath+file);
					byte[] buffer = new byte[(int) fileToCreate.length()];
					FileInputStream fs;
					try {
						fs = new FileInputStream(fileToCreate);
						fs.read(buffer);
						fs.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ByteArrayInputStream is = new ByteArrayInputStream(buffer);
					AMedia fileContent = new AMedia("report", "text", "text/plain", is);
					Include studyInformationPage = new Include();
					studyInformationPage.setParent(txtResultPanel);
					studyInformationPage.setDynamicProperty("txtFile", fileContent);
					studyInformationPage.setSrc("/user/analysis/txtviewer.zul");
				}
				
				if(file.endsWith(".png")){
					System.out.println("display image:" + outputFolderPath+file);
					Tabpanel tabPanel = (Tabpanel) component.getFellow("graphResultTab");

					String path = outputFolderPath+file;
					Include studyInformationPage = new Include();
					studyInformationPage.setDynamicProperty("imageName", path.replaceAll("\\\\", "//"));
					studyInformationPage.setSrc("/user/analysis/imgviewer.zul");
					studyInformationPage.setParent(tabPanel);
					
					tabPanel.appendChild(studyInformationPage);
//					treeTabs.appendChild(newTab);
				}
			}
		}
		//outputGrphViewer

	}

}
