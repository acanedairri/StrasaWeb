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
package org.strasa.middleware.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.web.createfieldbook.view.pojos.SiteInformationModel;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateFieldBookManagerImpl.
 */
public class CreateFieldBookManagerImpl {

	/** The observation sheet. */
	Sheet observationSheet;

	/** The germplasm man. */
	GermplasmManagerImpl germplasmMan = new GermplasmManagerImpl();

	/** The study. */
	Study study;

	/** The output folder. */
	File outputFolder;

	/** The output file. */
	File outputFile;

	/** The lst site info. */
	private ArrayList<SiteInformationModel> lstSiteInfo = new ArrayList<SiteInformationModel>();

	private Workbook workbook;

	/**
	 * Instantiates a new CreateFieldBookManageImpl.
	 * 
	 * @param lstSiteInfo
	 *            the List<SiteInformationModel> that contains all the
	 *            SiteInformation
	 * @param Study
	 *            Object for the
	 * @param outputFolder
	 *            the output folder
	 */
	public CreateFieldBookManagerImpl(ArrayList<SiteInformationModel> lstSiteInfo, Study study, File outputFolder) {
		this.lstSiteInfo = lstSiteInfo;
		this.study = study;
		this.outputFolder = outputFolder;
	}

	/**
	 * Generate field book.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public File generateFieldBook() throws Exception {
		// Create excel
		workbook = createExcel(study.getName() + ".xls");
		Sheet descriptionSheet = workbook.createSheet("Description");
		generateMetaInfo(descriptionSheet);
		generateCondition(descriptionSheet);
		generateFactor(descriptionSheet, lstSiteInfo);
		generateVariate(descriptionSheet, lstSiteInfo);
		setColumnSize(descriptionSheet, 7000);
		workbook.setSh observationSheet = workbook.createSheet("Observation");

		for (SiteInformationModel siteInfo : lstSiteInfo) {
			populateSheetFromSite(siteInfo, observationSheet);
		}
		populateVariateHeader(observationSheet, lstSiteInfo);

		setColumnAutoResize(observationSheet);

		Sheet siteInformationSheet = workbook.createSheet("Site Information");

		generateSiteInformationSheet(siteInformationSheet, lstSiteInfo);
		setColumnAutoResize(siteInformationSheet);

		outputFile = new File(outputFolder.getAbsolutePath() + "/" + study.getName() + ".xls");
		FileOutputStream fos = new FileOutputStream(outputFile);
		workbook.write(fos);
		fos.close();
		return outputFile;
	}

	/**
	 * Creates the excel.
	 * 
	 * @param excelFileName
	 *            the excel file name
	 * @return the workbook
	 * @throws Exception
	 *             the exception
	 */
	public Workbook createExcel(String excelFileName) throws Exception {

		Workbook workbook;
		if (excelFileName.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFileName.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new Exception("invalid file name, should be xls or xlsx");
		}

		return workbook;
	}

	/*
	 * 
	 * META DATA
	 */

	public void generateMetaInfo(Sheet sheet) {
		int rowNum = 0;

		writeMetaInfo(sheet, "STUDY", study.getName(), rowNum++);
		writeMetaInfo(sheet, "TITLE", "", rowNum++);
		writeMetaInfo(sheet, "PMKEY", "", rowNum++);
		writeMetaInfo(sheet, "OBJECTIVE", "", rowNum++);

		writeMetaInfo(sheet, "START DATE", study.getStartyear(), rowNum++);
		writeMetaInfo(sheet, "END DATE", study.getEndyear(), rowNum++);

	}

	public void writeMetaInfo(Sheet sheet, String label, String value, int rowNum) {

		Row row = sheet.createRow(rowNum);
		Cell cellLabel = row.createCell(0);
		cellLabel.setCellStyle(formatCell(IndexedColors.RED.getIndex(), IndexedColors.WHITE.getIndex(), (short) 200, true));
		cellLabel.setCellValue(label);

		Cell cellValue = row.createCell(1);
		cellValue.setCellValue(value);

	}

