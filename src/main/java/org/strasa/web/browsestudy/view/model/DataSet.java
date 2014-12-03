package org.strasa.web.browsestudy.view.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.BrowseStudyManagerImpl;
import org.strasa.middleware.manager.StudyDataColumnManagerImpl;
import org.strasa.middleware.manager.StudyDataDynamicColumnManager;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Tabpanel;

public class DataSet {

	private int pageSize = 10;
	private int activePage = 0;
	private String filePath;
	private String studyName;
	private Long totalRows;
	private List<String> columnList;
	private List<String[]> dataList;

	private BrowseStudyManagerImpl browseStudyManagerImpl;
	private StudyManagerImpl studyMan;

	private Integer studyid;
	private Integer dataset;

	public Integer getStudyId() {
		return studyid;
	}

	public void setStudyId(Integer studyId) {
		this.studyid = studyId;
	}

	public Integer getDataset() {
		return dataset;
	}

	public void setDataset(Integer dataset) {
		this.dataset = dataset;
	}

	private String dataType;

	public DataSet() {
		// TODO Auto-generated constructor stub
	}

	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName, @BindingParam("target") Tabpanel panel) {
		if (panel != null && panel.getChildren().isEmpty()) {
			Map arg = new HashMap();
			arg.put("studyId", studyid);
			arg.put("studyid", studyid);
			arg.put("dataset", dataset);
			Executions.createComponents(zulFileName, panel, arg);
		}
	}

	public Long getTotalSize() {
		return totalRows;
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
		this.activePage = activePage;
	}

	public List<String> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}

	public ArrayList<ArrayList<String>> getRowData() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		Integer start = activePage * pageSize;
		Integer limit = pageSize;
		System.out.println("START");

		return new StudyDataDynamicColumnManager(dataType.endsWith("rd")).getStudyRawDataDynaCols(studyid, null, start, limit);
	}

	public List<String[]> getDataList() {
		if (true)
			return dataList;
		ArrayList<String[]> pageData = new ArrayList<String[]>();
		for (int i = activePage * pageSize; i < activePage * pageSize + pageSize; i++) {
			pageData.add(dataList.get(i));
			System.out.println(Arrays.toString(dataList.get(i)));
		}

		return pageData;
	}

	@Init
	public void init(@ExecutionArgParam("dataType") String dataType, @ExecutionArgParam("studyId") Integer studyId, @ExecutionArgParam("dataset") Integer dataset) {
		setDataset(dataset);
		setStudyId(studyId);
		setDataType(dataType);

		studyMan = new StudyManagerImpl();
		browseStudyManagerImpl = new BrowseStudyManagerImpl();
		columnList = new ArrayList<String>();
		dataList = new ArrayList<String[]>();

		// change this value as parameter

		// System.out.println("StudyId:"+ Integer.toString(studyId)
		// +" and dataset:" +Integer.toString(dataset));
		System.out.println("MERGED DATASETTYPE: " + dataType + " - " + dataset);

		totalRows = new StudyDataDynamicColumnManager(dataType.endsWith("rd")).countStudyDynamicCol(studyId, null);
		List<StudyDataColumn> columns = new StudyDataColumnManagerImpl().getStudyDataColumnByStudyId(studyId, dataType, dataset); // rd
																																	// as
																																	// raw
																																	// data,
																																	// dd
																																	// as
																																	// derived
																																	// data
		for (StudyDataColumn d : columns) {
			columnList.add(d.getColumnheader());
			System.out.print(d.getColumnheader() + "\t");
		}

		setStudyName(studyMan.getStudyById(studyId).getName());
	}

	@Command
	public void exportRowData(@BindingParam("columns") List<String> columns, @BindingParam("rows") List<String[]> rows, @BindingParam("studyName") String studyName, @BindingParam("dataType") String dataType) {
		// List<String[]> grid = new ArrayList<String[]>();
		// grid.addAll(rows);
		// grid.add(0,columns.toArray(new String[columns.size()]));

		if (dataType.endsWith("dd"))
			FileUtilities.exportData2(columns, new StudyDataDynamicColumnManager(false).getStudyRawDataDynaCols(studyid, dataset, null, null), studyName + "_rawData.csv");
		else
			FileUtilities.exportData2(columns, new StudyDataDynamicColumnManager(false).getStudyRawDataDynaCols(studyid, dataset, null, null), studyName + "_derivedData.csv");
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
}
