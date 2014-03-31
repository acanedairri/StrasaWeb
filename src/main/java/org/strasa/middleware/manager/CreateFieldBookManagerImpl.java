package org.strasa.middleware.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.strasa.middleware.model.Study;
import org.strasa.web.createfieldbook.view.pojos.SiteInformationModel;

public class CreateFieldBookManagerImpl {

	Sheet observationSheet;
	GermplasmManagerImpl germplasmMan = new GermplasmManagerImpl();
	Study study;

	private ArrayList<SiteInformationModel> lstSiteInfo = new ArrayList<SiteInformationModel>();

	public CreateFieldBookManagerImpl(ArrayList<SiteInformationModel> lstSiteInfo, Study study) {
		this.lstSiteInfo = lstSiteInfo;
		this.study = study;
	}

	public void generateFieldBook() throws Exception {
		// Create excel
		Workbook workbook = createExcel(study.getName() + ".xls");

		observationSheet = workbook.createSheet("Observation");

		for (SiteInformationModel siteInfo : lstSiteInfo) {
			populateSheetFromSite(siteInfo, observationSheet);
		}

	}

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

	public void populateSheetFromSite(SiteInformationModel siteInfo, Sheet sheet) throws Exception {
		Sheet shGenotype = getExcelSheet(siteInfo.getFileGenotype(), 0);
		Sheet shLayout = getExcelSheet(siteInfo.getFileLayout(), 0);
		Integer colGenotype;
		Integer colLayout;
		String autoHeaderMatch;

		if (siteInfo.isHeaderAutoMatch()) {
			autoHeaderMatch = getFirstCommonString(readParticularRowInExcelSheet(shGenotype, 0), readParticularRowInExcelSheet(shLayout, 0));
			colGenotype = getHeaderColumnNumber(autoHeaderMatch, shGenotype);
			colLayout = getHeaderColumnNumber(autoHeaderMatch, shGenotype);
		} else {
			colGenotype = getHeaderColumnNumber(siteInfo.getHeaderGenotype(), shGenotype);
			colLayout = getHeaderColumnNumber(siteInfo.getHeaderLayout(), shGenotype);
		}

	}

	public void createObservationHeader(ArrayList<String> lstGenotype, ArrayList<String> lstLayout) {
		if (observationSheet.getRow(0).getCell(0).getCellType() == Cell.CELL_TYPE_BLANK)
			return;

	}

	public String getFirstCommonString(ArrayList<String> lst1, ArrayList<String> lst2) {
		lst1.retainAll(lst2);
		return lst1.get(0);
	}

	public ArrayList<ArrayList<String>> readExcelSheet(Sheet sheet, int startToRow) {

		ArrayList<ArrayList<String>> returnVal = new ArrayList<ArrayList<String>>();

		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

		for (int i = startToRow; i < totalRows; i++) {
			ArrayList<String> row = new ArrayList<String>();
			for (int j = 0; j < totalColumns; j++) {
				row.add(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			returnVal.add(row);
		}

		return returnVal;
	}

	public int getHeaderColumnNumber(String header, Sheet sheet) throws Exception {
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

		for (int i = 0; i < totalColumns; i++) {
			if (sheet.getRow(0).getCell(i).getStringCellValue().toUpperCase().equals(header.toUpperCase()))
				return i;
		}

		throw new Exception("Error: Header not found!");

	}

	public HashMap<String, ArrayList<String>> parseExcelSheetToHMap(Sheet sheet, int index, int startToRow) {

		HashMap<String, ArrayList<String>> returnVal = new HashMap<String, ArrayList<String>>();
		ArrayList<ArrayList<String>> lstSheet = readExcelSheet(sheet, startToRow);

		for (ArrayList<String> arr : lstSheet) {
			returnVal.put(arr.get(index), arr);
		}

		return returnVal;

	}

	public ArrayList<String> readParticularRowInExcelSheet(Sheet sheet, int particularRow) {

		ArrayList<String> returnVal = new ArrayList<String>();

		int totalRows = sheet.getLastRowNum();

		for (int i = 0; i < totalRows; i++) {

			returnVal.add(sheet.getRow(i).getCell(particularRow).getStringCellValue());

		}

		return returnVal;
	}

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
