package org.strasa.web.uploadstudy.view.model;

import java.util.List;

import org.strasa.middleware.model.StudySite;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

 
public class UploadStudyStep3 {
     
    private List<StudySite> sites;

	public List<StudySite> getSites() {
		return sites;
	}
	public void setSites(List<StudySite> sites) {
		this.sites = sites;
	}
}