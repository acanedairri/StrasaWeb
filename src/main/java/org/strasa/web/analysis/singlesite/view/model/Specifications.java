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
import java.util.Set;

import org.analysis.rserve.manager.RServeManager;
import org.analysis.rserve.manager.test.TestRServeManager;
import org.apache.commons.io.input.ReaderInputStream;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.web.analysis.view.model.SingleSiteAnalysisModel;
import org.strasa.web.uploadstudy.view.model.DataColumnValidation;
import org.strasa.web.utilities.AnalysisUtils;
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import au.com.bytecode.opencsv.CSVReader;

public class Specifications {	

	//Zul file components
	@Wire
	private Button chooseResponseBtn;

	private Listbox numericLb;
	private Listbox responseLb;
	private Listbox factorLb;


	//DataModels
	private ListModelList<String> numericModel;
	private ListModelList<String> responseModel;
	private ListModelList<String> factorModel;

	//Class Variables
	private ArrayList<String> varInfo;

	//textBoxes
	private Textbox envTextBox;
	private Textbox genotypeTextBox;
	private Textbox blockTextBox;
	private Textbox replicateTextBox;
	private Textbox rowTextBox;
	private Textbox columnTextBox;

	//imageButtons
	private Image addEnvButton;
	private Image addGenotypeButton;
	private Image addBlockButton;
	private Image addReplicateButton;
	private Image addRowButton;
	private Image addColumnButton;

	private Component mainView;
	private SingleSiteAnalysisModel ssaModel;

	private String resultRServe;
	private List<String> typeOfDesignList;
	private boolean isVariableDataVisible;
	private String dataFileName;

	private File tempFile;
	private boolean isNewDataSet;
	public boolean isUpdateMode = false;

	//Rserve Parameters
	private int fileFormat=1;
	private String separator="NULL";;
	private String tempFileName;
	private String fileName=System.getProperty("user.dir")+ System.getProperty("file.separator") + "sample_datasets" + System.getProperty("file.separator") + "RCB_ME.csv";
	private RServeManager rServeManager;

	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		
		typeOfDesignList = getTypeOfDesignList();
		ssaModel=new SingleSiteAnalysisModel();
		
		Include inc = (Include) component.getFellow("includeVariableList");
		numericLb = (Listbox) inc.getFellow("numericLb");
		responseLb = (Listbox) inc.getFellow("responseLb");
		factorLb = (Listbox) inc.getFellow("factorLb");


		//wire textboxes
		envTextBox = (Textbox) inc.getFellow("envTextBox");
		genotypeTextBox = (Textbox) inc.getFellow("genotypeTextBox");
		blockTextBox = (Textbox) inc.getFellow("blockTextBox");
		replicateTextBox = (Textbox) inc.getFellow("replicateTextBox");
		rowTextBox = (Textbox) inc.getFellow("rowTextBox");
		columnTextBox = (Textbox) inc.getFellow("columnTextBox");

		//wire image buttons
		addEnvButton = (Image) inc.getFellow("addEnvButton");
		addGenotypeButton = (Image) inc.getFellow("addGenotypeButton");
		addBlockButton = (Image) inc.getFellow("addBlockButton");
		addReplicateButton = (Image) inc.getFellow("addReplicateButton");
		addRowButton = (Image) inc.getFellow("addRowButton");

		Selectors.wireEventListeners(view, this);
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


	@GlobalCommand("setSsaListvariables")
	@NotifyChange("*")
	public void setSsaListvariables(@BindingParam("filePath")String filepath){
		//...

		rServeManager = new RServeManager();
		varInfo = rServeManager.getVariableInfo(filepath.replace("\\", "/"), fileFormat, separator);

		numericModel= AnalysisUtils.getNumericAsListModel(varInfo);
		factorModel= AnalysisUtils.getFactorsAsListModel(varInfo);
		responseModel = new ListModelList<String>();

		numericLb.setModel(numericModel);
		factorLb.setModel(factorModel);
		responseLb.setModel(responseModel);

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

				isVariableDataVisible = true;
				dataFileName = name;

				Map<String,Object> args = new HashMap<String,Object>();
				args.put("filePath", tempFile.getAbsolutePath());
				BindUtils.postGlobalCommand(null, null, "setSsaListvariables", args);

				//				if (this.isUpdateMode)
				//					isNewDataSet = true;

	}


