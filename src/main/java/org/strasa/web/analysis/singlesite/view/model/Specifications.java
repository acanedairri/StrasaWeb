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
import org.strasa.middleware.filesystem.manager.UserFileManager;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.model.Study;
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
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import au.com.bytecode.opencsv.CSVReader;

public class Specifications {	

	//Zul file components
	@Wire
	private Button chooseResponseBtn;
	private Button resetBtn;
	private Button uploadCSVbtn;

	private Div divDatagrid;

	private Listbox numericLb;
	private Listbox responseLb;
	private Listbox factorLb;


	//DataModels
	private ListModelList<String> numericModel;
	private ListModelList<String> responseModel;
	private ListModelList<String> factorModel;

	//Class Variables
	private ArrayList<String> varInfo;
	private ArrayList<String> varNames;

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
	private String fileName;
	private RServeManager rServeManager;

	private Checkbox boxplotCheckBox;
	private Checkbox histogramCheckBox;
	private Checkbox heatmapCheckBox;
	private Checkbox diagnosticplotCheckBox;
	private Combobox fieldRowComboBox;
	private Combobox fieldColumnComboBox;
	private String errorMessage;
	private Checkbox randomCheckBox;
	private Checkbox fixedCheckBox;

	private Row blockRow;
	private Row replicateRow;
	private Row rowRow;
	private Row columnRow;

	//otheroptions UI
	private Groupbox groupLevelOfControls;
	private Checkbox performPairwiseCheckBox;
	private Groupbox groupGenotypeFixed;
	private Groupbox groupGenotypeRandom;
	private Checkbox excludeControlsCheckBox;
	private Checkbox estimateGenotypeCheckBox;
	private Radio performAllPairwiseBtn;
	private Radio compareWithControlsBtn;
	private Checkbox descriptiveStatCheckBox;
	private Checkbox varComponentsCheckBox;
	private Groupbox groupPerformPairwise;
	private Listbox controlsLb;
	private Doublebox pairwiseAlphaTextBox;


	private String[] environmentLevels;
	private String[] genotypeLevels;
	private List<String> respvars = new ArrayList<String>();
	private List<String> controls = new ArrayList<String>();

	private List<String> columnList = new ArrayList<String>();
	private List<String[]> dataList = new ArrayList<String[]>();
	public boolean isDataReUploaded = false;
	private boolean gridReUploaded = false;
	private int pageSize = 10;
	private int activePage = 0;

	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		//init vars
		typeOfDesignList = getTypeOfDesignList();
		ssaModel=new SingleSiteAnalysisModel();

		divDatagrid = (Div) component.getFellow("datagrid");
		resetBtn = (Button) component.getFellow("resetBtn");
		uploadCSVbtn = (Button) component.getFellow("uploadCSVbtn");

		Include incVariableList = (Include) component.getFellow("includeVariableList");
		numericLb = (Listbox) incVariableList.getFellow("numericLb");
		responseLb = (Listbox) incVariableList.getFellow("responseLb");
		factorLb = (Listbox) incVariableList.getFellow("factorLb");

		numericModel = new ListModelList<String>();
		responseModel = new ListModelList<String>();
		factorModel = new ListModelList<String>();

		//wire textboxes
		envTextBox = (Textbox) incVariableList.getFellow("envTextBox");
		genotypeTextBox = (Textbox) incVariableList.getFellow("genotypeTextBox");
		blockTextBox = (Textbox) incVariableList.getFellow("blockTextBox");
		replicateTextBox = (Textbox) incVariableList.getFellow("replicateTextBox");
		rowTextBox = (Textbox) incVariableList.getFellow("rowTextBox");
		columnTextBox = (Textbox) incVariableList.getFellow("columnTextBox");

		//wire image buttons
		addEnvButton = (Image) incVariableList.getFellow("addEnvButton");
		addGenotypeButton = (Image) incVariableList.getFellow("addGenotypeButton");
		addBlockButton = (Image) incVariableList.getFellow("addBlockButton");
		addReplicateButton = (Image) incVariableList.getFellow("addReplicateButton");
		addRowButton = (Image) incVariableList.getFellow("addRowButton");

		//wire variable checkboxes
		randomCheckBox = (Checkbox) incVariableList.getFellow("randomCheckBox");
		fixedCheckBox = (Checkbox) incVariableList.getFellow("fixedCheckBox");	

