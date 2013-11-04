package org.strasa.web.uploadstudy.view.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.web.uploadstudy.view.pojos.UploadCSVDataVariableModel;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class DataColumnValidation {
	public static String ZUL_PATH = "/user/uploadstudy/datacolumnvalidation.zul";

	private String CsvPath;

	private Component mainView;

	private Binder parBinder;

	public List<UploadCSVDataVariableModel> varData = new ArrayList<UploadCSVDataVariableModel>();

	private boolean isHeaderClear = true;
	public boolean showAll;
	public boolean isShowAll(){
		return !showAll;
	}
	@Init
	public void Init(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,
			@ContextParam(ContextType.VIEW) Component view,
			@ExecutionArgParam("CSVPath") String CSVPath,
			@ExecutionArgParam("showAll") boolean showAll) {
		mainView = view;
		parBinder = (Binder) view.getParent().getAttribute("binder");
		CsvPath = CSVPath;
		this.showAll = showAll;
		ArrayList<String> invalidHeader = new ArrayList<String>();

		try {
			StudyVariableManagerImpl studyVarMan = new StudyVariableManagerImpl();
			CSVReader reader = new CSVReader(new FileReader(CsvPath));
			String[] header = reader.readNext();
			for (String column : header) {

				invalidHeader.add(column);

			}
			System.out.println(invalidHeader.size());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		populateVarData(invalidHeader);
	}

	public void close() {
		Map<String, Object> params = new HashMap<String, Object>();
		// params.put("refreshCsv",null);

		// this.parBinder.postCommand("change", params);
		parBinder.postCommand("refreshCsv", null);
		mainView.detach();
	}

	@Command("saveHeader")
	public void saveHeader() {

		String[] newHeader = new String[varData.size()];
		for (int i = 0; i < varData.size(); i++) {
			if (varData.get(i).getNewVariable().equals("-")) {
				Messagebox.show("Error: Headers must be matched accordingly.",
						"Save Error", Messagebox.OK, Messagebox.ERROR);
				return;
			}
			newHeader[i] = varData.get(i).getNewVariable();
		}
		FileWriter mFileWriter;
		try {
			CSVReader reader = new CSVReader(new FileReader(CsvPath));
			List<String[]> currDataSet = reader.readAll();
			currDataSet.set(0, newHeader);
			mFileWriter = new FileWriter(CsvPath);
			CSVWriter mCsvWriter = new CSVWriter(mFileWriter);
			mCsvWriter.writeAll(currDataSet);
			mCsvWriter.flush();
			mCsvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Messagebox.show("CSV Data successfully updated!", "Save",
				Messagebox.OK, Messagebox.INFORMATION);
		System.out.println("SavePath: " + CsvPath);

		Binder bind = parBinder;
		if (bind == null)
			return;

		Map<String, Object> params = new HashMap<String, Object>();
		// params.put("refreshCsv",null);

		// this.parBinder.postCommand("change", params);
		bind.postCommand("refreshCsv", null);
		try {
			mainView.detach();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@NotifyChange("*")
	@Command("refreshVarList")
	public void refreshList(@BindingParam("newValue") String newValue,
			@BindingParam("oldVar") String oldVar) {
		for (int i = 0; i < varData.size(); i++) {

			if (varData.get(i).getCurrentVariable().equals(oldVar)) {
				System.out.println("   ss");
				varData.get(i).setNewVariable(newValue);
			}

		}

	}

	@Command("changeVar")
	@NotifyChange("variableData")
	public void changeVar(
			@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,
			@ContextParam(ContextType.VIEW) Component view,
			@BindingParam("oldVar") String oldVar) {

		Map<String, Object> params = new HashMap<String, Object>();
		System.out.println(oldVar);
		params.put("oldVar", oldVar);
		params.put("parent", view);

		Window popup = (Window) Executions.createComponents(
				DataColumnChanged.ZUL_PATH, view, params);

		popup.doModal();
	}

	@NotifyChange("varData")
	public void populateVarData(ArrayList<String> list) {
		StudyVariableManagerImpl studyVarMan = new StudyVariableManagerImpl();

		for (String var : list) {
			if (showAll) {
				varData.add(new UploadCSVDataVariableModel(var, var, true));
				isHeaderClear = false;
			} else {
				if (!studyVarMan.hasVariable(var)) {
					varData.add(new UploadCSVDataVariableModel(var, "-", true));
					isHeaderClear = false;
				} else {
					varData.add(new UploadCSVDataVariableModel(var, var));
					
				}
			}
		}

	}

	public List<UploadCSVDataVariableModel> getVarData() {
		return varData;
	}
}
