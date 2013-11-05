package org.strasa.middleware.manager;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.mapper.StudyTypeMapper;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmExample;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudySite;
import org.strasa.middleware.model.StudyType;
import org.strasa.middleware.model.StudyTypeExample;

public class GermplasmQueryManagerImpl {

	
	public Germplasm getGermplasmByName(String value){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);
		
		try{
			GermplasmExample example = new GermplasmExample();
			example.createCriteria().andGermplasmnameEqualTo(value);
			if(mapper.selectByExample(example).isEmpty()) return null;
			return mapper.selectByExample(example).get(0);
			
		}
		finally{
				session.close();
		}
	}
	
	public boolean isGermplasmExisting(String value){
		if(this.getGermplasmByName(value) == null) return false;
		return true;
	}
	

	public int addGermplasm(Germplasm record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);
		try{
			mapper.insert(record);
			session.commit();
		}
		finally{
			session.close();
		}
		return record.getId();
	}

	public List<StudySite> getAllStudySites(int studyId) {
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
