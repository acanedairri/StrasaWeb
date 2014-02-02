package org.strasa.web.updatestudy.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyDataSetManagerImpl;
import org.strasa.middleware.manager.StudyManager;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudyTypeManagerImpl;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyDataSet;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.strasa.web.uploadstudy.view.model.AddProgram;
import org.strasa.web.uploadstudy.view.model.AddProject;
import org.strasa.web.uploadstudy.view.model.UploadData;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Window;

public class Index {

	@Wire("#rawDataTab")
	Tabbox rawDataTab;


	@Wire("#derivedDataTab")
	Tabbox derivedDataTab;
	
	@Wire("#tabGenotypeData")
	Tabpanel tabGenotype;
	
	@Command("addProgram")
	public void addProgram(@ContextParam(ContextType.VIEW) Component view) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar", null);
		params.put("parent", view);

		Window popup = (Window) Executions.createComponents(
				AddProgram.ZUL_PATH, view, params);

		popup.doModal();
	}

	

	@Command("addProject")
	public void addProject(@ContextParam(ContextType.VIEW) Component view) {

		if (txtProgram == null) {
			Messagebox.show("Error: Please specify/select a program first.",
					"Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar", null);
		params.put("parent", view);
		params.put("programID", txtProgram.getId());

		Window popup = (Window) Executions.createComponents(
				AddProject.ZUL_PATH, view, params);

		popup.doModal();
	}
	
	ArrayList<Tabpanel> arrTabPanels = new ArrayList<Tabpanel>();
	private UploadData uploadData;
	private int selectedIndex = 1;
	private boolean[] tabDisabled = { false, true, true, true, true };
	private Tab firstRawTab, firstDerivedTab, firstGenotypeTab;
	private boolean isRaw;
	private ProcessTabViewModel uploadModel;
	private int datasetCount;
	// imported in UploadData.java
	private Study study;
	private int userID = 1;
	private ArrayList<Program> programList = new ArrayList<Program>();
	private ArrayList<Project> projectList = new ArrayList<Project>();
	private ArrayList<String> studyTypeList = new ArrayList<String>();
	private HashMap<String,tabObject> tabMap = new HashMap<String,tabObject>();
	private Program txtProgram = new Program();
	private Project txtProject = new Project();
	private boolean isDataUploaded = false;
	
	private boolean hasRawTabLoaded, hasDerivedLoaded,hasGenotypeLoaded;
	public boolean isDataUploaded() {
		return isDataUploaded;
	}

	public void setDataUploaded(boolean isDataUploaded) {
		this.isDataUploaded = isDataUploaded;
	}

	public Program getTxtProgram() {
		return txtProgram;
	}

	@NotifyChange({ "projectList", "txtProject" })
	public void setTxtProgram(Program txtProgram) {
		refreshProjectList(txtProgram);
		this.txtProgram = txtProgram;
		txtProject = null;
	}

	public void setTxtProject(Project txtProject) {
		this.txtProject = txtProject;
	}

	private String txtStudyName = new String();
	private String txtStudyType = new String();
	private int startYear = Calendar.getInstance().get(Calendar.YEAR);
	private int endYear = Calendar.getInstance().get(Calendar.YEAR);
	private boolean isNewDataSet;

	private int  datasetinc = 1;

	public ArrayList<Program> getProgramList() {
		return programList;
	}

	public void setProgramList(ArrayList<Program> programList) {
		this.programList = programList;
	}

	public ArrayList<Project> getProjectList() {
		return projectList;
	}

	public ArrayList<String> getStudyTypeList() {
		return studyTypeList;
	}

	public void setStudyTypeList(ArrayList<String> studyTypeList) {
		this.studyTypeList = studyTypeList;
	}

	public void setProjectList(ArrayList<Project> projectList) {
		this.projectList = projectList;
	}

	public String getTxtStudyName() {
		return txtStudyName;
	}

	public void setTxtStudyName(String txtStudyName) {
		this.txtStudyName = txtStudyName;
	}

	public String getTxtStudyType() {
		return txtStudyType;
	}

	public void setTxtStudyType(String txtStudyType) {
		this.txtStudyType = txtStudyType;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public Project getTxtProject() {
		return txtProject;
	}

	@NotifyChange("*")
	@Command("refreshProgramList")
	public void refreshProgramList(@BindingParam("selected") Program selected) {

		ProgramManagerImpl programMan = new ProgramManagerImpl();
		programList.clear();
		programList.addAll(programMan.getAllProgram());
		System.out.print(selected);
		txtProgram = selected;
		refreshProjectList(selected);

	}
	
	public void closeAllTabs(boolean isRaw){
		for(tabObject tObj : tabMap.values()){
			if(tObj.isRaw)tObj.tab.close();
		}
	}
	public void getFirstTabSelected(boolean isRaw){
		for(tabObject tObj : tabMap.values()){
			if(tObj.isRaw)Events.sendEvent("onClick",tObj.tab,tObj.tab);;
		}
	}
	 @SuppressWarnings("unchecked")
	@Command
	 public void mergeData(){
		
			Messagebox
			.show("Are you sure you want to merge the datasets? WARNING! This cannot be undone.",
					"Delete dataset?", Messagebox.OK | Messagebox.CANCEL,
					Messagebox.QUESTION, new EventListener() {
				public void onEvent(Event e) {
					if ("onOK".equals(e.getName())) {
						 new StudyManagerImpl().mergeStudyData(uploadModel.getStudyID(), uploadModel.isRaw);
					closeAllTabs(Index.this.uploadModel.isRaw);
						 
							boolean rawLoaded = false, derivedLoaded = false;
							
							List<StudyDataSet> studyDataSets = new StudyDataSetManagerImpl().getDataSetsByStudyId(Index.this.uploadModel.studyID);
							for(StudyDataSet datasetNum : studyDataSets){
							
								
								if( datasetNum.getDatatype().equals("rd")){
									if(!rawLoaded){
										rawLoaded = true;
									}
								}
								else{
									if(!derivedLoaded){
										derivedLoaded = true;
							
									}
								}
								initializeDataSetTab(datasetNum, true, datasetNum.getDatatype().equals("rd"),false);
								
							}
							getFirstTabSelected(Index.this.uploadModel.isRaw);
					} else if ("onCancel".equals(e.getName())) {

					}

					/*
					 * Event Name Mapping list Messagebox.YES =
					 * "onYes"; Messagebox.NO = "onNo";
					 * Messagebox.RETRY = "onRetry";
					 * Messagebox.ABORT = "onAbort";
					 * Messagebox.IGNORE = "onIgnore";
					 * Messagebox.CANCEL = "onCancel"; Messagebox.OK
					 * = "onOK";
					 */
				}
			});
	 }
	@NotifyChange({ "txtProject", "projectList" })
	@Command("changeProjectList")
	public void changeProjectList(@BindingParam("selected") Project selected) {
		refreshProjectList(txtProgram);
		txtProject = selected;

	}

	@NotifyChange("projectList")
	@Command("refreshProjectList")
	public void refreshProjectList(@BindingParam("selected") Program selected) {

		txtProject = null;
		if (selected == null) {
			projectList.clear();
			return;

		}

		ProjectManagerImpl programMan = new ProjectManagerImpl();
		projectList.clear();
		projectList.addAll(programMan.getProjectList( selected));

	}

	// end

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public UploadData getUploadData() {
		return uploadData;
	}

	public void setUploadData(UploadData uploadData) {
		this.uploadData = uploadData;
	}

	public boolean[] getTabDisabled() {
		return tabDisabled;
	}

	public void setTabDisabled(boolean[] tabDisabled) {
		this.tabDisabled = tabDisabled;
	}

	@Command
	public void addNewDataset(@BindingParam("datatype") boolean datatype){
		StudyDataSet newDataset = new StudyDataSet();
		newDataset.setTitle("New DataSet");
		initializeDataSetTab(newDataset, false, datatype,true);
	
	}
	@Command
	public void saveStudyInformation() {
		if (txtProgram == null || txtProject == null || txtStudyName == null
				|| txtStudyType == null) {
			Messagebox.show("Error: All fields are required", "Upload Error",
					Messagebox.OK, Messagebox.ERROR);

			// TODO: must have message DIalog
			return;
		}

		if (txtProgram == null || txtProject == null || txtStudyName.isEmpty()
				|| txtStudyType.isEmpty()) {
			Messagebox.show("Error: All fields are requiredx", "Upload Error",
					Messagebox.OK, Messagebox.ERROR);

			// TODO: must have message DIalog
			return;
		}

		if (startYear < Calendar.getInstance().get(Calendar.YEAR)) {
			Messagebox
					.show("Error: Invalid start year. Year must be greater or equal than the present year("
							+ Calendar.getInstance().get(Calendar.YEAR) + " )",
							"Upload Error", Messagebox.OK, Messagebox.ERROR);

			return;
		}
		if (endYear < Calendar.getInstance().get(Calendar.YEAR)) {
			Messagebox.show(
					"Error: Invalid end year. Year must be greater or equal than the present year("
							+ Calendar.getInstance().get(Calendar.YEAR) + " )",
					"Upload Error", Messagebox.OK, Messagebox.ERROR);

			return;
		}

		if (study == null) {
			study = new Study();
		}
		study.setName(txtStudyName);
		study.setStudytypeid(new StudyTypeManagerImpl().getStudyTypeByName(
				txtStudyType).getId());
		study.setProgramid(txtProgram.getId());
		study.setProjectid(txtProject.getId());
		study.setStartyear(String.valueOf(startYear));
		study.setEndyear(String.valueOf(String.valueOf(endYear)));
		study.setUserid(userID);
		study.setId(uploadModel.studyID);
		study.setDatelastmodified(new Date());
		if (new StudyManager().isProjectExist(study, userID)) {
			Messagebox
					.show("Error: Study name already exist! Please choose a different name.",
							"Upload Error", Messagebox.OK, Messagebox.ERROR);

			return;
		}
		new StudyManagerImpl().updateStudyById(study);
		Messagebox.show("Study information has been successfully updated.",
				"Information", Messagebox.OK, Messagebox.INFORMATION);

	}

	@Init
	public void init(@ExecutionArgParam("studyID") Integer studyID) {
		// editing mode
		uploadModel = new ProcessTabViewModel();

		refreshProgramList(null);
		refreshProjectList(null);
//		Integer studyIDFromURL = Integer.parseInt(Executions.getCurrent()
//				.getParameter("studyid"));
//		
		if (true) {
			uploadModel.setStudyID(studyID);
			uploadModel.setUpdateMode(true);
			tabDisabled[0] = false;
			tabDisabled[1] = false;
			tabDisabled[2] = false;
			tabDisabled[3] = false;
			tabDisabled[4] = false;

			StudyManagerImpl studyMan = new StudyManagerImpl();
			study = studyMan.getStudyById(uploadModel.getStudyID());
			this.txtStudyName = study.getName();
			this.txtStudyType = new StudyTypeManagerImpl().getStudyTypeById(
					study.getStudytypeid()).getStudytype();
			this.txtProgram = new ProgramManagerImpl().getProgramById(study
					.getProgramid());
			this.txtProject = new ProjectManagerImpl().getProjectById(study
					.getProjectid());
			this.startYear = Integer.parseInt(study.getStartyear());
			this.endYear = Integer.parseInt(study.getEndyear());
			isNewDataSet = false;

		}

	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {

		Selectors.wireComponents(view, this, false);

		// wire event listener
		// Selectors.wireEventListeners(view, this);
	
		boolean rawLoaded = false, derivedLoaded = false;
		
		List<StudyDataSet> studyDataSets = new StudyDataSetManagerImpl().getDataSetsByStudyId(this.uploadModel.studyID);
		for(StudyDataSet datasetNum : studyDataSets){
		
			
			if( datasetNum.getDatatype().equals("rd")){
				if(!rawLoaded){
					rawLoaded = true;
				}
			}
			else{
				if(!derivedLoaded){
					derivedLoaded = true;
		
				}
			}
			initializeDataSetTab(datasetNum, true, datasetNum.getDatatype().equals("rd"),false);	
			
		}
//		if(derivedDataTab.getTabs().getChildren().isEmpty())initializeDataSetTab(new StudyDataSet(), false, false);	
//		if(rawDataTab.getTabs().getChildren().isEmpty())initializeDataSetTab(new StudyDataSet(), false, true);	
		
//		
//		if(derivedLoaded){
//			derivedDataTab.getChildren().remove(0);
//		}
//		if(rawLoaded){
//			rawDataTab.getChildren().remove(0);
//		}
	}
	@GlobalCommand("removeDataSet")
	public void removeDataSet(@BindingParam("dataset") StudyDataSet dataset, @BindingParam("isUpdateMode") boolean isUpdateMode, @BindingParam("isRaw") boolean isRaw){
		System.out.println("REMOVE!");
		initializeDataSetTab(dataset, isUpdateMode, isRaw,true);

		
	}

	
	@GlobalCommand("initializeDataSetTab")
	@SuppressWarnings("unchecked")
	public void initializeDataSetTab(@BindingParam("dataset") StudyDataSet dataset, @BindingParam("isUpdateMode") boolean isUpdateMode, @BindingParam("isRaw") boolean isRaw,boolean selected) {
	System.out.println("TABBOX IS NULL!");
		Tab newTab = new Tab(dataset.getTitle());
		datasetinc++;
		newTab.setSelected(true);
		String tabId = "dataset"+Math.random();
		newTab.setId(tabId);
//		newTab.setClosable(true);

		newTab.addEventListener("onClick", new EventListener(){

			@Override
			public void onEvent(Event arg0) throws Exception {
				if(!Index.this.tabMap.get(arg0.getTarget().getId()).hasBeenLoaded)
				{
					Index.this.tabMap.get(arg0.getTarget().getId()).hasBeenLoaded = true;
					Executions.createComponents("/user/updatestudy/datasettab.zul", Index.this.tabMap.get(arg0.getTarget().getId()).panel,  Index.this.tabMap.get(arg0.getTarget().getId()).arg);
				}
			}});

		Tabpanel newTabpanel = new Tabpanel();
		// newTabpanel.appendChild();
		if(isRaw){
			
			firstRawTab = newTab;
			
			
		rawDataTab.getTabs().getChildren().add(newTab);
		newTabpanel.setParent(rawDataTab.getTabpanels());
		}
		else{
			firstDerivedTab = newTab;
			
			derivedDataTab.getTabs().getChildren().add(newTab);
			newTabpanel.setParent(derivedDataTab.getTabpanels());
		}
		Map arg = new HashMap();
		ProcessTabViewModel newUploadModel = new ProcessTabViewModel();
		newUploadModel.dataset = dataset;
		newUploadModel.isUpdateMode = isUpdateMode;
		newUploadModel.studyID = uploadModel.studyID;
		newUploadModel.isRaw = isRaw;
		newUploadModel.mainTab = newTab;
		newUploadModel.mainTabPanel = newTabpanel;
		System.out.println(newUploadModel.toString());
		arg.put("uploadModel", newUploadModel);
		
		tabMap.put(tabId, new tabObject(arg,newTabpanel,newTab,isRaw));
		if(selected){
			Events.sendEvent("onClick",newTab,newTab);
		}
	}

	@Command
	public void loadRawDataTab(){
		if(firstRawTab == null) return;
		if(hasRawTabLoaded) return;
		Events.sendEvent("onClick",firstRawTab,firstRawTab);
		hasRawTabLoaded = true;
		System.out.println("RAW TAB SELECTED!!");
		
	}
	@Command
	public void loadDerivedDataTab(){
		if(firstDerivedTab == null) return;
		if(hasDerivedLoaded) return;
		Events.sendEvent("onClick",firstDerivedTab,firstDerivedTab);
		hasDerivedLoaded=true;
	}
	@Command
	public void loadGenotypeDataTab(){
		if(hasGenotypeLoaded) return;
		
		showzulfile("/user/updatestudy/genotypicdata.zul",tabGenotype);
		hasGenotypeLoaded=true;
	}
	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName,
			@BindingParam("target") Tabpanel panel) {
		System.out.println(zulFileName);
		if (panel != null && panel.getChildren().isEmpty()) {
			Map arg = new HashMap();
			arg.put("uploadModel", uploadModel);

			Executions.createComponents(zulFileName, panel, arg);

		}
	}
	
	public class tabObject {
		public Map arg;
		public Tab tab;
		public Tabpanel panel;
		public boolean hasBeenLoaded=false;
		public boolean isRaw;
		public tabObject(Map arg0, Tabpanel arg1, Tab arg2, boolean raw){
			this.arg = arg0;
			this.panel = arg1;
			this.tab = arg2;
			this.isRaw = raw;
		}
	}

}
