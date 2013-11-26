package org.strasa.web.germplasmquery.view.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.strasa.middleware.manager.BrowseGermplasmManagerImpl;
import org.strasa.middleware.manager.BrowseStudyManagerImpl;
import org.strasa.middleware.manager.GermplasmCharacteristicMananagerImpl;
import org.strasa.middleware.manager.GermplasmManagerImpl;
import org.strasa.middleware.manager.GermplasmTypeManagerImpl;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.strasa.web.browsestudy.view.model.StudySearchResultModel;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zkmax.zul.Chosenbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Textbox;



public class GermplasmQuery {

	private String nameSearch;
	private String searchKey;
	private List<GermplasmType> germplasmType;
	private List<String> keyCharacteristicOption;
	private int germplasmTypeId;
	private String keyCharactericticValue;
	private List<Germplasm> germplasmList;
	private Germplasm germplasm;
	private String abioticCharacteristics;
	private String bioticCharacteristics;
	private String grainQualityCharacteristics;
	private String majorGenesCharacteristics;
	private List<StudySearchResultModel> studyTested;
	private HashMap<String,Integer> germplasmTypeKey = new HashMap<String,Integer>();
	private ArrayList<String> keyCharValueList= new ArrayList<String>();



	@Init
	public void setInitialData(){
		this.germplasmList=getGermplasmByName("");
		this.germplasm=getGermplasmDetailInformation(-1);
		this.germplasmType=getGermplasmTypeList();
	}


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


	public List<Germplasm> getGermplasmList() {
		return germplasmList;
	}
	public void setGermplasmList(List<Germplasm> germplasmList) {
		this.germplasmList = germplasmList;
	}

	public Germplasm getGermplasm() {
		return germplasm;
	}


	public void setGermplasm(Germplasm germplasm) {
		this.germplasm = germplasm;
	}


	public String getAbioticCharacteristics() {
		return abioticCharacteristics;
	}


	public void setAbioticCharacteristics(String abioticCharacteristics) {
		this.abioticCharacteristics = abioticCharacteristics;
	}


	public String getBioticCharacteristics() {
		return bioticCharacteristics;
	}


	public void setBioticCharacteristics(String bioticCharacteristics) {
		this.bioticCharacteristics = bioticCharacteristics;
	}


	public String getGrainQualityCharacteristics() {
		return grainQualityCharacteristics;
	}


	public void setGrainQualityCharacteristics(String grainQualityCharacteristics) {
		this.grainQualityCharacteristics = grainQualityCharacteristics;
	}


	public String getMajorGenesCharacteristics() {
		return majorGenesCharacteristics;
	}


	public void setMajorGenesCharacteristics(String majoyGenesCharacteristics) {
		this.majorGenesCharacteristics = majoyGenesCharacteristics;
	}




	public List<StudySearchResultModel> getStudyTested() {
		return studyTested;
	}


	public void setStudyTested(List<StudySearchResultModel> studyTested) {
		this.studyTested = studyTested;
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

	private  List<Germplasm> getGermplasmByName(String name){

		GermplasmManagerImpl mgr= new GermplasmManagerImpl();
		return (List<Germplasm>) mgr.getGermplasmListByName(name);

	}

	private List<Germplasm> getGermplasmByType(int id) {
		// TODO Auto-generated method stub
		BrowseGermplasmManagerImpl mgr= new BrowseGermplasmManagerImpl();
		return (List<Germplasm>) mgr.getGermplasmListByType(id);
	}

	private List<Germplasm> getGermplasmByKeyCharacteristics(ArrayList<String> keyCharList ) {
		// TODO Auto-generated method stub
		BrowseGermplasmManagerImpl mgr= new BrowseGermplasmManagerImpl();
		return  mgr.getGermplasmKeyCharacteristicsAbiotic(keyCharList);
	}


	@NotifyChange("*")
	@Command
	public void SearchGermplasm(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view){
		Combobox cmbSearchKey= (Combobox) component.getFellow("cmbSearchKey");
		if(cmbSearchKey.getValue().equals("Name")){
			Textbox txt=(Textbox) component.getFellow("txtNameSearch");
			this.germplasmList=getGermplasmByName(txt.getValue());
		}else if(cmbSearchKey.getValue().contains("Key")){
			Chosenbox keyValues= (Chosenbox) component.getFellow("cmbKeyCharValue");
			Object[] keyCharList = keyValues.getSelectedObjects().toArray();
			ArrayList<String> list= new ArrayList<String>();
			for(Object s: keyCharList){
				list.add(s.toString());
			}
			this.germplasmList=getGermplasmByKeyCharacteristics(list);

		}else if(cmbSearchKey.getValue().equals("Type")){
			Combobox cmbGermplasmType= (Combobox) component.getFellow("cmbGermplasmType");
			int germplasmTypeId=germplasmTypeKey.get(cmbGermplasmType.getValue());
			this.germplasmList=getGermplasmByType(germplasmTypeId);
		}

	}

	@Command("AddNewKeyCharacteristics")
	public void AddNewKeyCharacteristics(@BindingParam("keyCharValue") String keyCharValue) {
		//		Chosenbox keyValues= (Chosenbox) component.getFellow("cmbKeyCharValue");
		keyCharValueList.addAll(keyCharValueList);
		System.out.println(keyCharValue);

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

	@NotifyChange("*")
	@Command
	public void DisplayGermplasmInfo(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view,@BindingParam("germplasmId")Integer id,@BindingParam("gname")String gname){
		//		System.out.println(id + " "+gname);
		Groupbox groupBoxInfo= (Groupbox) component.getFellow("GermplasmDetailId");
		groupBoxInfo.setVisible(true);

		Groupbox groupBoxStudyTested= (Groupbox) component.getFellow("StudyTestedId");
		groupBoxStudyTested.setVisible(true);


		germplasm=getGermplasmDetailInformation(id);
		abioticCharacteristics=getGermplasmCharacteristics("Abiotic",gname);
		bioticCharacteristics=getGermplasmCharacteristics("Biotic",gname);

		studyTested=getStudyTested(gname);
	}

	private List<StudySearchResultModel> getStudyTested(String gname) {
		BrowseGermplasmManagerImpl browseStudyManagerImpl= new BrowseGermplasmManagerImpl(); 
		return browseStudyManagerImpl.getStudyWithGemrplasmTested(gname);

	}


	private String getGermplasmCharacteristics(String keyChar, String gname) {
		String toreturn = "";
		GermplasmCharacteristicMananagerImpl mgr= new GermplasmCharacteristicMananagerImpl();
		List<GermplasmCharacteristics>  germplasmCharateristics= mgr.getGermplasmCharacteristicByKeyandGname(keyChar, gname);

		if(germplasmCharateristics.size() > 0){
			for(GermplasmCharacteristics key:germplasmCharateristics){
				toreturn+=key.getValue()+" ,";
			}
			return toreturn.substring(0,toreturn.length()-1);
		}

		return toreturn;

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

	private Germplasm getGermplasmDetailInformation(int id){
		GermplasmManagerImpl mgr = new GermplasmManagerImpl();
		Germplasm g=mgr.getGermplasmById(id);
		return g;
	}

	private List<GermplasmType> getGermplasmTypeList() {
		GermplasmTypeManagerImpl mgr= new GermplasmTypeManagerImpl();
		germplasmType=mgr.getAllGermplasmType();
		for(GermplasmType type:germplasmType){
			germplasmTypeKey.put(type.getGermplasmtype(), type.getId());
		}
		return germplasmType;
	}

}
