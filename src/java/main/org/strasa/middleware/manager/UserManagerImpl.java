package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.UserMapper;
import org.strasa.middleware.model.User;
import org.strasa.middleware.model.UserExample;

public class UserManagerImpl {

	public void addUser(User record){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try{
			userMapper.insert(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
	
	public List<User> getUser(String username, String password){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try{
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
			return  userMapper.selectByExample(example);
			
		}finally{
			session.close();
		}
		
	}

}