	public void generateVariate(Sheet sheet, List<SiteInformationModel> lstSiteInfo) throws Exception {

		HashSet<String> lstSet = new HashSet<String>();
		for (SiteInformationModel siteInfo : lstSiteInfo) {
			for (StudyVariable var : siteInfo.lstStudyVariable) {
				lstSet.add(var.getVariablecode());
			}
		}

		List<StudyVariable> lstVar = new StudyVariableManagerImpl().getVariateVariable(Arrays.asList(lstSet.toArray(new String[lstSet.size()])));

		int col = sheet.getLastRowNum() + 2;
		writeRowFromList(new ArrayList<String>(Arrays.asList("VARIATE", "DESCRIPTION", "PROPERTY", "SCALE", "METHOD", "DATATYPE", "       ")), sheet, col++, formatCell(IndexedColors.VIOLET.getIndex(), IndexedColors.WHITE.getIndex(), (short) 200, true));
		for (StudyVariable variable : lstVar) {
			writeRowFromList(new ArrayList<String>(Arrays.asList(variable.getVariablecode(), variable.getDescription(), variable.getProperty(), variable.getScale(), variable.getMethod(), variable.getDatatype(), "    ")), sheet, col++, null);

		}
	}

	public void generateFactor(Sheet sheet, List<SiteInformationModel> lstSiteInfo) throws Exception {

		HashSet<String> lstSet = new HashSet<String>();
		for (SiteInformationModel siteInfo : lstSiteInfo) {
			Sheet shGenotype = getExcelSheet(siteInfo.getFileGenotype(), 0);
			Sheet shLayout = getExcelSheet(siteInfo.getFileLayout(), 0);
			lstSet.addAll(readParticularRowInExcelSheet(shGenotype, 0));
			lstSet.addAll(readParticularRowInExcelSheet(shLayout, 0));
		}

		List<StudyVariable> lstVar = new StudyVariableManagerImpl().getFactorVariable(Arrays.asList(lstSet.toArray(new String[lstSet.size()])));

		int col = sheet.getLastRowNum() + 2;
		writeRowFromList(new ArrayList<String>(Arrays.asList("FACTOR", "DESCRIPTION", "PROPERTY", "SCALE", "METHOD", "DATATYPE", "       ")), sheet, col++, formatCell(IndexedColors.GREEN.getIndex(), IndexedColors.WHITE.getIndex(), (short) 200, true));
		for (StudyVariable variable : lstVar) {
			writeRowFromList(new ArrayList<String>(Arrays.asList(variable.getVariablecode(), variable.getDescription(), variable.getProperty(), variable.getScale(), variable.getMethod(), variable.getDatatype(), "    ")), sheet, col++, null);

		}
	}

	/*
	 * CONDITION
	 */

	public void generateCondition(Sheet sheet) {

		int col = sheet.getLastRowNum() + 2;
		writeRowFromList(new ArrayList<String>(Arrays.asList("CONDITION", "DESCRIPTION", "PROPERTY", "SCALE", "METHOD", "DATATYPE", "VALUE")), sheet, col++, formatCell(IndexedColors.GREEN.getIndex(), IndexedColors.WHITE.getIndex(), (short) 200, true));
		HashMap<String, StudyVariable> lstVars = new StudyVariableManagerImpl().getConditionVariable(new ArrayList<String>(Arrays.asList("StudyDescription", "StudyProgram", "StudyProject")));

		StudyVariable variable = lstVars.get("StudyDescription");

		writeRowFromList(new ArrayList<String>(Arrays.asList(variable.getVariablecode(), variable.getDescription(), variable.getProperty(), variable.getScale(), variable.getMethod(), variable.getDatatype(), study.getDescription())), sheet, col++, null);

		variable = lstVars.get("StudyProgram");
		writeRowFromList(
				new ArrayList<String>(Arrays.asList(variable.getVariablecode(), variable.getDescription(), variable.getProperty(), variable.getScale(), variable.getMethod(), variable.getDatatype(), new ProgramManagerImpl().getProgramById(study.getProgramid()).getName())), sheet,
				col++, null);
		variable = lstVars.get("StudyProject");
		writeRowFromList(
				new ArrayList<String>(Arrays.asList(variable.getVariablecode(), variable.getDescription(), variable.getProperty(), variable.getScale(), variable.getMethod(), variable.getDatatype(), new ProjectManagerImpl().getProjectById(study.getProjectid()).getName())), sheet,
				col++, null);

	}

