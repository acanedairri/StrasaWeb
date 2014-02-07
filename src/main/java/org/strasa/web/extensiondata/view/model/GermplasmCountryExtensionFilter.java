package org.strasa.web.extensiondata.view.model;

public class GermplasmCountryExtensionFilter {
	
	
	String programName="";
	String countryExtension="";
	String germplasmName="";
	String sumArea="";
	
	
	public String getProgramName() {
		return programName;
		
	}
	public void setProgramName(String programName) {
		this.programName = programName==null?"":programName.trim();
		
	}
	public String getCountryExtension() {
		return countryExtension;
	}
	public void setCountryExtension(String countryExtension) {
		this.countryExtension = countryExtension==null?"":countryExtension.trim();
	}
	public String getGermplasmName() {
		return germplasmName;
	}
	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName==null?"":germplasmName.trim();
	}
	public String getSumArea() {
		return sumArea;
	}
	public void setSumArea(String sumArea) {
		this.sumArea = sumArea==null?"":sumArea.trim();
	}
	
	
	
	
	

}
