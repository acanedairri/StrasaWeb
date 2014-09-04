package org.strasa.web.analysis.multisite.view.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.analysis.rserve.manager.RServeManager;
import org.analysis.rserve.manager.test.TestRServeManager;
import org.apache.commons.io.input.ReaderInputStream;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.spring.security.model.SecurityUtil;
import org.strasa.middleware.filesystem.manager.UserFileManager;
import org.strasa.middleware.manager.BrowseStudyManagerImpl;
import org.strasa.middleware.manager.StudyDataColumnManagerImpl;
import org.strasa.middleware.manager.StudyDataSetManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.middleware.model.StudyDataSet;
import org.strasa.web.analysis.view.model.MultiSiteAnalysisModel;
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
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import au.com.bytecode.opencsv.CSVReader;

public class Specifications {	

	//Managers
	private RServeManager rServeManager;
	private StudyManagerImpl studyMgr;
	private StudyDataSetManagerImpl studyDataSetMgr;
	private BrowseStudyManagerImpl browseStudyManagerImpl;

	//Zul file components
	@Wire
	private Button chooseResponseBtn;
	private Button resetBtn;
	private Button uploadCSVbtn;
	private Button selectDataBtn;
	private Div divDatagrid;
	private Groupbox grpVariableData;

	private Listbox numericLb;
	private Listbox responseLb;
	private Listbox factorLb;
	
	private Tabbox tabBox;

	//DataModels
	private Study selectedStudy;
	private StudyDataSet selectedDataSet;
	private List<Study> studies;
	private List<StudyDataSet> studyDataSets;
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
	private MultiSiteAnalysisModel msaModel;

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
	private Combobox studiesCombo;
	private Combobox dataSetCombo;

	//otheroptions UI
	private Div divOtherOptions;
	private Groupbox groupLevelOfControls;
	private Checkbox performPairwiseCheckBox;
	private Groupbox groupGenotypeFixed;
	private Groupbox groupGenotypeRandom;
	private Checkbox checkBoxExcludeControls;
	private Checkbox checkBoxEstimateGenotype;
	private Radio performAllPairwiseBtn;
	private Radio compareWithControlsBtn;
	private Checkbox checkBoxStabilityFinlayWilkinson;
	private Checkbox checkBoxStabilityShukla;
	private Checkbox checkBoxAmmi;
	private Checkbox checkBoxGge;
	private Checkbox checkBoxDescriptiveStat;
	private Checkbox checkBoxVarComponents;
	private Groupbox groupPerformPairwise;
	private Listbox controlsLb;
	private Doublebox pairwiseAlphaTextBox;


	private String[] environmentLevels;
	private String[] genotypeLevels;
	private List<String> respvars = new ArrayList<String>();

	private List<String> columnList = new ArrayList<String>();
	private List<String[]> dataList = new ArrayList<String[]>();
	public boolean isDataReUploaded = false;
	private boolean gridReUploaded = false;
	private int pageSize = 10;
	private int activePage = 0;
	private Include incVariableList;
	private File uploadedFile;
	private UserFileManager userFileManager;
	private ListModelList<String> controlsModel;
	private Listbox genotypeLevelsLb;
	private ListModelList<String> genotypeLevelsModel;
	private boolean genotypeControlsOpen = true;
	private Include includeOtherOptions;
	
	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		studyMgr = new StudyManagerImpl();
		studyDataSetMgr = new StudyDataSetManagerImpl();

		studies = studyMgr.getStudiesByUserID(SecurityUtil.getDbUser().getId());

		tabBox = (Tabbox) component.getFellow("tabBox");
		//init vars
		typeOfDesignList = getTypeOfDesignList();
		msaModel=new MultiSiteAnalysisModel();

		divDatagrid = (Div) component.getFellow("datagrid");
		grpVariableData = (Groupbox) component.getFellow("grpVariableData");
		resetBtn = (Button) component.getFellow("resetBtn");
		uploadCSVbtn = (Button) component.getFellow("uploadCSVbtn");
		selectDataBtn = (Button) component.getFellow("selectDataBtn");

		incVariableList = (Include) component.getFellow("includeVariableList");
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
		diagnosticplotCheckBox = (Checkbox) component.getFellow("diagnosticplotCheckBox");

		studiesCombo = (Combobox) component.getFellow("studiesCombo");
		dataSetCombo = (Combobox) component.getFellow("dataSetCombo");

