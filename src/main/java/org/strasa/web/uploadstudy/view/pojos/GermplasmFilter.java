package org.strasa.web.uploadstudy.view.pojos;

public class GermplasmFilter {

	private String gname = "", germplasmType = "", breeder = "", maleParent = "", femaleParent = "";

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGermplasmType() {
		return germplasmType;
	}

	public void setGermplasmType(String germplasmType) {
		this.germplasmType = germplasmType;
	}

	public String getBreeder() {
		return breeder;
	}

	public void setBreeder(String breeder) {
		this.breeder = breeder;
	}

	public String getMaleParent() {
		return maleParent;
	}

	public void setMaleParent(String maleParent) {
		this.maleParent = maleParent;
	}

	public String getFemaleParent() {
		return femaleParent;
	}

	public void setFemaleParent(String femaleParent) {
		this.femaleParent = femaleParent;
	}

	public boolean equals(GermplasmDeepInfoModel data) {

		return data.getGermplasmname().startsWith(gname) && data.getSelectedGermplasmType().getGermplasmtype().startsWith(germplasmType) && data.getBreeder().startsWith(breeder) && data.getMaleparent().startsWith(maleParent) && data.getFemaleparent().startsWith(femaleParent);
	}

}
