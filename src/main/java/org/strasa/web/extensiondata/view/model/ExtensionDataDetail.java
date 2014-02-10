package org.strasa.web.extensiondata.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.model.ExtensionData;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.web.extensiondata.view.model.EditExtensionData.RowStatus;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

public class ExtensionDataDetail {

	private ProgramManagerImpl programMan;
	private ProjectManagerImpl projectMan;
	private ExtensionDataManagerImpl mgr;

	private List<ExtensionDataSummaryModel> summaryByCountry;
	private List<ExtensionDataSummaryModel> summaryByYear;
	private List<ExtensionDataListModel> extensionDataList;
	private List<SummaryModel> summaryArea;
	private List<RowStatus> rowList = new ArrayList<RowStatus>();
	
	private List<SummaryModel> areaSummaryGermplasmByYearandCountryExtension;
	private List<SummaryModel> areaSummaryGermplasmByYear;
	private List<SummaryModel> areaSummaryGermplasmByCountryExtension;
	private List<SummaryModel> noOfVarietyReleaseByCountryAndYear;
	private List<SummaryModel> noOfVarietyReleaseByCountryRelease;
	private List<SummaryModel> noOfVarietyReleaseByYear;
	

	private HashMap<Integer,String> programKeyList = new HashMap<Integer,String>();
	private HashMap<Integer,String> projectKeyList = new HashMap<Integer,String>();
	
	private Tab detailTab;
	
	public Tab getDetailTab() {
		return detailTab;
	}

	public void setDetailTab(Tab detailTab) {
		this.detailTab = detailTab;
	}

	@Init
	public void AfterCompose(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("detailTab") Tab detailTab){
		setDetailTab(detailTab);
		mgr= new ExtensionDataManagerImpl();
		programMan = new ProgramManagerImpl();
		projectMan = new ProjectManagerImpl();
		
//		this.summaryByCountry=mgr.getCountOfGermplasmByCountrRealease();
//		this.summaryByYear=mgr.getCountOfGermplasmByYear();
//		this.extensionDataList=mgr.getExtensionDataList();
		
		this.areaSummaryGermplasmByYearandCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		this.areaSummaryGermplasmByYear=mgr.getAreaSummaryGermplasmByYear();
		this.areaSummaryGermplasmByCountryExtension=mgr.getAreaSummaryGermplasmByCountryExtension();
		this.noOfVarietyReleaseByCountryAndYear=mgr.getNoOfVarietyReleaseByCountryAndYear();
		this.noOfVarietyReleaseByCountryRelease=mgr.getNoOfVarietyReleaseByCountryRelease();
		this.noOfVarietyReleaseByYear=mgr.getNoOfVarietyReleaseByYear();
	}
	
	@NotifyChange("*")
	@GlobalCommand
	public void openExtensionDataDetail(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view,@BindingParam("function") String function, @BindingParam("model")Object each){
		getDetailTab().setSelected(true);

		programMan = new ProgramManagerImpl();
		projectMan = new ProjectManagerImpl();
		
		if(function.equals("varietyByYear")){
			SummaryModel areaSummaryGermplasmByYear = (SummaryModel) each;
			System.out.println("ProgramName: "+areaSummaryGermplasmByYear.getProgramName());
			System.out.println(" id:"+Integer.toString(areaSummaryGermplasmByYear.getProgramid()));
			makeRowStatus(mgr.getExtensionDataByNoOfVarietyReleaseByCountryRelease(areaSummaryGermplasmByYear.getYearrelease(), areaSummaryGermplasmByYear.getProgramid()));
		}
		
		
	}

	private void makeRowStatus(List<ExtensionData> list) {
		// TODO Auto-generated method stub
		projectKeyList.clear();
		programKeyList.clear();
		rowList.clear();
		for (ExtensionData p: list){
			Program prog = programMan.getProgramById(p.getProgramid());
			programKeyList.put(prog.getId(),prog.getName());

			Project proj = projectMan.getProjectById(p.getProjectid());
			projectKeyList.put(proj.getId(),proj.getName());
			
			RowStatus ps = new RowStatus(p,false, prog, proj);
			rowList.add(ps);
		}
	}
	
	public List<RowStatus> getRowList() {
		return rowList;
	}

