package org.strasa.middleware.manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyDerivedDataMapper;
import org.strasa.middleware.mapper.StudyDerivedRawDataMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataByDataColumnMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.mapper.StudyRawDerivedDataByDataColumnMapper;
import org.strasa.middleware.mapper.other.ExtendedStudyDataColumnMapper;
import org.strasa.middleware.mapper.other.StudyRawDataBatch;
import org.strasa.middleware.mapper.other.StudySharingMapper;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyDerivedDataExample;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudyRawDataByDataColumnExample;
import org.strasa.middleware.model.StudyRawDataExample;
import org.strasa.middleware.model.StudySite;
import org.strasa.middleware.model.custom.StudyRawDataDynCol;
import org.strasa.web.common.api.ExcelHelper;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import au.com.bytecode.opencsv.CSVWriter;

public class StudyRawDataManagerImpl {

	private boolean isRaw = true;
	@WireVariable
	ConnectionFactory connectionFactory;

	public StudyRawDataManagerImpl(boolean isRaw) {
		this.isRaw = isRaw;
		System.out.println("______________________________________________");
		System.out.println((isRaw) ? "Raw Init" : "Derived Init");
		System.out.println("______________________________________________");

	}

	public StudyRawDataManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public void changeDataColumn(Integer studyid, Integer dataset, String oldColumn, String newColumn) {

		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		try {
			ExtendedStudyDataColumnMapper mapper = session.getMapper(ExtendedStudyDataColumnMapper.class);
			if (isRaw) {
				mapper.updateRawDataColumn(newColumn, oldColumn, studyid, dataset);
			} else {
				mapper.updateDerivedDataColumn(newColumn, oldColumn, studyid, dataset);

			}
			session.commit();
		} finally {
			session.close();
		}

	}

