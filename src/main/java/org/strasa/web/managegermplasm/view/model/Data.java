package org.strasa.web.managegermplasm.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.BrowseStudyManagerImpl;
import org.strasa.middleware.manager.StudyDataColumnManagerImpl;
import org.strasa.middleware.manager.StudyDataDynamicColumnManager;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.middleware.model.custom.StudyDataDynamicColumnQueryBuilder;
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;

public class Data {

	private int pageSize = 10;
	private int activePage = 0;
	private String filePath;
	private String studyName;
	private Long totalRows;
	private List<String> columnList;
	private List<String[]> dataList;
	private Integer studyid;
	private Integer dataset;
	private BrowseStudyManagerImpl browseStudyManagerImpl;
	private StudyManagerImpl studyMan;
	private String dataType;
	private Div divDatagrid;
	private List<StudyDataColumn> columns;
	private StudyDataDynamicColumnQueryBuilder query;

	public Data() {
		// TODO Auto-generated constructor stub
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
		System.out.println("pageSize + " + activePage);
		includeDataGrid();
		this.activePage = activePage;
	}

	public List<String> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
		includeDataGrid();
	}

	public ArrayList<ArrayList<String>> getRowData() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		Integer start = activePage * pageSize;
		Integer limit = pageSize;
		System.out.println("START: " + dataType);

		return new StudyDataDynamicColumnManager(dataType.equals("rd")).getStudyRawDataDynaColsWithWhere(studyid, dataset, start, limit, query);
	}

	@Init
	public void init(@ExecutionArgParam("dataType") String dataType, @ExecutionArgParam("studyId") Integer studyId, @ExecutionArgParam("dataset") Integer dataset, @ExecutionArgParam("GName") String gName) {
		setDataType(dataType);

		studyMan = new StudyManagerImpl();
		browseStudyManagerImpl = new BrowseStudyManagerImpl();
		columnList = new ArrayList<String>();
		dataList = new ArrayList<String[]>();
		this.dataType = dataType;
		studyid = studyId;
		this.dataset = dataset;

		System.out.println("DATATYPE: " + dataType);
		// change this value as parameter

		// System.out.println("StudyId:"+ Integer.toString(studyId));
		// System.out.println("and dataset:" +Integer.toString(dataset));
		// List<HashMap<String, String>> toreturn =
		// browseStudyManagerImpl.getStudyData(studyId, dataType, dataset);

		query = new StudyDataDynamicColumnQueryBuilder(dataType.equals("rd"));
		query.andEqualTo("GName", gName);

		columns = new StudyDataColumnManagerImpl().getStudyDataColumnByStudyId(studyId, dataType); // rd
																									// as
		totalRows = new StudyDataDynamicColumnManager(dataType.endsWith("rd")).countStudyDynamicColWithWhereClause(studyId, dataset, query); // raw
		// data,
		// dd
		// as
		// derived
		// data
		for (StudyDataColumn d : columns) {
			columnList.add(d.getColumnheader());
			System.out.print(d.getColumnheader() + "\t");
		}
		System.out.println("\n ");

		setStudyName(studyMan.getStudyById(studyId).getName());
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		divDatagrid = (Div) view.getFellow("datagrid");
		includeDataGrid();
	}

	public void includeDataGrid() {
		if (!divDatagrid.getChildren().isEmpty())
			divDatagrid.getFirstChild().detach();
		Include incCSVData = new Include();
		incCSVData.setSrc("/user/managegermplasm/datagrid.zul");
		incCSVData.setParent(divDatagrid);
	}

	@Command
	public void exportRowData(@BindingParam("columns") List<String> columns, @BindingParam("studyName") String studyName, @BindingParam("dataType") String dataType) {
		// List<String[]> grid = new ArrayList<String[]>();
		// grid.addAll(rows);
		// grid.add(0,columns.toArray(new String[columns.size()]));

		if (dataType.endsWith("rd"))
			FileUtilities.exportData2(columns, new StudyDataDynamicColumnManager(true).getStudyRawDataDynaCols(studyid, dataset, null, null), studyName + "_rawData.csv");
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

	public Integer getStudyid() {
		return studyid;
	}

	public void setStudyid(Integer studyid) {
		this.studyid = studyid;
	}
}
