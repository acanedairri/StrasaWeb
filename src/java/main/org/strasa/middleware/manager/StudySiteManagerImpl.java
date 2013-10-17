package org.strasa.middleware.manager;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.StudySite;

public class StudySiteManagerImpl {

	public void addStudySite(StudySite record){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);
		
		try{
			studySiteMapper.insert(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	
	public void addStudySite(ArrayList<StudySite> records){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);
		
		try{
			for(StudySite record:records){
				studySiteMapper.insert(record);
			}
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	
	public void updateStudySite(ArrayList<StudySite> records){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);
		
		try{
			for(StudySite record:records){
				studySiteMapper.updateByPrimaryKey(record);
			}
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	


}
