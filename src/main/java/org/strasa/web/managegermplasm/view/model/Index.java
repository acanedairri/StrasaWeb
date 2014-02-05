package org.strasa.web.managegermplasm.view.model;

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
import org.spring.security.model.SecurityUtil;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.manager.GermplasmCharacteristicMananagerImpl;
import org.strasa.middleware.manager.GermplasmManagerImpl;
import org.strasa.middleware.manager.GermplasmTypeManagerImpl;
import org.strasa.middleware.manager.KeyCharacteristicManagerImpl;
import org.strasa.middleware.manager.StudyGermplasmManagerImpl;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.strasa.web.common.api.Encryptions;
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
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import com.mysql.jdbc.StringUtils;

public class Index {

	@WireVariable
	ConnectionFactory connectionFactory;

	@Wire("#tblKnownGerm")
	Listbox tblKnownGerm;

	@Wire("#tblStudyGerm")
	Listbox tblStudyGerm;

	@Wire("#gbUnknownGermplasm")
	Groupbox gbUnknownGermplasm;
	@Wire("#gbKnownGermplasm")
	Groupbox gbKnownGermplasm;
	@Wire("#divUploadOption")
	Div divUploadOption;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);

		// wire event listener
		// Selectors.wireEventListeners(view, this);
		gbUnknownGermplasm.setVisible(false);
		divUploadOption.setVisible(false);
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

	private Integer userID = SecurityUtil.getDbUser().getId();

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
		// System.out.println("ID:" + id);
		for (GermplasmType gtype : lstGermplasmType) {
			if (gtype.getId() == id)
				return gtype;
		}
		return null;
	}

	public void printArrList() {
		// System.out.println("_____________________________________________________________");

		for (GermplasmDeepInfoModel data : arrGermplasmDeepInfo) {
			// System.out.println(data.toString());
		}

		// System.out.println("_____________________________________________________________");

	}

	public String getTotalUnknownGermplasm() {
		return "List of total unknown germplasm (total: " + lstStudyGermplasm.size() + ")";
	}

	public String getTotalKnownGermplasm() {
		return "List of total of uploaded germplasm (total: " + lstKnownGermplasm.size() + ")";
	}

	@Command
	public void selectGermplasm(@BindingParam("germplasm") GermplasmDeepInfoModel data) {

		if (data.getGermplasmname().equals(selectedGermplasm.getGermplasmname())) {
			return;
		}

		// selectedGermplasm.setStyleBG("background-color: #FFF");
		// data.setStyleBG("background-color: #BEC7F7 ");
		selectedGermplasm = data;
		BindUtils.postNotifyChange(null, null, "*", "selectedGermplasm");
		if (lstStudyGermplasm.containsKey(data.getGermplasmname())) {

			tblStudyGerm.getItemAtIndex(data.rowIndex).setSelected(true);
			;
		} else {

			tblStudyGerm.getItemAtIndex(data.rowIndex).setSelected(true);

		}
	}

	@Command
	public void saveGermplasm(@BindingParam("germplasm") GermplasmDeepInfoModel data) {

		if (validateGermplasm(data)) {

			new GermplasmManagerImpl().modifyGermplasm(data);

			cancelEdit(data);
		}

	}

	@Command
	public void cancelEdit(@BindingParam("germplasm") GermplasmDeepInfoModel data) {

		lstKnownGermplasm.get(data.getGermplasmname()).setKnown(true);
		selectedGermplasm = lstKnownGermplasm.get(data.getGermplasmname());

		BindUtils.postNotifyChange(null, null, data, "known");
		BindUtils.postNotifyChange(null, null, selectedGermplasm, "*");

	}

	@Init
	public void init() {

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

		List<KeyBiotic> lstKeyBiotics = keyMan.getAllBiotic();
		List<KeyAbiotic> lstKeyAbioitc = keyMan.getAllAbiotic();
		List<KeyMajorGenes> lstKeyMajorGenes = keyMan.getAllMajorGenes();
		List<KeyGrainQuality> lstKeyGrainQuality = keyMan.getAllGrainQuality();

		GermplasmManagerImpl germplasmMan = new GermplasmManagerImpl();
		List<Germplasm> germplasmList = germplasmMan.getGermplasmListByUserID(this.userID);
		for (Germplasm subGermData : germplasmList) {
			GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel(subGermData);
			newData.setBiotic(lstKeyBiotics);
			newData.setAbiotic(lstKeyAbioitc);
			newData.setMajorGenes(lstKeyMajorGenes);

			newData.setGrainQuality(lstKeyGrainQuality);
			newData.setCharacteristicValues(germCharMan.getGermplasmByGermplasmName(subGermData.getGermplasmname()));
			newData.setSelectedGermplasmType(getGermplasmTypeById(newData.getGermplasmtypeid()));
			newData.setKnown(true);
			newData.setRowIndex(lstKnownGermplasm.size());

			lstKnownGermplasm.put(newData.getGermplasmname(), newData);
			if (selectedGermplasm == null)
				selectedGermplasm = newData;

		}

		selectedGermplasm.setStyleBG("background-color: #BEC7F7 ");

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

	@NotifyChange({ "lstStudyGermplasm", "lstKnownGermplasm", "totalUnknownGermplasm" })
	@Command("uploadGenotypeData")
	public void uploadGenotypeData(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx, @ContextParam(ContextType.VIEW) Component view) {

		UploadEvent event = (UploadEvent) ctx.getTriggerEvent();

		// //System.out.println(event.getMedia().getStringData());

		String name = event.getMedia().getName();
		if (!name.endsWith(".csv")) {
			Messagebox.show("Error: File must be a text-based CSV  format", "Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}
		((Label) view.getFellow("lblFileName")).setValue(name);
		try {
			String filename = name + Encryptions.encryptStringToNumber(name, new Date().getTime());
			File tempGenoFile = File.createTempFile(filename, ".tmp");
			InputStream in = event.getMedia().isBinary() ? event.getMedia().getStreamData() : new ReaderInputStream(event.getMedia().getReaderData());
			FileUtilities.uploadFile(tempGenoFile.getAbsolutePath(), in);
			List<GermplasmExt> lstGermplasm = CSVToBean(tempGenoFile);

			KeyCharacteristicManagerImpl keyMan = new KeyCharacteristicManagerImpl();
			List<KeyBiotic> lstKeyBiotics = keyMan.getAllBiotic();
			List<KeyAbiotic> lstKeyAbioitc = keyMan.getAllAbiotic();
			List<KeyMajorGenes> lstKeyMajorGenes = keyMan.getAllMajorGenes();
			List<KeyGrainQuality> lstKeyGrainQuality = keyMan.getAllGrainQuality();
			for (GermplasmExt germData : lstGermplasm) {
				if (!StringUtils.isNullOrEmpty(germData.getGermplasmname())) {

					if (lstKnownGermplasm.containsKey(germData.getGermplasmname())) {

						lstStudyGermplasm.put(germData.getGermplasmname(), lstKnownGermplasm.get(germData.getGermplasmname()));
					} else {

						GermplasmDeepInfoModel newData = new GermplasmDeepInfoModel();

						newData.setGermplasmtypeid(getGermplasmTypeById(germData.getGermplasmtype()));
						newData.setGermplasmname(germData.getGermplasmname());
						newData.setValueFromeGermplasmEx(germData, lstGermplasmType);
						newData.setBiotic(lstKeyBiotics);
						newData.setAbiotic(lstKeyAbioitc);
						newData.setMajorGenes(lstKeyMajorGenes);
						newData.setUserid(this.userID);
						newData.setGrainQuality(lstKeyGrainQuality);
						lstStudyGermplasm.put(newData.getGermplasmname(), newData);
					}
				}
			}

			gbUnknownGermplasm.setVisible(true);
			gbKnownGermplasm.setVisible(false);
			view.getFellow("divUploadOption").setVisible(true);
			// gbKnownGermplasm.invalidate();
			// gbUnknownGermplasm.invalidate();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}

	}

	@NotifyChange({ "lstStudyGermplasm" })
	@Command
	public void resetUnknownGermplasm() {
		lstStudyGermplasm.clear();
		gbUnknownGermplasm.setVisible(false);
		gbKnownGermplasm.setVisible(true);
		divUploadOption.setVisible(false);
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

		// System.out.println(file.getAbsolutePath());
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

			if (!validateGermplasm(data))
				return false;

		}
		return true;

	}

	public boolean validateGermplasm(GermplasmDeepInfoModel data) {
		String validate = data.validate();
		if (!data.getStyleBG().equals("background-color: #FFF")) {
			data.setStyleBG("background-color: #FFF");
			BindUtils.postNotifyChange(null, null, data, "styleBG");
		}
		if (validate != null) {
			Messagebox.show(validate, "OK", Messagebox.OK, Messagebox.EXCLAMATION);
			selectGermplasm(data);
			return false;
		}
		return true;
	}

	public boolean validateStudyGermplasm() {
		int studyGerm = 0;
		for (GermplasmDeepInfoModel data : lstStudyGermplasm.values()) {

			if (!validateGermplasm(data)) {
				selectGermplasm(data);
				return false;
			}

		}
		return true;

	}

	@Command
	public void updateCharacteristicInfo(@BindingParam("model") GermplasmDeepInfoModel model) {
		BindUtils.postNotifyChange(null, null, this.getLstStudyGermplasm().get(model.getRowIndex()), "*");
		this.tblStudyGerm.invalidate();
	}

	@NotifyChange("selectedGermplasm")
	@Command
	public void modifyGermplasm(@BindingParam("gname") String gname) {
		// System.out.println("GNAME: " + gname);
		// System.out.println("SIZE: " + lstKnownGermplasm.size());

		lstKnownGermplasm.get(gname).setKnown(false);
		selectedGermplasm = lstKnownGermplasm.get(gname);

		BindUtils.postNotifyChange(null, null, lstKnownGermplasm.get(gname), "known");

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

	public void selectRow(GermplasmDeepInfoModel model) {
		if (model.isKnown())
			tblKnownGerm.setSelectedIndex(model.rowIndex);
		else
			tblStudyGerm.setSelectedIndex(model.rowIndex);
	}

	@Command
	public void saveData() {

		// Validation
		if (!validateStudyGermplasm()) {
			return;
		}

		StudyGermplasmManagerImpl studyGermplasmMan = new StudyGermplasmManagerImpl();
		GermplasmManagerImpl germplasmManagerImpl = new GermplasmManagerImpl();
		// List<StudyGermplasm> lstStudyGerm =
		// convertDeepInfoToModel(lstStudyGermplasm.values());
		GermplasmCharacteristicMananagerImpl germCharMan = new GermplasmCharacteristicMananagerImpl();
		List<GermplasmDeepInfoModel> lstStudyGermpl = new ArrayList<GermplasmDeepInfoModel>();
		lstStudyGermpl.addAll(lstStudyGermplasm.values());
		germplasmManagerImpl.addGermplasmListNoRepeat(lstStudyGermplasm.values(), this.userID);

		germCharMan.addCharacteristicBatch(lstStudyGermplasm.values());

		resetUnknownGermplasm();
		init();
		BindUtils.postNotifyChange(null, null, this, "*");
		Messagebox.show("Germplasms has been added to the database!", "Information", Messagebox.OK, Messagebox.INFORMATION);

	}

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
			// System.out.println("DURATION : " + (endTime - startTime) /
			// 1000000000.0);
			return (endTime - startTime) / 1000000000.0;
		}

	}

}
