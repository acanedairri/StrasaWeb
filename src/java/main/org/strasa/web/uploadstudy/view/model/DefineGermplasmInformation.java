package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.GermplasmTypeManagerImpl;
import org.strasa.middleware.manager.KeyCharacteristicManagerImpl;
import org.strasa.middleware.manager.StudyGermplasmCharactersticManagerImpl;
import org.strasa.middleware.manager.StudyGermplasmManagerImpl;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.strasa.middleware.model.StudyGermplasm;
import org.strasa.middleware.model.StudyGermplasmCharacteristic;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.Init;

public class DefineGermplasmInformation extends ProcessTabViewModel{

	List<GermplasmDeepInfoModel> lstStudyGermplasm = new ArrayList<GermplasmDeepInfoModel>();

	private long studyID;
	private String[] arrGermplasmType;
	private List<GermplasmType> lstGermplasmType = new ArrayList<GermplasmType>();
	
	public List<GermplasmType> getLstGermplasmType() {
		return lstGermplasmType;
	}
	public String[] getCharacteristicTabs(){
		return new String[]{"Sample 1", "Sample 2", "Sample 3"};
		
	}

	public void setLstGermplasmType(List<GermplasmType> lstGermplasmType) {
		this.lstGermplasmType = lstGermplasmType;
	}

	public String[] getArrGermplasmType() {
		GermplasmTypeManagerImpl germMan = new GermplasmTypeManagerImpl();
		ArrayList<String> strVal = new ArrayList<String>();
		for(GermplasmType data : germMan.getAllGermplasm()){
			strVal.add(data.getGermplasmtype());
		}
		arrGermplasmType = strVal.toArray(new String[strVal.size()]);
		return arrGermplasmType;
	}

	public void setArrGermplasmType(String[] arrGermplasmType) {
		this.arrGermplasmType = arrGermplasmType;
	}

	public List<GermplasmDeepInfoModel> getLstStudyGermplasm() {
		return lstStudyGermplasm;
	}

	public void setLstStudyGermplasm(List<GermplasmDeepInfoModel> lstStudyGermplasm) {
		this.lstStudyGermplasm = lstStudyGermplasm;
	}
	
