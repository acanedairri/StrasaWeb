package org.strasa.web.common.api;

import java.util.ArrayList;

import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

public class DynamicGridView {

	ArrayList<String> lstColumns = new ArrayList<String>();
	ArrayList<String> lstRows = new ArrayList<String>();

	@Init
	public void init(@ExecutionArgParam("dataType") String dataType, @ExecutionArgParam("studyId") Integer studyId, @ExecutionArgParam("dataset") Integer dataset) {

	}

	public ArrayList<String> getLstColumns() {
		return lstColumns;
	}

	public void setLstColumns(ArrayList<String> lstColumns) {
		this.lstColumns = lstColumns;
	}

	public ArrayList<String> getLstRows() {
		return lstRows;
	}

	public void setLstRows(ArrayList<String> lstRows) {
		this.lstRows = lstRows;
	}

}
