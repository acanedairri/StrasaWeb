package org.strasa.web.uploadstudy.view.pojos;

import org.strasa.middleware.model.Germplasm;

public class GermplasmExt extends Germplasm {

	@Override
	public String toString() {
		return "GermplasmExt [germplasmtype=" + germplasmtype + ", other_name=" + other_name + "]";
	}

	private String germplasmtype;

	private String other_name;

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