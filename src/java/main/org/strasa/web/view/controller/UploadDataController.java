package org.strasa.web.view.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import au.com.bytecode.opencsv.CSVReader;

public class UploadDataController extends SelectorComposer<Window> {
	

	@Wire("#lblMsgUpload")
	private Label lblUploadMessage;
	
	

	@Listen("onUpload = #uploadCSV")
	public void updata(UploadEvent event) {
	   
		if(event.getMedia().isBinary()){
			 Messagebox.show("Error: File must be a text-based csv format", "Upload Error", Messagebox.OK, Messagebox.ERROR);
			 return;
		}
		
//		System.out.println(event.getMedia().getStringData());
		
		
		String name = "sampleName";
	
	    String path = Sessions.getCurrent().getWebApp().getRealPath("/UPLOADS/") + "/";                
	   

	    this.uploadFile(path, name, ".csv", event.getMedia().getStringData());       
	        BindUtils.postNotifyChange(null, null, this, "*");
	        

		    
	        lblUploadMessage.setValue("Filename: " + name + ".csv");
		
	}
	public void uploadFile(String path, String name, String ext,
           String data) {
 
		String filePath = path + name + ext;
		
		try {
			PrintWriter out = new PrintWriter(filePath);
			out.println(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public boolean validateHeader(String path){
		
		//STATIC
		HashMap<String,String> headerData = new HashMap<String,String>();
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		headerData.put("GN", "GName");
		
		try {
			CSVReader reader = new CSVReader(new FileReader(path));
			String[] header = reader.readNext();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
}