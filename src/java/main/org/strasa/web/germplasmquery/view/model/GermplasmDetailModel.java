package org.strasa.web.germplasmquery.view.model;

import org.strasa.middleware.model.Germplasm;

public class GermplasmDetailModel extends Germplasm {
	
	String abioticCharacteristics;
	String bioticCharacteristics;
	String grainQualityCharacteristics;
	String majoyGenesCharacteristics;
	public String getAbioticCharacteristics() {
		return abioticCharacteristics;
	}
	public void setAbioticCharacteristics(String abioticCharacteristics) {
		this.abioticCharacteristics = abioticCharacteristics;
	}
	public String getBioticCharacteristics() {
		return bioticCharacteristics;
	}
	public void setBioticCharacteristics(String bioticCharacteristics) {
		this.bioticCharacteristics = bioticCharacteristics;
	}
	public String getGrainQualityCharacteristics() {
		return grainQualityCharacteristics;
	}
	public void setGrainQualityCharacteristics(String grainQualityCharacteristics) {
		this.grainQualityCharacteristics = grainQualityCharacteristics;
	}
	public String getMajoyGenesCharacteristics() {
		return majoyGenesCharacteristics;
	}
	public void setMajoyGenesCharacteristics(String majoyGenesCharacteristics) {
		this.majoyGenesCharacteristics = majoyGenesCharacteristics;
	}
	
	

}
