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
	private String newBreeder;
	private ArrayList<CharacteristicModel> invalidCharacteristic = new ArrayList<CharacteristicModel>();

	public ArrayList<CharacteristicModel> getInvalidCharacteristic() {
		return invalidCharacteristic;
	}

	public void setInvalidCharacteristic(ArrayList<CharacteristicModel> invalidCharacteristic) {
		this.invalidCharacteristic = invalidCharacteristic;
	}

	public String getNewBreeder() {
		return newBreeder;
	}

	public void setNewBreeder(String newBreeder) {
		this.newBreeder = newBreeder;
	}

	public GermplasmDeepInfoModel() {

	}

	public String getTemplateMode() {

		if (this.getId() == null) {
			return "newEntry";
		}

		if (isKnown)
			return "display";

		return "editable";
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

	public void setGermplasmValue(Germplasm data) {
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

			keyBiotic.add(new CharacteristicModel(key.getValue(), BIOTIC));

		}
	}

	public void setAbiotic(List<KeyAbiotic> list) {

		for (KeyAbiotic key : list) {

			keyAbiotic.add(new CharacteristicModel(key.getValue(), ABIOTIC));

		}
	}

	public void setMajorGenes(List<KeyMajorGenes> list) {

		for (KeyMajorGenes key : list) {

			keyMajorGenes.add(new CharacteristicModel(key.getValue(), MAJORGENES));

		}
	}

	public void setGrainQuality(List<KeyGrainQuality> list) {

		for (KeyGrainQuality key : list) {

			keyGrainQuality.add(new CharacteristicModel(key.getValue(), GRAINQUALITY));

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

	public void clearCharactersticValue() {
		keyAbiotic.clear();
		keyBiotic.clear();
		keyGrainQuality.clear();
		keyMajorGenes.clear();
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

	public void setValueFromeGermplasmEx(GermplasmExt data, List<GermplasmType> lstGermplasmType) {

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
		if (!StringUtils.isNullOrEmpty(data.getOther_name()))
			setOthername(data.getOther_name());
		if (!StringUtils.isNullOrEmpty(data.getParentage()))
			setParentage(data.getParentage());
		if (!StringUtils.isNullOrEmpty(data.getRemarks()))
			setRemarks(data.getRemarks());
		if (!StringUtils.isNullOrEmpty(data.getSelectionhistory()))
			setSelectionhistory(data.getSelectionhistory());
		if (!StringUtils.isNullOrEmpty(data.getSource()))
			setSource(data.getSource());

		for (GermplasmType gtype : lstGermplasmType) {
			if (gtype.getGermplasmtype().equals(data.getGermplasmtype())) {
				this.setSelectedGermplasmType(gtype);
			}
		}

		// System.out.println(this.toString());

	}

	public boolean setGermplasmExCharacteristic(GermplasmExt data) {
		// Biotic
		ArrayList<CharacteristicModel> returnVal = new ArrayList<CharacteristicModel>();
		if (!StringUtils.isEmptyOrWhitespaceOnly(data.getBiotic()))
			for (String key : data.getBiotic().split(",")) {
				boolean added = false;
				for (CharacteristicModel ckey : keyBiotic) {
					if (key.trim().toUpperCase().equals(ckey.getName().trim().toUpperCase())) {
						ckey.setValue(true);
						added = true;
					}

				}
				if (!added)
					returnVal.add(new CharacteristicModel(key, BIOTIC));
			}

		if (!StringUtils.isEmptyOrWhitespaceOnly(data.getAbiotic()))
			for (String key : data.getAbiotic().split(",")) {
				boolean added = false;
				for (CharacteristicModel ckey : keyAbiotic) {
					if (key.trim().toUpperCase().equals(ckey.getName().trim().toUpperCase())) {
						ckey.setValue(true);
						added = true;
					}
				}
				if (!added)
					returnVal.add(new CharacteristicModel(key, ABIOTIC));
			}
		if (!StringUtils.isEmptyOrWhitespaceOnly(data.getGrainQuality()))
			for (String key : data.getGrainQuality().split(",")) {
				boolean added = false;
				for (CharacteristicModel ckey : keyGrainQuality) {
					if (key.trim().toUpperCase().equals(ckey.getName().trim().toUpperCase())) {
						ckey.setValue(true);
						added = true;
					}
				}
				if (!added)
					returnVal.add(new CharacteristicModel(key, GRAINQUALITY));
			}
		if (!StringUtils.isEmptyOrWhitespaceOnly(data.getMajorGenes()))
			for (String key : data.getMajorGenes().split(",")) {
				boolean added = false;
				for (CharacteristicModel ckey : keyMajorGenes) {
					if (key.trim().toUpperCase().equals(ckey.getName().trim().toUpperCase())) {
						ckey.setValue(true);
						added = true;
					}
				}
				if (!added)
					returnVal.add(new CharacteristicModel(key, MAJORGENES));
			}

		invalidCharacteristic = returnVal;
		return returnVal.isEmpty();

	}

	public boolean equalsGermplasmNoBreeder(Germplasm obj) {

		Germplasm other = obj;

		if (getFemaleparent() == null) {
			if (other.getFemaleparent() != null)
				return false;
		} else if (!getFemaleparent().equals(other.getFemaleparent()))
			return false;
		if (getGermplasmname() == null) {
			if (other.getGermplasmname() != null)
				return false;
		} else if (!getGermplasmname().equals(other.getGermplasmname()))
			return false;
		if (getGermplasmtypeid() == null) {
			if (other.getGermplasmtypeid() != null)
				return false;
		} else if (!getGermplasmtypeid().equals(other.getGermplasmtypeid()))
			return false;
		if (getGid() == null) {
			if (other.getGid() != null)
				return false;
		} else if (!getGid().equals(other.getGid()))
			return false;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (getIrcross() == null) {
			if (other.getIrcross() != null)
				return false;
		} else if (!getIrcross().equals(other.getIrcross()))
			return false;
		if (getIrnumber() == null) {
			if (other.getIrnumber() != null)
				return false;
		} else if (!getIrnumber().equals(other.getIrnumber()))
			return false;
		if (getMaleparent() == null) {
			if (other.getMaleparent() != null)
				return false;
		} else if (!getMaleparent().equals(other.getMaleparent()))
			return false;
		if (getOthername() == null) {
			if (other.getOthername() != null)
				return false;
		} else if (!getOthername().equals(other.getOthername()))
			return false;
		if (getParentage() == null) {
			if (other.getParentage() != null)
				return false;
		} else if (!getParentage().equals(other.getParentage()))
			return false;
		if (getRemarks() == null) {
			if (other.getRemarks() != null)
				return false;
		} else if (!getRemarks().equals(other.getRemarks()))
			return false;
		if (getSelectionhistory() == null) {
			if (other.getSelectionhistory() != null)
				return false;
		} else if (!getSelectionhistory().equals(other.getSelectionhistory()))
			return false;
		if (getSource() == null) {
			if (other.getSource() != null)
				return false;
		} else if (!getSource().equals(other.getSource()))
			return false;
		if (getUserid() == null) {
			if (other.getUserid() != null)
				return false;
		} else if (!getUserid().equals(other.getUserid()))
			return false;
		return true;
	}

	public void reprocessInvalidCharacters() {

		for (CharacteristicModel ch : invalidCharacteristic) {
			if (ch.getAttribute().equals(ABIOTIC)) {
				for (CharacteristicModel ckey : keyAbiotic) {
					if (ckey.getName().equals(ch.getName()))
						ckey.setValue(true);
				}
			}
			if (ch.getAttribute().equals(BIOTIC)) {
				for (CharacteristicModel ckey : keyBiotic) {
					if (ckey.getName().equals(ch.getName())) {
						// System.out.println("*");
						ckey.setValue(true);
					} else {
						// System.out.println("ckey: " + ckey.getName() +
						// " ch: " + ch.getName());
					}
				}
			}
			if (ch.getAttribute().equals(MAJORGENES)) {
				for (CharacteristicModel ckey : keyMajorGenes) {
					if (ckey.getName().equals(ch.getName()))
						ckey.setValue(true);
				}
			}
			if (ch.getAttribute().equals(GRAINQUALITY)) {
				for (CharacteristicModel ckey : keyGrainQuality) {
					if (ckey.getName().equals(ch.getName()))
						ckey.setValue(true);
				}
			}
		}

	}
}