package org.strasa.web.analysis.singlesite.view.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.analysis.rserve.manager.test.TestRServeManager;
import org.apache.commons.io.input.ReaderInputStream;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.web.uploadstudy.view.model.DataColumnValidation;
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import au.com.bytecode.opencsv.CSVReader;

public class Specifications {	
	//public static ArrayList<Integer> activeStudyIds = new ArrayList<Integer>();

	private Component mainView;

	private String resultRServe;
	private List<String> typeOfDesignList;
	private boolean isVariableDataVisible;
	private String dataFileName;

	private File tempFile;
	private boolean isNewDataSet;
	public boolean isUpdateMode = false;

	public String getResultRServe() {
		return resultRServe;
	}

	public void setResultRServe(String resultRServe) {
		this.resultRServe = resultRServe;
	}

	public String getDataFileName() {
		return dataFileName;
	}

	public boolean isVariableDataVisible() {
		return isVariableDataVisible;
	}

	public void setVariableDataVisible(boolean isVariableDataVisible) {
		this.isVariableDataVisible = isVariableDataVisible;
	}

	public Component getMainView() {
		return mainView;
	}

	public void setMainView(Component mainView) {
		this.mainView = mainView;
	}

	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		typeOfDesignList = getTypeOfDesignList();
	}

	public List<String> getTypeOfDesignList() {
		// TODO Auto-generated method stub
		List<String> designs = new ArrayList<String>();
		designs.add("CRD");
		designs.add("RCBD");
		designs.add("Alpha-Lattice");
		designs.add("Row-Column");
		designs.add("Augmented RCBD");
		return designs;
	}

	public void setTypeOfDesignList(List<String> typeOfDesignList) {
		this.typeOfDesignList = typeOfDesignList;
	}

	@NotifyChange("*")
	@Command("uploadCSV")
	public void uploadCSV(
			@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,
			@ContextParam(ContextType.VIEW) Component view) {

		UploadEvent event = (UploadEvent) ctx.getTriggerEvent();

		// System.out.println(event.getMedia().getStringData());

		String name = event.getMedia().getName();
		if (tempFile == null)
			try {
				tempFile = File.createTempFile(name, ".tmp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		if (!name.endsWith(".csv")) {
			Messagebox.show("Error: File must be a text-based csv format",
					"Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}

		InputStream in = event.getMedia().isBinary() ? event.getMedia()
				.getStreamData() : new ReaderInputStream(event.getMedia()
						.getReaderData());
				FileUtilities.uploadFile(tempFile.getAbsolutePath(), in);
				BindUtils.postNotifyChange(null, null, this, "*");

				ArrayList<String> invalidHeader = new ArrayList<String>();
				boolean isHeaderValid = true;
				try {
					StudyVariableManagerImpl studyVarMan = new StudyVariableManagerImpl();
					CSVReader reader = new CSVReader(new FileReader(
							tempFile.getAbsolutePath()));
					String[] header = reader.readNext();
					for (String column : header) {
						if (!studyVarMan.hasVariable(column)) {
							invalidHeader.add(column);
							isHeaderValid = false;
						}
					}
					System.out.println(invalidHeader.size());

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				isVariableDataVisible = true;
				dataFileName = name;

		        Map<String,Object> args = new HashMap<String,Object>();
		        args.put("filePath", tempFile.getAbsolutePath());
				BindUtils.postGlobalCommand(null, null, "setSsaListvariables", args);
				
				if (this.isUpdateMode)
					isNewDataSet = true;

	}

}
