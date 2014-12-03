package org.strasa.web.crossstudyquery.view.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.strasa.middleware.manager.CrossStudyQueryManagerImpl;
import org.strasa.middleware.manager.StudyDataDynamicColumnManager;
import org.strasa.middleware.manager.StudyManager;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.middleware.model.custom.StudyDataDynamicColumnQueryBuilder;
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Textbox;

public class CrossStudyQuery extends StudyVariable {

	List<StudyVariable> variablelist;
	ArrayList<CrossStudyQueryFilterModel> crossStudyFilterModelList = new ArrayList<CrossStudyQueryFilterModel>();
	String variableValue;
	String variableValue2;
	String studyVariable = null;
	String operator;
	String dataCategory = "dd";
	private CrossStudyQueryManagerImpl mgr;
	private int pageSize = 5;
	private int activePage = 0;
	private List<String> columnList = new ArrayList<String>();
	private List<String[]> dataList = new ArrayList<String[]>();
	private String searchResultLabel;
	private ArrayList<AcrossStudyData> newDataRow = new ArrayList<AcrossStudyData>();
	private StudyVariable variableInfo = new StudyVariable();

	private List<String> operatorString = Arrays.asList(new String[] { "Equal", "Like" });
	private List<String> operatorStringStudy = Arrays.asList(new String[] { "Equal" });
	private List<String> operatorNumber = Arrays.asList(new String[] { "Equal", "Greater Than", "Greater Than Equal", "Less Than", "Less Than Equal", "Range" });
	private List<String> operators;
	private List<StudyVariable> additionalColumns = new ArrayList<StudyVariable>();

	public List<StudyVariable> getVariablelist() {
		return variablelist;
	}

	public void setVariablelist(ListModelList<StudyVariable> variablelist) {
		this.variablelist = variablelist;
	}

	public ArrayList<CrossStudyQueryFilterModel> getCrossStudyFilterModelList() {
		return crossStudyFilterModelList;
	}

	public void setCrossStudyFilterModelList(ArrayList<CrossStudyQueryFilterModel> crossStudyFilterModelList) {
		this.crossStudyFilterModelList = crossStudyFilterModelList;
	}

