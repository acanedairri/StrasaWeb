package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.ProgramMapper;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.ProgramExample;

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

}
