package org.strasa.web.analysis.view;

import org.analysis.rserve.manager.RServeManager;
import org.strasa.web.analysis.view.model.SingleSiteAnalysisModel;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;

public class TextViewer {	
	private RServeManager rServeManager;
	String textFileContent = null;
	
	@NotifyChange("*")
	@GlobalCommand("displayTextFileContent")
	public void displayTextFileContent(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		
		System.out.println("call rserve");
		rServeManager = new RServeManager();
//		Window html = (Window) component.getFellow("textViewerHtml");
//		Label label = (Label) new Label();
		

		System.out.println("call rserve ssa");
		rServeManager.doSingleEnvironmentAnalysis(new SingleSiteAnalysisModel());
//		rServeManager.test();

		System.out.println("end rserve ssa");
//		label.setValue(textFileContent);
//		html.appendChild(label);
		
	}
	
}
