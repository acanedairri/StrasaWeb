package org.strasa.web.uploadstudy.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.manager.GermplasmTypeManager;
import org.strasa.middleware.manager.StudyGermplasmManagerImpl;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.StudyGermplasm;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

public class DefineGermplasmInformation extends ProcessTabViewModel{

	List<StudyGermplasm> lstStudyGermplasm = new ArrayList<StudyGermplasm>();
	private long studyID;
	private String[] arrGermplasmType;
	private List<GermplasmType> lstGermplasmType = new ArrayList<GermplasmType>();
	
	public List<GermplasmType> getLstGermplasmType() {
		return lstGermplasmType;
	}

	public void setLstGermplasmType(List<GermplasmType> lstGermplasmType) {
		this.lstGermplasmType = lstGermplasmType;
	}

	public String[] getArrGermplasmType() {
		GermplasmTypeManager germMan = new GermplasmTypeManager();
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

	public List<StudyGermplasm> getLstStudyGermplasm() {
		return lstStudyGermplasm;
	}

	public void setLstStudyGermplasm(List<StudyGermplasm> lstStudyGermplasm) {
		this.lstStudyGermplasm = lstStudyGermplasm;
	}
	
	@Init
//	public void init(@ExecutionArgParam("studyID") long studyID) {
	public void init() {
	this.studyID = 9;	
	System.out.println("Passed: " + studyID);
	StudyGermplasmManagerImpl germplasmMan = new StudyGermplasmManagerImpl();
	setLstStudyGermplasm(germplasmMan.getStudyGermplasmByStudyId((int)studyID));
	GermplasmTypeManager germMan = new GermplasmTypeManager();
	lstGermplasmType = germMan.getAllGermplasm();
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
	
}