	public void setRowList(List<RowStatus> rowList) {
		this.rowList = rowList;
	}
	

	public List<SummaryModel> getAreaSummaryGermplasmByYearandCountryExtension() {
		return areaSummaryGermplasmByYearandCountryExtension;
	}





	public void setAreaSummaryGermplasmByYearandCountryExtension(
			List<SummaryModel> areaSummaryGermplasmByYearandCountryExtension) {
		this.areaSummaryGermplasmByYearandCountryExtension = areaSummaryGermplasmByYearandCountryExtension;
	}





	public List<SummaryModel> getAreaSummaryGermplasmByYear() {
		return areaSummaryGermplasmByYear;
	}





	public void setAreaSummaryGermplasmByYear(
			List<SummaryModel> areaSummaryGermplasmByYear) {
		this.areaSummaryGermplasmByYear = areaSummaryGermplasmByYear;
	}





	public List<SummaryModel> getAreaSummaryGermplasmByCountryExtension() {
		return areaSummaryGermplasmByCountryExtension;
	}





	public void setAreaSummaryGermplasmByCountryExtension(
			List<SummaryModel> areaSummaryGermplasmByCountryExtension) {
		this.areaSummaryGermplasmByCountryExtension = areaSummaryGermplasmByCountryExtension;
	}





	public List<SummaryModel> getNoOfVarietyReleaseByCountryAndYear() {
		return noOfVarietyReleaseByCountryAndYear;
	}





	public void setNoOfVarietyReleaseByCountryAndYear(
			List<SummaryModel> noOfVarietyReleaseByCountryAndYear) {
		this.noOfVarietyReleaseByCountryAndYear = noOfVarietyReleaseByCountryAndYear;
	}





	public List<SummaryModel> getNoOfVarietyReleaseByCountryRelease() {
		return noOfVarietyReleaseByCountryRelease;
	}





	public void setNoOfVarietyReleaseByCountryRelease(
			List<SummaryModel> noOfVarietyReleaseByCountryRelease) {
		this.noOfVarietyReleaseByCountryRelease = noOfVarietyReleaseByCountryRelease;
	}





	public List<SummaryModel> getNoOfVarietyReleaseByYear() {
		return noOfVarietyReleaseByYear;
	}





	public void setNoOfVarietyReleaseByYear(
			List<SummaryModel> noOfVarietyReleaseByYear) {
		this.noOfVarietyReleaseByYear = noOfVarietyReleaseByYear;
	}





	public List<SummaryModel> getSummaryArea() {
		return summaryArea;
	}



	public void setSummaryArea(List<SummaryModel> summaryArea) {
		this.summaryArea = summaryArea;
	}



	public List<ExtensionDataSummaryModel> getSummaryByCountry() {
		return summaryByCountry;
	}
	public void setSummaryByCountry(List<ExtensionDataSummaryModel> summaryByCountry) {
		this.summaryByCountry = summaryByCountry;
	}
	public List<ExtensionDataSummaryModel> getSummaryByYear() {
		return summaryByYear;
	}
	public void setSummaryByYear(List<ExtensionDataSummaryModel> summaryByYear) {
		this.summaryByYear = summaryByYear;
	}



	public List<ExtensionDataListModel> getExtensionDataList() {
		return extensionDataList;
	}



	public void setExtensionDataList(List<ExtensionDataListModel> extensionDataList) {
		this.extensionDataList = extensionDataList;
	}
	public class RowStatus {
		private  Program program;
		private Project project;
		private  ExtensionData value;
		private boolean editingStatus;

		public RowStatus(ExtensionData p, boolean editingStatus, Program program, Project project) {
			this.setValue(p);
			this.editingStatus = editingStatus;
			this.setProgram(program);
			this.setProject(project);
		}


		public boolean getEditingStatus() {
			return editingStatus;
		}

		public void setEditingStatus(boolean editingStatus) {
			this.editingStatus = editingStatus;
		}


		public ExtensionData getValue() {
			return value;
		}


		public void setValue(ExtensionData p) {
			this.value = p;
		}


		public Program getProgram() {
			return program;
		}


		public void setProgram(Program program) {
			this.program = program;
		}


		public Project getProject() {
			return project;
		}


		public void setProject(Project project) {
			this.project = project;
		}

	}
}
