package org.strasa.web.view.model;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class UploadDataModel {
	
	


	@Command("uploadCSV")
	public void uploadCSV(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view) {
		
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("value","sample");
		params.put("parent", view);
	
		Window popup = (Window) Executions.createComponents("modal/popup.zul", view, params);
		
		popup.doModal();

		
		
		 UploadEvent event = (UploadEvent)ctx.getTriggerEvent();
		if(event.getMedia().isBinary()){
			 Messagebox.show("Error: File must be a text-based csv format", "Upload Error", Messagebox.OK, Messagebox.ERROR);
			 return;
		}
		
//		System.out.println(event.getMedia().getStringData());
		
		
		String name = "sampleName";
	
	    String path = Sessions.getCurrent().getWebApp().getRealPath("/UPLOADS/") + "/";                
	   

	    this.uploadFile(path, name, ".csv", event.getMedia().getStringData());       
	        BindUtils.postNotifyChange(null, null, this, "*");
	        

		    
		
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
	
	@Command("change")
	public void change(@BindingParam("newValue") String newValue) {
	
	System.out.println("newVal: " + newValue);
	}
	
}