	public void generateSiteInformationSheet(Sheet sheet, List<SiteInformationModel> lstSiteInfo) {

		ArrayList<ArrayList<String>> lstColumnFields = new ArrayList<ArrayList<String>>();

		lstColumnFields.add(new ArrayList<String>(Arrays.asList("Site Name", "Site Location", "Year", "Season", "Eco System", "Soil Type", "Soil pH", "Planting Type", "Transplanting/Sowing Date", "Harvest Date", "Fertilization", "Density", "Plot Size", "Design Structure",
				"Treatment Stucture", "Design Factor 1", "Design Factor 2", "Design Factor 3", "Design Factor 4")));

		for (SiteInformationModel s : lstSiteInfo) {
			ArrayList<String> ar = new ArrayList<String>();
			ar.add(s.getSitename());
			ar.add(s.getLocation().getLocationname());
			ar.add(s.getYear());
			ar.add(s.getSeason());
			ar.add(new EcotypeManagerImpl().getEcotypeById(s.getEcotypeid()).getEcotype());
			ar.add(s.getSoiltype());
			ar.add(s.getSoilph());

			ar.add(s.getPlantingtype().getPlanting());
			ar.add(new SimpleDateFormat("MM/dd/yyyy").format(s.getAgronomy().getSowingdate()));
			ar.add(new SimpleDateFormat("MM/dd/yyyy").format(s.getAgronomy().getHarvestdate()));
			ar.add(s.getAgronomy().getFertilization());
			ar.add(s.getAgronomy().getDensity());

			ar.add(s.getDesign().getPlotsize());
			ar.add(s.getDesign().getDesignstructure());
			ar.add(s.getDesign().getTreatmentstructure());
			ar.add(s.getDesign().getDesignfactor1());
			ar.add(s.getDesign().getDesignfactor2());
			ar.add(s.getDesign().getDesignfactor3());
			ar.add(s.getDesign().getDesignfactor4());
			lstColumnFields.add(ar);

		}

		ArrayList<String> lstHeader = new ArrayList<String>();
		for (ArrayList<String> col : lstColumnFields) {
			lstHeader.add(col.get(0).toUpperCase());
		}
		int rowCol = 0;
		writeRowFromList(lstHeader, sheet, rowCol++, formatCell(IndexedColors.GREEN.getIndex(), IndexedColors.WHITE.getIndex(), (short) 200, true));

		for (int i = 1; i < lstColumnFields.get(0).size(); i++) {
			ArrayList<String> newcol = new ArrayList<String>();
			for (ArrayList<String> col : lstColumnFields) {
				newcol.add(col.get(i));
			}
			writeRowFromList(newcol, sheet, rowCol++, null);

			sheet.getRow(i).getCell(0).setCellStyle(formatCell(IndexedColors.GREEN.getIndex(), IndexedColors.WHITE.getIndex(), (short) 200, true));
		}

	}

