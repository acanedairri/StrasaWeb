package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyVariableMapper;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.middleware.model.StudyVariableExample;

public class StudyVariableManagerImpl {
	
	
	
	private SqlSession session;
	
	
	private StudyVariableMapper getMapper(){
		return getSqlSession().getMapper(StudyVariableMapper.class);
	}
	private SqlSession getSqlSession(){
		session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		return session;

	}
	public StudyVariableManagerImpl(){
		 session = new  ConnectionFactory().getSqlSessionFactory().openSession();
	}
	
	public boolean hasVariable(String variable){
		
		try{
			StudyVariableExample query = new StudyVariableExample();
			query.createCriteria().andVariablecodeEqualTo(variable);
			if(getMapper().selectByExample(query).isEmpty()) return false;
			
		}
		finally{
			session.close();
		}
		
		return true;
	}
	
	public List<StudyVariable> getVariables(){
		
		try{
			return getMapper().selectByExample(null);
		}
		finally{
			session.close();
		}
		
	}
	
	public List<StudyVariable> getVariables(String sort){
		
		try{
			StudyVariableExample example = new StudyVariableExample();
			example.createCriteria().andVariablecodeLike("%" + sort + "%");
			return getMapper().selectByExample(example);
		}
		finally{
			session.close();
		}
		
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

	private String buildRelevanceClause(String var){
		return "CASE WHEN variablecode like '" + var +" %' THEN 0  WHEN variablecode like '" + var +"%' THEN 1 WHEN variablecode like '% " + var +"%' THEN 2 ELSE 3  END, variablecode";
	}
}
