package org.strasa.middleware.manager;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.mapper.StudySiteByStudyMapper;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyRawData;
import org.strasa.middleware.model.StudySiteByStudy;
import org.strasa.middleware.model.StudySiteByStudyExample;

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
		StudySiteByStudyMapper studySiteByStudyMapper = session.getMapper(StudySiteByStudyMapper.class);
		StudySiteByStudyExample example= new StudySiteByStudyExample();
		example.setDistinct(true);
		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo("Site");
		studySiteByStudyMapper.selectByExample(example);
		
		return false;
	}
	
	public List<StudySiteByStudy> getStudyRawDataSite(int studyid){
		
		SqlSession session =ConnectionFactory.getSqlSessionFactory().openSession();
		StudySiteByStudyMapper studySiteByStudyMapper = session.getMapper(StudySiteByStudyMapper.class);
	
		StudySiteByStudyExample example= new StudySiteByStudyExample();

		example.createCriteria().andStudyidEqualTo(studyid).andDatacolumnEqualTo("Site");
		example.setDistinct(true);
		return studySiteByStudyMapper.selectByExample(example);
		
	}



}
