package org.strasa.middleware.manager;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyGermplasmMapper;
import org.strasa.middleware.model.StudyGermplasm;
import org.strasa.middleware.model.StudyGermplasmExample;

public class StudyGermplasmManagerImpl {

	
	public StudyGermplasm getStudyGermplasmByName(String value){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyGermplasmMapper mapper = session.getMapper(StudyGermplasmMapper.class);
		
		try{
			StudyGermplasmExample example = new StudyGermplasmExample();
			example.createCriteria().andGermplasmnameEqualTo(value);
			return mapper.selectByExample(example).get(0);
			
		}
		finally{
				session.close();
		}
	}
	
	public boolean isStudyGermplasmExisting(String value){
		if(this.getStudyGermplasmByName(value) == null) return false;
		return true;
	}
	

	public int addStudyGermplasm(StudyGermplasm record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyGermplasmMapper mapper = session.getMapper(StudyGermplasmMapper.class);
		try{
			mapper.insert(record);
			session.commit();
		}
		finally{
			session.close();
		}
		return record.getId();
	}

		
}
