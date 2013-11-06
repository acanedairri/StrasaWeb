package org.strasa.middleware.manager;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.model.Study;

public class StudyManagerImpl {

	
	public Study getStudyById(int studyid){
		SqlSession session = new ConnectionFactory().sqlSessionFactory.openSession();
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		try{
			return mapper.selectByPrimaryKey(studyid);
		}
		finally{
			session.close();
		}
	}
	
}
