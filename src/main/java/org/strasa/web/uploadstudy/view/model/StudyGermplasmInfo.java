package org.strasa.web.uploadstudy.view.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.input.ReaderInputStream;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.manager.GermplasmCharacteristicMananagerImpl;
import org.strasa.middleware.manager.GermplasmManagerImpl;
import org.strasa.middleware.manager.GermplasmTypeManagerImpl;
import org.strasa.middleware.manager.KeyCharacteristicManagerImpl;
import org.strasa.middleware.manager.StudyGermplasmManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.strasa.web.common.api.Encryptions;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.strasa.web.managegermplasm.view.pojos.GermplasmComparator;
import org.strasa.web.managegermplasm.view.pojos.GermplasmGroupingModel;
import org.strasa.web.uploadstudy.view.pojos.GermplasmDeepInfoModel;
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
import org.zkoss.zul.Grid;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Row;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
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

	private GermplasmDeepInfoModel selectedGermplasm;

	public GermplasmDeepInfoModel getSelectedGermplasm() {

		return selectedGermplasm;
	}

	public void setSelectedGermplasm(GermplasmDeepInfoModel selectedGermplasm) {
		this.selectedGermplasm = selectedGermplasm;
	}

	public ArrayList<GermplasmDeepInfoModel> arrGermplasmDeepInfo = new ArrayList<GermplasmDeepInfoModel>();

	private List<GermplasmType> lstGermplasmType = new ArrayList<GermplasmType>();
	private HashMap<String, GermplasmDeepInfoModel> lstKnownGermplasm = new HashMap<String, GermplasmDeepInfoModel>();

	private boolean showGroup = true;

	public GermplasmGroupingModel getGermplasmModel() {

		ArrayList<GermplasmDeepInfoModel> allData = new ArrayList<GermplasmDeepInfoModel>();
		allData.addAll(lstKnownGermplasm.values());
		allData.addAll(lstStudyGermplasm.values());

		return new GermplasmGroupingModel(allData, new GermplasmComparator(), this.showGroup);
	}

	public List<GermplasmDeepInfoModel> getLstKnownGermplasm() {

		return new ArrayList<GermplasmDeepInfoModel>(lstKnownGermplasm.values());
	}

	public void setLstKnownGermplasm(HashMap<String, GermplasmDeepInfoModel> lstKnownGermplasm) {
		this.lstKnownGermplasm = lstKnownGermplasm;
	}

	private List<KeyBiotic> lstBiotics;

	private List<KeyAbiotic> lstAbiotics;

	private List<KeyGrainQuality> lstGrainQualities;

	private List<KeyMajorGenes> lstAllMajorGenes;

	public List<GermplasmType> getLstGermplasmType() {
		return lstGermplasmType;
	}

	public void setLstGermplasmType(List<GermplasmType> lstGermplasmType) {
		this.lstGermplasmType = lstGermplasmType;
	}

	public ArrayList<GermplasmDeepInfoModel> getLstStudyGermplasm() {
		return new ArrayList<GermplasmDeepInfoModel>(lstStudyGermplasm.values());
	}

	public void setLstStudyGermplasm(HashMap<String, GermplasmDeepInfoModel> lstStudyGermplasm) {
		this.lstStudyGermplasm = lstStudyGermplasm;
	}

	@Command
	public List<GermplasmDeepInfoModel> getGermplasmByName(@BindingParam("Gname") String gname) {

		List<GermplasmDeepInfoModel> returnVal = new ArrayList<GermplasmDeepInfoModel>();
		for (GermplasmDeepInfoModel data : arrGermplasmDeepInfo) {
			if (data.getGermplasmname().equals(gname)) {
				returnVal.add(data);

			}
		}
		return returnVal;

	}

	public GermplasmType getGermplasmTypeById(Integer id) {
		System.out.println("ID:" + id);
		for (GermplasmType gtype : lstGermplasmType) {
			if (gtype.getId() == id)
				return gtype;
		}
		return null;
	}

	public void printArrList() {
		System.out.println("_____________________________________________________________");

		for (GermplasmDeepInfoModel data : arrGermplasmDeepInfo) {
			System.out.println(data.toString());
		}

		System.out.println("_____________________________________________________________");

	}

	@Command
	@NotifyChange("selectedGermplasm")
	public void selectGermplasm(@BindingParam("germplasm") GermplasmDeepInfoModel data) {

		String oldGerm = selectedGermplasm.getGermplasmname();
		if (selectedGermplasm.isKnown()) {
			lstKnownGermplasm.get(oldGerm).setStyleBG("background-color: #FFF");
			BindUtils.postNotifyChange(null, null, lstKnownGermplasm.get(oldGerm), "styleBG");
		} else {

			lstStudyGermplasm.get(oldGerm).setStyleBG("background-color: #FFF");
			BindUtils.postNotifyChange(null, null, lstStudyGermplasm.get(oldGerm), "styleBG");
		}
		if (data.isKnown()) {
			lstKnownGermplasm.get(data.getGermplasmname()).setStyleBG("background-color: #BEC7F7 ");
			BindUtils.postNotifyChange(null, null, lstKnownGermplasm.get(data.getGermplasmname()), "styleBG");
			System.out.println("COLOR CHANGED");
		} else {

			lstStudyGermplasm.get(data.getGermplasmname()).setStyleBG("background-color: #BEC7F7 ");
			BindUtils.postNotifyChange(null, null, lstStudyGermplasm.get(data.getGermplasmname()), "styleBG");
			System.out.println("COLOR CHANGED");
		}

		selectedGermplasm = data;

	}

	@Init
	public void init(@ExecutionArgParam("uploadModel") ProcessTabViewModel uploadModel) {

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
		GermplasmCharacteristicMananagerImpl germCharMan = new GermplasmCharacteristicMananagerImpl();
		StudyRawDataManagerImpl rawMan = new StudyRawDataManagerImpl(isRaw);
		List<Germplasm> lst = rawMan.getStudyGermplasmInfo(studyID, dataset.getId());

		List<KeyBiotic> lstKeyBiotics = keyMan.getAllBiotic();
		List<KeyAbiotic> lstKeyAbioitc = keyMan.getAllAbiotic();
		List<KeyMajorGenes> lstKeyMajorGenes = keyMan.getAllMajorGenes();
		List<KeyGrainQuality> lstKeyGrainQuality = keyMan.getAllGrainQuality();

		StudyGermplasmManagerImpl studyGermMan = new StudyGermplasmManagerImpl();

		GermplasmManagerImpl germplasmMan = new GermplasmManagerImpl();
		for (Germplasm germData : lst) {

			if (germplasmMan.isGermplasmExisting(germData.getGermplasmname())) {

				List<Germplasm> germplasmList = germplasmMan.getGermplasmListByName(germData.getGermplasmname());
				for (Germplasm subGermData : germplasmList) {
					GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel(subGermData);
					newData.setBiotic(lstKeyBiotics);
					newData.setAbiotic(lstKeyAbioitc);
					newData.setMajorGenes(lstKeyMajorGenes);

					newData.setGrainQuality(lstKeyGrainQuality);
					newData.setCharacteristicValues(germCharMan.getGermplasmByGermplasmName(germData.getGermplasmname()));
					newData.setSelectedGermplasmType(getGermplasmTypeById(newData.getGermplasmtypeid()));
					newData.setKnown(true);
					newData.setRowIndex(lstKnownGermplasm.size());

					// IF Record does not exist, add
					if (!lstKnownGermplasm.containsKey(newData.getGermplasmname())) {
						lstKnownGermplasm.put(newData.getGermplasmname(), newData);

					}
					// IF Record is equal to the UserID
					if (newData.getUserid() == this.getUserID()) {

						// If record does not exist, add
						if (!lstKnownGermplasm.containsKey(newData.getGermplasmname())) {
							lstKnownGermplasm.put(newData.getGermplasmname(), newData);
						} else {
							// IF Record exist and if the previous record does
							// not exist in the studygermplasm table
							if (!lstKnownGermplasm.get(newData.getGermplasmname()).recordExist) {
								lstKnownGermplasm.put(newData.getGermplasmname(), newData);
							}
						}

					}
					// IF Record exist in the studgermplasm table
					if (studyGermMan.isGermplasmRecordExist(subGermData.getId(), this.studyID, this.dataset.getId())) {
						newData.recordExist = true;
						lstKnownGermplasm.put(newData.getGermplasmname(), newData);
					}

					arrGermplasmDeepInfo.add(newData);
				}
			} else {
				GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel(germData);
				newData.setUserid(this.userID);
				newData.setBiotic(lstKeyBiotics);
				newData.setAbiotic(lstKeyAbioitc);
				newData.setMajorGenes(lstKeyMajorGenes);
				newData.setGrainQuality(lstKeyGrainQuality);
				newData.setKnown(false);
				newData.setRowIndex(lstStudyGermplasm.size());

				lstStudyGermplasm.put(newData.getGermplasmname(), newData);

			}

		}

		ArrayList<GermplasmDeepInfoModel> allData = new ArrayList<GermplasmDeepInfoModel>();
		allData.addAll(lstKnownGermplasm.values());
		allData.addAll(lstStudyGermplasm.values());

		selectedGermplasm = allData.get(0);
		timer.end();
	}

	public GermplasmDeepInfoModel getGermplasmDeepInfoModelById(Integer id) {

		for (GermplasmDeepInfoModel model : arrGermplasmDeepInfo) {
			if (model.getId() == id)
				return model;
		}
		return null;
	}

	@NotifyChange("lstKnownGermplasm")
	@Command
	public void changeGermplasmInfo(@BindingParam("index") GermplasmDeepInfoModel selected) {

		lstKnownGermplasm.put(selected.getGermplasmname(), selected);
		// printArrList();
		tblKnownGerm.invalidate();

	}

	@NotifyChange({ "lstStudyGermplasm", "lstKnownGermplasm" })
	@Command("uploadGenotypeData")
	public void uploadGenotypeData(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx, @ContextParam(ContextType.VIEW) Component view) {

		UploadEvent event = (UploadEvent) ctx.getTriggerEvent();

		// System.out.println(event.getMedia().getStringData());

		String name = event.getMedia().getName();
		if (!name.endsWith(".csv")) {
			Messagebox.show("Error: File must be a text-based CSV  format", "Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}

		try {
			String filename = name + Encryptions.encryptStringToNumber(name, new Date().getTime());
			File tempGenoFile = File.createTempFile(filename, ".tmp");
			InputStream in = event.getMedia().isBinary() ? event.getMedia().getStreamData() : new ReaderInputStream(event.getMedia().getReaderData());
			FileUtilities.uploadFile(tempGenoFile.getAbsolutePath(), in);
			List<GermplasmExt> lstGermplasm = CSVToBean(tempGenoFile);
			for (GermplasmExt germData : lstGermplasm) {
				if (!StringUtils.isNullOrEmpty(germData.getGermplasmname())) {
					if (lstStudyGermplasm.containsKey(germData.getGermplasmname())) {
						lstStudyGermplasm.get(germData.getGermplasmname()).setGermplasmtypeid(getGermplasmTypeById(germData.getGermplasmtype()));
						lstStudyGermplasm.get(germData.getGermplasmname()).setValueFromeGermplasmEx(germData);
					}
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public Integer getGermplasmTypeById(String key) {
		for (GermplasmType gtype : lstGermplasmType) {
			if (gtype.getGermplasmtype().equals(key))
				return gtype.getId();
		}
		return null;
	}

	public List<GermplasmExt> CSVToBean(File file) throws IOException {
		CsvToBean<GermplasmExt> bean = new CsvToBean<GermplasmExt>();

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("GID", "gid");
		columnMapping.put("GNAME", "germplasmname");
		columnMapping.put("OTHERNAME", "othername");
		columnMapping.put("BREEDER", "breeder");
		columnMapping.put("IR NUMBER", "irnumber");
		columnMapping.put("IR CROSS", "ircross");
		columnMapping.put("GERMPLASMTYPE", "germplasmtype");
		columnMapping.put("PARENTAGE", "parentage");
		columnMapping.put("FEMALE PARENT", "femaleparent");
		columnMapping.put("MALE PARENT", "maleparent");
		columnMapping.put("SELECTION HISTORY", "selectionhistory");
		columnMapping.put("SOURCE", "source");

		System.out.println(file.getAbsolutePath());
		HeaderColumnNameTranslateMappingStrategy<GermplasmExt> strategy = new HeaderColumnNameTranslateMappingStrategy<GermplasmExt>();
		strategy.setType(GermplasmExt.class);
		strategy.setColumnMapping(columnMapping);

		CSVReader reader = new CSVReader(new FileReader(file));

		List<String[]> lstWriter = reader.readAll();
		String[] header = lstWriter.get(0);
		for (int i = 0; i < header.length; i++) {
			header[i] = header[i].toUpperCase();
		}
		lstWriter.set(0, header);
		CSVWriter writer = new CSVWriter(new FileWriter(file.getAbsolutePath()));

		writer.writeAll(lstWriter);
		writer.close();
		reader = new CSVReader(new FileReader(file));

		return bean.parse(strategy, reader);
	}

	public boolean validateKnownGermplasm() {
		int studyGerm = 0;
		for (GermplasmDeepInfoModel data : lstKnownGermplasm.values()) {
			String validate = data.validate(false);
			((Row) tblKnownGerm.getRows().getChildren().get(studyGerm)).setStyle("background-color: #FFF");
			if (validate != null) {
				Messagebox.show(validate, "OK", Messagebox.OK, Messagebox.EXCLAMATION);

				((Row) tblKnownGerm.getRows().getChildren().get(studyGerm)).setStyle("background-color: #ff6666");
				((Row) tblKnownGerm.getRows().getChildren().get(studyGerm)).setFocus(true);
				return false;
			}
			studyGerm++;

		}
		return true;

	}

	public boolean validateStudyGermplasm() {
		int studyGerm = 0;
		for (GermplasmDeepInfoModel data : lstStudyGermplasm.values()) {
			((Row) tblStudyGerm.getRows().getChildren().get(studyGerm)).setStyle("background-color: #FFF");
			String validate = data.validate(true);
			if (validate != null) {
				Messagebox.show(validate, "OK", Messagebox.OK, Messagebox.EXCLAMATION);

				((Row) tblStudyGerm.getRows().getChildren().get(studyGerm)).setStyle("background-color: #ff6666");
				((Row) tblStudyGerm.getRows().getChildren().get(studyGerm)).setFocus(true);
				return false;
			}
			studyGerm++;

		}
		return true;

	}

	@Command
	public void updateCharacteristicInfo(@BindingParam("model") GermplasmDeepInfoModel model) {
		BindUtils.postNotifyChange(null, null, this.getLstStudyGermplasm().get(model.getRowIndex()), "*");
		this.tblStudyGerm.invalidate();
	}

	@NotifyChange({ "lstKnownGermplasm", "lstStudyGermplasm" })
	@Command
	public void modifyGermplasm(@BindingParam("gname") String gname) {
		System.out.println("GNAME: " + gname);
		System.out.println("SIZE: " + lstKnownGermplasm.size());

		lstKnownGermplasm.get(gname).rowIndex = lstStudyGermplasm.size();
		lstKnownGermplasm.get(gname).setKnown(false);
		lstStudyGermplasm.put(gname, lstKnownGermplasm.get(gname));
		lstKnownGermplasm.remove(gname);

		for (GermplasmType gType : lstGermplasmType) {
			if (gType.getId() == lstStudyGermplasm.get(gname).getGermplasmtypeid()) {
				lstStudyGermplasm.get(gname).setSelectedGermplasmType(gType);
			}
		}

		if (this.getUserID() != lstStudyGermplasm.get(gname).getUserid()) {
			System.out.println("New User!");
			lstStudyGermplasm.get(gname).setUserid(this.userID);
			lstStudyGermplasm.get(gname).setId(null);

		}
		selectGermplasm(lstStudyGermplasm.get(gname));
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
		germplasmManagerImpl.addGermplasmList(lstStudyGermplasm.values());

		studyGermplasmMan.addStudyGermplasmBatch(lstStudyGermpl, this.studyID, this.dataset.getId());
		germCharMan.addCharacteristicBatch(lstStudyGermplasm.values());

		return true;

	}

	// @Init
	// public void init() {
	// this.studyID = 1;
	// StudyGermplasmManagerImpl germplasmMan = new StudyGermplasmManagerImpl();
	// setLstStudyGermplasm(germplasmMan.getStudyGermplasmByStudyId(5));
	// }

	public String getGermplasmType(int id) {

		for (GermplasmType type : lstGermplasmType) {
			if (type.getId() == id)
				return type.getGermplasmtype();
		}
		return "";

	}

	public class Runtimer {
		long startTime = System.nanoTime();

		public long start() {
			startTime = System.nanoTime();
			return startTime;
		}

		public double end() {
			long endTime = System.nanoTime();
			System.out.println("DURATION : " + (endTime - startTime) / 1000000000.0);
			return (endTime - startTime) / 1000000000.0;
		}

	}

}
