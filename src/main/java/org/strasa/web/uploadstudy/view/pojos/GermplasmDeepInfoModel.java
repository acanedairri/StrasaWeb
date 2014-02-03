package org.strasa.web.uploadstudy.view.pojos;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;

import com.mysql.jdbc.StringUtils;

public class GermplasmDeepInfoModel extends Germplasm {

	public static String ABIOTIC = "Abiotic";
	public static String BIOTIC = "Biotic";
	public static String MAJORGENES = "Major Genes";
	public static String GRAINQUALITY = "Grain Quality";

	private List<CharacteristicModel> keyBiotic = new ArrayList<CharacteristicModel>();
	private List<CharacteristicModel> keyAbiotic = new ArrayList<CharacteristicModel>();
	private List<CharacteristicModel> keyGrainQuality = new ArrayList<CharacteristicModel>();
	private List<CharacteristicModel> keyMajorGenes = new ArrayList<CharacteristicModel>();
	private String styleBG = "background-color: #FFF";
	public int rowIndex;
	private GermplasmType selectedGermplasmType;
	private String category;
	public boolean recordExist = false;
	private boolean isKnown;

	public GermplasmDeepInfoModel() {

	}

	public GermplasmDeepInfoModel(Germplasm data) {
		// TODO Auto-generated constructor stub

		if (!StringUtils.isNullOrEmpty(data.getBreeder()))
			setBreeder(data.getBreeder());
		if (!StringUtils.isNullOrEmpty(data.getFemaleparent()))
			setFemaleparent(data.getFemaleparent());
		if (!StringUtils.isNullOrEmpty(data.getGermplasmname()))
			setGermplasmname(data.getGermplasmname());
		if (data.getGid() != null)
			setGid(data.getGid());
		if (data.getGermplasmtypeid() != null)
			setGermplasmtypeid(data.getGermplasmtypeid());
		if (!StringUtils.isNullOrEmpty(data.getIrcross()))
			setIrcross(data.getIrcross());
		if (!StringUtils.isNullOrEmpty(data.getIrnumber()))
			setIrnumber(data.getIrnumber());
		if (!StringUtils.isNullOrEmpty(data.getMaleparent()))
			setMaleparent(data.getMaleparent());
		if (!StringUtils.isNullOrEmpty(data.getOthername()))
			setOthername(data.getOthername());
		if (!StringUtils.isNullOrEmpty(data.getParentage()))
			setParentage(data.getParentage());
		if (!StringUtils.isNullOrEmpty(data.getRemarks()))
			setRemarks(data.getRemarks());
		if (!StringUtils.isNullOrEmpty(data.getSelectionhistory()))
			setSelectionhistory(data.getSelectionhistory());
		if (!StringUtils.isNullOrEmpty(data.getSource()))
			setSource(data.getSource());
		this.setUserid(data.getUserid());
		this.setId(data.getId());
	}