	@NotifyChange("*")
	@Command()
	public void displayTextFileContent(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		setSsaModel(new SingleSiteAnalysisModel());

		System.out.println("call rserve");
		rServeManager = new RServeManager();
		System.out.println("call rserve ssa");
		rServeManager.doSingleEnvironmentAnalysis(new SingleSiteAnalysisModel());

		System.out.println("end rserve ssa");

	}

	@GlobalCommand("addResponse")
	@NotifyChange("*")
	public void addResponse() {
		chooseResponseVariable();
	}

	@GlobalCommand("removeResponse")
	@NotifyChange("*")
	public void removeResponse() {
		unchooseResponseVariable();
	}

	/**
	 * Set new numeric ListModelList.
	 * 
	 * @param numeric
	 *            is the data of numeric list model
	 */
	public void setModel(List<String> numeric) {
		numericLb.setModel(this.numericModel = new ListModelList<String>(numeric));
		responseModel.clear();
	}

	/**
	 * @return current response data list
	 */
	public List<String> getresponseDataList() {
		return new ArrayList<String>(responseModel);
	}


	@GlobalCommand("toFactor")
	@NotifyChange({"factorModel, numericModel"})
	public void toFactor() {
		// TODO Auto-generated method stub
		System.out.println("toFactor");
		Set<String> set = numericModel.getSelection();
		for (String selectedItem : set) {
			factorModel.add(selectedItem);
			numericModel.remove(selectedItem);
		}

	}

	@GlobalCommand("toNumeric")
	@NotifyChange({"factorModel, numericModel"})
	public void toNumeric() {
		// TODO Auto-generated method stub

		System.out.println("to Numeric");
		Set<String> set = factorModel.getSelection();
		fileName = fileName.replace("\\", "/");
		for (String selectedItem : set) {
			if (AnalysisUtils.isColumnNumeric(varInfo, selectedItem)){
				numericModel.add(selectedItem);
				factorModel.remove(selectedItem);
			}
			else{
				Messagebox.show("Can't move variable.\n"+selectedItem+ " is not Numeric.");
				System.out.println("Not Numeric");
			}
		}
	}


	@GlobalCommand("chooseVariable")
	@NotifyChange("*")
	public boolean chooseVariable(@BindingParam("varTextBox") Textbox varTextBox, @BindingParam("imgButton") Image imgButton ) {
		Set<String> set = factorModel.getSelection();
		//				System.out.println("removeResponse");

		if(varTextBox.getValue().isEmpty() && !set.isEmpty()){
			for (String selectedItem : set) {
				varTextBox.setValue(selectedItem);
				factorModel.remove(selectedItem);
			}

			imgButton.setSrc("/images/leftarrow_g.png");
			return true;
			//nag add
		}else if(!varTextBox.getValue().isEmpty()){
			factorModel.add(varTextBox.getValue());
			varTextBox.setValue(null);
		}

		imgButton.setSrc("/images/rightarrow_g.png");
		return false;
		// TODO Auto-generated method stub
	}


	private void chooseResponseVariable() {
		Set<String> set = numericModel.getSelection();
				System.out.println("addResponse");
		for (String selectedItem : set) {
			responseModel.add(selectedItem);
			numericModel.remove(selectedItem);
		}
	}

	private void unchooseResponseVariable() {
		Set<String> set = responseModel.getSelection();
				System.out.println("removeResponse");
		for (String selectedItem : set) {
			numericModel.add(selectedItem);
			responseModel.remove(selectedItem);
		}
	}

//	// Customized Event
//	public class ChooseEvent extends Event {
//		private static final long serialVersionUID = -7334906383953342976L;
//
//		public ChooseEvent(Component target, Set<String> data) {
//			super("onChoose", target, data);
//		}
//	}

	public SingleSiteAnalysisModel getSsaModel() {
		return ssaModel;
	}

	public void setSsaModel(SingleSiteAnalysisModel ssaModel) {
		this.ssaModel = ssaModel;
	}
	
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

}
