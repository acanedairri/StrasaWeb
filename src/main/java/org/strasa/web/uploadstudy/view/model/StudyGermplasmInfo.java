package org.strasa.web.uploadstudy.view.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.manager.GermplasmCharacteristicMananagerImpl;
import org.strasa.middleware.manager.GermplasmManagerImpl;
import org.strasa.middleware.manager.GermplasmTypeManagerImpl;
import org.strasa.middleware.manager.KeyCharacteristicManagerImpl;
import org.strasa.middleware.manager.StudyGermplasmManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmCharacteristicsExample;
import org.strasa.middleware.model.GermplasmExample;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.strasa.middleware.model.StudyGermplasm;
import org.strasa.web.common.api.Encryptions;
import org.strasa.web.common.api.FormValidator;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.strasa.web.uploadstudy.view.pojos.GermplasmExt;
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Row;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import com.mysql.jdbc.StringUtils;

public class StudyGermplasmInfo extends ProcessTabViewModel {

	@WireVariable
	ConnectionFactory connectionFactory;
	
	@Wire("#tblKnownGerm")
	Grid tblKnownGerm;

	@Wire("#tblStudyGerm")
	Grid tblStudyGerm;

	@Wire("#gbUnknownGermplasm")
	Groupbox gbUnknownGermplasm;
	@Wire("#gbKnownGermplasm")
	Groupbox gbKnownGermplasm;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);

		// wire event listener
		// Selectors.wireEventListeners(view, this);
	}

	HashMap<String, GermplasmDeepInfoModel> lstStudyGermplasm = new HashMap<String, GermplasmDeepInfoModel>();

	public ArrayList<GermplasmDeepInfoModel> arrGermplasmDeepInfo = new ArrayList<GermplasmDeepInfoModel>();
	private String[] arrGermplasmType;
	private List<GermplasmType> lstGermplasmType = new ArrayList<GermplasmType>();
	private FormValidator formValidator = new FormValidator();
	private HashMap<String, GermplasmDeepInfoModel> lstKnownGermplasm = new HashMap<String, GermplasmDeepInfoModel>();

	public List<GermplasmDeepInfoModel> getLstKnownGermplasm() {

		return new ArrayList<GermplasmDeepInfoModel>(lstKnownGermplasm.values());
	}

	public void setLstKnownGermplasm(
			HashMap<String, GermplasmDeepInfoModel> lstKnownGermplasm) {
		this.lstKnownGermplasm = lstKnownGermplasm;
	}

	private List<KeyBiotic> lstBiotics;

	private List<KeyAbiotic> lstAbiotics;

	private List<KeyGrainQuality> lstGrainQualities;

	private List<KeyMajorGenes> lstAllMajorGenes;

	public List<GermplasmType> getLstGermplasmType() {
		return lstGermplasmType;
	}

	public String[] getCharacteristicTabs() {
		return new String[] { "Sample 1", "Sample 2", "Sample 3" };

	}

	public void setLstGermplasmType(List<GermplasmType> lstGermplasmType) {
		this.lstGermplasmType = lstGermplasmType;
	}

	public String[] getArrGermplasmType() {
		GermplasmTypeManagerImpl germMan = new GermplasmTypeManagerImpl();
		ArrayList<String> strVal = new ArrayList<String>();
		for (GermplasmType data : germMan.getAllGermplasmType()) {
			strVal.add(data.getGermplasmtype());
		}
		arrGermplasmType = strVal.toArray(new String[strVal.size()]);
		return arrGermplasmType;
	}

	public FormValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(FormValidator formValidator) {
		this.formValidator = formValidator;
	}

	public void setArrGermplasmType(String[] arrGermplasmType) {
		this.arrGermplasmType = arrGermplasmType;
	}

	public ArrayList<GermplasmDeepInfoModel> getLstStudyGermplasm() {
		return new ArrayList<GermplasmDeepInfoModel>(lstStudyGermplasm.values());
	}

	public void setLstStudyGermplasm(
			HashMap<String, GermplasmDeepInfoModel> lstStudyGermplasm) {
		this.lstStudyGermplasm = lstStudyGermplasm;
	}

	@Command
	public List<GermplasmDeepInfoModel> getGermplasmByName(
			@BindingParam("Gname") String gname) {

		List<GermplasmDeepInfoModel> returnVal = new ArrayList<GermplasmDeepInfoModel>();
		for (GermplasmDeepInfoModel data : arrGermplasmDeepInfo) {
			if (data.getGermplasmname().equals(gname))
				{
				returnVal.add(data);
				

				}
		}
		return returnVal;

	}
	
	public void printArrList(){
		System.out.println("_____________________________________________________________");
		
		for (GermplasmDeepInfoModel data : arrGermplasmDeepInfo) {
			System.out.println(data.toString());
		}
		
		System.out.println("_____________________________________________________________");
		
	}

	@Init
	public void init(
			@ExecutionArgParam("uploadModel") ProcessTabViewModel uploadModel) {

		initValues(uploadModel);
		// @Init
		// public void init() {
		// int studyID = 121; //small
		// int studyID = 132; // large
		// boolean isRaw = true;

		Runtimer timer = new Runtimer();
		timer.start();
		KeyCharacteristicManagerImpl keyMan = new KeyCharacteristicManagerImpl();
		lstBiotics = keyMan.getAllBiotic();
		lstAbiotics = keyMan.getAllAbiotic();
		lstGrainQualities = keyMan.getAllGrainQuality();
		lstAllMajorGenes = keyMan.getAllMajorGenes();
		GermplasmTypeManagerImpl germMan = new GermplasmTypeManagerImpl();

		lstGermplasmType = germMan.getAllGermplasmType();

		StudyRawDataManagerImpl rawMan = new StudyRawDataManagerImpl(isRaw);
		List<StudyGermplasm> lst = rawMan.getStudyGermplasmInfo(studyID,
				dataset.getId());

		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);
		GermplasmCharacteristicsMapper charMapper = session
				.getMapper(GermplasmCharacteristicsMapper.class);
		for (StudyGermplasm data : lst) {
	
			GermplasmExample example = new GermplasmExample();
			example.createCriteria().andGermplasmnameEqualTo(
					data.getGermplasmname());
			List<Germplasm> lstGerm = mapper.selectByExample(example);

			if (!lstGerm.isEmpty()) {
				for (Germplasm germData : lstGerm) {
					GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel(
							(int) this.studyID,this.dataset.getId());
					newData.setValuesFromExistingGermplasm(germData);
					GermplasmCharacteristicsExample charEx = new GermplasmCharacteristicsExample();
					charEx.createCriteria().andGermplasmnameEqualTo(
							newData.getGermplasmname());
					newData.setCharacteristicValues(charMapper
							.selectByExample(charEx));
					if (newData.getGid() != null)
						if (newData.getGid() == 0)
							newData.setGid(null);
					if (newData.getOthername() != null)
						if (newData.getOthername().isEmpty()
								|| newData.getOthername().trim().equals(""))
							newData.setOthername(null);
					newData.rowIndex = lstKnownGermplasm.size();
					arrGermplasmDeepInfo.add(newData);
					System.out.println(newData.toString());
					if(!lstKnownGermplasm.containsKey(newData.getGermplasmname())) lstKnownGermplasm.put(newData.getGermplasmname(), newData);

				}
			} else {
				GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel(
						(int) this.studyID,this.dataset.getId());
				if (newData.getGid() != null)
					if (newData.getGid() == 0)
						newData.setGid(null);
				if (newData.getOthername() != null)
					if (newData.getOthername().isEmpty()
							|| newData.getOthername().trim().equals(""))
						newData.setOthername(null);
				newData.setValuesStudyGerm(data);
				newData.rowIndex = lstStudyGermplasm.size();
				lstStudyGermplasm.put(newData.getGermplasmname(), newData);

			}

			if (lstGerm.isEmpty()) {

			} else {

			}
		}

		GermplasmCharacteristicMananagerImpl studyCharMan = new GermplasmCharacteristicMananagerImpl();

		// List<GermplasmCharacteristics> arrCharList =
		// studyCharMan.getCharacteristicsByStudyID((int) studyID);
		ArrayList<String> keyCharMap = new ArrayList<String>();

		// for(GermplasmCharacteristics data : arrCharList){
		// keyCharMap.add(data.getGermplasmname()+data.getAttribute()+data.getValue());
		// }
		int iterator = 0;
		for (GermplasmDeepInfoModel dataModel : lstStudyGermplasm.values()) {

			dataModel.pkey = iterator;
			iterator++;
		}
		
		if(this.isUpdateMode){
			
			StudyGermplasmManagerImpl studyMan = new StudyGermplasmManagerImpl();
			List<StudyGermplasm> lstExistingStudyGerms = studyMan.getStudyGermplasmByStudyId(this.studyID, this.dataset.getId());
			
			for(StudyGermplasm studyGerm : lstExistingStudyGerms){
				System.out.println("Changing....");
				
				lstKnownGermplasm.put(studyGerm.getGermplasmname(), getGermplasmDeepInfoModelById(studyGerm.getGref()));
			}
		}
		
		
