package org.strasa.web.uploadstudy.view.pojos;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.LocationManagerImpl;
import org.strasa.middleware.manager.PlantingTypeManagerImpl;
import org.strasa.middleware.manager.StudyAgronomyManagerImpl;
import org.strasa.middleware.manager.StudyDesignManagerImpl;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudyRawDataManagerImpl;
import org.strasa.middleware.manager.StudySiteManagerImpl;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.PlantingType;
import org.strasa.middleware.model.StudyAgronomy;
import org.strasa.middleware.model.StudyDesign;
import org.strasa.middleware.model.StudySite;
import org.strasa.web.common.api.ProcessTabViewModel;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;

import com.mysql.jdbc.StringUtils;
public class StudySiteInfoModel extends StudySite {
	public StudyAgronomy selectedAgroInfo = new StudyAgronomy();
		public StudyDesign selectedDesignInfo = new StudyDesign();
		public PlantingType selectedSitePlantingType = new PlantingType();
		public int selectedPlantingIndex;
		public Ecotype selectedEcotype;
		public boolean isYearAuto = false;
		public Location selectedLocation = new Location();
		public Binder binder;

	
		public Location getSelectedLocation() {
			return selectedLocation;
		}
		public ListModelList<Location> getAllLocations(){
			ListModelList<Location> lstLocations = new ListModelList<Location>();
			lstLocations.addAll(new LocationManagerImpl().getAllLocations());
			return lstLocations ;
		}

		public void setSelectedLocation(Location selectedLocation) {
			this.selectedLocation = selectedLocation;
			this.setSitelocation(selectedLocation.getLocationname());
			this.setLocationid(selectedLocation.getId());
		}

		public boolean isYearAuto() {
			return isYearAuto;
		}

		public void updateFilteredLocations(){
	
		}
		public ListModelList<Location> getFilteredLocations() {
			System.out.println("Hello");
			ListModelList<Location> returnVal = new ListModelList<Location>();
			if (StringUtils.isNullOrEmpty(selectedLocation.getLocationname())){
		
				return getAllLocations();

			}
			String tempSelected = null;
			
			ListModelList<Location> lstLocations = getAllLocations();
			for (Location loc : lstLocations ) {
				if (loc.getLocationname().toLowerCase().startsWith(selectedLocation.getLocationname().toLowerCase()))
					{
						returnVal.add(loc);
						if(tempSelected == null) tempSelected = loc.getLocationname();
					}
			}

			return returnVal;

		}

		public void setYearAuto(boolean isYearAuto) {
			this.isYearAuto = isYearAuto;
		}

		public Ecotype getSelectedEcotype() {
			return selectedEcotype;
		}

		public void setSelectedEcotype(Ecotype selectedEcotype) {
			this.selectedEcotype = selectedEcotype;
			this.setEcotypeid(selectedEcotype.getId());
		}

		public String validateAll() {
			if (StringUtils.isNullOrEmpty(this.getSitename())) {
				return "Error: Site Name  must not be empty! ";
			}
			if (StringUtils.isNullOrEmpty(this.selectedLocation.getLocationname())) {
				return "Error: Location in " + this.getSitename()
						+ " must not be empty! ";
			}
			if (this.selectedLocation.getId() == null) {
				return "Error: Location in " + this.getSitename()
						+ " does not exist in the database. Please add your location first or select any existing location.";
			}
			if (StringUtils.isNullOrEmpty(this.getYear())) {
				return "Error: Year in " + this.getSitename()
						+ " must not be empty! ";
			}
			if (StringUtils.isNullOrEmpty(this.getSeason())) {
				return "Error: Season in " + this.getSitename()
						+ " must not be empty! ";
			}
			System.out.println("EcotypeID: " + this.getEcotypeid());
			if (this.getEcotypeid() == null) {
				return "Error: Eco System in " + this.getSitename()
						+ " must not be empty! ";
			}

			if (selectedSitePlantingType.getId() == -1) {
				return "Error: Planting Type in " + this.getSitename()
						+ " must not be empty! ";
			}
			if (selectedAgroInfo.getHarvestdate() == null) {
				return "Error: Harvest Date Type in " + this.getSitename()
						+ " must not be empty! ";
			}
			if (selectedAgroInfo.getSowingdate() == null) {
				return "Error: Sowing Date Type in " + this.getSitename()
						+ " must not be empty! ";
			}

			if (StringUtils.isNullOrEmpty(selectedDesignInfo
					.getTreatmentstructure())) {

				return "Treatment Structure in " + this.getSitename()
						+ "must not be empty!";
			}
			if (StringUtils.isNullOrEmpty(selectedDesignInfo
					.getDesignstructure())) {
				return "Design Structure in " + this.getSitename()
						+ "must not be empty!";
			}
			if (StringUtils.isNullOrEmpty(selectedDesignInfo.getPlotsize())) {
				return "Plot size in " + this.getSitename()
						+ "must not be empty!";

			}
			if (this.selectedAgroInfo.getSowingdate().compareTo(
					this.selectedAgroInfo.getHarvestdate()) > 0) {

				return "Error: Havest date must be greater than Transplanting/Sowing date in "
						+ this.getSitename();
			}
			return null;

		}

		public String validateColumnOnly() {
			if (StringUtils.isNullOrEmpty(this.getSitename())) {
				return "Error: Site Name  must not be empty! ";
			}
			if (StringUtils.isNullOrEmpty(this.getSitelocation())) {
				return "Error: Location in " + this.getSitename()
						+ " must not be empty! ";
			}
			if (StringUtils.isNullOrEmpty(this.getYear())) {
				return "Error: Year in " + this.getSitename()
						+ " must not be empty! ";
			}
			if (StringUtils.isNullOrEmpty(this.getSeason())) {
				return "Error: Season in " + this.getSitename()
						+ " must not be empty! ";
			}

			return null;

		}

		public StudySiteInfoModel(StudySite s) {
			this.setEcotypeid(s.getEcotypeid());
			if (StringUtils.isNullOrEmpty(s.getSeason())) {
				System.out.println("Season is now null!");
				s.setSeason("");
			}
			this.setSeason(s.getSeason());
			this.setSitelocation(s.getSitelocation());
			this.setSitename(s.getSitename());
			this.setSoilph(s.getSoilph());
			this.setSoiltype(s.getSoiltype());
			this.setSoiltype(s.getSoiltype());
			this.setStudyid(s.getStudyid());
			this.setYear(s.getYear());

		}

		public StudySiteInfoModel() {

		}

		public StudyAgronomy getSelectedAgroInfo() {
			if (selectedAgroInfo == null)
				return new StudyAgronomy();
			return selectedAgroInfo;
		}

		public void setSelectedAgroInfo(StudyAgronomy selectedAgroInfo) {

			this.selectedAgroInfo = selectedAgroInfo;
		}

		public StudyDesign getSelectedDesignInfo() {

			
			return selectedDesignInfo;
		}

		public void setSelectedDesignInfo(StudyDesign selectedDesignInfo) {
			this.selectedDesignInfo = selectedDesignInfo;
		}

		public PlantingType getSelectedSitePlantingType() {

			System.out.println(selectedSitePlantingType.getPlanting());
			return selectedSitePlantingType;
		}

		public void setSelectedSitePlantingType(
				PlantingType selectedSitePlantingType) {
			this.selectedSitePlantingType = selectedSitePlantingType;

			System.out.println(selectedSitePlantingType.getPlanting());
		}

	}