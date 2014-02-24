package org.strasa.web.extensionanddistributiondata.view.model;

import java.util.List;

public class SummaryModel extends ExtensionDataListModel {
	
	double sumArea;
	int countVariety;
	List<String> germplasmVarietyNames;

	public List<String> getGermplasmVarietyNames() {
		return germplasmVarietyNames;
	}

	public void setGermplasmVarietyNames(List<String> germplasmVarietyNames) {
		this.germplasmVarietyNames = germplasmVarietyNames;
	}

	public double getSumArea() {
		return sumArea;
	}

	public void setSumArea(double sumArea) {
		this.sumArea = sumArea;
	}

	public int getCountVariety() {
		return countVariety;
	}

	public void setCountVariety(int countVariety) {
		this.countVariety = countVariety;
	}
	
	

}
