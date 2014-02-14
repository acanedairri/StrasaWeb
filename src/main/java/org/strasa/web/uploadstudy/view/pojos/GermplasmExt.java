package org.strasa.web.uploadstudy.view.pojos;

import org.strasa.middleware.model.Germplasm;

public class GermplasmExt extends Germplasm {

	@Override
	public String toString() {
		return "GermplasmExt [germplasmtype=" + germplasmtype + ", other_name=" + other_name + "]";
	}

	private String germplasmtype;

	private String other_name;
	private String biotic, abiotic, grainQuality, majorGenes;

	public String getBiotic() {
		return biotic;
	}

	public void setBiotic(String biotic) {
		this.biotic = biotic;
	}

	public String getAbiotic() {
		return abiotic;
	}

	public void setAbiotic(String abiotic) {
		this.abiotic = abiotic;
	}

	public String getGrainQuality() {
		return grainQuality;
	}

	public void setGrainQuality(String grainQuality) {
		this.grainQuality = grainQuality;
	}

	public String getMajorGenes() {
		return majorGenes;
	}

	public void setMajorGenes(String majorGenes) {
		this.majorGenes = majorGenes;
	}

	public String getOther_name() {
		return other_name;
	}

	public void setOther_name(String other_name) {
		this.other_name = other_name;
	}

	public String getGermplasmtype() {
		return germplasmtype;
	}

	public void setGermplasmtype(String germplasmtype) {
		this.germplasmtype = germplasmtype;
	}

}