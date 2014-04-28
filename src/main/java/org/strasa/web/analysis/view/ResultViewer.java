package org.strasa.web.analysis.view;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.analysis.rserve.manager.RServeManager;
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
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

public class ResultViewer {	
	private RServeManager rServeManager;
	String textFileContent = null;
	
	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("ssaModel") SingleSiteAnalysisModel ssaModel){

		//outputTextViewer

		Tabpanel txtResultPanel = (Tabpanel) component.getFellow("txtResultTab");
		
		System.out.println("display: "+ssaModel.getOutFileName());
		File fileToCreate = new File(ssaModel.getOutFileName());
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
	
}