		//wire Other Options UI
		
		includeOtherOptions =(Include) component.getFellow("includeOtherOptions");
		groupLevelOfControls = (Groupbox) includeOtherOptions.getFellow("groupLevelOfControls");

		groupGenotypeFixed = (Groupbox) includeOtherOptions.getFellow("groupGenotypeFixed");
		compareWithControlsBtn = (Radio) includeOtherOptions.getFellow("compareWithControlsBtn");
		performAllPairwiseBtn = (Radio) includeOtherOptions.getFellow("performAllPairwiseBtn");
		pairwiseAlphaTextBox = (Doublebox) includeOtherOptions.getFellow("pairwiseAlphaTextBox");
		groupPerformPairwise = (Groupbox) includeOtherOptions.getFellow("groupPerformPairwise");
		performPairwiseCheckBox = (Checkbox) includeOtherOptions.getFellow("cbPerformPairwise");

		groupGenotypeRandom = (Groupbox) includeOtherOptions.getFellow("groupGenotypeRandom");
		checkBoxExcludeControls = (Checkbox) includeOtherOptions.getFellow("excludeControlsCheckBox");
		checkBoxEstimateGenotype = (Checkbox) includeOtherOptions.getFellow("estimateGenotypeCheckBox");


		checkBoxStabilityFinlayWilkinson = (Checkbox) includeOtherOptions.getFellow("StabilityFinlayWilkinson");
		checkBoxStabilityShukla = (Checkbox) includeOtherOptions.getFellow("StabilityShukla");
		checkBoxAmmi = (Checkbox) includeOtherOptions.getFellow("Ammi");
		checkBoxGge = (Checkbox) includeOtherOptions.getFellow("Gge");
		checkBoxDescriptiveStat = (Checkbox) includeOtherOptions.getFellow("descriptiveStatCheckBox");
		checkBoxVarComponents = (Checkbox) includeOtherOptions.getFellow("varComponentsCheckBox");

		genotypeLevelsLb = (Listbox)  includeOtherOptions.getFellow("genotypeLevelsLb");
		controlsLb = (Listbox)  includeOtherOptions.getFellow("controlsLb");
		
