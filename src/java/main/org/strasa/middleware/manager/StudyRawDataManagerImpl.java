package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyDerivedDataMapper;
import org.strasa.middleware.mapper.StudyDerivedRawDataMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataByDataColumnMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.mapper.StudyRawDerivedDataByDataColumnMapper;
import org.strasa.middleware.mapper.other.StudyRawDataBatch;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyDerivedDataExample;
import org.strasa.middleware.model.StudyGermplasm;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudyRawDataByDataColumnExample;
import org.strasa.middleware.model.StudyRawDataExample;
import org.strasa.middleware.model.StudySite;

public class StudyRawDataManagerImpl {

	private boolean isRaw = true;

	public StudyRawDataManagerImpl(boolean isRaw) {
		this.isRaw = isRaw;
		System.out.println("______________________________________________");
		System.out.println((isRaw) ? "Raw Init" : "Derived Init");
		System.out.println("______________________________________________");

	}

	public void deleteByStudyId(int studyID) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		try {
			if (isRaw) {
				StudyRawDataMapper studyMapper = session
						.getMapper(StudyRawDataMapper.class);

				StudyRawDataExample example = new StudyRawDataExample();
				example.createCriteria().andStudyidEqualTo(studyID);
				studyMapper.deleteByExample(example);
			} else {
				StudyDerivedDataMapper studyMapper = session
						.getMapper(StudyDerivedDataMapper.class);

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
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
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
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		List<Location> lstData = mapper.getRawLocation(studyid,
				getStudyRawTable(), dataset);
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

	public List<StudySite> getStudySiteInfo(int studyid, int dataset) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		List<StudySite> lstData = mapper
				.getRawSite(studyid, getStudyRawTable(), dataset);
		return lstData;
	}

	public List<StudyGermplasm> getStudyGermplasmInfo(int studyid, int dataset) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		List<StudyGermplasm> lstData = mapper.getRawGermplasm(studyid,
				getStudyRawTable(),  dataset);
		return lstData;
	}

	public HashMap<String, StudySite> getStudySiteInfoToMap(int studyid, int dataset) {
		List<StudySite> lstRaw = getStudySiteInfo(studyid, dataset);
		HashMap<String, StudySite> returnVal = new HashMap<String, StudySite>();
		for (StudySite data : lstRaw) {
			returnVal.put(data.getSitename(), data);
		}
		return returnVal;
	}

	public HashMap<String, StudyGermplasm> getStudyGermplasmInfoToMap(
			int studyid, int dataset) {
		List<StudyGermplasm> lstRaw = getStudyGermplasmInfo(studyid, dataset);
		HashMap<String, StudyGermplasm> returnVal = new HashMap<String, StudyGermplasm>();
		for (StudyGermplasm data : lstRaw) {
			returnVal.put(data.getGermplasmname(), data);
		}
		return returnVal;
	}

	public ArrayList<ArrayList<String>> constructDataRaw(int studyid,
			String[] columns, String baseColumn, boolean isDistinct) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataMapper mapper = getStudyRawMapper(session);

		StudyRawDataExample example = new StudyRawDataExample();
		example.createCriteria().andStudyidEqualTo(studyid)
				.andDatacolumnEqualTo(baseColumn);