	/**
	 * Populate sheet from site.
	 * 
	 * @param siteInfo
	 *            the site info
	 * @param sheet
	 *            the sheet
	 * @throws Exception
	 *             the exception
	 */
	public void populateSheetFromSite(SiteInformationModel siteInfo, Sheet sheet) throws Exception {
		Sheet shGenotype = getExcelSheet(siteInfo.getFileGenotype(), 0);
		Sheet shLayout = getExcelSheet(siteInfo.getFileLayout(), 0);
		Integer colGenotype;
		Integer colLayout;
		String autoHeaderMatch = null;

		if (siteInfo.isHeaderAutoMatch()) {
			autoHeaderMatch = getFirstCommonString(readParticularRowInExcelSheet(shGenotype, 0), readParticularRowInExcelSheet(shLayout, 0));
			colGenotype = getHeaderColumnNumber(autoHeaderMatch, shGenotype);
			colLayout = getHeaderColumnNumber(autoHeaderMatch, shLayout);

		} else {
			colGenotype = getHeaderColumnNumber(siteInfo.getHeaderGenotype(), shGenotype);
			colLayout = getHeaderColumnNumber(siteInfo.getHeaderLayout(), shGenotype);
		}

		// Write the header column for Observation Header if its blank or has
		// not been created yet
		if (sheet.getRow(0) == null) {
			ArrayList<String> lstGenotype = readParticularRowInExcelSheet(shGenotype, 0);
			ArrayList<String> lstLayout = readParticularRowInExcelSheet(shLayout, 0);
			if (autoHeaderMatch != null) {
				lstGenotype.remove(autoHeaderMatch);
				lstLayout.remove(autoHeaderMatch);
			} else {
				lstGenotype.remove(colGenotype);
				lstLayout.remove(colLayout);
			}
			lstGenotype.add("SITE");
			lstGenotype.add("LOCATION");
			lstGenotype.add("YEAR");
			lstGenotype.add("SEASON");
			lstGenotype.addAll(lstLayout);
			writeRowFromList(lstGenotype, sheet, 0, formatCell(IndexedColors.GREEN.getIndex(), HSSFColor.WHITE.index, (short) 210, true));
		}

		// Generate the observation sheet;
		HashMap<String, ArrayList<String>> hmGenotype = parseExcelSheetToHMap(shGenotype, colGenotype, 1, true);

		ArrayList<ArrayList<String>> hmLayout = readExcelSheet(shLayout, 1);
		// printMap(hmGenotype);
		for (ArrayList<String> lstLayout : hmLayout) {

			String key = lstLayout.get(colLayout).trim();
			lstLayout.remove((int) colLayout);
			if (!hmGenotype.containsKey(key.trim()))
				throw new Exception("Key '" + key + "' not found in genotype sheet");

			ArrayList<String> lstNewRow = new ArrayList<String>(hmGenotype.get(key));

			lstNewRow.add(siteInfo.getSitename());
			lstNewRow.add(siteInfo.getLocation().getLocationname());
			lstNewRow.add(siteInfo.getYear());
			lstNewRow.add(siteInfo.getSeason());

			lstNewRow.addAll(lstLayout);
			writeRowFromList(lstNewRow, sheet, sheet.getLastRowNum() + 1, null);
		}

	}

	public void populateVariateHeader(Sheet sheet, List<SiteInformationModel> lstSiteInfo) {
		ArrayList<String> variateHeader = new ArrayList<String>();
		HashSet<String> noDup = new HashSet<String>();
		for (SiteInformationModel siteInfo : lstSiteInfo) {
			for (StudyVariable variate : siteInfo.lstStudyVariable) {
				if (noDup.add(variate.getVariablecode()))
					variateHeader.add(variate.getVariablecode());

			}
		}
		appendRowFromList(variateHeader, sheet, 0, formatCell(IndexedColors.BLUE.getIndex(), HSSFColor.WHITE.index, (short) 210, true));

	}

	public CellStyle formatCell(Short bgcolor, Short fontcolor, Short fontsize, boolean isBold) {

		CellStyle cellStyle = workbook.createCellStyle();
		Font font = workbook.createFont();

		if (bgcolor != null) {
			cellStyle.setFillForegroundColor(bgcolor);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		}
		if (fontcolor != null) {
			font.setColor(fontcolor);

		}
		if (fontsize != null) {
			font.setFontHeight(fontsize);
		}

		if (isBold)
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		cellStyle.setFont(font);
		return cellStyle;

	}

	/**
	 * Write row from list.
	 * 
	 * @param lstRow
	 *            the lst row
	 * @param sheet
	 *            the sheet
	 * @param rowNum
	 *            the row num
	 */
	public void writeRowFromList(List<String> lstRow, Sheet sheet, int rowNum, CellStyle style) {
		Row row = sheet.createRow(rowNum);
		for (int i = 0; i < lstRow.size(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(lstRow.get(i));
			if (style != null) {
				cell.setCellStyle(style);
			}

		}

	}

	public void setColumnAutoResize(Sheet sheet) {
		for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
			sheet.autoSizeColumn(i);
		}
	}

	public void setColumnSize(Sheet sheet, int size) {
		for (int i = 0; i < 20; i++) {
			sheet.setColumnWidth(i, size);
		}
	}

	/**
	 * Append row from list.
	 * 
	 * @param lstRow
	 *            the lst row
	 * @param sheet
	 *            the sheet
	 * @param rowNum
	 *            the row num
	 */
	public void appendRowFromList(List<String> lstRow, Sheet sheet, int rowNum, CellStyle cellStyle) {
		Row row = sheet.getRow(rowNum);

		int totalRows = row.getPhysicalNumberOfCells();

		for (int i = 0; i < lstRow.size(); i++) {
			Cell cell = row.createCell(i + totalRows);
			cell.setCellValue(lstRow.get(i));

			if (cellStyle != null)
				cell.setCellStyle(cellStyle);
		}

	}