	public void deleteByStudyId(int studyID) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		try {
			if (isRaw) {
				StudyRawDataMapper studyMapper = session.getMapper(StudyRawDataMapper.class);

				StudyRawDataExample example = new StudyRawDataExample();
				example.createCriteria().andStudyidEqualTo(studyID);
				studyMapper.deleteByExample(example);
			} else {
				StudyDerivedDataMapper studyMapper = session.getMapper(StudyDerivedDataMapper.class);

				StudyDerivedDataExample example = new StudyDerivedDataExample();
				example.createCriteria().andStudyidEqualTo(studyID);
				studyMapper.deleteByExample(example);
			}
			session.commit();
		} finally {
			session.close();
		}
	}

	public int addStudy(Study record) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try {
			if (record.getId() == null)
				studyMapper.insert(record);
			else
				studyMapper.updateByPrimaryKey(record);
			session.commit();
		} finally {
			session.close();
		}
		return record.getId();
	}

	public List<Location> getStudyLocationInfo(int studyid, int dataset) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		List<Location> lstData = mapper.getRawLocation(studyid, getStudyRawTable(), dataset);
		return lstData;
	}

	public HashMap<String, Location> getStudyLocationInfoToMap(int studyid, int dataset) {
		List<Location> lstRaw = getStudyLocationInfo(studyid, dataset);
		HashMap<String, Location> returnVal = new HashMap<String, Location>();
		for (Location data : lstRaw) {
			returnVal.put(data.getLocationname(), data);
		}
		return returnVal;
	}

	public List<StudySite> getStudySiteInfo(int studyid, Integer dataset) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		if (dataset != null) {
			List<StudySite> lstData = mapper.getRawSite(studyid, getStudyRawTable(), dataset);
			return lstData;
		} else {
			List<StudySite> lstData = mapper.getRawSiteNoDataset(studyid, getStudyRawTable());
			return lstData;
		}

	}

	public List<Germplasm> getStudyGermplasmInfo(int studyid, Integer dataset) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		if (dataset != null) {
			List<Germplasm> lstData = mapper.getRawGermplasm(studyid, getStudyRawTable(), dataset);
			return lstData;

		} else {
			List<Germplasm> lstData = mapper.getRawGermplasmNoDataset(studyid, getStudyRawTable());
			return lstData;

		}
	}

	public HashMap<String, StudySite> getStudySiteInfoToMap(int studyid, Integer dataset) {
		List<StudySite> lstRaw = getStudySiteInfo(studyid, dataset);
		HashMap<String, StudySite> returnVal = new HashMap<String, StudySite>();
		for (StudySite data : lstRaw) {
			returnVal.put(data.getSitename(), data);
		}
		return returnVal;
	}

	public ArrayList<ArrayList<String>> constructDataRaw(int studyid, String[] columns, String baseColumn, boolean isDistinct) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataMapper mapper = getStudyRawMapper(session);

		StudyRawDataExample example = new StudyRawDataExample();
		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo(baseColumn);

		List<StudyRawData> lstBaseRaw = mapper.selectByExample(example);
		ArrayList<ArrayList<String>> returnVal = new ArrayList<ArrayList<String>>();
		try {
			for (StudyRawData rowData : lstBaseRaw) {
				ArrayList<String> rowConstructed = new ArrayList<String>();
				for (String col : columns) {
					example.clear();
					// System.out.println("StudyID: " + studyid + " DataCol:  "
					// +
					// col + " Row: " + rowData.getDatarow() );
					example.createCriteria().andDatacolumnEqualTo(col).andStudyidEqualTo(studyid).andDatarowEqualTo(rowData.getDatarow());
					List<StudyRawData> subList = mapper.selectByExample(example);
					if (subList.isEmpty())
						rowConstructed.add("");
					else
						rowConstructed.add(subList.get(0).getDatavalue());
				}
				if (isDistinct) {
					if (!returnVal.contains(rowConstructed))
						returnVal.add(rowConstructed);
				} else
					returnVal.add(rowConstructed);

			}
			return returnVal;
		} finally {
			session.close();
		}

	}

	public HashMap<String, ArrayList<String>> constructDataRawAsMap(int studyid, String[] columns, String baseColumn, boolean isDistinct) {

		ArrayList<ArrayList<String>> lstBaseData = constructDataRaw(studyid, columns, baseColumn, isDistinct);
		HashMap<String, ArrayList<String>> returnVal = new HashMap<String, ArrayList<String>>();
		for (ArrayList<String> row : lstBaseData) {
			returnVal.put(row.get(0), row);
		}
		return returnVal;

	}

	public void addStudyRawData(Study study, List<StudyRawData> studyData) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataMapper studyDataMapper = getStudyRawMapper(session);
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try {
			studyMapper.insert(study);
			for (StudyRawData sdata : studyData) {
				sdata.setStudyid(study.getId());
				studyDataMapper.insert(sdata);
			}
			session.commit();

		} finally {
			session.close();
		}

	}

	public void addStudyRawUsingDynaCols(Study study, List<String[]> rawCSVData, int dataset) {
		String[] header = rawCSVData.get(0);
		SqlSession session = connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		StudyRawDataBatch studyRawBatch = session.getMapper(StudyRawDataBatch.class);
		StudyRawDataMapper rawMapper = session.getMapper(StudyRawDataMapper.class);
		try {
			addStudy(study);
			List<StudyRawDataDynCol> lstData = new ArrayList<StudyRawDataDynCol>();

			System.out.println("USING STUDYRAWDYNACOL IN STUDYID: " + study.getId());
			for (int i = 1; i < rawCSVData.size(); i++) {
				String[] row = rawCSVData.get(i);
				StudyRawDataDynCol lstRow = new StudyRawDataDynCol();
				lstRow.setDatarow(i);
				lstRow.setDataset(dataset);
				lstRow.setStudyid(study.getId());
				ArrayList<String> lstDynaCols = new ArrayList<String>();

				for (int j = 0; j < header.length; j++) {

					if (row.length == header.length) {

						lstDynaCols.add(header[j]);
						lstDynaCols.add(row[j]);
					}
					lstRow.setRows(lstDynaCols);
					lstData.add(lstRow);
				}
			}

			// studyRawBatch.insertBatchDynaColRaw(lstData);
			session.commit();

		} finally {
			session.close();
		}

	}

	public void addStudyRawDataByRawCsvList(Study study, List<String[]> rawCSVData, int dataset) {
		String[] header = rawCSVData.get(0);
		SqlSession session = connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		StudyRawDataBatch studyRawBatch = session.getMapper(StudyRawDataBatch.class);
		StudyRawDataMapper rawMapper = session.getMapper(StudyRawDataMapper.class);
		try {
			addStudy(study);
			List<StudyRawData> lstData = new ArrayList<StudyRawData>();

			System.out.println("StudyIDDDDDDDDDDDDDDDDDDDDDDDD: " + study.getId());
			for (int i = 1; i < rawCSVData.size(); i++) {
				String[] row = rawCSVData.get(i);
				for (int j = 0; j < header.length; j++) {

					if (row.length == header.length) {
						StudyRawData record = new StudyRawData();

						record.setDatacolumn(header[j]);
						record.setDatarow(i + 1);
						record.setDatavalue(row[j]);
						record.setStudyid(study.getId());
						record.setDatarow(record.getDatarow() + 1);
						// studyDataMapper.insert(record);
						lstData.add(record);
						// rawMapper.insert(record);
						// System.out.println("Record " + record.toString());

					}
				}
			}
			if (isRaw)
				studyRawBatch.insertBatchRaw(lstData);
			else
				studyRawBatch.insertBatchDerived(lstData);
			session.commit();

		} finally {
			session.close();
		}

	}

	public Integer getLastDataRow(Integer studyid, boolean isRaw) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		try {
			if (isRaw) {

				StudyRawDataMapper mapper = session.getMapper(StudyRawDataMapper.class);
				StudyRawDataExample example = new StudyRawDataExample();
				example.createCriteria().andStudyidEqualTo(studyid);

				if (mapper.countByExample(example) > 0) {

					StudyRawDataBatch mapperCounter = session.getMapper(StudyRawDataBatch.class);
					Map<String, Object> par = new HashMap<String, Object>();
					par.put("studyid", studyid);
					return mapperCounter.getStudyRawLastRow(par);
				} else {
					return 0;
				}
			} else {

				StudyDerivedDataMapper mapper = session.getMapper(StudyDerivedDataMapper.class);
				StudyDerivedDataExample example = new StudyDerivedDataExample();
				example.createCriteria().andStudyidEqualTo(studyid);
				if (mapper.countByExample(example) > 0) {
					return mapper.selectByExample(example).get(mapper.selectByExample(example).size() - 1).getDatarow();
				} else {
					return 0;
				}

			}
		} finally {

		}

	}

	public void addStudyRawData(Study study, List<String> header, List<String[]> rawCSVData, int dataset, boolean isRawData, Integer userid) {

		SqlSession session = connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		StudyRawDataBatch studyRawBatch = session.getMapper(StudyRawDataBatch.class);
		ArrayList<String> lstTemp = new StudyVariableManagerImpl().correctVariableCase(header);
		header.clear();
		header.addAll(lstTemp);

		try {
			addStudy(study);
			Integer lastRow = getLastDataRow(study.getId(), isRawData);

			List<StudyRawData> lstData = new ArrayList<StudyRawData>();
			System.out.println("StudyID______________________: " + study.getId());
			for (int i = 0; i < rawCSVData.size(); i++) {
				String[] row = rawCSVData.get(i);
				for (int j = 0; j < header.size(); j++) {

					if (row.length == header.size()) {
						StudyRawData record = new StudyRawData();

						record.setDatacolumn(header.get(j));
						record.setDatarow((int) (i + 1 + lastRow));
						record.setDatavalue(row[j]);
						record.setStudyid(study.getId());
						record.setDataset(dataset);
						record.setShared(false);
						record.setUserid(userid);
						// studyDataMapper.insert(record);
						lstData.add(record);
					}
				}
			}
			if (isRawData)
				studyRawBatch.insertBatchRaw(lstData);
			else
				studyRawBatch.insertBatchDerived(lstData);

			session.commit();

			new StudyDataColumnManagerImpl().addStudyDataColumn(study.getId(), header.toArray(new String[header.size()]), isRaw, dataset);

		} finally {
			session.close();
		}

	}

	public void addStudyRawDataFromSpreadsheet(Study study, ArrayList<String> header, Sheet sheet, int dataset, boolean isRawData, Integer userid) throws Exception {
		long startTime = System.nanoTime();
		int in = 0;
		SqlSession session = connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		StudyRawDataBatch studyRawBatch = session.getMapper(StudyRawDataBatch.class);

		ArrayList<String> lstTemp = new StudyVariableManagerImpl().correctVariableCase(header);
		System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");

		header.clear();
		header.addAll(lstTemp);

		try {

			addStudy(study);
			System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");

			Integer lastRow = getLastDataRow(study.getId(), isRawData);
			System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");

			List<StudyRawData> lstData = new ArrayList<StudyRawData>();
			System.out.println("StudyID: " + study.getId());
			ExcelHelper excelHelper = new ExcelHelper();

			ArrayList<String[]> arrDump = new ArrayList<String[]>();
			for (Row row : sheet) {
				if (row.getRowNum() > 0) {
					for (Cell cell : row) {

						ArrayList<String> dump = new ArrayList<String>();
						dump.add("");
						dump.add(String.valueOf(study.getId()));
						dump.add(String.valueOf(dataset));
						dump.add(String.valueOf((int) (row.getRowNum() + 1 + lastRow)));
						dump.add(String.valueOf(header.get(cell.getColumnIndex())));
						dump.add(excelHelper.getCellValueToString(cell));
						dump.add("0");
						dump.add(String.valueOf(userid));

						arrDump.add(dump.toArray(new String[dump.size()]));

					}
				}
			}

			File tempCSVFile = File.createTempFile(study.getName() + System.nanoTime(), ".csv");

			try {

				System.out.println(tempCSVFile.getAbsolutePath());
				FileWriter mFileWriter = new FileWriter(tempCSVFile.getAbsolutePath());
				CSVWriter mCsvWriter = new CSVWriter(mFileWriter);
				mCsvWriter.writeAll(arrDump);
				mCsvWriter.flush();
				mCsvWriter.close();

				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/strasa", "root", "root");
				java.sql.Statement stmt = con.createStatement();
				String sql = "LOAD DATA LOCAL INFILE '" + tempCSVFile.getAbsolutePath().replace("\\", "\\\\") + "' INTO TABLE studyrawdata FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n'";

				stmt.execute(sql);

			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
			System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");
			//
			// if (isRawData)
			// studyRawBatch.insertBatchRaw(lstData);
			// else
			// studyRawBatch.insertBatchDerived(lstData);

			session.commit();
			new StudyDataColumnManagerImpl().addStudyDataColumn(study.getId(), header.toArray(new String[header.size()]), isRaw, dataset);
			System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");

		} finally {
			session.close();
		}

	}

	public boolean hasSiteColumnData(int studyid) {

		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataByDataColumnMapper studySiteByStudyMapper = getStudyRawMapperByColumn(session);

		StudyRawDataByDataColumnExample example = new StudyRawDataByDataColumnExample();
		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo("Site");

		return (studySiteByStudyMapper.countByExample(example) > 0);
	}

	public boolean hasLocationColumnData(int studyid) {

		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataByDataColumnMapper studySiteByStudyMapper = getStudyRawMapperByColumn(session);

		StudyRawDataByDataColumnExample example = new StudyRawDataByDataColumnExample();
		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo("Location");

		return (studySiteByStudyMapper.countByExample(example) > 0);
	}

	public List<StudyRawDataByDataColumn> getStudyRawDataColumn(int studyid, String column) {

		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataByDataColumnMapper StudyRawDataByDataColumnMapper = getStudyRawMapperByColumn(session);

		StudyRawDataByDataColumnExample example = new StudyRawDataByDataColumnExample();

		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo(column);
		example.setDistinct(true);
		return StudyRawDataByDataColumnMapper.selectByExample(example);

	}

	public List<StudyRawData> getAllStudyRawData() {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyRawDataMapper studyrawdataMapper = getStudyRawMapper(session);

		try {
			List<StudyRawData> studyrawdata = studyrawdataMapper.selectByExample(null);
			return studyrawdata;
		} finally {
			session.close();
		}
	}

	private StudyRawDataMapper getStudyRawMapper(SqlSession session) {
		if (isRaw)
			return session.getMapper(StudyRawDataMapper.class);
		else
			return (StudyRawDataMapper) session.getMapper(StudyDerivedRawDataMapper.class);
	}

	private StudyRawDataByDataColumnMapper getStudyRawMapperByColumn(SqlSession session) {
		if (isRaw)
			return session.getMapper(StudyRawDataByDataColumnMapper.class);
		else
			return (StudyRawDataByDataColumnMapper) session.getMapper(StudyRawDerivedDataByDataColumnMapper.class);
	}

	private String getStudyRawTable() {
		return (isRaw) ? "studyrawdata" : "studyderiveddata";

	}

	/*
	 * public void setPrivacyByStudyId(Integer studyid, Boolean shared) { //
	 * TODO Auto-generated method stub SqlSession session =
	 * connectionFactory.sqlSessionFactory.openSession(); StudyRawDataMapper
	 * studyDataMapper = getStudyRawMapper(session);
	 * 
	 * try { StudyRawDataExample example = new StudyRawDataExample();
	 * example.createCriteria().andStudyidEqualTo(studyid);
	 * 
	 * List<StudyRawData> studyData = studyDataMapper.selectByExample(example);
	 * for (StudyRawData sdata : studyData) { sdata.setShared(shared);
	 * studyDataMapper.updateByPrimaryKey(sdata); } session.commit();
	 * 
	 * } finally { session.close(); }
	 * 
	 * }
	 */

	public void setPrivacyByStudyId(Integer studyid, Boolean shared) {
		// TODO Auto-generated method stub
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudySharingMapper mapper = session.getMapper(StudySharingMapper.class);

		try {
			mapper.setSharingStudyRawData(studyid, shared);
			mapper.setSharingStudyDerivedData(studyid, shared);
			session.commit();

		} finally {
			session.close();
		}

	}

}
