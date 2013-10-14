package org.strasa.web.view.model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.web.pojos.VariableModel;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class UploadDataModel {


	
	public String dataFileName;
	public boolean isVariableDataVisible = false;
	 
    public String getDataFileName() {
		return dataFileName;
	}
    

	public List<VariableModel> varData = new ArrayList<VariableModel>();
	private String path;
     
    public boolean isVariableDataVisible() {
		return isVariableDataVisible;
	}

	public void setVariableDataVisible(boolean isVariableDataVisible) {
		this.isVariableDataVisible = isVariableDataVisible;
	}

	public List<VariableModel>  getVarData() {
        return varData;
    }
 
	    @Command
	    @NotifyChange("variableData")
	    public void changeVar(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view ,@BindingParam("oldVar") String oldVar) {

			Map<String, Object> params = new HashMap<String, Object>();
		     System.out.println(oldVar);
			params.put("oldVar",oldVar);
			params.put("parent", view);

			Window popup = (Window) Executions.createComponents("modal/selectvariabledata.zul", view, params);

			popup.doModal();
	    }

	
	    @NotifyChange("*")
		@Command("refreshVarList")
	    public void refreshList(@BindingParam("newValue") String newValue, @BindingParam("oldVar") String oldVar){
	    	for(int i = 0; i < varData.size(); i++){
	    		
	    		if(varData.get(i).getCurrentVariable().equals(oldVar)) {
	    			System.out.println("   ss");
	    			varData.get(i).setNewVariable(newValue);
	    		}
	    		
	    	}
	    	
	    	
	    }
	
	 @NotifyChange("*")
	@Command("uploadCSV")
	public void uploadCSV(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view) {

		UploadEvent event = (UploadEvent)ctx.getTriggerEvent();
		if(event.getMedia().isBinary()){
			Messagebox.show("Error: File must be a text-based csv format", "Upload Error", Messagebox.OK, Messagebox.ERROR);
			return;
		}

		//		System.out.println(event.getMedia().getStringData());


		String name = event.getMedia().getName();

		 path = Sessions.getCurrent().getWebApp().getRealPath("/UPLOADS/") + "/";                


		this.uploadFile(path, name,  event.getMedia().getStringData());       
		BindUtils.postNotifyChange(null, null, this, "*");

		ArrayList<String> invalidHeader = new ArrayList<String>();
		
		try {
			StudyVariableManagerImpl studyVarMan = new StudyVariableManagerImpl();
			CSVReader reader = new CSVReader(new FileReader(path+name));
			String[] header = reader.readNext();
			for(String column : header){
				if(!studyVarMan.hasVariable(column)){
					invalidHeader.add(column);
				}
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
		isVariableDataVisible = true;
		dataFileName = name ;

	}
	 

	 @NotifyChange("varData")
	 public void populateVarData(ArrayList<String> list){
		 for(String var : list){
			 varData.add(new VariableModel(var,"-"));
		 }
	 }
	 
	 @NotifyChange("*")
	 @Command("removeUpload")
	 public void removeUpload(){
		 isVariableDataVisible = false;
		 dataFileName = "";
		 varData.clear();
	 }
	public void uploadFile(String path, String name, 
			String data) {

		String filePath = path + name ;

		try {
			PrintWriter out = new PrintWriter(filePath);
			out.println(data);
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command("saveHeader")
	public void saveHeader(){
		
		String[] newHeader = new String[varData.size()];
		for(int i = 0; i < varData.size(); i++)
			{
				if(varData.get(i).getNewVariable().equals("-")){
					Messagebox.show("Error: Headers must be matched accordingly.", "Save Error", Messagebox.OK, Messagebox.ERROR);
					return;
				}
				newHeader[i] = varData.get(i).getNewVariable();
			}
		FileWriter mFileWriter;
		try {
			CSVReader reader = new CSVReader(new FileReader(path+dataFileName));
			List<String[]> currDataSet = reader.readAll();
			currDataSet.set(0,  newHeader) ;
			mFileWriter = new FileWriter(path+dataFileName);
			CSVWriter mCsvWriter = new CSVWriter(mFileWriter);
			mCsvWriter.writeAll(currDataSet);
			mCsvWriter.flush();
			mCsvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		Messagebox.show("CSV Data successfully updated!", "Save", Messagebox.OK, Messagebox.INFORMATION);
		System.out.println("SavePath: "+path+dataFileName);
	}
	

	@Command("change")
	public void change(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view,@BindingParam("newValue") String newValue,@BindingParam("oldVar") String oldVar) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("value",newValue);
		params.put("oldVar",oldVar);
		params.put("parent", view);

		Window popup = (Window) Executions.createComponents("modal/selectvariabledata.zul", view, params);

		popup.doModal();

	}

}