	/**
	 * Gets the first common string.
	 * 
	 * @param lst1
	 *            the lst1
	 * @param lst2
	 *            the lst2
	 * @return the first common string
	 */
	public String getFirstCommonString(ArrayList<String> lst1, ArrayList<String> lst2) {
		lst1.retainAll(lst2);
		return lst1.get(0);
	}

	/**
	 * Read excel sheet.
	 * 
	 * @param sheet
	 *            the sheet
	 * @param startToRow
	 *            the start to row
	 * @return the array list
	 * @throws Exception
	 *             the exception
	 */
	public ArrayList<ArrayList<String>> readExcelSheet(Sheet sheet, int startToRow) throws Exception {

		ArrayList<ArrayList<String>> returnVal = new ArrayList<ArrayList<String>>();

		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = startToRow; i <= totalRows; i++) {
			ArrayList<String> row = new ArrayList<String>();
			for (int j = 0; j < totalColumns; j++) {
				row.add(getCellValueToString(sheet.getRow(i).getCell(j)));
			}
			returnVal.add(row);
		}

		return returnVal;
	}

	/**
	 * Gets the header column number.
	 * 
	 * @param header
	 *            the header
	 * @param sheet
	 *            the sheet
	 * @return the header column number
	 * @throws Exception
	 *             the exception
	 */
	public int getHeaderColumnNumber(String header, Sheet sheet) throws Exception {
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

		for (int i = 0; i < totalColumns; i++) {
			if (sheet.getRow(0).getCell(i).getStringCellValue().toUpperCase().equals(header.toUpperCase()))
				return i;

		}

		throw new Exception("Error: Header not found!");

	}

	/**
	 * Parses the excel sheet to h map.
	 * 
	 * @param sheet
	 *            the sheet
	 * @param index
	 *            the index
	 * @param startToRow
	 *            the start to row
	 * @param removeIndexColumn
	 *            the remove index column
	 * @return the hash map
	 * @throws Exception
	 *             the exception
	 */
	public HashMap<String, ArrayList<String>> parseExcelSheetToHMap(Sheet sheet, int index, int startToRow, boolean removeIndexColumn) throws Exception {

		HashMap<String, ArrayList<String>> returnVal = new HashMap<String, ArrayList<String>>();
		ArrayList<ArrayList<String>> lstSheet = readExcelSheet(sheet, startToRow);

		for (ArrayList<String> arr : lstSheet) {
			returnVal.put(arr.get(index).trim(), arr);
			if (removeIndexColumn) {
				returnVal.get(arr.get(index)).remove(index);
			}
		}

		return returnVal;

	}

	/**
	 * Read particular row in excel sheet.
	 * 
	 * @param sheet
	 *            the sheet
	 * @param particularRow
	 *            the particular row
	 * @return the array list
	 * @throws Exception
	 *             the exception
	 */
	public ArrayList<String> readParticularRowInExcelSheet(Sheet sheet, int particularRow) throws Exception {

		ArrayList<String> returnVal = new ArrayList<String>();

		Iterator<Cell> cellIterator = sheet.getRow(0).cellIterator();
		while (cellIterator.hasNext()) {

			returnVal.add(getCellValueToString(cellIterator.next()));

		}

		return returnVal;
	}

	/**
	 * Gets the cell value to string.
	 * 
	 * @param cell
	 *            the cell
	 * @return the cell value to string
	 * @throws Exception
	 *             the exception
	 */
	public String getCellValueToString(Cell cell) throws Exception {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());

		case Cell.CELL_TYPE_NUMERIC:
			return String.valueOf((int) cell.getNumericCellValue());

		case Cell.CELL_TYPE_STRING:
			return String.valueOf(cell.getStringCellValue());
		case Cell.CELL_TYPE_BLANK:
			return "";

		}

		throw new Exception("Unknown cell format");
	}

	/**
	 * Gets the excel sheet.
	 * 
	 * @param file
	 *            the file
	 * @param sheetNum
	 *            the sheet num
	 * @return the excel sheet
	 */
	public Sheet getExcelSheet(File file, int sheetNum) {
		try {
			FileInputStream excelFile = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
			return workbook.getSheetAt(sheetNum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
