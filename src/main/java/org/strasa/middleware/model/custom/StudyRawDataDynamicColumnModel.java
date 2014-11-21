package org.strasa.middleware.model.custom;

import java.util.List;

public class StudyRawDataDynamicColumnModel {

	private Integer studyid;
	private Integer dataset;
	private List<String> lstColumns;

	public Integer getStudyid() {
		return studyid;
	}

	public void setStudyid(Integer studyid) {
		this.studyid = studyid;
	}

	public Integer getDataset() {
		return dataset;
	}

	public void setDataset(Integer dataset) {
		this.dataset = dataset;
	}

	public List<String> getLstColumns() {
		return lstColumns;
	}

	public void setLstColumns(List<String> lstColumns) {
		this.lstColumns = lstColumns;
	}

}
