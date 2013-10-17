package org.strasa.middleware.manager;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataByDataColumnMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudyRawDataByDataColumnExample;

public class StudyRawDataManagerImpl {


	public int addStudy(Study record){
		SqlSession session =ConnectionFactory.getSqlSessionFactory().openSession();
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(record);
			session.commit();
		}
		finally{
			
		}
		return record.getId();
	}


	public void addStudyRawData(Study study, List<StudyRawData> studyData){
		SqlSession session =ConnectionFactory.getSqlSessionFactory().openSession();
		StudyRawDataMapper studyDataMapper = session.getMapper(StudyRawDataMapper.class);
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(study);
			for(StudyRawData sdata:studyData){
				sdata.setStudyid(study.getId());
				studyDataMapper.insert(sdata);
			}
			session.commit();

		}finally{
			session.close();
		}

	}
	
	public boolean hasSiteColumnData(int studyid){
		
		SqlSession session =ConnectionFactory.getSqlSessionFactory().openSession();
		StudyRawDataByDataColumnMapper studySiteByStudyMapper = session.getMapper(StudyRawDataByDataColumnMapper.class);
		StudyRawDataByDataColumnExample example= new StudyRawDataByDataColumnExample();
		example.setDistinct(true);
		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo("Site");
		studySiteByStudyMapper.selectByExample(example);
		
		return false;
	}
	
	public List<StudyRawDataByDataColumn> getStudyRawDataSite(int studyid,String column){
		
		SqlSession session =ConnectionFactory.getSqlSessionFactory().openSession();
		StudyRawDataByDataColumnMapper studyRawDataUniqueStudyMapper = session.getMapper(StudyRawDataByDataColumnMapper.class);
	
		StudyRawDataByDataColumnExample example= new StudyRawDataByDataColumnExample();

		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo(column);
		example.setDistinct(true);
		return studyRawDataUniqueStudyMapper.selectByExample(example);
		
	}



}