	@Init
//	public void init(@ExecutionArgParam("studyID") long studyID) {
	public void init() {
	this.studyID = 5;	
	System.out.println("Passed: " + studyID);
	StudyGermplasmManagerImpl germplasmMan = new StudyGermplasmManagerImpl();
	List<StudyGermplasm> lst = germplasmMan.getStudyGermplasmByStudyId((int)studyID);
	for(StudyGermplasm data : lst){
		GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel();
		newData.setBreeder(data.getBreeder());
		newData.setFemaleparent(data.getFemaleparent());
		newData.setGermplasmname(data.getGermplasmname());
		newData.setGermplasmtypeid(data.getGermplasmtypeid());
		newData.setGid(data.getGid());
		newData.setId(data.getId());
		newData.setIrcross(data.getIrcross());
		newData.setIrnumber(data.getIrnumber());
		newData.setMaleparent(data.getMaleparent());
		newData.setOthername(data.getOthername());
		newData.setParentage(data.getParentage());
		newData.setRemarks(data.getRemarks());
		newData.setSelectionhistory(data.getSelectionhistory());
		newData.setSource(data.getSource());
		newData.setStudyid(data.getStudyid());
		
		lstStudyGermplasm.add(newData);
		
	}
	
	GermplasmTypeManagerImpl germMan = new GermplasmTypeManagerImpl();
	lstGermplasmType = germMan.getAllGermplasm();
	StudyGermplasmCharactersticManagerImpl studyCharMan = new StudyGermplasmCharactersticManagerImpl();
	KeyCharacteristicManagerImpl keyMan = new KeyCharacteristicManagerImpl();
	List<StudyGermplasmCharacteristic> arrCharList = studyCharMan.getCharacteristicsByStudyID((int) studyID);
	ArrayList<String> keyCharMap = new ArrayList<String>();
	
	List<KeyBiotic> lstBiotics = keyMan.getAllBiotic();
	List<KeyAbiotic> lstAbiotics = keyMan.getAllAbiotic();
	List<KeyGrainQuality> lstGrainQualities= keyMan.getAllGrainQuality();
	List<KeyMajorGenes> lstAllMajorGenes = keyMan.getAllMajorGenes();
	for(StudyGermplasmCharacteristic data : arrCharList){
		keyCharMap.add(data.getGermplasmname()+data.getAttribute()+data.getValue());
	}
	for(int i = 0; i < lstStudyGermplasm.size(); i++){
	List<CharacteristicModel> lstBioticKey = new ArrayList<CharacteristicModel>();
	for(KeyBiotic data : lstBiotics){
		CharacteristicModel newData = new CharacteristicModel();
		newData.setName(data.getValue());
		newData.setValue(keyCharMap.contains(lstStudyGermplasm.get(i).getGermplasmname()+"Biotic"+data.getValue()));
		lstBioticKey.add(newData);
	}
	List<CharacteristicModel> lstAbioticKey = new ArrayList<CharacteristicModel>();
	for(KeyAbiotic data : lstAbiotics){
		CharacteristicModel newData = new CharacteristicModel();
		newData.setName(data.getValue());
		newData.setValue(keyCharMap.contains(lstStudyGermplasm.get(i).getGermplasmname()+"Abiotic"+data.getValue()));
		lstAbioticKey.add(newData);
	}
	List<CharacteristicModel> lstGrainQuality = new ArrayList<CharacteristicModel>();
	for(KeyGrainQuality data : lstGrainQualities){
		CharacteristicModel newData = new CharacteristicModel();
		newData.setName(data.getValue());

		newData.setValue(keyCharMap.contains(lstStudyGermplasm.get(i).getGermplasmname()+"Grain Quality"+data.getValue()));
		lstGrainQuality.add(newData);
	}
	List<CharacteristicModel> lstMajorGenes = new ArrayList<CharacteristicModel>();
	for(KeyMajorGenes data : lstAllMajorGenes){
		CharacteristicModel newData = new CharacteristicModel();
		newData.setName(data.getValue());

		newData.setValue(keyCharMap.contains(lstStudyGermplasm.get(i).getGermplasmname()+"Major Genes"+data.getValue()));
		lstMajorGenes.add(newData);
	}
	lstStudyGermplasm.get(i).setKeyAbiotic(lstAbioticKey);
	lstStudyGermplasm.get(i).setKeyBiotic(lstBioticKey);
	lstStudyGermplasm.get(i).setKeyGrainQuality(lstGrainQuality);
	lstStudyGermplasm.get(i).setKeyMajorGenes(lstMajorGenes);
	
	}
	
	}
	
	@Override
	public boolean validateTab(){
		
		StudyGermplasmManagerImpl germplasmMan = new StudyGermplasmManagerImpl();
		for(StudyGermplasm record: lstStudyGermplasm)
			germplasmMan.updateStudyGermplasm(record);
		return true;
		
	}
//	@Init
//	public void init() {
//	this.studyID = 1;	
//	StudyGermplasmManagerImpl germplasmMan = new StudyGermplasmManagerImpl();
//	setLstStudyGermplasm(germplasmMan.getStudyGermplasmByStudyId(5));
//	}
	
	public class GermplasmDeepInfoModel extends StudyGermplasm {
		
	 private List<CharacteristicModel> keyBiotic = new ArrayList<CharacteristicModel>();
	 private List<CharacteristicModel> keyAbiotic = new ArrayList<CharacteristicModel>();
	 private List<CharacteristicModel> keyGrainQuality = new ArrayList<CharacteristicModel>();		
	 private List<CharacteristicModel> keyMajorGenes = new ArrayList<CharacteristicModel>();
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
	 
	}
	public class CharacteristicModel {
		private String name;
		private boolean value;
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
		
	}
	
}
