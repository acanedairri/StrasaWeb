package org.strasa.web.uploadstudy.view.model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.web.common.api.ProccessTabViewModel;
import org.strasa.web.uploadstudy.view.pojos.UploadCSVDataVariableModel;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
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
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import au.com.bytecode.opencsv.CSVReader;

public class UploadData implements ProccessTabViewModel{

	private List<String[]> dataList = new ArrayList<String[]>();
	private List<String> columnList = new ArrayList<String>();
	private ArrayList<String> programList = new ArrayList<String>();
	private ArrayList<String> projectList = new ArrayList<String>();
	private ArrayList<String> studyTypeList = new ArrayList<String>();

	private ArrayList<String> dataTypeList = new ArrayList<String>();
	private String txtProgram;
	private String txtProject;
	private String txtStudyName;
	private String txtStudyType;
	private String txtYear;

	public ArrayList<String> getProgramList() {
		return programList;
	}
	public void setProgramList(ArrayList<String> programList) {
		this.programList = programList;
	}
	public ArrayList<String> getProjectList() {
		return projectList;
	}
	public void setProjectList(ArrayList<String> projectList) {
		this.projectList = projectList;
	}
	public ArrayList<String> getDataTypeList() {
		return dataTypeList;
	}
	public void setDataTypeList(ArrayList<String> dataTypeList) {
		this.dataTypeList = dataTypeList;
	}
	public ArrayList<String> getStudyTypeList() {
		return studyTypeList;
	}
	public void setStudyTypeList(ArrayList<String> studyTypeList) {
		this.studyTypeList = studyTypeList;
	}
	public String getTxtProgram() {
		return txtProgram;
	}
	public void setTxtProgram(String txtProgram) {
		this.txtProgram = txtProgram;
	}
	public String getTxtProject() {
		return txtProject;
	}
	public void setTxtProject(String txtProject) {
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
	public String getTxtYear() {
		return txtYear;
	}
	public void setTxtYear(String txtYear) {
		this.txtYear = txtYear;
	}
	public List<String> getColumnList() {
		return columnList;
	}
	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}
	
	public List<String[]> getDataList() {
		return dataList;
	}
	public void setDataList(List<String[]> dataList) {
		this.dataList = dataList;
	}
	public String dataFileName;
	public boolean isVariableDataVisible = false;
	private Component mainView;

