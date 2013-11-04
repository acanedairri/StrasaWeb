package org.strasa.middleware.manager;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyDerivedDataMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataByDataColumnMapper;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyDerivedData;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudyRawDataByDataColumnExample;

public class StudyDerivedDataManagerImpl {


	public int addStudy(Study record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(record);
			session.commit();
		}
		finally{
			
		}
		return record.getId();
	}


	public void addStudyDerivedData(Study study, List<StudyDerivedData> studyData){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyDerivedDataMapper studyDataMapper = session.getMapper(StudyDerivedDataMapper.class);
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(study);
			for(StudyDerivedData sdata:studyData){
				sdata.setStudyid(study.getId());
				studyDataMapper.insert(sdata);
			}
			session.commit();

		}finally{
			session.close();
		}

	}
	public void addStudyDerivedDataByRawCsvList(Study study, List<String[]> rawCSVData){
		String[] header = rawCSVData.get(0);
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyDerivedDataMapper studyDataMapper = session.getMapper(StudyDerivedDataMapper.class);
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(study);
			for(int i = 1; i < rawCSVData.size(); i++){
				String[] row = rawCSVData.get(i);
				for(int j = 0; j < header.length; j++){
					
					if(row.length == header.length){
						StudyDerivedData record = new StudyDerivedData();
					
					record.setDatacolumn(header[j]);
					record.setDatarow(i);
					record.setDatavalue(row[j]);
					record.setStudyid(study.getId());
					studyDataMapper.insert(record);
					}
				}
			}
			session.commit();

		}finally{
			session.close();
		}
		
	}
	
	public boolean hasSiteColumnData(int studyid){
		
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyRawDataByDataColumnMapper studySiteByStudyMapper = session.getMapper(StudyRawDataByDataColumnMapper.class);
		StudyRawDataByDataColumnExample example= new StudyRawDataByDataColumnExample();
		example.setDistinct(true);
		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo("Site");
		studySiteByStudyMapper.selectByExample(example);
		
		return false;
	}
	
	
	public boolean hasLocationColumnData(int studyid){
		
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyRawDataByDataColumnMapper studySiteByStudyMapper = session.getMapper(StudyRawDataByDataColumnMapper.class);
		StudyRawDataByDataColumnExample example= new StudyRawDataByDataColumnExample();
		example.setDistinct(true);
		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo("Location");
		studySiteByStudyMapper.selectByExample(example);
		
		return false;
	}
	
	public List<StudyRawDataByDataColumn> getStudyRawDataColumn(int studyid,String column){
		
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyRawDataByDataColumnMapper StudyRawDataByDataColumnMapper = session.getMapper(StudyRawDataByDataColumnMapper.class);
	
		StudyRawDataByDataColumnExample example= new StudyRawDataByDataColumnExample();

		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo(column);
		example.setDistinct(true);
		return StudyRawDataByDataColumnMapper.selectByExample(example);
		
	}


	public List<StudyDerivedData> getAllStudyRawData() {
		SqlSession session =new ConnectionFactory().getSqlSessionFactory().openSession();
		StudyDerivedDataMapper StudyDerivedDataMapper = session.getMapper(StudyDerivedDataMapper.class);
		
		try{
			List<StudyDerivedData> studyrawdata = StudyDerivedDataMapper.selectByExample(null);
			return studyrawdata;
		}finally{
			session.close();
		}
	}
}
