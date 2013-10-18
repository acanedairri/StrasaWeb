package org.strasa.web.common.api;

import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

public interface ProccessTabViewModel {

	public boolean validateTab();
	@Init
	public void init(@ExecutionArgParam("studyID")double studyID);
	
}
