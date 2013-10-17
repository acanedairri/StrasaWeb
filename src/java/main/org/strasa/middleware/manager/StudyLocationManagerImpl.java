package org.strasa.middleware.manager;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyLocationMapper;
import org.strasa.middleware.model.StudyLocation;

public class StudyLocationManagerImpl {

	public void addStudyLocation(StudyLocation record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyLocationMapper studyLocationMapper = session.getMapper(StudyLocationMapper.class);
		
		try{
			studyLocationMapper.insert(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	
	public void addStudyLocation(ArrayList<StudyLocation> records){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyLocationMapper studyLocationMapper = session.getMapper(StudyLocationMapper.class);
		
		try{
			for(StudyLocation record:records){
				studyLocationMapper.insert(record);
			}
			session.commit();
		}finally{
			session.close();
		}
	}
	
	
	public void updateStudySite(ArrayList<StudyLocation> records){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyLocationMapper studyLocationMapper = session.getMapper(StudyLocationMapper.class);
		
		try{
			for(StudyLocation record:records){
				studyLocationMapper.updateByPrimaryKey(record);
			}
			session.commit();
			
		}finally{
			session.close();
		}
	}
}
