package org.strasa.web.crossstudyquery.view.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.strasa.middleware.manager.CrossStudyQueryManagerImpl;
import org.strasa.middleware.model.StudyVariable;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

public class CrossStudyQuery extends StudyVariable {

	List<StudyVariable> variablelist;
	ArrayList<CrossStudyQueryFilterModel> crossStudyFilterModelList = new ArrayList<CrossStudyQueryFilterModel>();
	String variableValue;
	String studyVariable=null;
	String operator;
	private CrossStudyQueryManagerImpl mgr;
	private int pageSize = 5;
	private int activePage = 0;
	private List<String> columnList= new ArrayList<String>();
	private List<String[]> dataList = new ArrayList<String[]>();
	private String searchResultLabel;
	private ArrayList<AcrossStudyData> newDataRow= new ArrayList<AcrossStudyData>();


	public List<StudyVariable> getVariablelist() {
		return variablelist;
	}
	public void setVariablelist(ListModelList<StudyVariable> variablelist) {
		this.variablelist = variablelist;
	}
	public ArrayList<CrossStudyQueryFilterModel> getCrossStudyFilterModelList() {
		return crossStudyFilterModelList;
	}
	public void setCrossStudyFilterModelList(
			ArrayList<CrossStudyQueryFilterModel> crossStudyFilterModelList) {
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
	@Init
	public void init(){
		mgr= new CrossStudyQueryManagerImpl();
		this.variablelist= new ListModelList<StudyVariable>(mgr.getStudyVariable());

	}

	@Command
	@NotifyChange({"variablelist"})
	public void changeFilter(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view) {
		Bandbox variableSelected= (Bandbox) component.getFellow("studyVariable");
		if(variableSelected.getValue().length() > 0){
			this.variablelist= new ListModelList<StudyVariable>(mgr.getStudyVariableLike(variableSelected.getValue()));
		}else{
			this.variablelist= new ListModelList<StudyVariable>(mgr.getStudyVariable());
		}
	}


	@Command
	@NotifyChange({"crossStudyFilterModelList"})
	public void AddCriteria(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view) {
		Bandbox variableSelected= (Bandbox) component.getFellow("studyVariable");
		CrossStudyQueryFilterModel criteria = new CrossStudyQueryFilterModel();
		criteria.setVariable(variableSelected.getValue());
		criteria.setOperator(operator);
		criteria.setValueString(variableValue);

		this.crossStudyFilterModelList.add(criteria);

	}

	@Command
	@NotifyChange({"crossStudyFilterModelList"})
	public void reset(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		this.crossStudyFilterModelList= new ArrayList<CrossStudyQueryFilterModel>();
		columnList = new ArrayList<String>();
		dataList = new ArrayList<String[]>();
		Groupbox gridResult = (Groupbox) component.getFellow("crossResultId");
		gridResult.setVisible(false);
	}

	@Command
	@NotifyChange({"crossStudyFilterModelList"})
	public void DeleteCriteria(@BindingParam("rowIndex") int index){
		this.crossStudyFilterModelList.remove(index);
	}


	@Command
	@NotifyChange({"*"})
	public void RunQuery(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){

		if(crossStudyFilterModelList.isEmpty()){
			Messagebox.show("Please specify a criteria" ,"Warning",null,null,null,null); 
		}else{

			Groupbox gridResult = (Groupbox) component.getFellow("crossResultId");
			gridResult.setVisible(true);

			dataList = new ArrayList<String[]>();
			columnList = new ArrayList<String>();
			newDataRow= new ArrayList<AcrossStudyData>();
			

			final CrossStudyQueryManagerImpl crossStudyQueryManagerImpl= new CrossStudyQueryManagerImpl(); 

			ArrayList<CrossStudyQueryFilterModel> filters = new ArrayList<CrossStudyQueryFilterModel>();

			// Field

			//			CrossStudyQueryFilterModel fieldStudyId= new CrossStudyQueryFilterModel();
			//			fieldStudyId.setVariable("STUDY ID");
			//			fieldStudyId.setColumnAs("field");
			//			filters.add(fieldStudyId);
			//
			//
			//			CrossStudyQueryFilterModel fieldDataRow= new CrossStudyQueryFilterModel();
			//			fieldDataRow.setVariable("datarow");
			//			fieldDataRow.setColumnAs("field");
			//			filters.add(fieldDataRow);

			CrossStudyQueryFilterModel fieldStudyName= new CrossStudyQueryFilterModel();
			fieldStudyName.setColumnHeader("Study Name");
			fieldStudyName.setVariable("studyname");
			fieldStudyName.setColumnAs("field");
			filters.add(fieldStudyName);

			CrossStudyQueryFilterModel fieldGName= new CrossStudyQueryFilterModel();
			fieldGName.setColumnHeader("Germplasm");
			fieldGName.setVariable("GName");
			fieldGName.setColumnAs("field");
			filters.add(fieldGName);

			//Get Other Field
			int sizeFieldSelected=crossStudyFilterModelList.size();

			List<String> s= new ArrayList<String>();
			for(CrossStudyQueryFilterModel f:crossStudyFilterModelList){
				s.add(f.getVariable());
			}
			Collections.sort(s);
			int counter=1;
			ArrayList<String> newField=removeDuplicateField(s);

			for(String fieldLabel:newField){
				CrossStudyQueryFilterModel field= new CrossStudyQueryFilterModel();
				field.setColumnHeader(fieldLabel);
				field.setVariable(fieldLabel);
				field.setColumnAs("field");

				if(counter==newField.size()){
					field.setOrderCriteria("last");
				}
				counter++;
				filters.add(field);
			}


			for(CrossStudyQueryFilterModel f:filters){

				System.out.println(f.getVariable());
				System.out.println(f.getColumnAs());
				System.out.println(f.getDataType());
				System.out.println(f.getValueDouble());
				System.out.println(f.getValueString());
				System.out.println(f.getOperator());
				System.out.println(f.getOrderCriteria());
				System.out.println("-------------------");

			}


			System.out.println("FILTER");
			counter=1;
			for(CrossStudyQueryFilterModel f:crossStudyFilterModelList){
				CrossStudyQueryFilterModel field= new CrossStudyQueryFilterModel();
				field.setVariable(f.getVariable());
				field.setColumnHeader(f.getVariable());
				field.setColumnAs("field");

				String valueString=f.getValueString();

				if(isNumeric(valueString)){
					field.setValueDouble(Double.valueOf(valueString));
					field.setDataType("Number");
				}else{
					field.setValueString(valueString);
					field.setDataType("String");
				}

				field.setColumnAs("filter");

				if(f.getOperator().equals("Equal")){
					field.setOperator(CrossStudyQueryOperator.EQUAL_TO);
				}else if(f.getOperator().equals("Not Equal")){
					field.setOperator(CrossStudyQueryOperator.NOT_EQUAL_TO);
				}else if(f.getOperator().equals("Greater Than")){
					field.setOperator(CrossStudyQueryOperator.GREATER_THAN);
				}else if(f.getOperator().equals("Greater Than Equal")){
					field.setOperator(CrossStudyQueryOperator.GREATER_THAN_EQUAL);
				}else if(f.getOperator().equals("Less Than")){
					field.setOperator(CrossStudyQueryOperator.LESS_THAN);
				}else if(f.getOperator().equals("Less Than Equal")){
					field.setOperator(CrossStudyQueryOperator.LESS_THAN_EQUAL);
				}


				if(counter==sizeFieldSelected){
					field.setOrderCriteria("last");
				}
				counter++;
				filters.add(field);
			}



			List<HashMap<String,String>> toreturn = crossStudyQueryManagerImpl.getCrossStudyQueryResult(filters);
			System.out.println("Size:"+toreturn.size());
			this.searchResultLabel="Cross Study Query Result(s): "+toreturn.size()+"  row(s) returned";

			//Column Header
			for (CrossStudyQueryFilterModel d: filters) {
				if(d.getColumnAs().equals("field")){
					//					System.out.print(d.getVariable()+ "\t");
					columnList.add(d.getColumnHeader());
				}
			}
			System.out.println("\n ");
			for( HashMap<String,String> rec:toreturn){
				ArrayList<String> newRow = new ArrayList<String>();
				AcrossStudyData dataRow= new AcrossStudyData();
				ArrayList<String> otherDataList = new ArrayList<String>();
				for (CrossStudyQueryFilterModel d: filters) {
					if(d.getColumnAs().equals("field")){
						String value= String.valueOf(rec.get(d.getVariable()));
						if(d.getVariable().equals("studyname")){
							dataRow.setStudyname(value);
						}else if(d.getVariable().equals("GName")){
							dataRow.setGname(value);
						}else{
							otherDataList.add(value);
						}
						
						System.out.print("Value "+value + "\t");
						newRow.add(value);
					}
				}
				dataRow.setOtherdata(otherDataList);
				newDataRow.add(dataRow);
				System.out.print("\n");
				dataList.add(newRow.toArray(new String[newRow.size()]));
				//				System.out.println("\n ");

			}
			
			for(AcrossStudyData d: newDataRow){
	
				System.out.println(d.getGname()+ " "+d.getStudyname());
			}
			
		}

	}

	private ArrayList<String> removeDuplicateField(List<String> s) {
		String oldString="";
		ArrayList<String> toreturn= new ArrayList<String>();
		for(String fieldLabel:s){
			CrossStudyQueryFilterModel field= new CrossStudyQueryFilterModel();
			if(!oldString.equals(fieldLabel)){
				toreturn.add(fieldLabel);
			}
			oldString=fieldLabel;
		}
		return toreturn;

	}
	public static boolean isNumeric(String str)
	{
		return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	public ArrayList<ArrayList<String>> getRawData() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (dataList.isEmpty())
			return null;
		for (int i = activePage * pageSize; i < activePage * pageSize
				+ pageSize
				&& i < dataList.size(); i++) {
			ArrayList<String> row = new ArrayList<String>();
			row.addAll(Arrays.asList(dataList.get(i)));
			result.add(row);
			row.add(0, "  ");
			System.out.println(Arrays.toString(dataList.get(i)) + "ROW: "
					+ row.get(0));
		}
		return result;
	}

	public List<String[]> getDataList() {
		if (true)
			return dataList;
		ArrayList<String[]> pageData = new ArrayList<String[]>();
		for (int i = activePage * pageSize; i < activePage * pageSize
				+ pageSize; i++) {
			pageData.add(dataList.get(i));
			System.out.println(Arrays.toString(dataList.get(i)));
		}

		return pageData;
	}

	
	
}
