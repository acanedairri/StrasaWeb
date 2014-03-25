package org.strasa.web.createfieldbook.view.model;

import org.strasa.web.createfieldbook.view.pojos.SiteInformationModel;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Bandbox;

public class FieldBookSite {

	SiteInformationModel site;
	Bandbox bboxLocation;

	public SiteInformationModel getSite() {
		return site;
	}

	public void setSite(SiteInformationModel site) {
		this.site = site;
	}

	@Command
	public void doLocationSearch() {
		toggleBandBox(true);

		BindUtils.postNotifyChange(null, null, this.site, "*");
		site.getLocation().setId(null);
	}

	public void toggleBandBox(boolean isOpen) {

		if (isOpen) {
			bboxLocation.open();
			bboxLocation.setFocus(true);
		} else {
			bboxLocation.close();
			bboxLocation.setFocus(false);
		}

	}

	public void afterCompose(@ContextParam(ContextType.VIEW) final Component view) {

		bboxLocation = (Bandbox) view.getAttribute("bbox_location");
	}

}
