package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.ProjectMapper;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.middleware.model.ProjectExample;

public class ProjectManagerImpl {

	public void addProject(Project record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		
		try{
			projectMapper.insert(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	
	public ArrayList<Project> getProjectList(int userID, Program selected){
	
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		try{
			ProjectExample example = new ProjectExample();
			example.createCriteria().andUseridEqualTo(userID).andProgramidEqualTo(selected.getId());
			return new ArrayList<Project>(projectMapper.selectByExample(example));
		}finally{
			session.close();
		}
		
		
	}
	
	public void updateProject(Project record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		
		try{
			projectMapper.updateByPrimaryKey(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	public List<Project> getAllProject(){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		
		try{
			return projectMapper.selectByExample(null);
		}finally{
			session.close();
		}
	}
	
	public Project getProjectById(int id){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		
		try{
			ProjectExample example= new ProjectExample();
			example.createCriteria().andIdEqualTo(id);
			
			return projectMapper.selectByExample(example).get(0);
		}finally{
			session.close();
		}
	}
	
	public List<Project> getProjectByUserId(int id){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		
		try{
			ProjectExample example= new ProjectExample();
			example.createCriteria().andUseridEqualTo(id);
			
			return projectMapper.selectByExample(example);
		}finally{
			session.close();
		}
	}
	public Project getProjectByName(String name,int id){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		
		try{
			ProjectExample example= new ProjectExample();
			example.createCriteria().andUseridEqualTo(id).andNameEqualTo(name);
			
			return projectMapper.selectByExample(example).get(0);
		}finally{
			session.close();
		}
	}
	
	public boolean isProjectExist(String name,int userID, int programID){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		
		try{
			ProjectExample example= new ProjectExample();
			example.createCriteria().andUseridEqualTo(userID).andProgramidEqualTo(programID).andNameEqualTo(name);
			
			return (projectMapper.countByExample(example) != 0 );
		}finally{
			session.close();
		}
	}


	public List<Project>  getProjectByProgramId(Integer programId) {
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
		
		try{
			ProjectExample example= new ProjectExample();
			example.createCriteria().andProgramidEqualTo(programId);
			
			return projectMapper.selectByExample(example);
		}finally{
			session.close();
		}
	}


}
