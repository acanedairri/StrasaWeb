package org.strasa.middleware.manager;

import java.util.Date;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.UserValidationMapper;
import org.strasa.middleware.model.DbUser;
import org.strasa.middleware.model.UserValidation;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class UserValidationManager {
	@WireVariable
	ConnectionFactory connectionFactory;

	public String addValidation(DbUser user) {

		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		UserValidationMapper userValidationMapper = session.getMapper(UserValidationMapper.class);

		try {
			UserValidation userVal = new UserValidation();
			userVal.setDateCreated(new Date());
			String validationCode = new Random().nextInt() + "" + new Random().nextInt();
			userVal.setConfirmationcode(validationCode);
			userVal.setUserid(user.getId());
			userValidationMapper.insert(userVal);

			session.commit();
			return validationCode;
		} finally {
			session.close();
		}

	}
}
