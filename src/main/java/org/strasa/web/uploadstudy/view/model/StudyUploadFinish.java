package org.strasa.web.uploadstudy.view.model;

import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

public class StudyUploadFinish extends ProcessTabViewModel{
	
	@Init
	public void init(@ExecutionArgParam("uploadModel") ProcessTabViewModel uploadModel) {
		this.initValues(uploadModel);
	}
}
