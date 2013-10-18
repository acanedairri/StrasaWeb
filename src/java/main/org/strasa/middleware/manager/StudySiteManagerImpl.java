package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.StudySite;

public class StudySiteManagerImpl {

	public void addStudySite(StudySite record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);

		try{
			studySiteMapper.insert(record);
			session.commit();

		}finally{
			session.close();
		}

	}


	public void addStudySite(ArrayList<StudySite> records){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
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
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
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


	public List<StudySite> getAllStudySites() {
		// TODO Auto-generated method stub
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);

		try{
			List<StudySite> studySites = studySiteMapper.selectByExample(null);
			return studySites;

		}finally{
			session.close();
		}

	}




}
