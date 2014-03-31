/*
 * Data Management and Analysis (DMAS) - International Rice Research Institute 2013-2015
 * 
 *   DMAS is an opensource Data management and statistical analysis mainly for STRASA Project: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *  DMAS is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with DMAS.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 * 
 */
package org.strasa.web.createfieldbook.view.pojos;

import java.io.File;
import java.util.ArrayList;

import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.PlantingType;
import org.strasa.middleware.model.StudyAgronomy;
import org.strasa.middleware.model.StudyDesign;
import org.strasa.middleware.model.StudySite;
import org.strasa.middleware.model.StudyVariable;

// TODO: Auto-generated Javadoc
/**
 * The Class SiteInformationModel.
 */
public class SiteInformationModel extends StudySite {

	public ArrayList<StudyVariable> lstStudyVariable = new ArrayList<StudyVariable>();

	/** The file layout. */
	private File fileLayout;

	/** The file genotype. */
	private File fileGenotype;

	/** The design. */
	private StudyDesign design = new StudyDesign();

	/** The agronomy. */
	private StudyAgronomy agronomy = new StudyAgronomy();

	/** The location. */
	private Location location = new Location();;

	/** The lst variable. */
	private ArrayList<StudyVariable> lstVariable;

	private Ecotype ecotype;
	private PlantingType plantingtype = new PlantingType();
	private boolean headerAutoMatch = true;
	private String headerLayout;
	private String headerGenotype;

	public Ecotype getEcotype() {
		return ecotype;
	}

	public void setEcotype(Ecotype ecotype) {
		this.ecotype = ecotype;
		this.setEcotypeid(ecotype.getId());
	}

	/**
	 * Gets the design.
	 * 
	 * @return the design
	 */
	public StudyDesign getDesign() {
		return design;
	}

	/**
	 * Sets the design.
	 * 
	 * @param design
	 *            the new design
	 */
	public void setDesign(StudyDesign design) {
		this.design = design;
	}

	/**
	 * Gets the agronomy.
	 * 
	 * @return the agronomy
	 */
	public StudyAgronomy getAgronomy() {
		return agronomy;
	}

	/**
	 * Sets the agronomy.
	 * 
	 * @param agronomy
	 *            the new agronomy
	 */
	public void setAgronomy(StudyAgronomy agronomy) {
		this.agronomy = agronomy;
	}

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 * 
	 * @param location
	 *            the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
		this.setLocationid(location.getId());
	}

	/**
	 * Gets the file layout.
	 * 
	 * @return the file layout
	 */
	public File getFileLayout() {
		return fileLayout;
	}

	/**
	 * Sets the file layout.
	 * 
	 * @param fileLayout
	 *            the new file layout
	 */
	public void setFileLayout(File fileLayout) {
		this.fileLayout = fileLayout;
	}

	/**
	 * Gets the file genotype.
	 * 
	 * @return the file genotype
	 */
	public File getFileGenotype() {
		return fileGenotype;
	}

	/**
	 * Sets the file genotype.
	 * 
	 * @param fileGenotype
	 *            the new file genotype
	 */
	public void setFileGenotype(File fileGenotype) {
		this.fileGenotype = fileGenotype;
	}

	/**
	 * Gets the lst variable.
	 * 
	 * @return the lst variable
	 */
	public ArrayList<StudyVariable> getLstVariable() {
		return lstVariable;
	}

	/**
	 * Sets the lst variable.
	 * 
	 * @param lstVariable
	 *            the new lst variable
	 */
	public void setLstVariable(ArrayList<StudyVariable> lstVariable) {
		this.lstVariable = lstVariable;
	}

	public PlantingType getPlantingtype() {
		return plantingtype;
	}

	public void setPlantingtype(PlantingType plantingtype) {
		this.plantingtype = plantingtype;
	}

	public ArrayList<StudyVariable> getLstStudyVariable() {
		return lstStudyVariable;
	}

	public void setLstStudyVariable(ArrayList<StudyVariable> lstStudyVariable) {
		this.lstStudyVariable = lstStudyVariable;
	}

	public boolean isHeaderAutoMatch() {
		return headerAutoMatch;
	}

	public void setHeaderAutoMatch(boolean headerAutoMatch) {
		this.headerAutoMatch = headerAutoMatch;
	}

	public String getHeaderLayout() {
		return headerLayout;
	}

	public void setHeaderLayout(String headerLayout) {
		this.headerLayout = headerLayout;
	}

	public String getHeaderGenotype() {
		return headerGenotype;
	}

	public void setHeaderGenotype(String headerGenotype) {
		this.headerGenotype = headerGenotype;
	}

}