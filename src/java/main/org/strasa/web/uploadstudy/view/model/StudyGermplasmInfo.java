package org.strasa.web.uploadstudy.view.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.manager.GermplasmManagerImpl;
import org.strasa.middleware.manager.GermplasmTypeManagerImpl;
import org.strasa.middleware.manager.KeyCharacteristicManagerImpl;
import org.strasa.middleware.manager.StudyGermplasmCharacteristicsManagerImpl;
import org.strasa.middleware.manager.StudyGermplasmManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmCharacteristics;
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
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.UploadEvent;

import com.mysql.jdbc.StringUtils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class StudyGermplasmInfo extends ProcessTabViewModel {

	HashMap<String, GermplasmDeepInfoModel> lstStudyGermplasm = new HashMap<String, GermplasmDeepInfoModel>();

	private long studyID;
	private String[] arrGermplasmType;
	private List<GermplasmType> lstGermplasmType = new ArrayList<GermplasmType>();
	private FormValidator formValidator = new FormValidator();

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

	@Init
	// public void init(@ExecutionArgParam("studyID") long studyID,
	// @ExecutionArgParam("isRaw") boolean isRaw ) {
	public void init() {
		int studyID = 33;
		boolean isRaw = true;

		Runtimer timer = new Runtimer();
		timer.start();
		KeyCharacteristicManagerImpl keyMan = new KeyCharacteristicManagerImpl();
		lstBiotics = keyMan.getAllBiotic();
		lstAbiotics = keyMan.getAllAbiotic();
		lstGrainQualities = keyMan.getAllGrainQuality();
		lstAllMajorGenes = keyMan.getAllMajorGenes();

		this.studyID = studyID;
		System.out.println("Geno Passed: " + studyID + " IsRaw: " + isRaw);
		StudyGermplasmManagerImpl germplasmMan = new StudyGermplasmManagerImpl();
		StudyRawDataManagerImpl rawMan = new StudyRawDataManagerImpl(isRaw);
		GermplasmManagerImpl germplMan = new GermplasmManagerImpl();
		List<StudyGermplasm> lst = rawMan.getStudyGermplasmInfo((int) studyID);

		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);
		GermplasmExample example = new GermplasmExample();

		for (StudyGermplasm data : lst) {
			GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel();

			example.createCriteria().andGermplasmnameEqualTo(
					data.getGermplasmname());
			List<Germplasm> lstGerm = mapper.selectByExample(example);

			if (!lstGerm.isEmpty()) {
				Germplasm germData = lstGerm.get(0);
				newData.setBreeder(germData.getBreeder());
				newData.setFemaleparent(germData.getFemaleparent());
				newData.setGermplasmname(germData.getGermplasmname());
				newData.setGermplasmtypeid(germData.getGermplasmtypeid());
				newData.setGid(germData.getGid());
				newData.setId(germData.getId());
				newData.setIrcross(germData.getIrcross());
				newData.setIrnumber(germData.getIrnumber());
				newData.setMaleparent(germData.getMaleparent());
				newData.setOthername(germData.getOthername());
				newData.setParentage(germData.getParentage());
				newData.setRemarks(germData.getRemarks());
				newData.setSelectionhistory(germData.getSelectionhistory());
				newData.setSource(germData.getSource());
			} else {
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
			}
			// //RawDataMapping
			// if(rawMap.containsKey(data.getGermplasmname())){
			// StudyGermplasm r = rawMap.get(data.getGermplasmname());
			//
			// if(newData.getBreeder() == null && !r.getBreeder().equals("") )
			// newData.setBreeder(r.getBreeder());
			// if(newData.getFemaleparent() == null &&
			// !r.getFemaleparent().equals(""))
			// newData.setFemaleparent(r.getFemaleparent());
			// if(newData.getGid() == null && !r.getGid().equals(""))
			// newData.setGid(r.getGid());
			// if(newData.getIrnumber()== null && !r.getIrnumber().equals(""))
			// newData.setIrnumber(r.getIrnumber());
			// if(newData.getMaleparent() == null &&
			// !r.getMaleparent().equals(""))
			// newData.setMaleparent(r.getMaleparent());
			// if(newData.getOthername() == null &&
			// !r.getOthername().equals(""))
			// newData.setOthername(r.getOthername());
			// if(newData.getParentage() == null &&
			// !r.getParentage().equals(""))
			// newData.setRemarks(r.getParentage());
			// if(newData.getRemarks() == null && !r.getRemarks().equals(""))
			// newData.setBreeder(r.getRemarks());
			// if(newData.getSelectionhistory() == null &&
			// !r.getSelectionhistory().equals(""))
			// newData.setSelectionhistory(r.getSelectionhistory());
			// }
			if (newData.getGid() != null)
				if (newData.getGid() == 0)
					newData.setGid(null);
			if (newData.getOthername() != null)
				if (newData.getOthername().isEmpty()
						|| newData.getOthername().trim().equals(""))
					newData.setOthername(null);
			lstStudyGermplasm.put(newData.getGermplasmname(), newData);

		}

		GermplasmTypeManagerImpl germMan = new GermplasmTypeManagerImpl();
		lstGermplasmType = germMan.getAllGermplasmType();
		StudyGermplasmCharacteristicsManagerImpl studyCharMan = new StudyGermplasmCharacteristicsManagerImpl();

		// List<StudyGermplasmCharacteristics> arrCharList =
		// studyCharMan.getCharacteristicsByStudyID((int) studyID);
		ArrayList<String> keyCharMap = new ArrayList<String>();

		// for(StudyGermplasmCharacteristics data : arrCharList){
		// keyCharMap.add(data.getGermplasmname()+data.getAttribute()+data.getValue());
		// }
		int iterator = 0;
		for (GermplasmDeepInfoModel dataModel : lstStudyGermplasm.values()) {

			dataModel.primarykey = iterator;
			iterator++;
		}
		timer.end();
	}

	@NotifyChange("lstStudyGermplasm")
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
			 List<StudyGermplasm> lstGermplasm = CSVToBean(tempGenoFile);
			 for(StudyGermplasm germData : lstGermplasm){
				 if(lstStudyGermplasm.containsKey(germData.getGermplasmname())){
					 if(!lstStudyGermplasm.get(germData.getGermplasmname()).isInGenotype){
						 lstStudyGermplasm.get(germData).setValues(germData);
					 }
				 }
				 else{
					 GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel();
					 newData.setValues(germData);
					 lstStudyGermplasm.put(germData.getGermplasmname(), newData);
				 }
			 }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public List<StudyGermplasm> CSVToBean(File file) throws FileNotFoundException {
		CsvToBean<StudyGermplasm> bean = new CsvToBean<StudyGermplasm>();

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("GID", "gid");
		columnMapping.put("GName", "germplasmname");
		columnMapping.put("OtherName", "othername");
		columnMapping.put("Breeder","breeder");
		columnMapping.put("IR Number","irnumber");
		columnMapping.put("IR Cross","ircross");
		columnMapping.put("Parentage","parentage");
		columnMapping.put("Female Parent","femaleparent");
		columnMapping.put("Male Parent","maleparent");
		columnMapping.put("Selection History","Selection History");
		columnMapping.put("Source","source");
		
		HeaderColumnNameTranslateMappingStrategy<StudyGermplasm> strategy = new HeaderColumnNameTranslateMappingStrategy<StudyGermplasm>();
		strategy.setType(StudyGermplasm.class);
		strategy.setColumnMapping(columnMapping);

		CSVReader reader =  new CSVReader(new FileReader(file));

		return bean.parse(strategy, reader);
	}

	@Command
	@NotifyChange("*")
	public void updateCharacteristicInfo(
			@BindingParam("model") GermplasmDeepInfoModel model) {
		System.out.println("Called");
		model.characteristic = "";
		StringBuilder strVal = new StringBuilder();
		String tmpStr = "";
		for (CharacteristicModel charData : model.keyAbiotic) {
			if (charData.value) {
				if (strVal.length() == 0) {
					strVal.append("Abiotic: {");
				} else {
					strVal.append(" ,");
				}
				strVal.append(charData.name);
			}
		}
		if (strVal.length() > 0) {
			strVal.append("} \n");
			tmpStr = tmpStr + strVal.toString();
			strVal = new StringBuilder();
		}

		for (CharacteristicModel charData : model.keyBiotic) {
			if (charData.value) {
				if (strVal.length() == 0) {
					strVal.append("Biotic: {");
				} else {
					strVal.append(" ,");
				}
				strVal.append(charData.name);
			}
		}
		if (strVal.length() > 0) {
			strVal.append("} \n");
			tmpStr = tmpStr + strVal.toString();
			strVal = new StringBuilder();
		}

		for (CharacteristicModel charData : model.keyGrainQuality) {
			if (charData.value) {
				if (strVal.length() == 0) {
					strVal.append("Grain Quality: {");
				} else {
					strVal.append(" ,");
				}
				strVal.append(charData.name);
			}
		}
		if (strVal.length() > 0) {
			strVal.append("} \n");
			tmpStr = tmpStr + strVal.toString();
			strVal = new StringBuilder();
		}
		for (CharacteristicModel charData : model.keyMajorGenes) {
			if (charData.value) {
				if (strVal.length() == 0) {
					strVal.append("Major Genes: {");
				} else {
					strVal.append(" ,");
				}
				strVal.append(charData.name);
			}
		}
		if (strVal.length() > 0) {
			strVal.append("} \n");
			tmpStr = tmpStr + strVal.toString();
			strVal = new StringBuilder();
		}

		model.characteristic = tmpStr;

		// lstStudyGermplasm.get(model.primaryid).characteristic =
		// lstStudyGermplasm.get(model.primaryid).characteristic + model.name;

	}

	@Override
	public boolean validateTab() {
		if (!formValidator.isAllValidated()) {
			Messagebox.show("Required fields must not be empty", "OK",
					Messagebox.OK, Messagebox.EXCLAMATION);
			return false;
		}
		StudyGermplasmManagerImpl studyGermplasmMan = new StudyGermplasmManagerImpl();
		GermplasmManagerImpl germplasmManagerImpl = new GermplasmManagerImpl();
		List<StudyGermplasm> lstStudyGerm = new ArrayList<StudyGermplasm>();
		lstStudyGerm.addAll(lstStudyGermplasm.values());

		List<GermplasmCharacteristics> lstCharacteristics = new ArrayList<GermplasmCharacteristics>();
		for (GermplasmDeepInfoModel record : lstStudyGermplasm.values()) {
			for (CharacteristicModel model : record.keyAbiotic) {
				if (model.value) {
					GermplasmCharacteristics rec = new GermplasmCharacteristics();
					rec.setAttribute("Abiotic");
					rec.setGermplasmname(record.getGermplasmname());
					rec.setValue(model.name);
					lstCharacteristics.add(rec);
				}
			}
			for (CharacteristicModel model : record.keyBiotic) {
				if (model.value) {
					GermplasmCharacteristics rec = new GermplasmCharacteristics();
					rec.setAttribute("Biotic");
					rec.setGermplasmname(record.getGermplasmname());
					rec.setValue(model.name);
					lstCharacteristics.add(rec);
				}
			}
			for (CharacteristicModel model : record.keyGrainQuality) {
				if (model.value) {
					GermplasmCharacteristics rec = new GermplasmCharacteristics();
					rec.setAttribute("Grain Quality");
					rec.setGermplasmname(record.getGermplasmname());
					rec.setValue(model.name);
					lstCharacteristics.add(rec);
				}
			}
			for (CharacteristicModel model : record.keyMajorGenes) {
				if (model.value) {
					GermplasmCharacteristics rec = new GermplasmCharacteristics();
					rec.setAttribute("Major Genes");
					rec.setGermplasmname(record.getGermplasmname());
					rec.setValue(model.name);
					lstCharacteristics.add(rec);
				}
			}
			record.setStudyid((int) studyID);
		}
		studyGermplasmMan.addStudyGermplasm(lstStudyGerm, lstCharacteristics);
		germplasmManagerImpl.addGermplasm(germplasmManagerImpl
				.convertStudyToGermplasm(lstStudyGerm));

		return true;

	}

	// @Init
	// public void init() {
	// this.studyID = 1;
	// StudyGermplasmManagerImpl germplasmMan = new StudyGermplasmManagerImpl();
	// setLstStudyGermplasm(germplasmMan.getStudyGermplasmByStudyId(5));
	// }

	public class GermplasmDeepInfoModel extends StudyGermplasm {

		private List<CharacteristicModel> keyBiotic = new ArrayList<CharacteristicModel>();
		private List<CharacteristicModel> keyAbiotic = new ArrayList<CharacteristicModel>();
		private List<CharacteristicModel> keyGrainQuality = new ArrayList<CharacteristicModel>();
		private List<CharacteristicModel> keyMajorGenes = new ArrayList<CharacteristicModel>();
		private String characteristic;
		public int primarykey;
		public boolean isInGenotype = false;

		public void setValues(StudyGermplasm data){
			if(!StringUtils.isNullOrEmpty(data.getBreeder())) setBreeder(data.getBreeder());
			if(!StringUtils.isNullOrEmpty(data.getFemaleparent())) setFemaleparent(data.getFemaleparent());
			if(!StringUtils.isNullOrEmpty(data.getGermplasmname())) setGermplasmname(data.getGermplasmname());
			if(data.getGid() != null) setGid(data.getGid());
			if(!StringUtils.isNullOrEmpty(data.getIrcross())) setIrcross(data.getIrcross());
			if(!StringUtils.isNullOrEmpty(data.getIrnumber())) setIrnumber(data.getIrnumber());
			if(!StringUtils.isNullOrEmpty(data.getMaleparent())) setMaleparent(data.getMaleparent());
			if(!StringUtils.isNullOrEmpty(data.getOthername())) setOthername(data.getOthername());
			if(!StringUtils.isNullOrEmpty(data.getParentage())) setParentage(data.getParentage());
			if(!StringUtils.isNullOrEmpty(data.getRemarks())) setRemarks(data.getRemarks());
			if(!StringUtils.isNullOrEmpty(data.getSelectionhistory())) setSelectionhistory(data.getSelectionhistory());
			if(!StringUtils.isNullOrEmpty(data.getSource())) setSource(data.getSource());
		}
		public void setValues(Germplasm data){
			setBreeder(data.getBreeder());
			setFemaleparent(data.getFemaleparent());
			setGermplasmname(data.getGermplasmname());
			setGermplasmtypeid(data.getGermplasmtypeid());
			setGid(data.getGid());
			setId(data.getId());
			setIrcross(data.getIrcross());
			setIrnumber(data.getIrnumber());
			setMaleparent(data.getMaleparent());
			setOthername(data.getOthername());
			setParentage(data.getParentage());
			setRemarks(data.getRemarks());
			setSelectionhistory(data.getSelectionhistory());
			setSource(data.getSource());
		}
		
		public String getCharacteristic() {
			return characteristic;
		}

		public void setCharacteristic(String characteristic) {
			this.characteristic = characteristic;
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

		public GermplasmDeepInfoModel() {

			String key = getGermplasmname();
			List<CharacteristicModel> lstBioticKey = new ArrayList<CharacteristicModel>();
			for (KeyBiotic data : lstBiotics) {
				CharacteristicModel newData = new CharacteristicModel();
				newData.setName(data.getValue());
				newData.setValue(false);
				newData.primaryid = primarykey;
				lstBioticKey.add(newData);

			}
			List<CharacteristicModel> lstAbioticKey = new ArrayList<CharacteristicModel>();
			for (KeyAbiotic data : lstAbiotics) {
				CharacteristicModel newData = new CharacteristicModel();
				newData.primaryid = primarykey;
				newData.setName(data.getValue());
				newData.setValue(false);
				lstAbioticKey.add(newData);
			}
			List<CharacteristicModel> lstGrainQuality = new ArrayList<CharacteristicModel>();
			for (KeyGrainQuality data : lstGrainQualities) {
				CharacteristicModel newData = new CharacteristicModel();
				newData.primaryid = primarykey;
				newData.setName(data.getValue());

				newData.setValue(false);
				lstGrainQuality.add(newData);
			}
			List<CharacteristicModel> lstMajorGenes = new ArrayList<CharacteristicModel>();
			for (KeyMajorGenes data : lstAllMajorGenes) {
				CharacteristicModel newData = new CharacteristicModel();
				newData.primaryid = primarykey;
				newData.setName(data.getValue());

				newData.setValue(false);
				lstMajorGenes.add(newData);
			}
			setKeyAbiotic(lstAbioticKey);
			setKeyBiotic(lstBioticKey);
			setKeyGrainQuality(lstGrainQuality);
			setKeyMajorGenes(lstMajorGenes);

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
