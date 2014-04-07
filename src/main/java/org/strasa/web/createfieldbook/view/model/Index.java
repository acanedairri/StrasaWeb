package org.strasa.web.createfieldbook.view.model;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.strasa.middleware.manager.CreateFieldBookManagerImpl;
import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyManager;
import org.strasa.middleware.manager.StudyTypeManagerImpl;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyType;
import org.strasa.web.createfieldbook.view.pojos.SiteInformationModel;
import org.strasa.web.updatestudy.view.Index.tabObject;
import org.strasa.web.uploadstudy.view.model.AddProgram;
import org.strasa.web.uploadstudy.view.model.AddProject;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Window;

public class Index {

	@Init
	public void init() {
		refreshProgramList(null);
		refreshProjectList(null);
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	private String txtStudyName = new String();
	private String txtStudyType = new String();
	private int startYear = Calendar.getInstance().get(Calendar.YEAR);
	private int endYear = Calendar.getInstance().get(Calendar.YEAR);
	private Study study;
	private ArrayList<Program> programList = new ArrayList<Program>();
	private ArrayList<Project> projectList = new ArrayList<Project>();
	private ArrayList<String> studyTypeList = new ArrayList<String>();
	private HashMap<String, tabObject> tabMap = new HashMap<String, tabObject>();
	private Program txtProgram = new Program();
	private Project txtProject = new Project();
	private ArrayList<SiteInformationModel> lstSiteInfo = new ArrayList<SiteInformationModel>();

	@Wire("#tabboxSites")
	private Tabbox siteTabBox;

	@Command
	public void addSite(@ContextParam(ContextType.VIEW) Component view) {
		if (siteTabBox == null) {

			System.out.println("TABBOX NULL!!");
			siteTabBox = (Tabbox) view.getFellow("tabboxSites");
		}

		Tab newTab = new Tab();
		newTab.setClosable(true);
		newTab.setLabel("New Site");
		newTab.setParent(siteTabBox.getTabs());
		newTab.setSelected(true);

		Tabpanel newTabPanel = new Tabpanel();
		newTabPanel.setParent(siteTabBox.getTabpanels());
		Include inc = new Include();
		inc.setSrc("/user/createfieldbook/fieldbooksitetab.zul");
		SiteInformationModel newSiteModel = new SiteInformationModel();
		inc.setDynamicProperty("SiteModel", newSiteModel);
		inc.setDynamicProperty("SiteTab", newTab);
		inc.setParent(newTabPanel);
		lstSiteInfo.add(newSiteModel);

		newTab.setAttribute("site", newSiteModel);
		newTab.addEventListener(Events.ON_CLOSE, new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				// event.stopPropagation();
				lstSiteInfo.remove(event.getTarget().getAttribute("site"));
				return;
			}

		});

		view.getFellow("gbSiteInfo").invalidate();
	}

	@Command("addProgram")
	public void addProgram(@ContextParam(ContextType.VIEW) Component view) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar", null);
		params.put("parent", view);

		Window popup = (Window) Executions.createComponents(AddProgram.ZUL_PATH, view, params);

		popup.doModal();
	}

	@Command("addProject")
	public void addProject(@ContextParam(ContextType.VIEW) Component view) {

		if (txtProgram == null) {
			Messagebox.show("Error: Please specify/select a program first.", "Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar", null);
		params.put("parent", view);
		params.put("programID", txtProgram.getId());

		Window popup = (Window) Executions.createComponents(AddProject.ZUL_PATH, view, params);

		popup.doModal();
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
		projectList.addAll(programMan.getProjectList(selected));

	}

	@NotifyChange({ "projectList", "txtProject" })
	public void setTxtProgram(Program txtProgram) {
		refreshProjectList(txtProgram);
		this.txtProgram = txtProgram;
		txtProject = null;
	}

	@Command
	public void generateFieldBook() {

		if (txtProgram == null || txtProject == null || txtStudyName == null || txtStudyType == null) {
			Messagebox.show("Error: All fields are required", " Error", Messagebox.OK, Messagebox.ERROR);
			System.out.println("1 + " + txtProgram);
			System.out.println("2 + " + txtProject);
			System.out.println("3 + " + txtStudyName);
			System.out.println("4 + " + txtStudyType);

			// TODO: must have message DIalog
			return;
		}

		if (txtProgram == null || txtProject == null || txtStudyName.isEmpty() || txtStudyType.isEmpty()) {
			Messagebox.show("Error: All fields are requiredx", "Upload Error", Messagebox.OK, Messagebox.ERROR);

			// TODO: must have message DIalog
			return;
		}

		if (startYear < Calendar.getInstance().get(Calendar.YEAR)) {
			Messagebox.show("Error: Invalid start year. Year must be greater or equal than the present year(" + Calendar.getInstance().get(Calendar.YEAR) + " )", "Upload Error", Messagebox.OK, Messagebox.ERROR);

			return;
		}
		if (endYear < Calendar.getInstance().get(Calendar.YEAR)) {
			Messagebox.show("Error: Invalid end year. Year must be greater or equal than the present year(" + Calendar.getInstance().get(Calendar.YEAR) + " )", "Upload Error", Messagebox.OK, Messagebox.ERROR);

			return;
		}

		if (study == null) {
			study = new Study();
		}
		study.setName(txtStudyName);
		study.setStudytypeid(new StudyTypeManagerImpl().getStudyTypeByName(txtStudyType).getId());
		study.setProgramid(txtProgram.getId());
		study.setProjectid(txtProject.getId());
		study.setStartyear(String.valueOf(startYear));
		study.setEndyear(String.valueOf(String.valueOf(endYear)));
		study.setUserid(1);
		study.setShared(false);
		study.setDatecreated(new Date());
		study.setDatelastmodified(new Date());
		if (study.getId() == null && new StudyManager().isProjectExist(study, 1)) {
			Messagebox.show("Error: Study name already exist! Please choose a different name.", "Upload Error", Messagebox.OK, Messagebox.ERROR);

			return;
		}

		System.out.println("lstTest : " + lstSiteInfo.get(0).getSitename());
		File outputFolder = new File(Executions.getCurrent().getDesktop().getWebApp().getRealPath("/") + "ExcelOutput/");
		if (!outputFolder.exists())
			outputFolder.mkdirs();
		CreateFieldBookManagerImpl createFieldBookMan = new CreateFieldBookManagerImpl(lstSiteInfo, study, outputFolder);
		try {
			Filedownload.save(new FileInputStream(createFieldBookMan.generateFieldBook().getAbsolutePath()), "application/vnd.ms-excel", study.getName() + ".xls");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void setTxtProject(Project txtProject) {
		this.txtProject = txtProject;
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

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public ArrayList<Program> getProgramList() {
		return programList;
	}

	public void setProgramList(ArrayList<Program> programList) {
		this.programList = programList;
	}

	public ArrayList<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(ArrayList<Project> projectList) {
		this.projectList = projectList;
	}

	public ArrayList<String> getStudyTypeList() {
		studyTypeList.clear();

		for (StudyType studyType : new StudyTypeManagerImpl().getAllStudyType()) {
			studyTypeList.add(studyType.getStudytype());
		}
		;
		return studyTypeList;
	}

	public void setStudyTypeList(ArrayList<String> studyTypeList) {
		this.studyTypeList = studyTypeList;
	}

	public HashMap<String, tabObject> getTabMap() {
		return tabMap;
	}

	public void setTabMap(HashMap<String, tabObject> tabMap) {
		this.tabMap = tabMap;
	}

	public Program getTxtProgram() {
		return txtProgram;
	}

	public Project getTxtProject() {
		return txtProject;
	}

}
