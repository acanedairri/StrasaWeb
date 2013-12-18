package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.ProgramMapper;
import org.strasa.middleware.mapper.StudyDataColumnMapper;
import org.strasa.middleware.mapper.StudyDerivedDataMapper;
import org.strasa.middleware.mapper.StudyFileMapper;
import org.strasa.middleware.mapper.StudyGermplasmMapper;
import org.strasa.middleware.mapper.StudyLocationMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.ProgramExample;
import org.strasa.middleware.model.StudyDataColumnExample;
import org.strasa.middleware.model.StudyDerivedDataExample;
import org.strasa.middleware.model.StudyFileExample;
import org.strasa.middleware.model.StudyGermplasmExample;
import org.strasa.middleware.model.StudyLocationExample;
import org.strasa.middleware.model.StudyRawDataExample;
import org.strasa.middleware.model.StudySiteExample;

public class ProgramManagerImpl {

	public void addProgram(Program record){
		SqlSession session =new ConnectionFactory().getSqlSessionFactory().openSession();
		ProgramMapper ProgramMapper = session.getMapper(ProgramMapper.class);
		
		try{
			ProgramMapper.insert(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	public boolean isProgramExist(String name, int userId){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory().openSession();
		ProgramMapper ProgramMapper = session.getMapper(ProgramMapper.class);
		
		try{
			ProgramExample example= new ProgramExample();
			example.createCriteria().andUseridEqualTo(userId).andNameEqualTo(name);
			
			return (ProgramMapper.countByExample(example) != 0);
		}finally{
			session.close();
		}
	}
	public Program getProgramByName(String name, int userId){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory().openSession();
		ProgramMapper ProgramMapper = session.getMapper(ProgramMapper.class);
		
		try{
			ProgramExample example= new ProgramExample();
			example.createCriteria().andUseridEqualTo(userId).andNameEqualTo(name);
			
			return ProgramMapper.selectByExample(example).get(0);
		}finally{
			session.close();
		}
	}
	
	public void updateProgram(Program record){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory().openSession();
		ProgramMapper ProgramMapper = session.getMapper(ProgramMapper.class);
		
		try{
			ProgramMapper.updateByPrimaryKey(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	public List<Program> getAllProgram(){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory().openSession();
		ProgramMapper ProgramMapper = session.getMapper(ProgramMapper.class);
		
		try{
			return ProgramMapper.selectByExample(null);
		}finally{
			session.close();
		}
	}
	
	public Program getProgramById(int id){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory().openSession();
		ProgramMapper ProgramMapper = session.getMapper(ProgramMapper.class);
		
		try{
			ProgramExample example= new ProgramExample();
			example.createCriteria().andIdEqualTo(id);
			
			return ProgramMapper.selectByExample(example).get(0);
		}finally{
			session.close();
		}
	}
	public List<Program> getProgramByUserId(int id){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory().openSession();
		ProgramMapper ProgramMapper = session.getMapper(ProgramMapper.class);
		
		try{
			ProgramExample example= new ProgramExample();
			example.createCriteria().andUseridEqualTo(id);
			
			return ProgramMapper.selectByExample(example);
		}finally{
			session.close();
		}
	}
	
	public void deleteProgramById(Integer programId) {
		// TODO Auto-generated method stub
		SqlSession session = new ConnectionFactory().sqlSessionFactory.openSession();
		ProgramMapper mapper = session.getMapper(ProgramMapper.class);
		 
		
		try{
			mapper.deleteByPrimaryKey(programId);
			session.commit();
		}
		finally{
			session.close();
		}
	}

}
