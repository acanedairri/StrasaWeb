package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyDerivedRawDataMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataByDataColumnMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.mapper.StudyRawDerivedDataByDataColumnMapper;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudyRawDataByDataColumnExample;
import org.strasa.middleware.model.StudyRawDataExample;

public class StudyRawDataManagerImpl {

	private boolean isRaw = true;
	public StudyRawDataManagerImpl(boolean isRaw){
		this.isRaw = isRaw;
		System.out.println("______________________________________________");
		System.out.println((isRaw) ? "Raw Init" : "Derived Init");
		System.out.println("______________________________________________");
		
	}
	public int addStudy(Study record) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try {
			studyMapper.insert(record);
			session.commit();
		} finally {

		}
		return record.getId();
	}

	public ArrayList<ArrayList<String>> constructDataRaw(int studyid,
			String[] columns, String baseColumn, boolean isDistinct) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataMapper mapper = getStudyRawMapper(session);

		StudyRawDataExample example = new StudyRawDataExample();
		example.createCriteria().andStudyidEqualTo(studyid)
				.andDatacolumnEqualTo(baseColumn);

		List<StudyRawData> lstBaseRaw = mapper
				.selectByExample(example);
		ArrayList<ArrayList<String>> returnVal = new ArrayList<ArrayList<String>>();
		for (StudyRawData rowData : lstBaseRaw) {
			ArrayList<String> rowConstructed = new ArrayList<String>();
			for (String col : columns) {
					example.clear();
//					System.out.println("StudyID: " + studyid + " DataCol:  " + col + " Row: " + rowData.getDatarow() );
					example.createCriteria().andDatacolumnEqualTo(col).andStudyidEqualTo(studyid).andDatarowEqualTo(rowData.getDatarow());
					List<StudyRawData> subList = mapper.selectByExample(example);
					if(subList.isEmpty()) rowConstructed.add("");
					else
					rowConstructed.add(subList.get(0).getDatavalue());
			}
			if(isDistinct){
				if(!returnVal.contains(rowConstructed)) returnVal.add(rowConstructed);
			}
			else returnVal.add(rowConstructed);
			
		}
		return returnVal;

	}
	public HashMap<String,ArrayList<String>> constructDataRawAsMap(int studyid,
			String[] columns, String baseColumn, boolean isDistinct) {
		

			ArrayList<ArrayList<String>>lstBaseData = constructDataRaw(studyid, columns, baseColumn, isDistinct);
			HashMap<String,ArrayList<String>> returnVal = new HashMap<String,ArrayList<String>> ();
			for(ArrayList<String> row : lstBaseData){
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
			List<String[]> rawCSVData) {
		String[] header = rawCSVData.get(0);
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataMapper studyDataMapper = getStudyRawMapper(session);
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try {
			studyMapper.insert(study);
			for (int i = 1; i < rawCSVData.size(); i++) {
				String[] row = rawCSVData.get(i);
				for (int j = 0; j < header.length; j++) {

					if (row.length == header.length) {
						StudyRawData record = new StudyRawData();

						record.setDatacolumn(header[j]);
						record.setDatarow(i);
						record.setDatavalue(row[j]);
						record.setStudyid(study.getId());
						studyDataMapper.insert(record);
					}
				}
			}
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
		example.setDistinct(true);
		example.createCriteria().andStudyidEqualTo(studyid)
				.andDatacolumnEqualTo("Site");
		studySiteByStudyMapper.selectByExample(example);

		return false;
	}

	public boolean hasLocationColumnData(int studyid) {

		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataByDataColumnMapper studySiteByStudyMapper = getStudyRawMapperByColumn(session);
		StudyRawDataByDataColumnExample example = new StudyRawDataByDataColumnExample();
		example.setDistinct(true);
		example.createCriteria().andStudyidEqualTo(studyid)
				.andDatacolumnEqualTo("Location");
		studySiteByStudyMapper.selectByExample(example);

		return false;
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
	
	private StudyRawDataMapper getStudyRawMapper(SqlSession session){
		if(isRaw) return  session
				.getMapper(StudyRawDataMapper.class);
		else return (StudyRawDataMapper)session
		.getMapper(StudyDerivedRawDataMapper.class);
	}
	private StudyRawDataByDataColumnMapper getStudyRawMapperByColumn(SqlSession session){
		if(isRaw) return  session
				.getMapper(StudyRawDataByDataColumnMapper.class);
		else return (StudyRawDataByDataColumnMapper)session
		.getMapper(StudyRawDerivedDataByDataColumnMapper.class);
	}
	
	
}