//		printArrList();
//
//		System.out.println("ERROR: " + arrGermplasmDeepInfo.size());
		timer.end();
	}
	
	
	public GermplasmDeepInfoModel getGermplasmDeepInfoModelById(Integer id){
		
		for(GermplasmDeepInfoModel model : arrGermplasmDeepInfo){
			if(model.getId() == id ) return model;
		}
		return null;
	}
	@NotifyChange("lstKnownGermplasm")
	@Command
	public void changeGermplasmInfo(@BindingParam("index") GermplasmDeepInfoModel selected) {
    System.out.println(selected.toString());
    	selected.selectedData = selected;
		lstKnownGermplasm.put(selected.getGermplasmname(), selected.selectedData);
//		printArrList();
		
	}

	@NotifyChange({ "lstStudyGermplasm", "lstKnownGermplasm" })
	@Command("uploadGenotypeData")
	public void uploadGenotypeData(
			@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,
			@ContextParam(ContextType.VIEW) Component view) {

		UploadEvent event = (UploadEvent) ctx.getTriggerEvent();

		// System.out.println(event.getMedia().getStringData());

		String name = event.getMedia().getName();
		if (!name.endsWith(".csv")) {
			Messagebox.show("Error: File must be a text-based CSV  format",
					"Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}

		try {
			String filename = name
					+ Encryptions.encryptStringToNumber(name,
							new Date().getTime());
			File tempGenoFile = File.createTempFile(filename, ".tmp");
			InputStream in = event.getMedia().isBinary() ? event.getMedia()
					.getStreamData() : new ReaderInputStream(event.getMedia()
					.getReaderData());
			FileUtilities.uploadFile(tempGenoFile.getAbsolutePath(), in);
			List<GermplasmExt> lstGermplasm = CSVToBean(tempGenoFile);
			for (GermplasmExt germData : lstGermplasm) {
				if (!StringUtils.isNullOrEmpty(germData.getGermplasmname())) {
					if (lstStudyGermplasm.containsKey(germData
							.getGermplasmname())) {
						lstStudyGermplasm.get(germData.getGermplasmname())
								.setValuesExt(germData);
					}
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public List<GermplasmExt> CSVToBean(File file) throws FileNotFoundException {
		CsvToBean<GermplasmExt> bean = new CsvToBean<GermplasmExt>();

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("GID", "gid");
		columnMapping.put("GName", "germplasmname");
		columnMapping.put("OtherName", "othername");
		columnMapping.put("Breeder", "breeder");
		columnMapping.put("IR Number", "irnumber");
		columnMapping.put("IR Cross", "ircross");
		columnMapping.put("GermplasmType", "germplasmtype");
		columnMapping.put("Parentage", "parentage");
		columnMapping.put("Female Parent", "femaleparent");
		columnMapping.put("Male Parent", "maleparent");
		columnMapping.put("Selection History", "selectionhistory");
		columnMapping.put("Source", "source");

		HeaderColumnNameTranslateMappingStrategy<GermplasmExt> strategy = new HeaderColumnNameTranslateMappingStrategy<GermplasmExt>();
		strategy.setType(GermplasmExt.class);
		strategy.setColumnMapping(columnMapping);

		CSVReader reader = new CSVReader(new FileReader(file));

		return bean.parse(strategy, reader);
	}

	public boolean validateKnownGermplasm() {
		int studyGerm = 0;
		for (GermplasmDeepInfoModel data : lstKnownGermplasm.values()) {
			String validate = data.validate(false);
			((Row) tblKnownGerm.getRows().getChildren().get(studyGerm))
					.setStyle("background-color: #FFF");
			if (validate != null) {
				Messagebox.show(validate, "OK", Messagebox.OK,
						Messagebox.EXCLAMATION);

				((Row) tblKnownGerm.getRows().getChildren().get(studyGerm))
						.setStyle("background-color: #ff6666");
				((Row) tblKnownGerm.getRows().getChildren().get(studyGerm))
						.setFocus(true);
				return false;
			}
			studyGerm++;

		}
		return true;

	}

	public boolean validateStudyGermplasm() {
		int studyGerm = 0;
		for (GermplasmDeepInfoModel data : lstStudyGermplasm.values()) {
			((Row) tblStudyGerm.getRows().getChildren().get(studyGerm))
					.setStyle("background-color: #FFF");
			String validate = data.validate(true);
			if (validate != null) {
				Messagebox.show(validate, "OK", Messagebox.OK,
						Messagebox.EXCLAMATION);

				((Row) tblStudyGerm.getRows().getChildren().get(studyGerm))
						.setStyle("background-color: #ff6666");
				((Row) tblStudyGerm.getRows().getChildren().get(studyGerm))
						.setFocus(true);
				return false;
			}
			studyGerm++;

		}
		return true;

	}

	@Command
	public void updateCharacteristicInfo(
			@BindingParam("model") GermplasmDeepInfoModel model) {
		BindUtils.postNotifyChange(null, null, this.getLstStudyGermplasm().get(model.rowIndex), "*");
		this.tblStudyGerm.invalidate();
	}
	

	@NotifyChange({ "lstKnownGermplasm", "lstStudyGermplasm" })
	@Command
	public void modifyGermplasm(@BindingParam("gname") String gname) {
		lstKnownGermplasm.get(gname).rowIndex = lstStudyGermplasm.size();
		lstStudyGermplasm.put(gname, lstKnownGermplasm.get(gname));
		lstKnownGermplasm.remove(gname);
		lstStudyGermplasm.get(gname).processOthers();
		lstStudyGermplasm.get(gname).reprocessCharacteristic();
		
		lstStudyGermplasm.get(gname).currBreeder = lstStudyGermplasm.get(gname)
				.getBreeder();
		for (GermplasmType gType : lstGermplasmType) {
			if (gType.getId() == lstStudyGermplasm.get(gname)
					.getGermplasmtypeid()) {
				lstStudyGermplasm.get(gname).selectedGermplasmType = gType;
			}
		}

		if (this.getUserID() != lstStudyGermplasm.get(gname).userID) {
			System.out.println("New User!");
			lstStudyGermplasm.get(gname).setUserID(this.userID);
			lstStudyGermplasm.get(gname).setId(null);
			lstStudyGermplasm.get(gname).isAppend = true;
		}

		gbKnownGermplasm.invalidate();
		gbUnknownGermplasm.invalidate();
	}

	@Command
	public void validateList() {
		Runtimer timer = new Runtimer();
		timer.start();

		if (!validateStudyGermplasm()) {

			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", this);
		BindUtils.postGlobalCommand(null, null, "nextTab", params);
	}

	@Override
	public boolean validateTab() {

		// Validation
		if (!validateKnownGermplasm()) {
			return false;
		}
		if (!validateStudyGermplasm()) {
			return false;
		}

		StudyGermplasmManagerImpl studyGermplasmMan = new StudyGermplasmManagerImpl();
		GermplasmManagerImpl germplasmManagerImpl = new GermplasmManagerImpl();
		// List<StudyGermplasm> lstStudyGerm =
		// convertDeepInfoToModel(lstStudyGermplasm.values());
		GermplasmCharacteristicMananagerImpl germCharMan = new GermplasmCharacteristicMananagerImpl();
		List<GermplasmDeepInfoModel> lstStudyGermpl = new ArrayList<GermplasmDeepInfoModel>();
		lstStudyGermpl.addAll(lstKnownGermplasm.values());
		lstStudyGermpl.addAll(lstStudyGermplasm.values());

		studyGermplasmMan.addStudyGermplasmBatch(lstStudyGermpl);
		germplasmManagerImpl.addGermplasm(germplasmManagerImpl
				.convertStudyToGermplasm(lstStudyGermplasm.values()));
		germCharMan.addCharacteristicBatch(lstStudyGermplasm.values());
		germplasmManagerImpl.updateBreeders(lstStudyGermpl);

		return true;

	}

	// @Init
	// public void init() {
	// this.studyID = 1;
	// StudyGermplasmManagerImpl germplasmMan = new StudyGermplasmManagerImpl();
	// setLstStudyGermplasm(germplasmMan.getStudyGermplasmByStudyId(5));
	// }

	public List<StudyGermplasm> convertDeepInfoToModel(
			Collection<GermplasmDeepInfoModel> oldList) {

		List<StudyGermplasm> returnVal = new ArrayList<StudyGermplasm>();
		for (GermplasmDeepInfoModel data : oldList) {
			StudyGermplasm newData = new StudyGermplasm();
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
			returnVal.add(newData);
		}
		return returnVal;

	}

	public String getGermplasmType(int id) {

		for (GermplasmType type : lstGermplasmType) {
			if (type.getId() == id)
				return type.getGermplasmtype();
		}
		return "";

	}

	public class GermplasmDeepInfoModel extends StudyGermplasm {
		public int userID;

		public GermplasmDeepInfoModel selectedData;

		public GermplasmDeepInfoModel getSelectedData() {
			return selectedData;
		}

		public void setSelectedData(GermplasmDeepInfoModel selectedData) {
//			this.selectedData = selectedData;
			System.out.println("SELECTED " + selectedData.getOthername());
//			lstKnownGermplasm.put(selectedData.getGermplasmname(), selectedData);
//		
//			BindUtils.postNotifyChange(null, null, StudyGermplasmInfo.this, "*");
		}

		public int getUserID() {
			return userID;
		}

		public void addExistingGermplasm(GermplasmDeepInfoModel data) {
			System.out.println("Added new total: "
					+ lstExistingGermplasm.size());
			lstExistingGermplasm.add(data);
		}

		public List<GermplasmDeepInfoModel> lstExistingGermplasm = new ArrayList<GermplasmDeepInfoModel>();

		public List<GermplasmDeepInfoModel> getLstExistingGermplasm() {
			return lstExistingGermplasm;
		}

		public void setLstExistingGermplasm(
				List<GermplasmDeepInfoModel> lstExistingGermplasm) {
			this.lstExistingGermplasm = lstExistingGermplasm;
		}

		public void setUserID(int userID) {
			this.userID = userID;
		}

		public boolean isAppend = false;
		public int rowIndex;
		private String germplasmType;
		private GermplasmType selectedGermplasmType;

		public GermplasmType getSelectedGermplasmType() {
			return selectedGermplasmType;
		}

		public void setSelectedGermplasmType(GermplasmType selectedGermplasmType) {
			this.selectedGermplasmType = selectedGermplasmType;
			this.setGermplasmtypeid(selectedGermplasmType.getId());
		}

		public String getGermplasmType() {
			return germplasmType;
		}

		public void setGermplasmType(String germplasmType) {

			this.germplasmType = germplasmType;
		}

		private String abiotic, biotic, grainquality, majorgenes;

		public String getAbiotic() {

			if (!charMap.containsKey("Abiotic"))
				return null;
			return org.apache.commons.lang3.StringUtils.join(
					charMap.get("Abiotic"), ", ");

		}

		public void setAbiotic(String abiotic) {
			this.abiotic = abiotic;
		}

		public String getBiotic() {
			if (!charMap.containsKey("Biotic"))
				return null;
			return org.apache.commons.lang3.StringUtils.join(
					charMap.get("Biotic"), ", ");

		}

		public void setBiotic(String biotic) {
			this.biotic = biotic;
		}

		public String getGrainquality() {
			if (!charMap.containsKey("Grain Quality"))
				return null;
			return org.apache.commons.lang3.StringUtils.join(
					charMap.get("Grain Quality"), ", ");
		}

		public void setGrainquality(String grainquality) {
			this.grainquality = grainquality;
		}

		public String getMajorgenes() {
			if (!charMap.containsKey("Major Genes"))
				return null;
			return org.apache.commons.lang3.StringUtils.join(
					charMap.get("Major Genes"), ", ");

		}

		public void setMajorgenes(String majorgenes) {
			this.majorgenes = majorgenes;
		}

		private List<CharacteristicModel> keyBiotic = new ArrayList<CharacteristicModel>();
		private List<CharacteristicModel> keyAbiotic = new ArrayList<CharacteristicModel>();
		private List<CharacteristicModel> keyGrainQuality = new ArrayList<CharacteristicModel>();
		private List<CharacteristicModel> keyMajorGenes = new ArrayList<CharacteristicModel>();
		private String characteristic = "";
		public int pkey;
		private String styleBG = "background-color: #FFF";

		public String getStyleBG() {
			return styleBG;
		}

		public void setStyleBG(String styleBG) {
			this.styleBG = styleBG;
		}

		public boolean isInGenotype = false;
		private String currBreeder;
		private String oldBreeders;
		private String dispBreeder;
		private String preservedBreeder;
		private double masterID = Math.random();
		private int preservedGermplasmID;
		private HashMap<String, ArrayList<String>> charMap;

		public double getMasterID() {
			return masterID;
		}

		public void reprocessCharacteristic() {
			if (charMap.containsKey("Biotic"))
				for (String key : charMap.get("Biotic")) {
					for (CharacteristicModel mod : keyBiotic) {
						mod.setValue(charMap.get("Biotic").contains(mod.name));
					}
				}
			if (charMap.containsKey("Abiotic"))
				for (String key : charMap.get("Abiotic")) {
					for (CharacteristicModel mod : keyAbiotic) {
						mod.setValue(charMap.get("Abiotic").contains(mod.name));
					}
				}
			if (charMap.containsKey("Major Genes"))
				for (String key : charMap.get("Major Genes")) {
					for (CharacteristicModel mod : keyMajorGenes) {
						mod.setValue(charMap.get("Major Genes").contains(
								mod.name));
					}
				}
			if (charMap.containsKey("Grain Quality"))
				for (String key : charMap.get("Grain Quality")) {
					for (CharacteristicModel mod : keyGrainQuality) {
						mod.setValue(charMap.get("Grain Quality").contains(
								mod.name));
					}
				}
		}

		public int getPreservedGermplasmID() {
			return preservedGermplasmID;
		}

		public void setPreservedGermplasmID(int preservedGermplasmID) {
			this.preservedGermplasmID = preservedGermplasmID;
		}

		public void setMasterID(double masterID) {
			this.masterID = masterID;
		}

		public String getDispBreeder() {
			return dispBreeder;
		}

		public void setDispBreeder(String dispBreeder) {
			this.dispBreeder = dispBreeder;
		}

		public String getOldBreeders() {
			return oldBreeders;
		}

		public void setOldBreeders(String oldBreeders) {
			this.oldBreeders = oldBreeders;
		}

		public String getCurrBreader() {
			return currBreeder;
		}

		public void setCurrBreader(String currBreader) {
			this.currBreeder = currBreader;
		}

		public String validate(boolean isBreederReq) {
			// if(true) return true;

			if (StringUtils.isNullOrEmpty(getGermplasmname())) {
				// styleBG = "background-color: #ff6666";
				return "Error: GName cannot be empty";
			}
			if (StringUtils.isNullOrEmpty(currBreeder) && isBreederReq) {
				// styleBG = "background-color: #ff6666";
				return "Error: Breeder must not be empty in GName: "
						+ getGermplasmname();
			}

			if (StringUtils.isNullOrEmpty(getFemaleparent())) {
				// styleBG = "background-color: #ff6666";
				return "Error: Female Parent must not be empty in GName: "
						+ getGermplasmname();
			}

			;
			if (StringUtils.isNullOrEmpty(getMaleparent())) {
				// styleBG = "background-color: #ff6666";
				return "Error: Male Parent must not be empty in GName: "
						+ getGermplasmname();
			}

			if (getGermplasmtypeid() == null) {
				// styleBG = "background-color: #ff6666";
				return "Error: Germplasm Type must not be empty in GName: "
						+ getGermplasmname();
			}
			styleBG = "background-color: #FFF";
			return null;
		}

		public void setValuesFromExistingGermplasm(Germplasm germData) {
			this.selectedData = this;
			
			this.setValuesGern(germData);
			this.preservedGermplasmID = germData.getId();
			this.isInGenotype = true;
			this.setGermplasmType(StudyGermplasmInfo.this
					.getGermplasmType(germData.getGermplasmtypeid()));
			this.setBreeders();

		}

		public void setValuesStudyGerm(StudyGermplasm data) {
			if (!StringUtils.isNullOrEmpty(data.getBreeder()))
				setCurrBreader(data.getBreeder());
			if (!StringUtils.isNullOrEmpty(data.getFemaleparent()))
				setFemaleparent(data.getFemaleparent());
			if (!StringUtils.isNullOrEmpty(data.getGermplasmname()))
				setGermplasmname(data.getGermplasmname());
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

		public void setValuesInNullProperties(GermplasmExt germData) {

			setCurrBreader(germData.getBreeder());
			if (StringUtils.isNullOrEmpty(getFemaleparent()))
				setFemaleparent(germData.getFemaleparent());
			if (StringUtils.isNullOrEmpty(getGermplasmname()))
				setGermplasmname(germData.getGermplasmname());
			if (getGid() != null)
				setGid(getGid());
			if (StringUtils.isNullOrEmpty(getIrcross()))
				setIrcross(germData.getIrcross());
			if (StringUtils.isNullOrEmpty(getIrnumber()))
				setIrnumber(germData.getIrnumber());
			if (StringUtils.isNullOrEmpty(getMaleparent()))
				setMaleparent(germData.getMaleparent());
			if (StringUtils.isNullOrEmpty(getOthername()))
				setOthername(germData.getOthername());
			if (StringUtils.isNullOrEmpty(getParentage()))
				setParentage(germData.getParentage());
			if (StringUtils.isNullOrEmpty(getRemarks()))
				setRemarks(germData.getRemarks());
			if (StringUtils.isNullOrEmpty(getSelectionhistory()))
				setSelectionhistory(germData.getSelectionhistory());
			if (StringUtils.isNullOrEmpty(getSource()))
				setSource(germData.getSource());
		}

		public void setCharacteristicValues(
				List<GermplasmCharacteristics> lstChar) {

			charMap = new HashMap<String, ArrayList<String>>();

			for (GermplasmCharacteristics charRecord : lstChar) {
				if (charMap.containsKey(charRecord.getAttribute())) {
					charMap.get(charRecord.getAttribute()).add(
							charRecord.getKeyvalue());
				} else {
					charMap.put(charRecord.getAttribute(),
							new ArrayList<String>());
					charMap.get(charRecord.getAttribute()).add(
							charRecord.getKeyvalue());
				}
			}
			for (Entry<String, ArrayList<String>> entry : charMap.entrySet()) {
				String key = entry.getKey();
				ArrayList<String> value = entry.getValue();
				characteristic = characteristic + " <b>" + key
						+ "</b> <br /> <ul>";

				for (String val : value) {
					characteristic = characteristic + "<li>" + val + "</li>";
				}

				characteristic = characteristic + "</ul> <br />";

				// ...
			}

		}

		public void setValuesGern(Germplasm data) {
			setGref(data.getId());
			setBreeder(data.getBreeder());
			setFemaleparent(data.getFemaleparent());
			setGermplasmname(data.getGermplasmname());
			setGermplasmtypeid(data.getGermplasmtypeid());
			setGid(data.getGid());
			setUserID(data.getUserid());
			setIrcross(data.getIrcross());
			setIrnumber(data.getIrnumber());
			setMaleparent(data.getMaleparent());
			setOthername(data.getOthername());
			setParentage(data.getParentage());
			setRemarks(data.getRemarks());
			setSelectionhistory(data.getSelectionhistory());
			setSource(data.getSource());
			setId(data.getId());
		}

		public void setValuesExt(GermplasmExt data) {
			setCurrBreader(data.getBreeder());
			setFemaleparent(data.getFemaleparent());
			setGermplasmname(data.getGermplasmname());

			setGid(data.getGid());

			for (int i = 0; i < lstGermplasmType.size(); i++) {
				if (data.getGermplasmtype().equals(
						lstGermplasmType.get(i).getGermplasmtype())) {
					setSelectedGermplasmType(lstGermplasmType.get(i));
				}
			}
			setIrcross(data.getIrcross());
			setIrnumber(data.getIrnumber());
			setMaleparent(data.getMaleparent());
			setOthername(data.getOthername());
			setParentage(data.getParentage());
			setRemarks(data.getRemarks());
			setSelectionhistory(data.getSelectionhistory());
			setSource(data.getSource());
		}

		public List<GermplasmCharacteristics> getCharacteristicValues() {
			List<GermplasmCharacteristics> lstCharacteristics = new ArrayList<GermplasmCharacteristics>();

			for (CharacteristicModel model : this.keyAbiotic) {
				if (model.value) {
					GermplasmCharacteristics rec = new GermplasmCharacteristics();

					rec.setAttribute("Abiotic");
					rec.setGermplasmname(this.getGermplasmname());
					rec.setKeyvalue(model.name);
					lstCharacteristics.add(rec);
				}
			}
			for (CharacteristicModel model : this.keyBiotic) {
				if (model.value) {
					GermplasmCharacteristics rec = new GermplasmCharacteristics();

					rec.setAttribute("Biotic");
					rec.setGermplasmname(this.getGermplasmname());
					rec.setKeyvalue(model.name);
					lstCharacteristics.add(rec);
				}
			}
			for (CharacteristicModel model : this.keyGrainQuality) {
				if (model.value) {
					GermplasmCharacteristics rec = new GermplasmCharacteristics();

					rec.setAttribute("Grain Quality");
					rec.setGermplasmname(this.getGermplasmname());
					rec.setKeyvalue(model.name);
					lstCharacteristics.add(rec);
				}
			}
			for (CharacteristicModel model : this.keyMajorGenes) {
				if (model.value) {
					GermplasmCharacteristics rec = new GermplasmCharacteristics();

					rec.setAttribute("Major Genes");
					rec.setGermplasmname(this.getGermplasmname());
					rec.setKeyvalue(model.name);
					lstCharacteristics.add(rec);
				}
			}

			return lstCharacteristics;

		}

		
		
		
		
		public String getStrAbiotic(){
			
			String returnVal = "";
			for(CharacteristicModel model : keyAbiotic){
				if(model.value) returnVal = returnVal + " " + model.name; 
			}
			return returnVal;
		}
		
public String getStrBiotic(){
			
			String returnVal = "";
			for(CharacteristicModel model : keyBiotic){
				if(model.value) returnVal = returnVal + " " + model.name; 
			}
			return returnVal;
		}
		
public String getStrMajorGenes(){
	
	String returnVal = "";
	for(CharacteristicModel model : keyMajorGenes){
		if(model.value) returnVal = returnVal + " " + model.name; 
	}
	return returnVal;
}
		
public String getStrGrainQuality(){
	
	String returnVal = "";
	for(CharacteristicModel model : keyGrainQuality){
		if(model.value) returnVal = returnVal + " " + model.name; 
	}
	return returnVal;
}

		
		
		
		
		public String getCharacteristic() {
			return characteristic;
		}

		public String getComboItemName(){
			return this.getGermplasmname() + "(" + this.getId() + ")";
		}
		@NotifyChange("characteristic")
		public void setCharacteristic(String characteristic) {
			this.characteristic = characteristic;
		}

		public List<CharacteristicModel> getKeyBiotic() {
			List<CharacteristicModel> returnVal = new ArrayList<StudyGermplasmInfo.CharacteristicModel>();
			for(CharacteristicModel model : keyBiotic){
				if(model.value)returnVal.add(model);
			}
			for(CharacteristicModel model : keyBiotic){
				if(!model.value)returnVal.add(model);
			}
			return returnVal;
		}

		public void setKeyBiotic(List<CharacteristicModel> keyBiotic) {
			this.keyBiotic = keyBiotic;
		}

		public List<CharacteristicModel> getKeyAbiotic() {
			List<CharacteristicModel> returnVal = new ArrayList<StudyGermplasmInfo.CharacteristicModel>();
			for(CharacteristicModel model : keyAbiotic){
				if(model.value)returnVal.add(model);
			}
			for(CharacteristicModel model : keyAbiotic){
				if(!model.value)returnVal.add(model);
			}
			return returnVal;
		}

		public void setKeyAbiotic(List<CharacteristicModel> keyAbiotic) {
			this.keyAbiotic = keyAbiotic;
		}

		public List<CharacteristicModel> getKeyGrainQuality() {
			List<CharacteristicModel> returnVal = new ArrayList<StudyGermplasmInfo.CharacteristicModel>();
			for(CharacteristicModel model : keyGrainQuality){
				if(model.value)returnVal.add(model);
			}
			for(CharacteristicModel model : keyGrainQuality){
				if(!model.value)returnVal.add(model);
			}
			return returnVal;
		}

		public void setKeyGrainQuality(List<CharacteristicModel> keyGrainQuality) {
			this.keyGrainQuality = keyGrainQuality;
		}

		public List<CharacteristicModel> getKeyMajorGenes() {
			List<CharacteristicModel> returnVal = new ArrayList<StudyGermplasmInfo.CharacteristicModel>();
			for(CharacteristicModel model : keyMajorGenes){
				if(model.value)returnVal.add(model);
			}
			for(CharacteristicModel model : keyMajorGenes){
				if(!model.value)returnVal.add(model);
			}
			return returnVal;
		}

		public void setKeyMajorGenes(List<CharacteristicModel> keyMajorGenes) {
			this.keyMajorGenes = keyMajorGenes;
		}

		public void setBreeders() {
			preservedBreeder = getBreeder();

			if (getBreeder() != null) {
				String[] arrBreeders = getBreeder().split(", ");
				if (arrBreeders.length < 2) {
					dispBreeder = getBreeder();
					oldBreeders = getBreeder().replace(", ", " \n ");
				} else {
					dispBreeder = arrBreeders[0] + ", " + arrBreeders[1]
							+ "...";
					oldBreeders = getBreeder().replace(", ", " \n ");
				}
			}
		}

		public Germplasm toGermplasm() {
			GermplasmDeepInfoModel data = this;
			Germplasm newData = new Germplasm();
			String tempBreeder;

			if (StringUtils.isNullOrEmpty(preservedBreeder)) {
				tempBreeder = getCurrBreader();
			} else if (StringUtils.isNullOrEmpty(getCurrBreader())) {
				tempBreeder = preservedBreeder;
			} else {
				System.out.println("WAT: " + getCurrBreader());
				if (preservedBreeder.contains(getCurrBreader()))
					tempBreeder = preservedBreeder;
				else {
					if (StringUtils.isNullOrEmpty(preservedBreeder))
						tempBreeder = getCurrBreader();
					else
						tempBreeder = preservedBreeder + ", "
								+ getCurrBreader();
				}

			}
			newData.setBreeder(tempBreeder);
			newData.setFemaleparent(data.getFemaleparent());
			newData.setGermplasmname(data.getGermplasmname());
			newData.setGermplasmtypeid(data.getGermplasmtypeid());
			newData.setGid(data.getGid());
			newData.setId(data.preservedGermplasmID);
			newData.setIrcross(data.getIrcross());
			newData.setIrnumber(data.getIrnumber());
			newData.setMaleparent(data.getMaleparent());
			newData.setOthername(data.getOthername());
			newData.setParentage(data.getParentage());
			newData.setRemarks(data.getRemarks());
			newData.setSelectionhistory(data.getSelectionhistory());
			newData.setSource(data.getSource());
			return newData;
		}

		public GermplasmDeepInfoModel(int studyID, int dataset) {

			processOthers();
			setStudyid((int) studyID);
			setDataset(dataset);

		}

		public void processOthers() {
			List<CharacteristicModel> lstBioticKey = new ArrayList<CharacteristicModel>();

			for (KeyBiotic data : lstBiotics) {
				CharacteristicModel newData = new CharacteristicModel();
				newData.setName(data.getValue());
				newData.setValue(false);
				newData.primaryid = pkey;
				lstBioticKey.add(newData);

			}
			List<CharacteristicModel> lstAbioticKey = new ArrayList<CharacteristicModel>();
			for (KeyAbiotic data : lstAbiotics) {
				CharacteristicModel newData = new CharacteristicModel();
				newData.primaryid = pkey;
				newData.setName(data.getValue());
				newData.setValue(false);
				lstAbioticKey.add(newData);
			}
			List<CharacteristicModel> lstGrainQuality = new ArrayList<CharacteristicModel>();
			for (KeyGrainQuality data : lstGrainQualities) {
				CharacteristicModel newData = new CharacteristicModel();
				newData.primaryid = pkey;
				newData.setName(data.getValue());

				newData.setValue(false);
				lstGrainQuality.add(newData);
			}
			List<CharacteristicModel> lstMajorGenes = new ArrayList<CharacteristicModel>();
			for (KeyMajorGenes data : lstAllMajorGenes) {
				CharacteristicModel newData = new CharacteristicModel();
				newData.primaryid = pkey;
				newData.setName(data.getValue());

				newData.setValue(false);
				lstMajorGenes.add(newData);
			}
			setKeyAbiotic(lstAbioticKey);
			setKeyBiotic(lstBioticKey);
			setKeyGrainQuality(lstGrainQuality);
			setKeyMajorGenes(lstMajorGenes);

			if (getBreeder() != null) {
				String[] arrBreeders = getBreeder().split(", ");
				if (arrBreeders.length < 2) {
					dispBreeder = getBreeder();
					oldBreeders = getBreeder();
				} else {
					dispBreeder = arrBreeders[0] + ", " + arrBreeders[1]
							+ "...";
					oldBreeders = getBreeder();
				}
			}
		}
	}

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

	}

	public void debugMap(Map<String, ArrayList<String>> map) {
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			ArrayList<String> value = entry.getValue();
			System.out.println("Key: " + key + " Arr: " + value.toString());
			// ...
		}
	}

	public class Runtimer {
		long startTime = System.nanoTime();

		public long start() {
			startTime = System.nanoTime();
			return startTime;
		}

		public double end() {
			long endTime = System.nanoTime();
			System.out.println("DURATION : " + (endTime - startTime)
					/ 1000000000.0);
			return (endTime - startTime) / 1000000000.0;
		}

	}

}