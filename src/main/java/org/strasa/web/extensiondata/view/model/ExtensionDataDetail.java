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
import org.zkoss.bind.annotation.AfterCompose;

public class ExtensionDataDetail {

	private ProgramManagerImpl programMan;
	private ProjectManagerImpl projectMan;
	private ExtensionDataManagerImpl mgr;

	private List<ExtensionDataSummaryModel> summaryByCountry;
	private List<ExtensionDataSummaryModel> summaryByYear;
	private List<ExtensionDataListModel> extensionDataList;
	private List<SummaryModel> summaryArea;
	private List<RowStatus> rowList = new ArrayList<RowStatus>();
	private RowStatus row;
	
	private List<SummaryModel> areaSummaryGermplasmByYearandCountryExtension;
	private List<SummaryModel> areaSummaryGermplasmByYear;
	private List<SummaryModel> areaSummaryGermplasmByCountryExtension;
	private List<SummaryModel> noOfVarietyReleaseByCountryAndYear;
	private List<SummaryModel> noOfVarietyReleaseByCountryRelease;
	private List<SummaryModel> noOfVarietyReleaseByYear;
	
	private HashMap<Integer,String> programKeyList = new HashMap<Integer,String>();
	private HashMap<Integer,String> projectKeyList = new HashMap<Integer,String>();
	
	private Tab detailTab;
	private boolean single = true;
	
	public Tab getDetailTab() {
		return detailTab;
	}

	public void setDetailTab(Tab detailTab) {
		this.detailTab = detailTab;
	}

	@AfterCompose
	public void AfterCompose(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("function") String function, @ExecutionArgParam("summaryModel")SummaryModel each,@ExecutionArgParam("germplasmName")String germplasmName ){
		setDetailTab(detailTab);
		mgr= new ExtensionDataManagerImpl();
		programMan = new ProgramManagerImpl();
		projectMan = new ProjectManagerImpl();
		
		if(function.equals("varietyByYear"))makeRowStatus(mgr.getExtensionDataByNoOfVarietyReleaseByYearRelease(each.getYearrelease(), each.getCountryrelease(), each.getProgramid(), germplasmName));
		else if(function.equals("varietyByCountry"))makeRowStatus(mgr.getExtensionDataByNoOfVarietyReleaseByCountryRelease(each.getYearrelease(), each.getCountryrelease(), each.getProgramid(), germplasmName));
		else if(function.equals("varietyByCountryAndYear")) makeRowStatus(mgr.getExtensionDataByNoOfVarietyReleaseByYearAndCountryRelease(each.getYearrelease(), each.getCountryrelease(), each.getProgramid(), germplasmName));
		else if(function.equals("areaByYear")) makeRowStatus(mgr.getProgramGermplasmByYear(each.getYearextension(), each.getProgramid(), germplasmName));
		else if(function.equals("areaByCountry")) makeRowStatus(mgr.getProgramGermplasmByCountry(each.getCountryextension(), each.getProgramid(), germplasmName));
		else if(function.equals("areaByCountryAndYear")) makeRowStatus(mgr.getProgramGermplasmByYearandCountry(each.getYearextension(), each.getCountryextension(), each.getProgramid(), germplasmName));
		else if(function.equals("varietyCountByYear"))makeRowStatus(mgr.getVarietyReleaseByYear(each.getYearrelease(), each.getCountryrelease(), each.getProgramid(), germplasmName));
		else if(function.equals("varietyCountByCountry"))makeRowStatus(mgr.getVarietyReleaseByCountryRelease(each.getYearrelease(), each.getCountryrelease(), each.getProgramid(), germplasmName));
		else if(function.equals("varietyCountByCountryAndYear")) makeRowStatus(mgr.getVarietyReleaseByCountryAndYear(each.getYearrelease(), each.getCountryrelease(), each.getProgramid(), germplasmName));
		if(rowList.size()==1) {
			component.getFellow("singleGrid").setVisible(true);
			component.getFellow("multipleGrid").setVisible(false);
			setRow(rowList.get(0));
		}
		else{
			component.getFellow("singleGrid").setVisible(false);
			component.getFellow("multipleGrid").setVisible(true);
		}
		
		System.out.println(isSingle());
	}

	private void makeRowStatus(List<ExtensionData> list) {
		// TODO Auto-generated method stub
		rowList.clear();
		
		for (ExtensionData p: list){
			Program prog = programMan.getProgramById(p.getProgramid());
			Project proj = projectMan.getProjectById(p.getProjectid());
			
			RowStatus ps = new RowStatus(p, proj, prog);
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
	public boolean isSingle() {
		return single;
	}

	public void setSingle(boolean isSingle) {
		this.single = isSingle;
	}
	public RowStatus getRow() {
		return row;
	}

	public void setRow(RowStatus row) {
		this.row = row;
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

		public RowStatus(ExtensionData p, Program prog) {
			// TODO Auto-generated constructor stub
			this.setValue(p);
			this.setProgram(prog);
		}


		public RowStatus(ExtensionData p, Project proj, Program prog) {
			// TODO Auto-generated constructor stub
			this.setValue(p);
			this.setProgram(prog);
			this.setProject(proj);
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
