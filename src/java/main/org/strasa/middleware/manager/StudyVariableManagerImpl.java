package org.strasa.middleware.manager;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyVariableMapper;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.middleware.model.StudyVariableExample;

public class StudyVariableManagerImpl {
	
	
	
	private SqlSession session;
	
	
	private StudyVariableMapper getMapper(){
		return session.getMapper(StudyVariableMapper.class);
	}
	public StudyVariableManagerImpl(){
		ConnectionFactory con = new ConnectionFactory();
		session =con.getSqlSessionFactory().openSession();
	}
	
	public boolean hasVariable(String variable){
		
		try{
			StudyVariableExample query = new StudyVariableExample();
			query.createCriteria().andApplytofilterEqualTo(variable);
			if(getMapper().selectByExample(query).isEmpty()) return false;
			
		}
		finally{
			session.close();
		}
		
		return true;
	}
	
	public StudyVariable getVariableByName(String var){
		try{
		StudyVariableExample query = new StudyVariableExample();
		query.createCriteria().andApplytofilterEqualTo(var);
		return getMapper().selectByExample(query).get(0);
		}
		finally{
			session.close();
		}
		
	}

}
