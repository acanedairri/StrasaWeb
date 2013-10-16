package org.strasa.middleware.manager;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.UserMapper;
import org.strasa.middleware.model.User;

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

}
