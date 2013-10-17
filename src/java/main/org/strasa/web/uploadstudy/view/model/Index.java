package org.strasa.web.uploadstudy.view.model;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Tabpanel;

public class Index {

	private UploadData uploadData;
	
	
	
	public UploadData getUploadData() {
		return uploadData;
	}

	public void setUploadData(UploadData uploadData) {
		this.uploadData = uploadData;
	}

	@Command("showzulfile")
	public void showzulfile(@BindingParam("zulFileName") String zulFileName,
			@BindingParam("target") Tabpanel panel) {

		if (panel != null && panel.getChildren().isEmpty()) {
			 Map arg = new HashMap();
		        arg.put("newVal", Math.random());
			Executions.createComponents(zulFileName, panel, arg);
		}
	}
	@NotifyChange("uploadData")
	@GlobalCommand("sampleCommand")
	public void sampleCommand(@BindingParam("model") UploadData uploadData) {
		System.out.println("Sample: " + uploadData.getTxtProject());
		 Map arg = new HashMap();
	        arg.put("newVal", Math.random());
	        BindUtils.postGlobalCommand(null, null, "testGlobalCom", arg);


	}
}
