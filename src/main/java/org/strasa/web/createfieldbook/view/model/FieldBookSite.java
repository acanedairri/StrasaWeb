package org.strasa.web.createfieldbook.view.model;

import java.util.List;

import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.LocationManagerImpl;
import org.strasa.middleware.manager.PlantingTypeManagerImpl;
import org.strasa.middleware.manager.SoilTypeManagerImpl;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.PlantingType;
import org.strasa.web.createfieldbook.view.pojos.SiteInformationModel;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.ListModelList;

import com.mysql.jdbc.StringUtils;

public class FieldBookSite {

	/*
	 * INITS
	 */
	@Init
	public void init() {
		lstLocations = getAllLocations();
	}

	public void afterCompose(@ContextParam(ContextType.VIEW) final Component view) {

		bboxLocation = (Bandbox) view.getAttribute("bbox_location");
	}

	/*
	 * DECLARATIONS
	 */

	List<Ecotype> ecotypes = new EcotypeManagerImpl().getAllEcotypes();
	List<String> soiltypes = new SoilTypeManagerImpl().getAllSoilType();
	List<PlantingType> plantingtypes = new PlantingTypeManagerImpl().getAllPlantingTypes();
	SiteInformationModel site;
	Bandbox bboxLocation;
	List<Location> lstLocations;
	private String labelDate;

	/*
	 * COMMANDS
	 */

	@Command
	public void doLocationSearch() {
		toggleBandBox(true);

		BindUtils.postNotifyChange(null, null, this.site, "*");
		site.getLocation().setId(null);
	}

	@NotifyChange("labelDate")
	@Command
	public void updateLabelDate() {
		if (site.getPlantingtype().getPlanting().equals("Transplanting"))
			labelDate = "Transplanting Date";
		else if (site.getPlantingtype().getId() == -1)
			labelDate = "Transplanting/Sowing Date";
		else
			labelDate = "Sowing Date";
	}

	@Command
	public void autoFillBandbox(@BindingParam("id") int lstId) {

		if (!bboxLocation.isOpen()) {
			if (getFilteredLocations().isEmpty() && getFilteredLocations().getSize() != lstLocations.size()) {
				site.setLocation(getFilteredLocations().get(0));

			}
		} else {
			// updateDesignInfo(lstId);
		}
	}

	@Command
	public void openBandbox() {
		bboxLocation.open();
	}

	@Command
	public void setLocationRow(@BindingParam("location") Location location) {

		site.setLocation(location);
		BindUtils.postNotifyChange(null, null, this.site, "*");
		toggleBandBox(false);
	}

	/*
	 * COMMON METHODS
	 */
	public void toggleBandBox(boolean isOpen) {

		if (isOpen) {
			bboxLocation.open();
			bboxLocation.setFocus(true);
		} else {
			bboxLocation.close();
			bboxLocation.setFocus(false);
		}

	}

	public ListModelList<Location> getFilteredLocations() {

		ListModelList<Location> returnVal = new ListModelList<Location>();
		if (StringUtils.isNullOrEmpty(site.getLocation().getLocationname())) {

			return getAllLocations();

		}
		String tempSelected = null;

		ListModelList<Location> lstLocations = getAllLocations();
		for (Location loc : lstLocations) {
			if (loc.getLocationname().toLowerCase().startsWith(site.getLocation().getLocationname().toLowerCase())) {
				returnVal.add(loc);
				if (tempSelected == null)
					tempSelected = loc.getLocationname();
			}
		}

		return returnVal;

	}

	public ListModelList<Location> getAllLocations() {
		ListModelList<Location> lstLocations = new ListModelList<Location>();
		lstLocations.addAll(new LocationManagerImpl().getAllLocations());
		return lstLocations;
	}

	/*
	 * GETTERS AND SETTERS
	 */

	public List<Ecotype> getEcotypes() {
		return ecotypes;
	}

	public void setEcotypes(List<Ecotype> ecotypes) {
		this.ecotypes = ecotypes;
	}

	public List<String> getSoiltypes() {
		return soiltypes;
	}

	public void setSoiltypes(List<String> soiltypes) {
		this.soiltypes = soiltypes;
	}

	public List<Location> getLstLocations() {
		return lstLocations;
	}

	public void setLstLocations(List<Location> lstLocations) {
		this.lstLocations = lstLocations;
	}

	public SiteInformationModel getSite() {
		return site;
	}

	public void setSite(SiteInformationModel site) {
		this.site = site;
	}

	public List<PlantingType> getPlantingtypes() {
		return plantingtypes;
	}

	public void setPlantingtypes(List<PlantingType> plantingtypes) {
		this.plantingtypes = plantingtypes;
	}

	public String getLabelDate() {
		return labelDate;
	}

	public void setLabelDate(String labelDate) {
		this.labelDate = labelDate;
	}

}