	@Override
	public String toString() {
		return "GermplasmDeepInfoModel [keyBiotic=" + keyBiotic + ", keyAbiotic=" + keyAbiotic + ", keyGrainQuality=" + keyGrainQuality + ", keyMajorGenes=" + keyMajorGenes + ", styleBG=" + styleBG + ", rowIndex=" + rowIndex + ", selectedGermplasmType=" + selectedGermplasmType
				+ ", category=" + category + ", isKnown=" + isKnown + ", getId()=" + getId() + ", getGid()=" + getGid() + ", getGermplasmname()=" + getGermplasmname() + ", getOthername()=" + getOthername() + ", getBreeder()=" + getBreeder() + ", getGermplasmtypeid()="
				+ getGermplasmtypeid() + ", getIrnumber()=" + getIrnumber() + ", getIrcross()=" + getIrcross() + ", getParentage()=" + getParentage() + ", getFemaleparent()=" + getFemaleparent() + ", getMaleparent()=" + getMaleparent() + ", getSelectionhistory()="
				+ getSelectionhistory() + ", getSource()=" + getSource() + ", getRemarks()=" + getRemarks() + ", getUserid()=" + getUserid() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public boolean isEditMode() {
		return isKnown;
	}

	public boolean isKnown() {
		return isKnown;
	}

	public void setKnown(boolean isKnown) {
		this.isKnown = isKnown;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public GermplasmType getSelectedGermplasmType() {
		return selectedGermplasmType;
	}

	public void setSelectedGermplasmType(GermplasmType selectedGermplasmType) {
		this.selectedGermplasmType = selectedGermplasmType;
		this.setGermplasmtypeid(selectedGermplasmType.getId());
	}

	public String getStyleBG() {
		return styleBG;
	}

	public void setStyleBG(String styleBG) {
		this.styleBG = styleBG;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public List<CharacteristicModel> getKeyBiotic() {
		return keyBiotic;
	}

	public void setKeyBiotic(List<CharacteristicModel> keyBiotic) {
		this.keyBiotic = keyBiotic;
	}

	public List<CharacteristicModel> getKeyAbiotic() {
		return keyAbiotic;
	}

	public void setKeyAbiotic(List<CharacteristicModel> keyAbiotic) {
		this.keyAbiotic = keyAbiotic;
	}

	public List<CharacteristicModel> getKeyGrainQuality() {
		return keyGrainQuality;
	}

	public void setKeyGrainQuality(List<CharacteristicModel> keyGrainQuality) {
		this.keyGrainQuality = keyGrainQuality;
	}

	public List<CharacteristicModel> getKeyMajorGenes() {
		return keyMajorGenes;
	}

	public void setKeyMajorGenes(List<CharacteristicModel> keyMajorGenes) {
		this.keyMajorGenes = keyMajorGenes;
	}

	public void setBiotic(List<KeyBiotic> list) {

		for (KeyBiotic key : list) {

			keyBiotic.add(new CharacteristicModel(key.getValue()));

		}
	}

	public void setAbiotic(List<KeyAbiotic> list) {

		for (KeyAbiotic key : list) {

			keyAbiotic.add(new CharacteristicModel(key.getValue()));

		}
	}

	public void setMajorGenes(List<KeyMajorGenes> list) {

		for (KeyMajorGenes key : list) {

			keyMajorGenes.add(new CharacteristicModel(key.getValue()));

		}
	}

	public void setGrainQuality(List<KeyGrainQuality> list) {

		for (KeyGrainQuality key : list) {

			keyGrainQuality.add(new CharacteristicModel(key.getValue()));

		}
	}

	public void setBioticKeyValue(String attr, boolean value) {
		for (CharacteristicModel key : keyBiotic) {
			if (key.getName().equals(attr))
				key.setValue(value);
		}
	}

	public void setAbioticKeyValue(String attr, boolean value) {
		for (CharacteristicModel key : keyAbiotic) {
			if (key.getName().equals(attr))
				key.setValue(value);
		}
	}

	public void setGrainQualityKeyValue(String attr, boolean value) {
		for (CharacteristicModel key : keyGrainQuality) {
			if (key.getName().equals(attr))
				key.setValue(value);
		}
	}

	public void setMajorGenesKeyValue(String attr, boolean value) {
		for (CharacteristicModel key : keyMajorGenes) {
			if (key.getName().equals(attr))
				key.setValue(value);
		}
	}

	public void setCharacteristicValues(List<GermplasmCharacteristics> lstChars) {

		for (GermplasmCharacteristics germChar : lstChars) {
			if (germChar.getAttribute().equals(ABIOTIC)) {
				setAbioticKeyValue(germChar.getKeyvalue(), true);
			}
			if (germChar.getAttribute().equals(BIOTIC)) {
				setBioticKeyValue(germChar.getKeyvalue(), true);
			}
			if (germChar.getAttribute().equals(MAJORGENES)) {
				setMajorGenesKeyValue(germChar.getKeyvalue(), true);
			}
			if (germChar.getAttribute().equals(GRAINQUALITY)) {
				setGrainQualityKeyValue(germChar.getKeyvalue(), true);
			}
		}
	}

	public String validate() {
		// if(true) return true;
		styleBG = "background-color: #ff6666";
		if (StringUtils.isNullOrEmpty(getGermplasmname())) {
			// styleBG = "background-color: #ff6666";
			return "Error: GName cannot be empty";
		}
		if (StringUtils.isNullOrEmpty(getBreeder())) {
			// styleBG = "background-color: #ff6666";
			return "Error: Breeder must not be empty in GName: " + getGermplasmname();
		}

		if (StringUtils.isNullOrEmpty(getFemaleparent())) {
			// styleBG = "background-color: #ff6666";
			return "Error: Female Parent must not be empty in GName: " + getGermplasmname();
		}

		;
		if (StringUtils.isNullOrEmpty(getMaleparent())) {
			// styleBG = "background-color: #ff6666";
			return "Error: Male Parent must not be empty in GName: " + getGermplasmname();
		}

		if (getGermplasmtypeid() == null) {
			// styleBG = "background-color: #ff6666";
			return "Error: Germplasm Type must not be empty in GName: " + getGermplasmname();
		}
		styleBG = "background-color: #FFF";
		return null;
	}

	public List<GermplasmCharacteristics> getCharacteristicValues() {
		// TODO Auto-generated method stub
		ArrayList<GermplasmCharacteristics> returnVal = new ArrayList<GermplasmCharacteristics>();

		for (CharacteristicModel charData : keyAbiotic) {
			if (charData.isValue()) {
				GermplasmCharacteristics newData = new GermplasmCharacteristics();
				newData.setAttribute(ABIOTIC);
				newData.setGermplasmname(this.getGermplasmname());
				newData.setKeyvalue(charData.getName());
				returnVal.add(newData);
			}
		}
		for (CharacteristicModel charData : keyBiotic) {
			if (charData.isValue()) {
				GermplasmCharacteristics newData = new GermplasmCharacteristics();
				newData.setAttribute(BIOTIC);
				newData.setGermplasmname(this.getGermplasmname());
				newData.setKeyvalue(charData.getName());
				returnVal.add(newData);
			}
		}
		for (CharacteristicModel charData : keyMajorGenes) {
			if (charData.isValue()) {
				GermplasmCharacteristics newData = new GermplasmCharacteristics();
				newData.setAttribute(MAJORGENES);
				newData.setGermplasmname(this.getGermplasmname());
				newData.setKeyvalue(charData.getName());
				returnVal.add(newData);
			}
		}
		for (CharacteristicModel charData : keyGrainQuality) {
			if (charData.isValue()) {
				GermplasmCharacteristics newData = new GermplasmCharacteristics();
				newData.setAttribute(GRAINQUALITY);
				newData.setGermplasmname(this.getGermplasmname());
				newData.setKeyvalue(charData.getName());
				returnVal.add(newData);
			}
		}

		return returnVal;
	}

	public void setValueFromeGermplasmEx(GermplasmExt data) {

		if (!StringUtils.isNullOrEmpty(data.getBreeder()))
			setBreeder(data.getBreeder());
		if (!StringUtils.isNullOrEmpty(data.getFemaleparent()))
			setFemaleparent(data.getFemaleparent());

		if (data.getGid() != null)
			setGid(data.getGid());

		if (!StringUtils.isNullOrEmpty(data.getIrcross()))
			setIrcross(data.getIrcross());
		if (!StringUtils.isNullOrEmpty(data.getIrnumber()))
			setIrnumber(data.getIrnumber());
		if (!StringUtils.isNullOrEmpty(data.getMaleparent()))
			setMaleparent(data.getMaleparent());
		if (!StringUtils.isNullOrEmpty(data.getOthername()))
			setOthername(data.getOthername());
		if (!StringUtils.isNullOrEmpty(data.getParentage()))
			setParentage(data.getParentage());
		if (!StringUtils.isNullOrEmpty(data.getRemarks()))
			setRemarks(data.getRemarks());
		if (!StringUtils.isNullOrEmpty(data.getSelectionhistory()))
			setSelectionhistory(data.getSelectionhistory());
		if (!StringUtils.isNullOrEmpty(data.getSource()))
			setSource(data.getSource());

	}
}