		//wire variable
		blockRow = (Row) incVariableList.getFellow("blockRow");
		replicateRow = (Row) incVariableList.getFellow("replicateRow");
		rowRow = (Row) incVariableList.getFellow("rowRow");
		columnRow = (Row) incVariableList.getFellow("columnRow");

		replicateRow.setVisible(false);
		rowRow.setVisible(false);
		columnRow.setVisible(false);

		//wire graph checkboxes
		boxplotCheckBox = (Checkbox) component.getFellow("boxplotCheckBox");
		histogramCheckBox = (Checkbox) component.getFellow("histogramCheckBox");
		heatmapCheckBox = (Checkbox) component.getFellow("heatmapCheckBox");
		diagnosticplotCheckBox = (Checkbox) component.getFellow("diagnosticplotCheckBox");

		//wire comboboxes
		fieldRowComboBox = (Combobox) component.getFellow("fieldRowComboBox");
		fieldColumnComboBox = (Combobox) component.getFellow("fieldColumnComboBox");


		Include includeOtherOptions = (Include) component.getFellow("includeOtherOptions");
		groupLevelOfControls = (Groupbox) includeOtherOptions.getFellow("groupLevelOfControls");

		groupGenotypeFixed = (Groupbox) includeOtherOptions.getFellow("groupGenotypeFixed");
		compareWithControlsBtn = (Radio) includeOtherOptions.getFellow("compareWithControlsBtn");
		performAllPairwiseBtn = (Radio) includeOtherOptions.getFellow("performAllPairwiseBtn");
		pairwiseAlphaTextBox = (Doublebox) includeOtherOptions.getFellow("pairwiseAlphaTextBox");
		groupPerformPairwise = (Groupbox) includeOtherOptions.getFellow("groupPerformPairwise");
		performPairwiseCheckBox = (Checkbox) includeOtherOptions.getFellow("cbPerformPairwise");

		groupGenotypeRandom = (Groupbox) includeOtherOptions.getFellow("groupGenotypeRandom");
		excludeControlsCheckBox = (Checkbox) includeOtherOptions.getFellow("excludeControlsCheckBox");
		estimateGenotypeCheckBox = (Checkbox) includeOtherOptions.getFellow("estimateGenotypeCheckBox");

		descriptiveStatCheckBox = (Checkbox) includeOtherOptions.getFellow("descriptiveStatCheckBox");
		varComponentsCheckBox = (Checkbox) includeOtherOptions.getFellow("varComponentsCheckBox");

		controlsLb = (Listbox)  includeOtherOptions.getFellow("controlsLb");

