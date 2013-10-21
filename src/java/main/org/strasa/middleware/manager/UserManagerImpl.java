package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.UserMapper;
import org.strasa.middleware.model.User;
import org.strasa.middleware.model.UserExample;

public class UserManagerImpl {

	public void addUser(User record){
		 
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try{
			userMapper.insert(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	public void updateUser(User record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try{
	
			userMapper.updateByPrimaryKey(record);
			session.commit();
		}finally{
			session.close();
		}
		
	}
	
	
	public void deleteUser(User record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try{
			userMapper.deleteByPrimaryKey(record.getId());
			session.commit();
		}finally{
			session.close();
		}
		
	}
	
	public List<User> getUser(String username, String password){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try{
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
			return  userMapper.selectByExample(example);
			
		}finally{
			session.close();
		}
		
	}
	public User getUserById(int userID){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try{
			return  userMapper.selectByPrimaryKey(userID);
			
		}finally{
			session.close();
		}
		
	}

	public List<User> getAllRegisteredUser() {
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try{
			UserExample example = new UserExample();
			example.setOrderByClause("status");
			return  userMapper.selectByExample(example);
			
		}finally{
			session.close();
		}
		
	}
	

}