		Selectors.wireEventListeners(view, this);
		userFileManager = new UserFileManager();
	}

	public List<String> getTypeOfDesignList() {
		// TODO Auto-generated method stub
		List<String> designs = new ArrayList<String>();
		designs.add("Randomized Complete Block(RCB)"); 
		designs.add("Augmented RCB");
		designs.add("Augmented Latin Square");
		designs.add("Alpha-Lattice");
		designs.add("Row-Column");
		designs.add("Latinized Alpha-Lattice");
		designs.add("Latinized Row-Column");
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
			if(!checkBoxExcludeControls.isChecked() || !checkBoxExcludeControls.isVisible()) activateLevelOfConrolsOptions(false);
			else if(msaModel.getDesign()==1 || msaModel.getDesign()==2) activateLevelOfConrolsOptions(false);

		}
	}

	@Command("updateDataSetList")
	@NotifyChange("*")
	public void updateDataSetList(){

		dataSetCombo.setSelectedItem(null);
		dataSetCombo.setVisible(false);

		if(!columnList.isEmpty()){
			columnList.clear();
			dataList.clear();
//			refreshCsv();
			if (!divDatagrid.getChildren().isEmpty()){
				divDatagrid.getFirstChild().detach();
				BindUtils.postGlobalCommand(null, null, "setMsaListvariables", null);
			}
		}

		List<StudyDataSet> dataSet = studyDataSetMgr.getDataSetsByStudyId(selectedStudy.getId());

		if(!dataSet.isEmpty()){//
			dataSetCombo.setVisible(true);
			setStudyDataSets(dataSet);
			setSelectedDataSet(null);
			dataSetCombo.setSelectedItem(null);
			dataSetCombo.setText(null);
			BindUtils.postNotifyChange(null, null, this, "*");
			
		}
		else{
			dataSetCombo.setVisible(false);
			Messagebox.show("Please choose a different study","Study has no data", Messagebox.OK, Messagebox.ERROR);
		}

	}

	@Command("updateRandomOptions")
	@NotifyChange("*")
	public void updateRandomOptions(@BindingParam("selected") Boolean selected){
		System.out.println("activate Random");
		if(selected){//if checked
			activateRandomOptions(true);
			activateLevelOfConrolsOptions(false);
			if(checkBoxExcludeControls.isChecked()) activateLevelOfConrolsOptions(true);
			if(msaModel.getDesign() == 1 ||msaModel.getDesign() == 2){
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
		if(!responseModel.isEmpty()) checkBoxEstimateGenotype.setVisible(state);
	}

	private void activateFixedOptions(boolean state) {
		// TODO Auto-generated method stub
		groupGenotypeFixed.setOpen(state);
		activatePerformPairwiseOptions(state);

		if(!state && !checkBoxExcludeControls.isChecked()) activateLevelOfConrolsOptions(false);
	}

	@GlobalCommand("updatePairwiseOptions")
	@NotifyChange("*")
	public void updatePairwiseOptions(@BindingParam("selected") Boolean selected){
		System.out.println("activate updatePairwiseOptions");
		activatePerformPairwiseOptions(selected);
	}

	protected void activatePerformPairwiseOptions(boolean state) {
		// TODO Auto-generated method stub
		if(performPairwiseCheckBox.isChecked() && state) groupPerformPairwise.setOpen(true);
		else groupPerformPairwise.setOpen(false);
		compareWithControlsBtn.setSelected(true);

		if(state){
			try{
				genotypeLevels = rServeManager.getLevels(columnList, dataList, msaModel.getGenotype());
				compareWithControlsBtn.setSelected(true);
				activateLevelOfConrolsOptions(true);
				performAllPairwiseBtn.setSelected(false);
				if(genotypeLevels.length>15) performAllPairwiseBtn.setDisabled(true);
				else performAllPairwiseBtn.setDisabled(false);
				}catch(NullPointerException npe){
					Messagebox.show("Please select a genotype variable",
							"Error", Messagebox.OK, Messagebox.ERROR);
				}
			}
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
				if(!responseModel.isEmpty())checkBoxEstimateGenotype.setChecked(true);
				activateLevelOfConrolsOptions(!state);
				if(!state){
					checkBoxExcludeControls.setChecked(false);
					activateLevelOfConrolsOptions(false);
				}
			}
		}

		public void setTypeOfDesignList(List<String> typeOfDesignList) {
			this.typeOfDesignList = typeOfDesignList;
		}


		@GlobalCommand("setMsaListvariables")
		@NotifyChange("*")
		public void setMsaListvariables(@BindingParam("filePath")String filepath){
			//...
			try{
			msaModel.setDataFileName(filepath.replace("\\", "/"));
			rServeManager = new RServeManager();
			varInfo = rServeManager.getVariableInfo(filepath.replace("\\", "/"), fileFormat, separator);

			setVarNames(AnalysisUtils.getVarNames(varInfo));

			numericModel= AnalysisUtils.getNumericAsListModel(varInfo);
			factorModel= AnalysisUtils.getFactorsAsListModel(varInfo);
			responseModel = new ListModelList<String>();

			numericLb.setModel(numericModel);
			factorLb.setModel(factorModel);
			responseLb.setModel(responseModel);
			}catch(NullPointerException npe){
				resetListBoxes();
				
			}
			
			
		}

		private void resetListBoxes() {
			// TODO Auto-generated method stub
			numericModel= null;
			factorModel= null;
			responseModel = null;

			numericLb.setModel(numericModel);
			factorLb.setModel(factorModel);
			responseLb.setModel(responseModel);
			
			envTextBox.setText("");
			genotypeTextBox.setText("");
			blockTextBox.setText("");
			replicateTextBox.setText("");
			rowTextBox.setText("");
			columnTextBox.setText("");
		}

		@NotifyChange("*")
		@Command("selectFromDatabase")
		public void selectFromDatabase(	@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,
				@ContextParam(ContextType.VIEW) Component view) {
			selectDataBtn.setVisible(false);
			studiesCombo.setVisible(true);
			resetBtn.setVisible(true);
			uploadCSVbtn.setVisible(false);
		}

		@NotifyChange("*")
		@Command("displaySelectDataSet")
		public void displaySelectDataSet(	@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,
				@ContextParam(ContextType.VIEW) Component view) {

			selectDataBtn.setVisible(false);
			studiesCombo.setVisible(true);
			resetBtn.setVisible(true);
			uploadCSVbtn.setVisible(false);

			browseStudyManagerImpl = new BrowseStudyManagerImpl();

			columnList.clear();
			dataList.clear();
			List<HashMap<String, String>> toreturn = browseStudyManagerImpl.getStudyData(selectedStudy.getId(), selectedDataSet.getDatatype(), selectedDataSet.getId());
			//		System.out.println("Size:" + toreturn.size());
			List<StudyDataColumn> columns = new StudyDataColumnManagerImpl().getStudyDataColumnByStudyId(selectedStudy.getId(), selectedDataSet.getDatatype(), selectedDataSet.getId()); 

			for (StudyDataColumn d : columns) {
				columnList.add(d.getColumnheader());
				//			System.out.print(d.getColumnheader() + "\t");
			}
			//		System.out.println("\n ");
			for (HashMap<String, String> rec : toreturn) {
				ArrayList<String> newRow = new ArrayList<String>();
				for (StudyDataColumn d : columns) {
					String value = rec.get(d.getColumnheader());
					newRow.add(value);
					//				System.out.print(value + "\t");
				}
				//			System.out.println("\n ");
				dataList.add(newRow.toArray(new String[newRow.size()]));
			}

			fileName= selectedStudy.getName()+"_"+selectedDataSet.getTitle().replaceAll(" ", "");
			File BASE_FOLDER = new File(UserFileManager.buildUserPath(selectedStudy.getUserid(), selectedStudy.getId()));
			if(!BASE_FOLDER.exists()) BASE_FOLDER.mkdirs();
			String createPath = BASE_FOLDER.getAbsolutePath()+ File.separator+ fileName + "(dataset).csv";

			System.out.println("created path "+createPath);
			uploadedFile = FileUtilities.createFileFromDatabase(columnList, dataList, createPath);

			if (uploadedFile == null) return;
			

			Map<String,Object> args = new HashMap<String,Object>();
			args.put("filePath", uploadedFile.getAbsolutePath());
			BindUtils.postGlobalCommand(null, null, "setMsaListvariables", args);

			isVariableDataVisible = true;
			activePage = 0;
			//		dataFileName = fileName;
			setGridReUploaded(false);
			reloadCsvGrid();
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

					uploadedFile = FileUtilities.getFileFromUpload(ctx, view);
					String filePath = userFileManager.uploadFileForAnalysis(fileName, uploadedFile);

					if (tempFile == null)
						return;

					isVariableDataVisible = true;
					dataFileName = fileName;

					Map<String,Object> args = new HashMap<String,Object>();
					args.put("filePath", filePath);
					BindUtils.postGlobalCommand(null, null, "setMsaListvariables", args);

					isVariableDataVisible = true;
					dataFileName = fileName;
					refreshCsv();
					if (this.isUpdateMode) isNewDataSet = true;

					resetBtn.setVisible(true);
					uploadCSVbtn.setVisible(false);
					selectDataBtn.setVisible(false);

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
			} catch (NullPointerException e) {
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
//			grpVariableData.setOpen(true);
//			Messagebox.show("Dataset selected.");
			gridReUploaded = true;
		}
		
//		@NotifyChange("*")
//		@Command()
//		public void displayTextFileContent(@ContextParam(ContextType.COMPONENT) Component component,
//				@ContextParam(ContextType.VIEW) Component view){
//////			setMsaModel(new MultiSiteAnalysisModel());
//			rServeManager = new RServeManager();
//			rServeManager.doMultiEnvironmentOneStage(getMsaModel());
//////			rServeManager.doMultiEnvironmentAnalysis(new SingleSiteAnalysisModel());
//			System.out.println("end rserve multisiteAnalysis");
//		}

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
		public void validateMsaInputs() {
			// TODO Auto-generated method stub
			//		try{
			if(validateMsaModel()){
				System.out.println("pasing variables: "+ msaModel.toString());
				Map<String,Object> args = new HashMap<String,Object>();
				args.put("msaModel", msaModel);
				BindUtils.postGlobalCommand(null, null, "displayMsaResult", args);
			} else Messagebox.show(errorMessage);
		}

		private boolean validateMsaModel() {
			// TODO Auto-generated method stub

			String folderPath = AnalysisUtils.createOutputFolder(fileName.replaceAll(" ", ""), "msa");
			//set Paths
			msaModel.setResultFolderPath(folderPath);


			userFileManager.moveUploadedFileToOutputFolder(folderPath, fileName.replaceAll(" ", ""), uploadedFile);

			msaModel.setOutFileName(msaModel.getResultFolderPath()+ "MEA_output.txt");

			//set Vars
			
			if(!respvars.isEmpty()) msaModel.setRespvars(respvars.toArray(new String[respvars.size()]));
			else{
				errorMessage = "response variable cannot be empty";
				return false;
			}
			
			if(!envTextBox.getValue().isEmpty()) msaModel.setEnvironment(envTextBox.getValue());
			else{
				errorMessage = "environment cannot be empty";
				return false;
			}

			if(!genotypeTextBox.getValue().isEmpty()) msaModel.setGenotype(genotypeTextBox.getValue());
			else{
				errorMessage = "genotype cannot be empty";
				return false;
			}
			
			if(!blockTextBox.getValue().isEmpty())msaModel.setBlock(blockTextBox.getValue());
			else if(blockRow.isVisible() ){
				errorMessage = "block cannot be empty";
				return false;
			}

			if(!replicateTextBox.getValue().isEmpty())msaModel.setRep(replicateTextBox.getValue());
			else if(replicateRow.isVisible()){
				errorMessage = "replicate cannot be empty";
				return false;
			}

			if(!rowTextBox.getValue().isEmpty()) msaModel.setRow(rowTextBox.getValue());
			else if(rowRow.isVisible()){
				errorMessage = "row cannot be empty";
				return false;
			}

			if(!columnTextBox.getValue().isEmpty()) msaModel.setColumn(columnTextBox.getValue());
			else if(columnRow.isVisible()){
				errorMessage = "column cannot be empty";
				return false;
			}

			//Graph Options
			msaModel.setBoxplotRawData(boxplotCheckBox.isChecked());
			msaModel.setHistogramRawData(histogramCheckBox.isChecked());
			msaModel.setDiagnosticPlot(diagnosticplotCheckBox.isChecked());

			msaModel.setDescriptiveStat(checkBoxDescriptiveStat.isChecked());
			msaModel.setVarianceComponents(checkBoxVarComponents.isChecked());

			if(!msaModel.getEnvironment().isEmpty()){
				System.out.println("set Environment Levels for:"+ msaModel.getEnvironment());
				msaModel.setEnvironmentLevels(rServeManager.getLevels(columnList, dataList, msaModel.getEnvironment()));
			}
			else msaModel.setEnvironment("NULL");

			msaModel.setGenotypeLevels(rServeManager.getLevels(columnList, dataList, msaModel.getGenotype()));

			msaModel.setGenotypeRandom(randomCheckBox.isChecked());
			msaModel.setGenotypeFixed(fixedCheckBox.isChecked());
			msaModel.setAmmi(checkBoxAmmi.isChecked());
			msaModel.setGge(checkBoxGge.isChecked());
			msaModel.setStabilityFinlay(checkBoxStabilityFinlayWilkinson.isChecked());
			msaModel.setStabilityShukla(checkBoxStabilityShukla.isChecked());
			
			if(!msaModel.isGenotypeFixed() && !msaModel.isGenotypeRandom()){
				errorMessage = "Please specify whether the genotype variable is fixed or random.";
				return false;
			}

			if(msaModel.isGenotypeFixed()){//if fixed is checked
				msaModel.setPerformPairwise(performPairwiseCheckBox.isChecked());
				msaModel.setPerformAllPairwise(performAllPairwiseBtn.isChecked());
				msaModel.setCompareControl(compareWithControlsBtn.isChecked());
				if(msaModel.isPerformPairwise()){
					if(msaModel.isPerformAllPairwise()){
						if(pairwiseAlphaTextBox.getValue().toString().isEmpty()){
							errorMessage = "Please add a value for the pairwise level of significance.";
							return false;
						}else msaModel.setPairwiseAlpha(Double.toString(pairwiseAlphaTextBox.getValue()));
					}
					else{
						msaModel.setControlLevels(AnalysisUtils.getItemsFromListAsStringAyrray(controlsLb));
						//					ssaModel.setControlLevels(controls.toArray(new String[controls.size()]));
						if(msaModel.getControlLevels().length<1){
							errorMessage = "Please specify control variables from the genotype levels.";
							return false;
						}
					}
				}
			}

			if(msaModel.isGenotypeRandom()){//if random is checked

				if(checkBoxExcludeControls.isChecked() && !(compareWithControlsBtn.isChecked() && compareWithControlsBtn.isChecked())){
					msaModel.setControlLevels(AnalysisUtils.getItemsFromListAsStringAyrray(controlsLb));
					if(msaModel.getControlLevels().length<1 && (msaModel.getDesign()== 1 || msaModel.getDesign() == 2 )){
						errorMessage = "Please specify control variables from the genotype levels.";
						return false;
					}
				}
			}

			return true;
		}

		@Command("checkIfRandomOrFixedIsSelected")
		public void checkIfRandomOrFixedIsSelected() {
			if(!fixedCheckBox.isChecked() && !randomCheckBox.isChecked()){
				 Messagebox.show("Please specify whether the genotype variable is fixed or random.");
				 tabBox.setSelectedIndex(0);
			}
		}
		
		@GlobalCommand("chooseVariable")
		@NotifyChange("*")
		public boolean chooseVariable(@BindingParam("varTextBox") Textbox varTextBox, @BindingParam("imgButton") Image imgButton ) {
			Set<String> set = factorModel.getSelection();
			System.out.println("chooseVariables");
			if(varTextBox.getValue().isEmpty() && !set.isEmpty()){
				System.out.println("adding variables");
				for (String selectedItem : set) {
					varTextBox.setValue(selectedItem);
					factorModel.remove(selectedItem);
				}
				if(varTextBox.getId().equals("genotypeTextBox")){
					System.out.println("addGenotypeLevels");
					genotypeLevels = rServeManager.getLevels(columnList, dataList, genotypeTextBox.getValue());
					genotypeLevelsModel = AnalysisUtils.toListModelList(genotypeLevels);
					genotypeLevelsLb.setModel(genotypeLevelsModel);

					if(genotypeLevels.length>15){
						performAllPairwiseBtn.setDisabled(true);
						performAllPairwiseBtn.setChecked(false);
						compareWithControlsBtn.setChecked(true);
					}else performAllPairwiseBtn.setDisabled(false);
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

		@GlobalCommand("moveListItem")
		@NotifyChange("*")
		public void moveListItem(@BindingParam("fromList") Listbox fromList, @BindingParam("toList") Listbox toList ) {

			for (Listitem selectedItem : fromList.getSelectedItems()) {
				toList.appendChild(selectedItem);
				fromList.removeChild(selectedItem);
			}
			// TODO Auto-generated method stub
		}

		
		@Command("checkIfGenotypeOptionIsSelected")
		public void checkIfGenotypeOptionIsSelected(@BindingParam("selected") String selected, @BindingParam("groupbox") Groupbox groupbox) {

			Checkbox checkbox = (Checkbox) incVariableList.getFellow(selected);	
			if(checkbox.isChecked())return;
			else{
				groupbox.setOpen(false);
				Messagebox.show("Please define genotype as "+checkbox.getLabel()+" effect to view this option.","Option not available", Messagebox.OK, Messagebox.ERROR);
				
			}
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

		public MultiSiteAnalysisModel getMsaModel() {
			return msaModel;
		}

		public void setMsaModel(MultiSiteAnalysisModel msaModel) {
			this.msaModel = msaModel;
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

		public Study getSelectedStudy() {
			return selectedStudy;
		}

		public void setSelectedStudy(Study selectedStudy) {
			this.selectedStudy = selectedStudy;
		}

		public StudyDataSet getSelectedDataSet() {
			return selectedDataSet;
		}

		public void setSelectedDataSet(StudyDataSet selectedDataSet) {
			this.selectedDataSet = selectedDataSet;
		}

		public List<Study> getStudies() {
			return studies;
		}

		public void setStudies(List<Study> studies) {
			this.studies = studies;
		}

		@NotifyChange("*")
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		@NotifyChange("*")
		public int getActivePage() {
			return activePage;
		}

		public List<StudyDataSet> getStudyDataSets() {
			return studyDataSets;
		}

		public void setStudyDataSets(List<StudyDataSet> studyDataSets){
			this.studyDataSets = studyDataSets;
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

		public boolean isGenotypeControlsOpen() {
			return genotypeControlsOpen;
		}

		public void setGenotypeControlsOpen(boolean genotypeControlsOpen) {
			this.genotypeControlsOpen = genotypeControlsOpen;
		}
	}