	public String getDataFileName() {
		return dataFileName;
	}
	
	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view){
		mainView = view;

		refreshProgramList(null);
		refreshProjectList(null);
	}

	public List<UploadCSVDataVariableModel> varData = new ArrayList<UploadCSVDataVariableModel>();
	private String path;
	private String dataPath;

	public boolean isVariableDataVisible() {
		return isVariableDataVisible;
	}

	public void setVariableDataVisible(boolean isVariableDataVisible) {
		this.isVariableDataVisible = isVariableDataVisible;
	}

	public List<UploadCSVDataVariableModel>  getVarData() {
		return varData;
	}

	@Command
	@NotifyChange("variableData")
	public void changeVar(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view ,@BindingParam("oldVar") String oldVar) {

		Map<String, Object> params = new HashMap<String, Object>();
		System.out.println(oldVar);
		params.put("oldVar",oldVar);
		params.put("parent", view);

		Window popup = (Window) Executions.createComponents(ChangeCsvHeader.ZUL_PATH, view, params);

		popup.doModal();
	}

	public void openCSVHeaderValidator(String CSVPath){
		Map<String, Object> params = new HashMap<String, Object>();
		dataPath = CSVPath;
		params.put("CSVPath",CSVPath);
		params.put("parent", mainView);

		Window popup = (Window) Executions.createComponents(ValidateCsvHeader.ZUL_PATH, mainView, params);

		popup.doModal();
	}

	@NotifyChange("*")
	@Command("refreshVarList")
	public void refreshList(@BindingParam("newValue") String newValue, @BindingParam("oldVar") String oldVar){
		for(int i = 0; i < varData.size(); i++){

			if(varData.get(i).getCurrentVariable().equals(oldVar)) {
				System.out.println("   ss");
				varData.get(i).setNewVariable(newValue);
			}

		}


	}

	@NotifyChange("*")
	@Command("uploadCSV")
	public void uploadCSV(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view) {

		UploadEvent event = (UploadEvent)ctx.getTriggerEvent();
		if(event.getMedia().isBinary()){
			Messagebox.show("Error: File must be a text-based csv format", "Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}

		//		System.out.println(event.getMedia().getStringData());


		String name = event.getMedia().getName();

		path = Sessions.getCurrent().getWebApp().getRealPath("/UPLOADS/") + "/";                


		this.uploadFile(path, name,  event.getMedia().getStringData());       
		BindUtils.postNotifyChange(null, null, this, "*");

		ArrayList<String> invalidHeader = new ArrayList<String>();

		try {
			StudyVariableManagerImpl studyVarMan = new StudyVariableManagerImpl();
			CSVReader reader = new CSVReader(new FileReader(path+name));
			String[] header = reader.readNext();
			for(String column : header){
				if(!studyVarMan.hasVariable(column)){
					invalidHeader.add(column);
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


		populateVarData(invalidHeader);
		isVariableDataVisible = true;
		dataFileName = name ;
		openCSVHeaderValidator(path+name);

	}


	@NotifyChange("varData")
	public void populateVarData(ArrayList<String> list){
		for(String var : list){
			varData.add(new UploadCSVDataVariableModel(var,"-"));
		}
	}

	@NotifyChange("*")
	@Command("removeUpload")
	public void removeUpload(){
		isVariableDataVisible = false;
		dataFileName = "";
		varData.clear();
	}
	public void uploadFile(String path, String name, 
			String data) {

		String filePath = path + name ;

		try {
			PrintWriter out = new PrintWriter(filePath);
			out.println(data);
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@NotifyChange("*")
	@Command("refreshCsv")
	public void refreshCsv(){
	    CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(dataPath));
			 List<String[]> rawData = reader.readAll();
			 columnList.clear();
			 dataList.clear();
			 columnList = new ArrayList<String>(Arrays.asList(rawData.get(0)));
			 rawData.remove(0);
			 dataList = new ArrayList<String[]>(rawData);
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

	@Command("addProgram")
	public void addProgram(){
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar",null);
		params.put("parent", mainView);

		Window popup = (Window) Executions.createComponents(UploadDataAddProgram.ZUL_PATH, mainView, params);

		popup.doModal();
	}
	@Command("addProject")
	public void addProject(){
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("oldVar",null);
		params.put("parent", mainView);

		Window popup = (Window) Executions.createComponents(UploadDataAddProject.ZUL_PATH, mainView, params);

		popup.doModal();
	}
	@NotifyChange("*")
	@Command("refreshProgramList")
	public void refreshProgramList(@BindingParam("selected") String selected){

		ProgramManagerImpl programMan = new ProgramManagerImpl();
		programList.clear();
		for(Program data : programMan.getProgramByUserId(1)){
			programList.add(data.getName());
			
		}
		System.out.print(selected);
		txtProgram = selected;


	}
	
	
	@NotifyChange("*")
	@Command("refreshProjectList")
	public void refreshProjectList(@BindingParam("selected") String selected){

		ProjectManagerImpl programMan = new ProjectManagerImpl();
		projectList.clear();
		for(Project data : programMan.getProjectByUserId(1)){
			projectList.add(data.getName());
			
		}
		System.out.print(selected);
		txtProject = selected;


	}

	@GlobalCommand
	public void testGlobalCom(@BindingParam("newVal")double newVal){
		System.out.println("globalCom: " + newVal);
	}
	@Override
	public boolean validateTab() {
		if(txtProgram == null) 
		return false;
		else
			return true;
	}
	@Override
	
	public void init(@ExecutionArgParam("studyID") double studyID) {
		// TODO Auto-generated method stub
		
	}
	


}
