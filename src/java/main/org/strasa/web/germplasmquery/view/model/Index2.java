package org.strasa.web.germplasmquery.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.GermplasmTypeManagerImpl;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zkmax.zul.Chosenbox;
import org.zkoss.zul.Combobox;



public class Index2 {

	String nameSearch;
	String searchKey;
	List<GermplasmType> germplasmType;
	List<String> keyCharacteristicOption;
	int germplasmTypeId;
	String keyCharactericticValue;



	public String getNameSearch() {
		return nameSearch;
	}
	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}


	public List<GermplasmType> getGermplasmType() {
		GermplasmTypeManagerImpl mgr= new GermplasmTypeManagerImpl();
		germplasmType=mgr.getAllGermplasmType();
		return germplasmType;
	}
	public void setGermplasmType(List<GermplasmType> germplasmType) {
		this.germplasmType = germplasmType;
	}




	public int getGermplasmTypeId() {
		return germplasmTypeId;
	}
	public void setGermplasmTypeId(int germplasmTypeId) {
		this.germplasmTypeId = germplasmTypeId;
	}


	public List<String> getKeyCharacteristicOption() {
		return keyCharacteristicOption;
	}
	public void setKeyCharacteristicOption(List<String> keyCharacteristicOption) {
		this.keyCharacteristicOption = keyCharacteristicOption;
	}

	public String getKeyCharactericticValue() {
		return keyCharactericticValue;
	}
	public void setKeyCharactericticValue(String keyCharactericticValue) {
		this.keyCharactericticValue = keyCharactericticValue;
	}
	@Command
	public void SetSearchUI(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view) {

		Combobox cmbSearchKey= (Combobox) component.getFellow("cmbSearchKey");
		if(cmbSearchKey.getValue().equals("Name")){
			component.getFellow("txtNameSearch").setVisible(true);
			component.getFellow("cmbKeyChar").setVisible(false);
			component.getFellow("cmbKeyCharValue").setVisible(false);
			component.getFellow("cmbGermplasmType").setVisible(false);
		}else if(cmbSearchKey.getValue().contains("Key")){
			component.getFellow("txtNameSearch").setVisible(false);
			component.getFellow("cmbKeyChar").setVisible(true);
			component.getFellow("cmbKeyCharValue").setVisible(true);
			component.getFellow("cmbGermplasmType").setVisible(false);
		}else{
			component.getFellow("txtNameSearch").setVisible(false);
			component.getFellow("cmbKeyChar").setVisible(false);
			component.getFellow("cmbKeyCharValue").setVisible(false);
			component.getFellow("cmbGermplasmType").setVisible(true);
		}
	}
	@NotifyChange("*")
	@Command
	public void getKeyCharacteristicOptionsList(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view) {

		Combobox cmbKeyChar= (Combobox) component.getFellow("cmbKeyChar");

		if(cmbKeyChar.getValue().equals("Abiotic")){
			keyCharacteristicOption=getAbioticOptions();
		}else if(cmbKeyChar.getValue().contains("Biotic")){
			keyCharacteristicOption=getBioticOptions();
		}else if(cmbKeyChar.getValue().contains("Grain")){
			keyCharacteristicOption=getGrainQuality();
		}else{
			keyCharacteristicOption=getMajorGenes();
		}
		
		Chosenbox box = (Chosenbox) component.getFellow("cmbKeyCharValue");
		box.setSelectedIndex(-1);
		

	
	}

	private List<String> getGrainQuality() {
		List<String> toreturn= new ArrayList<String>();

		GermplasmTypeManagerImpl mgr= new GermplasmTypeManagerImpl();
		List<KeyGrainQuality> keyGrainQualityList = mgr.getKeyGrainQualityOption();
		for(KeyGrainQuality k:keyGrainQualityList ){
			toreturn.add(k.getValue());
		}

		return toreturn;
	}

	private List<String> getMajorGenes() {
		List<String> toreturn= new ArrayList<String>();
		GermplasmTypeManagerImpl mgr= new GermplasmTypeManagerImpl();
		List<KeyMajorGenes> keyMajorGenesList = mgr.getKeyMajorGenesOption();
		for(KeyMajorGenes k:keyMajorGenesList ){
			toreturn.add(k.getValue());
		}

		return toreturn;
	}


	private List<String> getBioticOptions() {
		List<String> toreturn= new ArrayList<String>();
		GermplasmTypeManagerImpl mgr= new GermplasmTypeManagerImpl();
		List<KeyBiotic> keyBioticList = mgr.getKeyBioticOption();
		for(KeyBiotic k:keyBioticList ){
			toreturn.add(k.getValue());
		}

		return toreturn;
	}
	private List<String> getAbioticOptions() {
		List<String> toreturn= new ArrayList<String>();
		GermplasmTypeManagerImpl mgr= new GermplasmTypeManagerImpl();
		List<KeyAbiotic> keyAbioticList = mgr.getKeyAbioticOption();
		for(KeyAbiotic k:keyAbioticList ){
			toreturn.add(k.getValue());
		}

		return toreturn;
	}


}
