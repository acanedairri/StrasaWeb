package org.strasa.web.uploadstudy.view.pojos;

public class CharacteristicModel {
	private String name;
	private boolean value = true;
	private int primaryid;
	private boolean exist;
	private String attribute;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

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

	public CharacteristicModel(String name, Integer id, String attr) {
		this.name = name;
		this.primaryid = id;
		attribute = attr;
	}

	public CharacteristicModel(String name, String attr) {
		this.name = name;
		attribute = attr;
	}

	public CharacteristicModel(CharacteristicModel charRecord) {
		// TODO Auto-generated constructor stub

	}

}