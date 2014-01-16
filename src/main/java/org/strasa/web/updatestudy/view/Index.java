package org.strasa.web.updatestudy.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
import org.strasa.web.uploadstudy.view.model.UploadData;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;

import com.mysql.jdbc.StringUtils;

public class Index {

	@Wire("#rawDataTab")
	Tabbox rawDataTab;


	@Wire("#derivedDataTab")
	Tabbox derivedDataTab;
	
	
	
	ArrayList<Tabpanel> arrTabPanels = new ArrayList<Tabpanel>();
	private UploadData uploadData;
	private int selectedIndex = 1;
	private boolean[] tabDisabled = { false, true, true, true, true };

	private boolean isRaw;
	private ProcessTabViewModel uploadModel;
	private int datasetCount;
	// imported in UploadData.java
	private Study study;
	private int userID = 1;
	private ArrayList<Program> programList = new ArrayList<Program>();
	private ArrayList<Project> projectList = new ArrayList<Project>();
	private ArrayList<String> studyTypeList = new ArrayList<String>();

	private Program txtProgram = new Program();
	private Project txtProject = new Project();
	private boolean isDataUploaded = false;

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
		programList.addAll(programMan.getProgramByUserId(userID));
		System.out.print(selected);
		txtProgram = selected;

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
		projectList.addAll(programMan.getProjectList(userID, selected));

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
		
		initializeDataSetTab(new StudyDataSet(), false, datatype);
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
	
		List<StudyDataSet> studyDataSets = new StudyDataSetManagerImpl().getDataSetsByStudyId(this.uploadModel.studyID);
		for(StudyDataSet datasetNum : studyDataSets){
		
			initializeDataSetTab(datasetNum, true, datasetNum.getDatatype().equals("rd"));	
		}
		if(derivedDataTab.getTabs().getChildren().isEmpty())initializeDataSetTab(new StudyDataSet(), false, false);	
		if(rawDataTab.getTabs().getChildren().isEmpty())initializeDataSetTab(new StudyDataSet(), false, true);	
		
		
	}

	public void initializeDataSetTab(StudyDataSet dataset, boolean isUpdateMode, boolean isRaw) {
		if(rawDataTab == null)System.out.println("TABBOX IS NULL!");
		Tab newTab = new Tab("Dataset " + datasetinc);
		datasetinc++;
		newTab.setSelected(true);
		newTab.setId("dataset"+dataset);
		Tabpanel newTabpanel = new Tabpanel();
		// newTabpanel.appendChild();
		if(isRaw){
		rawDataTab.getTabs().getChildren().add(newTab);
		newTabpanel.setParent(rawDataTab.getTabpanels());
		}
		else{
			derivedDataTab.getTabs().getChildren().add(newTab);
			newTabpanel.setParent(derivedDataTab.getTabpanels());
		}
		Map arg = new HashMap();
		ProcessTabViewModel newUploadModel = new ProcessTabViewModel();
		newUploadModel.dataset = dataset;
		newUploadModel.isUpdateMode = isUpdateMode;
		newUploadModel.studyID = uploadModel.studyID;
		newUploadModel.isRaw = isRaw;
		System.out.println(newUploadModel.toString());
		arg.put("uploadModel", newUploadModel);

		Executions.createComponents("/user/updatestudy/datasettab.zul", newTabpanel, arg);

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

}
