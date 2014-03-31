package org.strasa.web.analysis.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTML;

import org.analysis.rserve.manager.RServeManager;
import org.analysis.rserve.manager.test.TestRServeManager;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.StudyType;
import org.strasa.web.analysis.view.model.SingleSiteAnalysisModel;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Br;
import org.zkoss.zhtml.Textarea;
import org.zkoss.zul.Html;
import org.zkoss.zhtml.P;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Window;

public class TextViewer {	
	private RServeManager rServeManager;
	String textFileContent = null;
	
	@NotifyChange("*")
	@GlobalCommand
	public void displayTextFileContent(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		
		rServeManager = new RServeManager();
		Window html = (Window) component.getFellow("textViewerHtml");
		Label label = (Label) new Label();
		
		rServeManager.doSingleEnvironmentAnalysis(new SingleSiteAnalysisModel());
		label.setValue(textFileContent);
		html.appendChild(label);
		
	}
	
}
