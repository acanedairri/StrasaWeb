package org.strasa.middleware.model.custom;

import java.util.List;

public class StudyRawDataDynCol {

	private Integer id, studyid, dataset, datarow;
	private List<String> rows;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getDatarow() {
		return datarow;
	}

	public void setDatarow(Integer datarow) {
		this.datarow = datarow;
	}

	public List<String> getRows() {
		return rows;
	}

	public void setRows(List<String> rows) {
		this.rows = rows;
	}

}