		Selectors.wireEventListeners(view, this);
	}

	public List<String> getTypeOfDesignList() {
		// TODO Auto-generated method stub
		List<String> designs = new ArrayList<String>();
		designs.add("RCB");
		designs.add("RCBD");
		designs.add("Alpha-Lattice");
		designs.add("Row-Column");
		designs.add("Augmented RCBD");
		return designs;
	}

	@GlobalCommand("updateFixedOptions")
	@NotifyChange("*")
	public void updateFixedOptions(@BindingParam("selected") Boolean selected){
		System.out.println("activate Fixed");
		if(selected){//if checked
			activateFixedOptions(true);
			if(compareWithControlsBtn.isSelected() && performPairwiseCheckBox.isChecked()) activateLevelOfConrolsOptions(true);
		}
		else{//if unchecked
			activateFixedOptions(false);
			if(!excludeControlsCheckBox.isChecked() || !excludeControlsCheckBox.isVisible()) activateLevelOfConrolsOptions(false);
			else if(ssaModel.getDesign()==1 || ssaModel.getDesign()==2) activateLevelOfConrolsOptions(false);

		}
	}

	@GlobalCommand("updateRandomOptions")
	@NotifyChange("*")
	public void updateRandomOptions(@BindingParam("selected") Boolean selected){
		System.out.println("activate Random");
		if(selected){//if checked
			activateRandomOptions(true);
			activateLevelOfConrolsOptions(false);
			if(excludeControlsCheckBox.isChecked()) activateLevelOfConrolsOptions(true);
			if(ssaModel.getDesign() == 1 ||ssaModel.getDesign() == 2){
				enableAugmentedOptions(true);
			}
		}
		else{//if unchecked
			activateRandomOptions(false);
			if((!compareWithControlsBtn.isSelected() || !compareWithControlsBtn.isVisible())) activateLevelOfConrolsOptions(false);

		}
	}

	private void activateRandomOptions(boolean state) {
		// TODO Auto-generated method stub
		groupGenotypeRandom.setOpen(state);
		if(!responseModel.isEmpty()) estimateGenotypeCheckBox.setVisible(state);
	}

	private void activateFixedOptions(boolean state) {
		// TODO Auto-generated method stub
		groupGenotypeFixed.setOpen(state);
		activatePerformPairwiseOptions(state);

		if(!state && !excludeControlsCheckBox.isChecked()) activateLevelOfConrolsOptions(false);
	}

	@GlobalCommand("updatePairwiseOptions")
	@NotifyChange("*")
	public void updatePairwiseOptions(@BindingParam("selected") Boolean selected){
		System.out.println("activate updatePairwiseOptions");
		activatePerformPairwiseOptions(selected);
	}

	protected void activatePerformPairwiseOptions(boolean state) {
		// TODO Auto-generated method stub
		if(performPairwiseCheckBox.isChecked() && state) groupPerformPairwise.setVisible(true);
		else groupPerformPairwise.setVisible(false);
		compareWithControlsBtn.setSelected(true);

//		if(state){
//			genotypeLevels = rServeManager.getLevels(columnList, dataList, ssaModel.getGenotype());
//			try{
//				if(genotypeLevels.length>15){
//					compareWithControlsBtn.setSelected(true);
//					activateLevelOfConrolsOptions(true);
//					performAllPairwiseBtn.setSelected(false);
//					performAllPairwiseBtn.setVisible(false);
//					//			performAllComparisonsBtn.setSelection(false);
//				}
//				else{
//					performAllPairwiseBtn.setSelected(true);
//					if(performAllPairwiseBtn.isSelected()) compareWithControlsBtn.setSelected(false);
//				}
//			}catch(NullPointerException npe){
//				
//			}
//		}
	}

	@Command("updateVariableList")
	@NotifyChange("*")
	public void updateVariableList(@BindingParam("selectedIndex") Integer selectedIndex){
		System.out.println("chose " + Integer.toString(selectedIndex));
		switch (selectedIndex) {
		case 1: {//AugmentedRCB
			enableAugmentedOptions(true);	
			if(performPairwiseCheckBox.isChecked()){
				activateLevelOfConrolsOptions(true);
			}else activateLevelOfConrolsOptions(false);

			blockRow.setVisible(true);
			replicateRow.setVisible(false);
			rowRow.setVisible(false);
			columnRow.setVisible(false);
			break;
		}
		case 2: {//AugmentedLatin square
			enableAugmentedOptions(true);
			if(performPairwiseCheckBox.isChecked()){
				activateLevelOfConrolsOptions(true);
			}else activateLevelOfConrolsOptions(false);

			rowRow.setVisible(true);
			columnRow.setVisible(true);

			blockRow.setVisible(false);
			replicateRow.setVisible(false);
			break;
		}
		case 3: {//Alpha lattice
			enableAugmentedOptions(false);
			if(performPairwiseCheckBox.isChecked()){
				activateLevelOfConrolsOptions(true);
			}else activateLevelOfConrolsOptions(false);

			blockRow.setVisible(true);
			replicateRow.setVisible(true);

			rowRow.setVisible(false);
			columnRow.setVisible(false);

			break;
		}
		case 4: {//Row Column
			enableAugmentedOptions(false);
			if(performPairwiseCheckBox.isChecked()){
				activateLevelOfConrolsOptions(true);
			}else activateLevelOfConrolsOptions(false);

			blockRow.setVisible(false);
			replicateRow.setVisible(true);
			rowRow.setVisible(true);
			columnRow.setVisible(true);
			break;
		}
		case 5: {// Latinized Alpha lattice
			enableAugmentedOptions(false);
			if(performPairwiseCheckBox.isChecked()){
				activateLevelOfConrolsOptions(true);
			}else activateLevelOfConrolsOptions(false);
			blockRow.setVisible(true);
			replicateRow.setVisible(true);

			rowRow.setVisible(false);
			columnRow.setVisible(false);
			break;
		}
		case 6: {// Latinized Row Column
			enableAugmentedOptions(false);
			if(performPairwiseCheckBox.isChecked()){
				activateLevelOfConrolsOptions(true);
			}else activateLevelOfConrolsOptions(false);
			blockRow.setVisible(false);
			replicateRow.setVisible(true);
			rowRow.setVisible(true);
			columnRow.setVisible(true);
			break;
		}
		case 0: {//RCB
		}
		default: {

			enableAugmentedOptions(false);
			if(performPairwiseCheckBox.isChecked()){
				activateLevelOfConrolsOptions(true);
			}else activateLevelOfConrolsOptions(false);

			blockRow.setVisible(true);
			replicateRow.setVisible(false);
			rowRow.setVisible(false);
			columnRow.setVisible(false);
			break;
		}
		}
	}

	private void activateLevelOfConrolsOptions(boolean state) {
		// TODO Auto-generated method stub
		groupLevelOfControls.setOpen(state);
	}

	private void enableAugmentedOptions(boolean state) {
		// TODO Auto-generated method stub
		if(randomCheckBox.isChecked()){
			groupGenotypeRandom.setOpen(true);

			if(!responseModel.isEmpty())estimateGenotypeCheckBox.setChecked(true);
			activateLevelOfConrolsOptions(!state);
			if(!state){
				excludeControlsCheckBox.setChecked(false);
				activateLevelOfConrolsOptions(false);
			}
		}
	}

	public void setTypeOfDesignList(List<String> typeOfDesignList) {
		this.typeOfDesignList = typeOfDesignList;
	}


	@GlobalCommand("setSsaListvariables")
	@NotifyChange("*")
	public void setSsaListvariables(@BindingParam("filePath")String filepath){
		//...
		ssaModel.setDataFileName(filepath.replace("\\", "/"));
		rServeManager = new RServeManager();
		varInfo = rServeManager.getVariableInfo(filepath.replace("\\", "/"), fileFormat, separator);

		setVarNames(AnalysisUtils.getVarNames(varInfo));

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

		fileName = event.getMedia().getName();
		if (tempFile == null)
			try {
				tempFile = File.createTempFile(fileName, ".tmp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		if (!fileName.endsWith(".csv")) {
			Messagebox.show("Error: File must be a text-based csv format",
					"Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}

		InputStream in = event.getMedia().isBinary() ? event.getMedia()
				.getStreamData() : new ReaderInputStream(event.getMedia()
						.getReaderData());
				FileUtilities.uploadFile(tempFile.getAbsolutePath(), in);
				BindUtils.postNotifyChange(null, null, this, "*");


				File uploadedFile = FileUtilities.getFileFromUpload(ctx, view);

				UserFileManager userFileManager = new UserFileManager();
				String filePath = userFileManager.uploadFileForAnalysis(fileName, uploadedFile);

				if (tempFile == null)
					return;

				isVariableDataVisible = true;
				dataFileName = fileName;

				Map<String,Object> args = new HashMap<String,Object>();
				args.put("filePath", filePath);
				BindUtils.postGlobalCommand(null, null, "setSsaListvariables", args);

				isVariableDataVisible = true;
				dataFileName = fileName;
				refreshCsv();
				if (this.isUpdateMode) isNewDataSet = true;

				resetBtn.setVisible(true);
				uploadCSVbtn.setVisible(false);

	}

	@Command("refreshCsv")
	public void refreshCsv() {
		activePage = 0;
		CSVReader reader;
		reloadCsvGrid();

		try {
			reader = new CSVReader(new FileReader(tempFile.getAbsolutePath()));
			List<String[]> rawData = reader.readAll();
			columnList.clear();
			dataList.clear();
			columnList = new ArrayList<String>(Arrays.asList(rawData.get(0)));
			rawData.remove(0);
			dataList = new ArrayList<String[]>(rawData);
			System.out.println(Arrays.toString(dataList.get(0)));
			if (!this.isDataReUploaded)
				System.out.println("gbUploadData.invalidate()");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<ArrayList<String>> getCsvData() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (dataList.isEmpty())
			return result;
		for (int i = activePage * pageSize; i < activePage * pageSize + pageSize && i < dataList.size(); i++) {
			ArrayList<String> row = new ArrayList<String>();
			row.addAll(Arrays.asList(dataList.get(i)));
			result.add(row);
			row.add(0, "  ");
			System.out.println(Arrays.toString(dataList.get(i)) + "ROW: " + row.get(0));
		}
		return result;
	}

	public void reloadCsvGrid() {
		if (gridReUploaded) {
			gridReUploaded = false;
			return;
		}
		if (!divDatagrid.getChildren().isEmpty())
			divDatagrid.getFirstChild().detach();
		Include incCSVData = new Include();
		incCSVData.setSrc("/user/updatestudy/csvdata.zul");
		incCSVData.setParent(divDatagrid);
		gridReUploaded = true;
	}

	@NotifyChange("*")
	@Command()
	public void displayTextFileContent(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		setSsaModel(new SingleSiteAnalysisModel());

		rServeManager = new RServeManager();
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


	@Command()
	public void validateSsaInputs() {
		// TODO Auto-generated method stub
		if(validateSsaModel()){
			System.out.println("pasing variables");
			Map<String,Object> args = new HashMap<String,Object>();
			args.put("ssaModel", ssaModel);
			BindUtils.postGlobalCommand(null, null, "displaySsaResult", args);
		} else Messagebox.show(errorMessage);
	}

	private boolean validateSsaModel() {
		// TODO Auto-generated method stub

		System.out.println("validating ssaModels");
		//		rServeManager = new RServeManager();
		//set Paths
		ssaModel.setResultFolderPath(AnalysisUtils.createOutputFolder(fileName, "ssa"));
		ssaModel.setOutFileName(ssaModel.getResultFolderPath()+ "SEA_output.txt");

		//set Vars
		if(!envTextBox.getValue().isEmpty()) ssaModel.setEnvironment(envTextBox.getValue());
		else{
			errorMessage = "environment cannot be empty";
			return false;
		}

		if(!genotypeTextBox.getValue().isEmpty()) ssaModel.setGenotype(genotypeTextBox.getValue());
		else{
			errorMessage = "genotype cannot be empty";
			return false;
		}

		if(!blockTextBox.getValue().isEmpty())ssaModel.setBlock(blockTextBox.getValue());
		else if(blockRow.isVisible() ){
			errorMessage = "block cannot be empty";
			return false;
		}

		if(!replicateTextBox.getValue().isEmpty())ssaModel.setRep(replicateTextBox.getValue());
		else if(replicateRow.isVisible()){
			errorMessage = "replicate cannot be empty";
			return false;
		}

		if(!rowTextBox.getValue().isEmpty()) ssaModel.setRow(rowTextBox.getValue());
		else if(rowRow.isVisible()){
			errorMessage = "row cannot be empty";
			return false;
		}

		if(!columnTextBox.getValue().isEmpty()) ssaModel.setColumn(columnTextBox.getValue());
		else if(columnRow.isVisible()){
			errorMessage = "column cannot be empty";
			return false;
		}

		//Graph Options
		ssaModel.setBoxplotRawData(boxplotCheckBox.isChecked());
		ssaModel.setHistogramRawData(histogramCheckBox.isChecked());
		ssaModel.setDiagnosticPlot(diagnosticplotCheckBox.isChecked());

		ssaModel.setHeatmapResiduals(heatmapCheckBox.isChecked());
		if(heatmapCheckBox.isChecked()){
			if(fieldRowComboBox.getValue().isEmpty()){
				errorMessage = "select heatmap field row";
				return false;
			}
			else if	(fieldColumnComboBox.getValue().isEmpty()){
				errorMessage = "select heatmap field column";
				return false;
			}
			else{
				ssaModel.setHeatmapRow(fieldRowComboBox.getValue());
				ssaModel.setHeatmapColumn(fieldColumnComboBox.getValue());
			}
		}


		ssaModel.setDescriptiveStat(descriptiveStatCheckBox.isChecked());
		ssaModel.setVarianceComponents(varComponentsCheckBox.isChecked());

		ssaModel.setRespvars(respvars.toArray(new String[respvars.size()]));

		if(!ssaModel.getEnvironment().isEmpty()) ssaModel.setEnvironmentLevels(rServeManager.getLevels(columnList, dataList, ssaModel.getEnvironment()));
		else ssaModel.setEnvironment("NULL");

		ssaModel.setGenotypeLevels(rServeManager.getLevels(columnList, dataList, ssaModel.getGenotype()));

		ssaModel.setGenotypeRandom(randomCheckBox.isChecked());
		ssaModel.setGenotypeFixed(fixedCheckBox.isChecked());

		if(!ssaModel.isGenotypeFixed() && !ssaModel.isGenotypeRandom()){
			errorMessage = "Please specify whether the genotype variable is fixed or random.";
			return false;
		}

		if(ssaModel.isGenotypeFixed()){//if fixed is checked
			ssaModel.setPerformPairwise(performPairwiseCheckBox.isChecked());
			if(ssaModel.isPerformPairwise()){
				ssaModel.setPairwiseAlpha(Double.toString(pairwiseAlphaTextBox.getValue()));
				if(ssaModel.getPairwiseAlpha().isEmpty()){
					errorMessage = "Please add a value for the pairwise level of significance.";
					return false;
				}
				else{
					ssaModel.setCompareControl(compareWithControlsBtn.isChecked());
					ssaModel.setPerformAllPairwise(performAllPairwiseBtn.isChecked());
					if(ssaModel.isCompareControl()){
						ssaModel.setControlLevels(controls.toArray(new String[controls.size()]));
						if(ssaModel.getControlLevels().length<1){
							errorMessage = "Please specify control variables from the genotype levels.";
							return false;
						}
					}
				}
			}
		}

		if(ssaModel.isGenotypeRandom()){//if random is checked
			ssaModel.setExcludeControls(excludeControlsCheckBox.isChecked());
			ssaModel.setGenoPhenoCorrelation(estimateGenotypeCheckBox.isChecked());

			if(excludeControlsCheckBox.isChecked() && !(compareWithControlsBtn.isChecked() && compareWithControlsBtn.isChecked())){
				ssaModel.setControlLevels(controls.toArray(new String[controls.size()]));
				if(controls.size()<1 && !(ssaModel.getDesign()== 1 || ssaModel.getDesign() == 2 )){
					errorMessage = "Please specify control variables from the genotype levels.";
					return false;
				}
			}
		}

		return true;
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
			respvars.add(selectedItem);
			responseModel.add(selectedItem);
			numericModel.remove(selectedItem);
		}
	}

	private void unchooseResponseVariable() {
		Set<String> set = responseModel.getSelection();
		System.out.println("removeResponse");
		for (String selectedItem : set) {
			respvars.remove(selectedItem);
			numericModel.add(selectedItem);
			responseModel.remove(selectedItem);
		}
	}

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

	public ArrayList<String> getVarNames() {
		return varNames;
	}

	public void setVarNames(ArrayList<String> varNames) {
		this.varNames = varNames;
	}

	public List<String[]> getDataList() {
		System.out.println("DaALIST GEt");
		reloadCsvGrid();
		if (true)
			return dataList;
		ArrayList<String[]> pageData = new ArrayList<String[]>();
		for (int i = activePage * pageSize; i < activePage * pageSize + pageSize; i++) {
			pageData.add(dataList.get(i));
			System.out.println(Arrays.toString(dataList.get(i)));
		}

		return pageData;
	}

	public void setDataList(List<String[]> dataList) {
		this.dataList = dataList;
	}

	public boolean isGridReUploaded() {
		return gridReUploaded;
	}

	public void setGridReUploaded(boolean gridReUploaded) {
		this.gridReUploaded = gridReUploaded;
	}

	public boolean isDataReUploaded() {
		return isDataReUploaded;
	}

	public void setDataReUploaded(boolean isDataReUploaded) {
		this.isDataReUploaded = isDataReUploaded;
	}

	public List<String> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}

	public int getPageSize() {
		return pageSize;
	}

	@NotifyChange("*")
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@NotifyChange("*")
	public int getActivePage() {

		return activePage;
	}

	@NotifyChange("*")
	public void setActivePage(int activePage) {
		System.out.println("pageSize");
		reloadCsvGrid();
		this.activePage = activePage;
	}

	public int getTotalSize() {
		return dataList.size();
	}
}