		List<StudyRawData> lstBaseRaw = mapper.selectByExample(example);
		ArrayList<ArrayList<String>> returnVal = new ArrayList<ArrayList<String>>();
		for (StudyRawData rowData : lstBaseRaw) {
			ArrayList<String> rowConstructed = new ArrayList<String>();
			for (String col : columns) {
				example.clear();
				// System.out.println("StudyID: " + studyid + " DataCol:  " +
				// col + " Row: " + rowData.getDatarow() );
				example.createCriteria().andDatacolumnEqualTo(col)
						.andStudyidEqualTo(studyid)
						.andDatarowEqualTo(rowData.getDatarow());
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

	}

	public HashMap<String, ArrayList<String>> constructDataRawAsMap(
			int studyid, String[] columns, String baseColumn, boolean isDistinct) {

		ArrayList<ArrayList<String>> lstBaseData = constructDataRaw(studyid,
				columns, baseColumn, isDistinct);
		HashMap<String, ArrayList<String>> returnVal = new HashMap<String, ArrayList<String>>();
		for (ArrayList<String> row : lstBaseData) {
			returnVal.put(row.get(0), row);
		}
		return returnVal;

	}

	public void addStudyRawData(Study study, List<StudyRawData> studyData) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
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

	public void addStudyRawDataByRawCsvList(Study study,
			List<String[]> rawCSVData,int dataset) {
		String[] header = rawCSVData.get(0);
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		StudyRawDataBatch studyRawBatch = session
				.getMapper(StudyRawDataBatch.class);
		StudyRawDataMapper rawMapper = session
				.getMapper(StudyRawDataMapper.class);
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

	public void addStudyRawData(Study study, String[] header,
			List<String[]> rawCSVData, int dataset, boolean isRawData) {

		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		StudyRawDataBatch studyRawBatch = session
				.getMapper(StudyRawDataBatch.class);
		try {
			addStudy(study);
			List<StudyRawData> lstData = new ArrayList<StudyRawData>();
			System.out.println("StudyID______________________: " + study.getId());
			for (int i = 0; i < rawCSVData.size(); i++) {
				String[] row = rawCSVData.get(i);
				for (int j = 0; j < header.length; j++) {

					if (row.length == header.length) {
						StudyRawData record = new StudyRawData();

						record.setDatacolumn(header[j]);
						record.setDatarow(i + 1);
						record.setDatavalue(row[j]);
						record.setStudyid(study.getId());
						record.setDataset(dataset);
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

		} finally {
			session.close();
		}

	}

	public boolean hasSiteColumnData(int studyid) {

		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataByDataColumnMapper studySiteByStudyMapper = getStudyRawMapperByColumn(session);

		StudyRawDataByDataColumnExample example = new StudyRawDataByDataColumnExample();
		example.createCriteria().andStudyidEqualTo(studyid)
				.andDatacolumnEqualTo("Site");

		return (studySiteByStudyMapper.countByExample(example) > 0);
	}

	public boolean hasLocationColumnData(int studyid) {

		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataByDataColumnMapper studySiteByStudyMapper = getStudyRawMapperByColumn(session);

		StudyRawDataByDataColumnExample example = new StudyRawDataByDataColumnExample();
		example.createCriteria().andStudyidEqualTo(studyid)
				.andDatacolumnEqualTo("Location");

		return (studySiteByStudyMapper.countByExample(example) > 0);
	}

	public List<StudyRawDataByDataColumn> getStudyRawDataColumn(int studyid,
			String column) {

		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataByDataColumnMapper StudyRawDataByDataColumnMapper = getStudyRawMapperByColumn(session);

		StudyRawDataByDataColumnExample example = new StudyRawDataByDataColumnExample();

		example.createCriteria().andStudyidEqualTo(studyid)
				.andDatacolumnEqualTo(column);
		example.setDistinct(true);
		return StudyRawDataByDataColumnMapper.selectByExample(example);

	}

	public List<StudyRawData> getAllStudyRawData() {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataMapper studyrawdataMapper = getStudyRawMapper(session);

		try {
			List<StudyRawData> studyrawdata = studyrawdataMapper
					.selectByExample(null);
			return studyrawdata;
		} finally {
			session.close();
		}
	}

	private StudyRawDataMapper getStudyRawMapper(SqlSession session) {
		if (isRaw)
			return session.getMapper(StudyRawDataMapper.class);
		else
			return (StudyRawDataMapper) session
					.getMapper(StudyDerivedRawDataMapper.class);
	}

	private StudyRawDataByDataColumnMapper getStudyRawMapperByColumn(
			SqlSession session) {
		if (isRaw)
			return session.getMapper(StudyRawDataByDataColumnMapper.class);
		else
			return (StudyRawDataByDataColumnMapper) session
					.getMapper(StudyRawDerivedDataByDataColumnMapper.class);
	}

	private String getStudyRawTable() {
		return (isRaw) ? "studyrawdata" : "studyderiveddata";

	}

}