	public String getVariableValue() {
		return variableValue;
	}

	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}

	public String getStudyVariable() {
		return studyVariable;
	}

	public void setStudyVariable(String studyVariable) {
		this.studyVariable = studyVariable;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getActivePage() {
		return activePage;
	}

	public void setActivePage(int activePage) {
		this.activePage = activePage;
	}

	public List<String> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}

	public void setDataList(List<String[]> dataList) {
		this.dataList = dataList;
	}

	public String getSearchResultLabel() {
		return searchResultLabel;
	}

	public void setSearchResultLabel(String searchResultLabel) {
		this.searchResultLabel = searchResultLabel;
	}

	public ArrayList<AcrossStudyData> getNewDataRow() {
		return newDataRow;
	}

	public void setNewDataRow(ArrayList<AcrossStudyData> newDataRow) {
		this.newDataRow = newDataRow;
	}

	public void setVariablelist(List<StudyVariable> variablelist) {
		this.variablelist = variablelist;
	}

	public StudyVariable getVariableInfo() {
		return variableInfo;
	}

	public void setVariableInfo(StudyVariable variableInfo) {
		this.variableInfo = variableInfo;
	}

	public List<String> getOperators() {
		return operators;
	}

	public void setOperators(List<String> operators) {
		this.operators = operators;
	}

	public String getVariableValue2() {
		return variableValue2;
	}

	public void setVariableValue2(String variableValue2) {
		this.variableValue2 = variableValue2;
	}

	public List<StudyVariable> getAdditionalColumns() {
		return additionalColumns;
	}

	public void setAdditionalColumns(List<StudyVariable> additionalColumns) {
		this.additionalColumns = additionalColumns;
	}

	public String getDataCategory() {
		return dataCategory;
	}

	public void setDataCategory(String dataCategory) {
		this.dataCategory = dataCategory;
	}

	@Init
	public void init() {
		mgr = new CrossStudyQueryManagerImpl();
		this.variablelist = new ListModelList<StudyVariable>(mgr.getStudyVariable());

	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) final Component view) {
		view.addEventListener(Events.ON_CLIENT_INFO, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				StudyDataDynamicColumnQueryBuilder queryBuilder = new StudyDataDynamicColumnQueryBuilder(dataCategory.equals("rd"));
				for (CrossStudyQueryFilterModel qfilter : crossStudyFilterModelList) {
					if (qfilter.getOperator().equals("Equal")) {

						queryBuilder.andEqualTo(qfilter.variable, qfilter.valueString);
					} else if (qfilter.getOperator().equals("Not Equal")) {
						queryBuilder.andNotEqualTo(qfilter.variable, qfilter.valueString);
					} else if (qfilter.getOperator().equals("Greater Than")) {
						queryBuilder.andGreaterThan(qfilter.variable, qfilter.valueString);
					} else if (qfilter.getOperator().equals("Greater Than Equal")) {
						queryBuilder.andGreaterThanOrEqual(qfilter.variable, qfilter.valueString);
					} else if (qfilter.getOperator().equals("Less Than")) {
						queryBuilder.andLessThan(qfilter.variable, qfilter.valueString);
					} else if (qfilter.getOperator().equals("Less Than Equal")) {
						queryBuilder.andLessThanOrEqual(qfilter.variable, qfilter.valueString);
					}
				}

				for (StudyVariable studyvar : additionalColumns) {
					queryBuilder.addOtherVariable(studyvar.getVariablecode());
				}

				System.out.println("STARTING QUERY WITH" + dataCategory);

				ArrayList<AcrossStudyData> toreturn = new StudyDataDynamicColumnManager(dataCategory.equals("rd")).getAcrossStudyResult(queryBuilder);
				// System.out.println("Size:"+toreturn.size());
				searchResultLabel = "Cross Study Query Result(s): " + toreturn.size() + "  row(s) returned";
				System.out.println("Cross Study Query Result(s): " + toreturn.size() + "  row(s) returned");

				if (toreturn.size() > 0) {

					// btnExport.setVisible(true);

					// Column Header
					columnList.clear();
					columnList.add("Study Name");
					columnList.add("Germplasm");

					for (String d : queryBuilder.getQueriesColumn()) {
						columnList.add(d);
					}

					System.out.println(columnList.toString());
					newDataRow.clear();
					newDataRow.addAll(toreturn);
					// newDataRow = toreturn;

					/*
					 * for(AcrossStudyData d: newDataRow){
					 * 
					 * System.out.println(d.getGname()+ " "+d.getStudyname()); }
					 */

					Div resultGrid = (Div) view.getFellow("resultQuery");
					if (resultGrid.getFirstChild() != null)
						resultGrid.getFirstChild().detach();

					Include gridResultQuery = new Include();
					gridResultQuery.setSrc("/user/crossstudyquery/gridresult.zul");
					gridResultQuery.setParent(resultGrid);
					// resultGrid.getFellows().add(gridResultQuery);
					((Groupbox) view.getFellow("crossResultId")).setVisible(true);

				} else {
					// btnExport.setVisible(false);
					System.out.println("EMPTY RESULT");
				}
				Clients.clearBusy();
			}
		});
	}

	@Command
	@NotifyChange({ "variablelist", "operators" })
	public void changeFilter(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view) {
		Bandbox variableSelected = (Bandbox) component.getFellow("studyVariable");
		if (variableSelected.getValue().length() > 0) {
			this.variablelist = new ListModelList<StudyVariable>(mgr.getStudyVariableLike(variableSelected.getValue()));
		} else {
			this.variablelist = new ListModelList<StudyVariable>(mgr.getStudyVariable());
		}
	}

	@Command
	@NotifyChange({ "variablelist" })
	public void changeFilter2(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view) {
		Bandbox variableSelected = (Bandbox) component.getFellow("studyVariable2");
		if (variableSelected.getValue().length() > 0) {
			this.variablelist = new ListModelList<StudyVariable>(mgr.getStudyVariableLike(variableSelected.getValue()));
		} else {
			this.variablelist = new ListModelList<StudyVariable>(mgr.getStudyVariable());
		}
	}

	public void resetVariableList() {
		this.variablelist = new ListModelList<StudyVariable>(mgr.getStudyVariable());
	}

	@Command
	@NotifyChange({ "operators" })
	public void setOperator(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view) {
		Bandbox variableSelected = (Bandbox) component.getFellow("studyVariable");
		StudyVariableManagerImpl mgr = new StudyVariableManagerImpl();
		try {
			StudyVariable sVariable = mgr.getVariableInfoByName(variableSelected.getValue());
			if (sVariable.getDatatype().equals("C")) {
				this.operators = operatorString;
			} else {
				this.operators = operatorNumber;
			}

			if (variableSelected.getValue().contains("Study")) {
				this.operators = operatorStringStudy;
			}
		} catch (IndexOutOfBoundsException npe) {

		}
	}

	@Command
	public void setVariableValueInput(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view, @BindingParam("operatorSelected") String operatorSelected) {
		Textbox txtVaribleValue2 = (Textbox) component.getFellow("txtVaribleValue2");
		if (operatorSelected.equals("Range")) {
			txtVaribleValue2.setVisible(true);
		} else {
			txtVaribleValue2.setVisible(false);
		}

	}

	@Command
	@NotifyChange({ "additionalColumns", "variablelist" })
	public void AddColumn(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view) {

		try {
			Bandbox variableSelected = (Bandbox) component.getFellow("studyVariable2");
			StudyVariable v = new StudyVariable();
			v.setVariablecode(variableSelected.getValue());
			v.setDescription("");
			additionalColumns.add(v);
			variableSelected.setText("");
			resetVariableList();
		} catch (Exception e) {
			Messagebox.show("Invalid Values", "Warning", null, null, null, null);
		}
	}

	@Command
	@NotifyChange({ "crossStudyFilterModelList" })
	public void AddCriteria(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view) {

		try {
			Bandbox variableSelected = (Bandbox) component.getFellow("studyVariable");
			CrossStudyQueryFilterModel criteria = new CrossStudyQueryFilterModel();
			CrossStudyQueryFilterModel criteria2 = new CrossStudyQueryFilterModel();
			if (operator.contains("Range")) {
				if (Double.valueOf(variableValue) < Double.valueOf(variableValue2)) {
					criteria.setVariable(variableSelected.getValue());
					criteria.setOperator("Greater Than Equal");
					criteria.setValueString(variableValue);
					this.crossStudyFilterModelList.add(criteria);
					criteria2.setVariable(variableSelected.getValue());
					criteria2.setOperator("Less Than Equal");
					criteria2.setValueString(variableValue2);
					this.crossStudyFilterModelList.add(criteria2);
				} else {
					Messagebox.show("Invalid Ranges.", "Warning", null, null, null, null);
				}

			} else {

				criteria.setVariable(variableSelected.getValue());
				criteria.setOperator(operator);
				criteria.setValueString(variableValue);
				this.crossStudyFilterModelList.add(criteria);
			}

		} catch (Exception e) {
			Messagebox.show("Invalid Values", "Warning", null, null, null, null);
		}

	}

	@Command
	@NotifyChange({ "crossStudyFilterModelList" })
	public void reset(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view) {
		this.crossStudyFilterModelList = new ArrayList<CrossStudyQueryFilterModel>();
		dataList = new ArrayList<String[]>();
		columnList = new ArrayList<String>();
		newDataRow = new ArrayList<AcrossStudyData>();
		Groupbox gridResult = (Groupbox) component.getFellow("crossResultId");
		gridResult.setVisible(false);
	}

	@Command
	@NotifyChange({ "crossStudyFilterModelList" })
	public void DeleteCriteria(@BindingParam("rowIndex") int index) {
		this.crossStudyFilterModelList.remove(index);
	}

	@Command
	@NotifyChange({ "additionalColumns" })
	public void DeleteAdditionalColumn(@BindingParam("rowIndex") int index) {
		this.additionalColumns.remove(index);
	}

	@GlobalCommand
	@NotifyChange({ "variableInfo" })
	public void ShowVariateDescription(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view, @BindingParam("variable") String variable) {
		System.out.println(variable);
		Div resultGrid = (Div) component.getFellow("resultQuery");
		StudyVariableManagerImpl studyVariableMngr = new StudyVariableManagerImpl();
		StudyVariable newVariableInfo = studyVariableMngr.getVariableInfoByName(variable);

		Popup popVariableDescription = new Popup();
		popVariableDescription.setWidth("355px");
		popVariableDescription.setHflex("1");
		;
		popVariableDescription.setParent(view.getParent());
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("description", newVariableInfo.getDescription());
		params.put("property", newVariableInfo.getProperty());
		params.put("method", newVariableInfo.getMethod());
		params.put("scale", newVariableInfo.getScale());
		params.put("datatype", newVariableInfo.getDatatype());
		Executions.createComponents("/user/crossstudyquery/variabledetail.zul", popVariableDescription, params);

		popVariableDescription.open(resultGrid.getFirstChild().getFellowIfAny(variable), "after_end");

	}

	@Command
	@NotifyChange({ "*" })
	public void RunQuery(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view) {
		Clients.showBusy("Searching. please wait...");

		Events.echoEvent("onClientInfo", view, null);
	}

	private int getStudyIdByStudyName(String studyname) {
		int toreturn = 0;
		StudyManager mgr = new StudyManager();
		toreturn = mgr.getStudyByStudyName(studyname);

		return toreturn;
	}

	@Command
	public void exportToCSV(@BindingParam("columns") List<String> columns, @BindingParam("rows") List<String[]> rows) {
		// List<String[]> grid = new ArrayList<String[]>();
		// grid.addAll(rows);
		// grid.add(0,columns.toArray(new String[columns.size()]));

		String fileName = "accrossStudyQuery";
		FileUtilities.exportData(columns, rows, fileName);

	}

	private ArrayList<String> removeDuplicateField(List<String> s) {
		String oldString = "";
		ArrayList<String> toreturn = new ArrayList<String>();
		for (String fieldLabel : s) {
			CrossStudyQueryFilterModel field = new CrossStudyQueryFilterModel();
			if (!oldString.equals(fieldLabel)) {
				if (!fieldLabel.equals("GName") && !fieldLabel.contains("Study")) {
					toreturn.add(fieldLabel);
				}
			}
			oldString = fieldLabel;
		}
		return toreturn;

	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}

	public ArrayList<ArrayList<String>> getRawData() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (dataList.isEmpty())
			return null;
		for (int i = activePage * pageSize; i < activePage * pageSize + pageSize && i < dataList.size(); i++) {
			ArrayList<String> row = new ArrayList<String>();
			row.addAll(Arrays.asList(dataList.get(i)));
			result.add(row);
			row.add(0, "  ");
			System.out.println(Arrays.toString(dataList.get(i)) + "ROW: " + row.get(0));
		}
		return result;
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

}
