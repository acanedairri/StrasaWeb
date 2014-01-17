package org.strasa.web.uploadstudy.view.model;
public class Container{


	private String lable;
	private String value;
    
	public String getLable() {
		return lable;
	}
	public String getValue() {
		return value;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public void setValue(String value) {
		this.value = value;
	}
	 public Container (String lable, String value) {
		 this.lable = lable;
	  this.value = value;
	 }
	  }