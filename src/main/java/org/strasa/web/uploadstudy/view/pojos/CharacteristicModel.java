package org.strasa.web.uploadstudy.view.pojos;


public class CharacteristicModel {
	private String name;
	private boolean value;
	private int primaryid;

	public int getPrimaryid() {
		return primaryid;
	}

	public void setPrimaryid(int primaryid) {
		this.primaryid = primaryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;

	}

	public CharacteristicModel(String name, Integer id) {
		this.name = name;
		this.primaryid = id;
	}

	public CharacteristicModel(String name) {
		this.name = name;
	}

	public CharacteristicModel(CharacteristicModel charRecord) {
		// TODO Auto-generated constructor stub

	}

}