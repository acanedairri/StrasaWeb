package org.strasa.web.browsestudy.view.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.strasa.middleware.manager.BrowseStudyManagerImpl;
import org.strasa.middleware.manager.StudyDataColumnManagerImpl;
import org.strasa.middleware.model.StudyDataColumn;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;

public class RawData {

	private int pageSize = 10;
	private int activePage = 0;
	
	private List<String> columnList= new ArrayList<String>();
	private List<String[]> dataList = new ArrayList<String[]>();
	
	private BrowseStudyManagerImpl browseStudyManagerImpl;
	
	public RawData() {
		// TODO Auto-generated constructor stub


	}
	
	public int getTotalSize() {
		return dataList.size();
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

	
	public ArrayList<ArrayList<String>> getCsvData() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (dataList.isEmpty())
			return result;
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
	
	@Init
	public void init() {
		browseStudyManagerImpl= new BrowseStudyManagerImpl(); 
		List<HashMap<String,String>> toreturn = browseStudyManagerImpl.getStudyRawData(1);
		System.out.println("Size:"+toreturn.size());
		List<StudyDataColumn> columns= new StudyDataColumnManagerImpl().getStudyDataColumnByStudyId(1,"rd"); // rd as raw data, dd as derived data
		for (StudyDataColumn d: columns) {
			columnList.add(d.getColumnheader());
			System.out.print(d.getColumnheader()+ "\t");
		}
		System.out.println("\n ");
		for( HashMap<String,String> rec:toreturn){
			ArrayList<String> newRow = new ArrayList<String>();
			for (StudyDataColumn d: columns) {
				String value= rec.get(d.getColumnheader());
				newRow.add(value);
				System.out.print(value + "\t");
			}
			System.out.println("\n ");
			dataList.add(newRow.toArray(new String[newRow.size()]));
		}
		
	}
}
